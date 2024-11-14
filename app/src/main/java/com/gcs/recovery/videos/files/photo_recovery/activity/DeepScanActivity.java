package com.gcs.recovery.videos.files.photo_recovery.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.demo.example.R;
import com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass;
import com.demo.example.databinding.ActivityDeepScanBinding;
import com.gcs.recovery.videos.files.photo_recovery.utils.SharedDataHolder;
import com.gcs.recovery.videos.files.photo_recovery.utils.Utils;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;





/* compiled from: DeepScanActivity.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0019\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0014H\u0003J3\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u001b0\u001a2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0006H\u0083@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u0014H\u0002J\b\u0010\u001f\u001a\u00020\u0014H\u0003J \u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u0006H\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/activity/DeepScanActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "deepScanBinding", "Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ActivityDeepScanBinding;", "foundFiles", "", "isScanning", "", "junkFilesList", "", "", "scannedFiles", "totalJunkSize", "", "countFiles", "rootDir", "Ljava/io/File;", "(Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onScanComplete", "scanJunkFiles", "Lkotlin/Pair;", "", "totalFiles", "(Ljava/io/File;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showExitConfirmationDialog", "startDeepScan", "updateUI", "currentFilePath", "totalSize", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DeepScanActivity extends AppCompatActivity {
    private ActivityDeepScanBinding deepScanBinding;
    private int foundFiles;
    private boolean isScanning = true;
    private List<String> junkFilesList = new ArrayList();
    private int scannedFiles;
    private long totalJunkSize;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDeepScanBinding inflate = ActivityDeepScanBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.deepScanBinding = inflate;
        ActivityDeepScanBinding activityDeepScanBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepScanBinding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        AdsClass adsClass = new AdsClass();
        ActivityDeepScanBinding activityDeepScanBinding2 = this.deepScanBinding;
        if (activityDeepScanBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepScanBinding");
            activityDeepScanBinding2 = null;
        }
        adsClass.refreshAd(activityDeepScanBinding2.frameLayout, this, 0);
        ActivityDeepScanBinding activityDeepScanBinding3 = this.deepScanBinding;
        if (activityDeepScanBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepScanBinding");
        } else {
            activityDeepScanBinding = activityDeepScanBinding3;
        }
        activityDeepScanBinding.icBack.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DeepScanActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeepScanActivity.onCreate$lambda$0(DeepScanActivity.this, view);
            }
        });
        startDeepScan();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(DeepScanActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackPressed();
    }

    private final void startDeepScan() {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DeepScanActivity$startDeepScan$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object countFiles(File file, Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new DeepScanActivity$countFiles$2(file, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object scanJunkFiles(File file, int i, Continuation<? super Pair<Long, ? extends List<String>>> continuation) {
        DeepScanActivity$scanJunkFiles$1 deepScanActivity$scanJunkFiles$1;
        int i2;
        Ref.LongRef longRef;
        List list;
        if (continuation instanceof DeepScanActivity$scanJunkFiles$1) {
            deepScanActivity$scanJunkFiles$1 = (DeepScanActivity$scanJunkFiles$1) continuation;
            if ((deepScanActivity$scanJunkFiles$1.label & Integer.MIN_VALUE) != 0) {
                deepScanActivity$scanJunkFiles$1.label -= Integer.MIN_VALUE;
                Object obj = deepScanActivity$scanJunkFiles$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = deepScanActivity$scanJunkFiles$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref.LongRef longRef2 = new Ref.LongRef();
                    ArrayList arrayList = new ArrayList();
                    CoroutineDispatcher io = Dispatchers.getIO();
                    DeepScanActivity$scanJunkFiles$2 deepScanActivity$scanJunkFiles$2 = new DeepScanActivity$scanJunkFiles$2(file, this, longRef2, arrayList, i, null);
                    deepScanActivity$scanJunkFiles$1.L$0 = longRef2;
                    deepScanActivity$scanJunkFiles$1.L$1 = arrayList;
                    deepScanActivity$scanJunkFiles$1.label = 1;
                    if (BuildersKt.withContext(io, deepScanActivity$scanJunkFiles$2, deepScanActivity$scanJunkFiles$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    longRef = longRef2;
                    list = arrayList;
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    list = (List) deepScanActivity$scanJunkFiles$1.L$1;
                    longRef = (Ref.LongRef) deepScanActivity$scanJunkFiles$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return new Pair(Boxing.boxLong(longRef.element), list);
            }
        }
        deepScanActivity$scanJunkFiles$1 = new DeepScanActivity$scanJunkFiles$1(this, continuation);
        Object obj2 = deepScanActivity$scanJunkFiles$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = deepScanActivity$scanJunkFiles$1.label;
        if (i2 != 0) {
        }
        return new Pair(Boxing.boxLong(longRef.element), list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateUI(String currentFilePath, long totalSize, int totalFiles) {
        ActivityDeepScanBinding activityDeepScanBinding = this.deepScanBinding;
        ActivityDeepScanBinding activityDeepScanBinding2 = null;
        if (activityDeepScanBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepScanBinding");
            activityDeepScanBinding = null;
        }
        activityDeepScanBinding.itemPath.setText(currentFilePath);
        ActivityDeepScanBinding activityDeepScanBinding3 = this.deepScanBinding;
        if (activityDeepScanBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepScanBinding");
            activityDeepScanBinding3 = null;
        }
        activityDeepScanBinding3.junkSize.setText(Utils.INSTANCE.formatSize(totalSize) + " : Size Found");
        ActivityDeepScanBinding activityDeepScanBinding4 = this.deepScanBinding;
        if (activityDeepScanBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deepScanBinding");
        } else {
            activityDeepScanBinding2 = activityDeepScanBinding4;
        }
        activityDeepScanBinding2.storageProgress.setProgress(RangesKt.coerceAtMost((this.scannedFiles / totalFiles) * 100, 100.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onScanComplete() {
        SharedDataHolder.INSTANCE.setJunkFilesList(this.junkFilesList);
        SharedDataHolder.INSTANCE.setTotalJunkSize(this.totalJunkSize);
        AdsClass.showInterstitial(this, new AdsClass.onListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DeepScanActivity$$ExternalSyntheticLambda1
            @Override // com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass.onListener
            public final void click() {
                DeepScanActivity.onScanComplete$lambda$1(DeepScanActivity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onScanComplete$lambda$1(DeepScanActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivity(new Intent(this$0, (Class<?>) DeepScanFileActivity.class));
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
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DeepScanActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeepScanActivity.showExitConfirmationDialog$lambda$3(DeepScanActivity.this, bottomSheetDialog, view);
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DeepScanActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeepScanActivity.showExitConfirmationDialog$lambda$4(BottomSheetDialog.this, view);
            }
        });
        bottomSheetDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showExitConfirmationDialog$lambda$3(final DeepScanActivity this$0, final BottomSheetDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        AdsClass.showInterstitial(this$0, new AdsClass.onListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DeepScanActivity$$ExternalSyntheticLambda2
            @Override // com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass.onListener
            public final void click() {
                DeepScanActivity.showExitConfirmationDialog$lambda$3$lambda$2(BottomSheetDialog.this, this$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showExitConfirmationDialog$lambda$3$lambda$2(BottomSheetDialog dialog, DeepScanActivity this$0) {
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
}
