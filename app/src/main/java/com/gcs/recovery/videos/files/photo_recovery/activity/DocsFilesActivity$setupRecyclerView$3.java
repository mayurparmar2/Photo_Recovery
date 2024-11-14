package com.gcs.recovery.videos.files.photo_recovery.activity;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: DocsFilesActivity.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
/* synthetic */ class DocsFilesActivity$setupRecyclerView$3 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    DocsFilesActivity$setupRecyclerView$3(Object obj) {
        super(1, obj, DocsFilesActivity.class, "onSelectionChanged", "onSelectionChanged(Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        ((DocsFilesActivity) this.receiver).onSelectionChanged(z);
    }
}
