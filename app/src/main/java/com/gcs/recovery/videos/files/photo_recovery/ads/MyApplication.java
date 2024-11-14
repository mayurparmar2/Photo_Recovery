package com.gcs.recovery.videos.files.photo_recovery.ads;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.facebook.FacebookSdk;

import com.facebook.appevents.AppEventsLogger;
import com.demo.example.R;





import com.onesignal.OneSignal;
import com.onesignal.debug.LogLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;




/* compiled from: MyApplication.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/ads/MyApplication;", "Landroid/app/Application;", "()V", "ONESIGNAL_APP_ID", "", "onCreate", "", "setUpAdmobAds", "setUpAppEvent", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MyApplication extends Application {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static MyApplication instance;
    private final String ONESIGNAL_APP_ID = "4cd9c516-a3e0-4dcc-8b03-948cad753b90";

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        setUpAppEvent();
        setUpAdmobAds();
        MyApplication myApplication = this;
        FirebaseApp.initializeApp(myApplication);
        AudienceNetworkAds.initialize(myApplication);
        instance = this;
        FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(true);
        OneSignal.getDebug().setLogLevel(LogLevel.VERBOSE);
        OneSignal.initWithContext(myApplication, this.ONESIGNAL_APP_ID);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new MyApplication$onCreate$1(null), 3, null);
        new OpenAppManager(this);
        registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.gcs.recovery.videos.files.photo_recovery.ads.MyApplication$onCreate$2
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                Intrinsics.checkNotNullParameter(outState, "outState");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }
        });
    }

    private final void setUpAppEvent() {
        String string = getString(R.string.Fb_App_Id);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        FacebookSdk.setApplicationId(string);
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        FacebookSdk.sdkInitialize(applicationContext);
        FacebookSdk.setAutoLogAppEventsEnabled(true);
        AppEventsLogger.INSTANCE.activateApp(this);
    }

    private final void setUpAdmobAds() {
        MobileAds.initialize(this, new OnInitializationCompleteListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.ads.MyApplication$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.ads.initialization.OnInitializationCompleteListener
            public final void onInitializationComplete(InitializationStatus initializationStatus) {
                Intrinsics.checkNotNullParameter(initializationStatus, "it");
            }
        });
    }

    /* compiled from: MyApplication.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/ads/MyApplication$Companion;", "", "()V", "<set-?>", "Lcom/gcs/recovery/videos/files/photo_recovery/ads/MyApplication;", "instance", "getInstance", "()Lcom/gcs/recovery/videos/files/photo_recovery/ads/MyApplication;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MyApplication getInstance() {
            MyApplication myApplication = MyApplication.instance;
            if (myApplication != null) {
                return myApplication;
            }
            Intrinsics.throwUninitializedPropertyAccessException("instance");
            return null;
        }
    }
}
