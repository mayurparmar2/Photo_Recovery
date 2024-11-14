package com.gcs.recovery.videos.files.photo_recovery.activity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;





/* compiled from: VideosScanActivity.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.gcs.recovery.videos.files.photo_recovery.activity.VideosScanActivity$scanForVideos$2", f = "VideosScanActivity.kt", i = {0}, l = {130}, m = "invokeSuspend", n = {"videoFiles"}, s = {"L$0"})
/* loaded from: classes2.dex */
final class VideosScanActivity$scanForVideos$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<File>>, Object> {
    final /* synthetic */ File $directory;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ VideosScanActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideosScanActivity$scanForVideos$2(File file, VideosScanActivity videosScanActivity, Continuation<? super VideosScanActivity$scanForVideos$2> continuation) {
        super(2, continuation);
        this.$directory = file;
        this.this$0 = videosScanActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        VideosScanActivity$scanForVideos$2 videosScanActivity$scanForVideos$2 = new VideosScanActivity$scanForVideos$2(this.$directory, this.this$0, continuation);
        videosScanActivity$scanForVideos$2.L$0 = obj;
        return videosScanActivity$scanForVideos$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<File>> continuation) {
        return ((VideosScanActivity$scanForVideos$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List list;
        Deferred async$default;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            list = (List) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            ArrayList arrayList = new ArrayList();
            File[] listFiles = this.$directory.listFiles();
            if (listFiles == null) {
                return arrayList;
            }
            VideosScanActivity videosScanActivity = this.this$0;
            ArrayList arrayList2 = new ArrayList(listFiles.length);
            for (File file : listFiles) {
                async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new VideosScanActivity$scanForVideos$2$1$1(videosScanActivity, file, arrayList, null), 3, null);
                arrayList2.add(async$default);
            }
            this.L$0 = arrayList;
            this.label = 1;
            obj = AwaitKt.awaitAll(arrayList2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            list = arrayList;
        }
        return list;
    }
}
