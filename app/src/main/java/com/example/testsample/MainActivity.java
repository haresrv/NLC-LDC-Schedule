package com.example.testsample;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static com.example.testsample.R.drawable.nlclogo;


public class MainActivity extends AppCompatActivity {
    Spinner spinner1, spinner2;
    ParticipantCategory[] PC;
    ProgramCategory[] PROGC;
    Button button1;

    ScrollView scroll;
    LinearLayout linearLayout;
    String s1, s2;
    String scommon;
    TrainingPlan[] TP;
    String partCatgCode, progCatgCode;
    static String urltext;
    EditText textView;
    static int x;

    boolean internet_connection() {
        //Check if connected to internet, output accordingly
        ConnectivityManager cm =
                (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         // getSupportActionBar().setDisplayShowHomeEnabled(true);
        ;
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("NLC LDC Schedule");

       getSupportActionBar().setHomeButtonEnabled(true);

          getSupportActionBar().setIcon(nlclogo);
getSupportActionBar().setLogo(nlclogo);








        scommon = "EndpointURL";
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        button1 = findViewById(R.id.bt1);
        linearLayout=findViewById(R.id.linear);
        scroll= findViewById(R.id.scroll);
        textView = findViewById(R.id.text);
        new Data(scommon + "fetchParticipantCatg", 1).execute();
        new Data(scommon + "fetchProgCatg", 2).execute();

    }

    public void showdetail(View view) {
        if (internet_connection()) {
            s1 = spinner1.getSelectedItem().toString();
            s2 = spinner2.getSelectedItem().toString();
            urltext = scommon + "fetchTrgPlans?progCatgCode=";
            urltext += s2 + "&partCatgCode=";
            urltext += s1;
            partCatgCode = spinner1.getSelectedItem().toString();
            progCatgCode = spinner2.getSelectedItem().toString();
            for (int j = 0; j < PC.length; j++) {
                if (PC[j].getDescr().equals(partCatgCode)) {
                    partCatgCode = PC[j].getCode();
                }

            }
            for (int j = 0; j < PROGC.length; j++) {
                if (PROGC[j].getDescr().equals(progCatgCode)) {
                    progCatgCode = PROGC[j].getCode();
                }

            }


            urltext = scommon + "fetchTrgPlans?progCatgCode=" + progCatgCode + "&partCatgCode=" + partCatgCode;
            new Data(urltext, 3).execute();
        } else {
            //create a snackbar telling the user there is no internet connection and issuing a chance to reconnect
            final Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content),
                    R.string.try_again,
                    Snackbar.LENGTH_LONG);
            snackbar.setActionTextColor(ContextCompat.getColor(getApplicationContext(),
                    R.color.colorStarBlue));
            snackbar.setAction("Retry now", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, MainActivity.class));
                }
            }).show();
        }

    }

    class Data extends AsyncTask<Void, Void, Integer> {
        String data = "";
        int response = -1, x;

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
                String ur = data;
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
        protected void onPostExecute(Integer aVoid) {
            super.onPostExecute(aVoid);
            //textView.setText(aVoid);

            ObjectMapper mapper = new ObjectMapper();
         linearLayout.removeAllViews();
            if (x == 1) {

                try {

                    PC = mapper.readValue(data, ParticipantCategory[].class);
                    List<String> spinnerArray1 = new ArrayList<String>();

                    for (int j = 0; j < PC.length; j++) {
                        spinnerArray1.add(PC[j].getDescr());

                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, spinnerArray1);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner1.setAdapter(adapter);


                } catch (JsonParseException e) {
                    e.printStackTrace();

                } catch (JsonMappingException e) {
                    e.printStackTrace();

                } catch (IOException e) {
                    e.printStackTrace();

                }

            } else if (x == 2) {

                try {

                    PROGC = mapper.readValue(data, ProgramCategory[].class);
                    List<String> spinnerArray2 = new ArrayList<String>();

                    for (int j = 0; j < PROGC.length; j++) {
                        spinnerArray2.add(PROGC[j].getDescr());

                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, spinnerArray2);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner2.setAdapter(adapter);


                } catch (JsonParseException e) {
                    e.printStackTrace();

                } catch (JsonMappingException e) {
                    e.printStackTrace();

                } catch (IOException e) {
                    e.printStackTrace();

                }


            } else if (x == 3) {

                String[] ProbeHeaders = {"FILE NO", "PROGRAM NAME", "PROGRAM COORDINATOR", "NO.OF PROGRAMS", "PROGRAM DAYS", "PROGRAM CATEGORY","PARTICIPANT CATEGORY"};
                String[][] Probes;
                try {
                String x="";
                TP = mapper.readValue(data, TrainingPlan[].class);
                Probes=new String[TP.length][7];
                for (int i=0;i<TP.length;i++)
                {


                    Probes[i][0]=TP[i].getFileno()==null?"-":TP[i].getFileno();
                    Probes[i][1]=TP[i].getPrgName()==null?"-":TP[i].getPrgName();
                    Probes[i][2]=TP[i].getProgCoord().getPersInfo().getEmpName()==null?"-":TP[i].getProgCoord().getPersInfo().getEmpName();
                    Probes[i][3]=TP[i].getNoOfPrgs().toString()==null?"-":TP[i].getNoOfPrgs().toString();
                    Probes[i][4]=TP[i].getPrgDays().toString()==null?"-":TP[i].getPrgDays().toString();
                    Probes[i][5]=TP[i].getProgCategory().getCode()==null?"-":TP[i].getProgCategory().getCode();
                    Probes[i][6]=TP[i].getParticipant().getDescr()==null?"-":TP[i].getParticipant().getDescr();
                    x+=Probes[i][0];
                }
                    LinearLayout parent[] = new LinearLayout[TP.length+1];
                    Display display = getWindowManager().getDefaultDisplay();
                    Point size = new Point();
                    try {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                            display.getRealSize(size);
                        }
                    } catch (NoSuchMethodError err) {
                        display.getSize(size);
                    }
                    int width = size.x;
                    int height = size.y;
                    linearLayout.setBackgroundColor(Color.WHITE);
                    LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams((int)(width/3),LinearLayout.LayoutParams.MATCH_PARENT);
                    LinearLayout.LayoutParams lparams1 = new LinearLayout.LayoutParams((int)(width/3),LinearLayout.LayoutParams.MATCH_PARENT );
                    for(int i=0;i<TP.length+1;i++) {
                        parent[i] = new LinearLayout(MainActivity.this);
                        parent[i].setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                        parent[i].setOrientation(LinearLayout.HORIZONTAL);
                        parent[i].setGravity(Gravity.CENTER);
                        parent[i].setPadding(5, 5, 5, 5);
                    }
                    for(int i=0;i<7;i++) {
                        TextView tv = new TextView(MainActivity.this);
                        tv.setBackgroundColor(Color.GRAY);
                    if(i==0)
                        tv.setLayoutParams(lparams1);
                    else
                        tv.setLayoutParams(lparams);
                        tv.setText(ProbeHeaders[i]);
                        tv.setGravity(Gravity.CENTER);
                        tv.setPadding(5, 5, 5, 5);
                        parent[TP.length].addView(tv);
                    }

    for(int i=0;i<TP.length;i++)
    {
    for(int j=0;j<7;j++) {
        if(j==0)
        {
            Button tv=new Button(MainActivity.this);

            tv.setLayoutParams(lparams1);
            tv.setBackgroundResource(R.drawable.buttonstyle3);
            tv.setText(Probes[i][j]);
            tv.setGravity(Gravity.CENTER);
            tv.setEnabled(true);
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button b = (Button)v;
                    urltext=scommon+"fetchTrgProgs?calYear="+ Calendar.getInstance().get(Calendar.YEAR)+"&fileNo="+b.getText().toString();
                    textView.setVisibility(View.GONE);
                    startActivity(new Intent(MainActivity.this,scheduling.class));

                }
            });
            parent[i].addView(tv);
        }
else {
            TextView tv = new TextView(MainActivity.this);
            tv.setLayoutParams(lparams);
            tv.setGravity(Gravity.CENTER);
//            if (j % 2 == 0)
//                tv.setBackgroundColor(Color.GREEN);
//            else
//                tv.setBackgroundColor(Color.YELLOW);

            tv.setText(Probes[i][j]);
            parent[i].addView(tv);
        }
    } }

    linearLayout.addView(parent[TP.length]);

    for(int i=0;i<TP.length;i++)
        linearLayout.addView(parent[i]);


                }
            catch (JsonParseException e) {
                e.printStackTrace();

            }
            catch (JsonMappingException e) {
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();

            }

}

        }


    }


    class HTTPException extends IOException {
        private int responseCode;

        public HTTPException(final int responseCode) {
            super();
            this.responseCode = responseCode;
        }

        public int getResponseCode() {
            return this.responseCode;
        }
    }



}
