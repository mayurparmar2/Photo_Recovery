package com.gcs.recovery.videos.files.photo_recovery.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.demo.example.R;
import com.gcs.recovery.videos.files.photo_recovery.adapter.DocsAlbumAdapter;
import com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass;
import com.demo.example.databinding.ActivityDocsAlbumBinding;
import com.gcs.recovery.videos.files.photo_recovery.model.AlbumModel2;
import com.gcs.recovery.videos.files.photo_recovery.utils.SharedDataHolder;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DocsAlbumActivity.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0012\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u000fH\u0014J\b\u0010\u0015\u001a\u00020\u000fH\u0014J)\u0010\u0016\u001a\u00020\u000f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u000fH\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/activity/DocsAlbumActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "cachedDocPaths", "", "", "[Ljava/lang/String;", "docsAlbumBinding", "Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ActivityDocsAlbumBinding;", "getDocsFolders", "", "Lcom/gcs/recovery/videos/files/photo_recovery/model/AlbumModel2;", "docPaths", "([Ljava/lang/String;)Ljava/util/List;", "initializeDocData", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "setupRecyclerView", "albumList", "allDocPaths", "(Ljava/util/List;[Ljava/lang/String;)V", "showBackConfirmationDialog", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DocsAlbumActivity extends AppCompatActivity {
    private String[] cachedDocPaths = new String[0];
    private ActivityDocsAlbumBinding docsAlbumBinding;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatImageView appCompatImageView;
        super.onCreate(savedInstanceState);
        ActivityDocsAlbumBinding inflate = ActivityDocsAlbumBinding.inflate(getLayoutInflater());
        this.docsAlbumBinding = inflate;
        Intrinsics.checkNotNull(inflate);
        setContentView(inflate.getRoot());
        AdsClass adsClass = new AdsClass();
        ActivityDocsAlbumBinding activityDocsAlbumBinding = this.docsAlbumBinding;
        Intrinsics.checkNotNull(activityDocsAlbumBinding);
        adsClass.refreshAd(activityDocsAlbumBinding.frameLayout, this, 2);
        if (this.cachedDocPaths.length == 0) {
            initializeDocData();
        }
        ActivityDocsAlbumBinding activityDocsAlbumBinding2 = this.docsAlbumBinding;
        if (activityDocsAlbumBinding2 == null || (appCompatImageView = activityDocsAlbumBinding2.icBack) == null) {
            return;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DocsAlbumActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DocsAlbumActivity.onCreate$lambda$0(DocsAlbumActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(DocsAlbumActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showBackConfirmationDialog();
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x003f, code lost:
    
        if (r0 == null) goto L10;
     */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onResume() {
        String[] strArr;
        super.onResume();
        List<File> docFiles = SharedDataHolder.INSTANCE.getDocFiles();
        if (docFiles != null) {
            List<File> list = docFiles;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((File) it.next()).getAbsolutePath());
            }
            strArr = (String[]) arrayList.toArray(new String[0]);
        }
        strArr = new String[0];
        if (Arrays.equals(strArr, this.cachedDocPaths)) {
            return;
        }
        this.cachedDocPaths = strArr;
        setupRecyclerView(getDocsFolders(strArr), this.cachedDocPaths);
    }

    private final void initializeDocData() {
        List<File> docFiles = SharedDataHolder.INSTANCE.getDocFiles();
        if (docFiles == null) {
            docFiles = CollectionsKt.emptyList();
        }
        List<File> list = docFiles;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((File) it.next()).getAbsolutePath());
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        this.cachedDocPaths = strArr;
        setupRecyclerView(getDocsFolders(strArr), this.cachedDocPaths);
    }

    private final void setupRecyclerView(List<AlbumModel2> albumList, final String[] allDocPaths) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        if (albumList.isEmpty()) {
            ActivityDocsAlbumBinding activityDocsAlbumBinding = this.docsAlbumBinding;
            AppCompatImageView appCompatImageView = activityDocsAlbumBinding != null ? activityDocsAlbumBinding.ivError : null;
            if (appCompatImageView != null) {
                appCompatImageView.setVisibility(View.VISIBLE);
            }
            ActivityDocsAlbumBinding activityDocsAlbumBinding2 = this.docsAlbumBinding;
            recyclerView = activityDocsAlbumBinding2 != null ? activityDocsAlbumBinding2.recyclerView : null;
            if (recyclerView == null) {
                return;
            }
            recyclerView.setVisibility(View.GONE);
            return;
        }
        ActivityDocsAlbumBinding activityDocsAlbumBinding3 = this.docsAlbumBinding;
        AppCompatImageView appCompatImageView2 = activityDocsAlbumBinding3 != null ? activityDocsAlbumBinding3.ivError : null;
        if (appCompatImageView2 != null) {
            appCompatImageView2.setVisibility(View.GONE);
        }
        ActivityDocsAlbumBinding activityDocsAlbumBinding4 = this.docsAlbumBinding;
        recyclerView = activityDocsAlbumBinding4 != null ? activityDocsAlbumBinding4.recyclerView : null;
        if (recyclerView != null) {
            recyclerView.setVisibility(View.VISIBLE);
        }
        ActivityDocsAlbumBinding activityDocsAlbumBinding5 = this.docsAlbumBinding;
        if (activityDocsAlbumBinding5 == null || (recyclerView2 = activityDocsAlbumBinding5.recyclerView) == null) {
            return;
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        recyclerView2.setAdapter(new DocsAlbumAdapter(albumList, new Function1<AlbumModel2, Unit>() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DocsAlbumActivity$setupRecyclerView$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AlbumModel2 albumModel2) {
                invoke2(albumModel2);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Removed duplicated region for block: B:16:0x0075  */
            /* JADX WARN: Removed duplicated region for block: B:25:0x009b  */
            /* JADX WARN: Removed duplicated region for block: B:28:0x0096 A[SYNTHETIC] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(AlbumModel2 album) {
                int length;
                int i;
                String str;
                Intrinsics.checkNotNullParameter(album, "album");
                Intent intent = new Intent(DocsAlbumActivity.this, (Class<?>) DocsFilesActivity.class);
                intent.putExtra("ALBUM_TITLE", album.getAlbumName());
                String albumName = album.getAlbumName();
                int hashCode = albumName.hashCode();
                if (hashCode == -1530394768) {
                    if (albumName.equals("Deleted Files")) {
                        SharedDataHolder.INSTANCE.setAllDocPaths(album.getPaths());
                        intent.putExtra("ALBUM_PATH", "DELETED_FILES");
                    }
                    String[] strArr = allDocPaths;
                    length = strArr.length;
                    i = 0;
                    while (true) {
                        if (i >= length) {
                        }
                        i++;
                    }
                    SharedDataHolder.INSTANCE.setAlbumFolderPath(str != null ? new File(str).getParent() : null);
                    intent.putExtra("ALBUM_PATH", "SPECIFIC_ALBUM");
                } else if (hashCode == -678466887) {
                    if (albumName.equals("All Documents")) {
                        SharedDataHolder.INSTANCE.setAllDocPaths(ArraysKt.toList(allDocPaths));
                        intent.putExtra("ALBUM_PATH", "ALL_DOCS");
                    }
                    String[] strArr2 = allDocPaths;
                    length = strArr2.length;
                    i = 0;
                    while (true) {
                        if (i >= length) {
                        }
                        i++;
                    }
                    SharedDataHolder.INSTANCE.setAlbumFolderPath(str != null ? new File(str).getParent() : null);
                    intent.putExtra("ALBUM_PATH", "SPECIFIC_ALBUM");
                } else {
                    if (hashCode == 764447473 && albumName.equals("Hidden Docs")) {
                        SharedDataHolder.INSTANCE.setHiddenDocPaths(album.getPaths());
                        intent.putExtra("ALBUM_PATH", "HIDDEN_DOCS");
                    }
                    String[] strArr22 = allDocPaths;
                    length = strArr22.length;
                    i = 0;
                    while (true) {
                        if (i >= length) {
                            str = null;
                            break;
                        }
                        str = strArr22[i];
                        File parentFile = new File(str).getParentFile();
                        if (Intrinsics.areEqual(parentFile != null ? parentFile.getName() : null, album.getAlbumName())) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    SharedDataHolder.INSTANCE.setAlbumFolderPath(str != null ? new File(str).getParent() : null);
                    intent.putExtra("ALBUM_PATH", "SPECIFIC_ALBUM");
                }
                DocsAlbumActivity.this.startActivity(intent);
            }
        }));
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0116  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<AlbumModel2> getDocsFolders(String[] docPaths) {
        int i;
        boolean z;
        boolean z2;
        File parentFile;
        String name;
        File parentFile2;
        String name2;
        String[] strArr = docPaths;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        boolean z3 = false;
        int i2 = 0;
        for (int length = strArr.length; i2 < length; length = i) {
            File file = new File(strArr[i2]);
            File parentFile3 = file.getParentFile();
            if (parentFile3 == null) {
                i = length;
            } else {
                String name3 = file.getName();
                Intrinsics.checkNotNullExpressionValue(name3, "getName(...)");
                if (!StringsKt.startsWith$default(name3, ".", z3, 2, (Object) null) && ((parentFile2 = parentFile3.getParentFile()) == null || (name2 = parentFile2.getName()) == null || !StringsKt.startsWith$default(name2, ".Trash", z3, 2, (Object) null))) {
                    String name4 = parentFile3.getName();
                    Intrinsics.checkNotNullExpressionValue(name4, "getName(...)");
                    if (!StringsKt.startsWith$default(name4, ".Trash", false, 2, (Object) null)) {
                        String path = file.getPath();
                        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
                        i = length;
                        if (!StringsKt.contains$default((CharSequence) path, (CharSequence) "/.Trash/", false, 2, (Object) null)) {
                            String path2 = parentFile3.getPath();
                            Intrinsics.checkNotNullExpressionValue(path2, "getPath(...)");
                            if (!StringsKt.contains$default((CharSequence) path2, (CharSequence) ".Trash", false, 2, (Object) null)) {
                                String name5 = file.getName();
                                Intrinsics.checkNotNullExpressionValue(name5, "getName(...)");
                                if (!StringsKt.contains$default((CharSequence) name5, (CharSequence) "._", false, 2, (Object) null)) {
                                    String name6 = file.getName();
                                    Intrinsics.checkNotNullExpressionValue(name6, "getName(...)");
                                    if (!StringsKt.startsWith$default(name6, "~", false, 2, (Object) null)) {
                                        z = false;
                                        if (file.isHidden()) {
                                            z3 = false;
                                        } else {
                                            String name7 = file.getName();
                                            Intrinsics.checkNotNullExpressionValue(name7, "getName(...)");
                                            z3 = false;
                                            if (!StringsKt.startsWith$default(name7, ".", false, 2, (Object) null)) {
                                                String name8 = parentFile3.getName();
                                                Intrinsics.checkNotNullExpressionValue(name8, "getName(...)");
                                                if (!StringsKt.startsWith$default(name8, "pdf_temp", false, 2, (Object) null)) {
                                                    String name9 = parentFile3.getName();
                                                    Intrinsics.checkNotNullExpressionValue(name9, "getName(...)");
                                                    if (!StringsKt.startsWith$default(name9, ".", false, 2, (Object) null)) {
                                                        String name10 = file.getName();
                                                        Intrinsics.checkNotNullExpressionValue(name10, "getName(...)");
                                                        if (StringsKt.contains$default((CharSequence) name10, (CharSequence) ".", false, 2, (Object) null) && ((parentFile = parentFile3.getParentFile()) == null || (name = parentFile.getName()) == null || !StringsKt.startsWith$default(name, ".", false, 2, (Object) null))) {
                                                            z2 = false;
                                                            if (!z) {
                                                                arrayList3.add(file);
                                                                arrayList.add(file);
                                                            } else if (z2) {
                                                                arrayList2.add(file);
                                                                arrayList.add(file);
                                                            } else {
                                                                arrayList.add(file);
                                                                String absolutePath = parentFile3.getAbsolutePath();
                                                                Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                                                                Object obj = linkedHashMap.get(absolutePath);
                                                                if (obj == null) {
                                                                    obj = (List) new ArrayList();
                                                                    linkedHashMap.put(absolutePath, obj);
                                                                }
                                                                ((List) obj).add(file);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        z2 = true;
                                        if (!z) {
                                        }
                                    }
                                }
                            }
                        }
                        z = true;
                        if (file.isHidden()) {
                        }
                        z2 = true;
                        if (!z) {
                        }
                    }
                }
                i = length;
                z = true;
                if (file.isHidden()) {
                }
                z2 = true;
                if (!z) {
                }
            }
            i2++;
            strArr = docPaths;
        }
        ArrayList arrayList4 = new ArrayList();
        if (!arrayList.isEmpty()) {
            arrayList4.add(new AlbumModel2("All Documents", arrayList.size(), null, 4, null));
        }
        if (!arrayList2.isEmpty()) {
            int size = arrayList2.size();
            ArrayList arrayList5 = arrayList2;
            ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList5, 10));
            Iterator it = arrayList5.iterator();
            while (it.hasNext()) {
                arrayList6.add(((File) it.next()).getAbsolutePath());
            }
            arrayList4.add(new AlbumModel2("Hidden Docs", size, arrayList6));
        }
        if (!arrayList3.isEmpty()) {
            int size2 = arrayList3.size();
            ArrayList arrayList7 = arrayList3;
            ArrayList arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList7, 10));
            Iterator it2 = arrayList7.iterator();
            while (it2.hasNext()) {
                arrayList8.add(((File) it2.next()).getAbsolutePath());
            }
            arrayList4.add(new AlbumModel2("Deleted Files", size2, arrayList8));
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            String name11 = new File(str).getName();
            Intrinsics.checkNotNull(name11);
            arrayList4.add(new AlbumModel2(name11, list.size(), null, 4, null));
        }
        return arrayList4;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        showBackConfirmationDialog();
    }

    private final void showBackConfirmationDialog() {
        View inflate = getLayoutInflater().inflate(R.layout.dialog_back_alert, (ViewGroup) null);
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(inflate);
        bottomSheetDialog.setCancelable(true);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.iv_exit_btn);
        ((LinearLayout) inflate.findViewById(R.id.iv_cancel_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DocsAlbumActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DocsAlbumActivity.showBackConfirmationDialog$lambda$7(BottomSheetDialog.this, view);
            }
        });
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DocsAlbumActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DocsAlbumActivity.showBackConfirmationDialog$lambda$9(DocsAlbumActivity.this, bottomSheetDialog, view);
            }
        });
        bottomSheetDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showBackConfirmationDialog$lambda$7(BottomSheetDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showBackConfirmationDialog$lambda$9(final DocsAlbumActivity this$0, final BottomSheetDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        AdsClass.showInterstitial(this$0, new AdsClass.onListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DocsAlbumActivity$$ExternalSyntheticLambda1
            @Override // com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass.onListener
            public final void click() {
                DocsAlbumActivity.showBackConfirmationDialog$lambda$9$lambda$8(BottomSheetDialog.this, this$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showBackConfirmationDialog$lambda$9$lambda$8(BottomSheetDialog dialog, DocsAlbumActivity this$0) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialog.dismiss();
        this$0.finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.docsAlbumBinding = null;
    }
}
