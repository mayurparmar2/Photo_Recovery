package com.gcs.recovery.videos.files.photo_recovery.adapter;

import android.content.Context;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.share.internal.ShareInternalUtility;
import com.demo.example.databinding.ItemBackupContBinding;
import com.gcs.recovery.videos.files.photo_recovery.model.ContactModel;
import com.gcs.recovery.videos.files.photo_recovery.utils.Utils;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ContactBackupAdapter.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001cB+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\u001c\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u000eH\u0017J\u001c\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000eH\u0016J\b\u0010\u001b\u001a\u00020\u0014H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/adapter/ContactBackupAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/gcs/recovery/videos/files/photo_recovery/adapter/ContactBackupAdapter$ContactViewHolder;", "context", "Landroid/content/Context;", "backUpContList", "", "Lcom/gcs/recovery/videos/files/photo_recovery/model/ContactModel;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "ivError", "Landroid/view/View;", "(Landroid/content/Context;Ljava/util/List;Landroidx/recyclerview/widget/RecyclerView;Landroid/view/View;)V", "countContactsInVcf", "", ShareInternalUtility.STAGING_PARAM, "Ljava/io/File;", "getBackedUpContacts", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateVisibility", "ContactViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ContactBackupAdapter extends RecyclerView.Adapter<ContactViewHolder> {
    private List<ContactModel> backUpContList;
    private final Context context;
    private final View ivError;
    private final RecyclerView recyclerView;

    public ContactBackupAdapter(Context context, List<ContactModel> backUpContList, RecyclerView recyclerView, View ivError) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(backUpContList, "backUpContList");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(ivError, "ivError");
        this.context = context;
        this.backUpContList = backUpContList;
        this.recyclerView = recyclerView;
        this.ivError = ivError;
        this.backUpContList = getBackedUpContacts();
        updateVisibility();
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemBackupContBinding inflate = ItemBackupContBinding.inflate(LayoutInflater.from(this.context), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ContactViewHolder(this, inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.backUpContList.size();
    }

    private final List<ContactModel> getBackedUpContacts() {
        File file = new File(Environment.getExternalStorageDirectory(), "PhotoRecovery/Documents");
        if (!file.exists() || !file.isDirectory()) {
            return CollectionsKt.emptyList();
        }
        File[] listFiles = file.listFiles(new FileFilter() { // from class: com.gcs.recovery.videos.files.photo_recovery.adapter.ContactBackupAdapter$$ExternalSyntheticLambda0
            @Override // java.io.FileFilter
            public final boolean accept(File file2) {
                boolean backedUpContacts$lambda$0;
                backedUpContacts$lambda$0 = ContactBackupAdapter.getBackedUpContacts$lambda$0(file2);
                return backedUpContacts$lambda$0;
            }
        });
        if (listFiles == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(listFiles.length);
        for (File file2 : listFiles) {
            String name = file2.getName();
            String formatSize = Utils.INSTANCE.formatSize(file2.length());
            Intrinsics.checkNotNull(name);
            arrayList.add(new ContactModel(name, name, formatSize, null));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getBackedUpContacts$lambda$0(File file) {
        Intrinsics.checkNotNull(file);
        return Intrinsics.areEqual(FilesKt.getExtension(file), "vcf");
    }

    private final void updateVisibility() {
        if (this.backUpContList.isEmpty()) {
            this.recyclerView.setVisibility(View.GONE);
            this.ivError.setVisibility(View.VISIBLE);
        } else {
            this.recyclerView.setVisibility(View.VISIBLE);
            this.ivError.setVisibility(View.GONE);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ContactModel contactModel = this.backUpContList.get(position);
        File file = new File(Environment.getExternalStorageDirectory(), "PhotoRecovery/Documents/" + contactModel.getName());
        ItemBackupContBinding binding = holder.getBinding();
        binding.fileName.setText(contactModel.getName());
        binding.noOfItems.setText(countContactsInVcf(file) + " Contacts");
        binding.fileDate.setText(Utils.INSTANCE.formatDate(file.lastModified()));
    }

    private final int countContactsInVcf(File file) {
        try {
            return StringsKt.split$default((CharSequence) FilesKt.readText$default(file, null, 1, null), new String[]{"BEGIN:VCARD"}, false, 0, 6, (Object) null).size() - 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* compiled from: ContactBackupAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/adapter/ContactBackupAdapter$ContactViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ItemBackupContBinding;", "(Lcom/gcs/recovery/videos/files/photo_recovery/adapter/ContactBackupAdapter;Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ItemBackupContBinding;)V", "getBinding", "()Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ItemBackupContBinding;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ContactViewHolder extends RecyclerView.ViewHolder {
        private final ItemBackupContBinding binding;
        final /* synthetic */ ContactBackupAdapter this$0;

        public final ItemBackupContBinding getBinding() {
            return this.binding;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ContactViewHolder(ContactBackupAdapter contactBackupAdapter, ItemBackupContBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = contactBackupAdapter;
            this.binding = binding;
        }
    }
}
