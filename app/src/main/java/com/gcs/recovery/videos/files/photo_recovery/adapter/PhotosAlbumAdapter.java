package com.gcs.recovery.videos.files.photo_recovery.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.demo.example.R;
import com.gcs.recovery.videos.files.photo_recovery.adapter.PhotosAlbumAdapter;
import com.gcs.recovery.videos.files.photo_recovery.model.AlbumModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PhotosAlbumAdapter.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/adapter/PhotosAlbumAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/gcs/recovery/videos/files/photo_recovery/adapter/PhotosAlbumAdapter$AlbumViewHolder;", "albumList", "", "Lcom/gcs/recovery/videos/files/photo_recovery/model/AlbumModel;", "onItemClickListener", "Lkotlin/Function1;", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "AlbumViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PhotosAlbumAdapter extends RecyclerView.Adapter<AlbumViewHolder> {
    private final List<AlbumModel> albumList;
    private final Function1<AlbumModel, Unit> onItemClickListener;

    /* JADX WARN: Multi-variable type inference failed */
    public PhotosAlbumAdapter(List<AlbumModel> albumList, Function1<? super AlbumModel, Unit> onItemClickListener) {
        Intrinsics.checkNotNullParameter(albumList, "albumList");
        Intrinsics.checkNotNullParameter(onItemClickListener, "onItemClickListener");
        this.albumList = albumList;
        this.onItemClickListener = onItemClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public AlbumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_album, parent, false);
        Intrinsics.checkNotNull(inflate);
        return new AlbumViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(AlbumViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.albumList.get(position), this.onItemClickListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.albumList.size();
    }

    /* compiled from: PhotosAlbumAdapter.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\u000fH\u0007R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/adapter/PhotosAlbumAdapter$AlbumViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "ivThumbnail", "Landroid/widget/ImageView;", "tvAlbumName", "Landroid/widget/TextView;", "tvItemCount", "bind", "", "album", "Lcom/gcs/recovery/videos/files/photo_recovery/model/AlbumModel;", "onItemClickListener", "Lkotlin/Function1;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class AlbumViewHolder extends RecyclerView.ViewHolder {
        private final ImageView ivThumbnail;
        private final TextView tvAlbumName;
        private final TextView tvItemCount;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AlbumViewHolder(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.ivThumbnail);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.ivThumbnail = (ImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.tvAlbumName);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.tvAlbumName = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.tvItemCount);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.tvItemCount = (TextView) findViewById3;
        }

        public final void bind(final AlbumModel album, final Function1<? super AlbumModel, Unit> onItemClickListener) {
            Intrinsics.checkNotNullParameter(album, "album");
            Intrinsics.checkNotNullParameter(onItemClickListener, "onItemClickListener");
            this.tvAlbumName.setText(album.getAlbumName());
            this.tvItemCount.setText(album.getItemCount() + " Photos");
            Glide.with(this.itemView.getContext()).load(album.getThumbnail()).placeholder(R.drawable.ic_image_placeholder).into(this.ivThumbnail);
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.adapter.PhotosAlbumAdapter$AlbumViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PhotosAlbumAdapter.AlbumViewHolder.bind$lambda$0(Function1.this, album, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0(Function1 onItemClickListener, AlbumModel album, View view) {
            Intrinsics.checkNotNullParameter(onItemClickListener, "$onItemClickListener");
            Intrinsics.checkNotNullParameter(album, "$album");
            onItemClickListener.invoke(album);
        }
    }
}
