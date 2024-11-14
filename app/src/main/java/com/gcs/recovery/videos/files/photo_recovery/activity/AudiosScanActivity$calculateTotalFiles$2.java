package com.gcs.recovery.videos.files.photo_recovery.activity;

import com.onesignal.notifications.internal.badges.impl.shortcutbadger.impl.NewHtcHomeBadger;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;


/* compiled from: AudiosScanActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.gcs.recovery.videos.files.photo_recovery.activity.AudiosScanActivity$calculateTotalFiles$2", f = "AudiosScanActivity.kt", i = {0, 0}, l = {122}, m = "invokeSuspend", n = {NewHtcHomeBadger.COUNT, "$this$forEach$iv"}, s = {"L$0", "L$1"})
/* loaded from: classes2.dex */
final class AudiosScanActivity$calculateTotalFiles$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    final /* synthetic */ File $directory;
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ AudiosScanActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AudiosScanActivity$calculateTotalFiles$2(File file, AudiosScanActivity audiosScanActivity, Continuation<? super AudiosScanActivity$calculateTotalFiles$2> continuation) {
        super(2, continuation);
        this.$directory = file;
        this.this$0 = audiosScanActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AudiosScanActivity$calculateTotalFiles$2(this.$directory, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
        return ((AudiosScanActivity$calculateTotalFiles$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x004d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0071 -> B:5:0x0076). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0083 -> B:6:0x0088). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Ref.IntRef intRef;
        File[] fileArr;
        AudiosScanActivity audiosScanActivity;
        int length;
        int i;
        Ref.IntRef intRef2;
        AudiosScanActivity$calculateTotalFiles$2 audiosScanActivity$calculateTotalFiles$2;
        Object calculateTotalFiles;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            intRef = new Ref.IntRef();
            File[] listFiles = this.$directory.listFiles();
            if (listFiles != null) {
                fileArr = listFiles;
                audiosScanActivity = this.this$0;
                length = listFiles.length;
                i = 0;
                intRef2 = intRef;
                audiosScanActivity$calculateTotalFiles$2 = this;
                if (i >= length) {
                }
            }
            return Boxing.boxInt(intRef.element);
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i3 = this.I$2;
        length = this.I$1;
        i = this.I$0;
        intRef2 = (Ref.IntRef) this.L$3;
        audiosScanActivity = (AudiosScanActivity) this.L$2;
        fileArr = (File[]) this.L$1;
        Ref.IntRef intRef3 = (Ref.IntRef) this.L$0;
        ResultKt.throwOnFailure(obj);
        Ref.IntRef intRef4 = intRef3;
        int i4 = i3;
        Object obj2 = coroutine_suspended;
        AudiosScanActivity$calculateTotalFiles$2 audiosScanActivity$calculateTotalFiles$22 = this;
        intRef2.element = i4 + ((Number) obj).intValue();
        audiosScanActivity$calculateTotalFiles$2 = audiosScanActivity$calculateTotalFiles$22;
        coroutine_suspended = obj2;
        intRef2 = intRef4;
        i++;
        if (i >= length) {
            File file = fileArr[i];
            if (file.isDirectory()) {
                i4 = intRef2.element;
                Intrinsics.checkNotNull(file);
                audiosScanActivity$calculateTotalFiles$2.L$0 = intRef2;
                audiosScanActivity$calculateTotalFiles$2.L$1 = fileArr;
                audiosScanActivity$calculateTotalFiles$2.L$2 = audiosScanActivity;
                audiosScanActivity$calculateTotalFiles$2.L$3 = intRef2;
                audiosScanActivity$calculateTotalFiles$2.I$0 = i;
                audiosScanActivity$calculateTotalFiles$2.I$1 = length;
                audiosScanActivity$calculateTotalFiles$2.I$2 = i4;
                audiosScanActivity$calculateTotalFiles$2.label = 1;
                calculateTotalFiles = audiosScanActivity.calculateTotalFiles(file, audiosScanActivity$calculateTotalFiles$2);
                if (calculateTotalFiles == coroutine_suspended) {
                    return coroutine_suspended;
                }
                intRef4 = intRef2;
                Object obj3 = coroutine_suspended;
                audiosScanActivity$calculateTotalFiles$22 = audiosScanActivity$calculateTotalFiles$2;
                obj = calculateTotalFiles;
                obj2 = obj3;
                intRef2.element = i4 + ((Number) obj).intValue();
                audiosScanActivity$calculateTotalFiles$2 = audiosScanActivity$calculateTotalFiles$22;
                coroutine_suspended = obj2;
                intRef2 = intRef4;
                i++;
                if (i >= length) {
                    intRef = intRef2;
                    return Boxing.boxInt(intRef.element);
                }
            } else {
                intRef2.element++;
                i++;
                if (i >= length) {
                }
            }
        }
    }
}
