package com.example.user.e_finance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class interest2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest2);
    }

    public void backmain(View v){
        Intent intentGetMessage = new Intent(this, MainActivity.class);

        startActivityForResult(intentGetMessage,2);
    }
}
