package com.gcs.recovery.videos.files.photo_recovery.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.ShareInternalUtility;
import com.demo.example.R;
import com.gcs.recovery.videos.files.photo_recovery.activity.ViewDocActivity;
import com.gcs.recovery.videos.files.photo_recovery.adapter.DuplicateFileAdapter;
import com.demo.example.databinding.ItemImagesBinding;
import com.gcs.recovery.videos.files.photo_recovery.utils.Utils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.objectweb.asm.signature.SignatureVisitor;

/* compiled from: DuplicateFileAdapter.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000245B\u001f\u0012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0002\u0010\bJ\u0006\u0010\u001a\u001a\u00020\u0007J\b\u0010\u001b\u001a\u00020\nH\u0016J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nH\u0016J\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00120\u001fJ\u0006\u0010 \u001a\u00020\u0005J\u0006\u0010!\u001a\u00020\nJ\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00140\u000f2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fH\u0002J$\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00140\u000f2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f2\u0006\u0010%\u001a\u00020\u0010H\u0002J\u0006\u0010&\u001a\u00020\u0006J\u0010\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0012H\u0002J\u001e\u0010)\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00122\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J\u0006\u0010+\u001a\u00020\u0006J\u0018\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\nH\u0016J\u0018\u0010.\u001a\u00020\u00022\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\nH\u0016J\u0006\u00102\u001a\u00020\u0007J\u0014\u00103\u001a\u00020\u00072\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fR\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\nX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/adapter/DuplicateFileAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onFileSelectionChanged", "Lkotlin/Function2;", "", "", "", "(Lkotlin/jvm/functions/Function2;)V", "ITEM_TYPE_FILE", "", "ITEM_TYPE_SET", "getITEM_TYPE_SET", "()I", "audioExtensions", "", "", "dupFiles", "Ljava/io/File;", "groupedItems", "", "imageExtensions", "selectedFiles", "", "selectionMode", "videoExtensions", "deselectAllFiles", "getItemCount", "getItemViewType", "position", "getSelectedFiles", "", "getSelectedFilesSize", "getSelectedItemCount", "groupFilesBySet", "files", "groupFilesBySetAndType", "setName", "isAllFilesSelected", "isDocumentFile", ShareInternalUtility.STAGING_PARAM, "isFileType", "extensions", "isSelectionMode", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "smartSelectAllFiles", "submitList", "DuplicateFileViewHolder", "SetViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DuplicateFileAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int ITEM_TYPE_FILE;
    private final int ITEM_TYPE_SET;
    private final List<String> audioExtensions;
    private List<? extends File> dupFiles;
    private List<? extends Object> groupedItems;
    private final List<String> imageExtensions;
    private final Function2<Long, Boolean, Unit> onFileSelectionChanged;
    private Set<File> selectedFiles;
    private boolean selectionMode;
    private final List<String> videoExtensions;

    public final int getITEM_TYPE_SET() {
        return this.ITEM_TYPE_SET;
    }

    public final Set<File> getSelectedFiles() {
        return this.selectedFiles;
    }

    /* renamed from: isSelectionMode, reason: from getter */
    public final boolean getSelectionMode() {
        return this.selectionMode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DuplicateFileAdapter(Function2<? super Long, ? super Boolean, Unit> onFileSelectionChanged) {
        Intrinsics.checkNotNullParameter(onFileSelectionChanged, "onFileSelectionChanged");
        this.onFileSelectionChanged = onFileSelectionChanged;
        this.ITEM_TYPE_FILE = 1;
        this.ITEM_TYPE_SET = 2;
        this.dupFiles = CollectionsKt.emptyList();
        this.groupedItems = CollectionsKt.emptyList();
        this.selectedFiles = new LinkedHashSet();
        this.imageExtensions = CollectionsKt.listOf((Object[]) new String[]{"jpg", "png", "gif", "bmp", "tiff", "svg", "psd"});
        this.videoExtensions = CollectionsKt.listOf((Object[]) new String[]{"mp4", "avi", "mov", "mkv", "wmv", "mpeg"});
        this.audioExtensions = CollectionsKt.listOf((Object[]) new String[]{"mp3", "wav", "m4a", "ogg", "aac", "flac"});
    }

    public final void submitList(List<? extends File> files) {
        Intrinsics.checkNotNullParameter(files, "files");
        this.dupFiles = CollectionsKt.sortedWith(files, new Comparator() { // from class: com.gcs.recovery.videos.files.photo_recovery.adapter.DuplicateFileAdapter$submitList$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Long.valueOf(((File) t2).lastModified()), Long.valueOf(((File) t).lastModified()));
            }
        });
        this.selectedFiles.clear();
        smartSelectAllFiles();
        this.groupedItems = groupFilesBySet(this.dupFiles);
        notifyDataSetChanged();
    }

    private final List<Object> groupFilesBySet(List<? extends File> files) {
        ArrayList arrayList = new ArrayList();
        for (Pair pair : CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("Images", new Function1<File, Boolean>() { // from class: com.gcs.recovery.videos.files.photo_recovery.adapter.DuplicateFileAdapter$groupFilesBySet$fileTypeGroups$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(File file) {
                boolean isFileType;
                Intrinsics.checkNotNullParameter(file, "file");
                isFileType = DuplicateFileAdapter.this.isFileType(file, CollectionsKt.listOf((Object[]) new String[]{"jpg", "png", "gif", "bmp", "tiff", "svg", "psd"}));
                return Boolean.valueOf(isFileType);
            }
        }), TuplesKt.to("Videos", new Function1<File, Boolean>() { // from class: com.gcs.recovery.videos.files.photo_recovery.adapter.DuplicateFileAdapter$groupFilesBySet$fileTypeGroups$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(File file) {
                boolean isFileType;
                Intrinsics.checkNotNullParameter(file, "file");
                isFileType = DuplicateFileAdapter.this.isFileType(file, CollectionsKt.listOf((Object[]) new String[]{"mp4", "avi", "mov", "mkv", "wmv", "mpeg"}));
                return Boolean.valueOf(isFileType);
            }
        }), TuplesKt.to("Audio", new Function1<File, Boolean>() { // from class: com.gcs.recovery.videos.files.photo_recovery.adapter.DuplicateFileAdapter$groupFilesBySet$fileTypeGroups$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(File file) {
                boolean isFileType;
                Intrinsics.checkNotNullParameter(file, "file");
                isFileType = DuplicateFileAdapter.this.isFileType(file, CollectionsKt.listOf((Object[]) new String[]{"mp3", "wav", "m4a", "ogg", "aac", "flac"}));
                return Boolean.valueOf(isFileType);
            }
        }), TuplesKt.to("Documents", new Function1<File, Boolean>() { // from class: com.gcs.recovery.videos.files.photo_recovery.adapter.DuplicateFileAdapter$groupFilesBySet$fileTypeGroups$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(File file) {
                boolean isDocumentFile;
                Intrinsics.checkNotNullParameter(file, "file");
                isDocumentFile = DuplicateFileAdapter.this.isDocumentFile(file);
                return Boolean.valueOf(isDocumentFile);
            }
        })})) {
            String str = (String) pair.component1();
            Function1 function1 = (Function1) pair.component2();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : files) {
                if (((Boolean) function1.invoke(obj)).booleanValue()) {
                    arrayList2.add(obj);
                }
            }
            arrayList.addAll(groupFilesBySetAndType(arrayList2, str));
        }
        return arrayList;
    }

    private final List<Object> groupFilesBySetAndType(List<? extends File> files, String setName) {
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : files) {
            File file = (File) obj;
            String str = file.getName() + SignatureVisitor.SUPER + file.length();
            Object obj2 = linkedHashMap.get(str);
            if (obj2 == null) {
                obj2 = (List) new ArrayList();
                linkedHashMap.put(str, obj2);
            }
            ((List) obj2).add(obj);
        }
        int i = 1;
        for (List list : linkedHashMap.values()) {
            if (list.size() > 1) {
                arrayList.add(setName + " Set " + i);
                arrayList.addAll(list);
                i++;
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isFileType(File file, List<String> extensions) {
        String lowerCase = FilesKt.getExtension(file).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return extensions.contains(lowerCase);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isDocumentFile(File file) {
        return isFileType(file, CollectionsKt.listOf((Object[]) new String[]{"pdf", "doc", "docx", "txt", "xlsx", "ppt", "pptx"})) || !(isFileType(file, this.imageExtensions) || isFileType(file, this.videoExtensions) || isFileType(file, this.audioExtensions));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.groupedItems.get(position) instanceof String ? this.ITEM_TYPE_SET : this.ITEM_TYPE_FILE;
    }

    public final long getSelectedFilesSize() {
        Iterator<T> it = this.selectedFiles.iterator();
        long j = 0;
        while (it.hasNext()) {
            j += ((File) it.next()).length();
        }
        return j;
    }

    public final void smartSelectAllFiles() {
        this.selectedFiles.clear();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (File file : this.dupFiles) {
            String str = file.getName() + SignatureVisitor.SUPER + file.length();
            if (linkedHashMap.containsKey(str)) {
                List list = (List) linkedHashMap.get(str);
                if (list != null) {
                    list.add(file);
                }
            } else {
                linkedHashMap.put(str, CollectionsKt.mutableListOf(file));
            }
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            List list2 = (List) ((Map.Entry) it.next()).getValue();
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (Object obj : list2) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                if (i != 0) {
                    arrayList.add(obj);
                }
                i = i2;
            }
            this.selectedFiles.addAll(arrayList);
        }
        this.selectionMode = true;
        notifyDataSetChanged();
        this.onFileSelectionChanged.invoke(Long.valueOf(getSelectedFilesSize()), Boolean.valueOf(this.selectionMode));
    }

    public final void deselectAllFiles() {
        this.selectedFiles.clear();
        this.selectionMode = false;
        notifyDataSetChanged();
        this.onFileSelectionChanged.invoke(0L, Boolean.valueOf(this.selectionMode));
    }

    public final boolean isAllFilesSelected() {
        List<? extends File> list = this.dupFiles;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : list) {
            File file = (File) obj;
            String str = file.getName() + SignatureVisitor.SUPER + file.length();
            Object obj2 = linkedHashMap.get(str);
            if (obj2 == null) {
                obj2 = (List) new ArrayList();
                linkedHashMap.put(str, obj2);
            }
            ((List) obj2).add(obj);
        }
        int i = 0;
        for (List list2 : linkedHashMap.values()) {
            i += list2.size() > 1 ? list2.size() - 1 : 0;
        }
        return this.selectedFiles.size() == i;
    }

    public final int getSelectedItemCount() {
        return this.selectedFiles.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == this.ITEM_TYPE_SET) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_date_header, parent, false);
            Intrinsics.checkNotNull(inflate);
            return new SetViewHolder(this, inflate);
        }
        ItemImagesBinding inflate2 = ItemImagesBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(...)");
        return new DuplicateFileViewHolder(this, inflate2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof DuplicateFileViewHolder) {
            Object obj = this.groupedItems.get(position);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.io.File");
            ((DuplicateFileViewHolder) holder).bind((File) obj);
            return;
        }
        if (holder instanceof SetViewHolder) {
            Object obj2 = this.groupedItems.get(position);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            ((SetViewHolder) holder).bind((String) obj2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.groupedItems.size();
    }

    /* compiled from: DuplicateFileAdapter.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/adapter/DuplicateFileAdapter$DuplicateFileViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ItemImagesBinding;", "(Lcom/gcs/recovery/videos/files/photo_recovery/adapter/DuplicateFileAdapter;Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ItemImagesBinding;)V", "fileCheckBox", "Landroidx/appcompat/widget/AppCompatImageView;", "fileSize", "Landroid/widget/TextView;", "fileType", "Landroid/widget/ImageView;", "fileUnCheckBox", "imageView", "selectedOverlay", "Landroid/view/View;", "bind", "", ShareInternalUtility.STAGING_PARAM, "Ljava/io/File;", "openFile", "toggleSelection", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class DuplicateFileViewHolder extends RecyclerView.ViewHolder {
        private final ItemImagesBinding binding;
        private final AppCompatImageView fileCheckBox;
        private final TextView fileSize;
        private final ImageView fileType;
        private final AppCompatImageView fileUnCheckBox;
        private final AppCompatImageView imageView;
        private final View selectedOverlay;
        final /* synthetic */ DuplicateFileAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DuplicateFileViewHolder(DuplicateFileAdapter duplicateFileAdapter, ItemImagesBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = duplicateFileAdapter;
            this.binding = binding;
            AppCompatImageView imageView = binding.imageView;
            Intrinsics.checkNotNullExpressionValue(imageView, "imageView");
            this.imageView = imageView;
            TextView imgSize = binding.imgSize;
            Intrinsics.checkNotNullExpressionValue(imgSize, "imgSize");
            this.fileSize = imgSize;
            AppCompatImageView fileCheckBox = binding.fileCheckBox;
            Intrinsics.checkNotNullExpressionValue(fileCheckBox, "fileCheckBox");
            this.fileCheckBox = fileCheckBox;
            AppCompatImageView fileUnCheckBox = binding.fileUnCheckBox;
            Intrinsics.checkNotNullExpressionValue(fileUnCheckBox, "fileUnCheckBox");
            this.fileUnCheckBox = fileUnCheckBox;
            View selectedOverlay = binding.selectedOverlay;
            Intrinsics.checkNotNullExpressionValue(selectedOverlay, "selectedOverlay");
            this.selectedOverlay = selectedOverlay;
            AppCompatImageView iconType = binding.iconType;
            Intrinsics.checkNotNullExpressionValue(iconType, "iconType");
            this.fileType = iconType;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0072, code lost:
        
            if (r0.equals("tiff") == false) goto L77;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0115, code lost:
        
            com.bumptech.glide.Glide.with(r5.imageView.getContext()).load(r6).placeholder(com.gcs.recovery.videos.files.photo_recovery.R.drawable.ic_image_placeholder).into(r5.imageView);
            r5.fileType.setImageResource(com.gcs.recovery.videos.files.photo_recovery.R.drawable.ic_img_icon);
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x007c, code lost:
        
            if (r0.equals("mpeg") == false) goto L77;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0143, code lost:
        
            com.bumptech.glide.Glide.with(r5.imageView.getContext()).load(r6).placeholder(com.gcs.recovery.videos.files.photo_recovery.R.drawable.ic_video_placeholder).into(r5.imageView);
            r5.fileType.setImageResource(com.gcs.recovery.videos.files.photo_recovery.R.drawable.ic_play);
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0086, code lost:
        
            if (r0.equals("flac") == false) goto L77;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0171, code lost:
        
            r5.imageView.setImageResource(com.gcs.recovery.videos.files.photo_recovery.R.drawable.ic_mcs);
            r5.fileType.setImageResource(com.gcs.recovery.videos.files.photo_recovery.R.drawable.ic_mcs);
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0090, code lost:
        
            if (r0.equals("wmv") == false) goto L77;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x009a, code lost:
        
            if (r0.equals("wav") == false) goto L77;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x00a4, code lost:
        
            if (r0.equals("svg") == false) goto L77;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00ae, code lost:
        
            if (r0.equals("psd") == false) goto L77;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00b8, code lost:
        
            if (r0.equals("png") == false) goto L77;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00c2, code lost:
        
            if (r0.equals("ogg") == false) goto L77;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00cc, code lost:
        
            if (r0.equals("mov") == false) goto L77;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00d6, code lost:
        
            if (r0.equals("mp4") == false) goto L77;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00e0, code lost:
        
            if (r0.equals("mp3") == false) goto L77;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00ea, code lost:
        
            if (r0.equals("mkv") == false) goto L77;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00f4, code lost:
        
            if (r0.equals("m4a") == false) goto L77;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00fe, code lost:
        
            if (r0.equals("jpg") == false) goto L77;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0108, code lost:
        
            if (r0.equals("gif") == false) goto L77;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x0112, code lost:
        
            if (r0.equals("bmp") == false) goto L77;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x0140, code lost:
        
            if (r0.equals("avi") == false) goto L77;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x016e, code lost:
        
            if (r0.equals("aac") == false) goto L77;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void bind(final File file) {
            Intrinsics.checkNotNullParameter(file, "file");
            String lowerCase = FilesKt.getExtension(file).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            this.fileSize.setText(Utils.INSTANCE.formatSize(file.length()));
            this.fileCheckBox.setVisibility(this.this$0.selectedFiles.contains(file) ? 0 : 8);
            this.fileUnCheckBox.setVisibility(!this.this$0.selectedFiles.contains(file) ? 0 : 8);
            this.selectedOverlay.setVisibility(this.this$0.selectedFiles.contains(file) ? 0 : 8);
            switch (lowerCase.hashCode()) {
                case 96323:
                    break;
                case 96980:
                    break;
                case 97669:
                    break;
                case 102340:
                    break;
                case 105441:
                    break;
                case 106458:
                    break;
                case 108184:
                    break;
                case 108272:
                    break;
                case 108273:
                    break;
                case 108308:
                    break;
                case 109967:
                    break;
                case 111145:
                    break;
                case 111297:
                    break;
                case 114276:
                    break;
                case 117484:
                    break;
                case 117856:
                    break;
                case 3145576:
                    break;
                case 3358085:
                    break;
                case 3559925:
                    break;
                default:
                    this.imageView.setImageResource(Utils.INSTANCE.getIconForFileType(file));
                    break;
            }
            this.fileCheckBox.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.adapter.DuplicateFileAdapter$DuplicateFileViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DuplicateFileAdapter.DuplicateFileViewHolder.bind$lambda$0(DuplicateFileAdapter.DuplicateFileViewHolder.this, file, view);
                }
            });
            this.fileUnCheckBox.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.adapter.DuplicateFileAdapter$DuplicateFileViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DuplicateFileAdapter.DuplicateFileViewHolder.bind$lambda$1(DuplicateFileAdapter.DuplicateFileViewHolder.this, file, view);
                }
            });
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.adapter.DuplicateFileAdapter$DuplicateFileViewHolder$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DuplicateFileAdapter.DuplicateFileViewHolder.bind$lambda$2(DuplicateFileAdapter.DuplicateFileViewHolder.this, file, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0(DuplicateFileViewHolder this$0, File file, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(file, "$file");
            this$0.toggleSelection(file);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$1(DuplicateFileViewHolder this$0, File file, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(file, "$file");
            this$0.toggleSelection(file);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$2(DuplicateFileViewHolder this$0, File file, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(file, "$file");
            this$0.openFile(file);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:10:0x00e8, code lost:
        
            r1 = new android.content.Intent(r0, (java.lang.Class<?>) com.gcs.recovery.videos.files.photo_recovery.activity.ViewVideoActivity.class);
            r1.putExtra("VIDEO_PATH", r6.getAbsolutePath());
            r1.putExtra("IS_RECOVERED", true);
            r0.startActivity(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x003b, code lost:
        
            if (r1.equals("flac") == false) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0108, code lost:
        
            r1 = new android.content.Intent(r0, (java.lang.Class<?>) com.gcs.recovery.videos.files.photo_recovery.activity.ViewAudioActivity.class);
            r1.putExtra("AUDIO_PATH", r6.getAbsolutePath());
            r1.putExtra("IS_RECOVERED", true);
            r0.startActivity(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0045, code lost:
        
            if (r1.equals("wmv") == false) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x004f, code lost:
        
            if (r1.equals("wav") == false) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0059, code lost:
        
            if (r1.equals("svg") == false) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0063, code lost:
        
            if (r1.equals("psd") == false) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x006d, code lost:
        
            if (r1.equals("png") == false) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0077, code lost:
        
            if (r1.equals("ogg") == false) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0081, code lost:
        
            if (r1.equals("mov") == false) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x008b, code lost:
        
            if (r1.equals("mp4") == false) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0095, code lost:
        
            if (r1.equals("mp3") == false) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x009f, code lost:
        
            if (r1.equals("mkv") == false) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00a9, code lost:
        
            if (r1.equals("m4a") == false) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00b3, code lost:
        
            if (r1.equals("jpg") == false) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00bc, code lost:
        
            if (r1.equals("gif") == false) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00c5, code lost:
        
            if (r1.equals("bmp") == false) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00e5, code lost:
        
            if (r1.equals("avi") == false) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x0105, code lost:
        
            if (r1.equals("aac") == false) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:4:0x0027, code lost:
        
            if (r1.equals("tiff") == false) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:5:0x00c8, code lost:
        
            r1 = new android.content.Intent(r0, (java.lang.Class<?>) com.gcs.recovery.videos.files.photo_recovery.activity.ViewPhotoActivity.class);
            r1.putExtra("PHOTO_PATH", r6.getAbsolutePath());
            r1.putExtra("IS_RECOVERED", true);
            r0.startActivity(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0031, code lost:
        
            if (r1.equals("mpeg") == false) goto L65;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void openFile(File file) {
            Context context = this.itemView.getContext();
            String lowerCase = FilesKt.getExtension(file).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            switch (lowerCase.hashCode()) {
                case 96323:
                    break;
                case 96980:
                    break;
                case 97669:
                    break;
                case 102340:
                    break;
                case 105441:
                    break;
                case 106458:
                    break;
                case 108184:
                    break;
                case 108272:
                    break;
                case 108273:
                    break;
                case 108308:
                    break;
                case 109967:
                    break;
                case 111145:
                    break;
                case 111297:
                    break;
                case 114276:
                    break;
                case 117484:
                    break;
                case 117856:
                    break;
                case 3145576:
                    break;
                case 3358085:
                    break;
                case 3559925:
                    break;
                default:
                    Intent intent = new Intent(context, (Class<?>) ViewDocActivity.class);
                    intent.putExtra("DOC_PATH", file.getAbsolutePath());
                    intent.putExtra("IS_RECOVERED", true);
                    context.startActivity(intent);
                    break;
            }
        }

        private final void toggleSelection(File file) {
            if (this.this$0.selectedFiles.contains(file)) {
                this.this$0.selectedFiles.remove(file);
                this.fileCheckBox.setVisibility(View.GONE);
                this.selectedOverlay.setVisibility(View.GONE);
            } else {
                this.this$0.selectedFiles.add(file);
                this.fileCheckBox.setVisibility(View.VISIBLE);
                this.selectedOverlay.setVisibility(View.VISIBLE);
            }
            this.this$0.onFileSelectionChanged.invoke(Long.valueOf(this.this$0.getSelectedFilesSize()), true);
            DuplicateFileAdapter duplicateFileAdapter = this.this$0;
            duplicateFileAdapter.notifyItemRangeChanged(0, duplicateFileAdapter.groupedItems.size());
        }
    }

    /* compiled from: DuplicateFileAdapter.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/adapter/DuplicateFileAdapter$SetViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "(Lcom/gcs/recovery/videos/files/photo_recovery/adapter/DuplicateFileAdapter;Landroid/view/View;)V", "bind", "", "setName", "", "getItemsCountForSet", "", "position", "updateSetCheckBox", "setCheckBox", "Landroidx/appcompat/widget/AppCompatImageView;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class SetViewHolder extends RecyclerView.ViewHolder {
        final /* synthetic */ DuplicateFileAdapter this$0;
        private final View view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SetViewHolder(DuplicateFileAdapter duplicateFileAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.this$0 = duplicateFileAdapter;
            this.view = view;
        }

        public final void bind(String setName) {
            Intrinsics.checkNotNullParameter(setName, "setName");
            View findViewById = this.view.findViewById(R.id.dateTextView);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            View findViewById2 = this.view.findViewById(R.id.dateCheckBox);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            final AppCompatImageView appCompatImageView = (AppCompatImageView) findViewById2;
            ((TextView) findViewById).setText(setName);
            updateSetCheckBox(appCompatImageView);
            final DuplicateFileAdapter duplicateFileAdapter = this.this$0;
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.adapter.DuplicateFileAdapter$SetViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DuplicateFileAdapter.SetViewHolder.bind$lambda$2(DuplicateFileAdapter.SetViewHolder.this, duplicateFileAdapter, appCompatImageView, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$2(SetViewHolder this$0, DuplicateFileAdapter this$1, AppCompatImageView setCheckBox, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullParameter(setCheckBox, "$setCheckBox");
            int adapterPosition = this$0.getAdapterPosition() + 1;
            int coerceAtMost = RangesKt.coerceAtMost(this$1.groupedItems.size(), this$0.getItemsCountForSet(this$0.getAdapterPosition()) + adapterPosition);
            List subList = this$1.groupedItems.subList(adapterPosition, coerceAtMost);
            ArrayList arrayList = new ArrayList();
            for (Object obj : subList) {
                if (obj instanceof File) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            int i = 0;
            for (Object obj2 : arrayList) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                if (i != 0) {
                    arrayList2.add(obj2);
                }
                i = i2;
            }
            ArrayList arrayList3 = arrayList2;
            ArrayList arrayList4 = arrayList3;
            if (!(arrayList4 instanceof Collection) || !arrayList4.isEmpty()) {
                Iterator it = arrayList4.iterator();
                while (it.hasNext()) {
                    if (!this$1.selectedFiles.contains((File) it.next())) {
                        this$1.selectedFiles.addAll(arrayList3);
                        if (!this$1.selectionMode) {
                            this$1.selectionMode = true;
                            this$1.onFileSelectionChanged.invoke(Long.valueOf(this$1.getSelectedFilesSize()), Boolean.valueOf(this$1.selectionMode));
                        }
                        this$1.notifyItemRangeChanged(adapterPosition, coerceAtMost - adapterPosition);
                        this$1.onFileSelectionChanged.invoke(Long.valueOf(this$1.getSelectedFilesSize()), Boolean.valueOf(this$1.selectionMode));
                        this$0.updateSetCheckBox(setCheckBox);
                    }
                }
            }
            this$1.selectedFiles.removeAll(CollectionsKt.toSet(arrayList4));
            this$1.notifyItemRangeChanged(adapterPosition, coerceAtMost - adapterPosition);
            this$1.onFileSelectionChanged.invoke(Long.valueOf(this$1.getSelectedFilesSize()), Boolean.valueOf(this$1.selectionMode));
            this$0.updateSetCheckBox(setCheckBox);
        }

        private final void updateSetCheckBox(AppCompatImageView setCheckBox) {
            int adapterPosition = getAdapterPosition() + 1;
            List subList = this.this$0.groupedItems.subList(adapterPosition, RangesKt.coerceAtMost(this.this$0.groupedItems.size(), getItemsCountForSet(getAdapterPosition()) + adapterPosition));
            ArrayList arrayList = new ArrayList();
            for (Object obj : subList) {
                if (obj instanceof File) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            int i = 0;
            for (Object obj2 : arrayList) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                if (i != 0) {
                    arrayList2.add(obj2);
                }
                i = i2;
            }
            ArrayList arrayList3 = arrayList2;
            DuplicateFileAdapter duplicateFileAdapter = this.this$0;
            if (!(arrayList3 instanceof Collection) || !arrayList3.isEmpty()) {
                Iterator it = arrayList3.iterator();
                while (it.hasNext()) {
                    if (!duplicateFileAdapter.selectedFiles.contains((File) it.next())) {
                        setCheckBox.setImageResource(R.drawable.ic_dslct);
                        return;
                    }
                }
            }
            setCheckBox.setImageResource(R.drawable.ic_check);
        }

        private final int getItemsCountForSet(int position) {
            int size = this.this$0.groupedItems.size();
            int i = 0;
            for (int i2 = position + 1; i2 < size && !(this.this$0.groupedItems.get(i2) instanceof String); i2++) {
                i++;
            }
            return i;
        }
    }
}
