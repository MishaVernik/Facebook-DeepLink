package com.test.deeplinktest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.test.deeplinktest.PostRequest.OnPostEvent;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DeepLinkFailure extends AppCompatActivity {
    private static final String linkFailure = "http://fbkraken.com/zrv22D";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deep_link_failure);
        onPostRequest(linkFailure);
    }


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

                          //  if (link.contentEquals(linkSuccess)){
                          //      intent.setData(Uri.parse(link));
                          //  }else
                            if (link.contentEquals(linkFailure)){
                                intent.setData(Uri.parse(link));
                                startActivity(intent);
                            }
                        }
                    });
                }
            }
        });
    }
}
