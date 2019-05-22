package com.example.testsample;
import android.content.Intent;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class fetchData extends AsyncTask<Void,Void,Void> {
    String data ="";
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            String ur=MainActivity.urltext;
            URL url = new URL(ur);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line != null){
                line = bufferedReader.readLine();
                data = data + line;
            }



            ObjectMapper mapper= new ObjectMapper();
            try {

                TrainingPlan[] TP= mapper.readValue(data, TrainingPlan[].class);

                for(int j=0;j<TP.length;j++)
                {
                    TrainPlans.textView.setText("PGM name: "+TP[j].getPrgName());
                }


            }
            catch (JsonParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (JsonMappingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } catch (MalformedURLException e) {


            e.printStackTrace();
        } catch (IOException e) {


            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

    }
}
