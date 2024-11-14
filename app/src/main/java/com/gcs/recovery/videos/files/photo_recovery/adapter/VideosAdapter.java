package com.gcs.recovery.videos.files.photo_recovery.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.facebook.share.internal.ShareConstants;
import com.demo.example.R;
import com.gcs.recovery.videos.files.photo_recovery.adapter.VideosAdapter;
import com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass;
import com.gcs.recovery.videos.files.photo_recovery.model.VideosModel;
import com.gcs.recovery.videos.files.photo_recovery.utils.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: VideosAdapter.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00010BW\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u001c\u0010\u0017\u001a\u00020\t2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u00192\u0006\u0010\u0016\u001a\u00020\bJ\b\u0010\u001a\u001a\u00020\tH\u0002J\u0006\u0010\u001b\u001a\u00020\tJ\u000e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\bJ\b\u0010\u001e\u001a\u00020\bH\u0016J\u0006\u0010\u001f\u001a\u00020\bJ\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\u0019J\u0006\u0010!\u001a\u00020\bJ\u0010\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020$H\u0002J\u0018\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\bH\u0017J\u0018\u0010'\u001a\u00020\u00022\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\bH\u0016J\u0006\u0010+\u001a\u00020\tJ\u000e\u0010,\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\bJ\u000e\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\u0005J\u001c\u0010/\u001a\u00020\t2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u00192\u0006\u0010\u0016\u001a\u00020\bR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/adapter/VideosAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/gcs/recovery/videos/files/photo_recovery/adapter/VideosAdapter$VideoViewHolder;", "videoList", "", "Lcom/gcs/recovery/videos/files/photo_recovery/model/VideosModel;", "onItemClickListener", "Lkotlin/Function1;", "", "", "onItemLongClickListener", "onSelectionChangedListener", "", "activity", "Landroid/app/Activity;", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroid/app/Activity;)V", "clickCount", "<set-?>", "isAllSelected", "()Z", "selectedItems", "", "totalItemCount", "addVideos", "newVideos", "", "checkIfAllSelected", "deselectAll", "getItemAtPosition", "position", "getItemCount", "getSelectedItemCount", "getSelectedItems", "getTotalItemCount", "isZeroDurationExpected", ShareConstants.MEDIA_EXTENSION, "", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "selectAll", "toggleSelection", "updateVideo", "updatedVideo", "updateVideos", "VideoViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class VideosAdapter extends RecyclerView.Adapter<VideoViewHolder> {
    private final Activity activity;
    private int clickCount;
    private boolean isAllSelected;
    private final Function1<Integer, Unit> onItemClickListener;
    private final Function1<Integer, Unit> onItemLongClickListener;
    private final Function1<Boolean, Unit> onSelectionChangedListener;
    private Set<Integer> selectedItems;
    private int totalItemCount;
    private final List<VideosModel> videoList;

    public final int getTotalItemCount() {
        return this.totalItemCount;
    }

    /* renamed from: isAllSelected, reason: from getter */
    public final boolean getIsAllSelected() {
        return this.isAllSelected;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VideosAdapter(List<VideosModel> videoList, Function1<? super Integer, Unit> onItemClickListener, Function1<? super Integer, Unit> onItemLongClickListener, Function1<? super Boolean, Unit> onSelectionChangedListener, Activity activity) {
        Intrinsics.checkNotNullParameter(videoList, "videoList");
        Intrinsics.checkNotNullParameter(onItemClickListener, "onItemClickListener");
        Intrinsics.checkNotNullParameter(onItemLongClickListener, "onItemLongClickListener");
        Intrinsics.checkNotNullParameter(onSelectionChangedListener, "onSelectionChangedListener");
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.videoList = videoList;
        this.onItemClickListener = onItemClickListener;
        this.onItemLongClickListener = onItemLongClickListener;
        this.onSelectionChangedListener = onSelectionChangedListener;
        this.activity = activity;
        this.selectedItems = new LinkedHashSet();
    }

    public final VideosModel getItemAtPosition(int position) {
        return this.videoList.get(position);
    }

    public final void addVideos(List<VideosModel> newVideos, int totalItemCount) {
        Intrinsics.checkNotNullParameter(newVideos, "newVideos");
        int size = this.videoList.size();
        this.totalItemCount = totalItemCount;
        this.videoList.addAll(newVideos);
        notifyItemRangeInserted(size, newVideos.size());
    }

    public final void updateVideos(List<VideosModel> newVideos, int totalItemCount) {
        Intrinsics.checkNotNullParameter(newVideos, "newVideos");
        this.totalItemCount = totalItemCount;
        this.videoList.clear();
        this.videoList.addAll(newVideos);
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
        CollectionsKt.addAll(this.selectedItems, RangesKt.until(0, this.videoList.size()));
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

    public final List<VideosModel> getSelectedItems() {
        Set<Integer> set = this.selectedItems;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(this.videoList.get(((Number) it.next()).intValue()));
        }
        return arrayList;
    }

    private final void checkIfAllSelected() {
        boolean z = this.selectedItems.size() == this.totalItemCount;
        this.isAllSelected = z;
        this.onSelectionChangedListener.invoke(Boolean.valueOf(z));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_videos, parent, false);
        Intrinsics.checkNotNull(inflate);
        return new VideoViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(VideoViewHolder holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        VideosModel videosModel = this.videoList.get(position);
        holder.bind(this.videoList.get(position), position, this.onItemClickListener, this.onItemLongClickListener, this.selectedItems.contains(Integer.valueOf(position)));
        if (videosModel.getDuration() == 0) {
            if (isZeroDurationExpected(FilesKt.getExtension(videosModel.getFile()))) {
                holder.getTvDuration().setText("0:00");
            } else {
                holder.getTvDuration().setText("Calculating...");
            }
        } else {
            holder.getTvDuration().setText(Utils.INSTANCE.formatDuration(videosModel.getDuration()));
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.adapter.VideosAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideosAdapter.onBindViewHolder$lambda$3(VideosAdapter.this, position, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$3(final VideosAdapter this$0, final int i, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i2 = this$0.clickCount;
        int i3 = i2 + 1;
        this$0.clickCount = i3;
        if (i3 == 1 || i2 % 5 == 0) {
            AdsClass.showInterstitial(this$0.activity, new AdsClass.onListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.adapter.VideosAdapter$$ExternalSyntheticLambda0
                @Override // com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass.onListener
                public final void click() {
                    VideosAdapter.onBindViewHolder$lambda$3$lambda$2(VideosAdapter.this, i);
                }
            });
        } else {
            this$0.onItemClickListener.invoke(Integer.valueOf(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$3$lambda$2(VideosAdapter this$0, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onItemClickListener.invoke(Integer.valueOf(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.videoList.size();
    }

    /* compiled from: VideosAdapter.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JF\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0\u00132\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/adapter/VideosAdapter$VideoViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "imageView", "Landroid/widget/ImageView;", "selectedOverlay", "tvDuration", "Landroid/widget/TextView;", "getTvDuration", "()Landroid/widget/TextView;", "bind", "", "video", "Lcom/gcs/recovery/videos/files/photo_recovery/model/VideosModel;", "position", "", "onItemClickListener", "Lkotlin/Function1;", "onItemLongClickListener", "isSelected", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class VideoViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;
        private final View selectedOverlay;
        private final TextView tvDuration;

        public final TextView getTvDuration() {
            return this.tvDuration;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VideoViewHolder(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.imageView);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.imageView = (ImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.tv_duration);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.tvDuration = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.selected_overlay);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.selectedOverlay = findViewById3;
        }

        public final void bind(VideosModel video, final int position, final Function1<? super Integer, Unit> onItemClickListener, final Function1<? super Integer, Unit> onItemLongClickListener, boolean isSelected) {
            Intrinsics.checkNotNullParameter(video, "video");
            Intrinsics.checkNotNullParameter(onItemClickListener, "onItemClickListener");
            Intrinsics.checkNotNullParameter(onItemLongClickListener, "onItemLongClickListener");
            Glide.with(this.itemView.getContext()).load(video.getFile()).placeholder(R.drawable.ic_video_placeholder).into(this.imageView);
            this.tvDuration.setText(Utils.INSTANCE.formatDuration(video.getDuration()));
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.adapter.VideosAdapter$VideoViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VideosAdapter.VideoViewHolder.bind$lambda$0(Function1.this, position, view);
                }
            });
            this.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.adapter.VideosAdapter$VideoViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean bind$lambda$1;
                    bind$lambda$1 = VideosAdapter.VideoViewHolder.bind$lambda$1(Function1.this, position, view);
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

    private final boolean isZeroDurationExpected(String extension) {
        List listOf = CollectionsKt.listOf((Object[]) new String[]{"tmp", "partial", "crdownload"});
        String lowerCase = extension.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return listOf.contains(lowerCase);
    }

    public final void updateVideo(VideosModel updatedVideo) {
        Intrinsics.checkNotNullParameter(updatedVideo, "updatedVideo");
        Iterator<VideosModel> it = this.videoList.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual(it.next().getFile(), updatedVideo.getFile())) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            this.videoList.set(i, updatedVideo);
            notifyItemChanged(i);
        }
    }
}
