package com.gcs.recovery.videos.files.photo_recovery.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass;
import com.gcs.recovery.videos.files.photo_recovery.ads.CheckSubscription;
import com.demo.example.databinding.ActivitySplashBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SplashActivity.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\f\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/activity/SplashActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "splashActivityBinding", "Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ActivitySplashBinding;", "hasPermissions", "", "navigateAfterDelay", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "startGuideActivity", "startPermissionActivity", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SplashActivity extends AppCompatActivity {
    private static final long DELAY_TIME = 3000;
    private ActivitySplashBinding splashActivityBinding;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySplashBinding inflate = ActivitySplashBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.splashActivityBinding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("splashActivityBinding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        navigateAfterDelay();
        SplashActivity splashActivity = this;
        AdsClass.loadAd(splashActivity);
        new CheckSubscription(splashActivity).checkPremium();
    }

    private final void navigateAfterDelay() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.SplashActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                SplashActivity.navigateAfterDelay$lambda$0(SplashActivity.this);
            }
        }, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void navigateAfterDelay$lambda$0(SplashActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.hasPermissions()) {
            this$0.startGuideActivity();
        } else {
            this$0.startPermissionActivity();
        }
        this$0.finish();
    }

    private final boolean hasPermissions() {
        if (Build.VERSION.SDK_INT >= 33) {
            SplashActivity splashActivity = this;
            if (ContextCompat.checkSelfPermission(splashActivity, "android.permission.READ_MEDIA_IMAGES") == 0 && ContextCompat.checkSelfPermission(splashActivity, "android.permission.READ_MEDIA_VIDEO") == 0) {
                return true;
            }
        } else {
            SplashActivity splashActivity2 = this;
            if (ContextCompat.checkSelfPermission(splashActivity2, "android.permission.READ_EXTERNAL_STORAGE") == 0 && ContextCompat.checkSelfPermission(splashActivity2, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                return true;
            }
        }
        return false;
    }

    private final void startGuideActivity() {
        startActivity(new Intent(this, (Class<?>) GuideActivity.class));
    }

    private final void startPermissionActivity() {
        startActivity(new Intent(this, (Class<?>) PermissionActivity.class));
    }
}
