package com.gcs.recovery.videos.files.photo_recovery.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.demo.example.databinding.ActivityPermissionBinding;
import com.demo.example.databinding.DialogPermissionBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PermissionActivity.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\u0012\u0010\u0010\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J-\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u000e\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0016¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\nH\u0002J\b\u0010\u001b\u001a\u00020\nH\u0002J\b\u0010\u001c\u001a\u00020\nH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/activity/PermissionActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "permissionActivityBinding", "Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ActivityPermissionBinding;", "permissionDialog", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "hasPermissions", "", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "redirectToGuideActivity", "requestPermissions", "showCustomSettingsDialog", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PermissionActivity extends AppCompatActivity {
    private static final int REQUEST_MANAGE_EXTERNAL_STORAGE_CODE = 2;
    private static final int REQUEST_PERMISSIONS_CODE = 1;
    private ActivityPermissionBinding permissionActivityBinding;
    private BottomSheetDialog permissionDialog;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityPermissionBinding inflate = ActivityPermissionBinding.inflate(getLayoutInflater());
        this.permissionActivityBinding = inflate;
        Intrinsics.checkNotNull(inflate);
        setContentView(inflate.getRoot());
        ActivityPermissionBinding activityPermissionBinding = this.permissionActivityBinding;
        Intrinsics.checkNotNull(activityPermissionBinding);
        activityPermissionBinding.ivAllow.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PermissionActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PermissionActivity.onCreate$lambda$0(PermissionActivity.this, view);
            }
        });
        if (hasPermissions()) {
            redirectToGuideActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(PermissionActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showCustomSettingsDialog();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0024, code lost:
    
        if (androidx.core.content.ContextCompat.checkSelfPermission(r0, "android.permission.READ_MEDIA_VIDEO") == 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:?, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0038, code lost:
    
        if (androidx.core.content.ContextCompat.checkSelfPermission(r0, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean hasPermissions() {
        if (Build.VERSION.SDK_INT >= 30) {
            return Environment.isExternalStorageManager();
        }
        if (Build.VERSION.SDK_INT >= 33) {
            PermissionActivity permissionActivity = this;
            if (ContextCompat.checkSelfPermission(permissionActivity, "android.permission.READ_MEDIA_IMAGES") == 0) {
            }
            return false;
        }
        PermissionActivity permissionActivity2 = this;
        if (ContextCompat.checkSelfPermission(permissionActivity2, "android.permission.READ_EXTERNAL_STORAGE") == 0) {
        }
        return false;
    }

    private final void requestPermissions() {
        if (Build.VERSION.SDK_INT >= 30) {
            if (!Environment.isExternalStorageManager()) {
                Intent intent = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
                intent.setData(Uri.fromParts("package", getPackageName(), null));
                startActivityForResult(intent, 2);
                return;
            } else {
                Toast.makeText(this, "Permissions already granted", Toast.LENGTH_SHORT).show();
                redirectToGuideActivity();
                return;
            }
        }
        if (Build.VERSION.SDK_INT >= 33) {
            if (!hasPermissions()) {
                ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO"}, 1);
                return;
            } else {
                Toast.makeText(this, "Permissions already granted", Toast.LENGTH_SHORT).show();
                redirectToGuideActivity();
                return;
            }
        }
        if (!hasPermissions()) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
        } else {
            Toast.makeText(this, "Permissions already granted", Toast.LENGTH_SHORT).show();
            redirectToGuideActivity();
        }
    }

    private final void showCustomSettingsDialog() {
        PermissionActivity permissionActivity = this;
        DialogPermissionBinding inflate = DialogPermissionBinding.inflate(LayoutInflater.from(permissionActivity));
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(permissionActivity);
        this.permissionDialog = bottomSheetDialog;
        bottomSheetDialog.setContentView(inflate.getRoot());
        inflate.ivAllow.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PermissionActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PermissionActivity.showCustomSettingsDialog$lambda$1(PermissionActivity.this, view);
            }
        });
        BottomSheetDialog bottomSheetDialog2 = this.permissionDialog;
        if (bottomSheetDialog2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("permissionDialog");
            bottomSheetDialog2 = null;
        }
        bottomSheetDialog2.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showCustomSettingsDialog$lambda$1(PermissionActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.requestPermissions();
    }

    private final void redirectToGuideActivity() {
        startActivity(new Intent(this, (Class<?>) GuideActivity.class));
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (!(grantResults.length == 0)) {
                for (int i : grantResults) {
                    if (i != 0) {
                        if (!shouldShowRequestPermissionRationale("android.permission.READ_MEDIA_IMAGES") || !shouldShowRequestPermissionRationale("android.permission.READ_MEDIA_VIDEO") || !shouldShowRequestPermissionRationale("android.permission.READ_EXTERNAL_STORAGE") || !shouldShowRequestPermissionRationale("android.permission.WRITE_EXTERNAL_STORAGE")) {
                            showCustomSettingsDialog();
                            return;
                        } else {
                            Toast.makeText(this, "Permissions denied", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                }
                Toast.makeText(this, "Permissions granted", Toast.LENGTH_SHORT).show();
                redirectToGuideActivity();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != 2 || Build.VERSION.SDK_INT < 30) {
            return;
        }
        if (Environment.isExternalStorageManager()) {
            Toast.makeText(this, "Manage External Storage permission granted", Toast.LENGTH_SHORT).show();
            redirectToGuideActivity();
        } else {
            Toast.makeText(this, "Manage External Storage permission denied", Toast.LENGTH_SHORT).show();
        }
    }
}
