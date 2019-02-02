package com.test.deeplinktest.PostRequest;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OnPostEvent extends AppCompatActivity implements OnPostRequest{

    private static final String linkSuccess = "http://fbkraken.com/2w2pT8";
    private static final String linkFailure = "http://fbkraken.com/zrv22D";

    public OnPostEvent(String reslut) {

        if (reslut.contentEquals("success")) {
            onPostRequest(linkSuccess);
        }else
            if (reslut.contentEquals("failure")){
                onPostRequest(linkFailure);
            }else{

                // TODO: failure
            }
    }


    @Override
    public void onPostRequest(final String link) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(link)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String myResponse = response.body().string();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(Intent.ACTION_VIEW);

                            if (link.contentEquals(linkSuccess)){
                                intent.setData(Uri.parse(link));
                            }else
                            if (link.contentEquals(linkFailure)){
                                intent.setData(Uri.parse(link));
                            }

                            startActivity(intent);
                        }
                    });
                }
            }
        });
    }
}
