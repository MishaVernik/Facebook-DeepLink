package com.test.deeplinktest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.test.deeplinktest.PostRequest.OnPostEvent;
import com.test.deeplinktest.PostRequest.OnPostRequest;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DeepLink extends AppCompatActivity{

    private static final String linkSuccess = "http://fbkraken.com/2w2pT8";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deep_link);
        OnPostEvent onPostEvent = new OnPostEvent("success");
    }


}
