package com.example.testsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Spinner spinner1,spinner2;
Button button1;
String s1,s2;
static String url;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner1=findViewById(R.id.spinner1);
        spinner2=findViewById(R.id.spinner2);
        button1=findViewById(R.id.bt1);
        textView=findViewById(R.id.text);
    }

    public void showdetail(View view) {
        s1=spinner1.getSelectedItem().toString();
        s2=spinner2.getSelectedItem().toString();
        url="http://210.212.241.79:8080/HRWS/fetchTrgPlans?progCatgCode=";
        url+=s2+"&partCatgCode=";
        url+=s1;


textView.setText(url);

    }
}
