package com.sauyee333.socialloginsample.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.crashlytics.android.Crashlytics;
import com.sauyee333.socialloginsample.R;
import com.sauyee333.socialloginsample.fragment.MainFragment;
import com.sauyee333.socialloginsample.listener.MainListener;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity implements MainListener {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "sauyee333@gmail.com";
    private static final String TWITTER_SECRET = "abc123456";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Crashlytics(), new Twitter(authConfig));
        setContentView(R.layout.activity_main);
        showMainFragment();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            finish();
        }
    }

    private void showMainFragment() {
        Fragment fragment = new MainFragment();
        showFragment(fragment, false);
    }

    private void showFragment(Fragment frag, boolean force) {
        String fragmentTag = frag.getClass().getName();
        FragmentManager manager = getSupportFragmentManager();
        boolean fragmentPopped = force ? false : manager.popBackStackImmediate(fragmentTag, 0);

        if ((!fragmentPopped && manager.findFragmentByTag(fragmentTag) == null) || force) {
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.content, frag, fragmentTag);
            transaction.addToBackStack(fragmentTag);
            transaction.commit();
        }
    }

    @Override
    public void onShowFragment(Fragment fragment, boolean force) {
        showFragment(fragment, force);
    }
}
