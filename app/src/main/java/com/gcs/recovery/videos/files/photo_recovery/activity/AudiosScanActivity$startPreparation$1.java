package com.gcs.recovery.videos.files.photo_recovery.activity;

import android.widget.RelativeLayout;
import android.widget.TextView;
import com.demo.example.databinding.ActivityAudiosScanBinding;
import com.google.android.exoplayer2.C;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;



/* compiled from: AudiosScanActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.gcs.recovery.videos.files.photo_recovery.activity.AudiosScanActivity$startPreparation$1", f = "AudiosScanActivity.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class AudiosScanActivity$startPreparation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AudiosScanActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AudiosScanActivity$startPreparation$1(AudiosScanActivity audiosScanActivity, Continuation<? super AudiosScanActivity$startPreparation$1> continuation) {
        super(2, continuation);
        this.this$0 = audiosScanActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AudiosScanActivity$startPreparation$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AudiosScanActivity$startPreparation$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ActivityAudiosScanBinding activityAudiosScanBinding;
        ActivityAudiosScanBinding activityAudiosScanBinding2;
        ActivityAudiosScanBinding activityAudiosScanBinding3;
        ActivityAudiosScanBinding activityAudiosScanBinding4;
        ActivityAudiosScanBinding activityAudiosScanBinding5;
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
        activityAudiosScanBinding = this.this$0.audiosScanBinding;
        RelativeLayout relativeLayout = activityAudiosScanBinding != null ? activityAudiosScanBinding.preProgress : null;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(View.GONE);
        }
        activityAudiosScanBinding2 = this.this$0.audiosScanBinding;
        RelativeLayout relativeLayout2 = activityAudiosScanBinding2 != null ? activityAudiosScanBinding2.lay1 : null;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(View.VISIBLE);
        }
        activityAudiosScanBinding3 = this.this$0.audiosScanBinding;
        RelativeLayout relativeLayout3 = activityAudiosScanBinding3 != null ? activityAudiosScanBinding3.lay2 : null;
        if (relativeLayout3 != null) {
            relativeLayout3.setVisibility(View.VISIBLE);
        }
        activityAudiosScanBinding4 = this.this$0.audiosScanBinding;
        TextView textView = activityAudiosScanBinding4 != null ? activityAudiosScanBinding4.noOfItems : null;
        if (textView != null) {
            textView.setVisibility(View.VISIBLE);
        }
        activityAudiosScanBinding5 = this.this$0.audiosScanBinding;
        TextView textView2 = activityAudiosScanBinding5 != null ? activityAudiosScanBinding5.itemPath : null;
        if (textView2 != null) {
            textView2.setVisibility(View.VISIBLE);
        }
        this.this$0.startAudioScan();
        return Unit.INSTANCE;
    }
}
