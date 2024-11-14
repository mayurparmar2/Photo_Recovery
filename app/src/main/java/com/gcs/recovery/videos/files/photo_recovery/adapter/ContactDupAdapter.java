package com.gcs.recovery.videos.files.photo_recovery.adapter;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.AnalyticsEvents;
import com.demo.example.R;
import com.demo.example.databinding.ItemDeleteContactBinding;
import com.gcs.recovery.videos.files.photo_recovery.model.ContactModel;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.objectweb.asm.signature.SignatureVisitor;

/* compiled from: ContactDupAdapter.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002&'B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011H\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0012\u0010\u001c\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001aH\u0002J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u0018\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u000eH\u0016J\b\u0010%\u001a\u00020\u001fH\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/adapter/ContactDupAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "contactList", "", "Lcom/gcs/recovery/videos/files/photo_recovery/model/ContactModel;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "ivError", "Landroid/view/View;", "(Landroid/content/Context;Ljava/util/List;Landroidx/recyclerview/widget/RecyclerView;Landroid/view/View;)V", "ITEM_TYPE_CONTACT", "", "ITEM_TYPE_SET", "groupedItems", "", "", "getAllDupContacts", "getItemCount", "getItemViewType", "position", "groupContactsBySet", "contacts", "normalizePhoneNumber", "", "phoneNumber", "normalizeText", "text", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateVisibility", "ContactViewHolder", "SetViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ContactDupAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int ITEM_TYPE_CONTACT;
    private final int ITEM_TYPE_SET;
    private List<ContactModel> contactList;
    private final Context context;
    private List<? extends Object> groupedItems;
    private final View ivError;
    private final RecyclerView recyclerView;

    public ContactDupAdapter(Context context, List<ContactModel> contactList, RecyclerView recyclerView, View ivError) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(contactList, "contactList");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(ivError, "ivError");
        this.context = context;
        this.contactList = contactList;
        this.recyclerView = recyclerView;
        this.ivError = ivError;
        this.ITEM_TYPE_CONTACT = 1;
        this.ITEM_TYPE_SET = 2;
        this.groupedItems = CollectionsKt.emptyList();
        List<ContactModel> allDupContacts = getAllDupContacts(context);
        this.contactList = allDupContacts;
        this.groupedItems = groupContactsBySet(allDupContacts);
        updateVisibility();
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.groupedItems.get(position) instanceof String ? this.ITEM_TYPE_SET : this.ITEM_TYPE_CONTACT;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == this.ITEM_TYPE_SET) {
            View inflate = LayoutInflater.from(this.context).inflate(R.layout.item_set_header, parent, false);
            Intrinsics.checkNotNull(inflate);
            return new SetViewHolder(this, inflate);
        }
        ItemDeleteContactBinding inflate2 = ItemDeleteContactBinding.inflate(LayoutInflater.from(this.context), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(...)");
        return new ContactViewHolder(this, inflate2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.groupedItems.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof ContactViewHolder) {
            Object obj = this.groupedItems.get(position);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.gcs.recovery.videos.files.photo_recovery.model.ContactModel");
            ((ContactViewHolder) holder).bind((ContactModel) obj);
            return;
        }
        if (holder instanceof SetViewHolder) {
            Object obj2 = this.groupedItems.get(position);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            ((SetViewHolder) holder).bind((String) obj2);
        }
    }

    /* compiled from: ContactDupAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/adapter/ContactDupAdapter$ContactViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ItemDeleteContactBinding;", "(Lcom/gcs/recovery/videos/files/photo_recovery/adapter/ContactDupAdapter;Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ItemDeleteContactBinding;)V", "bind", "", "contact", "Lcom/gcs/recovery/videos/files/photo_recovery/model/ContactModel;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class ContactViewHolder extends RecyclerView.ViewHolder {
        private final ItemDeleteContactBinding binding;
        final /* synthetic */ ContactDupAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ContactViewHolder(ContactDupAdapter contactDupAdapter, ItemDeleteContactBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.this$0 = contactDupAdapter;
            this.binding = binding;
        }

        public final void bind(ContactModel contact) {
            Intrinsics.checkNotNullParameter(contact, "contact");
            TextView textView = this.binding.contName;
            textView.setText(contact.getName());
            textView.setSelected(true);
            textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
            textView.setMarqueeRepeatLimit(-1);
            textView.setSingleLine(true);
            textView.setHorizontallyScrolling(true);
            this.binding.contNumber.setText(contact.getPhoneNumber());
            this.binding.itemImage.setImageResource(R.drawable.ic_contact);
        }
    }

    /* compiled from: ContactDupAdapter.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/adapter/ContactDupAdapter$SetViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "(Lcom/gcs/recovery/videos/files/photo_recovery/adapter/ContactDupAdapter;Landroid/view/View;)V", "bind", "", "setName", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class SetViewHolder extends RecyclerView.ViewHolder {
        final /* synthetic */ ContactDupAdapter this$0;
        private final View view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SetViewHolder(ContactDupAdapter contactDupAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.this$0 = contactDupAdapter;
            this.view = view;
        }

        public final void bind(String setName) {
            Intrinsics.checkNotNullParameter(setName, "setName");
            View findViewById = this.view.findViewById(R.id.setText);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            ((TextView) findViewById).setText(setName);
        }
    }

    private final void updateVisibility() {
        this.recyclerView.setVisibility(this.groupedItems.isEmpty() ? View.GONE : View.VISIBLE);
        this.ivError.setVisibility(this.groupedItems.isEmpty() ? 0 : 8);
    }

    private final List<Object> groupContactsBySet(List<ContactModel> contacts) {
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : contacts) {
            ContactModel contactModel = (ContactModel) obj;
            String str = contactModel.getName() + SignatureVisitor.SUPER + contactModel.getPhoneNumber();
            Object obj2 = linkedHashMap.get(str);
            if (obj2 == null) {
                obj2 = (List) new ArrayList();
                linkedHashMap.put(str, obj2);
            }
            ((List) obj2).add(obj);
        }
        int i = 1;
        for (List list : linkedHashMap.values()) {
            if (list.size() > 1) {
                arrayList.add("Contact Set " + i);
                arrayList.addAll(list);
                i++;
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0059, code lost:
    
        if (r5 == null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<ContactModel> getAllDupContacts(Context context) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        Cursor query = context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{"contact_id", "display_name", "data1"}, null, null, null);
        if (query != null) {
            Cursor cursor = query;
            try {
                Cursor cursor2 = cursor;
                while (cursor2.moveToNext()) {
                    long j = cursor2.getLong(cursor2.getColumnIndex("contact_id"));
                    String string = cursor2.getString(cursor2.getColumnIndex("display_name"));
                    if (string != null) {
                        Intrinsics.checkNotNull(string);
                        str = StringsKt.trim((CharSequence) string).toString();
                    }
                    str = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                    String normalizeText = normalizeText(str);
                    String string2 = cursor2.getString(cursor2.getColumnIndex("data1"));
                    if (string2 == null) {
                        string2 = "No Phone Number";
                    } else {
                        Intrinsics.checkNotNull(string2);
                    }
                    String normalizePhoneNumber = normalizePhoneNumber(string2);
                    ContactModel contactModel = new ContactModel(String.valueOf(j), normalizeText, normalizePhoneNumber, null);
                    String str2 = normalizeText + '_' + normalizePhoneNumber;
                    if (!linkedHashMap.containsKey(str2)) {
                        linkedHashMap.put(str2, CollectionsKt.mutableListOf(contactModel));
                    } else {
                        List list = (List) linkedHashMap.get(str2);
                        if (list != null) {
                            list.add(contactModel);
                        }
                    }
                }
                Collection values = linkedHashMap.values();
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : values) {
                    if (((List) obj).size() > 1) {
                        arrayList2.add(obj);
                    }
                }
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    arrayList.addAll((List) it.next());
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(cursor, null);
            } finally {
            }
        }
        if (query != null) {
            query.close();
        }
        return arrayList;
    }

    private final String normalizePhoneNumber(String phoneNumber) {
        return new Regex("[^\\d+]").replace(phoneNumber, "");
    }

    private final String normalizeText(String text) {
        if (text == null) {
            return "";
        }
        String normalize = Normalizer.normalize(text, Normalizer.Form.NFD);
        Intrinsics.checkNotNullExpressionValue(normalize, "normalize(...)");
        String replace = new Regex("\\p{InCombiningDiacriticalMarks}+").replace(normalize, "");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String lowerCase = replace.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        String obj = StringsKt.trim((CharSequence) lowerCase).toString();
        return obj == null ? "" : obj;
    }
}
