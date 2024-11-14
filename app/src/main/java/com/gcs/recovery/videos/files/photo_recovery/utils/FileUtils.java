package com.gcs.recovery.videos.files.photo_recovery.utils;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FileUtils.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/utils/FileUtils;", "", "()V", "createAppFolders", "", "context", "Landroid/content/Context;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FileUtils {
    public static final FileUtils INSTANCE = new FileUtils();

    private FileUtils() {
    }

    public final void createAppFolders(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        File file = new File(Environment.getExternalStorageDirectory(), "PhotoRecovery");
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(file, "Photos");
        File file3 = new File(file, "Videos");
        File file4 = new File(file, "Audios");
        File file5 = new File(file, "Documents");
        if (!file2.exists()) {
            file2.mkdir();
        }
        if (!file3.exists()) {
            file3.mkdir();
        }
        if (!file4.exists()) {
            file4.mkdir();
        }
        if (file5.exists()) {
            return;
        }
        file5.mkdir();
    }
}
