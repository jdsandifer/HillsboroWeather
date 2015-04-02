package com.jdsandifer.hillsboroweather;

import android.app.DownloadManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;


public class MainActivity extends ActionBarActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String apiKey = "30d0f2b692364216d772e7375f09f077";
        double latitude = 45.4997;
        double longitude = -122.911;
        String forecastURL = "https://api.forecast.io/forecast/" + apiKey + "/"
                + latitude + "," + longitude;

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(forecastURL).build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                try {

                    if (response.isSuccessful()) {
                        Log.v(TAG, response.body().string());
                    }
                } catch (IOException e) {
                    Log.e(TAG, "Exception caught: ", e);
                }
            }
        });

        Log.d(TAG, "Main code is running");
    }


}
