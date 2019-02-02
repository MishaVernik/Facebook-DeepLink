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
        OnPostEvent onPostEvent = new OnPostEvent("failure");
    }



}
