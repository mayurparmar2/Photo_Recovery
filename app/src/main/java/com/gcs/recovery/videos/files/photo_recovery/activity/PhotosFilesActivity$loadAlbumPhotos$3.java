package com.gcs.recovery.videos.files.photo_recovery.activity;

import com.airbnb.lottie.LottieAnimationView;
import com.gcs.recovery.videos.files.photo_recovery.adapter.PhotosAdapter;
import com.demo.example.databinding.ActivityPhotosFilesBinding;
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

/* compiled from: PhotosFilesActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.gcs.recovery.videos.files.photo_recovery.activity.PhotosFilesActivity$loadAlbumPhotos$3", f = "PhotosFilesActivity.kt", i = {}, l = {128, 129, 130, Opcodes.LXOR, Opcodes.IINC, Opcodes.L2I}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class PhotosFilesActivity$loadAlbumPhotos$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $albumPath;
    Object L$0;
    int label;
    final /* synthetic */ PhotosFilesActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PhotosFilesActivity$loadAlbumPhotos$3(PhotosFilesActivity photosFilesActivity, String str, Continuation<? super PhotosFilesActivity$loadAlbumPhotos$3> continuation) {
        super(2, continuation);
        this.this$0 = photosFilesActivity;
        this.$albumPath = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PhotosFilesActivity$loadAlbumPhotos$3(this.this$0, this.$albumPath, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PhotosFilesActivity$loadAlbumPhotos$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0144 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        PhotosFilesActivity photosFilesActivity;
        List emptyList;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                photosFilesActivity = this.this$0;
                String str = this.$albumPath;
                if (str != null) {
                    switch (str.hashCode()) {
                        case -2115988298:
                            if (str.equals("HIDDEN_PHOTOS")) {
                                PhotosFilesActivity photosFilesActivity2 = this.this$0;
                                List<String> hiddenPhotoPaths = SharedDataHolder.INSTANCE.getHiddenPhotoPaths();
                                if (hiddenPhotoPaths == null) {
                                    hiddenPhotoPaths = CollectionsKt.emptyList();
                                }
                                this.L$0 = photosFilesActivity;
                                this.label = 3;
                                obj = photosFilesActivity2.fetchAllPhotos(hiddenPhotoPaths, this);
                                if (obj == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                emptyList = (List) obj;
                                photosFilesActivity.allPhotosList = emptyList;
                                this.L$0 = null;
                                this.label = 6;
                                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.this$0, null), this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                return Unit.INSTANCE;
                            }
                            break;
                        case -758758767:
                            if (str.equals("DELETED_FILES")) {
                                PhotosFilesActivity photosFilesActivity3 = this.this$0;
                                List<String> allPhotoPaths = SharedDataHolder.INSTANCE.getAllPhotoPaths();
                                if (allPhotoPaths == null) {
                                    allPhotoPaths = CollectionsKt.emptyList();
                                }
                                this.L$0 = photosFilesActivity;
                                this.label = 5;
                                obj = photosFilesActivity3.fetchAllPhotos(allPhotoPaths, this);
                                if (obj == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                emptyList = (List) obj;
                                photosFilesActivity.allPhotosList = emptyList;
                                this.L$0 = null;
                                this.label = 6;
                                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.this$0, null), this) == coroutine_suspended) {
                                }
                                return Unit.INSTANCE;
                            }
                            break;
                        case 266303743:
                            if (str.equals("ALL_PHOTOS")) {
                                PhotosFilesActivity photosFilesActivity4 = this.this$0;
                                List<String> allPhotoPaths2 = SharedDataHolder.INSTANCE.getAllPhotoPaths();
                                if (allPhotoPaths2 == null) {
                                    allPhotoPaths2 = CollectionsKt.emptyList();
                                }
                                this.L$0 = photosFilesActivity;
                                this.label = 1;
                                obj = photosFilesActivity4.fetchAllPhotos(allPhotoPaths2, this);
                                if (obj == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                emptyList = (List) obj;
                                photosFilesActivity.allPhotosList = emptyList;
                                this.L$0 = null;
                                this.label = 6;
                                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.this$0, null), this) == coroutine_suspended) {
                                }
                                return Unit.INSTANCE;
                            }
                            break;
                        case 529110274:
                            if (str.equals("SPECIFIC_ALBUM")) {
                                this.L$0 = photosFilesActivity;
                                this.label = 2;
                                obj = this.this$0.fetchPhotosFromAlbum(SharedDataHolder.INSTANCE.getAlbumFolderPath(), this);
                                if (obj == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                emptyList = (List) obj;
                                photosFilesActivity.allPhotosList = emptyList;
                                this.L$0 = null;
                                this.label = 6;
                                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.this$0, null), this) == coroutine_suspended) {
                                }
                                return Unit.INSTANCE;
                            }
                            break;
                        case 2021513141:
                            if (str.equals(".THUMBNAILS")) {
                                PhotosFilesActivity photosFilesActivity5 = this.this$0;
                                List<String> thumbnailsPath = SharedDataHolder.INSTANCE.getThumbnailsPath();
                                if (thumbnailsPath == null) {
                                    thumbnailsPath = CollectionsKt.emptyList();
                                }
                                this.L$0 = photosFilesActivity;
                                this.label = 4;
                                obj = photosFilesActivity5.fetchAllPhotos(thumbnailsPath, this);
                                if (obj == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                emptyList = (List) obj;
                                photosFilesActivity.allPhotosList = emptyList;
                                this.L$0 = null;
                                this.label = 6;
                                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.this$0, null), this) == coroutine_suspended) {
                                }
                                return Unit.INSTANCE;
                            }
                            break;
                    }
                }
                emptyList = CollectionsKt.emptyList();
                photosFilesActivity.allPhotosList = emptyList;
                this.L$0 = null;
                this.label = 6;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.this$0, null), this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 1:
                photosFilesActivity = (PhotosFilesActivity) this.L$0;
                ResultKt.throwOnFailure(obj);
                emptyList = (List) obj;
                photosFilesActivity.allPhotosList = emptyList;
                this.L$0 = null;
                this.label = 6;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.this$0, null), this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 2:
                photosFilesActivity = (PhotosFilesActivity) this.L$0;
                ResultKt.throwOnFailure(obj);
                emptyList = (List) obj;
                photosFilesActivity.allPhotosList = emptyList;
                this.L$0 = null;
                this.label = 6;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.this$0, null), this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 3:
                photosFilesActivity = (PhotosFilesActivity) this.L$0;
                ResultKt.throwOnFailure(obj);
                emptyList = (List) obj;
                photosFilesActivity.allPhotosList = emptyList;
                this.L$0 = null;
                this.label = 6;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.this$0, null), this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 4:
                photosFilesActivity = (PhotosFilesActivity) this.L$0;
                ResultKt.throwOnFailure(obj);
                emptyList = (List) obj;
                photosFilesActivity.allPhotosList = emptyList;
                this.L$0 = null;
                this.label = 6;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.this$0, null), this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 5:
                photosFilesActivity = (PhotosFilesActivity) this.L$0;
                ResultKt.throwOnFailure(obj);
                emptyList = (List) obj;
                photosFilesActivity.allPhotosList = emptyList;
                this.L$0 = null;
                this.label = 6;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.this$0, null), this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 6:
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: PhotosFilesActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.gcs.recovery.videos.files.photo_recovery.activity.PhotosFilesActivity$loadAlbumPhotos$3$1", f = "PhotosFilesActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.gcs.recovery.videos.files.photo_recovery.activity.PhotosFilesActivity$loadAlbumPhotos$3$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PhotosFilesActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PhotosFilesActivity photosFilesActivity, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = photosFilesActivity;
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
            ActivityPhotosFilesBinding activityPhotosFilesBinding;
            ActivityPhotosFilesBinding activityPhotosFilesBinding2;
            PhotosAdapter photosAdapter;
            LottieAnimationView lottieAnimationView;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.loadMorePhotos();
                this.this$0.updateSelectionUI();
                this.this$0.updateEmptyView();
                activityPhotosFilesBinding = this.this$0.photoFilesBinding;
                PhotosAdapter photosAdapter2 = null;
                LottieAnimationView lottieAnimationView2 = activityPhotosFilesBinding != null ? activityPhotosFilesBinding.preLottie : null;
                if (lottieAnimationView2 != null) {
                    lottieAnimationView2.setVisibility(View.GONE);
                }
                activityPhotosFilesBinding2 = this.this$0.photoFilesBinding;
                if (activityPhotosFilesBinding2 != null && (lottieAnimationView = activityPhotosFilesBinding2.preLottie) != null) {
                    lottieAnimationView.cancelAnimation();
                }
                photosAdapter = this.this$0.photosAdapter;
                if (photosAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photosAdapter");
                } else {
                    photosAdapter2 = photosAdapter;
                }
                photosAdapter2.notifyDataSetChanged();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
