package com.gcs.recovery.videos.files.photo_recovery.activity;

import com.demo.example.databinding.ActivityDocScanBinding;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.encoding.Base64;
import kotlin.jvm.functions.Function2;

import org.objectweb.asm.TypeReference;

/* compiled from: DocScanActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.gcs.recovery.videos.files.photo_recovery.activity.DocScanActivity$startDocsScan$1$1", f = "DocScanActivity.kt", i = {}, l = {TypeReference.CONSTRUCTOR_REFERENCE_TYPE_ARGUMENT, Base64.mimeLineLength}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class DocScanActivity$startDocsScan$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ActivityDocScanBinding $binding;
    Object L$0;
    int label;
    final /* synthetic */ DocScanActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DocScanActivity$startDocsScan$1$1(ActivityDocScanBinding activityDocScanBinding, DocScanActivity docScanActivity, Continuation<? super DocScanActivity$startDocsScan$1$1> continuation) {
        super(2, continuation);
        this.$binding = activityDocScanBinding;
        this.this$0 = docScanActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DocScanActivity$startDocsScan$1$1(this.$binding, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DocScanActivity$startDocsScan$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DocScanActivity docScanActivity;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.$binding.storageProgress.setProgress(0.0f);
            this.$binding.noOfItems.setText("0 Items found");
            this.$binding.scanTxt.setText("Scanning...");
            this.$binding.progressCircular.playAnimation();
            docScanActivity = this.this$0;
            this.L$0 = docScanActivity;
            this.label = 1;
            obj = docScanActivity.calculateTotalFiles(new File("/storage/emulated/0/"), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$binding.progressCircular.cancelAnimation();
                this.$binding.scanTxt.setText("Scan Complete");
                this.$binding.storageProgress.setProgress(100.0f);
                this.this$0.onScanComplete((List) obj);
                return Unit.INSTANCE;
            }
            docScanActivity = (DocScanActivity) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        docScanActivity.totalFiles = ((Number) obj).intValue();
        this.L$0 = null;
        this.label = 2;
        obj = this.this$0.scanForDocuments(new File("/storage/emulated/0/"), this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        this.$binding.progressCircular.cancelAnimation();
        this.$binding.scanTxt.setText("Scan Complete");
        this.$binding.storageProgress.setProgress(100.0f);
        this.this$0.onScanComplete((List) obj);
        return Unit.INSTANCE;
    }
}
