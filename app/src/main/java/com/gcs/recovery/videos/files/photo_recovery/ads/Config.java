package com.gcs.recovery.videos.files.photo_recovery.ads;

import android.app.Activity;

/* loaded from: classes2.dex */
public class Config {
    public static final String ADMOB_APP_OPEN_ID = "ca-app-pub-6265205464703134/9139715426";
    public static final String ADMOB_INTERSTITIAL_ID = "ca-app-pub-6265205464703134/2250873443";
    public static final String ADMOB_NATIVE_ID = "ca-app-pub-6265205464703134/7446788986";
    public static String adsEnable = "";

    public static void loadAdsEnableFromPrefs(Activity activity) {
        adsEnable = activity.getSharedPreferences("AppPrefs", 0).getString("adsEnabled", "");
    }
}
