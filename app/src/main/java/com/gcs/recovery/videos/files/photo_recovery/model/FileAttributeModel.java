package com.gcs.recovery.videos.files.photo_recovery.model;


import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FileAttributeModel.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/model/FileAttributeModel;", "", Constants.ScionAnalytics.PARAM_LABEL, "", "value", "(Ljava/lang/String;Ljava/lang/String;)V", "getLabel", "()Ljava/lang/String;", "getValue", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class FileAttributeModel {
    private final String label;
    private final String value;

    public static /* synthetic */ FileAttributeModel copy$default(FileAttributeModel fileAttributeModel, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fileAttributeModel.label;
        }
        if ((i & 2) != 0) {
            str2 = fileAttributeModel.value;
        }
        return fileAttributeModel.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* renamed from: component2, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    public final FileAttributeModel copy(String label, String value) {
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(value, "value");
        return new FileAttributeModel(label, value);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileAttributeModel)) {
            return false;
        }
        FileAttributeModel fileAttributeModel = (FileAttributeModel) other;
        return Intrinsics.areEqual(this.label, fileAttributeModel.label) && Intrinsics.areEqual(this.value, fileAttributeModel.value);
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return (this.label.hashCode() * 31) + this.value.hashCode();
    }

    public String toString() {
        return "FileAttributeModel(label=" + this.label + ", value=" + this.value + ')';
    }

    public FileAttributeModel(String label, String value) {
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(value, "value");
        this.label = label;
        this.value = value;
    }
}
