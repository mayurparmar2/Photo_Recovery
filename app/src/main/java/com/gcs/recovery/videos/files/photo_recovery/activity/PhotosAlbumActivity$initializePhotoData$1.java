package com.gcs.recovery.videos.files.photo_recovery.activity;

import com.gcs.recovery.videos.files.photo_recovery.utils.SharedDataHolder;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
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



import org.objectweb.asm.TypeReference;

/* compiled from: PhotosAlbumActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.gcs.recovery.videos.files.photo_recovery.activity.PhotosAlbumActivity$initializePhotoData$1", f = "PhotosAlbumActivity.kt", i = {}, l = {TypeReference.CONSTRUCTOR_INVOCATION_TYPE_ARGUMENT}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class PhotosAlbumActivity$initializePhotoData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PhotosAlbumActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PhotosAlbumActivity$initializePhotoData$1(PhotosAlbumActivity photosAlbumActivity, Continuation<? super PhotosAlbumActivity$initializePhotoData$1> continuation) {
        super(2, continuation);
        this.this$0 = photosAlbumActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PhotosAlbumActivity$initializePhotoData$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PhotosAlbumActivity$initializePhotoData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            List<File> photoFiles = SharedDataHolder.INSTANCE.getPhotoFiles();
            if (photoFiles == null) {
                photoFiles = CollectionsKt.emptyList();
            }
            PhotosAlbumActivity photosAlbumActivity = this.this$0;
            List filterNotNull = CollectionsKt.filterNotNull(photoFiles);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(filterNotNull, 10));
            Iterator it = filterNotNull.iterator();
            while (it.hasNext()) {
                arrayList.add(((File) it.next()).getAbsolutePath());
            }
            photosAlbumActivity.cachedPhotoPaths = (String[]) arrayList.toArray(new String[0]);
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(this.this$0, null), this) == coroutine_suspended) {
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

    /* compiled from: PhotosAlbumActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.gcs.recovery.videos.files.photo_recovery.activity.PhotosAlbumActivity$initializePhotoData$1$2", f = "PhotosAlbumActivity.kt", i = {}, l = {TypeReference.METHOD_INVOCATION_TYPE_ARGUMENT}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.gcs.recovery.videos.files.photo_recovery.activity.PhotosAlbumActivity$initializePhotoData$1$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PhotosAlbumActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(PhotosAlbumActivity photosAlbumActivity, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = photosAlbumActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String[] strArr;
            String[] strArr2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PhotosAlbumActivity photosAlbumActivity = this.this$0;
                strArr = photosAlbumActivity.cachedPhotoPaths;
                this.label = 1;
                obj = photosAlbumActivity.getPhotoFolders(strArr, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            PhotosAlbumActivity photosAlbumActivity2 = this.this$0;
            strArr2 = photosAlbumActivity2.cachedPhotoPaths;
            photosAlbumActivity2.setupRecyclerView((List) obj, strArr2);
            return Unit.INSTANCE;
        }
    }
}
