package com.gcs.recovery.videos.files.photo_recovery.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.demo.example.R;
import com.gcs.recovery.videos.files.photo_recovery.adapter.DuplicateFileAdapter;
import com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass;
import com.demo.example.databinding.ActivityDuplicateFileBinding;
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

/* compiled from: DuplicateFileActivity.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0016J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\bH\u0002J\b\u0010\u000f\u001a\u00020\bH\u0002J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/activity/DuplicateFileActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "dFBinding", "Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ActivityDuplicateFileBinding;", "duplicateFileAdapter", "Lcom/gcs/recovery/videos/files/photo_recovery/adapter/DuplicateFileAdapter;", "deleteSelectedFiles", "", "loadDuplicateFiles", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setupListeners", "setupRecyclerView", "updateSelectAllButtonUI", "isAllSelected", "", "updateSelectedFilesSize", "size", "", "updateSelectionUI", "isSelectionMode", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DuplicateFileActivity extends AppCompatActivity {
    private ActivityDuplicateFileBinding dFBinding;
    private DuplicateFileAdapter duplicateFileAdapter;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDuplicateFileBinding inflate = ActivityDuplicateFileBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.dFBinding = inflate;
        ActivityDuplicateFileBinding activityDuplicateFileBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dFBinding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        AdsClass adsClass = new AdsClass();
        ActivityDuplicateFileBinding activityDuplicateFileBinding2 = this.dFBinding;
        if (activityDuplicateFileBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dFBinding");
        } else {
            activityDuplicateFileBinding = activityDuplicateFileBinding2;
        }
        adsClass.refreshAd(activityDuplicateFileBinding.frameLayout, this, 2);
        setupRecyclerView();
        loadDuplicateFiles();
        setupListeners();
    }

    private final void setupRecyclerView() {
        this.duplicateFileAdapter = new DuplicateFileAdapter(new Function2<Long, Boolean, Unit>() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DuplicateFileActivity$setupRecyclerView$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Long l, Boolean bool) {
                invoke(l.longValue(), bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j, boolean z) {
                DuplicateFileAdapter duplicateFileAdapter;
                DuplicateFileActivity.this.updateSelectedFilesSize(j);
                DuplicateFileActivity.this.updateSelectionUI(z);
                DuplicateFileActivity duplicateFileActivity = DuplicateFileActivity.this;
                duplicateFileAdapter = duplicateFileActivity.duplicateFileAdapter;
                if (duplicateFileAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("duplicateFileAdapter");
                    duplicateFileAdapter = null;
                }
                duplicateFileActivity.updateSelectAllButtonUI(duplicateFileAdapter.isAllFilesSelected());
            }
        });
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DuplicateFileActivity$setupRecyclerView$2
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int position) {
                DuplicateFileAdapter duplicateFileAdapter;
                DuplicateFileAdapter duplicateFileAdapter2;
                duplicateFileAdapter = DuplicateFileActivity.this.duplicateFileAdapter;
                DuplicateFileAdapter duplicateFileAdapter3 = null;
                if (duplicateFileAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("duplicateFileAdapter");
                    duplicateFileAdapter = null;
                }
                int itemViewType = duplicateFileAdapter.getItemViewType(position);
                duplicateFileAdapter2 = DuplicateFileActivity.this.duplicateFileAdapter;
                if (duplicateFileAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("duplicateFileAdapter");
                } else {
                    duplicateFileAdapter3 = duplicateFileAdapter2;
                }
                if (itemViewType == duplicateFileAdapter3.getITEM_TYPE_SET()) {
                    return gridLayoutManager.getSpanCount();
                }
                return 1;
            }
        });
        ActivityDuplicateFileBinding activityDuplicateFileBinding = this.dFBinding;
        DuplicateFileAdapter duplicateFileAdapter = null;
        if (activityDuplicateFileBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dFBinding");
            activityDuplicateFileBinding = null;
        }
        RecyclerView recyclerView = activityDuplicateFileBinding.recyclerView;
        recyclerView.setLayoutManager(gridLayoutManager);
        DuplicateFileAdapter duplicateFileAdapter2 = this.duplicateFileAdapter;
        if (duplicateFileAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("duplicateFileAdapter");
        } else {
            duplicateFileAdapter = duplicateFileAdapter2;
        }
        recyclerView.setAdapter(duplicateFileAdapter);
    }

    private final void setupListeners() {
        ActivityDuplicateFileBinding activityDuplicateFileBinding = this.dFBinding;
        ActivityDuplicateFileBinding activityDuplicateFileBinding2 = null;
        if (activityDuplicateFileBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dFBinding");
            activityDuplicateFileBinding = null;
        }
        activityDuplicateFileBinding.icBack.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DuplicateFileActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DuplicateFileActivity.setupListeners$lambda$1(DuplicateFileActivity.this, view);
            }
        });
        ActivityDuplicateFileBinding activityDuplicateFileBinding3 = this.dFBinding;
        if (activityDuplicateFileBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dFBinding");
            activityDuplicateFileBinding3 = null;
        }
        activityDuplicateFileBinding3.icDelete.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DuplicateFileActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DuplicateFileActivity.setupListeners$lambda$2(DuplicateFileActivity.this, view);
            }
        });
        ActivityDuplicateFileBinding activityDuplicateFileBinding4 = this.dFBinding;
        if (activityDuplicateFileBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dFBinding");
        } else {
            activityDuplicateFileBinding2 = activityDuplicateFileBinding4;
        }
        activityDuplicateFileBinding2.icSelectAll.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DuplicateFileActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DuplicateFileActivity.setupListeners$lambda$3(DuplicateFileActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$1(DuplicateFileActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$2(DuplicateFileActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.deleteSelectedFiles();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupListeners$lambda$3(DuplicateFileActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DuplicateFileAdapter duplicateFileAdapter = this$0.duplicateFileAdapter;
        DuplicateFileAdapter duplicateFileAdapter2 = null;
        if (duplicateFileAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("duplicateFileAdapter");
            duplicateFileAdapter = null;
        }
        if (duplicateFileAdapter.isAllFilesSelected()) {
            DuplicateFileAdapter duplicateFileAdapter3 = this$0.duplicateFileAdapter;
            if (duplicateFileAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("duplicateFileAdapter");
            } else {
                duplicateFileAdapter2 = duplicateFileAdapter3;
            }
            duplicateFileAdapter2.deselectAllFiles();
            this$0.updateSelectAllButtonUI(false);
            return;
        }
        DuplicateFileAdapter duplicateFileAdapter4 = this$0.duplicateFileAdapter;
        if (duplicateFileAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("duplicateFileAdapter");
        } else {
            duplicateFileAdapter2 = duplicateFileAdapter4;
        }
        duplicateFileAdapter2.smartSelectAllFiles();
        this$0.updateSelectAllButtonUI(true);
    }

    private final void loadDuplicateFiles() {
        ActivityDuplicateFileBinding activityDuplicateFileBinding = this.dFBinding;
        ActivityDuplicateFileBinding activityDuplicateFileBinding2 = null;
        if (activityDuplicateFileBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dFBinding");
            activityDuplicateFileBinding = null;
        }
        activityDuplicateFileBinding.loadLottie.setVisibility(View.VISIBLE);
        List<File> duplicateFiles = SharedDataHolder.INSTANCE.getDuplicateFiles();
        if (duplicateFiles == null) {
            duplicateFiles = CollectionsKt.emptyList();
        }
        if (!duplicateFiles.isEmpty()) {
            DuplicateFileAdapter duplicateFileAdapter = this.duplicateFileAdapter;
            if (duplicateFileAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("duplicateFileAdapter");
                duplicateFileAdapter = null;
            }
            duplicateFileAdapter.submitList(duplicateFiles);
            ActivityDuplicateFileBinding activityDuplicateFileBinding3 = this.dFBinding;
            if (activityDuplicateFileBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dFBinding");
            } else {
                activityDuplicateFileBinding2 = activityDuplicateFileBinding3;
            }
            activityDuplicateFileBinding2.loadLottie.setVisibility(View.GONE);
            return;
        }
        ActivityDuplicateFileBinding activityDuplicateFileBinding4 = this.dFBinding;
        if (activityDuplicateFileBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dFBinding");
            activityDuplicateFileBinding4 = null;
        }
        activityDuplicateFileBinding4.ivError.setVisibility(View.VISIBLE);
        ActivityDuplicateFileBinding activityDuplicateFileBinding5 = this.dFBinding;
        if (activityDuplicateFileBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dFBinding");
            activityDuplicateFileBinding5 = null;
        }
        activityDuplicateFileBinding5.loadLottie.setVisibility(View.GONE);
        ActivityDuplicateFileBinding activityDuplicateFileBinding6 = this.dFBinding;
        if (activityDuplicateFileBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dFBinding");
        } else {
            activityDuplicateFileBinding2 = activityDuplicateFileBinding6;
        }
        activityDuplicateFileBinding2.recyclerView.setVisibility(View.GONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSelectedFilesSize(long size) {
        ActivityDuplicateFileBinding activityDuplicateFileBinding = this.dFBinding;
        if (activityDuplicateFileBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dFBinding");
            activityDuplicateFileBinding = null;
        }
        activityDuplicateFileBinding.dfDltSize.setText(Utils.INSTANCE.formatSize(size));
    }

    private final void deleteSelectedFiles() {
        View inflate = getLayoutInflater().inflate(R.layout.dialog_delete_alert, (ViewGroup) null);
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(inflate);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.iv_no_btn);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.iv_yes_btn);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DuplicateFileActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DuplicateFileActivity.deleteSelectedFiles$lambda$4(BottomSheetDialog.this, view);
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DuplicateFileActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DuplicateFileActivity.deleteSelectedFiles$lambda$8(DuplicateFileActivity.this, bottomSheetDialog, view);
            }
        });
        bottomSheetDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteSelectedFiles$lambda$4(BottomSheetDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteSelectedFiles$lambda$8(final DuplicateFileActivity this$0, final BottomSheetDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        AdsClass.showInterstitial(this$0, new AdsClass.onListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DuplicateFileActivity$$ExternalSyntheticLambda0
            @Override // com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass.onListener
            public final void click() {
                DuplicateFileActivity.deleteSelectedFiles$lambda$8$lambda$7(DuplicateFileActivity.this, dialog);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteSelectedFiles$lambda$8$lambda$7(DuplicateFileActivity this$0, BottomSheetDialog dialog) {
        ArrayList arrayList;
        long j;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        DuplicateFileAdapter duplicateFileAdapter = this$0.duplicateFileAdapter;
        DuplicateFileAdapter duplicateFileAdapter2 = null;
        if (duplicateFileAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("duplicateFileAdapter");
            duplicateFileAdapter = null;
        }
        Set<File> selectedFiles = duplicateFileAdapter.getSelectedFiles();
        Iterator<File> it = selectedFiles.iterator();
        while (it.hasNext()) {
            it.next().delete();
        }
        Toast.makeText(this$0, selectedFiles.size() + " Files deleted successfully", Toast.LENGTH_SHORT).show();
        SharedDataHolder sharedDataHolder = SharedDataHolder.INSTANCE;
        List<File> duplicateFiles = SharedDataHolder.INSTANCE.getDuplicateFiles();
        if (duplicateFiles != null) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : duplicateFiles) {
                if (!selectedFiles.contains((File) obj)) {
                    arrayList2.add(obj);
                }
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        sharedDataHolder.setDuplicateFiles(arrayList);
        List<File> duplicateFiles2 = SharedDataHolder.INSTANCE.getDuplicateFiles();
        if (duplicateFiles2 != null) {
            Iterator<T> it2 = duplicateFiles2.iterator();
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
        DuplicateFileAdapter duplicateFileAdapter3 = this$0.duplicateFileAdapter;
        if (duplicateFileAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("duplicateFileAdapter");
        } else {
            duplicateFileAdapter2 = duplicateFileAdapter3;
        }
        List<File> duplicateFiles3 = SharedDataHolder.INSTANCE.getDuplicateFiles();
        if (duplicateFiles3 == null) {
            duplicateFiles3 = CollectionsKt.emptyList();
        }
        duplicateFileAdapter2.submitList(duplicateFiles3);
        this$0.updateSelectedFilesSize(0L);
        this$0.loadDuplicateFiles();
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSelectionUI(boolean isSelectionMode) {
        ActivityDuplicateFileBinding activityDuplicateFileBinding = this.dFBinding;
        ActivityDuplicateFileBinding activityDuplicateFileBinding2 = null;
        if (activityDuplicateFileBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dFBinding");
            activityDuplicateFileBinding = null;
        }
        activityDuplicateFileBinding.llSelection.setVisibility(isSelectionMode ? 0 : 8);
        ActivityDuplicateFileBinding activityDuplicateFileBinding3 = this.dFBinding;
        if (activityDuplicateFileBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dFBinding");
        } else {
            activityDuplicateFileBinding2 = activityDuplicateFileBinding3;
        }
        activityDuplicateFileBinding2.headerLayout.setVisibility(isSelectionMode ? View.GONE : View.VISIBLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSelectAllButtonUI(boolean isAllSelected) {
        ActivityDuplicateFileBinding activityDuplicateFileBinding = this.dFBinding;
        ActivityDuplicateFileBinding activityDuplicateFileBinding2 = null;
        if (activityDuplicateFileBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dFBinding");
            activityDuplicateFileBinding = null;
        }
        activityDuplicateFileBinding.icSelectAll.setImageResource(isAllSelected ? R.drawable.ic_check : R.drawable.ic_dslct);
        ActivityDuplicateFileBinding activityDuplicateFileBinding3 = this.dFBinding;
        if (activityDuplicateFileBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dFBinding");
        } else {
            activityDuplicateFileBinding2 = activityDuplicateFileBinding3;
        }
        activityDuplicateFileBinding2.allSelected.setText(isAllSelected ? R.string.smart_deselect : R.string.smart_select);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        DuplicateFileAdapter duplicateFileAdapter = this.duplicateFileAdapter;
        DuplicateFileAdapter duplicateFileAdapter2 = null;
        if (duplicateFileAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("duplicateFileAdapter");
            duplicateFileAdapter = null;
        }
        if (duplicateFileAdapter.getSelectionMode()) {
            DuplicateFileAdapter duplicateFileAdapter3 = this.duplicateFileAdapter;
            if (duplicateFileAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("duplicateFileAdapter");
            } else {
                duplicateFileAdapter2 = duplicateFileAdapter3;
            }
            duplicateFileAdapter2.deselectAllFiles();
            updateSelectedFilesSize(0L);
            return;
        }
        super.onBackPressed();
    }
}
