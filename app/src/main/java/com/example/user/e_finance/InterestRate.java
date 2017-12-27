package com.example.user.e_finance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class InterestRate extends AppCompatActivity {

    EditText editTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest_rate);
/*
        editTextMessage = (EditText)findViewById(R.id.editTextMessage);*/
    }

    public void backmain(View v){
        Intent intentGetMessage = new Intent(this, MainActivity.class);

        startActivityForResult(intentGetMessage,2);
    }

    public void gonext(View v){
        Intent intentGetMessage = new Intent(this, interest2.class);

        startActivityForResult(intentGetMessage,2);
    }

    public void submitMessage(View V){
        String message = editTextMessage.getText().toString();
        Intent intentMessage = new Intent();

        intentMessage.putExtra("MESSAGE",message);
        setResult(2,intentMessage);
        finish();
    }
}
