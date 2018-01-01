package com.example.user.e_finance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.HashMap;

public class ManageProfile extends AppCompatActivity {

    int i =0;
    UserDataSource helper = new UserDataSource(this);
    UserSessionManager session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_profile);

        session = new UserSessionManager(getApplicationContext());

        HashMap<String, String> user = session.getUserDetails();

        if(session.checkLogin())
            finish();

        TextView tfUser = (TextView) findViewById(R.id.tfUser);
        TextView tfemail = (TextView) findViewById(R.id.editTextEmail);
        TextView tfAddress = (TextView) findViewById(R.id.editTextHome);
        TextView tfContact = (TextView) findViewById(R.id.editTextContact);
        // get name
        String name = user.get(UserSessionManager.KEY_NAME);
        tfUser.setText(name);
        String email = "";
        email = helper.seachEmail(name);
        tfemail.setText(email);
        tfemail.setEnabled(false);
        String Address = "";
        Address = helper.seachAddress(name);
        tfAddress.setText(Address);
        tfAddress.setEnabled(false);
        String contact = "";
        contact = helper.searchContact(name);
        tfContact.setText(contact);
        tfContact.setEnabled(false);

    }

    public void EnableProfile(View v){
        i++;
        HashMap<String, String> user = session.getUserDetails();
        String name = user.get(UserSessionManager.KEY_NAME);
        TextView tfemail = (TextView) findViewById(R.id.editTextEmail);
        TextView tfAddress = (TextView) findViewById(R.id.editTextHome);
        TextView tfContact = (TextView) findViewById(R.id.editTextContact);
        if(i%2==1){
            tfemail.setEnabled(true);
            tfAddress.setEnabled(true);
            tfContact.setEnabled(true);


        }else{
            tfemail.setEnabled(false);
            tfAddress.setEnabled(false);
            tfContact.setEnabled(false);

            UserRecord userRecord = new UserRecord();
            userRecord.setEmail(tfemail.getText().toString());
            userRecord.setUsername(name);
            userRecord.setContactno(tfContact.getText().toString());
            userRecord.setAddress(tfAddress.getText().toString());

            UserDataSource userDataSource = new UserDataSource(this);
            userDataSource.updateUser(userRecord);


        }


    }





}
