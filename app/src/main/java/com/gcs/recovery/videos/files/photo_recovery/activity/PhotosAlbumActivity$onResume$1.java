package com.gcs.recovery.videos.files.photo_recovery.activity;

import com.gcs.recovery.videos.files.photo_recovery.model.AlbumModel;
import com.gcs.recovery.videos.files.photo_recovery.utils.SharedDataHolder;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
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





/* compiled from: PhotosAlbumActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.gcs.recovery.videos.files.photo_recovery.activity.PhotosAlbumActivity$onResume$1", f = "PhotosAlbumActivity.kt", i = {}, l = {54, 55}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class PhotosAlbumActivity$onResume$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PhotosAlbumActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PhotosAlbumActivity$onResume$1(PhotosAlbumActivity photosAlbumActivity, Continuation<? super PhotosAlbumActivity$onResume$1> continuation) {
        super(2, continuation);
        this.this$0 = photosAlbumActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PhotosAlbumActivity$onResume$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PhotosAlbumActivity$onResume$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0066, code lost:
    
        if (r7 != null) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00ab A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        String[] strArr;
        String[] strArr2;
        String[] strArr3;
        List filterNotNull;
        MainCoroutineDispatcher main;
        PhotosAlbumActivity photosAlbumActivity;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            List<File> photoFiles = SharedDataHolder.INSTANCE.getPhotoFiles();
            if (photoFiles != null && (filterNotNull = CollectionsKt.filterNotNull(photoFiles)) != null) {
                List list = filterNotNull;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((File) it.next()).getAbsolutePath());
                }
                strArr = (String[]) arrayList.toArray(new String[0]);
            }
            strArr = new String[0];
            strArr2 = this.this$0.cachedPhotoPaths;
            if (!Arrays.equals(strArr, strArr2)) {
                this.this$0.cachedPhotoPaths = strArr;
                PhotosAlbumActivity photosAlbumActivity2 = this.this$0;
                strArr3 = photosAlbumActivity2.cachedPhotoPaths;
                this.label = 1;
                obj = photosAlbumActivity2.getPhotoFolders(strArr3, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                main = Dispatchers.getMain();
                photosAlbumActivity = this.this$0;
                this.label = 2;
                if (BuildersKt.withContext(main, new AnonymousClass1(photosAlbumActivity, (List) obj, null), this) == coroutine_suspended) {
                }
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            main = Dispatchers.getMain();
            photosAlbumActivity = this.this$0;
            this.label = 2;
            if (BuildersKt.withContext(main, new AnonymousClass1(photosAlbumActivity, (List) obj, null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* compiled from: PhotosAlbumActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.gcs.recovery.videos.files.photo_recovery.activity.PhotosAlbumActivity$onResume$1$1", f = "PhotosAlbumActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.gcs.recovery.videos.files.photo_recovery.activity.PhotosAlbumActivity$onResume$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<AlbumModel> $albumList;
        int label;
        final /* synthetic */ PhotosAlbumActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PhotosAlbumActivity photosAlbumActivity, List<AlbumModel> list, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = photosAlbumActivity;
            this.$albumList = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$albumList, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String[] strArr;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                PhotosAlbumActivity photosAlbumActivity = this.this$0;
                List<AlbumModel> list = this.$albumList;
                strArr = photosAlbumActivity.cachedPhotoPaths;
                photosAlbumActivity.setupRecyclerView(list, strArr);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
