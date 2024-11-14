package com.gcs.recovery.videos.files.photo_recovery.activity;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.objectweb.asm.Opcodes;

/* compiled from: PhotosFilesActivity.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.gcs.recovery.videos.files.photo_recovery.activity.PhotosFilesActivity", f = "PhotosFilesActivity.kt", i = {0, 0}, l = {Opcodes.LSHL}, m = "loadAlbumPhotos", n = {"this", "albumPath"}, s = {"L$0", "L$1"})
/* loaded from: classes2.dex */
final class PhotosFilesActivity$loadAlbumPhotos$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PhotosFilesActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PhotosFilesActivity$loadAlbumPhotos$1(PhotosFilesActivity photosFilesActivity, Continuation<? super PhotosFilesActivity$loadAlbumPhotos$1> continuation) {
        super(continuation);
        this.this$0 = photosFilesActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object loadAlbumPhotos;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        loadAlbumPhotos = this.this$0.loadAlbumPhotos(null, this);
        return loadAlbumPhotos;
    }
}
