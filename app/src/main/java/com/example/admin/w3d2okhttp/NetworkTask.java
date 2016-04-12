package com.example.admin.w3d2okhttp;

import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by admin on 4/12/2016.
 */
public class NetworkTask extends AsyncTask<String, Void, Void> {
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private OkHttpClient client = new OkHttpClient();

    @Override
    protected Void doInBackground(String... params) {
        String getResponse;
        try {
            getResponse = doGetRequest("http://www.margulls.com");
            Log.d("TAG", "doInBackground: " + getResponse);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String doPostRequest(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public String doGetRequest(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
