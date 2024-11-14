package com.gcs.recovery.videos.files.photo_recovery.activity;

import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;


/* compiled from: DeepScanActivity.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001*\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.gcs.recovery.videos.files.photo_recovery.activity.DeepScanActivity$startDeepScan$1$junkData$1", f = "DeepScanActivity.kt", i = {}, l = {48}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class DeepScanActivity$startDeepScan$1$junkData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends Long, ? extends List<? extends String>>>, Object> {
    final /* synthetic */ File $rootDir;
    final /* synthetic */ int $totalFiles;
    int label;
    final /* synthetic */ DeepScanActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DeepScanActivity$startDeepScan$1$junkData$1(DeepScanActivity deepScanActivity, File file, int i, Continuation<? super DeepScanActivity$startDeepScan$1$junkData$1> continuation) {
        super(2, continuation);
        this.this$0 = deepScanActivity;
        this.$rootDir = file;
        this.$totalFiles = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeepScanActivity$startDeepScan$1$junkData$1(this.this$0, this.$rootDir, this.$totalFiles, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends Long, ? extends List<? extends String>>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Pair<Long, ? extends List<String>>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Pair<Long, ? extends List<String>>> continuation) {
        return ((DeepScanActivity$startDeepScan$1$junkData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.scanJunkFiles(this.$rootDir, this.$totalFiles, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
