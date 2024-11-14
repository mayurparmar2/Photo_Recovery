package com.gcs.recovery.videos.files.photo_recovery.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SharedDataHolder.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010!\n\u0002\b \bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u000eR\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000eR\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\f\"\u0004\b!\u0010\u000eR\u001e\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\f\"\u0004\b+\u0010\u000eR\"\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\f\"\u0004\b.\u0010\u000eR\"\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\f\"\u0004\b1\u0010\u000eR\"\u00102\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\f\"\u0004\b4\u0010\u000eR \u00105\u001a\b\u0012\u0004\u0012\u00020\u000406X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\f\"\u0004\b8\u0010\u000eR\u001e\u00109\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b:\u0010%\"\u0004\b;\u0010'R\"\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\f\"\u0004\b>\u0010\u000eR\u001e\u0010?\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b@\u0010%\"\u0004\bA\u0010'R\"\u0010B\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\f\"\u0004\bD\u0010\u000eR\"\u0010E\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\f\"\u0004\bG\u0010\u000eR\u001e\u0010H\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\bI\u0010%\"\u0004\bJ\u0010'R\"\u0010K\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\f\"\u0004\bM\u0010\u000eR\u001a\u0010N\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\"\u0010S\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\f\"\u0004\bU\u0010\u000e¨\u0006V"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/utils/SharedDataHolder;", "", "()V", "albumFolderPath", "", "getAlbumFolderPath", "()Ljava/lang/String;", "setAlbumFolderPath", "(Ljava/lang/String;)V", "allAudioPaths", "", "getAllAudioPaths", "()Ljava/util/List;", "setAllAudioPaths", "(Ljava/util/List;)V", "allDocPaths", "getAllDocPaths", "setAllDocPaths", "allPhotoPaths", "getAllPhotoPaths", "setAllPhotoPaths", "allVideoPaths", "getAllVideoPaths", "setAllVideoPaths", "audioFiles", "Ljava/io/File;", "getAudioFiles", "setAudioFiles", "docFiles", "getDocFiles", "setDocFiles", "duplicateFiles", "getDuplicateFiles", "setDuplicateFiles", "duplicateFilesSize", "", "getDuplicateFilesSize", "()Ljava/lang/Long;", "setDuplicateFilesSize", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "hiddenAudioPaths", "getHiddenAudioPaths", "setHiddenAudioPaths", "hiddenDocPaths", "getHiddenDocPaths", "setHiddenDocPaths", "hiddenPhotoPaths", "getHiddenPhotoPaths", "setHiddenPhotoPaths", "hiddenVideoPaths", "getHiddenVideoPaths", "setHiddenVideoPaths", "junkFilesList", "", "getJunkFilesList", "setJunkFilesList", "junkFilesSize", "getJunkFilesSize", "setJunkFilesSize", "largeFiles", "getLargeFiles", "setLargeFiles", "largeFilesSize", "getLargeFilesSize", "setLargeFilesSize", "photoFiles", "getPhotoFiles", "setPhotoFiles", "screenshotFiles", "getScreenshotFiles", "setScreenshotFiles", "screenshotFilesSize", "getScreenshotFilesSize", "setScreenshotFilesSize", "thumbnailsPath", "getThumbnailsPath", "setThumbnailsPath", "totalJunkSize", "getTotalJunkSize", "()J", "setTotalJunkSize", "(J)V", "videoFiles", "getVideoFiles", "setVideoFiles", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SharedDataHolder {
    private static String albumFolderPath;
    private static List<String> allAudioPaths;
    private static List<String> allDocPaths;
    private static List<String> allPhotoPaths;
    private static List<String> allVideoPaths;
    private static List<? extends File> audioFiles;
    private static List<? extends File> docFiles;
    private static List<? extends File> duplicateFiles;
    private static Long duplicateFilesSize;
    private static List<String> hiddenAudioPaths;
    private static List<String> hiddenDocPaths;
    private static List<String> hiddenPhotoPaths;
    private static List<String> hiddenVideoPaths;
    private static Long junkFilesSize;
    private static List<? extends File> largeFiles;
    private static Long largeFilesSize;
    private static List<? extends File> photoFiles;
    private static List<? extends File> screenshotFiles;
    private static Long screenshotFilesSize;
    private static List<String> thumbnailsPath;
    private static long totalJunkSize;
    private static List<? extends File> videoFiles;
    public static final SharedDataHolder INSTANCE = new SharedDataHolder();
    private static List<String> junkFilesList = new ArrayList();

    public final String getAlbumFolderPath() {
        return albumFolderPath;
    }

    public final List<String> getAllAudioPaths() {
        return allAudioPaths;
    }

    public final List<String> getAllDocPaths() {
        return allDocPaths;
    }

    public final List<String> getAllPhotoPaths() {
        return allPhotoPaths;
    }

    public final List<String> getAllVideoPaths() {
        return allVideoPaths;
    }

    public final List<File> getAudioFiles() {
        return audioFiles;
    }

    public final List<File> getDocFiles() {
        return docFiles;
    }

    public final List<File> getDuplicateFiles() {
        return duplicateFiles;
    }

    public final Long getDuplicateFilesSize() {
        return duplicateFilesSize;
    }

    public final List<String> getHiddenAudioPaths() {
        return hiddenAudioPaths;
    }

    public final List<String> getHiddenDocPaths() {
        return hiddenDocPaths;
    }

    public final List<String> getHiddenPhotoPaths() {
        return hiddenPhotoPaths;
    }

    public final List<String> getHiddenVideoPaths() {
        return hiddenVideoPaths;
    }

    public final List<String> getJunkFilesList() {
        return junkFilesList;
    }

    public final Long getJunkFilesSize() {
        return junkFilesSize;
    }

    public final List<File> getLargeFiles() {
        return largeFiles;
    }

    public final Long getLargeFilesSize() {
        return largeFilesSize;
    }

    public final List<File> getPhotoFiles() {
        return photoFiles;
    }

    public final List<File> getScreenshotFiles() {
        return screenshotFiles;
    }

    public final Long getScreenshotFilesSize() {
        return screenshotFilesSize;
    }

    public final List<String> getThumbnailsPath() {
        return thumbnailsPath;
    }

    public final long getTotalJunkSize() {
        return totalJunkSize;
    }

    public final List<File> getVideoFiles() {
        return videoFiles;
    }

    public final void setAlbumFolderPath(String str) {
        albumFolderPath = str;
    }

    public final void setAllAudioPaths(List<String> list) {
        allAudioPaths = list;
    }

    public final void setAllDocPaths(List<String> list) {
        allDocPaths = list;
    }

    public final void setAllPhotoPaths(List<String> list) {
        allPhotoPaths = list;
    }

    public final void setAllVideoPaths(List<String> list) {
        allVideoPaths = list;
    }

    public final void setAudioFiles(List<? extends File> list) {
        audioFiles = list;
    }

    public final void setDocFiles(List<? extends File> list) {
        docFiles = list;
    }

    public final void setDuplicateFiles(List<? extends File> list) {
        duplicateFiles = list;
    }

    public final void setDuplicateFilesSize(Long l) {
        duplicateFilesSize = l;
    }

    public final void setHiddenAudioPaths(List<String> list) {
        hiddenAudioPaths = list;
    }

    public final void setHiddenDocPaths(List<String> list) {
        hiddenDocPaths = list;
    }

    public final void setHiddenPhotoPaths(List<String> list) {
        hiddenPhotoPaths = list;
    }

    public final void setHiddenVideoPaths(List<String> list) {
        hiddenVideoPaths = list;
    }

    public final void setJunkFilesList(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        junkFilesList = list;
    }

    public final void setJunkFilesSize(Long l) {
        junkFilesSize = l;
    }

    public final void setLargeFiles(List<? extends File> list) {
        largeFiles = list;
    }

    public final void setLargeFilesSize(Long l) {
        largeFilesSize = l;
    }

    public final void setPhotoFiles(List<? extends File> list) {
        photoFiles = list;
    }

    public final void setScreenshotFiles(List<? extends File> list) {
        screenshotFiles = list;
    }

    public final void setScreenshotFilesSize(Long l) {
        screenshotFilesSize = l;
    }

    public final void setThumbnailsPath(List<String> list) {
        thumbnailsPath = list;
    }

    public final void setTotalJunkSize(long j) {
        totalJunkSize = j;
    }

    public final void setVideoFiles(List<? extends File> list) {
        videoFiles = list;
    }

    private SharedDataHolder() {
    }
}
