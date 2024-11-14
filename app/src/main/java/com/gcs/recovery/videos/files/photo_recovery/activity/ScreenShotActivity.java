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
import com.gcs.recovery.videos.files.photo_recovery.adapter.ScreenshotAdapter;
import com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass;
import com.demo.example.databinding.ActivityScreenShotBinding;
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

/* compiled from: ScreenShotActivity.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\nH\u0016J\u0012\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0010\u001a\u00020\nH\u0002J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\bH\u0002J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/activity/ScreenShotActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "screenShotBinding", "Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ActivityScreenShotBinding;", "screenshotAdapter", "Lcom/gcs/recovery/videos/files/photo_recovery/adapter/ScreenshotAdapter;", "selectedFilesSize", "", "deleteSelectedFiles", "", "loadScreenshots", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setupRecyclerView", "updateSelectAllButtonUI", "isAllSelected", "", "updateSelectedFilesSize", "size", "updateSelectionUI", "isSelectionMode", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ScreenShotActivity extends AppCompatActivity {
    private ActivityScreenShotBinding screenShotBinding;
    private ScreenshotAdapter screenshotAdapter;
    private long selectedFilesSize;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityScreenShotBinding inflate = ActivityScreenShotBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.screenShotBinding = inflate;
        ActivityScreenShotBinding activityScreenShotBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenShotBinding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        AdsClass adsClass = new AdsClass();
        ActivityScreenShotBinding activityScreenShotBinding2 = this.screenShotBinding;
        if (activityScreenShotBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenShotBinding");
            activityScreenShotBinding2 = null;
        }
        adsClass.refreshAd(activityScreenShotBinding2.frameLayout, this, 2);
        setupRecyclerView();
        loadScreenshots();
        ActivityScreenShotBinding activityScreenShotBinding3 = this.screenShotBinding;
        if (activityScreenShotBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenShotBinding");
            activityScreenShotBinding3 = null;
        }
        activityScreenShotBinding3.icBack.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ScreenShotActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ScreenShotActivity.onCreate$lambda$0(ScreenShotActivity.this, view);
            }
        });
        ActivityScreenShotBinding activityScreenShotBinding4 = this.screenShotBinding;
        if (activityScreenShotBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenShotBinding");
            activityScreenShotBinding4 = null;
        }
        activityScreenShotBinding4.icDelete.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ScreenShotActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ScreenShotActivity.onCreate$lambda$1(ScreenShotActivity.this, view);
            }
        });
        ActivityScreenShotBinding activityScreenShotBinding5 = this.screenShotBinding;
        if (activityScreenShotBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenShotBinding");
        } else {
            activityScreenShotBinding = activityScreenShotBinding5;
        }
        activityScreenShotBinding.icSelectAll.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ScreenShotActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ScreenShotActivity.onCreate$lambda$2(ScreenShotActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(ScreenShotActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(ScreenShotActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.deleteSelectedFiles();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(ScreenShotActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ScreenshotAdapter screenshotAdapter = this$0.screenshotAdapter;
        ActivityScreenShotBinding activityScreenShotBinding = null;
        if (screenshotAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenshotAdapter");
            screenshotAdapter = null;
        }
        if (screenshotAdapter.isAllFilesSelected()) {
            ScreenshotAdapter screenshotAdapter2 = this$0.screenshotAdapter;
            if (screenshotAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("screenshotAdapter");
                screenshotAdapter2 = null;
            }
            screenshotAdapter2.deselectAllFiles();
            ActivityScreenShotBinding activityScreenShotBinding2 = this$0.screenShotBinding;
            if (activityScreenShotBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("screenShotBinding");
                activityScreenShotBinding2 = null;
            }
            activityScreenShotBinding2.icSelectAll.setImageResource(R.drawable.ic_dslct);
            ActivityScreenShotBinding activityScreenShotBinding3 = this$0.screenShotBinding;
            if (activityScreenShotBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("screenShotBinding");
            } else {
                activityScreenShotBinding = activityScreenShotBinding3;
            }
            activityScreenShotBinding.allSelected.setText(R.string.all_select);
            return;
        }
        ScreenshotAdapter screenshotAdapter3 = this$0.screenshotAdapter;
        if (screenshotAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenshotAdapter");
            screenshotAdapter3 = null;
        }
        screenshotAdapter3.selectAllFiles();
        ActivityScreenShotBinding activityScreenShotBinding4 = this$0.screenShotBinding;
        if (activityScreenShotBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenShotBinding");
            activityScreenShotBinding4 = null;
        }
        activityScreenShotBinding4.icSelectAll.setImageResource(R.drawable.ic_check);
        ActivityScreenShotBinding activityScreenShotBinding5 = this$0.screenShotBinding;
        if (activityScreenShotBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenShotBinding");
        } else {
            activityScreenShotBinding = activityScreenShotBinding5;
        }
        activityScreenShotBinding.allSelected.setText(R.string.all_deselect);
    }

    private final void setupRecyclerView() {
        this.screenshotAdapter = new ScreenshotAdapter(new Function2<Long, Boolean, Unit>() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ScreenShotActivity$setupRecyclerView$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Long l, Boolean bool) {
                invoke(l.longValue(), bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j, boolean z) {
                ScreenshotAdapter screenshotAdapter;
                ScreenShotActivity.this.updateSelectedFilesSize(j);
                ScreenShotActivity.this.updateSelectionUI(z);
                ScreenShotActivity screenShotActivity = ScreenShotActivity.this;
                screenshotAdapter = screenShotActivity.screenshotAdapter;
                if (screenshotAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("screenshotAdapter");
                    screenshotAdapter = null;
                }
                screenShotActivity.updateSelectAllButtonUI(screenshotAdapter.isAllFilesSelected());
            }
        });
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ScreenShotActivity$setupRecyclerView$2
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int position) {
                ScreenshotAdapter screenshotAdapter;
                ScreenshotAdapter screenshotAdapter2;
                screenshotAdapter = ScreenShotActivity.this.screenshotAdapter;
                ScreenshotAdapter screenshotAdapter3 = null;
                if (screenshotAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("screenshotAdapter");
                    screenshotAdapter = null;
                }
                int itemViewType = screenshotAdapter.getItemViewType(position);
                screenshotAdapter2 = ScreenShotActivity.this.screenshotAdapter;
                if (screenshotAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("screenshotAdapter");
                } else {
                    screenshotAdapter3 = screenshotAdapter2;
                }
                if (itemViewType == screenshotAdapter3.getITEM_TYPE_DATE()) {
                    return gridLayoutManager.getSpanCount();
                }
                return 1;
            }
        });
        ActivityScreenShotBinding activityScreenShotBinding = this.screenShotBinding;
        ScreenshotAdapter screenshotAdapter = null;
        if (activityScreenShotBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenShotBinding");
            activityScreenShotBinding = null;
        }
        RecyclerView recyclerView = activityScreenShotBinding.recyclerView;
        recyclerView.setLayoutManager(gridLayoutManager);
        ScreenshotAdapter screenshotAdapter2 = this.screenshotAdapter;
        if (screenshotAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenshotAdapter");
        } else {
            screenshotAdapter = screenshotAdapter2;
        }
        recyclerView.setAdapter(screenshotAdapter);
    }

    private final void loadScreenshots() {
        ActivityScreenShotBinding activityScreenShotBinding = this.screenShotBinding;
        ActivityScreenShotBinding activityScreenShotBinding2 = null;
        if (activityScreenShotBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenShotBinding");
            activityScreenShotBinding = null;
        }
        activityScreenShotBinding.loadLottie.setVisibility(View.VISIBLE);
        List<File> screenshotFiles = SharedDataHolder.INSTANCE.getScreenshotFiles();
        List<File> list = screenshotFiles;
        if (list == null || list.isEmpty()) {
            ActivityScreenShotBinding activityScreenShotBinding3 = this.screenShotBinding;
            if (activityScreenShotBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("screenShotBinding");
                activityScreenShotBinding3 = null;
            }
            activityScreenShotBinding3.ivError.setVisibility(View.VISIBLE);
            ActivityScreenShotBinding activityScreenShotBinding4 = this.screenShotBinding;
            if (activityScreenShotBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("screenShotBinding");
            } else {
                activityScreenShotBinding2 = activityScreenShotBinding4;
            }
            activityScreenShotBinding2.loadLottie.setVisibility(View.GONE);
            return;
        }
        ScreenshotAdapter screenshotAdapter = this.screenshotAdapter;
        if (screenshotAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenshotAdapter");
            screenshotAdapter = null;
        }
        screenshotAdapter.submitList(screenshotFiles);
        ActivityScreenShotBinding activityScreenShotBinding5 = this.screenShotBinding;
        if (activityScreenShotBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenShotBinding");
        } else {
            activityScreenShotBinding2 = activityScreenShotBinding5;
        }
        activityScreenShotBinding2.loadLottie.setVisibility(View.GONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSelectedFilesSize(long size) {
        this.selectedFilesSize = size;
        ActivityScreenShotBinding activityScreenShotBinding = this.screenShotBinding;
        if (activityScreenShotBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenShotBinding");
            activityScreenShotBinding = null;
        }
        activityScreenShotBinding.scrDltSize.setText(Utils.INSTANCE.formatSize(size));
    }

    private final void deleteSelectedFiles() {
        View inflate = getLayoutInflater().inflate(R.layout.dialog_delete_alert, (ViewGroup) null);
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(inflate);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.iv_no_btn);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.iv_yes_btn);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ScreenShotActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ScreenShotActivity.deleteSelectedFiles$lambda$4(BottomSheetDialog.this, view);
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ScreenShotActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ScreenShotActivity.deleteSelectedFiles$lambda$8(ScreenShotActivity.this, bottomSheetDialog, view);
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
    public static final void deleteSelectedFiles$lambda$8(final ScreenShotActivity this$0, final BottomSheetDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        AdsClass.showInterstitial(this$0, new AdsClass.onListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ScreenShotActivity$$ExternalSyntheticLambda5
            @Override // com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass.onListener
            public final void click() {
                ScreenShotActivity.deleteSelectedFiles$lambda$8$lambda$7(ScreenShotActivity.this, dialog);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteSelectedFiles$lambda$8$lambda$7(ScreenShotActivity this$0, BottomSheetDialog dialog) {
        ArrayList arrayList;
        long j;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        ScreenshotAdapter screenshotAdapter = this$0.screenshotAdapter;
        ScreenshotAdapter screenshotAdapter2 = null;
        if (screenshotAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenshotAdapter");
            screenshotAdapter = null;
        }
        Set<File> selectedFiles = screenshotAdapter.getSelectedFiles();
        Iterator<File> it = selectedFiles.iterator();
        while (it.hasNext()) {
            it.next().delete();
        }
        Toast.makeText(this$0, selectedFiles.size() + " Files deleted successfully", Toast.LENGTH_SHORT).show();
        SharedDataHolder sharedDataHolder = SharedDataHolder.INSTANCE;
        List<File> screenshotFiles = SharedDataHolder.INSTANCE.getScreenshotFiles();
        if (screenshotFiles != null) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : screenshotFiles) {
                if (!selectedFiles.contains((File) obj)) {
                    arrayList2.add(obj);
                }
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        sharedDataHolder.setScreenshotFiles(arrayList);
        List<File> screenshotFiles2 = SharedDataHolder.INSTANCE.getScreenshotFiles();
        if (screenshotFiles2 != null) {
            Iterator<T> it2 = screenshotFiles2.iterator();
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
        ScreenshotAdapter screenshotAdapter3 = this$0.screenshotAdapter;
        if (screenshotAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenshotAdapter");
        } else {
            screenshotAdapter2 = screenshotAdapter3;
        }
        List<File> screenshotFiles3 = SharedDataHolder.INSTANCE.getScreenshotFiles();
        if (screenshotFiles3 == null) {
            screenshotFiles3 = CollectionsKt.emptyList();
        }
        screenshotAdapter2.submitList(screenshotFiles3);
        this$0.updateSelectedFilesSize(0L);
        this$0.loadScreenshots();
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSelectionUI(boolean isSelectionMode) {
        ActivityScreenShotBinding activityScreenShotBinding = null;
        if (isSelectionMode) {
            ActivityScreenShotBinding activityScreenShotBinding2 = this.screenShotBinding;
            if (activityScreenShotBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("screenShotBinding");
                activityScreenShotBinding2 = null;
            }
            activityScreenShotBinding2.llSelection.setVisibility(View.VISIBLE);
            ActivityScreenShotBinding activityScreenShotBinding3 = this.screenShotBinding;
            if (activityScreenShotBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("screenShotBinding");
            } else {
                activityScreenShotBinding = activityScreenShotBinding3;
            }
            activityScreenShotBinding.headerLayout.setVisibility(View.GONE);
            return;
        }
        ActivityScreenShotBinding activityScreenShotBinding4 = this.screenShotBinding;
        if (activityScreenShotBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenShotBinding");
            activityScreenShotBinding4 = null;
        }
        activityScreenShotBinding4.llSelection.setVisibility(View.GONE);
        ActivityScreenShotBinding activityScreenShotBinding5 = this.screenShotBinding;
        if (activityScreenShotBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenShotBinding");
        } else {
            activityScreenShotBinding = activityScreenShotBinding5;
        }
        activityScreenShotBinding.headerLayout.setVisibility(View.VISIBLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSelectAllButtonUI(boolean isAllSelected) {
        ActivityScreenShotBinding activityScreenShotBinding = null;
        if (isAllSelected) {
            ActivityScreenShotBinding activityScreenShotBinding2 = this.screenShotBinding;
            if (activityScreenShotBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("screenShotBinding");
                activityScreenShotBinding2 = null;
            }
            activityScreenShotBinding2.icSelectAll.setImageResource(R.drawable.ic_check);
            ActivityScreenShotBinding activityScreenShotBinding3 = this.screenShotBinding;
            if (activityScreenShotBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("screenShotBinding");
            } else {
                activityScreenShotBinding = activityScreenShotBinding3;
            }
            activityScreenShotBinding.allSelected.setText(R.string.all_deselect);
            return;
        }
        ActivityScreenShotBinding activityScreenShotBinding4 = this.screenShotBinding;
        if (activityScreenShotBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenShotBinding");
            activityScreenShotBinding4 = null;
        }
        activityScreenShotBinding4.icSelectAll.setImageResource(R.drawable.ic_dslct);
        ActivityScreenShotBinding activityScreenShotBinding5 = this.screenShotBinding;
        if (activityScreenShotBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenShotBinding");
        } else {
            activityScreenShotBinding = activityScreenShotBinding5;
        }
        activityScreenShotBinding.allSelected.setText(R.string.all_select);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        ScreenshotAdapter screenshotAdapter = this.screenshotAdapter;
        ScreenshotAdapter screenshotAdapter2 = null;
        if (screenshotAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("screenshotAdapter");
            screenshotAdapter = null;
        }
        if (screenshotAdapter.getSelectionMode()) {
            ScreenshotAdapter screenshotAdapter3 = this.screenshotAdapter;
            if (screenshotAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("screenshotAdapter");
            } else {
                screenshotAdapter2 = screenshotAdapter3;
            }
            screenshotAdapter2.deselectAllFiles();
            updateSelectedFilesSize(0L);
            return;
        }
        super.onBackPressed();
    }
}
