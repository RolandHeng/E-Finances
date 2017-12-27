package com.example.user.e_finance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class debtCal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debt_cal);
    }

    public void getMessage(View v){


        TextView amount = (TextView)findViewById(R.id.amountloan);

        TextView result = (TextView) findViewById(R.id.result);

        if( amount.getText().toString().isEmpty()){
            String show = "Invalid input";
            result.setText(show);
        }
        else {
            String p = amount.getText().toString();
            double aa = Double.parseDouble(p);

            TextView rate = (TextView) findViewById(R.id.interestrate);
            String a = rate.getText().toString();
            double ab = Double.parseDouble(a);

            TextView month = (TextView) findViewById(R.id.month);
            String b = month.getText().toString();
            double ac = Double.parseDouble(b);

            double loan = (aa * ab * ac) / 100;
            double results = aa + loan;

            String st = String.valueOf(results);



            result.setText(st);
        }
    }

    public void backmain(View v){
        Intent intentGetMessage = new Intent(this, MainActivity.class);

        startActivityForResult(intentGetMessage,2);
    }

}
