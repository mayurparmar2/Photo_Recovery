package com.gcs.recovery.videos.files.photo_recovery.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.demo.example.R;
import com.gcs.recovery.videos.files.photo_recovery.adapter.LargeFileAdapter;
import com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass;
import com.demo.example.databinding.ActivityLargeFileBinding;
import com.gcs.recovery.videos.files.photo_recovery.utils.SharedDataHolder;
import com.gcs.recovery.videos.files.photo_recovery.utils.Utils;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LargeFileActivity.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\nH\u0016J\u0012\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0010\u001a\u00020\nH\u0002J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\bH\u0002J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/activity/LargeFileActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "largeFileAdapter", "Lcom/gcs/recovery/videos/files/photo_recovery/adapter/LargeFileAdapter;", "largeFileBinding", "Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ActivityLargeFileBinding;", "selectedFilesSize", "", "deleteSelectedFiles", "", "loadLargeFiles", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setupRecyclerView", "updateSelectAllButtonUI", "isAllSelected", "", "updateSelectedFilesSize", "size", "updateSelectionUI", "isSelectionMode", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LargeFileActivity extends AppCompatActivity {
    private LargeFileAdapter largeFileAdapter;
    private ActivityLargeFileBinding largeFileBinding;
    private long selectedFilesSize;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLargeFileBinding inflate = ActivityLargeFileBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.largeFileBinding = inflate;
        ActivityLargeFileBinding activityLargeFileBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("largeFileBinding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        AdsClass adsClass = new AdsClass();
        ActivityLargeFileBinding activityLargeFileBinding2 = this.largeFileBinding;
        if (activityLargeFileBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("largeFileBinding");
            activityLargeFileBinding2 = null;
        }
        adsClass.refreshAd(activityLargeFileBinding2.frameLayout, this, 2);
        setupRecyclerView();
        loadLargeFiles();
        ActivityLargeFileBinding activityLargeFileBinding3 = this.largeFileBinding;
        if (activityLargeFileBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("largeFileBinding");
            activityLargeFileBinding3 = null;
        }
        activityLargeFileBinding3.icBack.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.LargeFileActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LargeFileActivity.onCreate$lambda$0(LargeFileActivity.this, view);
            }
        });
        ActivityLargeFileBinding activityLargeFileBinding4 = this.largeFileBinding;
        if (activityLargeFileBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("largeFileBinding");
            activityLargeFileBinding4 = null;
        }
        activityLargeFileBinding4.icDelete.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.LargeFileActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LargeFileActivity.onCreate$lambda$1(LargeFileActivity.this, view);
            }
        });
        ActivityLargeFileBinding activityLargeFileBinding5 = this.largeFileBinding;
        if (activityLargeFileBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("largeFileBinding");
        } else {
            activityLargeFileBinding = activityLargeFileBinding5;
        }
        activityLargeFileBinding.icSelectAll.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.LargeFileActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LargeFileActivity.onCreate$lambda$2(LargeFileActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(LargeFileActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(LargeFileActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.deleteSelectedFiles();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(LargeFileActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LargeFileAdapter largeFileAdapter = this$0.largeFileAdapter;
        ActivityLargeFileBinding activityLargeFileBinding = null;
        if (largeFileAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("largeFileAdapter");
            largeFileAdapter = null;
        }
        if (largeFileAdapter.isAllFilesSelected()) {
            LargeFileAdapter largeFileAdapter2 = this$0.largeFileAdapter;
            if (largeFileAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("largeFileAdapter");
                largeFileAdapter2 = null;
            }
            largeFileAdapter2.deselectAllFiles();
            ActivityLargeFileBinding activityLargeFileBinding2 = this$0.largeFileBinding;
            if (activityLargeFileBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("largeFileBinding");
                activityLargeFileBinding2 = null;
            }
            activityLargeFileBinding2.icSelectAll.setImageResource(R.drawable.ic_dslct);
            ActivityLargeFileBinding activityLargeFileBinding3 = this$0.largeFileBinding;
            if (activityLargeFileBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("largeFileBinding");
            } else {
                activityLargeFileBinding = activityLargeFileBinding3;
            }
            activityLargeFileBinding.allSelected.setText(R.string.all_select);
            return;
        }
        LargeFileAdapter largeFileAdapter3 = this$0.largeFileAdapter;
        if (largeFileAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("largeFileAdapter");
            largeFileAdapter3 = null;
        }
        largeFileAdapter3.selectAllFiles();
        ActivityLargeFileBinding activityLargeFileBinding4 = this$0.largeFileBinding;
        if (activityLargeFileBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("largeFileBinding");
            activityLargeFileBinding4 = null;
        }
        activityLargeFileBinding4.icSelectAll.setImageResource(R.drawable.ic_check);
        ActivityLargeFileBinding activityLargeFileBinding5 = this$0.largeFileBinding;
        if (activityLargeFileBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("largeFileBinding");
        } else {
            activityLargeFileBinding = activityLargeFileBinding5;
        }
        activityLargeFileBinding.allSelected.setText(R.string.all_deselect);
    }

    private final void setupRecyclerView() {
        this.largeFileAdapter = new LargeFileAdapter(new Function2<Long, Boolean, Unit>() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.LargeFileActivity$setupRecyclerView$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Long l, Boolean bool) {
                invoke(l.longValue(), bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j, boolean z) {
                LargeFileAdapter largeFileAdapter;
                LargeFileActivity.this.updateSelectedFilesSize(j);
                LargeFileActivity.this.updateSelectionUI(z);
                LargeFileActivity largeFileActivity = LargeFileActivity.this;
                largeFileAdapter = largeFileActivity.largeFileAdapter;
                if (largeFileAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("largeFileAdapter");
                    largeFileAdapter = null;
                }
                largeFileActivity.updateSelectAllButtonUI(largeFileAdapter.isAllFilesSelected());
            }
        });
        ActivityLargeFileBinding activityLargeFileBinding = this.largeFileBinding;
        LargeFileAdapter largeFileAdapter = null;
        if (activityLargeFileBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("largeFileBinding");
            activityLargeFileBinding = null;
        }
        activityLargeFileBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ActivityLargeFileBinding activityLargeFileBinding2 = this.largeFileBinding;
        if (activityLargeFileBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("largeFileBinding");
            activityLargeFileBinding2 = null;
        }
        RecyclerView recyclerView = activityLargeFileBinding2.recyclerView;
        LargeFileAdapter largeFileAdapter2 = this.largeFileAdapter;
        if (largeFileAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("largeFileAdapter");
        } else {
            largeFileAdapter = largeFileAdapter2;
        }
        recyclerView.setAdapter(largeFileAdapter);
    }

    private final void loadLargeFiles() {
        ActivityLargeFileBinding activityLargeFileBinding = this.largeFileBinding;
        ActivityLargeFileBinding activityLargeFileBinding2 = null;
        if (activityLargeFileBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("largeFileBinding");
            activityLargeFileBinding = null;
        }
        activityLargeFileBinding.loadLottie.setVisibility(View.VISIBLE);
        List<File> largeFiles = SharedDataHolder.INSTANCE.getLargeFiles();
        List<File> list = largeFiles;
        if (list == null || list.isEmpty()) {
            ActivityLargeFileBinding activityLargeFileBinding3 = this.largeFileBinding;
            if (activityLargeFileBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("largeFileBinding");
                activityLargeFileBinding3 = null;
            }
            activityLargeFileBinding3.ivError.setVisibility(View.VISIBLE);
            ActivityLargeFileBinding activityLargeFileBinding4 = this.largeFileBinding;
            if (activityLargeFileBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("largeFileBinding");
            } else {
                activityLargeFileBinding2 = activityLargeFileBinding4;
            }
            activityLargeFileBinding2.loadLottie.setVisibility(View.GONE);
            return;
        }
        LargeFileAdapter largeFileAdapter = this.largeFileAdapter;
        if (largeFileAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("largeFileAdapter");
            largeFileAdapter = null;
        }
        largeFileAdapter.submitList(largeFiles);
        ActivityLargeFileBinding activityLargeFileBinding5 = this.largeFileBinding;
        if (activityLargeFileBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("largeFileBinding");
        } else {
            activityLargeFileBinding2 = activityLargeFileBinding5;
        }
        activityLargeFileBinding2.loadLottie.setVisibility(View.GONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSelectedFilesSize(long size) {
        this.selectedFilesSize = size;
        ActivityLargeFileBinding activityLargeFileBinding = this.largeFileBinding;
        if (activityLargeFileBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("largeFileBinding");
            activityLargeFileBinding = null;
        }
        activityLargeFileBinding.largeDltSize.setText(Utils.INSTANCE.formatSize(size));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSelectionUI(boolean isSelectionMode) {
        ActivityLargeFileBinding activityLargeFileBinding = null;
        if (isSelectionMode) {
            ActivityLargeFileBinding activityLargeFileBinding2 = this.largeFileBinding;
            if (activityLargeFileBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("largeFileBinding");
                activityLargeFileBinding2 = null;
            }
            activityLargeFileBinding2.llSelection.setVisibility(View.VISIBLE);
            ActivityLargeFileBinding activityLargeFileBinding3 = this.largeFileBinding;
            if (activityLargeFileBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("largeFileBinding");
            } else {
                activityLargeFileBinding = activityLargeFileBinding3;
            }
            activityLargeFileBinding.headerLayout.setVisibility(View.GONE);
            return;
        }
        ActivityLargeFileBinding activityLargeFileBinding4 = this.largeFileBinding;
        if (activityLargeFileBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("largeFileBinding");
            activityLargeFileBinding4 = null;
        }
        activityLargeFileBinding4.llSelection.setVisibility(View.GONE);
        ActivityLargeFileBinding activityLargeFileBinding5 = this.largeFileBinding;
        if (activityLargeFileBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("largeFileBinding");
        } else {
            activityLargeFileBinding = activityLargeFileBinding5;
        }
        activityLargeFileBinding.headerLayout.setVisibility(View.VISIBLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSelectAllButtonUI(boolean isAllSelected) {
        ActivityLargeFileBinding activityLargeFileBinding = null;
        if (isAllSelected) {
            ActivityLargeFileBinding activityLargeFileBinding2 = this.largeFileBinding;
            if (activityLargeFileBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("largeFileBinding");
                activityLargeFileBinding2 = null;
            }
            activityLargeFileBinding2.icSelectAll.setImageResource(R.drawable.ic_check);
            ActivityLargeFileBinding activityLargeFileBinding3 = this.largeFileBinding;
            if (activityLargeFileBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("largeFileBinding");
            } else {
                activityLargeFileBinding = activityLargeFileBinding3;
            }
            activityLargeFileBinding.allSelected.setText(R.string.all_deselect);
            return;
        }
        ActivityLargeFileBinding activityLargeFileBinding4 = this.largeFileBinding;
        if (activityLargeFileBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("largeFileBinding");
            activityLargeFileBinding4 = null;
        }
        activityLargeFileBinding4.icSelectAll.setImageResource(R.drawable.ic_dslct);
        ActivityLargeFileBinding activityLargeFileBinding5 = this.largeFileBinding;
        if (activityLargeFileBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("largeFileBinding");
        } else {
            activityLargeFileBinding = activityLargeFileBinding5;
        }
        activityLargeFileBinding.allSelected.setText(R.string.all_select);
    }

    private final void deleteSelectedFiles() {
        View inflate = getLayoutInflater().inflate(R.layout.dialog_delete_alert, (ViewGroup) null);
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(inflate);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.iv_no_btn);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.iv_yes_btn);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.LargeFileActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LargeFileActivity.deleteSelectedFiles$lambda$3(BottomSheetDialog.this, view);
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.LargeFileActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LargeFileActivity.deleteSelectedFiles$lambda$7(LargeFileActivity.this, bottomSheetDialog, view);
            }
        });
        bottomSheetDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteSelectedFiles$lambda$3(BottomSheetDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteSelectedFiles$lambda$7(final LargeFileActivity this$0, final BottomSheetDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        AdsClass.showInterstitial(this$0, new AdsClass.onListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.LargeFileActivity$$ExternalSyntheticLambda0
            @Override // com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass.onListener
            public final void click() {
                LargeFileActivity.deleteSelectedFiles$lambda$7$lambda$6(LargeFileActivity.this, dialog);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteSelectedFiles$lambda$7$lambda$6(LargeFileActivity this$0, BottomSheetDialog dialog) {
        ArrayList arrayList;
        long j;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        LargeFileAdapter largeFileAdapter = this$0.largeFileAdapter;
        LargeFileAdapter largeFileAdapter2 = null;
        if (largeFileAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("largeFileAdapter");
            largeFileAdapter = null;
        }
        Set<File> selectedFiles = largeFileAdapter.getSelectedFiles();
        Iterator<File> it = selectedFiles.iterator();
        while (it.hasNext()) {
            it.next().delete();
        }
        Toast.makeText(this$0, selectedFiles.size() + " Files deleted successfully", Toast.LENGTH_SHORT).show();
        SharedDataHolder sharedDataHolder = SharedDataHolder.INSTANCE;
        List<File> largeFiles = SharedDataHolder.INSTANCE.getLargeFiles();
        if (largeFiles != null) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : largeFiles) {
                if (!selectedFiles.contains((File) obj)) {
                    arrayList2.add(obj);
                }
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        sharedDataHolder.setLargeFiles(arrayList);
        List<File> largeFiles2 = SharedDataHolder.INSTANCE.getLargeFiles();
        if (largeFiles2 != null) {
            Iterator<T> it2 = largeFiles2.iterator();
            j = 0;
            while (it2.hasNext()) {
                j += ((File) it2.next()).length();
            }
        } else {
            j = 0;
        }
        Intent putExtra = new Intent().putExtra("updatedSize", j);
        Intrinsics.checkNotNullExpressionValue(putExtra, "putExtra(...)");
        this$0.setResult(-1, putExtra);
        LargeFileAdapter largeFileAdapter3 = this$0.largeFileAdapter;
        if (largeFileAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("largeFileAdapter");
        } else {
            largeFileAdapter2 = largeFileAdapter3;
        }
        List<File> largeFiles3 = SharedDataHolder.INSTANCE.getLargeFiles();
        if (largeFiles3 == null) {
            largeFiles3 = CollectionsKt.emptyList();
        }
        largeFileAdapter2.submitList(largeFiles3);
        this$0.loadLargeFiles();
        this$0.updateSelectedFilesSize(0L);
        dialog.dismiss();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        LargeFileAdapter largeFileAdapter = this.largeFileAdapter;
        LargeFileAdapter largeFileAdapter2 = null;
        if (largeFileAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("largeFileAdapter");
            largeFileAdapter = null;
        }
        if (largeFileAdapter.getSelectionMode()) {
            LargeFileAdapter largeFileAdapter3 = this.largeFileAdapter;
            if (largeFileAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("largeFileAdapter");
            } else {
                largeFileAdapter2 = largeFileAdapter3;
            }
            largeFileAdapter2.deselectAllFiles();
            updateSelectedFilesSize(0L);
            return;
        }
        super.onBackPressed();
    }
}
