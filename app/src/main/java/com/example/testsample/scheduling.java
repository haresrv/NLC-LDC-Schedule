package com.example.testsample;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
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


public class scheduling extends AppCompatActivity {
    EditText textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheduling);
        textView=findViewById(R.id.t);
        textView.setText(MainActivity.urltext);
        new Data(MainActivity.urltext,0).execute();

    }


    class Data extends AsyncTask<Void, Void, Integer> {
        String data = "";
        int response = -1, x;
        ProgramSchedule PS[];

    /*
    x=1 --> fetch Particpant
    x=2 --> fetch Prog
    x=3 --> fetch Training plans

     */

        Data(String s, Integer x) {
            data = s;
            this.x = x;
        }

        @Override
        protected Integer doInBackground(Void... voids) {
            try {
                String ur = MainActivity.urltext;
                URL url = new URL(ur);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.connect();
                response = httpURLConnection.getResponseCode();

                if (response == HttpURLConnection.HTTP_OK) {
                    data = "";
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    String line = "";
                    while (line != null) {
                        line = bufferedReader.readLine();
                        data = data + line;
                    }
                    //textView.setText(data);


                } else {

                    return -1;//data+"Internet conn";

                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return -1;//data+"MalformedURL";

            } catch (IOException e) {
                e.printStackTrace();
                return -1;//data+"IOExce";

            }
            return x;//data;
        }


        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);

            ObjectMapper mapper = new ObjectMapper();
            try {
                    PS = mapper.readValue(data, ProgramSchedule[].class);
                    textView.setText(PS.length+" ");

            } catch (IOException e) {
                e.printStackTrace();
                textView.setText("JACK ERROR ");

            }

        }

    }

}

