package com.gcs.recovery.videos.files.photo_recovery.adapter;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.ShareInternalUtility;
import com.demo.example.R;
import com.gcs.recovery.videos.files.photo_recovery.adapter.JunkFileAdapter;
import com.demo.example.databinding.ItemCategoryBinding;
import com.demo.example.databinding.ItemJunkFileBinding;
import com.gcs.recovery.videos.files.photo_recovery.utils.Utils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: JunkFileAdapter.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005'()*+B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\u0010\fJ\u0006\u0010\u000f\u001a\u00020\u000bJ\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\u0018\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\u0018\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0016H\u0016J \u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u0016H\u0002J\b\u0010#\u001a\u00020\u000bH\u0002J\u0014\u0010$\u001a\u00020\u000b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\b\u0010&\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/adapter/JunkFileAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "sections", "", "Lcom/gcs/recovery/videos/files/photo_recovery/adapter/JunkFileAdapter$Section;", "onSizeUpdated", "Lkotlin/Function1;", "", "", "(Landroid/content/Context;Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "displayItems", "Lcom/gcs/recovery/videos/files/photo_recovery/adapter/JunkFileAdapter$SectionItem;", "deleteSelectedFiles", "flattenSections", "getApkIcon", "Landroid/graphics/drawable/Drawable;", "apkFilePath", "", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "resizeDrawable", "image", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "updateCategorySelection", "updateJunkFiles", "newSections", "updateTotalSize", "CategoryHeaderViewHolder", "Companion", "JunkFileViewHolder", "Section", "SectionItem", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class JunkFileAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int HEADER_VIEW_TYPE = 0;
    private static final int ITEM_VIEW_TYPE = 1;
    private final Context context;
    private List<? extends SectionItem> displayItems;
    private final Function1<Long, Unit> onSizeUpdated;
    private List<Section> sections;

    /* JADX WARN: Multi-variable type inference failed */
    public JunkFileAdapter(Context context, List<Section> sections, Function1<? super Long, Unit> onSizeUpdated) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sections, "sections");
        Intrinsics.checkNotNullParameter(onSizeUpdated, "onSizeUpdated");
        this.context = context;
        this.sections = sections;
        this.onSizeUpdated = onSizeUpdated;
        this.displayItems = flattenSections(sections);
    }

    /* compiled from: JunkFileAdapter.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001dB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0018J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/adapter/JunkFileAdapter$Section;", "", "categoryName", "", "files", "", "Lcom/gcs/recovery/videos/files/photo_recovery/adapter/JunkFileAdapter$Section$FileItem;", "isExpanded", "", "(Ljava/lang/String;Ljava/util/List;Z)V", "getCategoryName", "()Ljava/lang/String;", "getFiles", "()Ljava/util/List;", "()Z", "setExpanded", "(Z)V", "component1", "component2", "component3", "copy", "equals", "other", "getSelectedSize", "", "getTotalSize", "hashCode", "", "toString", "FileItem", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Section {
        private final String categoryName;
        private final List<FileItem> files;
        private boolean isExpanded;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Section copy$default(Section section, String str, List list, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = section.categoryName;
            }
            if ((i & 2) != 0) {
                list = section.files;
            }
            if ((i & 4) != 0) {
                z = section.isExpanded;
            }
            return section.copy(str, list, z);
        }

        /* renamed from: component1, reason: from getter */
        public final String getCategoryName() {
            return this.categoryName;
        }

        public final List<FileItem> component2() {
            return this.files;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsExpanded() {
            return this.isExpanded;
        }

        public final Section copy(String categoryName, List<FileItem> files, boolean isExpanded) {
            Intrinsics.checkNotNullParameter(categoryName, "categoryName");
            Intrinsics.checkNotNullParameter(files, "files");
            return new Section(categoryName, files, isExpanded);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Section)) {
                return false;
            }
            Section section = (Section) other;
            return Intrinsics.areEqual(this.categoryName, section.categoryName) && Intrinsics.areEqual(this.files, section.files) && this.isExpanded == section.isExpanded;
        }

        public final String getCategoryName() {
            return this.categoryName;
        }

        public final List<FileItem> getFiles() {
            return this.files;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((this.categoryName.hashCode() * 31) + this.files.hashCode()) * 31;
            boolean z = this.isExpanded;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return hashCode + i;
        }

        public final boolean isExpanded() {
            return this.isExpanded;
        }

        public final void setExpanded(boolean z) {
            this.isExpanded = z;
        }

        public String toString() {
            return "Section(categoryName=" + this.categoryName + ", files=" + this.files + ", isExpanded=" + this.isExpanded + ')';
        }

        /* compiled from: JunkFileAdapter.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/adapter/JunkFileAdapter$Section$FileItem;", "", "filePath", "", "isSelected", "", "(Ljava/lang/String;Z)V", "getFilePath", "()Ljava/lang/String;", "()Z", "setSelected", "(Z)V", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class FileItem {
            private final String filePath;
            private boolean isSelected;

            public static /* synthetic */ FileItem copy$default(FileItem fileItem, String str, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = fileItem.filePath;
                }
                if ((i & 2) != 0) {
                    z = fileItem.isSelected;
                }
                return fileItem.copy(str, z);
            }

            /* renamed from: component1, reason: from getter */
            public final String getFilePath() {
                return this.filePath;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getIsSelected() {
                return this.isSelected;
            }

            public final FileItem copy(String filePath, boolean isSelected) {
                Intrinsics.checkNotNullParameter(filePath, "filePath");
                return new FileItem(filePath, isSelected);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof FileItem)) {
                    return false;
                }
                FileItem fileItem = (FileItem) other;
                return Intrinsics.areEqual(this.filePath, fileItem.filePath) && this.isSelected == fileItem.isSelected;
            }

            public final String getFilePath() {
                return this.filePath;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                int hashCode = this.filePath.hashCode() * 31;
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
                return "FileItem(filePath=" + this.filePath + ", isSelected=" + this.isSelected + ')';
            }

            public FileItem(String filePath, boolean z) {
                Intrinsics.checkNotNullParameter(filePath, "filePath");
                this.filePath = filePath;
                this.isSelected = z;
            }

            public /* synthetic */ FileItem(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, (i & 2) != 0 ? false : z);
            }
        }

        public Section(String categoryName, List<FileItem> files, boolean z) {
            Intrinsics.checkNotNullParameter(categoryName, "categoryName");
            Intrinsics.checkNotNullParameter(files, "files");
            this.categoryName = categoryName;
            this.files = files;
            this.isExpanded = z;
        }

        public /* synthetic */ Section(String str, List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, list, (i & 4) != 0 ? false : z);
        }

        public final long getTotalSize() {
            Iterator<T> it = this.files.iterator();
            long j = 0;
            while (it.hasNext()) {
                j += new File(((FileItem) it.next()).getFilePath()).length();
            }
            return j;
        }

        public final long getSelectedSize() {
            List<FileItem> list = this.files;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((FileItem) obj).isSelected()) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            long j = 0;
            while (it.hasNext()) {
                j += new File(((FileItem) it.next()).getFilePath()).length();
            }
            return j;
        }
    }

    /* compiled from: JunkFileAdapter.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/adapter/JunkFileAdapter$SectionItem;", "", "()V", "Header", "Item", "Lcom/gcs/recovery/videos/files/photo_recovery/adapter/JunkFileAdapter$SectionItem$Header;", "Lcom/gcs/recovery/videos/files/photo_recovery/adapter/JunkFileAdapter$SectionItem$Item;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class SectionItem {
        public /* synthetic */ SectionItem(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: JunkFileAdapter.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/adapter/JunkFileAdapter$SectionItem$Header;", "Lcom/gcs/recovery/videos/files/photo_recovery/adapter/JunkFileAdapter$SectionItem;", "section", "Lcom/gcs/recovery/videos/files/photo_recovery/adapter/JunkFileAdapter$Section;", "(Lcom/gcs/recovery/videos/files/photo_recovery/adapter/JunkFileAdapter$Section;)V", "getSection", "()Lcom/gcs/recovery/videos/files/photo_recovery/adapter/JunkFileAdapter$Section;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Header extends SectionItem {
            private final Section section;

            public static /* synthetic */ Header copy$default(Header header, Section section, int i, Object obj) {
                if ((i & 1) != 0) {
                    section = header.section;
                }
                return header.copy(section);
            }

            /* renamed from: component1, reason: from getter */
            public final Section getSection() {
                return this.section;
            }

            public final Header copy(Section section) {
                Intrinsics.checkNotNullParameter(section, "section");
                return new Header(section);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Header) && Intrinsics.areEqual(this.section, ((Header) other).section);
            }

            public final Section getSection() {
                return this.section;
            }

            public int hashCode() {
                return this.section.hashCode();
            }

            public String toString() {
                return "Header(section=" + this.section + ')';
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Header(Section section) {
                super(null);
                Intrinsics.checkNotNullParameter(section, "section");
                this.section = section;
            }
        }

        private SectionItem() {
        }

        /* compiled from: JunkFileAdapter.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/adapter/JunkFileAdapter$SectionItem$Item;", "Lcom/gcs/recovery/videos/files/photo_recovery/adapter/JunkFileAdapter$SectionItem;", ShareInternalUtility.STAGING_PARAM, "Lcom/gcs/recovery/videos/files/photo_recovery/adapter/JunkFileAdapter$Section$FileItem;", "(Lcom/gcs/recovery/videos/files/photo_recovery/adapter/JunkFileAdapter$Section$FileItem;)V", "getFile", "()Lcom/gcs/recovery/videos/files/photo_recovery/adapter/JunkFileAdapter$Section$FileItem;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Item extends SectionItem {
            private final Section.FileItem file;

            public static /* synthetic */ Item copy$default(Item item, Section.FileItem fileItem, int i, Object obj) {
                if ((i & 1) != 0) {
                    fileItem = item.file;
                }
                return item.copy(fileItem);
            }

            /* renamed from: component1, reason: from getter */
            public final Section.FileItem getFile() {
                return this.file;
            }

            public final Item copy(Section.FileItem file) {
                Intrinsics.checkNotNullParameter(file, "file");
                return new Item(file);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Item) && Intrinsics.areEqual(this.file, ((Item) other).file);
            }

            public final Section.FileItem getFile() {
                return this.file;
            }

            public int hashCode() {
                return this.file.hashCode();
            }

            public String toString() {
                return "Item(file=" + this.file + ')';
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Item(Section.FileItem file) {
                super(null);
                Intrinsics.checkNotNullParameter(file, "file");
                this.file = file;
            }
        }
    }

    /* compiled from: JunkFileAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/adapter/JunkFileAdapter$CategoryHeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ItemCategoryBinding;", "(Lcom/gcs/recovery/videos/files/photo_recovery/adapter/JunkFileAdapter;Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ItemCategoryBinding;)V", "bind", "", "section", "Lcom/gcs/recovery/videos/files/photo_recovery/adapter/JunkFileAdapter$Section;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class CategoryHeaderViewHolder extends RecyclerView.ViewHolder {
        private final ItemCategoryBinding binding;
        final /* synthetic */ JunkFileAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CategoryHeaderViewHolder(JunkFileAdapter junkFileAdapter, ItemCategoryBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = junkFileAdapter;
            this.binding = binding;
        }

        public final void bind(final Section section) {
            Intrinsics.checkNotNullParameter(section, "section");
            this.binding.categoryName.setText(section.getCategoryName());
            this.binding.categorySize.setText(Utils.INSTANCE.formatSize(section.getTotalSize()));
            final boolean z = false;
            this.binding.expandCollapseIcon.setVisibility(section.isExpanded() ? 0 : 8);
            this.binding.expandUnCollapseIcon.setVisibility(!section.isExpanded() ? 0 : 8);
            if (section.isExpanded()) {
                this.binding.expandCollapseIcon.setVisibility(View.VISIBLE);
                this.binding.expandUnCollapseIcon.setVisibility(View.GONE);
            } else {
                this.binding.expandCollapseIcon.setVisibility(View.GONE);
                this.binding.expandUnCollapseIcon.setVisibility(View.VISIBLE);
            }
            List<Section.FileItem> files = section.getFiles();
            if (!(files instanceof Collection) || !files.isEmpty()) {
                Iterator<T> it = files.iterator();
                while (it.hasNext()) {
                    if (!((Section.FileItem) it.next()).isSelected()) {
                        break;
                    }
                }
            }
            z = true;
            this.binding.categoryCheckBox.setImageResource(z ? R.drawable.ic_slct : R.drawable.ic_dslct);
            RelativeLayout root = this.binding.getRoot();
            final JunkFileAdapter junkFileAdapter = this.this$0;
            root.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.adapter.JunkFileAdapter$CategoryHeaderViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    JunkFileAdapter.CategoryHeaderViewHolder.bind$lambda$1(JunkFileAdapter.Section.this, junkFileAdapter, view);
                }
            });
            AppCompatImageView appCompatImageView = this.binding.categoryCheckBox;
            final JunkFileAdapter junkFileAdapter2 = this.this$0;
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.adapter.JunkFileAdapter$CategoryHeaderViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    JunkFileAdapter.CategoryHeaderViewHolder.bind$lambda$3(z, section, junkFileAdapter2, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$1(Section section, JunkFileAdapter this$0, View view) {
            Intrinsics.checkNotNullParameter(section, "$section");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            section.setExpanded(!section.isExpanded());
            this$0.displayItems = this$0.flattenSections(this$0.sections);
            this$0.notifyDataSetChanged();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$3(boolean z, Section section, JunkFileAdapter this$0, View view) {
            Intrinsics.checkNotNullParameter(section, "$section");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            boolean z2 = !z;
            Iterator<T> it = section.getFiles().iterator();
            while (it.hasNext()) {
                ((Section.FileItem) it.next()).setSelected(z2);
            }
            this$0.updateTotalSize();
            this$0.notifyDataSetChanged();
        }
    }

    /* compiled from: JunkFileAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/adapter/JunkFileAdapter$JunkFileViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ItemJunkFileBinding;", "(Lcom/gcs/recovery/videos/files/photo_recovery/adapter/JunkFileAdapter;Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ItemJunkFileBinding;)V", "bind", "", "fileItem", "Lcom/gcs/recovery/videos/files/photo_recovery/adapter/JunkFileAdapter$Section$FileItem;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class JunkFileViewHolder extends RecyclerView.ViewHolder {
        private final ItemJunkFileBinding binding;
        final /* synthetic */ JunkFileAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public JunkFileViewHolder(JunkFileAdapter junkFileAdapter, ItemJunkFileBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = junkFileAdapter;
            this.binding = binding;
        }

        public final void bind(final Section.FileItem fileItem) {
            Intrinsics.checkNotNullParameter(fileItem, "fileItem");
            File file = new File(fileItem.getFilePath());
            this.binding.fileName.setText(file.getName());
            this.binding.fileSize.setText(Utils.INSTANCE.formatSize(file.length()));
            this.binding.fileDate.setText(Utils.INSTANCE.formatDate(file.lastModified()));
            this.binding.fileCheckBox.setImageResource(fileItem.isSelected() ? R.drawable.ic_slct : R.drawable.ic_dslct);
            if (StringsKt.endsWith$default(fileItem.getFilePath(), ".apk", false, 2, (Object) null)) {
                Drawable apkIcon = this.this$0.getApkIcon(fileItem.getFilePath());
                if (apkIcon != null) {
                    this.binding.itemImage.setImageDrawable(apkIcon);
                } else {
                    this.binding.itemImage.setImageResource(R.drawable.file_apk);
                }
            } else {
                this.binding.itemImage.setImageResource(R.drawable.file_unknown);
            }
            RelativeLayout root = this.binding.getRoot();
            final JunkFileAdapter junkFileAdapter = this.this$0;
            root.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.adapter.JunkFileAdapter$JunkFileViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    JunkFileAdapter.JunkFileViewHolder.bind$lambda$0(JunkFileAdapter.Section.FileItem.this, this, junkFileAdapter, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0(Section.FileItem fileItem, JunkFileViewHolder this$0, JunkFileAdapter this$1, View view) {
            Intrinsics.checkNotNullParameter(fileItem, "$fileItem");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            fileItem.setSelected(!fileItem.isSelected());
            this$0.binding.fileCheckBox.setImageResource(fileItem.isSelected() ? R.drawable.ic_slct : R.drawable.ic_dslct);
            this$1.updateCategorySelection();
            this$1.updateTotalSize();
            this$1.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateCategorySelection() {
        for (Section section : this.sections) {
            List<Section.FileItem> files = section.getFiles();
            boolean z = true;
            if (!(files instanceof Collection) || !files.isEmpty()) {
                Iterator<T> it = files.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!((Section.FileItem) it.next()).isSelected()) {
                            z = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            section.setExpanded(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Drawable getApkIcon(String apkFilePath) {
        ApplicationInfo applicationInfo;
        PackageManager packageManager = this.context.getPackageManager();
        Intrinsics.checkNotNullExpressionValue(packageManager, "getPackageManager(...)");
        PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(apkFilePath, 1);
        if (packageArchiveInfo == null || (applicationInfo = packageArchiveInfo.applicationInfo) == null) {
            return null;
        }
        applicationInfo.sourceDir = apkFilePath;
        applicationInfo.publicSourceDir = apkFilePath;
        Drawable loadIcon = applicationInfo.loadIcon(packageManager);
        int dimensionPixelSize = this.context.getResources().getDimensionPixelSize(R.dimen.icon_size);
        Intrinsics.checkNotNull(loadIcon);
        return resizeDrawable(loadIcon, dimensionPixelSize, dimensionPixelSize);
    }

    private final Drawable resizeDrawable(Drawable image, int width, int height) {
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(createBitmap);
        image.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        image.draw(canvas);
        return new BitmapDrawable(this.context.getResources(), createBitmap);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        SectionItem sectionItem = this.displayItems.get(position);
        if (sectionItem instanceof SectionItem.Header) {
            return 0;
        }
        if (sectionItem instanceof SectionItem.Item) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            ItemCategoryBinding inflate = ItemCategoryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new CategoryHeaderViewHolder(this, inflate);
        }
        if (viewType == 1) {
            ItemJunkFileBinding inflate2 = ItemJunkFileBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(...)");
            return new JunkFileViewHolder(this, inflate2);
        }
        throw new IllegalArgumentException("Invalid view type");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof CategoryHeaderViewHolder) {
            SectionItem sectionItem = this.displayItems.get(position);
            Intrinsics.checkNotNull(sectionItem, "null cannot be cast to non-null type com.gcs.recovery.videos.files.photo_recovery.adapter.JunkFileAdapter.SectionItem.Header");
            ((CategoryHeaderViewHolder) holder).bind(((SectionItem.Header) sectionItem).getSection());
        } else if (holder instanceof JunkFileViewHolder) {
            SectionItem sectionItem2 = this.displayItems.get(position);
            Intrinsics.checkNotNull(sectionItem2, "null cannot be cast to non-null type com.gcs.recovery.videos.files.photo_recovery.adapter.JunkFileAdapter.SectionItem.Item");
            ((JunkFileViewHolder) holder).bind(((SectionItem.Item) sectionItem2).getFile());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.displayItems.size();
    }

    public final void updateJunkFiles(List<Section> newSections) {
        Intrinsics.checkNotNullParameter(newSections, "newSections");
        this.sections = newSections;
        this.displayItems = flattenSections(newSections);
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<SectionItem> flattenSections(List<Section> sections) {
        ArrayList arrayList = new ArrayList();
        for (Section section : sections) {
            arrayList.add(new SectionItem.Header(section));
            if (section.isExpanded()) {
                Iterator<T> it = section.getFiles().iterator();
                while (it.hasNext()) {
                    arrayList.add(new SectionItem.Item((Section.FileItem) it.next()));
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateTotalSize() {
        Iterator<T> it = this.sections.iterator();
        long j = 0;
        while (it.hasNext()) {
            j += ((Section) it.next()).getSelectedSize();
        }
        this.onSizeUpdated.invoke(Long.valueOf(j));
    }

    public final void deleteSelectedFiles() {
        Iterator<T> it = this.sections.iterator();
        while (it.hasNext()) {
            Iterator<Section.FileItem> it2 = ((Section) it.next()).getFiles().iterator();
            while (it2.hasNext()) {
                Section.FileItem next = it2.next();
                if (next.isSelected()) {
                    File file = new File(next.getFilePath());
                    if (file.exists() && file.delete()) {
                        it2.remove();
                    }
                }
            }
        }
        this.displayItems = flattenSections(this.sections);
        updateTotalSize();
        notifyDataSetChanged();
    }
}
