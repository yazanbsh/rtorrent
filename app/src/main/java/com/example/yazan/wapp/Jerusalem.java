package com.example.yazan.wapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Calendar;

public class Jerusalem extends AppCompatActivity {
    String URl="http://api.openweathermap.org/data/2.5/forecast/daily?id=7303419&units=metric&cnt=5";
    int index;
    private String tmpStr;
    private String name="default";
    ////
    Calendar calendar = Calendar.getInstance();
    int day = calendar.get(Calendar.DAY_OF_WEEK);
    String dayName="default";
    ///
    String [] sday1=new String [4];
    String [] sday2=new String [4];
    String [] sday3=new String [4];
    String [] sday4=new String [4];
    String [] sday5=new String [4];
    //
    TextView cityname;
    ////
    TextView day1max;
    TextView day1min;
    TextView day1pre;
    TextView day1hum;
    ////
    TextView day2max;
    TextView day2min;
    TextView day2pre;
    TextView day2hum;
    ////
    TextView day3max;
    TextView day3min;
    TextView day3pre;
    TextView day3hum;
    ////
    TextView day4max;
    TextView day4min;
    TextView day4pre;
    TextView day4hum;
    ////
    TextView day5max;
    TextView day5min;
    TextView day5pre;
    TextView day5hum;
    ////
    TextView day1name;
    TextView day2name;
    TextView day3name;
    TextView day4name;
    TextView day5name;
    ////
    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jerusalem);
        Intent intent=this.getIntent();
        index=intent.getExtras().getInt("id");
        SendHttpRequestTask task=new SendHttpRequestTask();
        task.execute();
        //
        cityname= (TextView) findViewById(R.id.cityName);
        ///
        day1max=(TextView)findViewById(R.id.day1Max);
        day1min=(TextView)findViewById(R.id.day1Min);
        day1pre=(TextView)findViewById(R.id.day1Pre);
        day1hum=(TextView)findViewById(R.id.day1Hum);
        ///
        day2max=(TextView)findViewById(R.id.day2Max);
        day2min=(TextView)findViewById(R.id.day2Min);
        day2pre=(TextView)findViewById(R.id.day2Pre);
        day2hum=(TextView)findViewById(R.id.day2Hum);
        ///
        day3max=(TextView)findViewById(R.id.day3Max);
        day3min=(TextView)findViewById(R.id.day3Min);
        day3pre=(TextView)findViewById(R.id.day3Pre);
        day3hum=(TextView)findViewById(R.id.day3Hum);
        ///
        day4max=(TextView)findViewById(R.id.day4Max);
        day4min=(TextView)findViewById(R.id.day4Min);
        day4pre=(TextView)findViewById(R.id.day4Pre);
        day4hum=(TextView)findViewById(R.id.day4Hum);
        ///
        day5max=(TextView)findViewById(R.id.day5Max);
        day5min=(TextView)findViewById(R.id.day5Min);
        day5pre=(TextView)findViewById(R.id.day5Pre);
        day5hum=(TextView)findViewById(R.id.day5Hum);
        ///
        day1name=(TextView)findViewById(R.id.day1Text);
        day2name=(TextView)findViewById(R.id.day2Text);
        day3name=(TextView)findViewById(R.id.day3Text);
        day4name=(TextView)findViewById(R.id.day4Text);
        day5name=(TextView)findViewById(R.id.day5Text);
        ///

    }

    private void setValues(){
        cityname.setText(name);
        //
        day1max.setText(sday1[0]);
        day1min.setText(sday1[1]);
        day1pre.setText(sday1[2]);
        day1hum.setText(sday1[3]);
        /////
        day2max.setText(sday2[0]);
        day2min.setText(sday2[1]);
        day2pre.setText(sday2[2]);
        day2hum.setText(sday2[3]);
        /////
        day3max.setText(sday3[0]);
        day3min.setText(sday3[1]);
        day3pre.setText(sday3[2]);
        day3hum.setText(sday3[3]);
        /////
        day4max.setText(sday4[0]);
        day4min.setText(sday4[1]);
        day4pre.setText(sday4[2]);
        day4hum.setText(sday4[3]);
        /////
        day5max.setText(sday5[0]);
        day5min.setText(sday5[1]);
        day5pre.setText(sday5[2]);
        day5hum.setText(sday5[3]);
        /////
    }
    private void setDays(){
        String [] days={"Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday"};
        int ind=0;
        switch (day){
            case Calendar.SATURDAY:
                ind=0;
                break;
            case Calendar.SUNDAY:
                ind=1;
                break;
            case Calendar.MONDAY:
                ind=2;
                break;
            case Calendar.TUESDAY:
                ind=3;
                break;
            case Calendar.WEDNESDAY:
                ind=4;
                break;
            case Calendar.THURSDAY:
                ind=5;
                break;
            case Calendar.FRIDAY:
                ind=6;
                break;
        }
        day1name.setText(days[ind]);
        day2name.setText(days[(ind+1)%7]);
        day3name.setText(days[(ind+2)%7]);
        day4name.setText(days[(ind+3)%7]);
        day5name.setText(days[(ind+4)%7]);
    }


    private class SendHttpRequestTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            if (index==2){
                URl="http://api.openweathermap.org/data/2.5/forecast/daily?id=282239&units=metric&cnt=5";
            }
            else if (index==3){
                URl="http://api.openweathermap.org/data/2.5/forecast/daily?id=282615&units=metric&cnt=5";
            }
            else if (index==4){
                URl="http://api.openweathermap.org/data/2.5/forecast/daily?id=282039&units=metric&cnt=5";
            }
            else if (index==5){
                URl="http://api.openweathermap.org/data/2.5/forecast/daily?id=283506&units=metric&cnt=5";
            }
            else if (index==6){
                URl="http://api.openweathermap.org/data/2.5/forecast/daily?id=285066&units=metric&cnt=5";
            }
            ///////
            String data=(new ConClient().connect(URl));
            return data;
        }

        @Override
        protected void onPostExecute(String result) {
            tmpStr=result;
            new JSONParser().parse(tmpStr);
            setValues();
            setDays();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_jerusalem, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    ///////////////////////////////////////////////////////////
    public class JSONParser {
        JSONObject objMain;
        JSONArray jArray;
        JSONObject day1,day2,day3,day4,day5;


        public void parse(String str) {
            try {
                objMain = new JSONObject(str);
                JSONObject city=objMain.getJSONObject("city");
                name=city.getString("name");
                System.out.println("helllllloooo lets find out \n"+name);
            } catch (Exception e) {
                Log.d("Whats up", "here we creating object from string");
                e.printStackTrace();
            }
            try {
                jArray = (objMain.getJSONArray("list"));
            } catch (Exception e) {
                Log.d("hello buddy", "trying to get the array");
            }

            try {
                day1=jArray.getJSONObject(0);
                day2=jArray.getJSONObject(1);
                day3=jArray.getJSONObject(2);
                day4=jArray.getJSONObject(3);
                day5=jArray.getJSONObject(4);
                //System.out.println("Day1: "+day1.toString()+"\n"+"Day2: "+day2.toString()+"\n"+
                //        "Day3: "+day3.toString()+"\n"+"Day4: "+day4.toString()+"\n"+"Day5: "+day5.toString()+"\n");
            }catch (Exception e){
                Log.d("mmmmm","and getting the days from array");
            }
            try {
                JSONObject temp;
                temp=day1.getJSONObject("temp");
                sday1[0]=String.valueOf(temp.getDouble("max"));
                sday1[1]=String.valueOf(temp.getDouble("min"));
                sday1[2]=String.valueOf(day1.getDouble("pressure"));
                sday1[3]=String.valueOf(day1.getDouble("humidity"));
                ///// end of day1

                temp=day2.getJSONObject("temp");
                sday2[0]=String.valueOf(temp.getDouble("max"));
                sday2[1]=String.valueOf(temp.getDouble("min"));
                sday2[2]=String.valueOf(day2.getDouble("pressure"));
                sday2[3]=String.valueOf(day2.getDouble("humidity"));
                ///// end of day2

                temp=day3.getJSONObject("temp");
                sday3[0]=String.valueOf(temp.getDouble("max"));
                sday3[1]=String.valueOf(temp.getDouble("min"));
                sday3[2]=String.valueOf(day3.getDouble("pressure"));
                sday3[3]=String.valueOf(day3.getDouble("humidity"));
                ///// end of day3

                temp=day4.getJSONObject("temp");
                sday4[0]=String.valueOf(temp.getDouble("max"));
                sday4[1]=String.valueOf(temp.getDouble("min"));
                sday4[2]=String.valueOf(day4.getDouble("pressure"));
                sday4[3]=String.valueOf(day4.getDouble("humidity"));
                ///// end of day4

                temp=day5.getJSONObject("temp");
                sday5[0]=String.valueOf(temp.getDouble("max"));
                sday5[1]=String.valueOf(temp.getDouble("min"));
                sday5[2]=String.valueOf(day5.getDouble("pressure"));
                sday5[3]=String.valueOf(day5.getDouble("humidity"));
                ///// end of day5
                /////

                System.out.println(sday1[0]+"\n");
                System.out.println(sday1[1]+"\n");
                System.out.println(sday1[2]+"\n");
                System.out.println(sday1[3]+"\n");

                ////


            }catch (Exception e){
                Log.d("ok","now to get the weather info");
                e.printStackTrace();
            }
            //allDays[0]=sday1;
        }
    }

    ///////////////////////////////////////////////////////////
}
