package com.example.user.e_finance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {

    UserSessionManager session;

    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    UserDataSource helper = new UserDataSource(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        session = new UserSessionManager(this);

        Toast.makeText(getApplicationContext(),
                "User Login Status: " + session.isUserLoggedIn(),
                Toast.LENGTH_LONG).show();
        //if(session.loggedin()){
        //    startActivity(new Intent(LogIn.this,MainActivity.class));
         //   finish();
        //}
    }

    /*public boolean onCreateOptionMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);

        return true;
    }*/
    public void SignUpClick(View v) {
        Intent intentGetMessage = new Intent(this, Register.class);

        startActivity(intentGetMessage);
    }

    public void onLogInClick(View v) {


        EditText uname = (EditText) findViewById(R.id.LoginUsername);
        String str = uname.getText().toString();

        EditText password = (EditText) findViewById(R.id.LoginPassword);
        String pass = password.getText().toString();

        String searchPassword = helper.searchPass(str);

        if (pass.equals(searchPassword)) {
            //session.setLoggedin(true);

            session.createUserLoginSession(str,pass);
            Intent intentGetMessage = new Intent(this, MainActivity.class);
            intentGetMessage.putExtra(EXTRA_MESSAGE,str);
            startActivity(intentGetMessage);
            finish();


        } else {

            Toast temp = Toast.makeText(LogIn.this, "Username and Password Does not match !" + searchPassword, Toast.LENGTH_SHORT);

            temp.show();
        }


    }

}
