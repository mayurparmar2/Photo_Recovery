package com.gcs.recovery.videos.files.photo_recovery.activity;

import android.widget.RelativeLayout;
import android.widget.TextView;
import com.demo.example.databinding.ActivityDocScanBinding;
import com.google.android.exoplayer2.C;
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
@DebugMetadata(c = "com.gcs.recovery.videos.files.photo_recovery.activity.DocScanActivity$startPreparation$1", f = "DocScanActivity.kt", i = {}, l = {54}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class DocScanActivity$startPreparation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DocScanActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DocScanActivity$startPreparation$1(DocScanActivity docScanActivity, Continuation<? super DocScanActivity$startPreparation$1> continuation) {
        super(2, continuation);
        this.this$0 = docScanActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DocScanActivity$startPreparation$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DocScanActivity$startPreparation$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ActivityDocScanBinding activityDocScanBinding;
        ActivityDocScanBinding activityDocScanBinding2;
        ActivityDocScanBinding activityDocScanBinding3;
        ActivityDocScanBinding activityDocScanBinding4;
        ActivityDocScanBinding activityDocScanBinding5;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        activityDocScanBinding = this.this$0.docScanBinding;
        RelativeLayout relativeLayout = activityDocScanBinding != null ? activityDocScanBinding.preProgress : null;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(View.GONE);
        }
        activityDocScanBinding2 = this.this$0.docScanBinding;
        RelativeLayout relativeLayout2 = activityDocScanBinding2 != null ? activityDocScanBinding2.lay1 : null;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(View.VISIBLE);
        }
        activityDocScanBinding3 = this.this$0.docScanBinding;
        RelativeLayout relativeLayout3 = activityDocScanBinding3 != null ? activityDocScanBinding3.lay2 : null;
        if (relativeLayout3 != null) {
            relativeLayout3.setVisibility(View.VISIBLE);
        }
        activityDocScanBinding4 = this.this$0.docScanBinding;
        TextView textView = activityDocScanBinding4 != null ? activityDocScanBinding4.noOfItems : null;
        if (textView != null) {
            textView.setVisibility(View.VISIBLE);
        }
        activityDocScanBinding5 = this.this$0.docScanBinding;
        TextView textView2 = activityDocScanBinding5 != null ? activityDocScanBinding5.itemPath : null;
        if (textView2 != null) {
            textView2.setVisibility(View.VISIBLE);
        }
        this.this$0.startDocsScan();
        return Unit.INSTANCE;
    }
}
