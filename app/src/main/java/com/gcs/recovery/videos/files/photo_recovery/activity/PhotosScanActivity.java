package com.gcs.recovery.videos.files.photo_recovery.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.LifecycleOwnerKt;
import com.facebook.share.internal.ShareInternalUtility;
import com.demo.example.R;
import com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass;
import com.demo.example.databinding.ActivityPhotosScanBinding;
import com.gcs.recovery.videos.files.photo_recovery.utils.SharedDataHolder;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;




/* compiled from: PhotosScanActivity.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0019\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\rH\u0002J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\rH\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0015H\u0014J\u0016\u0010\u001a\u001a\u00020\u00152\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u001cH\u0002J\u001f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001c2\u0006\u0010\f\u001a\u00020\rH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\b\u0010\u001e\u001a\u00020\u0015H\u0002J\b\u0010\u001f\u001a\u00020\u0015H\u0003J\b\u0010 \u001a\u00020\u0015H\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/activity/PhotosScanActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "foundFiles", "", "isScanning", "", "photosScanBinding", "Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ActivityPhotosScanBinding;", "scannedFiles", "totalFiles", "calculateTotalFiles", "directory", "Ljava/io/File;", "(Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFileSignature", "", ShareInternalUtility.STAGING_PARAM, "isImageWithoutExtension", "isValidImage", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onScanComplete", "photoFiles", "", "scanForPhotos", "showExitConfirmationDialog", "startPhotoScan", "startPreparation", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PhotosScanActivity extends AppCompatActivity {
    private int foundFiles;
    private boolean isScanning = true;
    private ActivityPhotosScanBinding photosScanBinding;
    private int scannedFiles;
    private int totalFiles;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatImageView appCompatImageView;
        super.onCreate(savedInstanceState);
        ActivityPhotosScanBinding inflate = ActivityPhotosScanBinding.inflate(getLayoutInflater());
        this.photosScanBinding = inflate;
        Intrinsics.checkNotNull(inflate);
        setContentView(inflate.getRoot());
        AdsClass adsClass = new AdsClass();
        ActivityPhotosScanBinding activityPhotosScanBinding = this.photosScanBinding;
        Intrinsics.checkNotNull(activityPhotosScanBinding);
        adsClass.refreshAd(activityPhotosScanBinding.frameLayout, this, 0);
        ActivityPhotosScanBinding activityPhotosScanBinding2 = this.photosScanBinding;
        if (activityPhotosScanBinding2 != null && (appCompatImageView = activityPhotosScanBinding2.icBack) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PhotosScanActivity$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PhotosScanActivity.onCreate$lambda$0(PhotosScanActivity.this, view);
                }
            });
        }
        startPreparation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(PhotosScanActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackPressed();
    }

    private final void startPreparation() {
        ActivityPhotosScanBinding activityPhotosScanBinding = this.photosScanBinding;
        RelativeLayout relativeLayout = activityPhotosScanBinding != null ? activityPhotosScanBinding.preProgress : null;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(View.VISIBLE);
        }
        ActivityPhotosScanBinding activityPhotosScanBinding2 = this.photosScanBinding;
        RelativeLayout relativeLayout2 = activityPhotosScanBinding2 != null ? activityPhotosScanBinding2.lay1 : null;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(View.GONE);
        }
        ActivityPhotosScanBinding activityPhotosScanBinding3 = this.photosScanBinding;
        RelativeLayout relativeLayout3 = activityPhotosScanBinding3 != null ? activityPhotosScanBinding3.lay2 : null;
        if (relativeLayout3 != null) {
            relativeLayout3.setVisibility(View.GONE);
        }
        ActivityPhotosScanBinding activityPhotosScanBinding4 = this.photosScanBinding;
        TextView textView = activityPhotosScanBinding4 != null ? activityPhotosScanBinding4.noOfItems : null;
        if (textView != null) {
            textView.setVisibility(View.GONE);
        }
        ActivityPhotosScanBinding activityPhotosScanBinding5 = this.photosScanBinding;
        TextView textView2 = activityPhotosScanBinding5 != null ? activityPhotosScanBinding5.itemPath : null;
        if (textView2 != null) {
            textView2.setVisibility(View.GONE);
        }
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new PhotosScanActivity$startPreparation$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startPhotoScan() {
        ActivityPhotosScanBinding activityPhotosScanBinding = this.photosScanBinding;
        if (activityPhotosScanBinding != null) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new PhotosScanActivity$startPhotoScan$1$1(activityPhotosScanBinding, this, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object calculateTotalFiles(File file, Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new PhotosScanActivity$calculateTotalFiles$2(file, this, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object scanForPhotos(File file, Continuation<? super List<? extends File>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new PhotosScanActivity$scanForPhotos$2(file, this, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isValidImage(File file) {
        if (file.isDirectory()) {
            return false;
        }
        String lowerCase = FilesKt.getExtension(file).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        try {
            String fileSignature = getFileSignature(file);
            if (CollectionsKt.listOf((Object[]) new String[]{"m4a", "mp3", "mp4", "wav"}).contains(lowerCase)) {
                return false;
            }
            if (!CollectionsKt.listOf((Object[]) new String[]{"heic", "jpg"}).contains(lowerCase) && !StringsKt.startsWith$default(fileSignature, "FFD8FFE0", false, 2, (Object) null) && !StringsKt.startsWith$default(fileSignature, "FFD8FFE1", false, 2, (Object) null) && !StringsKt.startsWith$default(fileSignature, "89504E47", false, 2, (Object) null) && !StringsKt.startsWith$default(fileSignature, "47494638", false, 2, (Object) null) && !StringsKt.startsWith$default(fileSignature, "424D", false, 2, (Object) null) && !StringsKt.startsWith$default(fileSignature, "52494646", false, 2, (Object) null) && !StringsKt.startsWith$default(fileSignature, "0000000C", false, 2, (Object) null)) {
                if (!StringsKt.startsWith$default(fileSignature, "0000001C", false, 2, (Object) null)) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isImageWithoutExtension(File file) {
        if (FilesKt.getExtension(file).length() > 0) {
            return false;
        }
        return isValidImage(file);
    }

    private final String getFileSignature(File file) {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            byte[] bArr = new byte[8];
            fileInputStream.read(bArr);
            String joinToString$default = ArraysKt.joinToString$default(bArr, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) new Function1<Byte, CharSequence>() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PhotosScanActivity$getFileSignature$1$1
                public final CharSequence invoke(byte b) {
                    String format = String.format("%02X", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                    return format;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ CharSequence invoke(Byte b) {
                    return invoke(b.byteValue());
                }
            }, 30, (Object) null);
            CloseableKt.closeFinally(fileInputStream, null);
            return joinToString$default;
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onScanComplete(List<? extends File> photoFiles) {
        SharedDataHolder.INSTANCE.setPhotoFiles(photoFiles);
        AdsClass.showInterstitial(this, new AdsClass.onListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PhotosScanActivity$$ExternalSyntheticLambda3
            @Override // com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass.onListener
            public final void click() {
                PhotosScanActivity.onScanComplete$lambda$3(PhotosScanActivity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onScanComplete$lambda$3(PhotosScanActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivity(new Intent(this$0, (Class<?>) PhotosAlbumActivity.class));
        this$0.finish();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.isScanning) {
            showExitConfirmationDialog();
        } else {
            super.onBackPressed();
        }
    }

    private final void showExitConfirmationDialog() {
        View inflate = getLayoutInflater().inflate(R.layout.dialog_scan_exit_alert, (ViewGroup) null);
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(inflate);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.iv_exit_btn);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.iv_cancel_btn);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PhotosScanActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhotosScanActivity.showExitConfirmationDialog$lambda$4(BottomSheetDialog.this, this, view);
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PhotosScanActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhotosScanActivity.showExitConfirmationDialog$lambda$5(BottomSheetDialog.this, view);
            }
        });
        bottomSheetDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showExitConfirmationDialog$lambda$4(BottomSheetDialog dialog, PhotosScanActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialog.dismiss();
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showExitConfirmationDialog$lambda$5(BottomSheetDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.photosScanBinding = null;
    }
}
