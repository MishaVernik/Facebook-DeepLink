package com.test.deeplinktest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.os.Bundle;
import android.widget.Toast;

import java.io.IOException;
import io.branch.referral.Branch;
import io.branch.referral.BranchError;

import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.applinks.AppLinkData;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        setContentView(R.layout.activity_main);
        FacebookSdk.setIsDebugEnabled(true);
      ///  logSentFriendRequestEvent();
        FacebookSdk.addLoggingBehavior(LoggingBehavior.APP_EVENTS);
        // enable Cordova apps to be started in the background
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.getBoolean("cdvStartInBackground", false)) {
            moveTaskToBack(true);
        }

        AppLinkData.fetchDeferredAppLinkData(MainActivity.this, new AppLinkData.CompletionHandler() {
            @Override
            public void onDeferredAppLinkDataFetched(AppLinkData appLinkData) {
                Intent myIntent = null;
                if (appLinkData != null && appLinkData.getTargetUri() != null) {

                    myIntent = new Intent(MainActivity.this, DeepLink.class);
                    startActivity(myIntent);

                }else{

                    myIntent = new Intent(MainActivity.this, DeepLinkFailure.class);
                    startActivity(myIntent);
                }

            }
        });
        // Initialize the Branch object

      //  Branch.getAutoInstance(this);
        GraphRequest request = GraphRequest.newMeRequest(
                AccessToken.getCurrentAccessToken(),
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        // Insert your code here
                    }
                });


    /*
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name");
      //  parameters.putString("access_token", " 000000000000000 | AppSecret ");
        parameters.putString("access_token", String.valueOf(R.string.facebook_app_id) + "|f963930d6d1aaf4fb86ff8aadace4593");
        request.setParameters(parameters);
        request.executeAsync();

        request = GraphRequest.newGraphPathRequest(
                AccessToken.getCurrentAccessToken(),
                "/me",
                new GraphRequest.Callback() {
                    @Override
                    public void onCompleted(GraphResponse response) {
                        // Insert your code here
                        Log.d("MyLogs response2", response.toString());
                    }
                });

        parameters = new Bundle();
        parameters.putString("access_token", String.valueOf(R.string.facebook_app_id) + "|f963930d6d1aaf4fb86ff8aadace4593");
        request.setParameters(parameters);
        request.executeAsync();

     */
    }



/*
    @Override
    public void onStart() {
        super.onStart();

        // Branch init
        //Branch branch = Branch.getInstance(getApplicationContext());
        Branch.getInstance(getApplicationContext()).initSession(new Branch.BranchReferralInitListener() {
            @Override
            public void onInitFinished(JSONObject referringParams, BranchError error) {
                if (error == null) {
                    Log.i("BRANCH SDK", referringParams.toString());


                    // Retrieve deeplink keys from 'referringParams' and evaluate the values to determine where to route the user
                    // Check '+clicked_branch_link' before deciding whether to use your Branch routing logic
                    try {
                        if ("true" == referringParams.getString("+clicked_branch_link")){

                            onPostRequest(linkSuccess);
                        }else{

                        }
                           // onPostRequest(linkFailure);
                    } catch (JSONException e) {
                        e.printStackTrace();

                    }

                } else {
                    Log.i("BRANCH SDK", error.getMessage());
                }
                Toast.makeText(getApplicationContext(), referringParams.toString(), Toast.LENGTH_SHORT);
            }
        }, this.getIntent().getData(), this);
    }





    @Override
    public void onNewIntent(Intent intent) {
      //  this.setIntent(intent);
    }

    /**
     * This function assumes logger is an instance of AppEventsLogger and has been
     * created using AppEventsLogger.newLogger() call.

    public void logSentFriendRequestEvent () {

        AppEventsLogger logger = AppEventsLogger.newLogger(getApplicationContext());
        logger.logEvent("sentFriendRequest");
    }
    */
}
