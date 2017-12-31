package com.example.user.e_finance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {

    UserDataSource helper = new UserDataSource(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
    }

    /*public boolean onCreateOptionMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);

        return true;
    }*/

    public void onLogInClick(View v){


            EditText uname= (EditText)findViewById(R.id.tfUsername);
            String str  = uname.getText().toString();

            EditText password = (EditText)findViewById(R.id.tfPassword);
            String pass = password.getText().toString();

            String searchPassword = helper.searchPass(str);

            if(pass.equals(searchPassword)){
                Intent intentGetMessage = new Intent(this, MainActivity.class);

                startActivityForResult(intentGetMessage,2);

            }else{

                Toast temp = Toast.makeText(LogIn.this, "Username and Password Does not match !"+searchPassword,Toast.LENGTH_SHORT);

                temp.show();
            }


    }

}
