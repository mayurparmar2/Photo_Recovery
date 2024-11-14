package com.gcs.recovery.videos.files.photo_recovery.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.demo.example.R;
import com.gcs.recovery.videos.files.photo_recovery.adapter.VideoAlbumAdapter;
import com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass;
import com.demo.example.databinding.ActivityVideoRecoverBinding;
import com.gcs.recovery.videos.files.photo_recovery.model.AlbumModel;
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

/* compiled from: VideoAlbumActivity.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0012\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u000fH\u0014J\b\u0010\u0015\u001a\u00020\u000fH\u0014J)\u0010\u0016\u001a\u00020\u000f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u000fH\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/activity/VideoAlbumActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "cachedVideoPaths", "", "", "[Ljava/lang/String;", "videoRecoverBinding", "Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ActivityVideoRecoverBinding;", "getVideoFolders", "", "Lcom/gcs/recovery/videos/files/photo_recovery/model/AlbumModel;", "videoPaths", "([Ljava/lang/String;)Ljava/util/List;", "initializeVideoData", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "setupRecyclerView", "albumList", "allVideoPaths", "(Ljava/util/List;[Ljava/lang/String;)V", "showBackConfirmationDialog", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class VideoAlbumActivity extends AppCompatActivity {
    private String[] cachedVideoPaths = new String[0];
    private ActivityVideoRecoverBinding videoRecoverBinding;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatImageView appCompatImageView;
        super.onCreate(savedInstanceState);
        ActivityVideoRecoverBinding inflate = ActivityVideoRecoverBinding.inflate(getLayoutInflater());
        this.videoRecoverBinding = inflate;
        Intrinsics.checkNotNull(inflate);
        setContentView(inflate.getRoot());
        AdsClass adsClass = new AdsClass();
        ActivityVideoRecoverBinding activityVideoRecoverBinding = this.videoRecoverBinding;
        Intrinsics.checkNotNull(activityVideoRecoverBinding);
        adsClass.refreshAd(activityVideoRecoverBinding.frameLayout, this, 2);
        if (this.cachedVideoPaths.length == 0) {
            initializeVideoData();
        }
        ActivityVideoRecoverBinding activityVideoRecoverBinding2 = this.videoRecoverBinding;
        if (activityVideoRecoverBinding2 == null || (appCompatImageView = activityVideoRecoverBinding2.icBack) == null) {
            return;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.VideoAlbumActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoAlbumActivity.onCreate$lambda$0(VideoAlbumActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(VideoAlbumActivity this$0, View view) {
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
        List<File> videoFiles = SharedDataHolder.INSTANCE.getVideoFiles();
        if (videoFiles != null) {
            List<File> list = videoFiles;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((File) it.next()).getAbsolutePath());
            }
            strArr = (String[]) arrayList.toArray(new String[0]);
        }
        strArr = new String[0];
        if (Arrays.equals(strArr, this.cachedVideoPaths)) {
            return;
        }
        this.cachedVideoPaths = strArr;
        setupRecyclerView(getVideoFolders(strArr), this.cachedVideoPaths);
    }

    private final void initializeVideoData() {
        List<File> videoFiles = SharedDataHolder.INSTANCE.getVideoFiles();
        if (videoFiles == null) {
            videoFiles = CollectionsKt.emptyList();
        }
        List filterNotNull = CollectionsKt.filterNotNull(videoFiles);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(filterNotNull, 10));
        Iterator it = filterNotNull.iterator();
        while (it.hasNext()) {
            arrayList.add(((File) it.next()).getAbsolutePath());
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        this.cachedVideoPaths = strArr;
        setupRecyclerView(getVideoFolders(strArr), this.cachedVideoPaths);
    }

    private final void setupRecyclerView(List<AlbumModel> albumList, final String[] allVideoPaths) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        if (albumList.isEmpty()) {
            ActivityVideoRecoverBinding activityVideoRecoverBinding = this.videoRecoverBinding;
            AppCompatImageView appCompatImageView = activityVideoRecoverBinding != null ? activityVideoRecoverBinding.ivError : null;
            Intrinsics.checkNotNull(appCompatImageView);
            appCompatImageView.setVisibility(View.VISIBLE);
            ActivityVideoRecoverBinding activityVideoRecoverBinding2 = this.videoRecoverBinding;
            recyclerView = activityVideoRecoverBinding2 != null ? activityVideoRecoverBinding2.recyclerView : null;
            Intrinsics.checkNotNull(recyclerView);
            recyclerView.setVisibility(View.GONE);
            return;
        }
        ActivityVideoRecoverBinding activityVideoRecoverBinding3 = this.videoRecoverBinding;
        AppCompatImageView appCompatImageView2 = activityVideoRecoverBinding3 != null ? activityVideoRecoverBinding3.ivError : null;
        Intrinsics.checkNotNull(appCompatImageView2);
        appCompatImageView2.setVisibility(View.GONE);
        ActivityVideoRecoverBinding activityVideoRecoverBinding4 = this.videoRecoverBinding;
        recyclerView = activityVideoRecoverBinding4 != null ? activityVideoRecoverBinding4.recyclerView : null;
        Intrinsics.checkNotNull(recyclerView);
        recyclerView.setVisibility(View.VISIBLE);
        ActivityVideoRecoverBinding activityVideoRecoverBinding5 = this.videoRecoverBinding;
        if (activityVideoRecoverBinding5 == null || (recyclerView2 = activityVideoRecoverBinding5.recyclerView) == null) {
            return;
        }
        recyclerView2.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView2.setAdapter(new VideoAlbumAdapter(albumList, new Function1<AlbumModel, Unit>() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.VideoAlbumActivity$setupRecyclerView$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AlbumModel albumModel) {
                invoke2(albumModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AlbumModel album) {
                Intrinsics.checkNotNullParameter(album, "album");
                Intent intent = new Intent(VideoAlbumActivity.this, (Class<?>) VideoFilesActivity.class);
                intent.putExtra("ALBUM_TITLE", album.getAlbumName());
                String albumName = album.getAlbumName();
                int hashCode = albumName.hashCode();
                if (hashCode == -1677571337) {
                    if (albumName.equals("All Videos")) {
                        SharedDataHolder.INSTANCE.setAllVideoPaths(ArraysKt.toList(allVideoPaths));
                        intent.putExtra("ALBUM_PATH", "ALL_VIDEOS");
                    }
                    SharedDataHolder.INSTANCE.setAlbumFolderPath(new File(album.getThumbnail().getAbsolutePath()).getParent());
                    intent.putExtra("ALBUM_PATH", "SPECIFIC_ALBUM");
                } else if (hashCode == 260230527) {
                    if (albumName.equals("Deleted Videos")) {
                        SharedDataHolder.INSTANCE.setAllVideoPaths(album.getPaths());
                        intent.putExtra("ALBUM_PATH", "DELETED_FILES");
                    }
                    SharedDataHolder.INSTANCE.setAlbumFolderPath(new File(album.getThumbnail().getAbsolutePath()).getParent());
                    intent.putExtra("ALBUM_PATH", "SPECIFIC_ALBUM");
                } else {
                    if (hashCode == 704417422 && albumName.equals("Hidden Videos")) {
                        SharedDataHolder.INSTANCE.setHiddenVideoPaths(album.getPaths());
                        intent.putExtra("ALBUM_PATH", "HIDDEN_VIDEOS");
                    }
                    SharedDataHolder.INSTANCE.setAlbumFolderPath(new File(album.getThumbnail().getAbsolutePath()).getParent());
                    intent.putExtra("ALBUM_PATH", "SPECIFIC_ALBUM");
                }
                VideoAlbumActivity.this.startActivity(intent);
            }
        }));
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<AlbumModel> getVideoFolders(String[] videoPaths) {
        Object next;
        Object next2;
        Object next3;
        Object next4;
        int i;
        boolean z;
        boolean z2;
        boolean z3;
        File parentFile;
        String name;
        String[] strArr = videoPaths;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        boolean z4 = false;
        int i2 = 0;
        for (int length = strArr.length; i2 < length; length = i) {
            File file = new File(strArr[i2]);
            File parentFile2 = file.getParentFile();
            if (parentFile2 == null) {
                i = length;
                z2 = z4;
            } else {
                String name2 = file.getName();
                Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                if (!StringsKt.startsWith$default(name2, ".", z4, 2, (Object) null) && ((parentFile = parentFile2.getParentFile()) == null || (name = parentFile.getName()) == null || !StringsKt.startsWith$default(name, ".Trash", z4, 2, (Object) null))) {
                    String name3 = parentFile2.getName();
                    Intrinsics.checkNotNullExpressionValue(name3, "getName(...)");
                    if (!StringsKt.startsWith$default(name3, ".Trash", false, 2, (Object) null)) {
                        String path = file.getPath();
                        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
                        i = length;
                        if (!StringsKt.contains$default((CharSequence) path, (CharSequence) "/.Trash/", false, 2, (Object) null)) {
                            String name4 = file.getName();
                            Intrinsics.checkNotNullExpressionValue(name4, "getName(...)");
                            if (!StringsKt.startsWith$default(name4, "-", false, 2, (Object) null)) {
                                String path2 = parentFile2.getPath();
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
                                                z2 = false;
                                            } else {
                                                String name7 = file.getName();
                                                Intrinsics.checkNotNullExpressionValue(name7, "getName(...)");
                                                z2 = false;
                                                if (!StringsKt.startsWith$default(name7, ".", false, 2, (Object) null)) {
                                                    String name8 = parentFile2.getName();
                                                    Intrinsics.checkNotNullExpressionValue(name8, "getName(...)");
                                                    if (!StringsKt.startsWith$default(name8, ".", false, 2, (Object) null)) {
                                                        z3 = false;
                                                        arrayList.add(file);
                                                        if (z3) {
                                                            arrayList2.add(file);
                                                        }
                                                        if (z) {
                                                            String absolutePath = parentFile2.getAbsolutePath();
                                                            Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                                                            Object obj = linkedHashMap.get(absolutePath);
                                                            if (obj == null) {
                                                                obj = (List) new ArrayList();
                                                                linkedHashMap.put(absolutePath, obj);
                                                            }
                                                            ((List) obj).add(file);
                                                        } else {
                                                            arrayList3.add(file);
                                                        }
                                                    }
                                                }
                                            }
                                            z3 = true;
                                            arrayList.add(file);
                                            if (z3) {
                                            }
                                            if (z) {
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        z = true;
                        if (file.isHidden()) {
                        }
                        z3 = true;
                        arrayList.add(file);
                        if (z3) {
                        }
                        if (z) {
                        }
                    }
                }
                i = length;
                z = true;
                if (file.isHidden()) {
                }
                z3 = true;
                arrayList.add(file);
                if (z3) {
                }
                if (z) {
                }
            }
            i2++;
            strArr = videoPaths;
            z4 = z2;
        }
        ArrayList arrayList4 = new ArrayList();
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                long lastModified = ((File) next).lastModified();
                do {
                    Object next5 = it.next();
                    long lastModified2 = ((File) next5).lastModified();
                    if (lastModified < lastModified2) {
                        next = next5;
                        lastModified = lastModified2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        File file2 = (File) next;
        if (file2 != null) {
            arrayList4.add(new AlbumModel("All Videos", arrayList.size(), file2, null, null, 24, null));
        }
        if (!arrayList2.isEmpty()) {
            ArrayList arrayList5 = arrayList2;
            Iterator it2 = arrayList5.iterator();
            if (it2.hasNext()) {
                next4 = it2.next();
                if (it2.hasNext()) {
                    long lastModified3 = ((File) next4).lastModified();
                    do {
                        Object next6 = it2.next();
                        long lastModified4 = ((File) next6).lastModified();
                        if (lastModified3 < lastModified4) {
                            next4 = next6;
                            lastModified3 = lastModified4;
                        }
                    } while (it2.hasNext());
                }
            } else {
                next4 = null;
            }
            File file3 = (File) next4;
            if (file3 != null) {
                int size = arrayList2.size();
                ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList5, 10));
                Iterator it3 = arrayList5.iterator();
                while (it3.hasNext()) {
                    arrayList6.add(((File) it3.next()).getAbsolutePath());
                }
                arrayList4.add(new AlbumModel("Hidden Videos", size, file3, arrayList6, null, 16, null));
            }
        }
        ArrayList arrayList7 = arrayList3;
        Iterator it4 = arrayList7.iterator();
        if (it4.hasNext()) {
            next2 = it4.next();
            if (it4.hasNext()) {
                long lastModified5 = ((File) next2).lastModified();
                do {
                    Object next7 = it4.next();
                    long lastModified6 = ((File) next7).lastModified();
                    if (lastModified5 < lastModified6) {
                        next2 = next7;
                        lastModified5 = lastModified6;
                    }
                } while (it4.hasNext());
            }
        } else {
            next2 = null;
        }
        File file4 = (File) next2;
        if (file4 != null) {
            int size2 = arrayList3.size();
            ArrayList arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList7, 10));
            Iterator it5 = arrayList7.iterator();
            while (it5.hasNext()) {
                arrayList8.add(((File) it5.next()).getAbsolutePath());
            }
            arrayList4.add(new AlbumModel("Deleted Videos", size2, file4, arrayList8, null, 16, null));
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            String name9 = new File(str).getName();
            Iterator it6 = list.iterator();
            if (it6.hasNext()) {
                next3 = it6.next();
                if (it6.hasNext()) {
                    long lastModified7 = ((File) next3).lastModified();
                    do {
                        Object next8 = it6.next();
                        long lastModified8 = ((File) next8).lastModified();
                        if (lastModified7 < lastModified8) {
                            next3 = next8;
                            lastModified7 = lastModified8;
                        }
                    } while (it6.hasNext());
                }
            } else {
                next3 = null;
            }
            File file5 = (File) next3;
            if (file5 != null) {
                Intrinsics.checkNotNull(name9);
                arrayList4.add(new AlbumModel(name9, list.size(), file5, null, null, 24, null));
            }
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
        ((LinearLayout) inflate.findViewById(R.id.iv_cancel_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.VideoAlbumActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoAlbumActivity.showBackConfirmationDialog$lambda$15(BottomSheetDialog.this, view);
            }
        });
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.VideoAlbumActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoAlbumActivity.showBackConfirmationDialog$lambda$17(VideoAlbumActivity.this, bottomSheetDialog, view);
            }
        });
        bottomSheetDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showBackConfirmationDialog$lambda$15(BottomSheetDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showBackConfirmationDialog$lambda$17(final VideoAlbumActivity this$0, final BottomSheetDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        AdsClass.showInterstitial(this$0, new AdsClass.onListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.VideoAlbumActivity$$ExternalSyntheticLambda3
            @Override // com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass.onListener
            public final void click() {
                VideoAlbumActivity.showBackConfirmationDialog$lambda$17$lambda$16(BottomSheetDialog.this, this$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showBackConfirmationDialog$lambda$17$lambda$16(BottomSheetDialog dialog, VideoAlbumActivity this$0) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialog.dismiss();
        this$0.finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.videoRecoverBinding = null;
    }
}
