package com.gcs.recovery.videos.files.photo_recovery.activity;

import com.gcs.recovery.videos.files.photo_recovery.utils.JunkFileScanner;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FileTreeWalk;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;




import org.objectweb.asm.Opcodes;

/* compiled from: DeepScanActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.gcs.recovery.videos.files.photo_recovery.activity.DeepScanActivity$scanJunkFiles$2", f = "DeepScanActivity.kt", i = {}, l = {Opcodes.FASTORE}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class DeepScanActivity$scanJunkFiles$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $junkFiles;
    final /* synthetic */ File $rootDir;
    final /* synthetic */ int $totalFiles;
    final /* synthetic */ Ref.LongRef $totalSize;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ DeepScanActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DeepScanActivity$scanJunkFiles$2(File file, DeepScanActivity deepScanActivity, Ref.LongRef longRef, List<String> list, int i, Continuation<? super DeepScanActivity$scanJunkFiles$2> continuation) {
        super(2, continuation);
        this.$rootDir = file;
        this.this$0 = deepScanActivity;
        this.$totalSize = longRef;
        this.$junkFiles = list;
        this.$totalFiles = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeepScanActivity$scanJunkFiles$2(this.$rootDir, this.this$0, this.$totalSize, this.$junkFiles, this.$totalFiles, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeepScanActivity$scanJunkFiles$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0050  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x00b6 -> B:5:0x00ba). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        DeepScanActivity$scanJunkFiles$2 deepScanActivity$scanJunkFiles$2;
        Iterator<File> it;
        DeepScanActivity deepScanActivity;
        Ref.LongRef longRef;
        List<String> list;
        int i;
        int i2;
        int i3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.label;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            FileTreeWalk walkTopDown = FilesKt.walkTopDown(this.$rootDir);
            DeepScanActivity deepScanActivity2 = this.this$0;
            Ref.LongRef longRef2 = this.$totalSize;
            List<String> list2 = this.$junkFiles;
            int i5 = this.$totalFiles;
            deepScanActivity$scanJunkFiles$2 = this;
            it = walkTopDown.iterator();
            deepScanActivity = deepScanActivity2;
            longRef = longRef2;
            list = list2;
            i = i5;
            while (it.hasNext()) {
            }
            return Unit.INSTANCE;
        }
        if (i4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        i = this.I$0;
        Iterator<File> it2 = (Iterator) this.L$3;
        List<String> list3 = (List) this.L$2;
        Ref.LongRef longRef3 = (Ref.LongRef) this.L$1;
        DeepScanActivity deepScanActivity3 = (DeepScanActivity) this.L$0;
        ResultKt.throwOnFailure(obj);
        deepScanActivity$scanJunkFiles$2 = this;
        it = it2;
        list = list3;
        longRef = longRef3;
        deepScanActivity = deepScanActivity3;
        while (it.hasNext()) {
            File next = it.next();
            if (next.isFile()) {
                i2 = deepScanActivity.scannedFiles;
                deepScanActivity.scannedFiles = i2 + 1;
                if (JunkFileScanner.INSTANCE.isJunkFile(next, deepScanActivity)) {
                    longRef.element += next.length();
                    String absolutePath = next.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                    list.add(absolutePath);
                    i3 = deepScanActivity.foundFiles;
                    deepScanActivity.foundFiles = i3 + 1;
                    MainCoroutineDispatcher main = Dispatchers.getMain();
                    DeepScanActivity$scanJunkFiles$2$1$1 deepScanActivity$scanJunkFiles$2$1$1 = new DeepScanActivity$scanJunkFiles$2$1$1(deepScanActivity, next, longRef, i, null);
                    deepScanActivity$scanJunkFiles$2.L$0 = deepScanActivity;
                    deepScanActivity$scanJunkFiles$2.L$1 = longRef;
                    deepScanActivity$scanJunkFiles$2.L$2 = list;
                    deepScanActivity$scanJunkFiles$2.L$3 = it;
                    deepScanActivity$scanJunkFiles$2.I$0 = i;
                    deepScanActivity$scanJunkFiles$2.label = 1;
                    if (BuildersKt.withContext(main, deepScanActivity$scanJunkFiles$2$1$1, deepScanActivity$scanJunkFiles$2) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    it2 = it;
                    list3 = list;
                    longRef3 = longRef;
                    deepScanActivity3 = deepScanActivity;
                    it = it2;
                    list = list3;
                    longRef = longRef3;
                    deepScanActivity = deepScanActivity3;
                    while (it.hasNext()) {
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }
}
