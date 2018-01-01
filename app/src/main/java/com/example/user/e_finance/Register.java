package com.example.user.e_finance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_register);
    }

    public void saveRecord(View v) {
        boolean insert=  false;
        EditText editTextName, editTextEmail,editTextUserName,editTextPassword,editTextContact,editTextAddress,editTextRePassword;
        editTextName = (EditText) findViewById(R.id.tfName);
        editTextEmail = (EditText) findViewById(R.id.tfEmail);
        editTextUserName = (EditText) findViewById(R.id.tfUsername);
        editTextPassword = (EditText) findViewById(R.id.tfPassword);
        editTextRePassword = (EditText) findViewById(R.id.tfRePassword);
        editTextContact = (EditText) findViewById(R.id.tfMobile);
        editTextAddress = (EditText) findViewById(R.id.tfAddress);

        UserRecord userRecord = new UserRecord();
        userRecord.setName(editTextName.getText().toString());
        userRecord.setEmail(editTextEmail.getText().toString());
        userRecord.setUsername(editTextUserName.getText().toString());
        userRecord.setPassword(editTextPassword.getText().toString());
        userRecord.setContactno(editTextContact.getText().toString());
        userRecord.setAddress(editTextAddress.getText().toString());

        if(editTextName.getText().toString().equals("")){

            Toast temp = Toast.makeText(Register.this, "Name is empty!", Toast.LENGTH_SHORT);

            temp.show();
        }else if(editTextEmail.getText().toString().equals("")){
            Toast temp = Toast.makeText(Register.this, "Email is empty!", Toast.LENGTH_SHORT);

            temp.show();

        }else if(editTextUserName.getText().toString().equals("")){
            Toast temp = Toast.makeText(Register.this, "Username is empty!", Toast.LENGTH_SHORT);

            temp.show();

        }else if(editTextContact.getText().toString().equals("")){
            Toast temp = Toast.makeText(Register.this, "Contact number is empty!", Toast.LENGTH_SHORT);

            temp.show();

        }else if(editTextAddress.getText().toString().equals("")){
            Toast temp = Toast.makeText(Register.this, "Address is empty!", Toast.LENGTH_SHORT);

            temp.show();

        }else if(editTextPassword.getText().toString().equals("")){
            Toast temp = Toast.makeText(Register.this, "Password is empty!", Toast.LENGTH_SHORT);

            temp.show();

        }else if(editTextRePassword.getText().toString().equals("")){
            Toast temp = Toast.makeText(Register.this, "You need to key in password again is empty!", Toast.LENGTH_SHORT);

            temp.show();

        }else
            insert = true;
        if(editTextRePassword.getText().toString().equals(editTextPassword.getText().toString())&&!editTextRePassword.getText().toString().equals("")){
            UserDataSource userDataSource = new UserDataSource(this);
            userDataSource.insertUser(userRecord);

            Intent intentGetMessage = new Intent(this, LogIn.class);
            startActivity(intentGetMessage);
            this.finish();
        }else if(!editTextRePassword.getText().toString().equals(editTextPassword.getText().toString())){

            Toast temp = Toast.makeText(Register.this, "Password Does not match !", Toast.LENGTH_SHORT);

            temp.show();
        }


   //Terminate	this	Activity					}

    }

    public void RegisterClick(View v) {
        Intent intentGetMessage = new Intent(this, LogIn.class);
        startActivity(intentGetMessage);
        finish();
    }




}
