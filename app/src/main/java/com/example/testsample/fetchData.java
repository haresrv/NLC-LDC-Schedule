package com.example.testsample;
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

public class fetchData extends AsyncTask<Void,Void,Void> {
    String data ="";
    String dataParsed = "Not found";
    String singleParsed ="";

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            String ur=MainActivity.url;
            URL url = new URL(ur);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line != null){
                line = bufferedReader.readLine();
                data = data + line;
            }

         //   JSONObject JO = new JSONObject(data);

            JSONArray JA = new JSONArray(data);
            for(int i =0 ;i <JA.length(); i++){


            }



                // MainActivity.data.setText("Length:"+JA.length());

          /*
for(int i =0 ;i <JA.length(); i++){
                singleParsed =  "Cell Number:" + JO.get("cellNo") + "\n"+
                        "Address:" + JO.get("partyAddLine1") + "\n"+
                        JO.get("partyAddLine2") + "\n"+JO.get("partyAddLine3")+
                        "Name:" + JO.get("partyName") + "\n";

                dataParsed = dataParsed + singleParsed +"\n" ;


            }*/

        } catch (MalformedURLException e) {


            e.printStackTrace();
        } catch (IOException e) {


            e.printStackTrace();
        } catch (JSONException e) {


            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

    }
}
