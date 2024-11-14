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
import com.demo.example.R;
import com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass;
import com.demo.example.databinding.ActivityAudiosScanBinding;
import com.gcs.recovery.videos.files.photo_recovery.utils.SharedDataHolder;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;




/* compiled from: AudiosScanActivity.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0019\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0010H\u0014J\u0016\u0010\u0015\u001a\u00020\u00102\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u0017H\u0002J\u001f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u00172\u0006\u0010\f\u001a\u00020\rH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\b\u0010\u0019\u001a\u00020\u0010H\u0002J\b\u0010\u001a\u001a\u00020\u0010H\u0003J\b\u0010\u001b\u001a\u00020\u0010H\u0003R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/activity/AudiosScanActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "audiosScanBinding", "Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ActivityAudiosScanBinding;", "foundFiles", "", "isScanning", "", "scannedFiles", "totalFiles", "calculateTotalFiles", "directory", "Ljava/io/File;", "(Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onScanComplete", "audioFiles", "", "scanForAudios", "showExitConfirmationDialog", "startAudioScan", "startPreparation", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AudiosScanActivity extends AppCompatActivity {
    private ActivityAudiosScanBinding audiosScanBinding;
    private int foundFiles;
    private boolean isScanning = true;
    private int scannedFiles;
    private int totalFiles;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatImageView appCompatImageView;
        super.onCreate(savedInstanceState);
        ActivityAudiosScanBinding inflate = ActivityAudiosScanBinding.inflate(getLayoutInflater());
        this.audiosScanBinding = inflate;
        Intrinsics.checkNotNull(inflate);
        setContentView(inflate.getRoot());
        startPreparation();
        AdsClass adsClass = new AdsClass();
        ActivityAudiosScanBinding activityAudiosScanBinding = this.audiosScanBinding;
        Intrinsics.checkNotNull(activityAudiosScanBinding);
        adsClass.refreshAd(activityAudiosScanBinding.frameLayout, this, 0);
        ActivityAudiosScanBinding activityAudiosScanBinding2 = this.audiosScanBinding;
        if (activityAudiosScanBinding2 == null || (appCompatImageView = activityAudiosScanBinding2.icBack) == null) {
            return;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.AudiosScanActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudiosScanActivity.onCreate$lambda$0(AudiosScanActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(AudiosScanActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackPressed();
    }

    private final void startPreparation() {
        ActivityAudiosScanBinding activityAudiosScanBinding = this.audiosScanBinding;
        RelativeLayout relativeLayout = activityAudiosScanBinding != null ? activityAudiosScanBinding.preProgress : null;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(View.VISIBLE);
        }
        ActivityAudiosScanBinding activityAudiosScanBinding2 = this.audiosScanBinding;
        RelativeLayout relativeLayout2 = activityAudiosScanBinding2 != null ? activityAudiosScanBinding2.lay1 : null;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(View.GONE);
        }
        ActivityAudiosScanBinding activityAudiosScanBinding3 = this.audiosScanBinding;
        RelativeLayout relativeLayout3 = activityAudiosScanBinding3 != null ? activityAudiosScanBinding3.lay2 : null;
        if (relativeLayout3 != null) {
            relativeLayout3.setVisibility(View.GONE);
        }
        ActivityAudiosScanBinding activityAudiosScanBinding4 = this.audiosScanBinding;
        TextView textView = activityAudiosScanBinding4 != null ? activityAudiosScanBinding4.noOfItems : null;
        if (textView != null) {
            textView.setVisibility(View.GONE);
        }
        ActivityAudiosScanBinding activityAudiosScanBinding5 = this.audiosScanBinding;
        TextView textView2 = activityAudiosScanBinding5 != null ? activityAudiosScanBinding5.itemPath : null;
        if (textView2 != null) {
            textView2.setVisibility(View.GONE);
        }
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AudiosScanActivity$startPreparation$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startAudioScan() {
        ActivityAudiosScanBinding activityAudiosScanBinding = this.audiosScanBinding;
        if (activityAudiosScanBinding != null) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AudiosScanActivity$startAudioScan$1$1(activityAudiosScanBinding, this, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object scanForAudios(File file, Continuation<? super List<? extends File>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AudiosScanActivity$scanForAudios$2(file, this, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object calculateTotalFiles(File file, Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AudiosScanActivity$calculateTotalFiles$2(file, this, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onScanComplete(List<? extends File> audioFiles) {
        SharedDataHolder.INSTANCE.setAudioFiles(audioFiles);
        AdsClass.showInterstitial(this, new AdsClass.onListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.AudiosScanActivity$$ExternalSyntheticLambda0
            @Override // com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass.onListener
            public final void click() {
                AudiosScanActivity.onScanComplete$lambda$2(AudiosScanActivity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onScanComplete$lambda$2(AudiosScanActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivity(new Intent(this$0, (Class<?>) AudiosAlbumActivity.class));
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
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.AudiosScanActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudiosScanActivity.showExitConfirmationDialog$lambda$3(BottomSheetDialog.this, this, view);
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.AudiosScanActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudiosScanActivity.showExitConfirmationDialog$lambda$4(BottomSheetDialog.this, view);
            }
        });
        bottomSheetDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showExitConfirmationDialog$lambda$3(BottomSheetDialog dialog, AudiosScanActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialog.dismiss();
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showExitConfirmationDialog$lambda$4(BottomSheetDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.audiosScanBinding = null;
    }
}
