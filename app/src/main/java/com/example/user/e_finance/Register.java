package com.example.user.e_finance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void saveRecord(View v) {
        EditText editTextName, editTextEmail,editTextUserName,editTextPassword;
        editTextName = (EditText) findViewById(R.id.tfName);
        editTextEmail = (EditText) findViewById(R.id.tfEmail);
        editTextUserName = (EditText) findViewById(R.id.tfUsername);
        editTextPassword = (EditText) findViewById(R.id.tfPassword);


        UserRecord userRecord = new UserRecord();
        userRecord.setName(editTextName.getText().toString());
        userRecord.setEmail(editTextEmail.getText().toString());
        userRecord.setUsername(editTextUserName.getText().toString());
        userRecord.setPassword(editTextPassword.getText().toString());

        UserDataSource userDataSource = new UserDataSource(this);
        userDataSource.insertUser(userRecord);

        this.finish();    //Terminate	this	Activity					}

    }




}
