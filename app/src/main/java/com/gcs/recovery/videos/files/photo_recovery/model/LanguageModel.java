package com.gcs.recovery.videos.files.photo_recovery.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LanguageModel.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/model/LanguageModel;", "", "name", "", "displayText", "flagIcon", "", "languageCode", "isSelected", "", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Z)V", "getDisplayText", "()Ljava/lang/String;", "getFlagIcon", "()I", "()Z", "setSelected", "(Z)V", "getLanguageCode", "getName", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class LanguageModel {
    private final String displayText;
    private final int flagIcon;
    private boolean isSelected;
    private final String languageCode;
    private final String name;

    public static /* synthetic */ LanguageModel copy$default(LanguageModel languageModel, String str, String str2, int i, String str3, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = languageModel.name;
        }
        if ((i2 & 2) != 0) {
            str2 = languageModel.displayText;
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            i = languageModel.flagIcon;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            str3 = languageModel.languageCode;
        }
        String str5 = str3;
        if ((i2 & 16) != 0) {
            z = languageModel.isSelected;
        }
        return languageModel.copy(str, str4, i3, str5, z);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDisplayText() {
        return this.displayText;
    }

    /* renamed from: component3, reason: from getter */
    public final int getFlagIcon() {
        return this.flagIcon;
    }

    /* renamed from: component4, reason: from getter */
    public final String getLanguageCode() {
        return this.languageCode;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    public final LanguageModel copy(String name, String displayText, int flagIcon, String languageCode, boolean isSelected) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(displayText, "displayText");
        Intrinsics.checkNotNullParameter(languageCode, "languageCode");
        return new LanguageModel(name, displayText, flagIcon, languageCode, isSelected);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LanguageModel)) {
            return false;
        }
        LanguageModel languageModel = (LanguageModel) other;
        return Intrinsics.areEqual(this.name, languageModel.name) && Intrinsics.areEqual(this.displayText, languageModel.displayText) && this.flagIcon == languageModel.flagIcon && Intrinsics.areEqual(this.languageCode, languageModel.languageCode) && this.isSelected == languageModel.isSelected;
    }

    public final String getDisplayText() {
        return this.displayText;
    }

    public final int getFlagIcon() {
        return this.flagIcon;
    }

    public final String getLanguageCode() {
        return this.languageCode;
    }

    public final String getName() {
        return this.name;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((this.name.hashCode() * 31) + this.displayText.hashCode()) * 31) + Integer.hashCode(this.flagIcon)) * 31) + this.languageCode.hashCode()) * 31;
        boolean z = this.isSelected;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    public String toString() {
        return "LanguageModel(name=" + this.name + ", displayText=" + this.displayText + ", flagIcon=" + this.flagIcon + ", languageCode=" + this.languageCode + ", isSelected=" + this.isSelected + ')';
    }

    public LanguageModel(String name, String displayText, int i, String languageCode, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(displayText, "displayText");
        Intrinsics.checkNotNullParameter(languageCode, "languageCode");
        this.name = name;
        this.displayText = displayText;
        this.flagIcon = i;
        this.languageCode = languageCode;
        this.isSelected = z;
    }

    public /* synthetic */ LanguageModel(String str, String str2, int i, String str3, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i, str3, (i2 & 16) != 0 ? false : z);
    }
}
