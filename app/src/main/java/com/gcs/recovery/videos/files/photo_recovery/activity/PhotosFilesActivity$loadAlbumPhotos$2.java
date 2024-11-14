package com.gcs.recovery.videos.files.photo_recovery.activity;

import com.airbnb.lottie.LottieAnimationView;
import com.demo.example.databinding.ActivityPhotosFilesBinding;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;


/* compiled from: PhotosFilesActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.gcs.recovery.videos.files.photo_recovery.activity.PhotosFilesActivity$loadAlbumPhotos$2", f = "PhotosFilesActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class PhotosFilesActivity$loadAlbumPhotos$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PhotosFilesActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PhotosFilesActivity$loadAlbumPhotos$2(PhotosFilesActivity photosFilesActivity, Continuation<? super PhotosFilesActivity$loadAlbumPhotos$2> continuation) {
        super(2, continuation);
        this.this$0 = photosFilesActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PhotosFilesActivity$loadAlbumPhotos$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PhotosFilesActivity$loadAlbumPhotos$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ActivityPhotosFilesBinding activityPhotosFilesBinding;
        ActivityPhotosFilesBinding activityPhotosFilesBinding2;
        LottieAnimationView lottieAnimationView;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            activityPhotosFilesBinding = this.this$0.photoFilesBinding;
            LottieAnimationView lottieAnimationView2 = activityPhotosFilesBinding != null ? activityPhotosFilesBinding.preLottie : null;
            if (lottieAnimationView2 != null) {
                lottieAnimationView2.setVisibility(View.VISIBLE);
            }
            activityPhotosFilesBinding2 = this.this$0.photoFilesBinding;
            if (activityPhotosFilesBinding2 == null || (lottieAnimationView = activityPhotosFilesBinding2.preLottie) == null) {
                return null;
            }
            lottieAnimationView.playAnimation();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
