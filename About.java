package com.example.isports;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.isports.ui.login.LoginActivity;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }
    public void btn_uncheck(View view) {
        Intent Uncheck = new Intent(getApplicationContext(), Schedule.class);
        startActivity(Uncheck);
    }

    public void btn_topmenu(View view) {
        Intent Glasses = new Intent(getApplicationContext(),Menu.class);
        startActivity(Glasses);

    }
}
