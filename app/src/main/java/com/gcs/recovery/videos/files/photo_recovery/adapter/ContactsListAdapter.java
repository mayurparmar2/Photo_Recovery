package com.gcs.recovery.videos.files.photo_recovery.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import androidx.webkit.internal.AssetHelper;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.AnalyticsEvents;
import com.demo.example.R;
import com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass;
import com.demo.example.databinding.ItemContactBinding;
import com.gcs.recovery.videos.files.photo_recovery.model.ContactModel;
import com.google.android.gms.actions.SearchIntents;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: ContactsListAdapter.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u00016BM\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0014H\u0002J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0017H\u0002J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0003J\u0006\u0010!\u001a\u00020\"J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u000bH\u0002J\u001c\u0010%\u001a\u00020\u00142\n\u0010&\u001a\u00060\u0002R\u00020\u00002\u0006\u0010'\u001a\u00020\u001dH\u0016J\u001c\u0010(\u001a\u00060\u0002R\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u001dH\u0016J\b\u0010,\u001a\u00020\u0014H\u0002J\b\u0010-\u001a\u00020\u0014H\u0002J\b\u0010.\u001a\u00020\u0014H\u0002J\u0010\u0010/\u001a\u00020\u00142\u0006\u00100\u001a\u00020\u0007H\u0002J\u0010\u00101\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u000bH\u0002J\u0010\u00102\u001a\u00020\u00142\u0006\u00103\u001a\u00020\"H\u0002J\b\u00104\u001a\u00020\u0014H\u0002J\b\u00105\u001a\u00020\u0014H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/adapter/ContactsListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/gcs/recovery/videos/files/photo_recovery/adapter/ContactsListAdapter$ContactViewHolder;", "context", "Landroid/content/Context;", "contactList", "", "Lcom/gcs/recovery/videos/files/photo_recovery/model/ContactModel;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "ivError", "Landroid/view/View;", "ivBackupBtn", "headerLayout", "searchLayout", "searchBar", "Landroid/widget/TextView;", "(Landroid/content/Context;Ljava/util/List;Landroidx/recyclerview/widget/RecyclerView;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/widget/TextView;)V", "originalContactList", "backupAllContacts", "", "callContact", "phoneNumber", "", "cancelSearch", "filterContacts", SearchIntents.EXTRA_QUERY, "getAllDeviceContacts", "getItemCount", "", "getNextAvailableVcfFile", "Ljava/io/File;", "folder", "handleBackPress", "", "hideKeyboard", ViewHierarchyConstants.VIEW_KEY, "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setupButton", "setupCancelSearch", "setupSearchFeature", "shareContact", "contact", "showKeyboard", "toggleSearch", "showSearch", "updateContactCount", "updateVisibility", "ContactViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ContactsListAdapter extends RecyclerView.Adapter<ContactViewHolder> {
    private List<ContactModel> contactList;
    private final Context context;
    private final View headerLayout;
    private final View ivBackupBtn;
    private final View ivError;
    private List<ContactModel> originalContactList;
    private final RecyclerView recyclerView;
    private final TextView searchBar;
    private final View searchLayout;

    public /* synthetic */ ContactsListAdapter(Context context, List list, RecyclerView recyclerView, View view, View view2, View view3, View view4, TextView textView, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? CollectionsKt.emptyList() : list, recyclerView, view, view2, view3, view4, textView);
    }

    public ContactsListAdapter(Context context, List<ContactModel> contactList, RecyclerView recyclerView, View ivError, View ivBackupBtn, View headerLayout, View searchLayout, TextView searchBar) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(contactList, "contactList");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(ivError, "ivError");
        Intrinsics.checkNotNullParameter(ivBackupBtn, "ivBackupBtn");
        Intrinsics.checkNotNullParameter(headerLayout, "headerLayout");
        Intrinsics.checkNotNullParameter(searchLayout, "searchLayout");
        Intrinsics.checkNotNullParameter(searchBar, "searchBar");
        this.context = context;
        this.contactList = contactList;
        this.recyclerView = recyclerView;
        this.ivError = ivError;
        this.ivBackupBtn = ivBackupBtn;
        this.headerLayout = headerLayout;
        this.searchLayout = searchLayout;
        this.searchBar = searchBar;
        this.originalContactList = CollectionsKt.emptyList();
        List<ContactModel> allDeviceContacts = getAllDeviceContacts();
        this.contactList = allDeviceContacts;
        this.originalContactList = allDeviceContacts;
        updateVisibility();
        setupButton();
        updateContactCount();
        setupSearchFeature();
        setupCancelSearch();
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemContactBinding inflate = ItemContactBinding.inflate(LayoutInflater.from(this.context), parent, false);
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
        final ContactModel contactModel = this.contactList.get(position);
        TextView textView = holder.getBinding().contName;
        textView.setText(contactModel.getName());
        textView.setSelected(true);
        textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        textView.setMarqueeRepeatLimit(-1);
        textView.setSingleLine(true);
        textView.setHorizontallyScrolling(true);
        holder.getBinding().contNum.setText(contactModel.getPhoneNumber());
        if (contactModel.getPhotoUri() != null) {
            Glide.with(this.context).load(contactModel.getPhotoUri()).apply((BaseRequestOptions<?>) RequestOptions.circleCropTransform()).into(holder.getBinding().itemImage);
        } else {
            holder.getBinding().itemImage.setImageResource(R.drawable.ic_contact);
        }
        holder.getBinding().shareCont.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.adapter.ContactsListAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ContactsListAdapter.onBindViewHolder$lambda$1(ContactsListAdapter.this, contactModel, view);
            }
        });
        holder.getBinding().callDial.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.adapter.ContactsListAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ContactsListAdapter.onBindViewHolder$lambda$2(ContactsListAdapter.this, contactModel, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1(ContactsListAdapter this$0, ContactModel contact, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(contact, "$contact");
        this$0.shareContact(contact);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$2(ContactsListAdapter this$0, ContactModel contact, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(contact, "$contact");
        this$0.callContact(contact.getPhoneNumber());
    }

    private final void shareContact(ContactModel contact) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(AssetHelper.DEFAULT_MIME_TYPE);
        intent.putExtra("android.intent.extra.TEXT", "Contact Name: " + contact.getName() + "\nPhone Number: " + contact.getPhoneNumber());
        this.context.startActivity(Intent.createChooser(intent, "Share Contact via"));
    }

    private final void callContact(String phoneNumber) {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:" + phoneNumber));
        this.context.startActivity(Intent.createChooser(intent, "Call Contact via"));
    }

    private final void updateVisibility() {
        this.recyclerView.setVisibility(this.contactList.isEmpty() ? View.GONE : View.VISIBLE);
        this.ivError.setVisibility(this.contactList.isEmpty() ? 0 : 8);
        this.ivBackupBtn.setVisibility(this.contactList.isEmpty() ? View.GONE : View.VISIBLE);
    }

    private final void setupButton() {
        this.ivBackupBtn.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.adapter.ContactsListAdapter$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ContactsListAdapter.setupButton$lambda$6(ContactsListAdapter.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupButton$lambda$6(final ContactsListAdapter this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.context;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        AdsClass.showInterstitial((Activity) context, new AdsClass.onListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.adapter.ContactsListAdapter$$ExternalSyntheticLambda3
            @Override // com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass.onListener
            public final void click() {
                ContactsListAdapter.setupButton$lambda$6$lambda$5(ContactsListAdapter.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupButton$lambda$6$lambda$5(ContactsListAdapter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.backupAllContacts();
    }

    private final void backupAllContacts() {
        File file = new File(Environment.getExternalStorageDirectory(), "PhotoRecovery/Documents");
        if (!file.exists()) {
            file.mkdirs();
        }
        File nextAvailableVcfFile = getNextAvailableVcfFile(file);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(nextAvailableVcfFile);
            for (ContactModel contactModel : this.contactList) {
                StringBuilder sb = new StringBuilder();
                sb.append("BEGIN:VCARD\n");
                sb.append("VERSION:3.0\n");
                sb.append("FN:").append(contactModel.getName()).append("\n");
                sb.append("TEL:").append(contactModel.getPhoneNumber()).append("\n");
                sb.append("END:VCARD\n");
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                byte[] bytes = sb2.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                fileOutputStream.write(bytes);
            }
            fileOutputStream.close();
            Toast.makeText(this.context, "Contacts backed up to " + nextAvailableVcfFile.getAbsolutePath(), Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this.context, "Failed to back up contacts", Toast.LENGTH_SHORT).show();
        }
    }

    private final File getNextAvailableVcfFile(File folder) {
        int i = 1;
        while (true) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            int i2 = i + 1;
            String format = String.format("Contacts %02d.vcf", Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            File file = new File(folder, format);
            if (!file.exists()) {
                return file;
            }
            i = i2;
        }
    }

    private final List<ContactModel> getAllDeviceContacts() {
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        Cursor query = this.context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, "display_name ASC");
        if (query != null) {
            Cursor cursor = query;
            try {
                Cursor cursor2 = cursor;
                int columnIndex = cursor2.getColumnIndex("_id");
                int columnIndex2 = cursor2.getColumnIndex("display_name");
                int columnIndex3 = cursor2.getColumnIndex("data1");
                int columnIndex4 = cursor2.getColumnIndex("photo_uri");
                while (cursor2.moveToNext()) {
                    String string = cursor2.getString(columnIndex);
                    String string2 = cursor2.getString(columnIndex2);
                    String str = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                    if (string2 == null) {
                        string2 = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                    } else {
                        Intrinsics.checkNotNull(string2);
                    }
                    String string3 = cursor2.getString(columnIndex3);
                    if (string3 != null) {
                        Intrinsics.checkNotNull(string3);
                        str = string3;
                    }
                    String string4 = cursor2.getString(columnIndex4);
                    String normalizeNumber = PhoneNumberUtils.normalizeNumber(str);
                    Intrinsics.checkNotNullExpressionValue(normalizeNumber, "normalizeNumber(...)");
                    String replace = new Regex("[^\\d]").replace(normalizeNumber, "");
                    if (hashSet.add(replace)) {
                        Intrinsics.checkNotNull(string);
                        arrayList.add(new ContactModel(string, string2, replace, string4));
                    }
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(cursor, null);
            } finally {
            }
        }
        return arrayList;
    }

    private final void updateContactCount() {
        ((TextView) this.headerLayout.findViewById(R.id.noOfCont)).setText(this.contactList.size() + " Contacts");
    }

    private final void setupSearchFeature() {
        this.headerLayout.findViewById(R.id.icSearch).setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.adapter.ContactsListAdapter$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ContactsListAdapter.setupSearchFeature$lambda$9(ContactsListAdapter.this, view);
            }
        });
        this.searchBar.addTextChangedListener(new TextWatcher() { // from class: com.gcs.recovery.videos.files.photo_recovery.adapter.ContactsListAdapter$setupSearchFeature$2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ContactsListAdapter.this.filterContacts(String.valueOf(s));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupSearchFeature$lambda$9(ContactsListAdapter this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.toggleSearch(true);
        this$0.searchBar.requestFocus();
        this$0.showKeyboard(this$0.searchBar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void filterContacts(String query) {
        ArrayList arrayList;
        String str = query;
        if (str.length() == 0) {
            arrayList = this.originalContactList;
        } else {
            List<ContactModel> list = this.originalContactList;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : list) {
                ContactModel contactModel = (ContactModel) obj;
                if (StringsKt.contains((CharSequence) contactModel.getName(), (CharSequence) str, true) || StringsKt.contains$default((CharSequence) contactModel.getPhoneNumber(), (CharSequence) str, false, 2, (Object) null)) {
                    arrayList2.add(obj);
                }
            }
            arrayList = arrayList2;
        }
        this.contactList = arrayList;
        notifyDataSetChanged();
        updateContactCount();
    }

    private final void setupCancelSearch() {
        this.searchLayout.findViewById(R.id.ivCancel).setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.adapter.ContactsListAdapter$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ContactsListAdapter.setupCancelSearch$lambda$11(ContactsListAdapter.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupCancelSearch$lambda$11(ContactsListAdapter this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.cancelSearch();
    }

    private final void cancelSearch() {
        toggleSearch(false);
        this.searchBar.setText("");
        filterContacts("");
        hideKeyboard(this.searchBar);
    }

    public final boolean handleBackPress() {
        if (this.searchLayout.getVisibility() != View.VISIBLE) {
            return false;
        }
        cancelSearch();
        return true;
    }

    private final void hideKeyboard(View view) {
        Object systemService = this.context.getSystemService(Context.INPUT_METHOD_SERVICE);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private final void showKeyboard(View view) {
        Object systemService = this.context.getSystemService(Context.INPUT_METHOD_SERVICE);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(view, 1);
    }

    private final void toggleSearch(boolean showSearch) {
        this.searchLayout.setVisibility(showSearch ? 0 : 8);
        this.headerLayout.findViewById(R.id.noOfContLayout).setVisibility(showSearch ? View.GONE : View.VISIBLE);
    }

    /* compiled from: ContactsListAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/adapter/ContactsListAdapter$ContactViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ItemContactBinding;", "(Lcom/gcs/recovery/videos/files/photo_recovery/adapter/ContactsListAdapter;Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ItemContactBinding;)V", "getBinding", "()Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ItemContactBinding;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ContactViewHolder extends RecyclerView.ViewHolder {
        private final ItemContactBinding binding;
        final /* synthetic */ ContactsListAdapter this$0;

        public final ItemContactBinding getBinding() {
            return this.binding;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ContactViewHolder(ContactsListAdapter contactsListAdapter, ItemContactBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = contactsListAdapter;
            this.binding = binding;
        }
    }
}
