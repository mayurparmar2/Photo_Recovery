package com.gcs.recovery.videos.files.photo_recovery.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StatFs;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.demo.example.R;
import com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass;
import com.demo.example.databinding.ActivityMainBinding;
import com.gcs.recovery.videos.files.photo_recovery.utils.Utils;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;
import java.text.DecimalFormat;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0003J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\nH\u0016J\u0012\u0010\u000e\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J-\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0016¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\nH\u0002J\b\u0010\u001b\u001a\u00020\nH\u0002J\b\u0010\u001c\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/activity/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ActivityMainBinding;", "exitDialog", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "firebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "displayStorageInfo", "", "handleContactPermission", "logAppOpenEvent", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "setupButtonListeners", "setupExitDialog", "showPermissionExplanation", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MainActivity extends AppCompatActivity {
    private static final int CONTACT_PERMISSION_REQUEST_CODE = 100;
    private ActivityMainBinding binding;
    private BottomSheetDialog exitDialog;
    private FirebaseAnalytics firebaseAnalytics;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding inflate = ActivityMainBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        ActivityMainBinding activityMainBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(this);
        Intrinsics.checkNotNullExpressionValue(firebaseAnalytics, "getInstance(...)");
        this.firebaseAnalytics = firebaseAnalytics;
        logAppOpenEvent();
        AdsClass adsClass = new AdsClass();
        ActivityMainBinding activityMainBinding2 = this.binding;
        if (activityMainBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityMainBinding = activityMainBinding2;
        }
        adsClass.refreshAd(activityMainBinding.frameLayout, this, 1);
        displayStorageInfo();
        setupButtonListeners();
        setupExitDialog();
    }

    private final void logAppOpenEvent() {
        FirebaseAnalytics firebaseAnalytics = this.firebaseAnalytics;
        if (firebaseAnalytics == null) {
            Intrinsics.throwUninitializedPropertyAccessException("firebaseAnalytics");
            firebaseAnalytics = null;
        }
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.APP_OPEN, null);
    }

    private final void displayStorageInfo() {
        StatFs statFs = new StatFs("/storage/emulated/0/");
        long blockSizeLong = statFs.getBlockSizeLong();
        long blockCountLong = statFs.getBlockCountLong() * blockSizeLong;
        long availableBlocksLong = statFs.getAvailableBlocksLong() * blockSizeLong;
        double d = ((blockCountLong - availableBlocksLong) / blockCountLong) * 100;
        ActivityMainBinding activityMainBinding = this.binding;
        if (activityMainBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainBinding = null;
        }
        activityMainBinding.storageTotal.setText(Utils.INSTANCE.formatSize(blockCountLong));
        activityMainBinding.availStorage.setText(Utils.INSTANCE.formatSize(availableBlocksLong));
        activityMainBinding.storagePercent.setText(new DecimalFormat("#.#").format(d) + '%');
        CircularProgressBar storageProgress = activityMainBinding.storageProgress;
        Intrinsics.checkNotNullExpressionValue(storageProgress, "storageProgress");
        CircularProgressBar.setProgressWithAnimation$default(storageProgress, (float) d, 1500L, null, null, 12, null);
    }

    private final void setupButtonListeners() {
        Pair[] pairArr = new Pair[9];
        ActivityMainBinding activityMainBinding = this.binding;
        ActivityMainBinding activityMainBinding2 = null;
        if (activityMainBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainBinding = null;
        }
        pairArr[0] = TuplesKt.to(activityMainBinding.btnRecoverFile, RecoveredFileActivity.class);
        ActivityMainBinding activityMainBinding3 = this.binding;
        if (activityMainBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainBinding3 = null;
        }
        pairArr[1] = TuplesKt.to(activityMainBinding3.setting, SettingsActivity.class);
        ActivityMainBinding activityMainBinding4 = this.binding;
        if (activityMainBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainBinding4 = null;
        }
        pairArr[2] = TuplesKt.to(activityMainBinding4.btnImage, PhotosScanActivity.class);
        ActivityMainBinding activityMainBinding5 = this.binding;
        if (activityMainBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainBinding5 = null;
        }
        pairArr[3] = TuplesKt.to(activityMainBinding5.btnVideo, VideosScanActivity.class);
        ActivityMainBinding activityMainBinding6 = this.binding;
        if (activityMainBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainBinding6 = null;
        }
        pairArr[4] = TuplesKt.to(activityMainBinding6.btnMusic, AudiosScanActivity.class);
        ActivityMainBinding activityMainBinding7 = this.binding;
        if (activityMainBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainBinding7 = null;
        }
        pairArr[5] = TuplesKt.to(activityMainBinding7.btnDocument, DocScanActivity.class);
        ActivityMainBinding activityMainBinding8 = this.binding;
        if (activityMainBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainBinding8 = null;
        }
        pairArr[6] = TuplesKt.to(activityMainBinding8.btnPrime, PrimeActivity.class);
        ActivityMainBinding activityMainBinding9 = this.binding;
        if (activityMainBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainBinding9 = null;
        }
        pairArr[7] = TuplesKt.to(activityMainBinding9.storageCard, StorageActivity.class);
        ActivityMainBinding activityMainBinding10 = this.binding;
        if (activityMainBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityMainBinding2 = activityMainBinding10;
        }
        pairArr[8] = TuplesKt.to(activityMainBinding2.cntBtn, ContactActivity.class);
        for (Map.Entry entry : MapsKt.mapOf(pairArr).entrySet()) {
            final View view = (View) entry.getKey();
            final Class cls = (Class) entry.getValue();
            view.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.MainActivity$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    MainActivity.setupButtonListeners$lambda$2$lambda$1(view, this, cls, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupButtonListeners$lambda$2$lambda$1(View button, MainActivity this$0, Class activityClass, View view) {
        Intrinsics.checkNotNullParameter(button, "$button");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activityClass, "$activityClass");
        ActivityMainBinding activityMainBinding = this$0.binding;
        if (activityMainBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityMainBinding = null;
        }
        if (Intrinsics.areEqual(button, activityMainBinding.cntBtn)) {
            this$0.handleContactPermission();
        } else {
            this$0.startActivity(new Intent(this$0, (Class<?>) activityClass));
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        BottomSheetDialog bottomSheetDialog = this.exitDialog;
        BottomSheetDialog bottomSheetDialog2 = null;
        if (bottomSheetDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("exitDialog");
            bottomSheetDialog = null;
        }
        if (bottomSheetDialog.isShowing()) {
            super.onBackPressed();
            return;
        }
        BottomSheetDialog bottomSheetDialog3 = this.exitDialog;
        if (bottomSheetDialog3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("exitDialog");
        } else {
            bottomSheetDialog2 = bottomSheetDialog3;
        }
        bottomSheetDialog2.show();
    }

    private final void setupExitDialog() {
        MainActivity mainActivity = this;
        this.exitDialog = new BottomSheetDialog(mainActivity);
        BottomSheetDialog bottomSheetDialog = null;
        View inflate = LayoutInflater.from(mainActivity).inflate(R.layout.dialog_exit_layout, (ViewGroup) null);
        BottomSheetDialog bottomSheetDialog2 = this.exitDialog;
        if (bottomSheetDialog2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("exitDialog");
        } else {
            bottomSheetDialog = bottomSheetDialog2;
        }
        bottomSheetDialog.setContentView(inflate);
        new AdsClass().refreshAd((FrameLayout) inflate.findViewById(R.id.frameLayout), this, 0);
        inflate.findViewById(R.id.exitBtn).setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.MainActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.setupExitDialog$lambda$3(MainActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupExitDialog$lambda$3(MainActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finishAffinity();
    }

    private final void handleContactPermission() {
        MainActivity mainActivity = this;
        if (ContextCompat.checkSelfPermission(mainActivity, "android.permission.READ_CONTACTS") == 0 && ContextCompat.checkSelfPermission(mainActivity, "android.permission.WRITE_CONTACTS") == 0) {
            startActivity(new Intent(mainActivity, (Class<?>) ContactActivity.class));
        } else if (shouldShowRequestPermissionRationale("android.permission.READ_CONTACTS") || shouldShowRequestPermissionRationale("android.permission.WRITE_CONTACTS")) {
            showPermissionExplanation();
        } else {
            requestPermissions(new String[]{"android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS"}, 100);
        }
    }

    private final void showPermissionExplanation() {
        Toast.makeText(this, "We need access to your contacts to recover deleted contacts.", Toast.LENGTH_LONG).show();
        requestPermissions(new String[]{"android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS"}, 100);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100) {
            if (!(grantResults.length == 0)) {
                for (int i : grantResults) {
                    if (i == 0) {
                    }
                }
                startActivity(new Intent(this, (Class<?>) ContactActivity.class));
                return;
            }
            if (!shouldShowRequestPermissionRationale("android.permission.READ_CONTACTS") || !shouldShowRequestPermissionRationale("android.permission.WRITE_CONTACTS")) {
                Toast.makeText(this, "Permission denied permanently. Go to settings to enable permission.", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Permission denied. Please allow permission to access contacts.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
