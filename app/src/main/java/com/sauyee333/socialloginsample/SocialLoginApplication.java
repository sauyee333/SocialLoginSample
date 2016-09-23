package com.sauyee333.socialloginsample;

import android.app.Application;

import com.facebook.FacebookSdk;

/**
 * Created by sauyee on 23/9/16.
 */

public class SocialLoginApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FacebookSdk.sdkInitialize(getApplicationContext());
    }
}
