package com.gcs.recovery.videos.files.photo_recovery.activity;

import android.widget.TextView;
import com.demo.example.databinding.ActivityVideosScanBinding;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;
import java.io.File;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;



import org.objectweb.asm.Opcodes;

/* compiled from: VideosScanActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.gcs.recovery.videos.files.photo_recovery.activity.VideosScanActivity$scanForVideos$2$1$1", f = "VideosScanActivity.kt", i = {}, l = {111, Opcodes.LNEG, 124}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class VideosScanActivity$scanForVideos$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
    final /* synthetic */ File $file;
    final /* synthetic */ List<File> $videoFiles;
    Object L$0;
    int label;
    final /* synthetic */ VideosScanActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideosScanActivity$scanForVideos$2$1$1(VideosScanActivity videosScanActivity, File file, List<File> list, Continuation<? super VideosScanActivity$scanForVideos$2$1$1> continuation) {
        super(2, continuation);
        this.this$0 = videosScanActivity;
        this.$file = file;
        this.$videoFiles = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideosScanActivity$scanForVideos$2$1$1(this.this$0, this.$file, this.$videoFiles, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Object> continuation) {
        return invoke2(coroutineScope, (Continuation<Object>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<Object> continuation) {
        return ((VideosScanActivity$scanForVideos$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int i;
        boolean isValidVideo;
        int i2;
        Object scanForVideos;
        List<File> list;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                list = (List) this.L$0;
                ResultKt.throwOnFailure(obj);
                return Boxing.boxBoolean(list.addAll((Collection) obj));
            }
            if (i3 == 2) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            if (i3 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        VideosScanActivity videosScanActivity = this.this$0;
        i = videosScanActivity.scannedFiles;
        videosScanActivity.scannedFiles = i + 1;
        if (this.$file.isDirectory()) {
            List<File> list2 = this.$videoFiles;
            VideosScanActivity videosScanActivity2 = this.this$0;
            File file = this.$file;
            Intrinsics.checkNotNullExpressionValue(file, "$file");
            this.L$0 = list2;
            this.label = 1;
            scanForVideos = videosScanActivity2.scanForVideos(file, this);
            if (scanForVideos == coroutine_suspended) {
                return coroutine_suspended;
            }
            list = list2;
            obj = scanForVideos;
            return Boxing.boxBoolean(list.addAll((Collection) obj));
        }
        VideosScanActivity videosScanActivity3 = this.this$0;
        File file2 = this.$file;
        Intrinsics.checkNotNullExpressionValue(file2, "$file");
        isValidVideo = videosScanActivity3.isValidVideo(file2);
        if (isValidVideo) {
            List<File> list3 = this.$videoFiles;
            File file3 = this.$file;
            synchronized (list3) {
                Intrinsics.checkNotNull(file3);
                list3.add(file3);
            }
            VideosScanActivity videosScanActivity4 = this.this$0;
            i2 = videosScanActivity4.foundFiles;
            videosScanActivity4.foundFiles = i2 + 1;
            this.label = 2;
            if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(this.this$0, this.$file, null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
        this.label = 3;
        if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass3(this.this$0, null), this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    /* compiled from: VideosScanActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.gcs.recovery.videos.files.photo_recovery.activity.VideosScanActivity$scanForVideos$2$1$1$2", f = "VideosScanActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.gcs.recovery.videos.files.photo_recovery.activity.VideosScanActivity$scanForVideos$2$1$1$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ File $file;
        int label;
        final /* synthetic */ VideosScanActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(VideosScanActivity videosScanActivity, File file, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = videosScanActivity;
            this.$file = file;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, this.$file, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int i;
            int i2;
            ActivityVideosScanBinding activityVideosScanBinding;
            ActivityVideosScanBinding activityVideosScanBinding2;
            ActivityVideosScanBinding activityVideosScanBinding3;
            int i3;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                i = this.this$0.scannedFiles;
                i2 = this.this$0.totalFiles;
                int i4 = (i * 100) / i2;
                activityVideosScanBinding = this.this$0.videosScanBinding;
                CircularProgressBar circularProgressBar = activityVideosScanBinding != null ? activityVideosScanBinding.storageProgress : null;
                if (circularProgressBar != null) {
                    circularProgressBar.setProgress(i4);
                }
                activityVideosScanBinding2 = this.this$0.videosScanBinding;
                TextView textView = activityVideosScanBinding2 != null ? activityVideosScanBinding2.noOfItems : null;
                if (textView != null) {
                    StringBuilder sb = new StringBuilder();
                    i3 = this.this$0.foundFiles;
                    textView.setText(sb.append(i3).append(" Items found").toString());
                }
                activityVideosScanBinding3 = this.this$0.videosScanBinding;
                TextView textView2 = activityVideosScanBinding3 != null ? activityVideosScanBinding3.itemPath : null;
                if (textView2 != null) {
                    textView2.setText(this.$file.getAbsolutePath());
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: VideosScanActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.gcs.recovery.videos.files.photo_recovery.activity.VideosScanActivity$scanForVideos$2$1$1$3", f = "VideosScanActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.gcs.recovery.videos.files.photo_recovery.activity.VideosScanActivity$scanForVideos$2$1$1$3, reason: invalid class name */
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ VideosScanActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(VideosScanActivity videosScanActivity, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.this$0 = videosScanActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int i;
            int i2;
            ActivityVideosScanBinding activityVideosScanBinding;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                i = this.this$0.scannedFiles;
                i2 = this.this$0.totalFiles;
                int i3 = (i * 100) / i2;
                activityVideosScanBinding = this.this$0.videosScanBinding;
                CircularProgressBar circularProgressBar = activityVideosScanBinding != null ? activityVideosScanBinding.storageProgress : null;
                if (circularProgressBar != null) {
                    circularProgressBar.setProgress(i3);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
