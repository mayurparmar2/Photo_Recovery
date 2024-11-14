package com.gcs.recovery.videos.files.photo_recovery.model;

import com.facebook.share.internal.ShareInternalUtility;
import java.io.File;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PhotosModel.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/model/PhotosModel;", "", ShareInternalUtility.STAGING_PARAM, "Ljava/io/File;", "size", "", "dateAdded", "Ljava/util/Date;", "(Ljava/io/File;JLjava/util/Date;)V", "getDateAdded", "()Ljava/util/Date;", "getFile", "()Ljava/io/File;", "getSize", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class PhotosModel {
    private final Date dateAdded;
    private final File file;
    private final long size;

    public static /* synthetic */ PhotosModel copy$default(PhotosModel photosModel, File file, long j, Date date, int i, Object obj) {
        if ((i & 1) != 0) {
            file = photosModel.file;
        }
        if ((i & 2) != 0) {
            j = photosModel.size;
        }
        if ((i & 4) != 0) {
            date = photosModel.dateAdded;
        }
        return photosModel.copy(file, j, date);
    }

    /* renamed from: component1, reason: from getter */
    public final File getFile() {
        return this.file;
    }

    /* renamed from: component2, reason: from getter */
    public final long getSize() {
        return this.size;
    }

    /* renamed from: component3, reason: from getter */
    public final Date getDateAdded() {
        return this.dateAdded;
    }

    public final PhotosModel copy(File file, long size, Date dateAdded) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(dateAdded, "dateAdded");
        return new PhotosModel(file, size, dateAdded);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PhotosModel)) {
            return false;
        }
        PhotosModel photosModel = (PhotosModel) other;
        return Intrinsics.areEqual(this.file, photosModel.file) && this.size == photosModel.size && Intrinsics.areEqual(this.dateAdded, photosModel.dateAdded);
    }

    public final Date getDateAdded() {
        return this.dateAdded;
    }

    public final File getFile() {
        return this.file;
    }

    public final long getSize() {
        return this.size;
    }

    public int hashCode() {
        return (((this.file.hashCode() * 31) + Long.hashCode(this.size)) * 31) + this.dateAdded.hashCode();
    }

    public String toString() {
        return "PhotosModel(file=" + this.file + ", size=" + this.size + ", dateAdded=" + this.dateAdded + ')';
    }

    public PhotosModel(File file, long j, Date dateAdded) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(dateAdded, "dateAdded");
        this.file = file;
        this.size = j;
        this.dateAdded = dateAdded;
    }
}
