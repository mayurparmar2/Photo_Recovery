package com.gcs.recovery.videos.files.photo_recovery.activity;

import com.airbnb.lottie.LottieAnimationView;
import com.gcs.recovery.videos.files.photo_recovery.adapter.VideosAdapter;
import com.demo.example.databinding.ActivityVideoFilesBinding;
import com.gcs.recovery.videos.files.photo_recovery.utils.SharedDataHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;



import org.objectweb.asm.Opcodes;

/* compiled from: VideoFilesActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.gcs.recovery.videos.files.photo_recovery.activity.VideoFilesActivity$loadAlbumPhotos$3", f = "VideoFilesActivity.kt", i = {}, l = {128, 129, 130, Opcodes.LXOR, 134}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class VideoFilesActivity$loadAlbumPhotos$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $albumPath;
    Object L$0;
    int label;
    final /* synthetic */ VideoFilesActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoFilesActivity$loadAlbumPhotos$3(VideoFilesActivity videoFilesActivity, String str, Continuation<? super VideoFilesActivity$loadAlbumPhotos$3> continuation) {
        super(2, continuation);
        this.this$0 = videoFilesActivity;
        this.$albumPath = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoFilesActivity$loadAlbumPhotos$3(this.this$0, this.$albumPath, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((VideoFilesActivity$loadAlbumPhotos$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        VideoFilesActivity videoFilesActivity;
        List emptyList;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            videoFilesActivity = this.this$0;
            String str = this.$albumPath;
            if (str != null) {
                switch (str.hashCode()) {
                    case -1943631987:
                        if (str.equals("HIDDEN_VIDEOS")) {
                            VideoFilesActivity videoFilesActivity2 = this.this$0;
                            List<String> hiddenVideoPaths = SharedDataHolder.INSTANCE.getHiddenVideoPaths();
                            if (hiddenVideoPaths == null) {
                                hiddenVideoPaths = CollectionsKt.emptyList();
                            }
                            this.L$0 = videoFilesActivity;
                            this.label = 3;
                            obj = videoFilesActivity2.fetchAllVideos(hiddenVideoPaths, this);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            emptyList = (List) obj;
                            break;
                        }
                        break;
                    case -758758767:
                        if (str.equals("DELETED_FILES")) {
                            VideoFilesActivity videoFilesActivity3 = this.this$0;
                            List<String> allVideoPaths = SharedDataHolder.INSTANCE.getAllVideoPaths();
                            if (allVideoPaths == null) {
                                allVideoPaths = CollectionsKt.emptyList();
                            }
                            this.L$0 = videoFilesActivity;
                            this.label = 4;
                            obj = videoFilesActivity3.fetchAllVideos(allVideoPaths, this);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            emptyList = (List) obj;
                            break;
                        }
                        break;
                    case 438660054:
                        if (str.equals("ALL_VIDEOS")) {
                            VideoFilesActivity videoFilesActivity4 = this.this$0;
                            List<String> allVideoPaths2 = SharedDataHolder.INSTANCE.getAllVideoPaths();
                            if (allVideoPaths2 == null) {
                                allVideoPaths2 = CollectionsKt.emptyList();
                            }
                            this.L$0 = videoFilesActivity;
                            this.label = 1;
                            obj = videoFilesActivity4.fetchAllVideos(allVideoPaths2, this);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            emptyList = (List) obj;
                            break;
                        }
                        break;
                    case 529110274:
                        if (str.equals("SPECIFIC_ALBUM")) {
                            this.L$0 = videoFilesActivity;
                            this.label = 2;
                            obj = this.this$0.fetchVideosFromAlbum(SharedDataHolder.INSTANCE.getAlbumFolderPath(), this);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            emptyList = (List) obj;
                            break;
                        }
                        break;
                }
            }
            emptyList = CollectionsKt.emptyList();
        } else if (i == 1) {
            videoFilesActivity = (VideoFilesActivity) this.L$0;
            ResultKt.throwOnFailure(obj);
            emptyList = (List) obj;
        } else if (i == 2) {
            videoFilesActivity = (VideoFilesActivity) this.L$0;
            ResultKt.throwOnFailure(obj);
            emptyList = (List) obj;
        } else if (i == 3) {
            videoFilesActivity = (VideoFilesActivity) this.L$0;
            ResultKt.throwOnFailure(obj);
            emptyList = (List) obj;
        } else {
            if (i != 4) {
                if (i != 5) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            videoFilesActivity = (VideoFilesActivity) this.L$0;
            ResultKt.throwOnFailure(obj);
            emptyList = (List) obj;
        }
        videoFilesActivity.allVideosList = emptyList;
        this.L$0 = null;
        this.label = 5;
        if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.this$0, null), this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    /* compiled from: VideoFilesActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.gcs.recovery.videos.files.photo_recovery.activity.VideoFilesActivity$loadAlbumPhotos$3$1", f = "VideoFilesActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.gcs.recovery.videos.files.photo_recovery.activity.VideoFilesActivity$loadAlbumPhotos$3$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ VideoFilesActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(VideoFilesActivity videoFilesActivity, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = videoFilesActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ActivityVideoFilesBinding activityVideoFilesBinding;
            ActivityVideoFilesBinding activityVideoFilesBinding2;
            VideosAdapter videosAdapter;
            LottieAnimationView lottieAnimationView;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.loadMoreVideos();
                this.this$0.updateSelectionUI();
                this.this$0.updateEmptyView();
                activityVideoFilesBinding = this.this$0.videoFilesBinding;
                VideosAdapter videosAdapter2 = null;
                LottieAnimationView lottieAnimationView2 = activityVideoFilesBinding != null ? activityVideoFilesBinding.preLottie : null;
                if (lottieAnimationView2 != null) {
                    lottieAnimationView2.setVisibility(View.GONE);
                }
                activityVideoFilesBinding2 = this.this$0.videoFilesBinding;
                if (activityVideoFilesBinding2 != null && (lottieAnimationView = activityVideoFilesBinding2.preLottie) != null) {
                    lottieAnimationView.cancelAnimation();
                }
                videosAdapter = this.this$0.videosAdapter;
                if (videosAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("videosAdapter");
                } else {
                    videosAdapter2 = videosAdapter;
                }
                videosAdapter2.notifyDataSetChanged();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
