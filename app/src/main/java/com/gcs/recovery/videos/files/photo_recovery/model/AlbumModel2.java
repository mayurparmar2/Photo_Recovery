package com.gcs.recovery.videos.files.photo_recovery.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AlbumModel2.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/model/AlbumModel2;", "", "albumName", "", "itemCount", "", "paths", "", "(Ljava/lang/String;ILjava/util/List;)V", "getAlbumName", "()Ljava/lang/String;", "getItemCount", "()I", "getPaths", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class AlbumModel2 {
    private final String albumName;
    private final int itemCount;
    private final List<String> paths;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AlbumModel2 copy$default(AlbumModel2 albumModel2, String str, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = albumModel2.albumName;
        }
        if ((i2 & 2) != 0) {
            i = albumModel2.itemCount;
        }
        if ((i2 & 4) != 0) {
            list = albumModel2.paths;
        }
        return albumModel2.copy(str, i, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAlbumName() {
        return this.albumName;
    }

    /* renamed from: component2, reason: from getter */
    public final int getItemCount() {
        return this.itemCount;
    }

    public final List<String> component3() {
        return this.paths;
    }

    public final AlbumModel2 copy(String albumName, int itemCount, List<String> paths) {
        Intrinsics.checkNotNullParameter(albumName, "albumName");
        Intrinsics.checkNotNullParameter(paths, "paths");
        return new AlbumModel2(albumName, itemCount, paths);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AlbumModel2)) {
            return false;
        }
        AlbumModel2 albumModel2 = (AlbumModel2) other;
        return Intrinsics.areEqual(this.albumName, albumModel2.albumName) && this.itemCount == albumModel2.itemCount && Intrinsics.areEqual(this.paths, albumModel2.paths);
    }

    public final String getAlbumName() {
        return this.albumName;
    }

    public final int getItemCount() {
        return this.itemCount;
    }

    public final List<String> getPaths() {
        return this.paths;
    }

    public int hashCode() {
        return (((this.albumName.hashCode() * 31) + Integer.hashCode(this.itemCount)) * 31) + this.paths.hashCode();
    }

    public String toString() {
        return "AlbumModel2(albumName=" + this.albumName + ", itemCount=" + this.itemCount + ", paths=" + this.paths + ')';
    }

    public AlbumModel2(String albumName, int i, List<String> paths) {
        Intrinsics.checkNotNullParameter(albumName, "albumName");
        Intrinsics.checkNotNullParameter(paths, "paths");
        this.albumName = albumName;
        this.itemCount = i;
        this.paths = paths;
    }

    public /* synthetic */ AlbumModel2(String str, int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, (i2 & 4) != 0 ? CollectionsKt.emptyList() : list);
    }
}
