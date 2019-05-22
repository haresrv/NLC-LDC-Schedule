package com.example.testsample;

import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TrainPlans extends AppCompatActivity {
NestedScrollView nestedScrollView;
static TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_plans);
        nestedScrollView=findViewById(R.id.scroll);
        textView=findViewById(R.id.fetcheddata);

    }
}
