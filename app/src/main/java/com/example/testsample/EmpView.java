package com.example.testsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class EmpView extends AppCompatActivity {

    TextView t1,t2,t3,t4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp_view);
        t1=findViewById(R.id.name);
        t2=findViewById(R.id.cpf);
        t3=findViewById(R.id.des);
        t4=findViewById(R.id.unit);
        if(scheduling.Empname!=null)
            t1.setText(scheduling.Empname);
        if(scheduling.CPF!=0)
           t2.setText(scheduling.CPF);
        if(scheduling.DES!=null)
            t3.setText(scheduling.DES);
        if(scheduling.UNIT!=null)
            t4.setText(scheduling.UNIT);



    }
}
