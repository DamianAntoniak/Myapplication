package com.example.damia.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickMe(View view) {

        Intent intent = new Intent(MainActivity.this, newActivity.class);
        startActivity(intent);
    }

    public void onClickHistory(View view) {

        Intent intent = new Intent(MainActivity.this, historyActivity.class);
        startActivity(intent);
    }
}
