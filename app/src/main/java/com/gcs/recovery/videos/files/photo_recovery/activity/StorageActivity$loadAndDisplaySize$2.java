package com.gcs.recovery.videos.files.photo_recovery.activity;

import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.gcs.recovery.videos.files.photo_recovery.utils.Utils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;


/* compiled from: StorageActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.gcs.recovery.videos.files.photo_recovery.activity.StorageActivity$loadAndDisplaySize$2", f = "StorageActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class StorageActivity$loadAndDisplaySize$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LottieAnimationView $animationView;
    final /* synthetic */ long $size;
    final /* synthetic */ TextView $textView;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StorageActivity$loadAndDisplaySize$2(TextView textView, long j, LottieAnimationView lottieAnimationView, Continuation<? super StorageActivity$loadAndDisplaySize$2> continuation) {
        super(2, continuation);
        this.$textView = textView;
        this.$size = j;
        this.$animationView = lottieAnimationView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StorageActivity$loadAndDisplaySize$2(this.$textView, this.$size, this.$animationView, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StorageActivity$loadAndDisplaySize$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$textView.setText(Utils.INSTANCE.formatSize(this.$size));
            LottieAnimationView lottieAnimationView = this.$animationView;
            if (lottieAnimationView != null) {
                lottieAnimationView.setVisibility(View.GONE);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
