package com.gcs.recovery.videos.files.photo_recovery.activity;

import android.widget.TextView;
import com.demo.example.databinding.ActivityDocScanBinding;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;


/* compiled from: DocScanActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.gcs.recovery.videos.files.photo_recovery.activity.DocScanActivity$scanForDocuments$2$1$1", f = "DocScanActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class DocScanActivity$scanForDocuments$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ File $file;
    int label;
    final /* synthetic */ DocScanActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DocScanActivity$scanForDocuments$2$1$1(DocScanActivity docScanActivity, File file, Continuation<? super DocScanActivity$scanForDocuments$2$1$1> continuation) {
        super(2, continuation);
        this.this$0 = docScanActivity;
        this.$file = file;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DocScanActivity$scanForDocuments$2$1$1(this.this$0, this.$file, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DocScanActivity$scanForDocuments$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int i;
        int i2;
        ActivityDocScanBinding activityDocScanBinding;
        ActivityDocScanBinding activityDocScanBinding2;
        ActivityDocScanBinding activityDocScanBinding3;
        int i3;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            i = this.this$0.scannedFiles;
            i2 = this.this$0.totalFiles;
            int i4 = (i * 100) / i2;
            activityDocScanBinding = this.this$0.docScanBinding;
            CircularProgressBar circularProgressBar = activityDocScanBinding != null ? activityDocScanBinding.storageProgress : null;
            if (circularProgressBar != null) {
                circularProgressBar.setProgress(i4);
            }
            activityDocScanBinding2 = this.this$0.docScanBinding;
            TextView textView = activityDocScanBinding2 != null ? activityDocScanBinding2.noOfItems : null;
            if (textView != null) {
                StringBuilder sb = new StringBuilder();
                i3 = this.this$0.foundFiles;
                textView.setText(sb.append(i3).append(" Items found").toString());
            }
            activityDocScanBinding3 = this.this$0.docScanBinding;
            TextView textView2 = activityDocScanBinding3 != null ? activityDocScanBinding3.itemPath : null;
            if (textView2 != null) {
                textView2.setText(this.$file.getAbsolutePath());
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
