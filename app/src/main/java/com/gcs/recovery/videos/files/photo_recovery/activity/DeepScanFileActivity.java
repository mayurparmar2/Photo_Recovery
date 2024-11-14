package com.gcs.recovery.videos.files.photo_recovery.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.ShareInternalUtility;
import com.demo.example.R;
import com.gcs.recovery.videos.files.photo_recovery.adapter.JunkFileAdapter;
import com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass;
import com.demo.example.databinding.ActivityDeepScanFileBinding;
import com.gcs.recovery.videos.files.photo_recovery.utils.SharedDataHolder;
import com.gcs.recovery.videos.files.photo_recovery.utils.Utils;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DeepScanFileActivity.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\f0\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\b\u0010 \u001a\u00020\u001cH\u0002J\b\u0010!\u001a\u00020\u001cH\u0002J\b\u0010\"\u001a\u00020\u001cH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/activity/DeepScanFileActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "junkBinding", "Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ActivityDeepScanFileBinding;", "junkFileAdapter", "Lcom/gcs/recovery/videos/files/photo_recovery/adapter/JunkFileAdapter;", "totalSelectedSize", "", "categorizeFiles", "", "", "", "junkFilePaths", "", "determineFileCategory", ShareInternalUtility.STAGING_PARAM, "Ljava/io/File;", "isAdsJunk", "", "context", "Landroid/content/Context;", "isCacheFile", "isObsoleteFile", "isResidualJunk", "isSystemGeneratedJunk", "isTemporaryFile", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setupRecyclerView", "showBackConfirmationDialog", "showDeleteConfirmationDialog", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DeepScanFileActivity extends AppCompatActivity {
    private ActivityDeepScanFileBinding junkBinding;
    private JunkFileAdapter junkFileAdapter;
    private long totalSelectedSize;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDeepScanFileBinding inflate = ActivityDeepScanFileBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.junkBinding = inflate;
        ActivityDeepScanFileBinding activityDeepScanFileBinding = null;
        byte b = 0;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("junkBinding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        AdsClass adsClass = new AdsClass();
        ActivityDeepScanFileBinding activityDeepScanFileBinding2 = this.junkBinding;
        if (activityDeepScanFileBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("junkBinding");
            activityDeepScanFileBinding2 = null;
        }
        int i = 2;
        adsClass.refreshAd(activityDeepScanFileBinding2.frameLayout, this, 2);
        setupRecyclerView();
        List<String> junkFilesList = SharedDataHolder.INSTANCE.getJunkFilesList();
        boolean z = false;
        if (!junkFilesList.isEmpty()) {
            Map<String, List<String>> categorizeFiles = categorizeFiles(junkFilesList);
            ArrayList arrayList = new ArrayList(categorizeFiles.size());
            for (Map.Entry<String, List<String>> entry : categorizeFiles.entrySet()) {
                String key = entry.getKey();
                List<String> value = entry.getValue();
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(value, 10));
                Iterator<T> it = value.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new JunkFileAdapter.Section.FileItem((String) it.next(), z, i, b == true ? 1 : 0));
                }
                arrayList.add(new JunkFileAdapter.Section(key, CollectionsKt.toMutableList((Collection) arrayList2), false));
            }
            ArrayList arrayList3 = arrayList;
            JunkFileAdapter junkFileAdapter = this.junkFileAdapter;
            if (junkFileAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("junkFileAdapter");
                junkFileAdapter = null;
            }
            junkFileAdapter.updateJunkFiles(arrayList3);
            ActivityDeepScanFileBinding activityDeepScanFileBinding3 = this.junkBinding;
            if (activityDeepScanFileBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("junkBinding");
                activityDeepScanFileBinding3 = null;
            }
            activityDeepScanFileBinding3.recyclerView.setVisibility(View.VISIBLE);
            ActivityDeepScanFileBinding activityDeepScanFileBinding4 = this.junkBinding;
            if (activityDeepScanFileBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("junkBinding");
                activityDeepScanFileBinding4 = null;
            }
            activityDeepScanFileBinding4.ivError.setVisibility(View.GONE);
        } else {
            ActivityDeepScanFileBinding activityDeepScanFileBinding5 = this.junkBinding;
            if (activityDeepScanFileBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("junkBinding");
                activityDeepScanFileBinding5 = null;
            }
            activityDeepScanFileBinding5.recyclerView.setVisibility(View.GONE);
            ActivityDeepScanFileBinding activityDeepScanFileBinding6 = this.junkBinding;
            if (activityDeepScanFileBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("junkBinding");
                activityDeepScanFileBinding6 = null;
            }
            activityDeepScanFileBinding6.ivError.setVisibility(View.VISIBLE);
        }
        ActivityDeepScanFileBinding activityDeepScanFileBinding7 = this.junkBinding;
        if (activityDeepScanFileBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("junkBinding");
            activityDeepScanFileBinding7 = null;
        }
        activityDeepScanFileBinding7.icDelete.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DeepScanFileActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeepScanFileActivity.onCreate$lambda$2(DeepScanFileActivity.this, view);
            }
        });
        ActivityDeepScanFileBinding activityDeepScanFileBinding8 = this.junkBinding;
        if (activityDeepScanFileBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("junkBinding");
        } else {
            activityDeepScanFileBinding = activityDeepScanFileBinding8;
        }
        activityDeepScanFileBinding.icBack.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DeepScanFileActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeepScanFileActivity.onCreate$lambda$3(DeepScanFileActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(DeepScanFileActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.totalSelectedSize > 0) {
            this$0.showDeleteConfirmationDialog();
        } else {
            Toast.makeText(this$0, "No files selected for deletion", Toast.LENGTH_SHORT).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(DeepScanFileActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackPressed();
    }

    private final void setupRecyclerView() {
        DeepScanFileActivity deepScanFileActivity = this;
        this.junkFileAdapter = new JunkFileAdapter(deepScanFileActivity, CollectionsKt.emptyList(), new Function1<Long, Unit>() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DeepScanFileActivity$setupRecyclerView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                invoke(l.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j) {
                ActivityDeepScanFileBinding activityDeepScanFileBinding;
                DeepScanFileActivity.this.totalSelectedSize = j;
                activityDeepScanFileBinding = DeepScanFileActivity.this.junkBinding;
                if (activityDeepScanFileBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("junkBinding");
                    activityDeepScanFileBinding = null;
                }
                activityDeepScanFileBinding.junkDltSize.setText(Utils.INSTANCE.formatSize(j));
            }
        });
        ActivityDeepScanFileBinding activityDeepScanFileBinding = this.junkBinding;
        JunkFileAdapter junkFileAdapter = null;
        if (activityDeepScanFileBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("junkBinding");
            activityDeepScanFileBinding = null;
        }
        RecyclerView recyclerView = activityDeepScanFileBinding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(deepScanFileActivity));
        JunkFileAdapter junkFileAdapter2 = this.junkFileAdapter;
        if (junkFileAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("junkFileAdapter");
        } else {
            junkFileAdapter = junkFileAdapter2;
        }
        recyclerView.setAdapter(junkFileAdapter);
    }

    private final Map<String, List<String>> categorizeFiles(List<String> junkFilePaths) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : junkFilePaths) {
            String determineFileCategory = determineFileCategory(new File(str));
            Object obj = linkedHashMap.get(determineFileCategory);
            if (obj == null) {
                obj = (List) new ArrayList();
                linkedHashMap.put(determineFileCategory, obj);
            }
            ((List) obj).add(str);
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            List list = (List) ((Map.Entry) it.next()).getValue();
            if (list.size() > 1) {
                CollectionsKt.sortWith(list, new Comparator() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DeepScanFileActivity$categorizeFiles$lambda$8$$inlined$sortByDescending$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(Long.valueOf(new File((String) t2).length()), Long.valueOf(new File((String) t).length()));
                    }
                });
            }
        }
        return linkedHashMap;
    }

    private final String determineFileCategory(File file) {
        return isResidualJunk(file) ? "Residual Junk" : isTemporaryFile(file) ? "Temporary Files" : isSystemGeneratedJunk(file) ? "System Files" : isAdsJunk(file, this) ? "Ads Junk" : StringsKt.equals(FilesKt.getExtension(file), "apk", true) ? "APK Files" : isCacheFile(file) ? "App Cache" : isObsoleteFile(file) ? "Obsolete Files" : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }

    private final boolean isResidualJunk(File file) {
        String absolutePath;
        File parentFile = file.getParentFile();
        return (parentFile == null || (absolutePath = parentFile.getAbsolutePath()) == null || !StringsKt.contains((CharSequence) absolutePath, (CharSequence) "/Android/data", true) || file.exists()) ? false : true;
    }

    private final boolean isTemporaryFile(File file) {
        String name;
        if (StringsKt.equals(FilesKt.getExtension(file), "tmp", true)) {
            return true;
        }
        String name2 = file.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
        if (StringsKt.contains((CharSequence) name2, (CharSequence) "temp", true)) {
            return true;
        }
        File parentFile = file.getParentFile();
        return (parentFile == null || (name = parentFile.getName()) == null || !StringsKt.contains((CharSequence) name, (CharSequence) "temp", true)) ? false : true;
    }

    private final boolean isSystemGeneratedJunk(File file) {
        boolean z;
        File[] listFiles;
        File parentFile;
        String name;
        String name2 = file.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
        if (!StringsKt.contains((CharSequence) name2, (CharSequence) "system", true)) {
            String name3 = file.getName();
            Intrinsics.checkNotNullExpressionValue(name3, "getName(...)");
            if (!StringsKt.endsWith(name3, ".bak", true) && ((parentFile = file.getParentFile()) == null || (name = parentFile.getName()) == null || !StringsKt.contains((CharSequence) name, (CharSequence) "system", true))) {
                z = false;
                return z || (!file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length == 0);
            }
        }
        z = true;
        if (z) {
            return true;
        }
    }

    private final boolean isAdsJunk(File file, Context context) {
        List listOf = CollectionsKt.listOf((Object[]) new String[]{"AdCache", "ads", "ad", "advertising", "cache"});
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listOf, 10));
        Iterator it = listOf.iterator();
        while (it.hasNext()) {
            arrayList.add(new File(context.getExternalCacheDir(), (String) it.next()).getAbsolutePath());
        }
        ArrayList<String> arrayList2 = arrayList;
        if ((arrayList2 instanceof Collection) && arrayList2.isEmpty()) {
            return false;
        }
        for (String str : arrayList2) {
            String absolutePath = file.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
            Intrinsics.checkNotNull(str);
            if (StringsKt.startsWith(absolutePath, str, true)) {
                return true;
            }
        }
        return false;
    }

    private final boolean isCacheFile(File file) {
        String absolutePath;
        File parentFile = file.getParentFile();
        return (parentFile == null || (absolutePath = parentFile.getAbsolutePath()) == null || !StringsKt.contains((CharSequence) absolutePath, (CharSequence) "cache", true)) ? false : true;
    }

    private final boolean isObsoleteFile(File file) {
        if (StringsKt.equals(FilesKt.getExtension(file), "log", true) || StringsKt.equals(FilesKt.getExtension(file), "bak", true)) {
            return true;
        }
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return StringsKt.contains((CharSequence) name, (CharSequence) "obsolete", true);
    }

    private final void showDeleteConfirmationDialog() {
        View inflate = getLayoutInflater().inflate(R.layout.dialog_delete_alert, (ViewGroup) null);
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(inflate);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.iv_no_btn);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.iv_yes_btn);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DeepScanFileActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeepScanFileActivity.showDeleteConfirmationDialog$lambda$11(BottomSheetDialog.this, view);
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DeepScanFileActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeepScanFileActivity.showDeleteConfirmationDialog$lambda$13(DeepScanFileActivity.this, bottomSheetDialog, view);
            }
        });
        bottomSheetDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDeleteConfirmationDialog$lambda$11(BottomSheetDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDeleteConfirmationDialog$lambda$13(final DeepScanFileActivity this$0, final BottomSheetDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        AdsClass.showInterstitial(this$0, new AdsClass.onListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DeepScanFileActivity$$ExternalSyntheticLambda4
            @Override // com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass.onListener
            public final void click() {
                DeepScanFileActivity.showDeleteConfirmationDialog$lambda$13$lambda$12(DeepScanFileActivity.this, dialog);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDeleteConfirmationDialog$lambda$13$lambda$12(DeepScanFileActivity this$0, BottomSheetDialog dialog) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        JunkFileAdapter junkFileAdapter = this$0.junkFileAdapter;
        if (junkFileAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("junkFileAdapter");
            junkFileAdapter = null;
        }
        junkFileAdapter.deleteSelectedFiles();
        dialog.dismiss();
        Toast.makeText(this$0, "Selected files have been deleted.", Toast.LENGTH_SHORT).show();
    }

    private final void showBackConfirmationDialog() {
        View inflate = getLayoutInflater().inflate(R.layout.dialog_back_alert, (ViewGroup) null);
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(inflate);
        bottomSheetDialog.setCancelable(true);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.iv_exit_btn);
        ((LinearLayout) inflate.findViewById(R.id.iv_cancel_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DeepScanFileActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeepScanFileActivity.showBackConfirmationDialog$lambda$14(BottomSheetDialog.this, view);
            }
        });
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DeepScanFileActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeepScanFileActivity.showBackConfirmationDialog$lambda$16(DeepScanFileActivity.this, bottomSheetDialog, view);
            }
        });
        bottomSheetDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showBackConfirmationDialog$lambda$14(BottomSheetDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showBackConfirmationDialog$lambda$16(final DeepScanFileActivity this$0, final BottomSheetDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        AdsClass.showInterstitial(this$0, new AdsClass.onListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DeepScanFileActivity$$ExternalSyntheticLambda5
            @Override // com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass.onListener
            public final void click() {
                DeepScanFileActivity.showBackConfirmationDialog$lambda$16$lambda$15(BottomSheetDialog.this, this$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showBackConfirmationDialog$lambda$16$lambda$15(BottomSheetDialog dialog, DeepScanFileActivity this$0) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialog.dismiss();
        this$0.finish();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        showBackConfirmationDialog();
    }
}
