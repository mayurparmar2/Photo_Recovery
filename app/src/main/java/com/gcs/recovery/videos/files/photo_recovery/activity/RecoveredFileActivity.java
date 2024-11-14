package com.gcs.recovery.videos.files.photo_recovery.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.gcs.recovery.videos.files.photo_recovery.NonSwipeableViewPager;
import com.demo.example.R;
import com.gcs.recovery.videos.files.photo_recovery.adapter.RecoverFilesPagerAdapter;
import com.gcs.recovery.videos.files.photo_recovery.adapter.RecoveredAudiosAdapter;
import com.gcs.recovery.videos.files.photo_recovery.adapter.RecoveredDocsAdapter;
import com.gcs.recovery.videos.files.photo_recovery.adapter.RecoveredPhotosAdapter;
import com.gcs.recovery.videos.files.photo_recovery.adapter.RecoveredVideosAdapter;
import com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass;
import com.demo.example.databinding.ActivityRecoveredFileBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.tabs.TabLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RecoveredFileActivity.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\nH\u0016J\u0012\u0010\u0010\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010\u0013\u001a\u00020\nH\u0014J\b\u0010\u0014\u001a\u00020\nH\u0002J\b\u0010\u0015\u001a\u00020\nH\u0002J\b\u0010\u0016\u001a\u00020\nH\u0002J\b\u0010\u0017\u001a\u00020\nH\u0002J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/activity/RecoveredFileActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapter", "Lcom/gcs/recovery/videos/files/photo_recovery/adapter/RecoverFilesPagerAdapter;", "allItemsSelected", "", "recoverFileBinding", "Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ActivityRecoveredFileBinding;", "deselectAllItems", "", "getRecyclerViewForCurrentTab", "Landroidx/recyclerview/widget/RecyclerView;", "fileType", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "selectAllItems", "shareSelectedItems", "showDeleteConfirmationDialog", "toggleSelectAllIcon", "updateSelectionUI", "selectedCount", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RecoveredFileActivity extends AppCompatActivity {
    private RecoverFilesPagerAdapter adapter;
    private boolean allItemsSelected;
    private ActivityRecoveredFileBinding recoverFileBinding;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRecoveredFileBinding inflate = ActivityRecoveredFileBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.recoverFileBinding = inflate;
        ActivityRecoveredFileBinding activityRecoveredFileBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recoverFileBinding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        this.adapter = new RecoverFilesPagerAdapter(this);
        ActivityRecoveredFileBinding activityRecoveredFileBinding2 = this.recoverFileBinding;
        if (activityRecoveredFileBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recoverFileBinding");
            activityRecoveredFileBinding2 = null;
        }
        NonSwipeableViewPager nonSwipeableViewPager = activityRecoveredFileBinding2.viewPager;
        RecoverFilesPagerAdapter recoverFilesPagerAdapter = this.adapter;
        if (recoverFilesPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            recoverFilesPagerAdapter = null;
        }
        nonSwipeableViewPager.setAdapter(recoverFilesPagerAdapter);
        ActivityRecoveredFileBinding activityRecoveredFileBinding3 = this.recoverFileBinding;
        if (activityRecoveredFileBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recoverFileBinding");
            activityRecoveredFileBinding3 = null;
        }
        TabLayout tabLayout = activityRecoveredFileBinding3.tabLayout;
        ActivityRecoveredFileBinding activityRecoveredFileBinding4 = this.recoverFileBinding;
        if (activityRecoveredFileBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recoverFileBinding");
            activityRecoveredFileBinding4 = null;
        }
        tabLayout.setupWithViewPager(activityRecoveredFileBinding4.viewPager);
        AdsClass adsClass = new AdsClass();
        ActivityRecoveredFileBinding activityRecoveredFileBinding5 = this.recoverFileBinding;
        if (activityRecoveredFileBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recoverFileBinding");
            activityRecoveredFileBinding5 = null;
        }
        adsClass.refreshAd(activityRecoveredFileBinding5.frameLayout, this, 2);
        ActivityRecoveredFileBinding activityRecoveredFileBinding6 = this.recoverFileBinding;
        if (activityRecoveredFileBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recoverFileBinding");
            activityRecoveredFileBinding6 = null;
        }
        activityRecoveredFileBinding6.icBack.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.RecoveredFileActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecoveredFileActivity.onCreate$lambda$0(RecoveredFileActivity.this, view);
            }
        });
        ActivityRecoveredFileBinding activityRecoveredFileBinding7 = this.recoverFileBinding;
        if (activityRecoveredFileBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recoverFileBinding");
            activityRecoveredFileBinding7 = null;
        }
        activityRecoveredFileBinding7.icBackBtn.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.RecoveredFileActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecoveredFileActivity.onCreate$lambda$1(RecoveredFileActivity.this, view);
            }
        });
        ActivityRecoveredFileBinding activityRecoveredFileBinding8 = this.recoverFileBinding;
        if (activityRecoveredFileBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recoverFileBinding");
            activityRecoveredFileBinding8 = null;
        }
        activityRecoveredFileBinding8.icSelectAll.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.RecoveredFileActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecoveredFileActivity.onCreate$lambda$2(RecoveredFileActivity.this, view);
            }
        });
        ActivityRecoveredFileBinding activityRecoveredFileBinding9 = this.recoverFileBinding;
        if (activityRecoveredFileBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recoverFileBinding");
            activityRecoveredFileBinding9 = null;
        }
        activityRecoveredFileBinding9.icShare.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.RecoveredFileActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecoveredFileActivity.onCreate$lambda$3(RecoveredFileActivity.this, view);
            }
        });
        ActivityRecoveredFileBinding activityRecoveredFileBinding10 = this.recoverFileBinding;
        if (activityRecoveredFileBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recoverFileBinding");
        } else {
            activityRecoveredFileBinding = activityRecoveredFileBinding10;
        }
        activityRecoveredFileBinding.icDelete.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.RecoveredFileActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecoveredFileActivity.onCreate$lambda$4(RecoveredFileActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(RecoveredFileActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(RecoveredFileActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(RecoveredFileActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.allItemsSelected) {
            this$0.deselectAllItems();
        } else {
            this$0.selectAllItems();
        }
        this$0.toggleSelectAllIcon();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(RecoveredFileActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.shareSelectedItems();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$4(RecoveredFileActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showDeleteConfirmationDialog();
    }

    public final void updateSelectionUI(int selectedCount) {
        ActivityRecoveredFileBinding activityRecoveredFileBinding = null;
        if (selectedCount > 0) {
            ActivityRecoveredFileBinding activityRecoveredFileBinding2 = this.recoverFileBinding;
            if (activityRecoveredFileBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recoverFileBinding");
                activityRecoveredFileBinding2 = null;
            }
            activityRecoveredFileBinding2.headerLayout.setVisibility(View.GONE);
            ActivityRecoveredFileBinding activityRecoveredFileBinding3 = this.recoverFileBinding;
            if (activityRecoveredFileBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recoverFileBinding");
                activityRecoveredFileBinding3 = null;
            }
            activityRecoveredFileBinding3.tabLayout.setVisibility(View.GONE);
            ActivityRecoveredFileBinding activityRecoveredFileBinding4 = this.recoverFileBinding;
            if (activityRecoveredFileBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recoverFileBinding");
                activityRecoveredFileBinding4 = null;
            }
            activityRecoveredFileBinding4.llSelection.setVisibility(View.VISIBLE);
            ActivityRecoveredFileBinding activityRecoveredFileBinding5 = this.recoverFileBinding;
            if (activityRecoveredFileBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recoverFileBinding");
                activityRecoveredFileBinding5 = null;
            }
            activityRecoveredFileBinding5.selectionLayout.setVisibility(View.VISIBLE);
            ActivityRecoveredFileBinding activityRecoveredFileBinding6 = this.recoverFileBinding;
            if (activityRecoveredFileBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recoverFileBinding");
                activityRecoveredFileBinding6 = null;
            }
            activityRecoveredFileBinding6.selectedCount.setText(selectedCount + " Selected");
            ActivityRecoveredFileBinding activityRecoveredFileBinding7 = this.recoverFileBinding;
            if (activityRecoveredFileBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recoverFileBinding");
                activityRecoveredFileBinding7 = null;
            }
            activityRecoveredFileBinding7.viewPager.setSwipeEnabled(false);
        } else {
            ActivityRecoveredFileBinding activityRecoveredFileBinding8 = this.recoverFileBinding;
            if (activityRecoveredFileBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recoverFileBinding");
                activityRecoveredFileBinding8 = null;
            }
            activityRecoveredFileBinding8.headerLayout.setVisibility(View.VISIBLE);
            ActivityRecoveredFileBinding activityRecoveredFileBinding9 = this.recoverFileBinding;
            if (activityRecoveredFileBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recoverFileBinding");
                activityRecoveredFileBinding9 = null;
            }
            activityRecoveredFileBinding9.tabLayout.setVisibility(View.VISIBLE);
            ActivityRecoveredFileBinding activityRecoveredFileBinding10 = this.recoverFileBinding;
            if (activityRecoveredFileBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recoverFileBinding");
                activityRecoveredFileBinding10 = null;
            }
            activityRecoveredFileBinding10.selectionLayout.setVisibility(View.GONE);
            ActivityRecoveredFileBinding activityRecoveredFileBinding11 = this.recoverFileBinding;
            if (activityRecoveredFileBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recoverFileBinding");
                activityRecoveredFileBinding11 = null;
            }
            activityRecoveredFileBinding11.llSelection.setVisibility(View.GONE);
            ActivityRecoveredFileBinding activityRecoveredFileBinding12 = this.recoverFileBinding;
            if (activityRecoveredFileBinding12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recoverFileBinding");
                activityRecoveredFileBinding12 = null;
            }
            activityRecoveredFileBinding12.viewPager.setSwipeEnabled(true);
        }
        RecoverFilesPagerAdapter recoverFilesPagerAdapter = this.adapter;
        if (recoverFilesPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            recoverFilesPagerAdapter = null;
        }
        RecoverFilesPagerAdapter recoverFilesPagerAdapter2 = this.adapter;
        if (recoverFilesPagerAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            recoverFilesPagerAdapter2 = null;
        }
        ActivityRecoveredFileBinding activityRecoveredFileBinding13 = this.recoverFileBinding;
        if (activityRecoveredFileBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recoverFileBinding");
        } else {
            activityRecoveredFileBinding = activityRecoveredFileBinding13;
        }
        this.allItemsSelected = selectedCount == recoverFilesPagerAdapter.getFilesForType(recoverFilesPagerAdapter2.getPageTitle(activityRecoveredFileBinding.viewPager.getCurrentItem()).toString()).size();
        toggleSelectAllIcon();
    }

    private final void selectAllItems() {
        ActivityRecoveredFileBinding activityRecoveredFileBinding = this.recoverFileBinding;
        RecoverFilesPagerAdapter recoverFilesPagerAdapter = null;
        if (activityRecoveredFileBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recoverFileBinding");
            activityRecoveredFileBinding = null;
        }
        int currentItem = activityRecoveredFileBinding.viewPager.getCurrentItem();
        RecoverFilesPagerAdapter recoverFilesPagerAdapter2 = this.adapter;
        if (recoverFilesPagerAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            recoverFilesPagerAdapter2 = null;
        }
        String obj = recoverFilesPagerAdapter2.getPageTitle(currentItem).toString();
        RecyclerView recyclerViewForCurrentTab = getRecyclerViewForCurrentTab(obj);
        RecyclerView.Adapter adapter = recyclerViewForCurrentTab != null ? recyclerViewForCurrentTab.getAdapter() : null;
        if (adapter instanceof RecoveredAudiosAdapter) {
            ((RecoveredAudiosAdapter) adapter).selectAll();
        } else if (adapter instanceof RecoveredVideosAdapter) {
            ((RecoveredVideosAdapter) adapter).selectAll();
        } else if (adapter instanceof RecoveredPhotosAdapter) {
            ((RecoveredPhotosAdapter) adapter).selectAll();
        } else if (adapter instanceof RecoveredDocsAdapter) {
            ((RecoveredDocsAdapter) adapter).selectAll();
        }
        RecoverFilesPagerAdapter recoverFilesPagerAdapter3 = this.adapter;
        if (recoverFilesPagerAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            recoverFilesPagerAdapter = recoverFilesPagerAdapter3;
        }
        List<File> list = recoverFilesPagerAdapter.getSelectedItems().get(obj);
        updateSelectionUI(list != null ? list.size() : 0);
    }

    private final void deselectAllItems() {
        ActivityRecoveredFileBinding activityRecoveredFileBinding = this.recoverFileBinding;
        if (activityRecoveredFileBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recoverFileBinding");
            activityRecoveredFileBinding = null;
        }
        int currentItem = activityRecoveredFileBinding.viewPager.getCurrentItem();
        RecoverFilesPagerAdapter recoverFilesPagerAdapter = this.adapter;
        if (recoverFilesPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            recoverFilesPagerAdapter = null;
        }
        RecyclerView recyclerViewForCurrentTab = getRecyclerViewForCurrentTab(recoverFilesPagerAdapter.getPageTitle(currentItem).toString());
        RecyclerView.Adapter adapter = recyclerViewForCurrentTab != null ? recyclerViewForCurrentTab.getAdapter() : null;
        if (adapter instanceof RecoveredAudiosAdapter) {
            ((RecoveredAudiosAdapter) adapter).deselectAll();
        } else if (adapter instanceof RecoveredVideosAdapter) {
            ((RecoveredVideosAdapter) adapter).deselectAll();
        } else if (adapter instanceof RecoveredPhotosAdapter) {
            ((RecoveredPhotosAdapter) adapter).deselectAll();
        } else if (adapter instanceof RecoveredDocsAdapter) {
            ((RecoveredDocsAdapter) adapter).deselectAll();
        }
        updateSelectionUI(0);
    }

    private final RecyclerView getRecyclerViewForCurrentTab(String fileType) {
        RecoverFilesPagerAdapter recoverFilesPagerAdapter = this.adapter;
        if (recoverFilesPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            recoverFilesPagerAdapter = null;
        }
        ActivityRecoveredFileBinding activityRecoveredFileBinding = this.recoverFileBinding;
        if (activityRecoveredFileBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recoverFileBinding");
            activityRecoveredFileBinding = null;
        }
        NonSwipeableViewPager viewPager = activityRecoveredFileBinding.viewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager, "viewPager");
        NonSwipeableViewPager nonSwipeableViewPager = viewPager;
        ActivityRecoveredFileBinding activityRecoveredFileBinding2 = this.recoverFileBinding;
        if (activityRecoveredFileBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recoverFileBinding");
            activityRecoveredFileBinding2 = null;
        }
        Object instantiateItem = recoverFilesPagerAdapter.instantiateItem((ViewGroup) nonSwipeableViewPager, activityRecoveredFileBinding2.viewPager.getCurrentItem());
        Intrinsics.checkNotNull(instantiateItem, "null cannot be cast to non-null type android.view.View");
        View findViewWithTag = ((View) instantiateItem).findViewWithTag("recyclerView_" + fileType);
        if (findViewWithTag instanceof RecyclerView) {
            return (RecyclerView) findViewWithTag;
        }
        return null;
    }

    private final void shareSelectedItems() {
        RecoverFilesPagerAdapter recoverFilesPagerAdapter = this.adapter;
        if (recoverFilesPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            recoverFilesPagerAdapter = null;
        }
        List<File> allSelectedFiles = recoverFilesPagerAdapter.getAllSelectedFiles();
        if (!allSelectedFiles.isEmpty()) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND_MULTIPLE");
            intent.setType("*/*");
            List<File> list = allSelectedFiles;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(FileProvider.getUriForFile(this, getPackageName() + ".provider", (File) it.next()));
            }
            intent.putParcelableArrayListExtra("android.intent.extra.STREAM", new ArrayList<>(arrayList));
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            startActivity(Intent.createChooser(intent, "Share files via"));
        }
    }

    private final void showDeleteConfirmationDialog() {
        RecoveredFileActivity recoveredFileActivity = this;
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(recoveredFileActivity);
        View inflate = LayoutInflater.from(recoveredFileActivity).inflate(R.layout.dialog_delete_alert, (ViewGroup) null);
        bottomSheetDialog.setContentView(inflate);
        View findViewById = inflate.findViewById(R.id.iv_yes_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        View findViewById2 = inflate.findViewById(R.id.iv_no_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        ((LinearLayout) findViewById).setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.RecoveredFileActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecoveredFileActivity.showDeleteConfirmationDialog$lambda$8(RecoveredFileActivity.this, bottomSheetDialog, view);
            }
        });
        ((LinearLayout) findViewById2).setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.RecoveredFileActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecoveredFileActivity.showDeleteConfirmationDialog$lambda$9(BottomSheetDialog.this, view);
            }
        });
        bottomSheetDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDeleteConfirmationDialog$lambda$8(RecoveredFileActivity this$0, BottomSheetDialog bottomSheetDialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bottomSheetDialog, "$bottomSheetDialog");
        RecoverFilesPagerAdapter recoverFilesPagerAdapter = this$0.adapter;
        RecoverFilesPagerAdapter recoverFilesPagerAdapter2 = null;
        if (recoverFilesPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            recoverFilesPagerAdapter = null;
        }
        List<File> allSelectedFiles = recoverFilesPagerAdapter.getAllSelectedFiles();
        if (!allSelectedFiles.isEmpty()) {
            Iterator<T> it = allSelectedFiles.iterator();
            while (it.hasNext()) {
                ((File) it.next()).delete();
            }
            RecoverFilesPagerAdapter recoverFilesPagerAdapter3 = this$0.adapter;
            if (recoverFilesPagerAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                recoverFilesPagerAdapter3 = null;
            }
            recoverFilesPagerAdapter3.clearSelectedItems();
            RecoverFilesPagerAdapter recoverFilesPagerAdapter4 = this$0.adapter;
            if (recoverFilesPagerAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                recoverFilesPagerAdapter4 = null;
            }
            recoverFilesPagerAdapter4.notifyDataSetChanged();
            RecoverFilesPagerAdapter recoverFilesPagerAdapter5 = this$0.adapter;
            if (recoverFilesPagerAdapter5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                recoverFilesPagerAdapter2 = recoverFilesPagerAdapter5;
            }
            recoverFilesPagerAdapter2.refreshAllTabs();
            this$0.updateSelectionUI(0);
        }
        bottomSheetDialog.dismiss();
        this$0.deselectAllItems();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDeleteConfirmationDialog$lambda$9(BottomSheetDialog bottomSheetDialog, View view) {
        Intrinsics.checkNotNullParameter(bottomSheetDialog, "$bottomSheetDialog");
        bottomSheetDialog.dismiss();
    }

    private final void toggleSelectAllIcon() {
        ActivityRecoveredFileBinding activityRecoveredFileBinding = null;
        if (this.allItemsSelected) {
            ActivityRecoveredFileBinding activityRecoveredFileBinding2 = this.recoverFileBinding;
            if (activityRecoveredFileBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recoverFileBinding");
            } else {
                activityRecoveredFileBinding = activityRecoveredFileBinding2;
            }
            activityRecoveredFileBinding.icSelectAll.setImageResource(R.drawable.ic_check);
            return;
        }
        ActivityRecoveredFileBinding activityRecoveredFileBinding3 = this.recoverFileBinding;
        if (activityRecoveredFileBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recoverFileBinding");
        } else {
            activityRecoveredFileBinding = activityRecoveredFileBinding3;
        }
        activityRecoveredFileBinding.icSelectAll.setImageResource(R.drawable.ic_dslct);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        RecoverFilesPagerAdapter recoverFilesPagerAdapter = this.adapter;
        if (recoverFilesPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            recoverFilesPagerAdapter = null;
        }
        if (recoverFilesPagerAdapter.getAllSelectedFiles().size() > 0) {
            deselectAllItems();
        } else {
            AdsClass.showInterstitial(this, new AdsClass.onListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.RecoveredFileActivity$$ExternalSyntheticLambda5
                @Override // com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass.onListener
                public final void click() {
                    RecoveredFileActivity.onBackPressed$lambda$10(RecoveredFileActivity.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBackPressed$lambda$10(RecoveredFileActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        super.onBackPressed();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        RecoverFilesPagerAdapter recoverFilesPagerAdapter = this.adapter;
        if (recoverFilesPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            recoverFilesPagerAdapter = null;
        }
        recoverFilesPagerAdapter.clearSelectedItems();
    }
}
