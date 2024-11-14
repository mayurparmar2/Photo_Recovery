package com.gcs.recovery.videos.files.photo_recovery.activity;

import com.gcs.recovery.videos.files.photo_recovery.model.VideosModel;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
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


/* compiled from: VideoFilesActivity.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lcom/gcs/recovery/videos/files/photo_recovery/model/VideosModel;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.gcs.recovery.videos.files.photo_recovery.activity.VideoFilesActivity$fetchAllVideos$2", f = "VideoFilesActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class VideoFilesActivity$fetchAllVideos$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends VideosModel>>, Object> {
    final /* synthetic */ List<String> $videoPaths;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoFilesActivity$fetchAllVideos$2(List<String> list, Continuation<? super VideoFilesActivity$fetchAllVideos$2> continuation) {
        super(2, continuation);
        this.$videoPaths = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoFilesActivity$fetchAllVideos$2(this.$videoPaths, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends VideosModel>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<VideosModel>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<VideosModel>> continuation) {
        return ((VideoFilesActivity$fetchAllVideos$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            List<String> list = this.$videoPaths;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                File file = new File((String) it.next());
                arrayList.add(new VideosModel(file, 0L, new Date(file.lastModified()), 0L, 8, null));
            }
            return CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.VideoFilesActivity$fetchAllVideos$2$invokeSuspend$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(((VideosModel) t2).getDateAdded(), ((VideosModel) t).getDateAdded());
                }
            });
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
