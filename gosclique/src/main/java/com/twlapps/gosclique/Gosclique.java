package com.twlapps.gosclique;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import java.util.UUID;

public class Gosclique {
    private static Gosclique instance;
    private String appId = "";
    private String userId = "";
    private Activity context;
    private String navigationBarColor = "#1c2529";
    private String navigationBarTextColor = "#FFFFFF";
    private String navigationBarText = "Gosclique Surveys";

    public static Gosclique getInstance()
    {
        if (instance == null)
        {
            instance = new Gosclique();
        }
        return instance;
    }
    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public Activity getContext() {
        return context;
    }

    public void setContext(Activity context) {
        this.context = context;
    }

    public String getNavigationBarColor() {
        return navigationBarColor;
    }

    public void setNavigationBarColor(String navigationBarColor) {
        this.navigationBarColor = navigationBarColor;
    }
    public String getNavigationBarTextColor() {
        return navigationBarTextColor;
    }

    public void setNavigationBarTextColor(String navigationBarTextColor) {
        this.navigationBarTextColor = navigationBarTextColor;
    }

    public String getNavigationBarText() {
        return navigationBarText;
    }

    public void setNavigationBarText(String navigationBarText) {
        this.navigationBarText = navigationBarText;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void init(String app_id, String user_id, Activity activity)  {
        if (TextUtils.isEmpty(app_id)){
            Log.e("Gosclique", "App ID can not be empty");
            throw new IllegalArgumentException("App ID can not be empty");
        }
        if (!TextUtils.isDigitsOnly(app_id)){
            Log.e("Gosclique", "App ID can only contain numbers");
            throw new IllegalArgumentException("App ID can only contain numbers");
        }
        String user = "";
        if (TextUtils.isEmpty(user_id)){
            user = UUID.randomUUID().toString();
        }else {
            user = user_id;
        }

        getInstance().initialize(app_id, user, activity);
    }


    private void initialize(String app_id, String user_id, Activity activity) {
        getInstance().setAppId(app_id);
        getInstance().setUserId(user_id);
        getInstance().setContext(activity);
    }

    public void showSurveyPanel(ShowCallBack showCallback) {
        if (this.context != null) {
            if (TextUtils.isEmpty(this.appId)){
                showCallback.fail("Gosclique SDK requires an app ID to initialize");
            }else {
                if (TextUtils.isEmpty(this.userId)){
                    showCallback.fail("Gosclique SDK requires a user ID to initialize");
                }else{
                    Intent intent = new Intent(this.context, SurveyActivity.class);
                    intent.putExtra("navigationColor", navigationBarColor);
                    intent.putExtra("navigationTextColor", navigationBarTextColor);
                    intent.putExtra("navigationText", navigationBarText);
                    intent.putExtra("appId", appId);
                    intent.putExtra("userId", userId);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    this.context.startActivity(intent);
                    showCallback.success();
                }
            }
        }else{
            showCallback.fail("Gosclique is not initialized properly");
            Log.e("Gosclique surveys", "Gosclique surveys is not initialized properly");
        }
    }

}
