package com.gcs.recovery.videos.files.photo_recovery.activity;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: AudioFilesActivity.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class AudioFilesActivity$setupRecyclerView$1 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    AudioFilesActivity$setupRecyclerView$1(Object obj) {
        super(1, obj, AudioFilesActivity.class, "onAudioClick", "onAudioClick(I)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        ((AudioFilesActivity) this.receiver).onAudioClick(i);
    }
}
