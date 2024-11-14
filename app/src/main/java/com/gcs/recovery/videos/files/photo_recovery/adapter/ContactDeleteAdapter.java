package com.gcs.recovery.videos.files.photo_recovery.adapter;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.facebook.internal.AnalyticsEvents;
import com.demo.example.R;
import com.gcs.recovery.videos.files.photo_recovery.adapter.ContactDeleteAdapter;
import com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass;
import com.demo.example.databinding.ItemDeleteContactBinding;
import com.gcs.recovery.videos.files.photo_recovery.model.ContactModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContactDeleteAdapter.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001.BM\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0003J\u001c\u0010\u001e\u001a\u00020\u001f2\n\u0010 \u001a\u00060\u0002R\u00020\u00002\u0006\u0010!\u001a\u00020\u0017H\u0016J\u001c\u0010\"\u001a\u00060\u0002R\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0017H\u0016J\b\u0010&\u001a\u00020\u001fH\u0002J\b\u0010'\u001a\u00020\u001fH\u0002J\b\u0010(\u001a\u00020\u001fH\u0002J\u0010\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\u0007H\u0002J\b\u0010+\u001a\u00020\u001fH\u0002J\b\u0010,\u001a\u00020\u001fH\u0003J\b\u0010-\u001a\u00020\u001fH\u0002R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/adapter/ContactDeleteAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/gcs/recovery/videos/files/photo_recovery/adapter/ContactDeleteAdapter$ContactViewHolder;", "context", "Landroid/content/Context;", "contactList", "", "Lcom/gcs/recovery/videos/files/photo_recovery/model/ContactModel;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "ivError", "Landroid/view/View;", "contRecoveryBtn", "headerLayout", "allSelect", "Landroid/widget/ImageView;", "tvContTxt", "Landroid/widget/TextView;", "(Landroid/content/Context;Ljava/util/List;Landroidx/recyclerview/widget/RecyclerView;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/widget/ImageView;Landroid/widget/TextView;)V", "selectedContact", "", "getDeletedContacts", "getItemCount", "", "getPhoneNumber", "", "contentResolver", "Landroid/content/ContentResolver;", "contactId", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "recoverSelectedContacts", "setupAllSelectButton", "setupRecoveryButton", "toggleSelection", "contact", "updateAllSelectButtonIcon", "updateSelectedCount", "updateVisibility", "ContactViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ContactDeleteAdapter extends RecyclerView.Adapter<ContactViewHolder> {
    private final ImageView allSelect;
    private final View contRecoveryBtn;
    private List<ContactModel> contactList;
    private final Context context;
    private final View headerLayout;
    private final View ivError;
    private final RecyclerView recyclerView;
    private final List<ContactModel> selectedContact;
    private final TextView tvContTxt;

    public /* synthetic */ ContactDeleteAdapter(Context context, List list, RecyclerView recyclerView, View view, View view2, View view3, ImageView imageView, TextView textView, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? CollectionsKt.emptyList() : list, recyclerView, view, view2, view3, imageView, textView);
    }

    public ContactDeleteAdapter(Context context, List<ContactModel> contactList, RecyclerView recyclerView, View ivError, View contRecoveryBtn, View headerLayout, ImageView allSelect, TextView tvContTxt) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(contactList, "contactList");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(ivError, "ivError");
        Intrinsics.checkNotNullParameter(contRecoveryBtn, "contRecoveryBtn");
        Intrinsics.checkNotNullParameter(headerLayout, "headerLayout");
        Intrinsics.checkNotNullParameter(allSelect, "allSelect");
        Intrinsics.checkNotNullParameter(tvContTxt, "tvContTxt");
        this.context = context;
        this.contactList = contactList;
        this.recyclerView = recyclerView;
        this.ivError = ivError;
        this.contRecoveryBtn = contRecoveryBtn;
        this.headerLayout = headerLayout;
        this.allSelect = allSelect;
        this.tvContTxt = tvContTxt;
        this.selectedContact = new ArrayList();
        this.contactList = getDeletedContacts(context);
        updateVisibility();
        setupRecoveryButton();
        setupAllSelectButton();
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemDeleteContactBinding inflate = ItemDeleteContactBinding.inflate(LayoutInflater.from(this.context), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ContactViewHolder(this, inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.contactList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.contactList.get(position));
        updateAllSelectButtonIcon();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toggleSelection(ContactModel contact) {
        if (this.selectedContact.contains(contact)) {
            this.selectedContact.remove(contact);
        } else {
            this.selectedContact.add(contact);
        }
        notifyDataSetChanged();
        updateSelectedCount();
        updateAllSelectButtonIcon();
    }

    private final void updateSelectedCount() {
        this.tvContTxt.setText("Recover : " + this.selectedContact.size());
        this.contRecoveryBtn.setEnabled(!this.selectedContact.isEmpty());
    }

    private final void updateVisibility() {
        this.recyclerView.setVisibility(this.contactList.isEmpty() ? View.GONE : View.VISIBLE);
        this.ivError.setVisibility(this.contactList.isEmpty() ? 0 : 8);
        this.contRecoveryBtn.setVisibility(this.contactList.isEmpty() ? View.GONE : View.VISIBLE);
        this.headerLayout.setVisibility(this.contactList.isEmpty() ? View.GONE : View.VISIBLE);
    }

    private final void setupRecoveryButton() {
        this.contRecoveryBtn.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.adapter.ContactDeleteAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ContactDeleteAdapter.setupRecoveryButton$lambda$1(ContactDeleteAdapter.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupRecoveryButton$lambda$1(final ContactDeleteAdapter this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AdsClass.showInterstitial((Activity) this$0.context, new AdsClass.onListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.adapter.ContactDeleteAdapter$$ExternalSyntheticLambda1
            @Override // com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass.onListener
            public final void click() {
                ContactDeleteAdapter.setupRecoveryButton$lambda$1$lambda$0(ContactDeleteAdapter.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupRecoveryButton$lambda$1$lambda$0(ContactDeleteAdapter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.recoverSelectedContacts();
    }

    private final void setupAllSelectButton() {
        this.allSelect.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.adapter.ContactDeleteAdapter$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ContactDeleteAdapter.setupAllSelectButton$lambda$2(ContactDeleteAdapter.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupAllSelectButton$lambda$2(ContactDeleteAdapter this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.selectedContact.size() == this$0.contactList.size()) {
            this$0.selectedContact.clear();
        } else {
            this$0.selectedContact.clear();
            this$0.selectedContact.addAll(this$0.contactList);
        }
        this$0.updateAllSelectButtonIcon();
        this$0.notifyDataSetChanged();
        this$0.updateSelectedCount();
    }

    private final void updateAllSelectButtonIcon() {
        this.allSelect.setImageResource(this.selectedContact.size() == this.contactList.size() ? R.drawable.ic_slct : R.drawable.ic_dslct);
    }

    private final List<ContactModel> getDeletedContacts(Context context) {
        ArrayList arrayList = new ArrayList();
        ContentResolver contentResolver = context.getContentResolver();
        Cursor query = contentResolver.query(ContactsContract.RawContacts.CONTENT_URI, new String[]{"_id", "contact_id", "display_name"}, "deleted = ?", new String[]{"1"}, null);
        if (query != null) {
            Cursor cursor = query;
            try {
                Cursor cursor2 = cursor;
                Log.d("DeletedContacts", "Total items fetched: " + cursor2.getCount());
                while (cursor2.moveToNext()) {
                    long j = cursor2.getLong(cursor2.getColumnIndex("contact_id"));
                    String string = cursor2.getString(cursor2.getColumnIndex("display_name"));
                    if (string == null) {
                        string = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                    } else {
                        Intrinsics.checkNotNull(string);
                    }
                    Intrinsics.checkNotNull(contentResolver);
                    String phoneNumber = getPhoneNumber(contentResolver, j);
                    if (phoneNumber == null) {
                        phoneNumber = "No Phone Number";
                    }
                    Log.d("DeletedContacts", "Contact ID: " + j + ", Name: " + string + ", Phone: " + phoneNumber);
                    arrayList.add(new ContactModel(String.valueOf(j), string, phoneNumber, null));
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(cursor, null);
            } finally {
            }
        } else {
            Log.d("DeletedContacts", "Cursor is null or empty");
        }
        return arrayList;
    }

    private final String getPhoneNumber(ContentResolver contentResolver, long contactId) {
        Cursor query = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{"data1"}, "contact_id = ?", new String[]{String.valueOf(contactId)}, null);
        if (query == null) {
            return null;
        }
        Cursor cursor = query;
        try {
            Cursor cursor2 = cursor;
            String string = cursor2.moveToFirst() ? cursor2.getString(cursor2.getColumnIndex("data1")) : null;
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(cursor, null);
            return string;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(cursor, th);
                throw th2;
            }
        }
    }

    /* compiled from: ContactDeleteAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/adapter/ContactDeleteAdapter$ContactViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ItemDeleteContactBinding;", "(Lcom/gcs/recovery/videos/files/photo_recovery/adapter/ContactDeleteAdapter;Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ItemDeleteContactBinding;)V", "bind", "", "contact", "Lcom/gcs/recovery/videos/files/photo_recovery/model/ContactModel;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ContactViewHolder extends RecyclerView.ViewHolder {
        private final ItemDeleteContactBinding binding;
        final /* synthetic */ ContactDeleteAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ContactViewHolder(ContactDeleteAdapter contactDeleteAdapter, ItemDeleteContactBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = contactDeleteAdapter;
            this.binding = binding;
        }

        public final void bind(final ContactModel contact) {
            Intrinsics.checkNotNullParameter(contact, "contact");
            TextView textView = this.binding.contName;
            textView.setText(contact.getName());
            textView.setSelected(true);
            textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
            textView.setMarqueeRepeatLimit(-1);
            textView.setSingleLine(true);
            textView.setHorizontallyScrolling(true);
            this.binding.contNumber.setText(contact.getPhoneNumber());
            if (contact.getPhotoUri() != null) {
                Glide.with(this.this$0.context).load(contact.getPhotoUri()).apply((BaseRequestOptions<?>) RequestOptions.circleCropTransform()).into(this.binding.itemImage);
            } else {
                this.binding.itemImage.setImageResource(R.drawable.ic_contact);
            }
            boolean contains = this.this$0.selectedContact.contains(contact);
            this.binding.fileCheckBox.setSelected(contains);
            AppCompatImageView appCompatImageView = this.binding.fileCheckBox;
            final ContactDeleteAdapter contactDeleteAdapter = this.this$0;
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.adapter.ContactDeleteAdapter$ContactViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ContactDeleteAdapter.ContactViewHolder.bind$lambda$1(ContactDeleteAdapter.this, contact, view);
                }
            });
            this.binding.fileCheckBox.setImageResource(contains ? R.drawable.ic_slct : R.drawable.ic_dslct);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void bind$lambda$1(ContactDeleteAdapter this$0, ContactModel contact, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(contact, "$contact");
            this$0.toggleSelection(contact);
        }
    }

    private final void recoverSelectedContacts() {
        ContentResolver contentResolver = this.context.getContentResolver();
        ArrayList arrayList = new ArrayList();
        for (ContactModel contactModel : this.selectedContact) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("account_type", (String) null);
                contentValues.put("account_name", (String) null);
                Uri insert = contentResolver.insert(ContactsContract.RawContacts.CONTENT_URI, contentValues);
                if (insert != null) {
                    long parseId = ContentUris.parseId(insert);
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("raw_contact_id", Long.valueOf(parseId));
                    contentValues2.put("mimetype", "vnd.android.cursor.item/name");
                    contentValues2.put("data1", contactModel.getName());
                    if (contentResolver.insert(ContactsContract.Data.CONTENT_URI, contentValues2) == null) {
                        Log.d("ContactRecovery", "Failed to insert display name for contact: " + contactModel.getName());
                    }
                    if (contactModel.getPhoneNumber().length() > 0) {
                        ContentValues contentValues3 = new ContentValues();
                        contentValues3.put("raw_contact_id", Long.valueOf(parseId));
                        contentValues3.put("mimetype", "vnd.android.cursor.item/phone_v2");
                        contentValues3.put("data1", contactModel.getPhoneNumber());
                        contentValues3.put("data2", (Integer) 2);
                        if (contentResolver.insert(ContactsContract.Data.CONTENT_URI, contentValues3) == null) {
                            Log.d("ContactRecovery", "Failed to insert phone number for contact: " + contactModel.getName());
                        } else {
                            Log.d("ContactRecovery", "Recovered contact: " + contactModel.getName() + " with phone: " + contactModel.getPhoneNumber());
                        }
                    } else {
                        Log.d("ContactRecovery", "No phone number available for contact: " + contactModel.getName());
                    }
                    arrayList.add(contactModel);
                }
            } catch (Exception e) {
                Log.e("ContactRecovery", "Error recovering contact: " + contactModel.getName(), e);
            }
        }
        this.contactList = CollectionsKt.minus((Iterable) this.contactList, (Iterable) CollectionsKt.toSet(arrayList));
        this.selectedContact.clear();
        updateSelectedCount();
        notifyDataSetChanged();
        updateVisibility();
    }
}
