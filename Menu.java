package com.example.isports;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;

import com.example.isports.ui.login.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Menu extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    FirebaseAuth auth;
    DatabaseReference myRef = database.getReference("message");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        myRef.setValue("Welcome");

        auth = FirebaseAuth.getInstance();
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menubar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.logout:

                FirebaseAuth.getInstance().signOut();
                finish();
                startActivity(new Intent(this, LoginActivity.class));

                break;
        }

        return true;
    }

    public void btn_uncheck(View view) {
        Intent Uncheck = new Intent(getApplicationContext(), Schedule.class);
        startActivity(Uncheck);
    }

    public void btn_glasses(View view) {
        Intent Glasses = new Intent(getApplicationContext(),About.class);
        startActivity(Glasses);

            }
        }
