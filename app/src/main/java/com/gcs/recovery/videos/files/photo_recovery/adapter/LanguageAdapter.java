package com.gcs.recovery.videos.files.photo_recovery.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.demo.example.R;
import com.gcs.recovery.videos.files.photo_recovery.adapter.LanguageAdapter;
import com.gcs.recovery.videos.files.photo_recovery.model.LanguageModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LanguageAdapter.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0016B'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\b\u0010\f\u001a\u00020\u000bH\u0016J\u001c\u0010\r\u001a\u00020\b2\n\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u001c\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/adapter/LanguageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/gcs/recovery/videos/files/photo_recovery/adapter/LanguageAdapter$LanguageViewHolder;", "languageList", "", "Lcom/gcs/recovery/videos/files/photo_recovery/model/LanguageModel;", "onLanguageSelected", "Lkotlin/Function1;", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "selectedPosition", "", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setSelectedLanguage", "language", "LanguageViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LanguageAdapter extends RecyclerView.Adapter<LanguageViewHolder> {
    private final List<LanguageModel> languageList;
    private final Function1<LanguageModel, Unit> onLanguageSelected;
    private int selectedPosition;

    /* JADX WARN: Multi-variable type inference failed */
    public LanguageAdapter(List<LanguageModel> languageList, Function1<? super LanguageModel, Unit> onLanguageSelected) {
        Intrinsics.checkNotNullParameter(languageList, "languageList");
        Intrinsics.checkNotNullParameter(onLanguageSelected, "onLanguageSelected");
        this.languageList = languageList;
        this.onLanguageSelected = onLanguageSelected;
        this.selectedPosition = -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public LanguageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_language, parent, false);
        Intrinsics.checkNotNull(inflate);
        return new LanguageViewHolder(this, inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(LanguageViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.languageList.get(position), position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.languageList.size();
    }

    public final void setSelectedLanguage(LanguageModel language) {
        Intrinsics.checkNotNullParameter(language, "language");
        int indexOf = this.languageList.indexOf(language);
        if (indexOf != -1) {
            this.selectedPosition = indexOf;
            notifyItemChanged(indexOf);
        }
    }

    /* compiled from: LanguageAdapter.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/adapter/LanguageAdapter$LanguageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/gcs/recovery/videos/files/photo_recovery/adapter/LanguageAdapter;Landroid/view/View;)V", "flagIcon", "Landroid/widget/ImageView;", "ivCheck", "languageNameText", "Landroid/widget/TextView;", "languageText", "bind", "", "language", "Lcom/gcs/recovery/videos/files/photo_recovery/model/LanguageModel;", "position", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class LanguageViewHolder extends RecyclerView.ViewHolder {
        private final ImageView flagIcon;
        private final ImageView ivCheck;
        private final TextView languageNameText;
        private final TextView languageText;
        final /* synthetic */ LanguageAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LanguageViewHolder(LanguageAdapter languageAdapter, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = languageAdapter;
            View findViewById = itemView.findViewById(R.id.language_flag_icon);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.flagIcon = (ImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.language_name_text);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.languageNameText = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.language_text);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.languageText = (TextView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.ivCheck);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
            this.ivCheck = (ImageView) findViewById4;
        }

        public final void bind(final LanguageModel language, final int position) {
            Intrinsics.checkNotNullParameter(language, "language");
            this.flagIcon.setImageResource(language.getFlagIcon());
            this.languageNameText.setText(language.getName());
            this.languageText.setText(language.getDisplayText());
            this.ivCheck.setVisibility(position == this.this$0.selectedPosition ? 0 : 4);
            View view = this.itemView;
            final LanguageAdapter languageAdapter = this.this$0;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.adapter.LanguageAdapter$LanguageViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LanguageAdapter.LanguageViewHolder.bind$lambda$0(LanguageAdapter.this, position, language, view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$0(LanguageAdapter this$0, int i, LanguageModel language, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(language, "$language");
            if (this$0.selectedPosition != i) {
                this$0.notifyItemChanged(this$0.selectedPosition);
                this$0.selectedPosition = i;
                this$0.notifyItemChanged(i);
                this$0.onLanguageSelected.invoke(language);
            }
        }
    }
}
