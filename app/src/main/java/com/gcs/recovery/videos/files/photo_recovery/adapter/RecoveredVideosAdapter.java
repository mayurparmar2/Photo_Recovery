package com.gcs.recovery.videos.files.photo_recovery.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.facebook.share.internal.ShareInternalUtility;
import com.demo.example.R;
import com.gcs.recovery.videos.files.photo_recovery.activity.RecoveredFileActivity;
import com.gcs.recovery.videos.files.photo_recovery.activity.ViewVideoActivity;
import com.demo.example.databinding.ItemVideosRecoveredBinding;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RecoveredVideosAdapter.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001dB)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001c\u0010\u0013\u001a\u00020\f2\n\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u000eH\u0016J\u001c\u0010\u0016\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eH\u0016J\u0006\u0010\u001a\u001a\u00020\fJ\u0010\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0007H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/adapter/RecoveredVideosAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/gcs/recovery/videos/files/photo_recovery/adapter/RecoveredVideosAdapter$VideoViewHolder;", "context", "Landroid/content/Context;", "videoList", "", "Ljava/io/File;", "selectedItems", "", "(Landroid/content/Context;Ljava/util/List;Ljava/util/List;)V", "deselectAll", "", "getItemCount", "", "isFileAlreadyRecovered", "", "filePath", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "selectAll", "toggleSelection", ShareInternalUtility.STAGING_PARAM, "VideoViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RecoveredVideosAdapter extends RecyclerView.Adapter<VideoViewHolder> {
    private final Context context;
    private final List<File> selectedItems;
    private final List<File> videoList;

    /* JADX WARN: Multi-variable type inference failed */
    public RecoveredVideosAdapter(Context context, List<? extends File> videoList, List<File> selectedItems) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(videoList, "videoList");
        Intrinsics.checkNotNullParameter(selectedItems, "selectedItems");
        this.context = context;
        this.videoList = videoList;
        this.selectedItems = selectedItems;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemVideosRecoveredBinding inflate = ItemVideosRecoveredBinding.inflate(LayoutInflater.from(this.context), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new VideoViewHolder(this, inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(VideoViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final File file = this.videoList.get(position);
        Glide.with(this.context).load(file).placeholder(R.drawable.ic_video_placeholder).into(holder.getBinding().imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.adapter.RecoveredVideosAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecoveredVideosAdapter.onBindViewHolder$lambda$1(RecoveredVideosAdapter.this, file, view);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.adapter.RecoveredVideosAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean onBindViewHolder$lambda$2;
                onBindViewHolder$lambda$2 = RecoveredVideosAdapter.onBindViewHolder$lambda$2(RecoveredVideosAdapter.this, file, view);
                return onBindViewHolder$lambda$2;
            }
        });
        holder.getBinding().selectedOverlay.setVisibility(this.selectedItems.contains(file) ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1(RecoveredVideosAdapter this$0, File videoFile, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(videoFile, "$videoFile");
        if (!this$0.selectedItems.isEmpty()) {
            this$0.toggleSelection(videoFile);
            return;
        }
        String absolutePath = videoFile.getAbsolutePath();
        Intent intent = new Intent(this$0.context, (Class<?>) ViewVideoActivity.class);
        intent.putExtra("FILE_TYPE", "video");
        intent.putExtra("VIDEO_PATH", absolutePath);
        Intrinsics.checkNotNull(absolutePath);
        intent.putExtra("IS_RECOVERED", this$0.isFileAlreadyRecovered(absolutePath));
        this$0.context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onBindViewHolder$lambda$2(RecoveredVideosAdapter this$0, File videoFile, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(videoFile, "$videoFile");
        this$0.toggleSelection(videoFile);
        return true;
    }

    private final void toggleSelection(File file) {
        if (this.selectedItems.contains(file)) {
            this.selectedItems.remove(file);
        } else {
            this.selectedItems.add(file);
        }
        notifyDataSetChanged();
        Context context = this.context;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.gcs.recovery.videos.files.photo_recovery.activity.RecoveredFileActivity");
        ((RecoveredFileActivity) context).updateSelectionUI(this.selectedItems.size());
    }

    private final boolean isFileAlreadyRecovered(String filePath) {
        File file = new File(filePath);
        if (file.exists() && file.isFile()) {
            File parentFile = file.getParentFile();
            if (Intrinsics.areEqual(parentFile != null ? parentFile.getName() : null, "Videos")) {
                return true;
            }
        }
        return false;
    }

    public final void selectAll() {
        this.selectedItems.clear();
        this.selectedItems.addAll(this.videoList);
        notifyDataSetChanged();
    }

    public final void deselectAll() {
        this.selectedItems.clear();
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.videoList.size();
    }

    /* compiled from: RecoveredVideosAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/adapter/RecoveredVideosAdapter$VideoViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ItemVideosRecoveredBinding;", "(Lcom/gcs/recovery/videos/files/photo_recovery/adapter/RecoveredVideosAdapter;Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ItemVideosRecoveredBinding;)V", "getBinding", "()Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ItemVideosRecoveredBinding;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class VideoViewHolder extends RecyclerView.ViewHolder {
        private final ItemVideosRecoveredBinding binding;
        final /* synthetic */ RecoveredVideosAdapter this$0;

        public final ItemVideosRecoveredBinding getBinding() {
            return this.binding;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VideoViewHolder(RecoveredVideosAdapter recoveredVideosAdapter, ItemVideosRecoveredBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = recoveredVideosAdapter;
            this.binding = binding;
        }
    }
}
