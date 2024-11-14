package com.gcs.recovery.videos.files.photo_recovery.activity;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

import org.objectweb.asm.Opcodes;

/* compiled from: VideoFilesActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.gcs.recovery.videos.files.photo_recovery.activity.VideoFilesActivity$onCreate$1", f = "VideoFilesActivity.kt", i = {}, l = {Opcodes.DUP_X2}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class VideoFilesActivity$onCreate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $albumPath;
    int label;
    final /* synthetic */ VideoFilesActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoFilesActivity$onCreate$1(VideoFilesActivity videoFilesActivity, String str, Continuation<? super VideoFilesActivity$onCreate$1> continuation) {
        super(2, continuation);
        this.this$0 = videoFilesActivity;
        this.$albumPath = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoFilesActivity$onCreate$1(this.this$0, this.$albumPath, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((VideoFilesActivity$onCreate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object loadAlbumPhotos;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            loadAlbumPhotos = this.this$0.loadAlbumPhotos(this.$albumPath, this);
            if (loadAlbumPhotos == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
