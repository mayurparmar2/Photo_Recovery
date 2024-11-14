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
import com.demo.example.databinding.ActivityVideosScanBinding;
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




/* compiled from: VideosScanActivity.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0019\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0012H\u0014J\u0016\u0010\u0017\u001a\u00020\u00122\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u0019H\u0002J\u001f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u00192\u0006\u0010\f\u001a\u00020\rH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\b\u0010\u001b\u001a\u00020\u0012H\u0002J\b\u0010\u001c\u001a\u00020\u0012H\u0003J\b\u0010\u001d\u001a\u00020\u0012H\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/activity/VideosScanActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "foundFiles", "", "isScanning", "", "scannedFiles", "totalFiles", "videosScanBinding", "Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ActivityVideosScanBinding;", "calculateTotalFiles", "directory", "Ljava/io/File;", "(Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isValidVideo", ShareInternalUtility.STAGING_PARAM, "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onScanComplete", "videoFiles", "", "scanForVideos", "showExitConfirmationDialog", "startPreparation", "startVideoScan", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class VideosScanActivity extends AppCompatActivity {
    private int foundFiles;
    private boolean isScanning = true;
    private int scannedFiles;
    private int totalFiles;
    private ActivityVideosScanBinding videosScanBinding;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatImageView appCompatImageView;
        super.onCreate(savedInstanceState);
        ActivityVideosScanBinding inflate = ActivityVideosScanBinding.inflate(getLayoutInflater());
        this.videosScanBinding = inflate;
        Intrinsics.checkNotNull(inflate);
        setContentView(inflate.getRoot());
        AdsClass adsClass = new AdsClass();
        ActivityVideosScanBinding activityVideosScanBinding = this.videosScanBinding;
        Intrinsics.checkNotNull(activityVideosScanBinding);
        adsClass.refreshAd(activityVideosScanBinding.frameLayout, this, 0);
        ActivityVideosScanBinding activityVideosScanBinding2 = this.videosScanBinding;
        if (activityVideosScanBinding2 != null && (appCompatImageView = activityVideosScanBinding2.icBack) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.VideosScanActivity$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VideosScanActivity.onCreate$lambda$0(VideosScanActivity.this, view);
                }
            });
        }
        startPreparation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(VideosScanActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackPressed();
    }

    private final void startPreparation() {
        ActivityVideosScanBinding activityVideosScanBinding = this.videosScanBinding;
        RelativeLayout relativeLayout = activityVideosScanBinding != null ? activityVideosScanBinding.preProgress : null;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(View.VISIBLE);
        }
        ActivityVideosScanBinding activityVideosScanBinding2 = this.videosScanBinding;
        RelativeLayout relativeLayout2 = activityVideosScanBinding2 != null ? activityVideosScanBinding2.lay1 : null;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(View.GONE);
        }
        ActivityVideosScanBinding activityVideosScanBinding3 = this.videosScanBinding;
        RelativeLayout relativeLayout3 = activityVideosScanBinding3 != null ? activityVideosScanBinding3.lay2 : null;
        if (relativeLayout3 != null) {
            relativeLayout3.setVisibility(View.GONE);
        }
        ActivityVideosScanBinding activityVideosScanBinding4 = this.videosScanBinding;
        TextView textView = activityVideosScanBinding4 != null ? activityVideosScanBinding4.noOfItems : null;
        if (textView != null) {
            textView.setVisibility(View.GONE);
        }
        ActivityVideosScanBinding activityVideosScanBinding5 = this.videosScanBinding;
        TextView textView2 = activityVideosScanBinding5 != null ? activityVideosScanBinding5.itemPath : null;
        if (textView2 != null) {
            textView2.setVisibility(View.GONE);
        }
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new VideosScanActivity$startPreparation$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startVideoScan() {
        ActivityVideosScanBinding activityVideosScanBinding = this.videosScanBinding;
        if (activityVideosScanBinding != null) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new VideosScanActivity$startVideoScan$1$1(activityVideosScanBinding, this, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object calculateTotalFiles(File file, Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new VideosScanActivity$calculateTotalFiles$2(file, this, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object scanForVideos(File file, Continuation<? super List<? extends File>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new VideosScanActivity$scanForVideos$2(file, this, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isValidVideo(File file) {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            byte[] bArr = new byte[8];
            fileInputStream.read(bArr);
            String joinToString$default = ArraysKt.joinToString$default(bArr, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) new Function1<Byte, CharSequence>() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.VideosScanActivity$isValidVideo$header$1$1
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
            String lowerCase = FilesKt.getExtension(file).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            if (CollectionsKt.listOf((Object[]) new String[]{"m4a", "mp3", "heic", "webp", "jpg"}).contains(lowerCase)) {
                return false;
            }
            return StringsKt.startsWith$default(joinToString$default, "000001BA", false, 2, (Object) null) || StringsKt.startsWith$default(joinToString$default, "000001B3", false, 2, (Object) null) || StringsKt.startsWith$default(joinToString$default, "00000018", false, 2, (Object) null) || StringsKt.startsWith$default(joinToString$default, "00000020", false, 2, (Object) null) || StringsKt.startsWith$default(joinToString$default, "66747970", false, 2, (Object) null) || StringsKt.startsWith$default(joinToString$default, "1A45DFA3", false, 2, (Object) null) || (StringsKt.startsWith$default(joinToString$default, "52494646", false, 2, (Object) null) && StringsKt.equals(FilesKt.getExtension(file), "avi", true)) || StringsKt.startsWith$default(joinToString$default, "00000014", false, 2, (Object) null) || StringsKt.startsWith$default(joinToString$default, "464C5601", false, 2, (Object) null) || StringsKt.startsWith$default(joinToString$default, "3026B2758E66CF11", false, 2, (Object) null) || StringsKt.startsWith$default(joinToString$default, "0000001C", false, 2, (Object) null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(fileInputStream, th);
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onScanComplete(List<? extends File> videoFiles) {
        SharedDataHolder.INSTANCE.setVideoFiles(videoFiles);
        AdsClass.showInterstitial(this, new AdsClass.onListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.VideosScanActivity$$ExternalSyntheticLambda3
            @Override // com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass.onListener
            public final void click() {
                VideosScanActivity.onScanComplete$lambda$3(VideosScanActivity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onScanComplete$lambda$3(VideosScanActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivity(new Intent(this$0, (Class<?>) VideoAlbumActivity.class));
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
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.VideosScanActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideosScanActivity.showExitConfirmationDialog$lambda$4(BottomSheetDialog.this, this, view);
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.VideosScanActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideosScanActivity.showExitConfirmationDialog$lambda$5(BottomSheetDialog.this, view);
            }
        });
        bottomSheetDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showExitConfirmationDialog$lambda$4(BottomSheetDialog dialog, VideosScanActivity this$0, View view) {
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
        this.videosScanBinding = null;
    }
}
