package com.gcs.recovery.videos.files.photo_recovery.activity;

import com.gcs.recovery.videos.files.photo_recovery.model.PhotosModel;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;


/* compiled from: PhotosFilesActivity.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lcom/gcs/recovery/videos/files/photo_recovery/model/PhotosModel;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.gcs.recovery.videos.files.photo_recovery.activity.PhotosFilesActivity$fetchPhotosFromAlbum$2", f = "PhotosFilesActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class PhotosFilesActivity$fetchPhotosFromAlbum$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends PhotosModel>>, Object> {
    final /* synthetic */ String $folderPath;
    int label;
    final /* synthetic */ PhotosFilesActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PhotosFilesActivity$fetchPhotosFromAlbum$2(String str, PhotosFilesActivity photosFilesActivity, Continuation<? super PhotosFilesActivity$fetchPhotosFromAlbum$2> continuation) {
        super(2, continuation);
        this.$folderPath = str;
        this.this$0 = photosFilesActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PhotosFilesActivity$fetchPhotosFromAlbum$2(this.$folderPath, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends PhotosModel>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<PhotosModel>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<PhotosModel>> continuation) {
        return ((PhotosFilesActivity$fetchPhotosFromAlbum$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        List list;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String str = this.$folderPath;
            if (str != null) {
                final PhotosFilesActivity photosFilesActivity = this.this$0;
                File[] listFiles = new File(str).listFiles(new FileFilter() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PhotosFilesActivity$fetchPhotosFromAlbum$2$$ExternalSyntheticLambda0
                    @Override // java.io.FileFilter
                    public final boolean accept(File file) {
                        boolean invokeSuspend$lambda$3$lambda$0;
                        invokeSuspend$lambda$3$lambda$0 = PhotosFilesActivity$fetchPhotosFromAlbum$2.invokeSuspend$lambda$3$lambda$0(PhotosFilesActivity.this, file);
                        return invokeSuspend$lambda$3$lambda$0;
                    }
                });
                if (listFiles != null) {
                    ArrayList arrayList = new ArrayList(listFiles.length);
                    for (File file : listFiles) {
                        Intrinsics.checkNotNull(file);
                        arrayList.add(new PhotosModel(file, file.length(), new Date(file.lastModified())));
                    }
                    list = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PhotosFilesActivity$fetchPhotosFromAlbum$2$invokeSuspend$lambda$3$$inlined$sortedByDescending$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            return ComparisonsKt.compareValues(((PhotosModel) t2).getDateAdded(), ((PhotosModel) t).getDateAdded());
                        }
                    });
                } else {
                    list = null;
                }
                if (list == null) {
                    list = CollectionsKt.emptyList();
                }
                if (list != null) {
                    return list;
                }
            }
            return CollectionsKt.emptyList();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invokeSuspend$lambda$3$lambda$0(PhotosFilesActivity photosFilesActivity, File file) {
        boolean isValidImage;
        boolean isImageWithoutExtension;
        Intrinsics.checkNotNull(file);
        isValidImage = photosFilesActivity.isValidImage(file);
        if (!isValidImage) {
            isImageWithoutExtension = photosFilesActivity.isImageWithoutExtension(file);
            if (!isImageWithoutExtension) {
                return false;
            }
        }
        return true;
    }
}
