package com.gcs.recovery.videos.files.photo_recovery.activity;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;




import org.objectweb.asm.Opcodes;

/* compiled from: AudiosScanActivity.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.gcs.recovery.videos.files.photo_recovery.activity.AudiosScanActivity$scanForAudios$2", f = "AudiosScanActivity.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2}, l = {Opcodes.SWAP, 100, 108}, m = "invokeSuspend", n = {"audioFiles", "audioExtensions", "$this$forEach$iv", "audioFiles", "audioExtensions", "$this$forEach$iv", "audioFiles", "audioExtensions", "$this$forEach$iv"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
/* loaded from: classes2.dex */
final class AudiosScanActivity$scanForAudios$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<File>>, Object> {
    final /* synthetic */ File $directory;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ AudiosScanActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AudiosScanActivity$scanForAudios$2(File file, AudiosScanActivity audiosScanActivity, Continuation<? super AudiosScanActivity$scanForAudios$2> continuation) {
        super(2, continuation);
        this.$directory = file;
        this.this$0 = audiosScanActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AudiosScanActivity$scanForAudios$2(this.$directory, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<File>> continuation) {
        return ((AudiosScanActivity$scanForAudios$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x014f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0125 -> B:10:0x014c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0149 -> B:10:0x014c). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        AudiosScanActivity$scanForAudios$2 audiosScanActivity$scanForAudios$2;
        List list;
        int length;
        List list2;
        int i;
        File[] fileArr;
        AudiosScanActivity audiosScanActivity;
        int i2;
        int i3;
        Object scanForAudios;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.label;
        if (i4 != 0) {
            if (i4 == 1) {
                length = this.I$1;
                i = this.I$0;
                List list3 = (List) this.L$4;
                AudiosScanActivity audiosScanActivity2 = (AudiosScanActivity) this.L$3;
                File[] fileArr2 = (File[]) this.L$2;
                List list4 = (List) this.L$1;
                List list5 = (List) this.L$0;
                ResultKt.throwOnFailure(obj);
                list3.addAll((Collection) obj);
                audiosScanActivity = audiosScanActivity2;
                fileArr = fileArr2;
                list2 = list4;
                list = list5;
                audiosScanActivity$scanForAudios$2 = this;
            } else {
                if (i4 != 2 && i4 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                length = this.I$1;
                i = this.I$0;
                audiosScanActivity = (AudiosScanActivity) this.L$3;
                fileArr = (File[]) this.L$2;
                list2 = (List) this.L$1;
                list = (List) this.L$0;
                ResultKt.throwOnFailure(obj);
                audiosScanActivity$scanForAudios$2 = this;
            }
            i++;
            if (i < length) {
                File file = fileArr[i];
                i2 = audiosScanActivity.scannedFiles;
                audiosScanActivity.scannedFiles = i2 + 1;
                if (file.isDirectory()) {
                    Intrinsics.checkNotNull(file);
                    audiosScanActivity$scanForAudios$2.L$0 = list;
                    audiosScanActivity$scanForAudios$2.L$1 = list2;
                    audiosScanActivity$scanForAudios$2.L$2 = fileArr;
                    audiosScanActivity$scanForAudios$2.L$3 = audiosScanActivity;
                    audiosScanActivity$scanForAudios$2.L$4 = list;
                    audiosScanActivity$scanForAudios$2.I$0 = i;
                    audiosScanActivity$scanForAudios$2.I$1 = length;
                    audiosScanActivity$scanForAudios$2.label = 1;
                    scanForAudios = audiosScanActivity.scanForAudios(file, audiosScanActivity$scanForAudios$2);
                    if (scanForAudios == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    AudiosScanActivity$scanForAudios$2 audiosScanActivity$scanForAudios$22 = audiosScanActivity$scanForAudios$2;
                    List list6 = list;
                    List list7 = list2;
                    File[] fileArr3 = fileArr;
                    AudiosScanActivity audiosScanActivity3 = audiosScanActivity;
                    list6.addAll((Collection) scanForAudios);
                    audiosScanActivity = audiosScanActivity3;
                    fileArr = fileArr3;
                    list2 = list7;
                    list = list6;
                    audiosScanActivity$scanForAudios$2 = audiosScanActivity$scanForAudios$22;
                } else {
                    Intrinsics.checkNotNull(file);
                    String lowerCase = FilesKt.getExtension(file).toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                    if (list2.contains(lowerCase)) {
                        list.add(file);
                        i3 = audiosScanActivity.foundFiles;
                        audiosScanActivity.foundFiles = i3 + 1;
                        MainCoroutineDispatcher main = Dispatchers.getMain();
                        AudiosScanActivity$scanForAudios$2$1$1 audiosScanActivity$scanForAudios$2$1$1 = new AudiosScanActivity$scanForAudios$2$1$1(audiosScanActivity, file, null);
                        audiosScanActivity$scanForAudios$2.L$0 = list;
                        audiosScanActivity$scanForAudios$2.L$1 = list2;
                        audiosScanActivity$scanForAudios$2.L$2 = fileArr;
                        audiosScanActivity$scanForAudios$2.L$3 = audiosScanActivity;
                        audiosScanActivity$scanForAudios$2.L$4 = null;
                        audiosScanActivity$scanForAudios$2.I$0 = i;
                        audiosScanActivity$scanForAudios$2.I$1 = length;
                        audiosScanActivity$scanForAudios$2.label = 2;
                        if (BuildersKt.withContext(main, audiosScanActivity$scanForAudios$2$1$1, audiosScanActivity$scanForAudios$2) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        MainCoroutineDispatcher main2 = Dispatchers.getMain();
                        AudiosScanActivity$scanForAudios$2$1$2 audiosScanActivity$scanForAudios$2$1$2 = new AudiosScanActivity$scanForAudios$2$1$2(audiosScanActivity, null);
                        audiosScanActivity$scanForAudios$2.L$0 = list;
                        audiosScanActivity$scanForAudios$2.L$1 = list2;
                        audiosScanActivity$scanForAudios$2.L$2 = fileArr;
                        audiosScanActivity$scanForAudios$2.L$3 = audiosScanActivity;
                        audiosScanActivity$scanForAudios$2.L$4 = null;
                        audiosScanActivity$scanForAudios$2.I$0 = i;
                        audiosScanActivity$scanForAudios$2.I$1 = length;
                        audiosScanActivity$scanForAudios$2.label = 3;
                        if (BuildersKt.withContext(main2, audiosScanActivity$scanForAudios$2$1$2, audiosScanActivity$scanForAudios$2) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
                i++;
                if (i < length) {
                    return list;
                }
            }
        } else {
            ResultKt.throwOnFailure(obj);
            ArrayList arrayList = new ArrayList();
            List listOf = CollectionsKt.listOf((Object[]) new String[]{"mp3", "wav", "m4a", "ogg", "flac", "opus", "aac", "aiff", "alac", "amr", "ape", "au", "dts", "mka", "ra", "wma", "wv"});
            File[] listFiles = this.$directory.listFiles();
            if (listFiles == null) {
                return arrayList;
            }
            AudiosScanActivity audiosScanActivity4 = this.this$0;
            audiosScanActivity$scanForAudios$2 = this;
            list = arrayList;
            length = listFiles.length;
            list2 = listOf;
            i = 0;
            fileArr = listFiles;
            audiosScanActivity = audiosScanActivity4;
            if (i < length) {
            }
        }
    }
}
