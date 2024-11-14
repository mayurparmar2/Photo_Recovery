package com.gcs.recovery.videos.files.photo_recovery.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.ShareInternalUtility;
import com.demo.example.R;
import com.gcs.recovery.videos.files.photo_recovery.activity.ViewDocActivity;
import com.gcs.recovery.videos.files.photo_recovery.adapter.LargeFileAdapter;
import com.demo.example.databinding.ItemLargeImageBinding;
import com.gcs.recovery.videos.files.photo_recovery.utils.Utils;
import com.google.android.material.imageview.ShapeableImageView;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.objectweb.asm.Opcodes;

/* compiled from: LargeFileAdapter.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002*+B\u001f\u0012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0002\u0010\bJ\u0006\u0010\u0016\u001a\u00020\u0007J\b\u0010\u0017\u001a\u00020\nH\u0016J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\nH\u0016J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u001bJ\u0006\u0010\u001c\u001a\u00020\u0005J\u0006\u0010\u001d\u001a\u00020\nJ\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fH\u0002J\u0006\u0010 \u001a\u00020\u0006J\u0006\u0010!\u001a\u00020\u0006J\u0018\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\nH\u0016J\u0018\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\nH\u0016J\u0006\u0010(\u001a\u00020\u0007J\u0014\u0010)\u001a\u00020\u00072\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fR\u0014\u0010\t\u001a\u00020\nX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/adapter/LargeFileAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onFileSelectionChanged", "Lkotlin/Function2;", "", "", "", "(Lkotlin/jvm/functions/Function2;)V", "ITEM_TYPE_DATE", "", "getITEM_TYPE_DATE", "()I", "ITEM_TYPE_FILE", "groupedItems", "", "", "largeFiles", "Ljava/io/File;", "selectedFiles", "", "selectionMode", "deselectAllFiles", "getItemCount", "getItemViewType", "position", "getSelectedFiles", "", "getSelectedFilesSize", "getSelectedItemCount", "groupFilesByDate", "files", "isAllFilesSelected", "isSelectionMode", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "selectAllFiles", "submitList", "DateViewHolder", "LargeFileViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LargeFileAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int ITEM_TYPE_DATE;
    private final int ITEM_TYPE_FILE;
    private List<? extends Object> groupedItems;
    private List<? extends File> largeFiles;
    private final Function2<Long, Boolean, Unit> onFileSelectionChanged;
    private Set<File> selectedFiles;
    private boolean selectionMode;

    public final int getITEM_TYPE_DATE() {
        return this.ITEM_TYPE_DATE;
    }

    public final Set<File> getSelectedFiles() {
        return this.selectedFiles;
    }

    /* renamed from: isSelectionMode, reason: from getter */
    public final boolean getSelectionMode() {
        return this.selectionMode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LargeFileAdapter(Function2<? super Long, ? super Boolean, Unit> onFileSelectionChanged) {
        Intrinsics.checkNotNullParameter(onFileSelectionChanged, "onFileSelectionChanged");
        this.onFileSelectionChanged = onFileSelectionChanged;
        this.ITEM_TYPE_FILE = 1;
        this.ITEM_TYPE_DATE = 2;
        this.largeFiles = CollectionsKt.emptyList();
        this.groupedItems = CollectionsKt.emptyList();
        this.selectedFiles = new LinkedHashSet();
    }

    public final void submitList(List<? extends File> files) {
        Intrinsics.checkNotNullParameter(files, "files");
        this.largeFiles = CollectionsKt.sortedWith(files, new Comparator() { // from class: com.gcs.recovery.videos.files.photo_recovery.adapter.LargeFileAdapter$submitList$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Long.valueOf(((File) t2).lastModified()), Long.valueOf(((File) t).lastModified()));
            }
        });
        this.selectedFiles.clear();
        this.groupedItems = groupFilesByDate(this.largeFiles);
        notifyDataSetChanged();
    }

    private final List<Object> groupFilesByDate(List<? extends File> files) {
        ArrayList arrayList = new ArrayList();
        String str = null;
        for (File file : files) {
            String formatDate = Utils.INSTANCE.formatDate(file.lastModified());
            if (!Intrinsics.areEqual(formatDate, str)) {
                arrayList.add(formatDate);
                str = formatDate;
            }
            arrayList.add(file);
        }
        return arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.groupedItems.get(position) instanceof String ? this.ITEM_TYPE_DATE : this.ITEM_TYPE_FILE;
    }

    public final long getSelectedFilesSize() {
        Iterator<T> it = this.selectedFiles.iterator();
        long j = 0;
        while (it.hasNext()) {
            j += ((File) it.next()).length();
        }
        return j;
    }

    public final void selectAllFiles() {
        this.selectedFiles.clear();
        this.selectedFiles.addAll(this.largeFiles);
        this.selectionMode = true;
        notifyDataSetChanged();
        this.onFileSelectionChanged.invoke(Long.valueOf(getSelectedFilesSize()), Boolean.valueOf(this.selectionMode));
        notifyItemRangeChanged(0, this.groupedItems.size());
    }

    public final void deselectAllFiles() {
        this.selectedFiles.clear();
        this.selectionMode = false;
        notifyDataSetChanged();
        this.onFileSelectionChanged.invoke(0L, Boolean.valueOf(this.selectionMode));
    }

    public final boolean isAllFilesSelected() {
        return this.selectedFiles.size() == this.largeFiles.size();
    }

    public final int getSelectedItemCount() {
        return this.selectedFiles.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == this.ITEM_TYPE_DATE) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_date_header, parent, false);
            Intrinsics.checkNotNull(inflate);
            return new DateViewHolder(this, inflate);
        }
        ItemLargeImageBinding inflate2 = ItemLargeImageBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(...)");
        return new LargeFileViewHolder(this, inflate2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof LargeFileViewHolder) {
            Object obj = this.groupedItems.get(position);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.io.File");
            ((LargeFileViewHolder) holder).bind((File) obj, getItemViewType(position));
            return;
        }
        if (holder instanceof DateViewHolder) {
            Object obj2 = this.groupedItems.get(position);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            ((DateViewHolder) holder).bind((String) obj2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.groupedItems.size();
    }

    /* compiled from: LargeFileAdapter.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/adapter/LargeFileAdapter$LargeFileViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ItemLargeImageBinding;", "(Lcom/gcs/recovery/videos/files/photo_recovery/adapter/LargeFileAdapter;Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ItemLargeImageBinding;)V", "fileCheckBox", "Landroidx/appcompat/widget/AppCompatImageView;", "fileName", "Landroid/widget/TextView;", "fileSize", "fileUnCheckBox", "imageView", "playIcon", "Landroid/widget/ImageView;", "bind", "", ShareInternalUtility.STAGING_PARAM, "Ljava/io/File;", "viewType", "", "openFile", "toggleSelection", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class LargeFileViewHolder extends RecyclerView.ViewHolder {
        private final AppCompatImageView fileCheckBox;
        private final TextView fileName;
        private final TextView fileSize;
        private final AppCompatImageView fileUnCheckBox;
        private final AppCompatImageView imageView;
        private final ImageView playIcon;
        final /* synthetic */ LargeFileAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LargeFileViewHolder(LargeFileAdapter largeFileAdapter, ItemLargeImageBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = largeFileAdapter;
            ShapeableImageView itemImage = binding.itemImage;
            Intrinsics.checkNotNullExpressionValue(itemImage, "itemImage");
            this.imageView = itemImage;
            TextView fileName = binding.fileName;
            Intrinsics.checkNotNullExpressionValue(fileName, "fileName");
            this.fileName = fileName;
            TextView fileSize = binding.fileSize;
            Intrinsics.checkNotNullExpressionValue(fileSize, "fileSize");
            this.fileSize = fileSize;
            AppCompatImageView fileCheckBox = binding.fileCheckBox;
            Intrinsics.checkNotNullExpressionValue(fileCheckBox, "fileCheckBox");
            this.fileCheckBox = fileCheckBox;
            AppCompatImageView fileUnCheckBox = binding.fileUnCheckBox;
            Intrinsics.checkNotNullExpressionValue(fileUnCheckBox, "fileUnCheckBox");
            this.fileUnCheckBox = fileUnCheckBox;
            ImageView playIcon = binding.playIcon;
            Intrinsics.checkNotNullExpressionValue(playIcon, "playIcon");
            this.playIcon = playIcon;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0081, code lost:
        
            if (r8.equals("mpeg") == false) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0148, code lost:
        
            com.bumptech.glide.Glide.with(r6.imageView.getContext()).load(r7).placeholder(com.gcs.recovery.videos.files.photo_recovery.R.drawable.ic_video_placeholder).thumbnail(new com.bumptech.glide.RequestBuilder[0]).into(r6.imageView);
            r6.playIcon.setVisibility(View.VISIBLE);
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x008b, code lost:
        
            if (r8.equals("flac") == false) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x017a, code lost:
        
            r6.imageView.setImageResource(com.gcs.recovery.videos.files.photo_recovery.R.drawable.file_music);
            r8 = new android.widget.RelativeLayout.LayoutParams(org.objectweb.asm.Opcodes.FCMPG, org.objectweb.asm.Opcodes.FCMPG);
            r8.addRule(13, -1);
            r6.imageView.setLayoutParams(r8);
            r6.imageView.requestLayout();
            r6.playIcon.setVisibility(View.GONE);
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0095, code lost:
        
            if (r8.equals("wmv") == false) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x009f, code lost:
        
            if (r8.equals("wav") == false) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x00a9, code lost:
        
            if (r8.equals("svg") == false) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x00b3, code lost:
        
            if (r8.equals("psd") == false) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x00bd, code lost:
        
            if (r8.equals("png") == false) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x00c7, code lost:
        
            if (r8.equals("ogg") == false) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00d1, code lost:
        
            if (r8.equals("mov") == false) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00db, code lost:
        
            if (r8.equals("mp4") == false) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00e5, code lost:
        
            if (r8.equals("mp3") == false) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00ef, code lost:
        
            if (r8.equals("mkv") == false) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00f9, code lost:
        
            if (r8.equals("m4a") == false) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0103, code lost:
        
            if (r8.equals("jpg") == false) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x010d, code lost:
        
            if (r8.equals("gif") == false) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x0117, code lost:
        
            if (r8.equals("bmp") == false) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x0145, code lost:
        
            if (r8.equals("avi") == false) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0177, code lost:
        
            if (r8.equals("aac") == false) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:7:0x0077, code lost:
        
            if (r8.equals("tiff") == false) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x011b, code lost:
        
            com.bumptech.glide.Glide.with(r6.imageView.getContext()).load(r7).placeholder(com.gcs.recovery.videos.files.photo_recovery.R.drawable.ic_image_placeholder).into(r6.imageView);
            r6.playIcon.setVisibility(View.GONE);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void bind(final File file, int viewType) {
            Intrinsics.checkNotNullParameter(file, "file");
            String lowerCase = FilesKt.getExtension(file).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            this.fileName.setText(file.getName());
            this.fileSize.setText(Utils.INSTANCE.formatSize(file.length()));
            this.fileName.setSelected(true);
            this.fileName.setEllipsize(TextUtils.TruncateAt.MARQUEE);
            this.fileName.setMarqueeRepeatLimit(-1);
            this.fileName.setSingleLine(true);
            this.fileName.setHorizontallyScrolling(true);
            this.fileCheckBox.setVisibility(this.this$0.selectedFiles.contains(file) ? 0 : 8);
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
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Opcodes.FCMPG, Opcodes.FCMPG);
                    layoutParams.addRule(13, -1);
                    this.imageView.setLayoutParams(layoutParams);
                    this.imageView.requestLayout();
                    this.playIcon.setVisibility(View.GONE);
                    break;
            }
            this.fileCheckBox.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.adapter.LargeFileAdapter$LargeFileViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LargeFileAdapter.LargeFileViewHolder.bind$lambda$2(LargeFileAdapter.LargeFileViewHolder.this, file, view);
                }
            });
            this.fileUnCheckBox.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.adapter.LargeFileAdapter$LargeFileViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LargeFileAdapter.LargeFileViewHolder.bind$lambda$3(LargeFileAdapter.LargeFileViewHolder.this, file, view);
                }
            });
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.adapter.LargeFileAdapter$LargeFileViewHolder$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LargeFileAdapter.LargeFileViewHolder.bind$lambda$4(LargeFileAdapter.LargeFileViewHolder.this, file, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$2(LargeFileViewHolder this$0, File file, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(file, "$file");
            this$0.toggleSelection(file);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$3(LargeFileViewHolder this$0, File file, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(file, "$file");
            this$0.toggleSelection(file);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$4(LargeFileViewHolder this$0, File file, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(file, "$file");
            this$0.openFile(file);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:10:0x00f1, code lost:
        
            r1 = new android.content.Intent(r0, (java.lang.Class<?>) com.gcs.recovery.videos.files.photo_recovery.activity.ViewVideoActivity.class);
            r1.putExtra("VIDEO_PATH", r7.getAbsolutePath());
            r1.putExtra("FILE_TYPE", "video");
            r1.putExtra("IS_RECOVERED", true);
            r0.startActivity(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x003d, code lost:
        
            if (r1.equals("flac") == false) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0116, code lost:
        
            r1 = new android.content.Intent(r0, (java.lang.Class<?>) com.gcs.recovery.videos.files.photo_recovery.activity.ViewAudioActivity.class);
            r1.putExtra("AUDIO_PATH", r7.getAbsolutePath());
            r1.putExtra("FILE_TYPE", "audio");
            r1.putExtra("IS_RECOVERED", true);
            r0.startActivity(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0047, code lost:
        
            if (r1.equals("wmv") == false) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0051, code lost:
        
            if (r1.equals("wav") == false) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x005b, code lost:
        
            if (r1.equals("svg") == false) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0065, code lost:
        
            if (r1.equals("psd") == false) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x006f, code lost:
        
            if (r1.equals("png") == false) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0079, code lost:
        
            if (r1.equals("ogg") == false) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0083, code lost:
        
            if (r1.equals("mov") == false) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x008d, code lost:
        
            if (r1.equals("mp4") == false) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0097, code lost:
        
            if (r1.equals("mp3") == false) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00a1, code lost:
        
            if (r1.equals("mkv") == false) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00ab, code lost:
        
            if (r1.equals("m4a") == false) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00b5, code lost:
        
            if (r1.equals("jpg") == false) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00bf, code lost:
        
            if (r1.equals("gif") == false) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00c9, code lost:
        
            if (r1.equals("bmp") == false) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00ee, code lost:
        
            if (r1.equals("avi") == false) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x0113, code lost:
        
            if (r1.equals("aac") == false) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:4:0x0029, code lost:
        
            if (r1.equals("tiff") == false) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:5:0x00cc, code lost:
        
            r1 = new android.content.Intent(r0, (java.lang.Class<?>) com.gcs.recovery.videos.files.photo_recovery.activity.ViewPhotoActivity.class);
            r1.putExtra("PHOTO_PATH", r7.getAbsolutePath());
            r1.putExtra("FILE_TYPE", com.facebook.internal.AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO);
            r1.putExtra("IS_RECOVERED", true);
            r0.startActivity(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0033, code lost:
        
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
                    intent.putExtra("FILE_TYPE", "doc");
                    intent.putExtra("IS_RECOVERED", true);
                    context.startActivity(intent);
                    break;
            }
        }

        private final void toggleSelection(File file) {
            if (this.this$0.selectedFiles.contains(file)) {
                this.this$0.selectedFiles.remove(file);
                this.fileCheckBox.setVisibility(View.GONE);
            } else {
                this.this$0.selectedFiles.add(file);
                this.fileCheckBox.setVisibility(View.VISIBLE);
            }
            this.this$0.onFileSelectionChanged.invoke(Long.valueOf(this.this$0.getSelectedFilesSize()), true);
            LargeFileAdapter largeFileAdapter = this.this$0;
            largeFileAdapter.notifyItemRangeChanged(0, largeFileAdapter.groupedItems.size());
        }
    }

    /* compiled from: LargeFileAdapter.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/adapter/LargeFileAdapter$DateViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "(Lcom/gcs/recovery/videos/files/photo_recovery/adapter/LargeFileAdapter;Landroid/view/View;)V", "bind", "", "date", "", "getItemsCountForDate", "", "position", "updateDateCheckBox", "dateCheckBox", "Landroidx/appcompat/widget/AppCompatImageView;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class DateViewHolder extends RecyclerView.ViewHolder {
        final /* synthetic */ LargeFileAdapter this$0;
        private final View view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DateViewHolder(LargeFileAdapter largeFileAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.this$0 = largeFileAdapter;
            this.view = view;
        }

        public final void bind(String date) {
            Intrinsics.checkNotNullParameter(date, "date");
            View findViewById = this.view.findViewById(R.id.dateTextView);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            View findViewById2 = this.view.findViewById(R.id.dateCheckBox);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            final AppCompatImageView appCompatImageView = (AppCompatImageView) findViewById2;
            ((TextView) findViewById).setText(date);
            updateDateCheckBox(appCompatImageView);
            final LargeFileAdapter largeFileAdapter = this.this$0;
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.adapter.LargeFileAdapter$DateViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LargeFileAdapter.DateViewHolder.bind$lambda$1(LargeFileAdapter.DateViewHolder.this, largeFileAdapter, appCompatImageView, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$1(DateViewHolder this$0, LargeFileAdapter this$1, AppCompatImageView dateCheckBox, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            Intrinsics.checkNotNullParameter(dateCheckBox, "$dateCheckBox");
            int adapterPosition = this$0.getAdapterPosition() + 1;
            int coerceAtMost = RangesKt.coerceAtMost(this$1.groupedItems.size(), this$0.getItemsCountForDate(this$0.getAdapterPosition()) + adapterPosition);
            List subList = this$1.groupedItems.subList(adapterPosition, coerceAtMost);
            ArrayList arrayList = new ArrayList();
            for (Object obj : subList) {
                if (obj instanceof File) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = arrayList;
            ArrayList arrayList3 = arrayList2;
            if (!(arrayList3 instanceof Collection) || !arrayList3.isEmpty()) {
                Iterator it = arrayList3.iterator();
                while (it.hasNext()) {
                    if (!this$1.selectedFiles.contains((File) it.next())) {
                        this$1.selectedFiles.addAll(arrayList2);
                        if (!this$1.selectionMode) {
                            this$1.selectionMode = true;
                            this$1.onFileSelectionChanged.invoke(Long.valueOf(this$1.getSelectedFilesSize()), Boolean.valueOf(this$1.selectionMode));
                        }
                        this$1.notifyItemRangeChanged(adapterPosition, coerceAtMost - adapterPosition);
                        this$1.onFileSelectionChanged.invoke(Long.valueOf(this$1.getSelectedFilesSize()), Boolean.valueOf(this$1.selectionMode));
                        this$0.updateDateCheckBox(dateCheckBox);
                    }
                }
            }
            this$1.selectedFiles.removeAll(CollectionsKt.toSet(arrayList3));
            this$1.notifyItemRangeChanged(adapterPosition, coerceAtMost - adapterPosition);
            this$1.onFileSelectionChanged.invoke(Long.valueOf(this$1.getSelectedFilesSize()), Boolean.valueOf(this$1.selectionMode));
            this$0.updateDateCheckBox(dateCheckBox);
        }

        private final void updateDateCheckBox(AppCompatImageView dateCheckBox) {
            int adapterPosition = getAdapterPosition() + 1;
            List subList = this.this$0.groupedItems.subList(adapterPosition, RangesKt.coerceAtMost(this.this$0.groupedItems.size(), getItemsCountForDate(getAdapterPosition()) + adapterPosition));
            ArrayList arrayList = new ArrayList();
            for (Object obj : subList) {
                if (obj instanceof File) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = arrayList;
            LargeFileAdapter largeFileAdapter = this.this$0;
            if (!(arrayList2 instanceof Collection) || !arrayList2.isEmpty()) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    if (!largeFileAdapter.selectedFiles.contains((File) it.next())) {
                        dateCheckBox.setImageResource(R.drawable.ic_dslct);
                        return;
                    }
                }
            }
            dateCheckBox.setImageResource(R.drawable.ic_check);
        }

        private final int getItemsCountForDate(int position) {
            int size = this.this$0.groupedItems.size();
            int i = 0;
            for (int i2 = position + 1; i2 < size && !(this.this$0.groupedItems.get(i2) instanceof String); i2++) {
                i++;
            }
            return i;
        }
    }
}
