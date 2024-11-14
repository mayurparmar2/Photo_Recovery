package com.gcs.recovery.videos.files.photo_recovery.utils;

import android.support.v4.media.session.PlaybackStateCompat;

import com.facebook.share.internal.ShareInternalUtility;
import com.demo.example.R;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: Utils.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0007H\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007H\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H\u0002¨\u0006\u0016"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/utils/Utils;", "", "()V", "formatDate", "", "date", "Ljava/util/Date;", "", "formatDuration", TypedValues.TransitionType.S_DURATION, "formatSize", "size", "getFileIconResource", "", "fileExtension", "getIconForFileType", ShareInternalUtility.STAGING_PARAM, "Ljava/io/File;", "isSameDay", "", "time1", "time2", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Utils {
    public static final Utils INSTANCE = new Utils();

    private Utils() {
    }

    public final String formatSize(long size) {
        long j = 1024;
        long j2 = j * PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        long j3 = j * j2;
        if (size >= j3) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%.2f GB", Arrays.copyOf(new Object[]{Double.valueOf(size / j3)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return format;
        }
        if (size >= j2) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format("%.2f MB", Arrays.copyOf(new Object[]{Double.valueOf(size / j2)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            return format2;
        }
        if (size >= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
            String format3 = String.format("%.2f KB", Arrays.copyOf(new Object[]{Double.valueOf(size / PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID)}, 1));
            Intrinsics.checkNotNullExpressionValue(format3, "format(format, *args)");
            return format3;
        }
        return size + " Bytes";
    }

    public final String formatDate(Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        String format = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(date);
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    public final String formatDate(long date) {
        Calendar calendar = Calendar.getInstance();
        long timeInMillis = calendar.getTimeInMillis();
        calendar.add(5, -1);
        long timeInMillis2 = calendar.getTimeInMillis();
        if (isSameDay(date, timeInMillis)) {
            return "Today";
        }
        if (isSameDay(date, timeInMillis2)) {
            return "Yesterday";
        }
        String format = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(new Date(date));
        Intrinsics.checkNotNull(format);
        return format;
    }

    private final boolean isSameDay(long time1, long time2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(time2);
        return calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
    }

    public final String formatDuration(long duration) {
        long j = duration / 1000;
        long j2 = 60;
        long j3 = j % j2;
        long j4 = j / j2;
        long j5 = j4 % j2;
        long j6 = j4 / j2;
        if (j6 > 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j6), Long.valueOf(j5), Long.valueOf(j3)}, 3));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return format;
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String format2 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j5), Long.valueOf(j3)}, 2));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        return format2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:?, code lost:
    
        return com.gcs.recovery.videos.files.photo_recovery.R.drawable.file_apk;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0037, code lost:
    
        if (r2.equals("pptx") == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
    
        return com.gcs.recovery.videos.files.photo_recovery.R.drawable.file_ppt;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0041, code lost:
    
        if (r2.equals("json") == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:?, code lost:
    
        return com.gcs.recovery.videos.files.photo_recovery.R.drawable.file_code;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004b, code lost:
    
        if (r2.equals(com.onesignal.inAppMessages.internal.InAppMessageContent.HTML) == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0055, code lost:
    
        if (r2.equals("docx") == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:?, code lost:
    
        return com.gcs.recovery.videos.files.photo_recovery.R.drawable.file_doc;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005f, code lost:
    
        if (r2.equals("zip") == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:?, code lost:
    
        return com.gcs.recovery.videos.files.photo_recovery.R.drawable.file_zip;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0069, code lost:
    
        if (r2.equals("xml") == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0073, code lost:
    
        if (r2.equals("xls") == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ab, code lost:
    
        if (r2.equals("rar") == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0023, code lost:
    
        if (r2.equals("xlsx") == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00c1, code lost:
    
        if (r2.equals("ppt") == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00d9, code lost:
    
        if (r2.equals("htm") == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00e5, code lost:
    
        if (r2.equals("doc") == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00f1, code lost:
    
        if (r2.equals("apk") == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00fa, code lost:
    
        if (r2.equals("aab") == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0106, code lost:
    
        if (r2.equals("7z") == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:?, code lost:
    
        return com.gcs.recovery.videos.files.photo_recovery.R.drawable.file_xls;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002d, code lost:
    
        if (r2.equals("xapk") == false) goto L79;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int getIconForFileType(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        String lowerCase = FilesKt.getExtension(file).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        switch (lowerCase.hashCode()) {
            case 1827:
                break;
            case 96322:
                break;
            case 96796:
                break;
            case 99640:
                break;
            case 103649:
                break;
            case 110834:
                if (lowerCase.equals("pdf")) {
                    return R.drawable.file_pdf;
                }
                return R.drawable.file_unknown;
            case 111220:
                break;
            case 111297:
                if (lowerCase.equals("psd")) {
                    return R.drawable.file_psd;
                }
                return R.drawable.file_unknown;
            case 112675:
                break;
            case 114276:
                if (lowerCase.equals("svg")) {
                    return R.drawable.file_svg;
                }
                return R.drawable.file_unknown;
            case 115174:
                if (lowerCase.equals("ttf")) {
                    return R.drawable.file_ttf;
                }
                return R.drawable.file_unknown;
            case 115312:
                if (lowerCase.equals("txt")) {
                    return R.drawable.file_txt;
                }
                return R.drawable.file_unknown;
            case 118783:
                break;
            case 118807:
                break;
            case 120609:
                break;
            case 3088960:
                break;
            case 3213227:
                break;
            case 3271912:
                break;
            case 3447940:
                break;
            case 3671716:
                break;
            case 3682393:
                break;
            default:
                return R.drawable.file_unknown;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:?, code lost:
    
        return com.gcs.recovery.videos.files.photo_recovery.R.drawable.file_apk;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0038, code lost:
    
        if (r3.equals("pptx") == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
    
        return com.gcs.recovery.videos.files.photo_recovery.R.drawable.file_ppt;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0050, code lost:
    
        if (r3.equals(com.onesignal.inAppMessages.internal.InAppMessageContent.HTML) == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:?, code lost:
    
        return com.gcs.recovery.videos.files.photo_recovery.R.drawable.file_code;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005a, code lost:
    
        if (r3.equals("docx") == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:?, code lost:
    
        return com.gcs.recovery.videos.files.photo_recovery.R.drawable.file_doc;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0064, code lost:
    
        if (r3.equals("zip") == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
    
        return com.gcs.recovery.videos.files.photo_recovery.R.drawable.file_zip;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006e, code lost:
    
        if (r3.equals("xml") == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0078, code lost:
    
        if (r3.equals("xls") == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b0, code lost:
    
        if (r3.equals("rar") == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0024, code lost:
    
        if (r3.equals("xlsx") == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00c6, code lost:
    
        if (r3.equals("ppt") == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00de, code lost:
    
        if (r3.equals("htm") == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00ea, code lost:
    
        if (r3.equals("doc") == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00f6, code lost:
    
        if (r3.equals("apk") == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00ff, code lost:
    
        if (r3.equals("aab") == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x010b, code lost:
    
        if (r3.equals("7z") == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:?, code lost:
    
        return com.gcs.recovery.videos.files.photo_recovery.R.drawable.file_xls;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002e, code lost:
    
        if (r3.equals("xapk") == false) goto L80;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int getFileIconResource(String fileExtension) {
        Intrinsics.checkNotNullParameter(fileExtension, "fileExtension");
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = fileExtension.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        switch (lowerCase.hashCode()) {
            case 1827:
                break;
            case 96322:
                break;
            case 96796:
                break;
            case 99640:
                break;
            case 103649:
                break;
            case 110834:
                if (lowerCase.equals("pdf")) {
                    return R.drawable.file_pdf;
                }
                return R.drawable.file_unknown;
            case 111220:
                break;
            case 111297:
                if (lowerCase.equals("psd")) {
                    return R.drawable.file_psd;
                }
                return R.drawable.file_unknown;
            case 112675:
                break;
            case 114276:
                if (lowerCase.equals("svg")) {
                    return R.drawable.file_svg;
                }
                return R.drawable.file_unknown;
            case 115174:
                if (lowerCase.equals("ttf")) {
                    return R.drawable.file_ttf;
                }
                return R.drawable.file_unknown;
            case 115312:
                if (lowerCase.equals("txt")) {
                    return R.drawable.file_txt;
                }
                return R.drawable.file_unknown;
            case 118783:
                break;
            case 118807:
                break;
            case 120609:
                break;
            case 3088960:
                break;
            case 3213227:
                break;
            case 3271912:
                if (lowerCase.equals("json")) {
                    return R.drawable.file_database;
                }
                return R.drawable.file_unknown;
            case 3447940:
                break;
            case 3671716:
                break;
            case 3682393:
                break;
            default:
                return R.drawable.file_unknown;
        }
    }
}
