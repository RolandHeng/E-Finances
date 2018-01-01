package com.example.user.e_finance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class monthlyCostCal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_cost_cal);
    }

    public void count(View v){


        TextView income = (TextView)findViewById(R.id.income);
        TextView tx1 = (TextView)findViewById(R.id.tx1);

        if( income.getText().toString().isEmpty()){
            String show = "Invalid input";
            tx1.setText(show);
        }
        else {

            String p = income.getText().toString();
            double incomes = Double.parseDouble(p);

            double house = incomes * 35 / 100;
            double transp = incomes * 12 / 100;
            double food = incomes * 18 / 100;
            double debt = incomes * 15 / 100;
            double leisure = incomes * 8 / 100;
            double save = incomes * 12 / 100;


            String housed = String.valueOf(house);
            tx1.setText(housed);

            TextView tx2 = (TextView) findViewById(R.id.tx2);
            String transpd = String.valueOf(transp);
            tx2.setText(transpd);

            TextView tx3 = (TextView) findViewById(R.id.tx3);
            String foodd = String.valueOf(food);
            tx3.setText(foodd);

            TextView tx4 = (TextView) findViewById(R.id.tx4);
            String debtd = String.valueOf(debt);
            tx4.setText(debtd);

            TextView tx5 = (TextView) findViewById(R.id.tx5);
            String leisured = String.valueOf(leisure);
            tx5.setText(leisured);

            TextView tx6 = (TextView) findViewById(R.id.tx6);
            String saved = String.valueOf(save);
            tx6.setText(saved);


        }
    }

    public void backmain(View v){
        Intent intentGetMessage = new Intent(this, MainActivity.class);

        startActivityForResult(intentGetMessage,2);
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent intentGetMessage = new Intent(this, MainActivity.class);

        startActivityForResult(intentGetMessage,2);
        finish();

    }
}
