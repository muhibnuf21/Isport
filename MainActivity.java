package com.example.isports;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import com.example.isports.ui.login.LoginActivity;

public class MainActivity extends AppCompatActivity {
    private int second = 4000;

    //4000=4 detik

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //setelah loading maka akan langsung berpindah ke home activity
                Intent home = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(home);
                finish();

            }
        },second);
    }
}
