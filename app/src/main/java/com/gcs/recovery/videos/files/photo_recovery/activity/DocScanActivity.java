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
import com.demo.example.databinding.ActivityDocScanBinding;
import com.gcs.recovery.videos.files.photo_recovery.utils.SharedDataHolder;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;




/* compiled from: DocScanActivity.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0019\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0012H\u0014J\u0016\u0010\u0017\u001a\u00020\u00122\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u0019H\u0002J\u001f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u00192\u0006\u0010\f\u001a\u00020\rH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\b\u0010\u001b\u001a\u00020\u0012H\u0002J\b\u0010\u001c\u001a\u00020\u0012H\u0003J\b\u0010\u001d\u001a\u00020\u0012H\u0003R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/activity/DocScanActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "docScanBinding", "Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ActivityDocScanBinding;", "foundFiles", "", "isScanning", "", "scannedFiles", "totalFiles", "calculateTotalFiles", "directory", "Ljava/io/File;", "(Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isDocumentFileWithoutExtension", ShareInternalUtility.STAGING_PARAM, "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onScanComplete", "docFiles", "", "scanForDocuments", "showExitConfirmationDialog", "startDocsScan", "startPreparation", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DocScanActivity extends AppCompatActivity {
    private ActivityDocScanBinding docScanBinding;
    private int foundFiles;
    private boolean isScanning = true;
    private int scannedFiles;
    private int totalFiles;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatImageView appCompatImageView;
        super.onCreate(savedInstanceState);
        ActivityDocScanBinding inflate = ActivityDocScanBinding.inflate(getLayoutInflater());
        this.docScanBinding = inflate;
        Intrinsics.checkNotNull(inflate);
        setContentView(inflate.getRoot());
        AdsClass adsClass = new AdsClass();
        ActivityDocScanBinding activityDocScanBinding = this.docScanBinding;
        Intrinsics.checkNotNull(activityDocScanBinding);
        adsClass.refreshAd(activityDocScanBinding.frameLayout, this, 0);
        ActivityDocScanBinding activityDocScanBinding2 = this.docScanBinding;
        if (activityDocScanBinding2 != null && (appCompatImageView = activityDocScanBinding2.icBack) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DocScanActivity$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DocScanActivity.onCreate$lambda$0(DocScanActivity.this, view);
                }
            });
        }
        startPreparation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(DocScanActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackPressed();
    }

    private final void startPreparation() {
        ActivityDocScanBinding activityDocScanBinding = this.docScanBinding;
        RelativeLayout relativeLayout = activityDocScanBinding != null ? activityDocScanBinding.preProgress : null;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(View.VISIBLE);
        }
        ActivityDocScanBinding activityDocScanBinding2 = this.docScanBinding;
        RelativeLayout relativeLayout2 = activityDocScanBinding2 != null ? activityDocScanBinding2.lay1 : null;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(View.GONE);
        }
        ActivityDocScanBinding activityDocScanBinding3 = this.docScanBinding;
        RelativeLayout relativeLayout3 = activityDocScanBinding3 != null ? activityDocScanBinding3.lay2 : null;
        if (relativeLayout3 != null) {
            relativeLayout3.setVisibility(View.GONE);
        }
        ActivityDocScanBinding activityDocScanBinding4 = this.docScanBinding;
        TextView textView = activityDocScanBinding4 != null ? activityDocScanBinding4.noOfItems : null;
        if (textView != null) {
            textView.setVisibility(View.GONE);
        }
        ActivityDocScanBinding activityDocScanBinding5 = this.docScanBinding;
        TextView textView2 = activityDocScanBinding5 != null ? activityDocScanBinding5.itemPath : null;
        if (textView2 != null) {
            textView2.setVisibility(View.GONE);
        }
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DocScanActivity$startPreparation$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startDocsScan() {
        ActivityDocScanBinding activityDocScanBinding = this.docScanBinding;
        if (activityDocScanBinding != null) {
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DocScanActivity$startDocsScan$1$1(activityDocScanBinding, this, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object calculateTotalFiles(File file, Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new DocScanActivity$calculateTotalFiles$2(file, this, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object scanForDocuments(File file, Continuation<? super List<? extends File>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new DocScanActivity$scanForDocuments$2(file, this, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isDocumentFileWithoutExtension(File file) {
        byte[] bArr = new byte[8];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                fileInputStream.read(bArr);
                CloseableKt.closeFinally(fileInputStream, null);
                String joinToString$default = ArraysKt.joinToString$default(bArr, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) new Function1<Byte, CharSequence>() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DocScanActivity$isDocumentFileWithoutExtension$header$1
                    public final CharSequence invoke(byte b) {
                        String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                        return format;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ CharSequence invoke(Byte b) {
                        return invoke(b.byteValue());
                    }
                }, 30, (Object) null);
                if (!StringsKt.startsWith$default(joinToString$default, "25504446", false, 2, (Object) null) && !StringsKt.startsWith$default(joinToString$default, "D0CF11E0", false, 2, (Object) null) && !StringsKt.startsWith$default(joinToString$default, "504B0304", false, 2, (Object) null) && !StringsKt.startsWith$default(joinToString$default, "504b030400000000", false, 2, (Object) null) && !StringsKt.startsWith$default(joinToString$default, "504b030414000808", false, 2, (Object) null) && !StringsKt.startsWith$default(joinToString$default, "52617221", false, 2, (Object) null) && !StringsKt.startsWith$default(joinToString$default, "504B0708", false, 2, (Object) null) && !StringsKt.startsWith$default(joinToString$default, "504B0506", false, 2, (Object) null) && !StringsKt.startsWith$default(joinToString$default, "504B4C49", false, 2, (Object) null) && !StringsKt.startsWith$default(joinToString$default, "504B5370", false, 2, (Object) null) && !StringsKt.startsWith$default(joinToString$default, "7F454C46", false, 2, (Object) null) && !StringsKt.startsWith$default(joinToString$default, "3C21444F", false, 2, (Object) null) && !StringsKt.startsWith$default(joinToString$default, "3C68746D", false, 2, (Object) null) && !StringsKt.startsWith$default(joinToString$default, "3C48544D", false, 2, (Object) null) && !StringsKt.startsWith$default(joinToString$default, "3C3F786D", false, 2, (Object) null) && !StringsKt.startsWith$default(joinToString$default, "EFBBBF3C", false, 2, (Object) null) && !StringsKt.startsWith$default(joinToString$default, "FFFE3C00", false, 2, (Object) null) && !StringsKt.startsWith$default(joinToString$default, "FEFF003C", false, 2, (Object) null) && !StringsKt.startsWith$default(joinToString$default, "00000100", false, 2, (Object) null)) {
                    return false;
                }
                return true;
            } finally {
            }
        } catch (IOException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onScanComplete(List<? extends File> docFiles) {
        SharedDataHolder.INSTANCE.setDocFiles(docFiles);
        AdsClass.showInterstitial(this, new AdsClass.onListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DocScanActivity$$ExternalSyntheticLambda2
            @Override // com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass.onListener
            public final void click() {
                DocScanActivity.onScanComplete$lambda$3(DocScanActivity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onScanComplete$lambda$3(DocScanActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivity(new Intent(this$0, (Class<?>) DocsAlbumActivity.class));
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
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DocScanActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DocScanActivity.showExitConfirmationDialog$lambda$4(BottomSheetDialog.this, this, view);
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DocScanActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DocScanActivity.showExitConfirmationDialog$lambda$5(BottomSheetDialog.this, view);
            }
        });
        bottomSheetDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showExitConfirmationDialog$lambda$4(BottomSheetDialog dialog, DocScanActivity this$0, View view) {
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
        this.docScanBinding = null;
    }
}
