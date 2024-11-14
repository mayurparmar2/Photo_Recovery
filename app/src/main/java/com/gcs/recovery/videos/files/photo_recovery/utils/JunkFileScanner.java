package com.gcs.recovery.videos.files.photo_recovery.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import androidx.core.app.NotificationCompat;
import com.facebook.share.internal.ShareInternalUtility;
import com.gcs.recovery.videos.files.photo_recovery.ads.MyApplication;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: JunkFileScanner.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\tH\u0002J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0016\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\u0014\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/utils/JunkFileScanner;", "", "()V", "junkExtensions", "", "", "isAdJunkFile", "", ShareInternalUtility.STAGING_PARAM, "Ljava/io/File;", "isApkFile", "isApkInstalled", "apkFile", "isAppInstalled", "context", "Landroid/content/Context;", "isCacheFile", "isJunkFile", "isKnownJunkExtension", "isObsoleteFile", "isResidualFile", "isSystemGeneratedJunk", "isTemporaryFile", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class JunkFileScanner {
    public static final JunkFileScanner INSTANCE = new JunkFileScanner();
    private static final List<String> junkExtensions = CollectionsKt.listOf((Object[]) new String[]{"apk", "tmp", "log", "aab", "cache", "bak", "dat", "temp"});

    private JunkFileScanner() {
    }

    public final boolean isJunkFile(File file, Context context) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(context, "context");
        return isCacheFile(file, context) || isResidualFile(file, context) || isTemporaryFile(file) || isAdJunkFile(file) || isApkFile(file) || isObsoleteFile(file) || isSystemGeneratedJunk(file) || isKnownJunkExtension(file);
    }

    private final boolean isCacheFile(File file, Context context) {
        Pattern compile = Pattern.compile(".*(cache).*", 2);
        List listOfNotNull = CollectionsKt.listOfNotNull((Object[]) new File[]{context.getCacheDir(), context.getExternalCacheDir()});
        for (File file2 : FilesKt.walkTopDown(file)) {
            List<File> list = listOfNotNull;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                for (File file3 : list) {
                    String absolutePath = file2.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                    String absolutePath2 = file3.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath2, "getAbsolutePath(...)");
                    if (!StringsKt.startsWith$default(absolutePath, absolutePath2, false, 2, (Object) null)) {
                        File parentFile = file2.getParentFile();
                        String name = parentFile != null ? parentFile.getName() : null;
                        if (name == null) {
                            name = "";
                        } else {
                            Intrinsics.checkNotNull(name);
                        }
                        if (compile.matcher(name).matches()) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean isResidualFile(File file, Context context) {
        List<String> listOf = CollectionsKt.listOf((Object[]) new String[]{"/Android/data/", "/Android/obb/", "/customAppData/"});
        if ((listOf instanceof Collection) && listOf.isEmpty()) {
            return false;
        }
        for (String str : listOf) {
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
            if (StringsKt.contains((CharSequence) absolutePath, (CharSequence) str, true) && !INSTANCE.isAppInstalled(file, context)) {
                return true;
            }
        }
        return false;
    }

    private final boolean isAppInstalled(File file, Context context) {
        Object obj;
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        Iterator it = StringsKt.split$default((CharSequence) absolutePath, new String[]{RemoteSettings.FORWARD_SLASH_STRING}, false, 0, 6, (Object) null).iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (StringsKt.startsWith$default((String) next, "com.", false, 2, (Object) null)) {
                obj = next;
                break;
            }
        }
        String str = (String) obj;
        if (str != null) {
            try {
                context.getPackageManager().getPackageInfo(str, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                return false;
            }
        }
        return true;
    }

    private final boolean isTemporaryFile(File file) {
        String property = System.getProperty("java.io.tmpdir");
        if (property == null) {
            return false;
        }
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        return StringsKt.startsWith$default(absolutePath, property, false, 2, (Object) null);
    }

    private final boolean isAdJunkFile(File file) {
        List listOf = CollectionsKt.listOf((Object[]) new String[]{"ads", "adcache", "advertising", "advert", NotificationCompat.CATEGORY_PROMO});
        for (File file2 : FilesKt.walkTopDown(file)) {
            List<String> list = listOf;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                for (String str : list) {
                    String absolutePath = file2.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                    if (StringsKt.contains((CharSequence) absolutePath, (CharSequence) str, true)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private final boolean isApkFile(File file) {
        return StringsKt.equals(FilesKt.getExtension(file), "apk", true) && !isApkInstalled(file);
    }

    private final boolean isApkInstalled(File apkFile) {
        return MyApplication.INSTANCE.getInstance().getPackageManager().getPackageArchiveInfo(apkFile.getAbsolutePath(), 0) != null;
    }

    private final boolean isObsoleteFile(File file) {
        List<File> listOf = CollectionsKt.listOf((Object[]) new File[]{new File(Environment.getExternalStorageDirectory(), "OldBackups"), new File(Environment.getExternalStorageDirectory(), "OldLogs")});
        if ((listOf instanceof Collection) && listOf.isEmpty()) {
            return false;
        }
        for (File file2 : listOf) {
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
            String absolutePath2 = file2.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath2, "getAbsolutePath(...)");
            if (StringsKt.startsWith$default(absolutePath, absolutePath2, false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    private final boolean isSystemGeneratedJunk(File file) {
        boolean z;
        File[] listFiles;
        File parentFile;
        String name;
        String name2 = file.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
        if (!StringsKt.contains((CharSequence) name2, (CharSequence) "system", true)) {
            String name3 = file.getName();
            Intrinsics.checkNotNullExpressionValue(name3, "getName(...)");
            if (!StringsKt.endsWith(name3, ".bak", true) && ((parentFile = file.getParentFile()) == null || (name = parentFile.getName()) == null || !StringsKt.contains((CharSequence) name, (CharSequence) "system", true))) {
                z = false;
                return z || (!file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length == 0);
            }
        }
        z = true;
        if (z) {
            return true;
        }
    }

    private final boolean isKnownJunkExtension(File file) {
        List<String> list = junkExtensions;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (StringsKt.equals(FilesKt.getExtension(file), (String) it.next(), true)) {
                return true;
            }
        }
        return false;
    }
}
