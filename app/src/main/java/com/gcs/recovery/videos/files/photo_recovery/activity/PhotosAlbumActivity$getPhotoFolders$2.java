package com.gcs.recovery.videos.files.photo_recovery.activity;

import com.gcs.recovery.videos.files.photo_recovery.model.AlbumModel;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;


/* compiled from: PhotosAlbumActivity.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lcom/gcs/recovery/videos/files/photo_recovery/model/AlbumModel;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.gcs.recovery.videos.files.photo_recovery.activity.PhotosAlbumActivity$getPhotoFolders$2", f = "PhotosAlbumActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class PhotosAlbumActivity$getPhotoFolders$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<AlbumModel>>, Object> {
    final /* synthetic */ String[] $photoPaths;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PhotosAlbumActivity$getPhotoFolders$2(String[] strArr, Continuation<? super PhotosAlbumActivity$getPhotoFolders$2> continuation) {
        super(2, continuation);
        this.$photoPaths = strArr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PhotosAlbumActivity$getPhotoFolders$2(this.$photoPaths, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<AlbumModel>> continuation) {
        return ((PhotosAlbumActivity$getPhotoFolders$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x016d A[ADDED_TO_REGION] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object next;
        Object next2;
        Object next3;
        Object next4;
        Object next5;
        String[] strArr;
        boolean z;
        String name;
        int i;
        int i2;
        boolean z2;
        boolean startsWith$default;
        File parentFile;
        String name2;
        String name3;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        String[] strArr2 = this.$photoPaths;
        int length = strArr2.length;
        int i3 = 0;
        while (i3 < length) {
            File file = new File(strArr2[i3]);
            File parentFile2 = file.getParentFile();
            if (parentFile2 == null) {
                strArr = strArr2;
                i = length;
                i2 = i3;
            } else {
                if (!file.isHidden()) {
                    String name4 = file.getName();
                    Intrinsics.checkNotNullExpressionValue(name4, "getName(...)");
                    if (!StringsKt.startsWith$default(name4, ".", false, 2, (Object) null)) {
                        String name5 = parentFile2.getName();
                        Intrinsics.checkNotNullExpressionValue(name5, "getName(...)");
                        if (!StringsKt.startsWith$default(name5, ".", false, 2, (Object) null)) {
                            String name6 = file.getName();
                            Intrinsics.checkNotNullExpressionValue(name6, "getName(...)");
                            strArr = strArr2;
                            if (StringsKt.contains$default((CharSequence) name6, (CharSequence) ".", false, 2, (Object) null) && !file.isHidden()) {
                                z = false;
                                name = file.getName();
                                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                                if (!StringsKt.startsWith$default(name, ".", false, 2, (Object) null) && ((parentFile = parentFile2.getParentFile()) == null || (name3 = parentFile.getName()) == null || !StringsKt.startsWith$default(name3, ".Trash", false, 2, (Object) null))) {
                                    name2 = parentFile2.getName();
                                    Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                                    if (!StringsKt.startsWith$default(name2, ".Trash", false, 2, (Object) null)) {
                                        String path = file.getPath();
                                        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
                                        i = length;
                                        i2 = i3;
                                        if (!StringsKt.contains$default((CharSequence) path, (CharSequence) "/.Trash/", false, 2, (Object) null)) {
                                            String path2 = parentFile2.getPath();
                                            Intrinsics.checkNotNullExpressionValue(path2, "getPath(...)");
                                            if (!StringsKt.contains$default((CharSequence) path2, (CharSequence) ".Trash", false, 2, (Object) null)) {
                                                String name7 = file.getName();
                                                Intrinsics.checkNotNullExpressionValue(name7, "getName(...)");
                                                if (!StringsKt.contains$default((CharSequence) name7, (CharSequence) "._", false, 2, (Object) null)) {
                                                    String name8 = file.getName();
                                                    Intrinsics.checkNotNullExpressionValue(name8, "getName(...)");
                                                    if (!StringsKt.startsWith$default(name8, "~", false, 2, (Object) null)) {
                                                        String name9 = file.getName();
                                                        Intrinsics.checkNotNullExpressionValue(name9, "getName(...)");
                                                        if (!StringsKt.endsWith$default(name9, ".j", false, 2, (Object) null)) {
                                                            String name10 = file.getName();
                                                            Intrinsics.checkNotNullExpressionValue(name10, "getName(...)");
                                                            if (!StringsKt.endsWith$default(name10, ".hidex", false, 2, (Object) null)) {
                                                                String name11 = file.getName();
                                                                Intrinsics.checkNotNullExpressionValue(name11, "getName(...)");
                                                                if (!StringsKt.endsWith$default(name11, ".hideu", false, 2, (Object) null) && !file.isHidden()) {
                                                                    z2 = false;
                                                                    String name12 = parentFile2.getName();
                                                                    Intrinsics.checkNotNullExpressionValue(name12, "getName(...)");
                                                                    startsWith$default = StringsKt.startsWith$default(name12, ".thumbnails", false, 2, (Object) null);
                                                                    if (z) {
                                                                        arrayList2.add(file);
                                                                    }
                                                                    if (z2) {
                                                                        arrayList3.add(file);
                                                                    }
                                                                    arrayList.add(file);
                                                                    if (!startsWith$default || z2) {
                                                                        arrayList4.add(file);
                                                                    } else {
                                                                        String absolutePath = parentFile2.getAbsolutePath();
                                                                        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                                                                        Object obj2 = linkedHashMap.get(absolutePath);
                                                                        if (obj2 == null) {
                                                                            obj2 = (List) new ArrayList();
                                                                            linkedHashMap.put(absolutePath, obj2);
                                                                        }
                                                                        ((List) obj2).add(file);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        z2 = true;
                                        String name122 = parentFile2.getName();
                                        Intrinsics.checkNotNullExpressionValue(name122, "getName(...)");
                                        startsWith$default = StringsKt.startsWith$default(name122, ".thumbnails", false, 2, (Object) null);
                                        if (z) {
                                        }
                                        if (z2) {
                                        }
                                        arrayList.add(file);
                                        if (startsWith$default) {
                                        }
                                        arrayList4.add(file);
                                    }
                                }
                                i = length;
                                i2 = i3;
                                z2 = true;
                                String name1222 = parentFile2.getName();
                                Intrinsics.checkNotNullExpressionValue(name1222, "getName(...)");
                                startsWith$default = StringsKt.startsWith$default(name1222, ".thumbnails", false, 2, (Object) null);
                                if (z) {
                                }
                                if (z2) {
                                }
                                arrayList.add(file);
                                if (startsWith$default) {
                                }
                                arrayList4.add(file);
                            }
                            z = true;
                            name = file.getName();
                            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                            if (!StringsKt.startsWith$default(name, ".", false, 2, (Object) null)) {
                                name2 = parentFile2.getName();
                                Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                                if (!StringsKt.startsWith$default(name2, ".Trash", false, 2, (Object) null)) {
                                }
                            }
                            i = length;
                            i2 = i3;
                            z2 = true;
                            String name12222 = parentFile2.getName();
                            Intrinsics.checkNotNullExpressionValue(name12222, "getName(...)");
                            startsWith$default = StringsKt.startsWith$default(name12222, ".thumbnails", false, 2, (Object) null);
                            if (z) {
                            }
                            if (z2) {
                            }
                            arrayList.add(file);
                            if (startsWith$default) {
                            }
                            arrayList4.add(file);
                        }
                    }
                }
                strArr = strArr2;
                z = true;
                name = file.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                if (!StringsKt.startsWith$default(name, ".", false, 2, (Object) null)) {
                }
                i = length;
                i2 = i3;
                z2 = true;
                String name122222 = parentFile2.getName();
                Intrinsics.checkNotNullExpressionValue(name122222, "getName(...)");
                startsWith$default = StringsKt.startsWith$default(name122222, ".thumbnails", false, 2, (Object) null);
                if (z) {
                }
                if (z2) {
                }
                arrayList.add(file);
                if (startsWith$default) {
                }
                arrayList4.add(file);
            }
            i3 = i2 + 1;
            strArr2 = strArr;
            length = i;
        }
        ArrayList arrayList5 = new ArrayList();
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                long lastModified = ((File) next).lastModified();
                do {
                    Object next6 = it.next();
                    long lastModified2 = ((File) next6).lastModified();
                    if (lastModified < lastModified2) {
                        next = next6;
                        lastModified = lastModified2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        File file2 = (File) next;
        if (file2 != null) {
            Boxing.boxBoolean(arrayList5.add(new AlbumModel("All Photos", arrayList.size(), file2, null, null, 24, null)));
        }
        if (!arrayList2.isEmpty()) {
            ArrayList arrayList6 = arrayList2;
            Iterator it2 = arrayList6.iterator();
            if (it2.hasNext()) {
                next5 = it2.next();
                if (it2.hasNext()) {
                    long lastModified3 = ((File) next5).lastModified();
                    do {
                        Object next7 = it2.next();
                        long lastModified4 = ((File) next7).lastModified();
                        if (lastModified3 < lastModified4) {
                            next5 = next7;
                            lastModified3 = lastModified4;
                        }
                    } while (it2.hasNext());
                }
            } else {
                next5 = null;
            }
            File file3 = (File) next5;
            if (file3 != null) {
                int size = arrayList2.size();
                ArrayList arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList6, 10));
                Iterator it3 = arrayList6.iterator();
                while (it3.hasNext()) {
                    arrayList7.add(((File) it3.next()).getAbsolutePath());
                }
                Boxing.boxBoolean(arrayList5.add(new AlbumModel("Hidden Photos", size, file3, arrayList7, null, 16, null)));
            }
        }
        if (!arrayList4.isEmpty()) {
            ArrayList arrayList8 = arrayList4;
            Iterator it4 = arrayList8.iterator();
            if (it4.hasNext()) {
                next4 = it4.next();
                if (it4.hasNext()) {
                    long lastModified5 = ((File) next4).lastModified();
                    do {
                        Object next8 = it4.next();
                        long lastModified6 = ((File) next8).lastModified();
                        if (lastModified5 < lastModified6) {
                            next4 = next8;
                            lastModified5 = lastModified6;
                        }
                    } while (it4.hasNext());
                }
            } else {
                next4 = null;
            }
            File file4 = (File) next4;
            if (file4 != null) {
                int size2 = arrayList4.size();
                ArrayList arrayList9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList8, 10));
                Iterator it5 = arrayList8.iterator();
                while (it5.hasNext()) {
                    arrayList9.add(((File) it5.next()).getAbsolutePath());
                }
                Boxing.boxBoolean(arrayList5.add(new AlbumModel(".thumbnails", size2, file4, arrayList9, null, 16, null)));
            }
        }
        ArrayList arrayList10 = arrayList3;
        Iterator it6 = arrayList10.iterator();
        if (it6.hasNext()) {
            next2 = it6.next();
            if (it6.hasNext()) {
                long lastModified7 = ((File) next2).lastModified();
                do {
                    Object next9 = it6.next();
                    long lastModified8 = ((File) next9).lastModified();
                    if (lastModified7 < lastModified8) {
                        next2 = next9;
                        lastModified7 = lastModified8;
                    }
                } while (it6.hasNext());
            }
        } else {
            next2 = null;
        }
        File file5 = (File) next2;
        if (file5 != null) {
            int size3 = arrayList3.size();
            ArrayList arrayList11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList10, 10));
            Iterator it7 = arrayList10.iterator();
            while (it7.hasNext()) {
                arrayList11.add(((File) it7.next()).getAbsolutePath());
            }
            Boxing.boxBoolean(arrayList5.add(new AlbumModel("Deleted Photos", size3, file5, arrayList11, null, 16, null)));
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            String name13 = new File(str).getName();
            Iterator it8 = list.iterator();
            if (it8.hasNext()) {
                next3 = it8.next();
                if (it8.hasNext()) {
                    long lastModified9 = ((File) next3).lastModified();
                    do {
                        Object next10 = it8.next();
                        long lastModified10 = ((File) next10).lastModified();
                        if (lastModified9 < lastModified10) {
                            next3 = next10;
                            lastModified9 = lastModified10;
                        }
                    } while (it8.hasNext());
                }
            } else {
                next3 = null;
            }
            File file6 = (File) next3;
            if (file6 != null) {
                Intrinsics.checkNotNull(name13);
                Boxing.boxBoolean(arrayList5.add(new AlbumModel(name13, list.size(), file6, null, null, 24, null)));
            }
        }
        return arrayList5;
    }
}
