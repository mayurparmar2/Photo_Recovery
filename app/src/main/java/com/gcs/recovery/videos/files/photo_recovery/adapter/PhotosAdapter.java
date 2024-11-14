package com.gcs.recovery.videos.files.photo_recovery.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.facebook.internal.AnalyticsEvents;
import com.demo.example.R;
import com.gcs.recovery.videos.files.photo_recovery.adapter.PhotosAdapter;
import com.gcs.recovery.videos.files.photo_recovery.model.PhotosModel;
import com.gcs.recovery.videos.files.photo_recovery.utils.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: PhotosAdapter.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001(BO\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0010\rJ\u001c\u0010\u0014\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u00162\u0006\u0010\u0013\u001a\u00020\bJ\b\u0010\u0017\u001a\u00020\tH\u0002J\u0006\u0010\u0018\u001a\u00020\tJ\u000e\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\bJ\b\u0010\u001b\u001a\u00020\bH\u0016J\u0006\u0010\u001c\u001a\u00020\bJ\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016J\u0006\u0010\u001e\u001a\u00020\bJ\u0018\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\bH\u0016J\u0018\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\bH\u0016J\u0006\u0010%\u001a\u00020\tJ\u000e\u0010&\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\bJ\u001c\u0010'\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u00162\u0006\u0010\u0013\u001a\u00020\bR\u001e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/adapter/PhotosAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/gcs/recovery/videos/files/photo_recovery/adapter/PhotosAdapter$PhotoViewHolder;", "photosList", "", "Lcom/gcs/recovery/videos/files/photo_recovery/model/PhotosModel;", "onItemClickListener", "Lkotlin/Function1;", "", "", "onItemLongClickListener", "onSelectionChangedListener", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "<set-?>", "isAllSelected", "()Z", "selectedItems", "", "totalItemCount", "addPhotos", "newPhotos", "", "checkIfAllSelected", "deselectAll", "getItemAtPosition", "position", "getItemCount", "getSelectedItemCount", "getSelectedItems", "getTotalItemCount", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "selectAll", "toggleSelection", "updatePhotos", "PhotoViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PhotosAdapter extends RecyclerView.Adapter<PhotoViewHolder> {
    private boolean isAllSelected;
    private final Function1<Integer, Unit> onItemClickListener;
    private final Function1<Integer, Unit> onItemLongClickListener;
    private final Function1<Boolean, Unit> onSelectionChangedListener;
    private final List<PhotosModel> photosList;
    private Set<Integer> selectedItems;
    private int totalItemCount;

    public final int getTotalItemCount() {
        return this.totalItemCount;
    }

    /* renamed from: isAllSelected, reason: from getter */
    public final boolean getIsAllSelected() {
        return this.isAllSelected;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PhotosAdapter(List<PhotosModel> photosList, Function1<? super Integer, Unit> onItemClickListener, Function1<? super Integer, Unit> onItemLongClickListener, Function1<? super Boolean, Unit> onSelectionChangedListener) {
        Intrinsics.checkNotNullParameter(photosList, "photosList");
        Intrinsics.checkNotNullParameter(onItemClickListener, "onItemClickListener");
        Intrinsics.checkNotNullParameter(onItemLongClickListener, "onItemLongClickListener");
        Intrinsics.checkNotNullParameter(onSelectionChangedListener, "onSelectionChangedListener");
        this.photosList = photosList;
        this.onItemClickListener = onItemClickListener;
        this.onItemLongClickListener = onItemLongClickListener;
        this.onSelectionChangedListener = onSelectionChangedListener;
        this.selectedItems = new LinkedHashSet();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_images, parent, false);
        Intrinsics.checkNotNull(inflate);
        return new PhotoViewHolder(inflate);
    }

    public final PhotosModel getItemAtPosition(int position) {
        return this.photosList.get(position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(PhotoViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.photosList.get(position), position, this.onItemClickListener, this.onItemLongClickListener, this.selectedItems.contains(Integer.valueOf(position)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.photosList.size();
    }

    public final void addPhotos(List<PhotosModel> newPhotos, int totalItemCount) {
        Intrinsics.checkNotNullParameter(newPhotos, "newPhotos");
        int size = this.photosList.size();
        this.totalItemCount = totalItemCount;
        this.photosList.addAll(newPhotos);
        notifyItemRangeInserted(size, newPhotos.size());
    }

    public final void updatePhotos(List<PhotosModel> newPhotos, int totalItemCount) {
        Intrinsics.checkNotNullParameter(newPhotos, "newPhotos");
        this.totalItemCount = totalItemCount;
        this.photosList.clear();
        this.photosList.addAll(newPhotos);
        this.selectedItems.clear();
        this.isAllSelected = false;
        notifyDataSetChanged();
    }

    public final void toggleSelection(int position) {
        if (this.selectedItems.contains(Integer.valueOf(position))) {
            this.selectedItems.remove(Integer.valueOf(position));
            this.isAllSelected = false;
        } else {
            this.selectedItems.add(Integer.valueOf(position));
        }
        notifyItemChanged(position);
        checkIfAllSelected();
    }

    public final void selectAll() {
        this.isAllSelected = true;
        this.selectedItems.clear();
        CollectionsKt.addAll(this.selectedItems, RangesKt.until(0, this.photosList.size()));
        notifyDataSetChanged();
        this.onSelectionChangedListener.invoke(true);
    }

    public final void deselectAll() {
        this.isAllSelected = false;
        this.selectedItems.clear();
        notifyDataSetChanged();
        this.onSelectionChangedListener.invoke(false);
    }

    public final int getSelectedItemCount() {
        return this.selectedItems.size();
    }

    public final List<PhotosModel> getSelectedItems() {
        Set<Integer> set = this.selectedItems;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(this.photosList.get(((Number) it.next()).intValue()));
        }
        return arrayList;
    }

    private final void checkIfAllSelected() {
        boolean z = this.selectedItems.size() == this.totalItemCount;
        this.isAllSelected = z;
        this.onSelectionChangedListener.invoke(Boolean.valueOf(z));
    }

    /* compiled from: PhotosAdapter.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JF\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0\u00112\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/adapter/PhotosAdapter$PhotoViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "imageView", "Landroid/widget/ImageView;", "imgSize", "Landroid/widget/TextView;", "selectedOverlay", "bind", "", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO, "Lcom/gcs/recovery/videos/files/photo_recovery/model/PhotosModel;", "position", "", "onItemClickListener", "Lkotlin/Function1;", "onItemLongClickListener", "isSelected", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class PhotoViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;
        private final TextView imgSize;
        private final View selectedOverlay;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PhotoViewHolder(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.imageView);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.imageView = (ImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.imgSize);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.imgSize = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.selected_overlay);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.selectedOverlay = findViewById3;
        }

        public final void bind(PhotosModel photo, final int position, final Function1<? super Integer, Unit> onItemClickListener, final Function1<? super Integer, Unit> onItemLongClickListener, boolean isSelected) {
            Intrinsics.checkNotNullParameter(photo, "photo");
            Intrinsics.checkNotNullParameter(onItemClickListener, "onItemClickListener");
            Intrinsics.checkNotNullParameter(onItemLongClickListener, "onItemLongClickListener");
            Glide.with(this.itemView.getContext()).load(photo.getFile()).placeholder(R.drawable.ic_image_placeholder).into(this.imageView);
            this.imgSize.setText(Utils.INSTANCE.formatSize(photo.getSize()));
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.adapter.PhotosAdapter$PhotoViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PhotosAdapter.PhotoViewHolder.bind$lambda$0(Function1.this, position, view);
                }
            });
            this.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.adapter.PhotosAdapter$PhotoViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean bind$lambda$1;
                    bind$lambda$1 = PhotosAdapter.PhotoViewHolder.bind$lambda$1(Function1.this, position, view);
                    return bind$lambda$1;
                }
            });
            this.selectedOverlay.setVisibility(isSelected ? 0 : 8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0(Function1 onItemClickListener, int i, View view) {
            Intrinsics.checkNotNullParameter(onItemClickListener, "$onItemClickListener");
            onItemClickListener.invoke(Integer.valueOf(i));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean bind$lambda$1(Function1 onItemLongClickListener, int i, View view) {
            Intrinsics.checkNotNullParameter(onItemLongClickListener, "$onItemLongClickListener");
            onItemLongClickListener.invoke(Integer.valueOf(i));
            return true;
        }
    }
}
