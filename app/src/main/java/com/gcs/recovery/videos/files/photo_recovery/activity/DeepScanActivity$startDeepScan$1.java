package com.gcs.recovery.videos.files.photo_recovery.activity;

import android.os.Environment;
import com.demo.example.databinding.ActivityDeepScanBinding;
import java.io.File;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;




/* compiled from: DeepScanActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.gcs.recovery.videos.files.photo_recovery.activity.DeepScanActivity$startDeepScan$1", f = "DeepScanActivity.kt", i = {0}, l = {47, 48}, m = "invokeSuspend", n = {"rootDir"}, s = {"L$0"})
/* loaded from: classes2.dex */
final class DeepScanActivity$startDeepScan$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ DeepScanActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DeepScanActivity$startDeepScan$1(DeepScanActivity deepScanActivity, Continuation<? super DeepScanActivity$startDeepScan$1> continuation) {
        super(2, continuation);
        this.this$0 = deepScanActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeepScanActivity$startDeepScan$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeepScanActivity$startDeepScan$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00d6  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ActivityDeepScanBinding activityDeepScanBinding;
        ActivityDeepScanBinding activityDeepScanBinding2;
        ActivityDeepScanBinding activityDeepScanBinding3;
        File file;
        List list;
        ActivityDeepScanBinding activityDeepScanBinding4;
        ActivityDeepScanBinding activityDeepScanBinding5;
        ActivityDeepScanBinding activityDeepScanBinding6;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        ActivityDeepScanBinding activityDeepScanBinding7 = null;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            activityDeepScanBinding = this.this$0.deepScanBinding;
            if (activityDeepScanBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deepScanBinding");
                activityDeepScanBinding = null;
            }
            activityDeepScanBinding.storageProgress.setProgress(0.0f);
            activityDeepScanBinding2 = this.this$0.deepScanBinding;
            if (activityDeepScanBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deepScanBinding");
                activityDeepScanBinding2 = null;
            }
            activityDeepScanBinding2.scanTxt.setText("Scanning...");
            activityDeepScanBinding3 = this.this$0.deepScanBinding;
            if (activityDeepScanBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("deepScanBinding");
                activityDeepScanBinding3 = null;
            }
            activityDeepScanBinding3.progressCircular.playAnimation();
            file = new File(Environment.getExternalStorageDirectory().getAbsolutePath());
            this.L$0 = file;
            this.label = 1;
            obj = this.this$0.countFiles(file, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Pair pair = (Pair) obj;
                this.this$0.totalJunkSize = ((Number) pair.getFirst()).longValue();
                this.this$0.junkFilesList = CollectionsKt.toMutableList((Collection) pair.getSecond());
                DeepScanActivity deepScanActivity = this.this$0;
                list = deepScanActivity.junkFilesList;
                deepScanActivity.foundFiles = list.size();
                activityDeepScanBinding4 = this.this$0.deepScanBinding;
                if (activityDeepScanBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("deepScanBinding");
                    activityDeepScanBinding4 = null;
                }
                activityDeepScanBinding4.progressCircular.cancelAnimation();
                activityDeepScanBinding5 = this.this$0.deepScanBinding;
                if (activityDeepScanBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("deepScanBinding");
                    activityDeepScanBinding5 = null;
                }
                activityDeepScanBinding5.scanTxt.setText("Scan Complete");
                activityDeepScanBinding6 = this.this$0.deepScanBinding;
                if (activityDeepScanBinding6 != null) {
                    Intrinsics.throwUninitializedPropertyAccessException("deepScanBinding");
                } else {
                    activityDeepScanBinding7 = activityDeepScanBinding6;
                }
                activityDeepScanBinding7.storageProgress.setProgress(100.0f);
                this.this$0.onScanComplete();
                return Unit.INSTANCE;
            }
            file = (File) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        int intValue = ((Number) obj).intValue();
        this.L$0 = null;
        this.label = 2;
        obj = BuildersKt.withContext(Dispatchers.getIO(), new DeepScanActivity$startDeepScan$1$junkData$1(this.this$0, file, intValue, null), this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        Pair pair2 = (Pair) obj;
        this.this$0.totalJunkSize = ((Number) pair2.getFirst()).longValue();
        this.this$0.junkFilesList = CollectionsKt.toMutableList((Collection) pair2.getSecond());
        DeepScanActivity deepScanActivity2 = this.this$0;
        list = deepScanActivity2.junkFilesList;
        deepScanActivity2.foundFiles = list.size();
        activityDeepScanBinding4 = this.this$0.deepScanBinding;
        if (activityDeepScanBinding4 == null) {
        }
        activityDeepScanBinding4.progressCircular.cancelAnimation();
        activityDeepScanBinding5 = this.this$0.deepScanBinding;
        if (activityDeepScanBinding5 == null) {
        }
        activityDeepScanBinding5.scanTxt.setText("Scan Complete");
        activityDeepScanBinding6 = this.this$0.deepScanBinding;
        if (activityDeepScanBinding6 != null) {
        }
        activityDeepScanBinding7.storageProgress.setProgress(100.0f);
        this.this$0.onScanComplete();
        return Unit.INSTANCE;
    }
}
