package com.example.nasafinal_api;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public abstract class BaseReq extends AsyncTask<Void, Void, Void> {
    String result = "";

    public abstract String getReqUrl();

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL (getReqUrl());

            HttpURLConnection connection =(HttpsURLConnection) url.openConnection(); // gönderieln url e bağlanmadsı açması için
            InputStream stream = connection.getInputStream(); //data akışını getir. açılan urlyi

            InputStreamReader reader = new InputStreamReader(stream);// akışı oku
            BufferedReader bfReader = new BufferedReader(reader); // bufferle adım adım sürekili olku  dataya çevir

            String res = "";
            while ((res = bfReader.readLine()) != null){
                result += res;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.d("MedipolRq:",result);

        return null;
    }
}
