package com.gcs.recovery.videos.files.photo_recovery.model;

import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AlbumModel.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003JC\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/model/AlbumModel;", "", "albumName", "", "itemCount", "", "thumbnail", "Ljava/io/File;", "paths", "", "parentFolder", "(Ljava/lang/String;ILjava/io/File;Ljava/util/List;Ljava/lang/String;)V", "getAlbumName", "()Ljava/lang/String;", "getItemCount", "()I", "getParentFolder", "getPaths", "()Ljava/util/List;", "getThumbnail", "()Ljava/io/File;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class AlbumModel {
    private final String albumName;
    private final int itemCount;
    private final String parentFolder;
    private final List<String> paths;
    private final File thumbnail;

    public static /* synthetic */ AlbumModel copy$default(AlbumModel albumModel, String str, int i, File file, List list, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = albumModel.albumName;
        }
        if ((i2 & 2) != 0) {
            i = albumModel.itemCount;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            file = albumModel.thumbnail;
        }
        File file2 = file;
        if ((i2 & 8) != 0) {
            list = albumModel.paths;
        }
        List list2 = list;
        if ((i2 & 16) != 0) {
            str2 = albumModel.parentFolder;
        }
        return albumModel.copy(str, i3, file2, list2, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAlbumName() {
        return this.albumName;
    }

    /* renamed from: component2, reason: from getter */
    public final int getItemCount() {
        return this.itemCount;
    }

    /* renamed from: component3, reason: from getter */
    public final File getThumbnail() {
        return this.thumbnail;
    }

    public final List<String> component4() {
        return this.paths;
    }

    /* renamed from: component5, reason: from getter */
    public final String getParentFolder() {
        return this.parentFolder;
    }

    public final AlbumModel copy(String albumName, int itemCount, File thumbnail, List<String> paths, String parentFolder) {
        Intrinsics.checkNotNullParameter(albumName, "albumName");
        Intrinsics.checkNotNullParameter(thumbnail, "thumbnail");
        Intrinsics.checkNotNullParameter(paths, "paths");
        return new AlbumModel(albumName, itemCount, thumbnail, paths, parentFolder);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AlbumModel)) {
            return false;
        }
        AlbumModel albumModel = (AlbumModel) other;
        return Intrinsics.areEqual(this.albumName, albumModel.albumName) && this.itemCount == albumModel.itemCount && Intrinsics.areEqual(this.thumbnail, albumModel.thumbnail) && Intrinsics.areEqual(this.paths, albumModel.paths) && Intrinsics.areEqual(this.parentFolder, albumModel.parentFolder);
    }

    public final String getAlbumName() {
        return this.albumName;
    }

    public final int getItemCount() {
        return this.itemCount;
    }

    public final String getParentFolder() {
        return this.parentFolder;
    }

    public final List<String> getPaths() {
        return this.paths;
    }

    public final File getThumbnail() {
        return this.thumbnail;
    }

    public int hashCode() {
        int hashCode = ((((((this.albumName.hashCode() * 31) + Integer.hashCode(this.itemCount)) * 31) + this.thumbnail.hashCode()) * 31) + this.paths.hashCode()) * 31;
        String str = this.parentFolder;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "AlbumModel(albumName=" + this.albumName + ", itemCount=" + this.itemCount + ", thumbnail=" + this.thumbnail + ", paths=" + this.paths + ", parentFolder=" + this.parentFolder + ')';
    }

    public AlbumModel(String albumName, int i, File thumbnail, List<String> paths, String str) {
        Intrinsics.checkNotNullParameter(albumName, "albumName");
        Intrinsics.checkNotNullParameter(thumbnail, "thumbnail");
        Intrinsics.checkNotNullParameter(paths, "paths");
        this.albumName = albumName;
        this.itemCount = i;
        this.thumbnail = thumbnail;
        this.paths = paths;
        this.parentFolder = str;
    }

    public /* synthetic */ AlbumModel(String str, int i, File file, List list, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, file, (i2 & 8) != 0 ? CollectionsKt.emptyList() : list, (i2 & 16) != 0 ? null : str2);
    }
}
