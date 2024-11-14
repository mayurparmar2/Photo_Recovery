package com.gcs.recovery.videos.files.photo_recovery.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;






import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OpenAppManager.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u000fH\u0002J\u001a\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\rH\u0016J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\rH\u0016J\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\rH\u0016J\u0018\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u001aH\u0016J\u0010\u0010 \u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\rH\u0016J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\rH\u0016J\b\u0010\"\u001a\u00020\u0015H\u0007J\b\u0010#\u001a\u00020\u0015H\u0002J\u0010\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u0013H\u0002R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/ads/OpenAppManager;", "Landroidx/lifecycle/LifecycleObserver;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "myApplication", "Lcom/gcs/recovery/videos/files/photo_recovery/ads/MyApplication;", "(Lcom/gcs/recovery/videos/files/photo_recovery/ads/MyApplication;)V", "adRequest", "Lcom/google/android/gms/ads/AdRequest;", "getAdRequest", "()Lcom/google/android/gms/ads/AdRequest;", "appOpenAd", "Lcom/google/android/gms/ads/appopen/AppOpenAd;", "currentActivity", "Landroid/app/Activity;", "isShowingAd", "", "loadCallback", "Lcom/google/android/gms/ads/appopen/AppOpenAd$AppOpenAdLoadCallback;", "loadTime", "", "fetchAd", "", "isAdAvailable", "onActivityCreated", "activity", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "onStart", "showAdIfAvailable", "wasLoadTimeLessThanNHoursAgo", "numHours", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OpenAppManager implements LifecycleObserver, Application.ActivityLifecycleCallbacks {
    private static final String LOG_TAG = "AppOpenManager";
    private AppOpenAd appOpenAd;
    private Activity currentActivity;
    private boolean isShowingAd;
    private AppOpenAd.AppOpenAdLoadCallback loadCallback;
    private long loadTime;
    private final MyApplication myApplication;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.currentActivity = null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.currentActivity = activity;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.currentActivity = activity;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public OpenAppManager(MyApplication myApplication) {
        Intrinsics.checkNotNullParameter(myApplication, "myApplication");
        this.myApplication = myApplication;
        myApplication.registerActivityLifecycleCallbacks(this);
        ProcessLifecycleOwner.INSTANCE.get().getLifecycle().addObserver(this);
    }

    private final void showAdIfAvailable() {
        if (!this.isShowingAd && isAdAvailable()) {
            String adsEnable = Config.adsEnable;
            Intrinsics.checkNotNullExpressionValue(adsEnable, "adsEnable");
            if (adsEnable.length() == 0) {
                FullScreenContentCallback fullScreenContentCallback = new FullScreenContentCallback() { // from class: com.gcs.recovery.videos.files.photo_recovery.ads.OpenAppManager$showAdIfAvailable$fullScreenContentCallback$1
                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                        Intrinsics.checkNotNullParameter(adError, "adError");
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdDismissedFullScreenContent() {
                        OpenAppManager.this.appOpenAd = null;
                        OpenAppManager.this.isShowingAd = false;
                        OpenAppManager.this.fetchAd();
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdShowedFullScreenContent() {
                        OpenAppManager.this.isShowingAd = true;
                    }
                };
                AppOpenAd appOpenAd = this.appOpenAd;
                if (appOpenAd != null) {
                    appOpenAd.setFullScreenContentCallback(fullScreenContentCallback);
                }
                AppOpenAd appOpenAd2 = this.appOpenAd;
                if (appOpenAd2 != null) {
                    Activity activity = this.currentActivity;
                    Intrinsics.checkNotNull(activity);
                    appOpenAd2.show(activity);
                    return;
                }
                return;
            }
        }
        fetchAd();
    }

    public final void fetchAd() {
        if (isAdAvailable()) {
            return;
        }
        this.loadCallback = new AppOpenAd.AppOpenAdLoadCallback() { // from class: com.gcs.recovery.videos.files.photo_recovery.ads.OpenAppManager$fetchAd$1
            @Override // com.google.android.gms.ads.AdLoadCallback
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                Intrinsics.checkNotNullParameter(loadAdError, "loadAdError");
            }

            @Override // com.google.android.gms.ads.AdLoadCallback
            public void onAdLoaded(AppOpenAd ad) {
                Intrinsics.checkNotNullParameter(ad, "ad");
                OpenAppManager.this.appOpenAd = ad;
                OpenAppManager.this.loadTime = new Date().getTime();
            }
        };
        AdRequest adRequest = getAdRequest();
        MyApplication myApplication = this.myApplication;
        AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback = this.loadCallback;
        Intrinsics.checkNotNull(appOpenAdLoadCallback);
        AppOpenAd.load(myApplication, Config.ADMOB_APP_OPEN_ID, adRequest, 1, appOpenAdLoadCallback);
    }

    private final AdRequest getAdRequest() {
        AdRequest build = new AdRequest.Builder().build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    private final boolean isAdAvailable() {
        return this.appOpenAd != null && wasLoadTimeLessThanNHoursAgo(4L);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void onStart() {
        showAdIfAvailable();
    }

    private final boolean wasLoadTimeLessThanNHoursAgo(long numHours) {
        return new Date().getTime() - this.loadTime < ((long) 3600000) * numHours;
    }
}
