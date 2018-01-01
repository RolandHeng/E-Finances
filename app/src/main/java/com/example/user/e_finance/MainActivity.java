package com.example.user.e_finance;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.SubMenu;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    UserDataSource helper = new UserDataSource(this);
    UserSessionManager session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        session = new UserSessionManager(getApplicationContext());



        Toast.makeText(getApplicationContext(),
                "User Login Status: " + session.isUserLoggedIn(),
                Toast.LENGTH_LONG).show();

        if(session.checkLogin())
            finish();
        //session = new Session(this);
        //if(!session.loggedin()){
        //    logout();
       // }

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        HashMap<String, String> user = session.getUserDetails();

        // get name
        String name = user.get(UserSessionManager.KEY_NAME);

        // get email




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
        this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        //updateList();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);
        Menu menu = navigationView.getMenu();

        TextView tfun = (TextView) header.findViewById(R.id.navUsername);
        TextView tfemail = (TextView) header.findViewById(R.id.navEmail);
        MenuItem nav_camara = menu.findItem(R.id.nav_camera);
        MenuItem nav_gallery = menu.findItem(R.id.nav_gallery);
        MenuItem nav_slideshow = menu.findItem(R.id.nav_slideshow);
        MenuItem nav_manage = menu.findItem(R.id.nav_manage);
        MenuItem nav_share = menu.findItem(R.id.nav_share);
        MenuItem nav_send = menu.findItem(R.id.nav_send);
        nav_share.setVisible(false);
        nav_send.setVisible(false);
        nav_camara.setVisible(true);
        nav_camara.setIcon(null);
        nav_gallery.setIcon(null);
        nav_slideshow.setIcon(null);
        nav_manage.setIcon(null);
        nav_camara.setTitle("Monly Cost");
        nav_gallery.setTitle("Risk and Return");
        nav_slideshow.setTitle("Calculate Debt");
        nav_manage.setTitle("Calculate Interest Rate");
        MenuItem title = menu.add("Time Value of Money");


        tfun.setText(name);
        String email = "";
        email = helper.seachEmail(name);
        tfemail.setText(email);


    }

/*    public void logout(){

        session.setLoggedin(false);
        finish();
        startActivity(new Intent(MainActivity.this,LogIn.class));
    }*/


    public void getMessage(View v) {
        Intent intentGetMessage = new Intent(this, InterestRate.class);

        startActivityForResult(intentGetMessage, 2);
    }

    public void gocost(View v) {
        Intent intentGetMessage = new Intent(this, monthlyCostCal.class);

        startActivityForResult(intentGetMessage, 2);
    }


    public void godebt(View v) {
        Intent intentGetMessage = new Intent(this, debtCal.class);

        startActivityForResult(intentGetMessage, 2);
    }

   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if(requestCode ==2){
            if(null!= data){
                String message = data.getStringExtra("MESSAGE");

                TextView textViewMessage = (TextView)findViewById(R.id.textViewMessage);
                textViewMessage.setText("Message is:"+ message);

            }
        }
    }*/

    @Override
    protected void onResume() {

        super.onResume();
    }

    private void updateList() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);

        TextView tfun = (TextView) header.findViewById(R.id.navUsername);
        TextView tfemail = (TextView) header.findViewById(R.id.navEmail);
        EditText tf = (EditText) findViewById(R.id.LoginUsername);

        Intent intent = getIntent();

        String message = "";
        message = intent.getStringExtra(LogIn.EXTRA_MESSAGE);
        if (!message.equals("")) {

            String email = "";
            email = helper.seachEmail(message);
            tfun.setText(message);
            tfemail.setText(email);
        } else {
            tfun.setText("Guest");
            tfemail.setText("Please Register / Log In");
        }


    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.SignOut) {
            session.logoutUser();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent inte = new Intent(this, LogIn.class);
            startActivity(inte);

            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            Intent inten = new Intent(this, Register.class);

            startActivity(inten);

        } else if (id == R.id.nav_slideshow) {
            session.logoutUser();

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
