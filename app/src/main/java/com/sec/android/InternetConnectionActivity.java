package com.sec.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class InternetConnectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet_connection);

        tumKisiler();

    }

    public void tumKisiler() {
        String url = "URL";
        StringRequest istek = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Log.e("Cevap: ", response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray kisilerListe = jsonObject.getJSONArray("users");
                    for(int i=0;i<kisilerListe.length();i++){
                        JSONObject k = kisilerListe.getJSONObject(i);
                        int id = k.getInt("id");
                        String kullanici_Adi = k.getString("kullanici_Adi");
                        String kullanici_Sifre = k.getString("kullanici_Sifre");

                        Log.e("id",String.valueOf(id));
                        Log.e("Ad",kullanici_Adi);
                        Log.e("Şifre",kullanici_Sifre);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Volley.newRequestQueue(this).add(istek);
    }

}