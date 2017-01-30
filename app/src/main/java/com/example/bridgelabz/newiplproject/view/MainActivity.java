package com.example.bridgelabz.newiplproject.view;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.bridgelabz.newiplproject.R;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_TIME = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(MainActivity.this,Loginpage.class);
                startActivity(i);
                finish();


            }
        }, SPLASH_TIME);

       // getSupportFragmentManager().beginTransaction().replace(R.id.activity_main,new Next()).commit();
    }
}




