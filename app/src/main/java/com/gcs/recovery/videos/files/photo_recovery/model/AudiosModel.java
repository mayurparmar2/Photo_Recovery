package com.gcs.recovery.videos.files.photo_recovery.model;


import com.facebook.share.internal.ShareInternalUtility;
import java.io.File;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AudiosModel.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/model/AudiosModel;", "", ShareInternalUtility.STAGING_PARAM, "Ljava/io/File;", TypedValues.TransitionType.S_DURATION, "", "dateAdded", "Ljava/util/Date;", "size", "(Ljava/io/File;JLjava/util/Date;J)V", "getDateAdded", "()Ljava/util/Date;", "getDuration", "()J", "setDuration", "(J)V", "getFile", "()Ljava/io/File;", "getSize", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class AudiosModel {
    private final Date dateAdded;
    private long duration;
    private final File file;
    private final long size;

    public static /* synthetic */ AudiosModel copy$default(AudiosModel audiosModel, File file, long j, Date date, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            file = audiosModel.file;
        }
        if ((i & 2) != 0) {
            j = audiosModel.duration;
        }
        long j3 = j;
        if ((i & 4) != 0) {
            date = audiosModel.dateAdded;
        }
        Date date2 = date;
        if ((i & 8) != 0) {
            j2 = audiosModel.size;
        }
        return audiosModel.copy(file, j3, date2, j2);
    }

    /* renamed from: component1, reason: from getter */
    public final File getFile() {
        return this.file;
    }

    /* renamed from: component2, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    /* renamed from: component3, reason: from getter */
    public final Date getDateAdded() {
        return this.dateAdded;
    }

    /* renamed from: component4, reason: from getter */
    public final long getSize() {
        return this.size;
    }

    public final AudiosModel copy(File file, long duration, Date dateAdded, long size) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(dateAdded, "dateAdded");
        return new AudiosModel(file, duration, dateAdded, size);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AudiosModel)) {
            return false;
        }
        AudiosModel audiosModel = (AudiosModel) other;
        return Intrinsics.areEqual(this.file, audiosModel.file) && this.duration == audiosModel.duration && Intrinsics.areEqual(this.dateAdded, audiosModel.dateAdded) && this.size == audiosModel.size;
    }

    public final Date getDateAdded() {
        return this.dateAdded;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final File getFile() {
        return this.file;
    }

    public final long getSize() {
        return this.size;
    }

    public int hashCode() {
        return (((((this.file.hashCode() * 31) + Long.hashCode(this.duration)) * 31) + this.dateAdded.hashCode()) * 31) + Long.hashCode(this.size);
    }

    public final void setDuration(long j) {
        this.duration = j;
    }

    public String toString() {
        return "AudiosModel(file=" + this.file + ", duration=" + this.duration + ", dateAdded=" + this.dateAdded + ", size=" + this.size + ')';
    }

    public AudiosModel(File file, long j, Date dateAdded, long j2) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(dateAdded, "dateAdded");
        this.file = file;
        this.duration = j;
        this.dateAdded = dateAdded;
        this.size = j2;
    }

    public /* synthetic */ AudiosModel(File file, long j, Date date, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, j, date, (i & 8) != 0 ? file.length() : j2);
    }
}
