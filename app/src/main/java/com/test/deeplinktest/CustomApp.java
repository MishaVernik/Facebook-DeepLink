package com.test.deeplinktest;
import android.app.Application;
import io.branch.referral.Branch;
public class CustomApp extends  Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Branch logging for debugging
        Branch.enableLogging();

        // Branch object initialization
        Branch.getAutoInstance(this);
    }
}
