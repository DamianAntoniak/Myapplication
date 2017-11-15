package com.example.damia.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.String;

public class newActivity extends AppCompatActivity {

    DatebaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
         db = new DatebaseHelper(this);
    }


    private double ResultC(double l, double km){
        return l / km * 100;
    }

    public void calculate(View view) {
        EditText eText;
        String l = "0", km = "0", c = "0", cl = "0", result = "";

        TextView cal = (TextView) findViewById(R.id.textView);

        eText = (EditText)findViewById(R.id.editTextL);
        l = eText.getText().toString().replace(",", ".");

        eText = (EditText)findViewById(R.id.editTextKm);
        km = eText.getText().toString().replace(",", ".");

        RadioButton rPrice = (RadioButton)findViewById(R.id.radioButton5);
        RadioButton rPriceL = (RadioButton)findViewById(R.id.radioButton6);

        if(!l.isEmpty() && !km.isEmpty())
        {
            result = String.format(" %.2f L / 100km", ResultC(Double.parseDouble(l), Double.parseDouble(km)));

            if(rPrice.isChecked())
            {
                eText = (EditText)findViewById(R.id.editText12);
                c = eText.getText().toString().replace(",", ".");
                result += String.format("\n%.2f zł / 100km", Double.parseDouble(c) / Double.parseDouble(l) * ResultC(Double.parseDouble(l), Double.parseDouble(km)));
            }
            else if(rPriceL.isChecked())
            {
                eText = (EditText)findViewById(R.id.editText12);
                cl = eText.getText().toString().replace(",", ".");
                result += String.format("\n%.2f zł / 100km", Double.parseDouble(cl) * ResultC(Double.parseDouble(l), Double.parseDouble(km)));
            }
        }
        cal.setText(result);
        cal.setTextColor(Color.RED);
    }

    public void saveToDateBase(View view)
    {
        EditText eText;
        String l = "0", km = "0", c = "0";

        TextView cal = (TextView) findViewById(R.id.textView);

        eText = (EditText)findViewById(R.id.editTextL);
        l = eText.getText().toString();

        eText = (EditText)findViewById(R.id.editTextKm);
        km = eText.getText().toString();



        RadioButton rPrice = (RadioButton)findViewById(R.id.radioButton5);
        RadioButton rPriceL = (RadioButton)findViewById(R.id.radioButton6);



        boolean t = false;

        if(!l.isEmpty() && !km.isEmpty()) {
            Log.i("!", "Zaczynamy testowac");
            if(rPrice.isChecked())
            {

                eText = (EditText)findViewById(R.id.editText12);
                c = eText.getText().toString();

                Log.i("!", "Test1: " + l + " || " + km + " || " + c);

                db.setInsert(Double.parseDouble(l), Double.parseDouble(km), Double.parseDouble(c), 0.0);
                Toast.makeText(newActivity.this, "Zapisane", Toast.LENGTH_LONG).show();
            }
            else if(rPriceL.isChecked())
            {
                eText = (EditText)findViewById(R.id.editText12);
                c = eText.getText().toString();
                Log.i("!", "Test2: " + Double.parseDouble(l) + " " +  Double.parseDouble(km) + " " + Double.parseDouble(c));
                db.setInsert(Double.parseDouble(l), Double.parseDouble(km), 0.0, Double.parseDouble(c));
                Toast.makeText(newActivity.this, "Zapisane", Toast.LENGTH_LONG).show();
            }
            else
            {
                Log.i("!", "Test3");
                eText = (EditText)findViewById(R.id.editText12);
                c = eText.getText().toString();

                db.setInsert(Double.parseDouble(l), Double.parseDouble(km), 0.0, 0.0);
                Toast.makeText(newActivity.this, "Zapisane", Toast.LENGTH_LONG).show();

            }

        }

    }
}
