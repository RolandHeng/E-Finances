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


        if(session.checkLogin())
            finish();


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
        tfun.setText(name);
        String email = "";
        email = helper.seachEmail(name);
        tfemail.setText(email);


    }

    public void getMessage(View v) {
        Intent intentGetMessage = new Intent(this, InterestRate.class);

        startActivityForResult(intentGetMessage, 2);
        finish();
    }

    public void gocost(View v) {
        Intent intentGetMessage = new Intent(this, monthlyCostCal.class);

        startActivityForResult(intentGetMessage, 2);
        finish();
    }


    public void godebt(View v) {
        Intent intentGetMessage = new Intent(this, debtCal.class);

        startActivityForResult(intentGetMessage, 2);
        finish();
    }



    @Override
    protected void onResume() {

        super.onResume();
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
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {

            Intent intentGetMessage = new Intent(this, monthlyCostCal.class);

            startActivityForResult(intentGetMessage, 2);
            finish();

        } else if (id == R.id.nav_gallery) {


        } else if (id == R.id.nav_slideshow) {
            Intent intentGetMessage = new Intent(this, debtCal.class);

            startActivityForResult(intentGetMessage, 2);
            finish();


        } else if (id == R.id.nav_manage) {

            Intent intentGetMessage = new Intent(this, InterestRate.class);

            startActivityForResult(intentGetMessage, 2);
            finish();


        }else if (id == R.id.nav_TVoM) {



        }else if(id== R.id.nav_manageProfile){
            Intent inten = new Intent(this, ManageProfile.class);

            startActivity(inten);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
