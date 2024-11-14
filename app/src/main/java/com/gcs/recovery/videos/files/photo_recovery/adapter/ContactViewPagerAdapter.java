package com.gcs.recovery.videos.files.photo_recovery.adapter;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.PagerAdapter;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.demo.example.R;
import com.demo.example.databinding.ContactBackupBinding;
import com.demo.example.databinding.ContactDeleteBinding;
import com.demo.example.databinding.ContactDupLayoutBinding;
import com.demo.example.databinding.ContactsListBinding;
import com.gcs.recovery.videos.files.photo_recovery.model.ContactModel;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContactViewPagerAdapter.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0018H\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0018\u0010 \u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012¨\u0006$"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/adapter/ContactViewPagerAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "backedUpContacts", "", "Lcom/gcs/recovery/videos/files/photo_recovery/model/ContactModel;", "contactsAdapter", "Lcom/gcs/recovery/videos/files/photo_recovery/adapter/ContactsListAdapter;", "contactsList", "deletedContacts", "duplicateContacts", "layoutInflater", "Landroid/view/LayoutInflater;", "tabTitles", "", "", "[Ljava/lang/String;", "destroyItem", "", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "position", "", "object", "", "getCount", "getPageTitle", "", "handleBackPress", "", "instantiateItem", "isViewFromObject", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ContactViewPagerAdapter extends PagerAdapter {
    private final List<ContactModel> backedUpContacts;
    private ContactsListAdapter contactsAdapter;
    private final List<ContactModel> contactsList;
    private final Context context;
    private final List<ContactModel> deletedContacts;
    private final List<ContactModel> duplicateContacts;
    private final LayoutInflater layoutInflater;
    private final String[] tabTitles;

    public ContactViewPagerAdapter(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        Object systemService = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        this.layoutInflater = (LayoutInflater) systemService;
        this.tabTitles = new String[]{"Contacts", "Backup", "Deleted", "Duplicate"};
        this.contactsList = new ArrayList();
        this.backedUpContacts = new ArrayList();
        this.deletedContacts = new ArrayList();
        this.duplicateContacts = new ArrayList();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.tabTitles.length;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object object) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(object, "object");
        return Intrinsics.areEqual(view, object);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup container, int position) {
        Pair pair;
        ContactsListAdapter contactsListAdapter;
        Intrinsics.checkNotNullParameter(container, "container");
        if (position == 0) {
            pair = TuplesKt.to(ContactsListBinding.inflate(this.layoutInflater, container, false), "Contacts");
        } else if (position == 1) {
            pair = TuplesKt.to(ContactBackupBinding.inflate(this.layoutInflater, container, false), "Backup");
        } else if (position == 2) {
            pair = TuplesKt.to(ContactDeleteBinding.inflate(this.layoutInflater, container, false), "Delete Contact");
        } else if (position == 3) {
            pair = TuplesKt.to(ContactDupLayoutBinding.inflate(this.layoutInflater, container, false), "Duplicate");
        } else {
            throw new IllegalStateException("Invalid position: " + position);
        }
        ViewBinding viewBinding = (ViewBinding) pair.component1();
        RecyclerView recyclerView = (RecyclerView) viewBinding.getRoot().findViewById(R.id.recyclerView);
        View findViewById = viewBinding.getRoot().findViewById(R.id.iv_error);
        View findViewById2 = viewBinding.getRoot().findViewById(R.id.ivBackupBtn);
        View findViewById3 = viewBinding.getRoot().findViewById(R.id.contRecoverBtn);
        View findViewById4 = viewBinding.getRoot().findViewById(R.id.headerLayout);
        View findViewById5 = viewBinding.getRoot().findViewById(R.id.searchLayout);
        TextView textView = (TextView) viewBinding.getRoot().findViewById(R.id.searchBar);
        ImageView imageView = (ImageView) viewBinding.getRoot().findViewById(R.id.ic_select_all);
        TextView textView2 = (TextView) viewBinding.getRoot().findViewById(R.id.tvContTxt);
        if (position == 0) {
            Context context = this.context;
            List<ContactModel> list = this.contactsList;
            Intrinsics.checkNotNull(recyclerView);
            Intrinsics.checkNotNull(findViewById);
            Intrinsics.checkNotNull(findViewById2);
            Intrinsics.checkNotNull(findViewById4);
            Intrinsics.checkNotNull(findViewById5);
            Intrinsics.checkNotNull(textView);
            ContactsListAdapter contactsListAdapter2 = new ContactsListAdapter(context, list, recyclerView, findViewById, findViewById2, findViewById4, findViewById5, textView);
            this.contactsAdapter = contactsListAdapter2;
            contactsListAdapter = contactsListAdapter2;
        } else if (position == 1) {
            Context context2 = this.context;
            List<ContactModel> list2 = this.backedUpContacts;
            Intrinsics.checkNotNull(recyclerView);
            Intrinsics.checkNotNull(findViewById);
            contactsListAdapter = new ContactBackupAdapter(context2, list2, recyclerView, findViewById);
        } else if (position == 2) {
            Context context3 = this.context;
            List<ContactModel> list3 = this.deletedContacts;
            Intrinsics.checkNotNull(recyclerView);
            Intrinsics.checkNotNull(findViewById);
            Intrinsics.checkNotNull(findViewById3);
            Intrinsics.checkNotNull(findViewById4);
            Intrinsics.checkNotNull(imageView);
            Intrinsics.checkNotNull(textView2);
            contactsListAdapter = new ContactDeleteAdapter(context3, list3, recyclerView, findViewById, findViewById3, findViewById4, imageView, textView2);
        } else if (position == 3) {
            Context context4 = this.context;
            List<ContactModel> list4 = this.duplicateContacts;
            Intrinsics.checkNotNull(recyclerView);
            Intrinsics.checkNotNull(findViewById);
            contactsListAdapter = new ContactDupAdapter(context4, list4, recyclerView, findViewById);
        } else {
            throw new IllegalStateException("Invalid position: " + position);
        }
        recyclerView.setAdapter(contactsListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.context));
        if (position == 0 || position == 2) {
            recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.gcs.recovery.videos.files.photo_recovery.adapter.ContactViewPagerAdapter$instantiateItem$1
                @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                    Intrinsics.checkNotNullParameter(outRect, "outRect");
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(parent, "parent");
                    Intrinsics.checkNotNullParameter(state, "state");
                    if (parent.getChildAdapterPosition(view) == state.getItemCount() - 1) {
                        outRect.bottom = 280;
                    }
                }
            });
        }
        container.addView(viewBinding.getRoot());
        View root = viewBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup container, int position, Object object) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(object, "object");
        container.removeView((View) object);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int position) {
        return this.tabTitles[position];
    }

    public final boolean handleBackPress() {
        ContactsListAdapter contactsListAdapter = this.contactsAdapter;
        if (contactsListAdapter != null) {
            return contactsListAdapter.handleBackPress();
        }
        return false;
    }
}
