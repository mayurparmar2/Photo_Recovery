package com.gcs.recovery.videos.files.photo_recovery.activity;

import java.io.File;
import java.util.ArrayList;
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




import org.objectweb.asm.Opcodes;

/* compiled from: PhotosScanActivity.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.gcs.recovery.videos.files.photo_recovery.activity.PhotosScanActivity$scanForPhotos$2", f = "PhotosScanActivity.kt", i = {0}, l = {Opcodes.F2I}, m = "invokeSuspend", n = {"imageFiles"}, s = {"L$0"})
/* loaded from: classes2.dex */
final class PhotosScanActivity$scanForPhotos$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends File>>, Object> {
    final /* synthetic */ File $directory;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PhotosScanActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PhotosScanActivity$scanForPhotos$2(File file, PhotosScanActivity photosScanActivity, Continuation<? super PhotosScanActivity$scanForPhotos$2> continuation) {
        super(2, continuation);
        this.$directory = file;
        this.this$0 = photosScanActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PhotosScanActivity$scanForPhotos$2 photosScanActivity$scanForPhotos$2 = new PhotosScanActivity$scanForPhotos$2(this.$directory, this.this$0, continuation);
        photosScanActivity$scanForPhotos$2.L$0 = obj;
        return photosScanActivity$scanForPhotos$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends File>> continuation) {
        return ((PhotosScanActivity$scanForPhotos$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                return CollectionsKt.toList(list);
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            ArrayList arrayList = new ArrayList();
            File[] listFiles = this.$directory.listFiles();
            if (listFiles == null) {
                return CollectionsKt.emptyList();
            }
            PhotosScanActivity photosScanActivity = this.this$0;
            ArrayList arrayList2 = new ArrayList(listFiles.length);
            for (File file : listFiles) {
                async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new PhotosScanActivity$scanForPhotos$2$deferreds$1$1(photosScanActivity, file, arrayList, null), 3, null);
                arrayList2.add(async$default);
            }
            try {
                this.L$0 = arrayList;
                this.label = 1;
                if (AwaitKt.awaitAll(arrayList2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                list = arrayList;
            } catch (Exception e2) {
                e = e2;
                list = arrayList;
                e.printStackTrace();
                return CollectionsKt.toList(list);
            }
        }
        return CollectionsKt.toList(list);
    }
}
