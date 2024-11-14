package com.gcs.recovery.videos.files.photo_recovery.activity;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DeepScanActivity.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.gcs.recovery.videos.files.photo_recovery.activity.DeepScanActivity", f = "DeepScanActivity.kt", i = {0, 0}, l = {71}, m = "scanJunkFiles", n = {"totalSize", "junkFiles"}, s = {"L$0", "L$1"})
/* loaded from: classes2.dex */
final class DeepScanActivity$scanJunkFiles$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DeepScanActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DeepScanActivity$scanJunkFiles$1(DeepScanActivity deepScanActivity, Continuation<? super DeepScanActivity$scanJunkFiles$1> continuation) {
        super(continuation);
        this.this$0 = deepScanActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object scanJunkFiles;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        scanJunkFiles = this.this$0.scanJunkFiles(null, 0, this);
        return scanJunkFiles;
    }
}
