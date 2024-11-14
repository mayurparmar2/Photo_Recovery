package com.gcs.recovery.videos.files.photo_recovery.activity;

import com.onesignal.inAppMessages.internal.InAppMessageContent;
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

/* compiled from: DocScanActivity.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Ljava/io/File;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.gcs.recovery.videos.files.photo_recovery.activity.DocScanActivity$scanForDocuments$2", f = "DocScanActivity.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2}, l = {110, Opcodes.DREM, Opcodes.LSHR}, m = "invokeSuspend", n = {"documentFiles", "documentExtensions", "$this$forEach$iv", "documentFiles", "documentExtensions", "$this$forEach$iv", "documentFiles", "documentExtensions", "$this$forEach$iv"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
/* loaded from: classes2.dex */
final class DocScanActivity$scanForDocuments$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<File>>, Object> {
    final /* synthetic */ File $directory;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ DocScanActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DocScanActivity$scanForDocuments$2(File file, DocScanActivity docScanActivity, Continuation<? super DocScanActivity$scanForDocuments$2> continuation) {
        super(2, continuation);
        this.$directory = file;
        this.this$0 = docScanActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DocScanActivity$scanForDocuments$2(this.$directory, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<File>> continuation) {
        return ((DocScanActivity$scanForDocuments$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x017f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x014a -> B:10:0x017c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0179 -> B:10:0x017c). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        DocScanActivity$scanForDocuments$2 docScanActivity$scanForDocuments$2;
        List list;
        int length;
        List list2;
        int i;
        File[] fileArr;
        DocScanActivity docScanActivity;
        int i2;
        int i3;
        boolean isDocumentFileWithoutExtension;
        Object scanForDocuments;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.label;
        if (i4 != 0) {
            if (i4 == 1) {
                length = this.I$1;
                i = this.I$0;
                List list3 = (List) this.L$4;
                DocScanActivity docScanActivity2 = (DocScanActivity) this.L$3;
                File[] fileArr2 = (File[]) this.L$2;
                List list4 = (List) this.L$1;
                List list5 = (List) this.L$0;
                ResultKt.throwOnFailure(obj);
                list3.addAll((Collection) obj);
                docScanActivity = docScanActivity2;
                fileArr = fileArr2;
                list2 = list4;
                list = list5;
                docScanActivity$scanForDocuments$2 = this;
            } else {
                if (i4 != 2 && i4 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                length = this.I$1;
                i = this.I$0;
                docScanActivity = (DocScanActivity) this.L$3;
                fileArr = (File[]) this.L$2;
                list2 = (List) this.L$1;
                list = (List) this.L$0;
                ResultKt.throwOnFailure(obj);
                docScanActivity$scanForDocuments$2 = this;
            }
            i++;
            if (i < length) {
                File file = fileArr[i];
                i2 = docScanActivity.scannedFiles;
                docScanActivity.scannedFiles = i2 + 1;
                if (file.isDirectory()) {
                    Intrinsics.checkNotNull(file);
                    docScanActivity$scanForDocuments$2.L$0 = list;
                    docScanActivity$scanForDocuments$2.L$1 = list2;
                    docScanActivity$scanForDocuments$2.L$2 = fileArr;
                    docScanActivity$scanForDocuments$2.L$3 = docScanActivity;
                    docScanActivity$scanForDocuments$2.L$4 = list;
                    docScanActivity$scanForDocuments$2.I$0 = i;
                    docScanActivity$scanForDocuments$2.I$1 = length;
                    docScanActivity$scanForDocuments$2.label = 1;
                    scanForDocuments = docScanActivity.scanForDocuments(file, docScanActivity$scanForDocuments$2);
                    if (scanForDocuments == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    DocScanActivity$scanForDocuments$2 docScanActivity$scanForDocuments$22 = docScanActivity$scanForDocuments$2;
                    List list6 = list;
                    List list7 = list2;
                    File[] fileArr3 = fileArr;
                    DocScanActivity docScanActivity3 = docScanActivity;
                    list6.addAll((Collection) scanForDocuments);
                    docScanActivity = docScanActivity3;
                    fileArr = fileArr3;
                    list2 = list7;
                    list = list6;
                    docScanActivity$scanForDocuments$2 = docScanActivity$scanForDocuments$22;
                } else {
                    Intrinsics.checkNotNull(file);
                    String lowerCase = FilesKt.getExtension(file).toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                    if (!list2.contains(lowerCase)) {
                        isDocumentFileWithoutExtension = docScanActivity.isDocumentFileWithoutExtension(file);
                        if (!isDocumentFileWithoutExtension) {
                            MainCoroutineDispatcher main = Dispatchers.getMain();
                            DocScanActivity$scanForDocuments$2$1$2 docScanActivity$scanForDocuments$2$1$2 = new DocScanActivity$scanForDocuments$2$1$2(docScanActivity, null);
                            docScanActivity$scanForDocuments$2.L$0 = list;
                            docScanActivity$scanForDocuments$2.L$1 = list2;
                            docScanActivity$scanForDocuments$2.L$2 = fileArr;
                            docScanActivity$scanForDocuments$2.L$3 = docScanActivity;
                            docScanActivity$scanForDocuments$2.L$4 = null;
                            docScanActivity$scanForDocuments$2.I$0 = i;
                            docScanActivity$scanForDocuments$2.I$1 = length;
                            docScanActivity$scanForDocuments$2.label = 3;
                            if (BuildersKt.withContext(main, docScanActivity$scanForDocuments$2$1$2, docScanActivity$scanForDocuments$2) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    }
                    list.add(file);
                    i3 = docScanActivity.foundFiles;
                    docScanActivity.foundFiles = i3 + 1;
                    MainCoroutineDispatcher main2 = Dispatchers.getMain();
                    DocScanActivity$scanForDocuments$2$1$1 docScanActivity$scanForDocuments$2$1$1 = new DocScanActivity$scanForDocuments$2$1$1(docScanActivity, file, null);
                    docScanActivity$scanForDocuments$2.L$0 = list;
                    docScanActivity$scanForDocuments$2.L$1 = list2;
                    docScanActivity$scanForDocuments$2.L$2 = fileArr;
                    docScanActivity$scanForDocuments$2.L$3 = docScanActivity;
                    docScanActivity$scanForDocuments$2.L$4 = null;
                    docScanActivity$scanForDocuments$2.I$0 = i;
                    docScanActivity$scanForDocuments$2.I$1 = length;
                    docScanActivity$scanForDocuments$2.label = 2;
                    if (BuildersKt.withContext(main2, docScanActivity$scanForDocuments$2$1$1, docScanActivity$scanForDocuments$2) == coroutine_suspended) {
                        return coroutine_suspended;
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
            List listOf = CollectionsKt.listOf((Object[]) new String[]{"pdf", "doc", "docx", "xls", "xlsx", "txt", "ppt", "pptx", "zip", "apk", "xapk", "aab", "temp", "odt", "ods", "odp", "rtf", "csv", "xml", InAppMessageContent.HTML, "htm", "md", "json", "epub", "mobi", "rar", "7z", "tar", "gz", "iso", "ttf", "psd", "svg", "pdf_temp", "pdf 100nu", "plp", "pages", "tmp.chck"});
            File[] listFiles = this.$directory.listFiles();
            if (listFiles == null) {
                return arrayList;
            }
            DocScanActivity docScanActivity4 = this.this$0;
            docScanActivity$scanForDocuments$2 = this;
            list = arrayList;
            length = listFiles.length;
            list2 = listOf;
            i = 0;
            fileArr = listFiles;
            docScanActivity = docScanActivity4;
            if (i < length) {
            }
        }
    }
}
