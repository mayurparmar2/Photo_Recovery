package com.gcs.recovery.videos.files.photo_recovery.model;

import android.net.Uri;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MediaFile.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/model/MediaFile;", "", "displayName", "", "filePath", "contentUri", "Landroid/net/Uri;", "size", "", TypedValues.TransitionType.S_DURATION, "(Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;JJ)V", "getContentUri", "()Landroid/net/Uri;", "getDisplayName", "()Ljava/lang/String;", "getDuration", "()J", "getFilePath", "getSize", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class MediaFile {
    private final Uri contentUri;
    private final String displayName;
    private final long duration;
    private final String filePath;
    private final long size;

    public static /* synthetic */ MediaFile copy$default(MediaFile mediaFile, String str, String str2, Uri uri, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mediaFile.displayName;
        }
        if ((i & 2) != 0) {
            str2 = mediaFile.filePath;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            uri = mediaFile.contentUri;
        }
        Uri uri2 = uri;
        if ((i & 8) != 0) {
            j = mediaFile.size;
        }
        long j3 = j;
        if ((i & 16) != 0) {
            j2 = mediaFile.duration;
        }
        return mediaFile.copy(str, str3, uri2, j3, j2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getFilePath() {
        return this.filePath;
    }

    /* renamed from: component3, reason: from getter */
    public final Uri getContentUri() {
        return this.contentUri;
    }

    /* renamed from: component4, reason: from getter */
    public final long getSize() {
        return this.size;
    }

    /* renamed from: component5, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    public final MediaFile copy(String displayName, String filePath, Uri contentUri, long size, long duration) {
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(contentUri, "contentUri");
        return new MediaFile(displayName, filePath, contentUri, size, duration);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaFile)) {
            return false;
        }
        MediaFile mediaFile = (MediaFile) other;
        return Intrinsics.areEqual(this.displayName, mediaFile.displayName) && Intrinsics.areEqual(this.filePath, mediaFile.filePath) && Intrinsics.areEqual(this.contentUri, mediaFile.contentUri) && this.size == mediaFile.size && this.duration == mediaFile.duration;
    }

    public final Uri getContentUri() {
        return this.contentUri;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final String getFilePath() {
        return this.filePath;
    }

    public final long getSize() {
        return this.size;
    }

    public int hashCode() {
        return (((((((this.displayName.hashCode() * 31) + this.filePath.hashCode()) * 31) + this.contentUri.hashCode()) * 31) + Long.hashCode(this.size)) * 31) + Long.hashCode(this.duration);
    }

    public String toString() {
        return "MediaFile(displayName=" + this.displayName + ", filePath=" + this.filePath + ", contentUri=" + this.contentUri + ", size=" + this.size + ", duration=" + this.duration + ')';
    }

    public MediaFile(String displayName, String filePath, Uri contentUri, long j, long j2) {
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(contentUri, "contentUri");
        this.displayName = displayName;
        this.filePath = filePath;
        this.contentUri = contentUri;
        this.size = j;
        this.duration = j2;
    }
}
