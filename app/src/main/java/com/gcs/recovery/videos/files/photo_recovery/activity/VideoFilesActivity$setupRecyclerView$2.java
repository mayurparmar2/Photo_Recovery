package com.gcs.recovery.videos.files.photo_recovery.activity;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: VideoFilesActivity.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class VideoFilesActivity$setupRecyclerView$2 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    VideoFilesActivity$setupRecyclerView$2(Object obj) {
        super(1, obj, VideoFilesActivity.class, "onVideoLongClick", "onVideoLongClick(I)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        ((VideoFilesActivity) this.receiver).onVideoLongClick(i);
    }
}
