package com.example.testsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
Spinner spinner1,spinner2;
Button button1;
String s1,s2;
static String urltext;
EditText textView;
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
        urltext="http://210.212.241.79:8080/HRWS/fetchTrgPlans?progCatgCode=";
        urltext+=s2+"&partCatgCode=";
        urltext+=s1;



        textView.setText(urltext);
//String data="";
//        try {
//            URL url = new URL(urltext);
//            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
//
//            InputStream inputStream = httpURLConnection.getInputStream();
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//            String line = "";
//            while(line != null){
//                line = bufferedReader.readLine();
//                data = data + line;
//            }
//            ObjectMapper mapper= new ObjectMapper();
//            try {
//
//                TrainingPlan[] TP= mapper.readValue(data, TrainingPlan[].class);
//
//                for(int j=0;j<TP.length;j++)
//                {
//                    textView.setText(url+"\n"+"PGM name: "+TP[j].getPrgName());
//                }
//
//
//            }
//            catch (JsonParseException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            } catch (JsonMappingException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//
//        } catch (MalformedURLException e) {
//
//
//            e.printStackTrace();
//        } catch (IOException e) {
//
//
//            e.printStackTrace();
//        }
//
//

    }
}
