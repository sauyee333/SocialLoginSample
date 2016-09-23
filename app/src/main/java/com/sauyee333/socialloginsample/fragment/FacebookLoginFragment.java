package com.sauyee333.socialloginsample.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.sauyee333.socialloginsample.R;

import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by sauyee on 23/9/16.
 */

public class FacebookLoginFragment extends Fragment {
    private Context mContext;
    private CallbackManager mCallbackManager;

    @Bind(R.id.login_button)
    LoginButton mLoginButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_facebook, container, false);
        ButterKnife.bind(this, view);
        mContext = getContext();
        setupLoginButton();
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void setupLoginButton() {
        _Debug("setupLoginButton");
        mCallbackManager = CallbackManager.Factory.create();

        mLoginButton.setFragment(FacebookLoginFragment.this);
        mLoginButton.setReadPermissions(Arrays.asList("public_profile", "email", "user_birthday"));
        _Debug("2. setupLoginButton");
        mLoginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                _Debug("onSuccess");
//                GraphRequest graphRequest = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
//                    @Override
//                    public void onCompleted(JSONObject object, GraphResponse response) {
//                        String displayInfo = "";
//                        try {
//                            if (object.has("id")) {
//                                String id = object.getString("id").toString();
//                                displayInfo += ("User ID: " + id + "\n");
//                                String profileImageUrl = "https://graph.facebook.com/" + id + "/picture?type=large";
//                            }
//                            if (object.has("name")) {
//                                displayInfo += ("Name: " + object.getString("name").toString() + "\n");
//                            }
//                            if (object.has("gender")) {
//                                displayInfo += ("Gender: " + object.getString("gender").toString() + "\n");
//                            }
//                            if (object.has("birthday")) {
////                                displayInfo += ("Birthday: " + object.getString("birthday").toString() + "\n");
//                            }
//                            if (object.has("email")) {
//                                displayInfo += ("Email: " + object.getString("email").toString() + "\n");
//                            }
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
//                });
//
//                Bundle parameters = new Bundle();
//                parameters.putString("fields", "id,name,email,gender,birthday");
//                graphRequest.setParameters(parameters);
//                graphRequest.executeAsync();
            }

            @Override
            public void onCancel() {
                _Debug("onCancel");
            }

            @Override
            public void onError(FacebookException error) {
                _Debug("onError");
            }
        });
    }

    private static void _Debug(String str) {
        Log.d("widget", str);
    }
}
