package com.example.testsample;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class welcomescreen extends AppCompatActivity {
    ImageView imageView0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomescreen);

        new Handler().postDelayed(new Runnable() {

// Using handler with postDelayed called runnable run method

            @Override

            public void run() {

                Intent i = new Intent(welcomescreen.this, MainActivity.class);

                startActivity(i);

                // close this activity

                finish();

            }

        }, 2*1000);

        imageView0=findViewById(R.id.imageView0);




    }
}
