package com.gcs.recovery.videos.files.photo_recovery.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.demo.example.R;
import com.gcs.recovery.videos.files.photo_recovery.adapter.AudiosAdapter;
import com.gcs.recovery.videos.files.photo_recovery.model.AudiosModel;
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

/* compiled from: AudiosAdapter.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001*BO\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0010\rJ\u001c\u0010\u0014\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u00162\u0006\u0010\u0013\u001a\u00020\bJ\b\u0010\u0017\u001a\u00020\tH\u0002J\u0006\u0010\u0018\u001a\u00020\tJ\u000e\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\bJ\b\u0010\u001b\u001a\u00020\bH\u0016J\u0006\u0010\u001c\u001a\u00020\bJ\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016J\u0006\u0010\u001e\u001a\u00020\bJ\u0018\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\bH\u0017J\u0018\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\bH\u0016J\u0006\u0010%\u001a\u00020\tJ\u000e\u0010&\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\bJ\u000e\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u0005J\u001c\u0010)\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u00162\u0006\u0010\u0013\u001a\u00020\bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/adapter/AudiosAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/gcs/recovery/videos/files/photo_recovery/adapter/AudiosAdapter$AudiosViewHolder;", "audiosList", "", "Lcom/gcs/recovery/videos/files/photo_recovery/model/AudiosModel;", "onItemClickListener", "Lkotlin/Function1;", "", "", "onItemLongClickListener", "onSelectionChangedListener", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "<set-?>", "isAllSelected", "()Z", "selectedItems", "", "totalItemCount", "addAudios", "newAudios", "", "checkIfAllSelected", "deselectAll", "getItemAtPosition", "position", "getItemCount", "getSelectedItemCount", "getSelectedItems", "getTotalItemCount", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "selectAll", "toggleSelection", "updateAudio", "updatedAudio", "updateAudios", "AudiosViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AudiosAdapter extends RecyclerView.Adapter<AudiosViewHolder> {
    private final List<AudiosModel> audiosList;
    private boolean isAllSelected;
    private final Function1<Integer, Unit> onItemClickListener;
    private final Function1<Integer, Unit> onItemLongClickListener;
    private final Function1<Boolean, Unit> onSelectionChangedListener;
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
    public AudiosAdapter(List<AudiosModel> audiosList, Function1<? super Integer, Unit> onItemClickListener, Function1<? super Integer, Unit> onItemLongClickListener, Function1<? super Boolean, Unit> onSelectionChangedListener) {
        Intrinsics.checkNotNullParameter(audiosList, "audiosList");
        Intrinsics.checkNotNullParameter(onItemClickListener, "onItemClickListener");
        Intrinsics.checkNotNullParameter(onItemLongClickListener, "onItemLongClickListener");
        Intrinsics.checkNotNullParameter(onSelectionChangedListener, "onSelectionChangedListener");
        this.audiosList = audiosList;
        this.onItemClickListener = onItemClickListener;
        this.onItemLongClickListener = onItemLongClickListener;
        this.onSelectionChangedListener = onSelectionChangedListener;
        this.selectedItems = new LinkedHashSet();
    }

    public final AudiosModel getItemAtPosition(int position) {
        return this.audiosList.get(position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public AudiosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_audios, parent, false);
        Intrinsics.checkNotNull(inflate);
        return new AudiosViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(AudiosViewHolder holder, int position) {
        String formatDuration;
        Intrinsics.checkNotNullParameter(holder, "holder");
        AudiosModel audiosModel = this.audiosList.get(position);
        holder.bind(this.audiosList.get(position), position, this.onItemClickListener, this.onItemLongClickListener, this.selectedItems.contains(Integer.valueOf(position)));
        TextView audioDuration = holder.getAudioDuration();
        if (audiosModel.getDuration() != 0) {
            formatDuration = Utils.INSTANCE.formatDuration(audiosModel.getDuration());
        }
        audioDuration.setText(formatDuration);
        holder.getAudioDate().setText(Utils.INSTANCE.formatDate(audiosModel.getDateAdded()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.audiosList.size();
    }

    public final void addAudios(List<AudiosModel> newAudios, int totalItemCount) {
        Intrinsics.checkNotNullParameter(newAudios, "newAudios");
        int size = this.audiosList.size();
        this.totalItemCount = totalItemCount;
        this.audiosList.addAll(newAudios);
        notifyItemRangeInserted(size, newAudios.size());
    }

    public final void updateAudios(List<AudiosModel> newAudios, int totalItemCount) {
        Intrinsics.checkNotNullParameter(newAudios, "newAudios");
        this.totalItemCount = totalItemCount;
        this.audiosList.clear();
        this.audiosList.addAll(newAudios);
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
        CollectionsKt.addAll(this.selectedItems, RangesKt.until(0, this.audiosList.size()));
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

    public final List<AudiosModel> getSelectedItems() {
        Set<Integer> set = this.selectedItems;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(this.audiosList.get(((Number) it.next()).intValue()));
        }
        return arrayList;
    }

    private final void checkIfAllSelected() {
        boolean z = this.selectedItems.size() == this.totalItemCount;
        this.isAllSelected = z;
        this.onSelectionChangedListener.invoke(Boolean.valueOf(z));
    }

    /* compiled from: AudiosAdapter.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JF\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000e0\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000e0\u00142\u0006\u0010\u0016\u001a\u00020\u0017R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/adapter/AudiosAdapter$AudiosViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "audioDate", "Landroid/widget/TextView;", "getAudioDate", "()Landroid/widget/TextView;", "audioDuration", "getAudioDuration", "audioName", "selectItem", "bind", "", "audio", "Lcom/gcs/recovery/videos/files/photo_recovery/model/AudiosModel;", "position", "", "onItemClickListener", "Lkotlin/Function1;", "onItemLongClickListener", "isSelected", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class AudiosViewHolder extends RecyclerView.ViewHolder {
        private final TextView audioDate;
        private final TextView audioDuration;
        private final TextView audioName;
        private final View selectItem;

        public final TextView getAudioDate() {
            return this.audioDate;
        }

        public final TextView getAudioDuration() {
            return this.audioDuration;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AudiosViewHolder(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.audioName);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.audioName = (TextView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.audioDuration);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.audioDuration = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.audioDate);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.audioDate = (TextView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.select);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
            this.selectItem = findViewById4;
        }

        public final void bind(AudiosModel audio, final int position, final Function1<? super Integer, Unit> onItemClickListener, final Function1<? super Integer, Unit> onItemLongClickListener, boolean isSelected) {
            Intrinsics.checkNotNullParameter(audio, "audio");
            Intrinsics.checkNotNullParameter(onItemClickListener, "onItemClickListener");
            Intrinsics.checkNotNullParameter(onItemLongClickListener, "onItemLongClickListener");
            this.audioDuration.setText(Utils.INSTANCE.formatDuration(audio.getDuration()));
            this.audioName.setText(audio.getFile().getName());
            this.audioDate.setText(Utils.INSTANCE.formatDate(audio.getDateAdded()));
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.adapter.AudiosAdapter$AudiosViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AudiosAdapter.AudiosViewHolder.bind$lambda$0(Function1.this, position, view);
                }
            });
            this.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.adapter.AudiosAdapter$AudiosViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean bind$lambda$1;
                    bind$lambda$1 = AudiosAdapter.AudiosViewHolder.bind$lambda$1(Function1.this, position, view);
                    return bind$lambda$1;
                }
            });
            this.selectItem.setVisibility(isSelected ? 0 : 8);
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

    public final void updateAudio(AudiosModel updatedAudio) {
        Intrinsics.checkNotNullParameter(updatedAudio, "updatedAudio");
        Iterator<AudiosModel> it = this.audiosList.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual(it.next().getFile(), updatedAudio.getFile())) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            this.audiosList.set(i, updatedAudio);
            notifyItemChanged(i);
        }
    }
}
