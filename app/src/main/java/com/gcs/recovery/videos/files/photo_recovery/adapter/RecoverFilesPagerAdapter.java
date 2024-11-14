package com.gcs.recovery.videos.files.photo_recovery.adapter;

import android.content.Context;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.PagerAdapter;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.demo.example.R;
import com.demo.example.databinding.RecoveredAudiosFileBinding;
import com.demo.example.databinding.RecoveredDocumentsFileBinding;
import com.demo.example.databinding.RecoveredPhotosFileBinding;
import com.demo.example.databinding.RecoveredVideosFileBinding;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RecoverFilesPagerAdapter.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0011\u001a\u00020\u0012J \u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\"\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001b2\u0006\u0010\u001c\u001a\u00020\t2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001eH\u0002J\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001eJ\b\u0010 \u001a\u00020\u0017H\u0016J\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001e2\u0006\u0010\u001c\u001a\u00020\tJ\u0010\u0010\"\u001a\u00020#2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010$\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0006\u0010)\u001a\u00020\u0012J \u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020,2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010-\u001a\u00020.H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006/"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/adapter/RecoverFilesPagerAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "layoutInflater", "Landroid/view/LayoutInflater;", "selectedItems", "", "", "", "Ljava/io/File;", "getSelectedItems", "()Ljava/util/Map;", "tabTitles", "", "[Ljava/lang/String;", "clearSelectedItems", "", "destroyItem", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "position", "", "object", "", "getAdapterForType", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "fileType", "files", "", "getAllSelectedFiles", "getCount", "getFilesForType", "getPageTitle", "", "instantiateItem", "isViewFromObject", "", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "refreshAllTabs", "setupRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "ivError", "Landroidx/appcompat/widget/AppCompatImageView;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RecoverFilesPagerAdapter extends PagerAdapter {
    private final Context context;
    private final LayoutInflater layoutInflater;
    private final Map<String, List<File>> selectedItems;
    private final String[] tabTitles;

    public final Map<String, List<File>> getSelectedItems() {
        return this.selectedItems;
    }

    public RecoverFilesPagerAdapter(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        Object systemService = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        this.layoutInflater = (LayoutInflater) systemService;
        String[] strArr = {"Photos", "Videos", "Audios", "Documents"};
        this.tabTitles = strArr;
        this.selectedItems = new LinkedHashMap();
        for (String str : strArr) {
            this.selectedItems.put(str, new ArrayList());
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.tabTitles.length;
    }

    public final void refreshAllTabs() {
        int count = getCount();
        for (int i = 0; i < count; i++) {
            List<File> list = this.selectedItems.get(this.tabTitles[i]);
            if (list != null) {
                list.clear();
            }
        }
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object object) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(object, "object");
        return Intrinsics.areEqual(view, object);
    }

    public final List<File> getAllSelectedFiles() {
        return CollectionsKt.flatten(this.selectedItems.values());
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup container, int position) {
        Pair pair;
        Intrinsics.checkNotNullParameter(container, "container");
        if (position == 0) {
            pair = TuplesKt.to(RecoveredPhotosFileBinding.inflate(this.layoutInflater, container, false), "Photos");
        } else if (position == 1) {
            pair = TuplesKt.to(RecoveredVideosFileBinding.inflate(this.layoutInflater, container, false), "Videos");
        } else if (position == 2) {
            pair = TuplesKt.to(RecoveredAudiosFileBinding.inflate(this.layoutInflater, container, false), "Audios");
        } else if (position == 3) {
            pair = TuplesKt.to(RecoveredDocumentsFileBinding.inflate(this.layoutInflater, container, false), "Documents");
        } else {
            throw new IllegalStateException("Invalid position: " + position);
        }
        ViewBinding viewBinding = (ViewBinding) pair.component1();
        String str = (String) pair.component2();
        RecyclerView recyclerView = (RecyclerView) viewBinding.getRoot().findViewById(R.id.recyclerView);
        recyclerView.setTag("recyclerView_" + str);
        Intrinsics.checkNotNull(recyclerView);
        View findViewById = viewBinding.getRoot().findViewById(R.id.iv_error);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        setupRecyclerView(recyclerView, str, (AppCompatImageView) findViewById);
        container.addView(viewBinding.getRoot());
        View root = viewBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    private final void setupRecyclerView(RecyclerView recyclerView, String fileType, AppCompatImageView ivError) {
        List<File> filesForType = getFilesForType(fileType);
        if (filesForType.isEmpty()) {
            recyclerView.setVisibility(View.GONE);
            ivError.setVisibility(View.VISIBLE);
        } else {
            recyclerView.setVisibility(View.VISIBLE);
            ivError.setVisibility(View.GONE);
            recyclerView.setLayoutManager(new GridLayoutManager(this.context, 3));
            recyclerView.setAdapter(getAdapterForType(fileType, filesForType));
        }
    }

    public final List<File> getFilesForType(String fileType) {
        Intrinsics.checkNotNullParameter(fileType, "fileType");
        File[] listFiles = new File(Environment.getExternalStorageDirectory(), "PhotoRecovery/" + fileType).listFiles();
        if (listFiles == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (File file : listFiles) {
            if (file.isFile()) {
                arrayList.add(file);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    private final RecyclerView.Adapter<?> getAdapterForType(String fileType, List<? extends File> files) {
        switch (fileType.hashCode()) {
            case -1905167199:
                if (fileType.equals("Photos")) {
                    Context context = this.context;
                    List<File> list = this.selectedItems.get(fileType);
                    Intrinsics.checkNotNull(list);
                    return new RecoveredPhotosAdapter(context, files, list);
                }
                break;
            case -1732810888:
                if (fileType.equals("Videos")) {
                    Context context2 = this.context;
                    List<File> list2 = this.selectedItems.get(fileType);
                    Intrinsics.checkNotNull(list2);
                    return new RecoveredVideosAdapter(context2, files, list2);
                }
                break;
            case -1347456360:
                if (fileType.equals("Documents")) {
                    Context context3 = this.context;
                    List<File> list3 = this.selectedItems.get(fileType);
                    Intrinsics.checkNotNull(list3);
                    return new RecoveredDocsAdapter(context3, files, list3);
                }
                break;
            case 1972030333:
                if (fileType.equals("Audios")) {
                    Context context4 = this.context;
                    List<File> list4 = this.selectedItems.get(fileType);
                    Intrinsics.checkNotNull(list4);
                    return new RecoveredAudiosAdapter(context4, files, list4);
                }
                break;
        }
        throw new IllegalArgumentException("Unknown file type");
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

    public final void clearSelectedItems() {
        Iterator<Map.Entry<String, List<File>>> it = this.selectedItems.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().clear();
        }
    }
}
