package com.example.yazan.wapp;

import android.util.Log;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Yazan on 8/3/2015.
 */

public class ConClient {
    private static String BASE_URL;
    HttpURLConnection con = null;
    InputStream is = null;

    public String connect(String str) {
        BASE_URL=str;
        try {
            con = (HttpURLConnection) (new URL(BASE_URL)).openConnection();
            con.setRequestMethod("GET");
            con.setDoInput(true);
            con.setDoOutput(true);
            con.connect();

            StringBuffer buffer = new StringBuffer();
            is = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while (  (line = br.readLine()) != null )
                buffer.append(line + "\r\n");
            is.close();
            con.disconnect();
            return buffer.toString();

        }catch (Exception e)
        {
            Log.d("In connect method", "we have an error !");
            e.printStackTrace();
        }
        return null;
    }
}
