package com.example.testsample;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
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
import java.util.Calendar;

import static com.example.testsample.MainActivity.urltext;


public class scheduling extends AppCompatActivity {
    EditText textView;
    ScrollView scroll;
    LinearLayout linearLayout;
    static int CPF;
    static String Empname,DES,UNIT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheduling);
        textView=findViewById(R.id.t);
        textView.setText(urltext);
        linearLayout=findViewById(R.id.linear);
        scroll= findViewById(R.id.scroll);

        new Data(urltext,0).execute();

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
                String ur = urltext;
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
            String[][] Probes;
            try {
                    PS = mapper.readValue(data, ProgramSchedule[].class);
                String[] ProbeHeaders = {"FILE NO","PROGRAM","FROM","TO","ROOM","PARTICIPANTS","COORDINATOR"};
                Probes=new String[PS.length][7];
                final Employee E[]=new Employee[PS.length];
                for (int i=0;i<PS.length;i++)
                {
                    E[i]=new Employee();

                    Probes[i][0]=PS[i].getFileno()==null?"-":PS[i].getFileno();
                    Probes[i][1]=PS[i].getProgram()==null?"-":PS[i].getProgram();
                    Probes[i][2]=PS[i].getFromDt().month==null?"-":PS[i].getFromDt().month;
                    if(Probes[i][2]!="-")
                    {
                        //JUNE-3 Time:9.00
                        Probes[i][2]=PS[i].getFromDt().month+"-"+PS[i].getFromDt().dayOfMonth+" \nTime:"+PS[i].getFromDt().hour+":"+PS[i].getFromDt().minute;
                    }

                    Probes[i][3]=PS[i].getToDt().month==null?"-":PS[i].getToDt().month;
                    if(Probes[i][3]!="-")
                    {
                        Probes[i][3]=PS[i].getToDt().month+"-"+PS[i].getToDt().dayOfMonth+" \nTime:"+PS[i].getToDt().hour+":"+PS[i].getToDt().minute;
                    }

                    Probes[i][4]=PS[i].getRoom()==null?"-":PS[i].getRoom();
                    Probes[i][5]=PS[i].getParticipan().toString()==null?"-":PS[i].getParticipan().toString();
                    Probes[i][6]=PS[i].getTrgCoord().getPersInfo().getEmpName()==null?"-":PS[i].getTrgCoord().getPersInfo().getEmpName();
                    E[i]=PS[i].getTrgCoord();
                }

                LinearLayout parent[] = new LinearLayout[PS.length+1];
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
                LinearLayout.LayoutParams lparams1 = new LinearLayout.LayoutParams((int)(width/3), LinearLayout.LayoutParams.MATCH_PARENT);
                for(int i=0;i<PS.length+1;i++) {
                    parent[i] = new LinearLayout(scheduling.this);
                    parent[i].setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                    parent[i].setOrientation(LinearLayout.HORIZONTAL);
                    parent[i].setGravity(Gravity.CENTER);
                    parent[i].setPadding(5, 5, 5, 5);


                }
                for(int i=0;i<7;i++) {
                    TextView tv = new TextView(scheduling.this);
                    tv.setBackgroundColor(Color.GRAY);
                    if(i==0)
                        tv.setLayoutParams(lparams1);
                    else
                        tv.setLayoutParams(lparams);
                    tv.setText(ProbeHeaders[i]);
                    tv.setGravity(Gravity.CENTER);
                    tv.setPadding(5, 5, 5, 5);
                    parent[PS.length].addView(tv);
                }

                for(int i=0;i<PS.length;i++)
                {
                    for(int j=0;j<7;j++)
                    {
                        if(j==0)
                        {
                            Button tv=new Button(scheduling.this);
                            tv.setLayoutParams(lparams1);
                            tv.setBackgroundResource(R.drawable.buttonstyle3);
                            tv.setText(Probes[i][j]);
                            tv.setEnabled(true);
                            final int k=i;
                            tv.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Button b = (Button)v;
                                    Empname=E[k].getPersInfo().getEmpName()==null?"-":E[k].getPersInfo().getEmpName();
                                    CPF=E[k].getPersInfo().getCpfNo();
                                    DES=E[k].getDesignation().getDesgShortDesc();
                                    UNIT=E[k].getPipasLocation().getPipasUnit().getUnitShortDesc();
                                    startActivity(new Intent(scheduling.this,EmpView.class));
                                }
                            });
                            parent[i].addView(tv);
                        }
                        else {
                            TextView tv = new TextView(scheduling.this);
                            tv.setLayoutParams(lparams);
                            tv.setGravity(Gravity.CENTER);
//                            if (j % 2 == 0)
//                                tv.setBackgroundColor(Color.GREEN);
//                            else
//                                tv.setBackgroundColor(Color.YELLOW);

                            tv.setText(Probes[i][j]);
                            parent[i].addView(tv);
                        }
                    } }

                linearLayout.addView(parent[PS.length]);

                for(int i=0;i<PS.length;i++)
                    linearLayout.addView(parent[i]);


            } catch (IOException e) {
                e.printStackTrace();
                textView.setText("JACK ERROR ");

            }

        }

    }

}

