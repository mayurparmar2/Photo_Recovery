package com.gcs.recovery.videos.files.photo_recovery.activity;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: PhotosFilesActivity.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class PhotosFilesActivity$setupRecyclerView$2 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    PhotosFilesActivity$setupRecyclerView$2(Object obj) {
        super(1, obj, PhotosFilesActivity.class, "onPhotoLongClick", "onPhotoLongClick(I)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        ((PhotosFilesActivity) this.receiver).onPhotoLongClick(i);
    }
}
