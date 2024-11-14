package com.gcs.recovery.videos.files.photo_recovery.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.demo.example.databinding.ItemFileInfoBinding;
import com.gcs.recovery.videos.files.photo_recovery.model.FileAttributeModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PreviewContentAdapter.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0011B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\f\u001a\u00020\bH\u0016J\u001c\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/adapter/PreviewContentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/gcs/recovery/videos/files/photo_recovery/adapter/PreviewContentAdapter$PreviewContentViewHolder;", "fileAttributes", "", "Lcom/gcs/recovery/videos/files/photo_recovery/model/FileAttributeModel;", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "PreviewContentViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PreviewContentAdapter extends RecyclerView.Adapter<PreviewContentViewHolder> {
    private final List<FileAttributeModel> fileAttributes;

    public PreviewContentAdapter(List<FileAttributeModel> fileAttributes) {
        Intrinsics.checkNotNullParameter(fileAttributes, "fileAttributes");
        this.fileAttributes = fileAttributes;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public PreviewContentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemFileInfoBinding inflate = ItemFileInfoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new PreviewContentViewHolder(this, inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(PreviewContentViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.fileAttributes.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.fileAttributes.size();
    }

    /* compiled from: PreviewContentAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/adapter/PreviewContentAdapter$PreviewContentViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ItemFileInfoBinding;", "(Lcom/gcs/recovery/videos/files/photo_recovery/adapter/PreviewContentAdapter;Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ItemFileInfoBinding;)V", "bind", "", "fileAttribute", "Lcom/gcs/recovery/videos/files/photo_recovery/model/FileAttributeModel;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class PreviewContentViewHolder extends RecyclerView.ViewHolder {
        private final ItemFileInfoBinding binding;
        final /* synthetic */ PreviewContentAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PreviewContentViewHolder(PreviewContentAdapter previewContentAdapter, ItemFileInfoBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = previewContentAdapter;
            this.binding = binding;
        }

        public final void bind(FileAttributeModel fileAttribute) {
            Intrinsics.checkNotNullParameter(fileAttribute, "fileAttribute");
            this.binding.previewInfo.setText(fileAttribute.getLabel());
            this.binding.itemInfoValue.setText(fileAttribute.getValue());
        }
    }
}
