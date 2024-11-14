package com.gcs.recovery.videos.files.photo_recovery.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.ShareInternalUtility;
import com.demo.example.R;
import com.gcs.recovery.videos.files.photo_recovery.activity.ViewPhotoActivity;
import com.gcs.recovery.videos.files.photo_recovery.adapter.ScreenshotAdapter;
import com.demo.example.databinding.ItemImagesBinding;
import com.gcs.recovery.videos.files.photo_recovery.utils.Utils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: ScreenshotAdapter.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002*+B\u001f\u0012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0002\u0010\bJ\u0006\u0010\u0016\u001a\u00020\u0007J\b\u0010\u0017\u001a\u00020\nH\u0016J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\nH\u0016J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u001bJ\u0006\u0010\u001c\u001a\u00020\u0005J\u0006\u0010\u001d\u001a\u00020\nJ\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fH\u0002J\u0006\u0010 \u001a\u00020\u0006J\u0006\u0010!\u001a\u00020\u0006J\u0018\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\nH\u0016J\u0018\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\nH\u0016J\u0006\u0010(\u001a\u00020\u0007J\u0014\u0010)\u001a\u00020\u00072\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fR\u0014\u0010\t\u001a\u00020\nX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/adapter/ScreenshotAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onFileSelectionChanged", "Lkotlin/Function2;", "", "", "", "(Lkotlin/jvm/functions/Function2;)V", "ITEM_TYPE_DATE", "", "getITEM_TYPE_DATE", "()I", "ITEM_TYPE_FILE", "groupedItems", "", "", "screenshotFiles", "Ljava/io/File;", "selectedFiles", "", "selectionMode", "deselectAllFiles", "getItemCount", "getItemViewType", "position", "getSelectedFiles", "", "getSelectedFilesSize", "getSelectedItemCount", "groupFilesByDate", "files", "isAllFilesSelected", "isSelectionMode", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "selectAllFiles", "submitList", "DateViewHolder", "ScreenshotViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ScreenshotAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int ITEM_TYPE_DATE;
    private final int ITEM_TYPE_FILE;
    private List<? extends Object> groupedItems;
    private final Function2<Long, Boolean, Unit> onFileSelectionChanged;
    private List<? extends File> screenshotFiles;
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
    public ScreenshotAdapter(Function2<? super Long, ? super Boolean, Unit> onFileSelectionChanged) {
        Intrinsics.checkNotNullParameter(onFileSelectionChanged, "onFileSelectionChanged");
        this.onFileSelectionChanged = onFileSelectionChanged;
        this.ITEM_TYPE_FILE = 1;
        this.ITEM_TYPE_DATE = 2;
        this.screenshotFiles = CollectionsKt.emptyList();
        this.groupedItems = CollectionsKt.emptyList();
        this.selectedFiles = new LinkedHashSet();
    }

    public final void submitList(List<? extends File> files) {
        Intrinsics.checkNotNullParameter(files, "files");
        this.screenshotFiles = CollectionsKt.sortedWith(files, new Comparator() { // from class: com.gcs.recovery.videos.files.photo_recovery.adapter.ScreenshotAdapter$submitList$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Long.valueOf(((File) t2).lastModified()), Long.valueOf(((File) t).lastModified()));
            }
        });
        this.selectedFiles.clear();
        selectAllFiles();
        this.groupedItems = groupFilesByDate(this.screenshotFiles);
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
        this.selectedFiles.addAll(this.screenshotFiles);
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
        return this.selectedFiles.size() == this.screenshotFiles.size();
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
        ItemImagesBinding inflate2 = ItemImagesBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(...)");
        return new ScreenshotViewHolder(this, inflate2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof ScreenshotViewHolder) {
            Object obj = this.groupedItems.get(position);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.io.File");
            ((ScreenshotViewHolder) holder).bind((File) obj);
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

    /* compiled from: ScreenshotAdapter.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/adapter/ScreenshotAdapter$ScreenshotViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ItemImagesBinding;", "(Lcom/gcs/recovery/videos/files/photo_recovery/adapter/ScreenshotAdapter;Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ItemImagesBinding;)V", "fileCheckBox", "Landroidx/appcompat/widget/AppCompatImageView;", "fileSize", "Landroid/widget/TextView;", "fileUnCheckBox", "imageView", "selectedOverlay", "Landroid/view/View;", "bind", "", ShareInternalUtility.STAGING_PARAM, "Ljava/io/File;", "openFile", "toggleSelection", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ScreenshotViewHolder extends RecyclerView.ViewHolder {
        private final ItemImagesBinding binding;
        private final AppCompatImageView fileCheckBox;
        private final TextView fileSize;
        private final AppCompatImageView fileUnCheckBox;
        private final AppCompatImageView imageView;
        private final View selectedOverlay;
        final /* synthetic */ ScreenshotAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ScreenshotViewHolder(ScreenshotAdapter screenshotAdapter, ItemImagesBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = screenshotAdapter;
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
        }

        public final void bind(final File file) {
            Intrinsics.checkNotNullParameter(file, "file");
            this.fileSize.setText(Utils.INSTANCE.formatSize(file.length()));
            this.fileCheckBox.setVisibility(this.this$0.selectedFiles.contains(file) ? 0 : 8);
            this.fileUnCheckBox.setVisibility(!this.this$0.selectedFiles.contains(file) ? 0 : 8);
            this.selectedOverlay.setVisibility(this.this$0.selectedFiles.contains(file) ? 0 : 8);
            Glide.with(this.imageView.getContext()).load(file).placeholder(R.drawable.ic_image_placeholder).into(this.imageView);
            this.fileCheckBox.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.adapter.ScreenshotAdapter$ScreenshotViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ScreenshotAdapter.ScreenshotViewHolder.bind$lambda$0(ScreenshotAdapter.ScreenshotViewHolder.this, file, view);
                }
            });
            this.fileUnCheckBox.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.adapter.ScreenshotAdapter$ScreenshotViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ScreenshotAdapter.ScreenshotViewHolder.bind$lambda$1(ScreenshotAdapter.ScreenshotViewHolder.this, file, view);
                }
            });
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.adapter.ScreenshotAdapter$ScreenshotViewHolder$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ScreenshotAdapter.ScreenshotViewHolder.bind$lambda$2(ScreenshotAdapter.ScreenshotViewHolder.this, file, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0(ScreenshotViewHolder this$0, File file, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(file, "$file");
            this$0.toggleSelection(file);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$1(ScreenshotViewHolder this$0, File file, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(file, "$file");
            this$0.toggleSelection(file);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$2(ScreenshotViewHolder this$0, File file, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(file, "$file");
            this$0.openFile(file);
        }

        private final void openFile(File file) {
            Context context = this.itemView.getContext();
            Intent intent = new Intent(context, (Class<?>) ViewPhotoActivity.class);
            intent.putExtra("PHOTO_PATH", file.getAbsolutePath());
            intent.putExtra("FILE_TYPE", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO);
            intent.putExtra("IS_RECOVERED", true);
            context.startActivity(intent);
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
            this.this$0.notifyItemChanged(getAdapterPosition());
            this.this$0.notifyDataSetChanged();
        }
    }

    /* compiled from: ScreenshotAdapter.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/adapter/ScreenshotAdapter$DateViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "(Lcom/gcs/recovery/videos/files/photo_recovery/adapter/ScreenshotAdapter;Landroid/view/View;)V", "bind", "", "date", "", "getItemsCountForDate", "", "position", "updateDateCheckBox", "dateCheckBox", "Landroidx/appcompat/widget/AppCompatImageView;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class DateViewHolder extends RecyclerView.ViewHolder {
        final /* synthetic */ ScreenshotAdapter this$0;
        private final View view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DateViewHolder(ScreenshotAdapter screenshotAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.this$0 = screenshotAdapter;
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
            final ScreenshotAdapter screenshotAdapter = this.this$0;
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.adapter.ScreenshotAdapter$DateViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ScreenshotAdapter.DateViewHolder.bind$lambda$1(ScreenshotAdapter.DateViewHolder.this, screenshotAdapter, appCompatImageView, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$1(DateViewHolder this$0, ScreenshotAdapter this$1, AppCompatImageView dateCheckBox, View view) {
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
            ScreenshotAdapter screenshotAdapter = this.this$0;
            if (!(arrayList2 instanceof Collection) || !arrayList2.isEmpty()) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    if (!screenshotAdapter.selectedFiles.contains((File) it.next())) {
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
