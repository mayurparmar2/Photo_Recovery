package com.gcs.recovery.videos.files.photo_recovery.activity;

import android.widget.RelativeLayout;
import android.widget.TextView;
import com.demo.example.databinding.ActivityPhotosScanBinding;
import com.google.android.exoplayer2.C;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;



/* compiled from: PhotosScanActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.gcs.recovery.videos.files.photo_recovery.activity.PhotosScanActivity$startPreparation$1", f = "PhotosScanActivity.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class PhotosScanActivity$startPreparation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PhotosScanActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PhotosScanActivity$startPreparation$1(PhotosScanActivity photosScanActivity, Continuation<? super PhotosScanActivity$startPreparation$1> continuation) {
        super(2, continuation);
        this.this$0 = photosScanActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PhotosScanActivity$startPreparation$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PhotosScanActivity$startPreparation$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ActivityPhotosScanBinding activityPhotosScanBinding;
        ActivityPhotosScanBinding activityPhotosScanBinding2;
        ActivityPhotosScanBinding activityPhotosScanBinding3;
        ActivityPhotosScanBinding activityPhotosScanBinding4;
        ActivityPhotosScanBinding activityPhotosScanBinding5;
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
        activityPhotosScanBinding = this.this$0.photosScanBinding;
        RelativeLayout relativeLayout = activityPhotosScanBinding != null ? activityPhotosScanBinding.preProgress : null;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(View.GONE);
        }
        activityPhotosScanBinding2 = this.this$0.photosScanBinding;
        RelativeLayout relativeLayout2 = activityPhotosScanBinding2 != null ? activityPhotosScanBinding2.lay1 : null;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(View.VISIBLE);
        }
        activityPhotosScanBinding3 = this.this$0.photosScanBinding;
        RelativeLayout relativeLayout3 = activityPhotosScanBinding3 != null ? activityPhotosScanBinding3.lay2 : null;
        if (relativeLayout3 != null) {
            relativeLayout3.setVisibility(View.VISIBLE);
        }
        activityPhotosScanBinding4 = this.this$0.photosScanBinding;
        TextView textView = activityPhotosScanBinding4 != null ? activityPhotosScanBinding4.noOfItems : null;
        if (textView != null) {
            textView.setVisibility(View.VISIBLE);
        }
        activityPhotosScanBinding5 = this.this$0.photosScanBinding;
        TextView textView2 = activityPhotosScanBinding5 != null ? activityPhotosScanBinding5.itemPath : null;
        if (textView2 != null) {
            textView2.setVisibility(View.VISIBLE);
        }
        this.this$0.startPhotoScan();
        return Unit.INSTANCE;
    }
}
