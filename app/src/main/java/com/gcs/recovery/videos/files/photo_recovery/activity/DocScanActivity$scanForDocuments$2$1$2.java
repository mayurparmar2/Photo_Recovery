package com.gcs.recovery.videos.files.photo_recovery.activity;

import com.demo.example.databinding.ActivityDocScanBinding;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;
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
@DebugMetadata(c = "com.gcs.recovery.videos.files.photo_recovery.activity.DocScanActivity$scanForDocuments$2$1$2", f = "DocScanActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class DocScanActivity$scanForDocuments$2$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DocScanActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DocScanActivity$scanForDocuments$2$1$2(DocScanActivity docScanActivity, Continuation<? super DocScanActivity$scanForDocuments$2$1$2> continuation) {
        super(2, continuation);
        this.this$0 = docScanActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DocScanActivity$scanForDocuments$2$1$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DocScanActivity$scanForDocuments$2$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int i;
        int i2;
        ActivityDocScanBinding activityDocScanBinding;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            i = this.this$0.scannedFiles;
            i2 = this.this$0.totalFiles;
            int i3 = (i * 100) / i2;
            activityDocScanBinding = this.this$0.docScanBinding;
            CircularProgressBar circularProgressBar = activityDocScanBinding != null ? activityDocScanBinding.storageProgress : null;
            if (circularProgressBar != null) {
                circularProgressBar.setProgress(i3);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
