package com.example.testsample;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
//import android.support.design.widget.Snackbar;

import static java.lang.Thread.sleep;


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
        if(internet_connection()) {
            s1 = spinner1.getSelectedItem().toString();
            s2 = spinner2.getSelectedItem().toString();
            urltext = "http://210.212.241.79:8080/HRWS/fetchTrgPlans?progCatgCode=";
            urltext += s2 + "&partCatgCode=";
            urltext += s1;
           // textView.setText(urltext);
           // urltext="http://210.212.241.79:8080/HRWS/fetchParticipantCatg";
            new Data().execute();
        }
        else{
//            //create a snackbar telling the user there is no internet connection and issuing a chance to reconnect
//            final Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content),
//                    "Retry now",
//                    Snackbar.LENGTH_LONG);
//            snackbar.setActionTextColor(ContextCompat.getColor(getApplicationContext(),
//                    R.color.colorPrimaryDark));
//            snackbar.setAction(R.string.try_again, new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    startActivity(new Intent(MainActivity.this,MainActivity.class));
//                }
//            }).show();
        }

    }

class Data extends AsyncTask<Void,Void,String> {
    String data ="";
    int response=-1;
    @Override
    protected String doInBackground(Void... voids) {
        try {
            String ur=MainActivity.urltext;
            URL url = new URL(ur);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();
            response=httpURLConnection.getResponseCode();
            if (response == HttpURLConnection.HTTP_OK) {

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";
                while (line != null) {
                    line = bufferedReader.readLine();
                    data = data + line;
                }
                //textView.setText(data);

                ObjectMapper mapper = new ObjectMapper();
                try {

                    TrainingPlan[] TP = mapper.readValue(data, TrainingPlan[].class);

                    for (int j = 0; j < TP.length; j++) {
                        data+="PGM name: "+TP[j].getPrgName();

                    }


                } catch (JsonParseException e) {
                    e.printStackTrace();
                    return "Parse";

                } catch (JsonMappingException e) {
                    e.printStackTrace();
                    return "Parse";

                } catch (IOException e) {
                    e.printStackTrace();
                    return "Parse";

                }
            }
            else {

                return data+"Internet conn";

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return data+"MalformedURL";

        } catch (IOException e) {
            e.printStackTrace();
            return data+"IOExce";

        }
        return data;
    }

    @Override
    protected void onPostExecute(String aVoid) {
        super.onPostExecute(aVoid);
        textView.setText(aVoid);

    }
}
class HTTPException extends IOException {
    private int responseCode;

    public HTTPException( final int responseCode ) {
        super();
        this.responseCode = responseCode;
    }

    public int getResponseCode() {
        return this.responseCode;
    }
}

    boolean internet_connection(){
        //Check if connected to internet, output accordingly
        ConnectivityManager cm =
                (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }
}
