package com.gcs.recovery.videos.files.photo_recovery.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.demo.example.R;
import com.gcs.recovery.videos.files.photo_recovery.adapter.DocsAdapter;
import com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass;
import com.demo.example.databinding.ActivityDocsFilesBinding;
import com.demo.example.databinding.DialogFilterAudioLayoutBinding;
import com.gcs.recovery.videos.files.photo_recovery.model.DocsModel;
import com.gcs.recovery.videos.files.photo_recovery.utils.FileUtils;
import com.gcs.recovery.videos.files.photo_recovery.utils.SharedDataHolder;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.button.MaterialButton;

import com.onesignal.inAppMessages.internal.InAppMessageContent;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;




/* compiled from: DocsFilesActivity.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0003MNOB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\u0016\u0010 \u001a\u00020\u001e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\b\u0010\"\u001a\u00020\u001eH\u0002J\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00180\u0004H\u0002J\u0018\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010&\u001a\u0004\u0018\u00010\u0018H\u0002J$\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010)\u001a\u00020\u0015H\u0002J$\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010+\u001a\u00020\u001aH\u0002J\u0012\u0010,\u001a\u00020\u001e2\b\u0010-\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010.\u001a\u00020\u001eH\u0002J\b\u0010/\u001a\u00020\u001eH\u0016J\u0012\u00100\u001a\u00020\u001e2\b\u00101\u001a\u0004\u0018\u000102H\u0014J\b\u00103\u001a\u00020\u001eH\u0014J\u0010\u00104\u001a\u00020\u001e2\u0006\u00105\u001a\u00020\u0007H\u0002J\u0010\u00106\u001a\u00020\u001e2\u0006\u00105\u001a\u00020\u0007H\u0002J\u0010\u00107\u001a\u00020\u001e2\u0006\u00108\u001a\u00020\u0012H\u0002J\u0010\u00109\u001a\u00020\u001e2\u0006\u0010:\u001a\u00020;H\u0002J\u0010\u0010<\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020\u0005H\u0002J\b\u0010>\u001a\u00020\u001eH\u0003J\b\u0010?\u001a\u00020\u001eH\u0002J\b\u0010@\u001a\u00020\u001eH\u0002J\b\u0010A\u001a\u00020\u001eH\u0002J\b\u0010B\u001a\u00020\u001eH\u0002J\b\u0010C\u001a\u00020\u001eH\u0002J$\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010E\u001a\u00020\u001cH\u0002J\u0010\u0010F\u001a\u00020\u001e2\u0006\u00105\u001a\u00020\u0007H\u0003J\u0018\u0010G\u001a\u00020\u001e2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\u0012H\u0002J\b\u0010K\u001a\u00020\u001eH\u0002J\b\u0010L\u001a\u00020\u001eH\u0003R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/activity/DocsFilesActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "allDocsList", "", "Lcom/gcs/recovery/videos/files/photo_recovery/model/DocsModel;", "currentPage", "", "customEndDate", "Ljava/util/Date;", "customStartDate", "docsAdapter", "Lcom/gcs/recovery/videos/files/photo_recovery/adapter/DocsAdapter;", "docsFilesBinding", "Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ActivityDocsFilesBinding;", "handler", "Landroid/os/Handler;", "isLoading", "", "pageSize", "selectedDateRange", "Lcom/gcs/recovery/videos/files/photo_recovery/activity/DocsFilesActivity$DateRange;", "selectedFilterTypes", "", "", "selectedSizeRange", "Lcom/gcs/recovery/videos/files/photo_recovery/activity/DocsFilesActivity$SizeRange;", "selectedSortOrder", "Lcom/gcs/recovery/videos/files/photo_recovery/activity/DocsFilesActivity$SortOrder;", "applyCustomDateRangeFilter", "", "applyFilters", "deleteSelectedItems", FirebaseAnalytics.Param.ITEMS, "deselectAllDocs", "fetchAllDocs", "docPaths", "fetchDocsFromAlbum", "folderPath", "filterByDateRange", "docs", "dateRange", "filterBySizeRange", "sizeRange", "loadAlbumDocs", "albumPath", "loadMoreDocs", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDocClick", "position", "onDocLongClick", "onSelectionChanged", "isAllSelected", "preselectFilterButtons", "dialogBinding", "Lcom/gcs/recovery/videos/files/photo_recovery/databinding/DialogFilterAudioLayoutBinding;", "recoverItem", "doc", "recoverSelectedDocs", "resetFilters", "selectAllDocs", "setupRecyclerView", "showCustomDatePickerDialog", "showSortDialog", "sortDocs", SDKConstants.PARAM_SORT_ORDER, "toggleSelection", "updateButtonSelection", "button", "Lcom/google/android/material/button/MaterialButton;", "isSelected", "updateEmptyView", "updateSelectionUI", "DateRange", "SizeRange", "SortOrder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DocsFilesActivity extends AppCompatActivity {
    private int currentPage;
    private Date customEndDate;
    private Date customStartDate;
    private DocsAdapter docsAdapter;
    private ActivityDocsFilesBinding docsFilesBinding;
    private boolean isLoading;
    private List<DocsModel> allDocsList = CollectionsKt.emptyList();
    private final int pageSize = 10;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final List<String> selectedFilterTypes = new ArrayList();
    private SortOrder selectedSortOrder = SortOrder.NONE;
    private DateRange selectedDateRange = DateRange.NONE;
    private SizeRange selectedSizeRange = SizeRange.NONE;

    /* compiled from: DocsFilesActivity.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[SortOrder.values().length];
            try {
                iArr[SortOrder.SIZE_ASC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SortOrder.SIZE_DESC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SortOrder.TIME_ASC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SortOrder.TIME_DESC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SortOrder.NONE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[DateRange.values().length];
            try {
                iArr2[DateRange.ONE_MONTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[DateRange.SIX_MONTHS.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[DateRange.ONE_YEAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[DateRange.CUSTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[DateRange.NONE.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[SizeRange.values().length];
            try {
                iArr3[SizeRange.ZERO_TO_ONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr3[SizeRange.ONE_TO_FIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr3[SizeRange.FIVE_TO_TEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr3[SizeRange.MORE_THAN_TEN.ordinal()] = 4;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr3[SizeRange.NONE.ordinal()] = 5;
            } catch (NoSuchFieldError unused15) {
            }
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        TextView textView;
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        LinearLayout linearLayout;
        AppCompatImageView appCompatImageView3;
        AppCompatImageView appCompatImageView4;
        super.onCreate(savedInstanceState);
        ActivityDocsFilesBinding inflate = ActivityDocsFilesBinding.inflate(getLayoutInflater());
        this.docsFilesBinding = inflate;
        Intrinsics.checkNotNull(inflate);
        setContentView(inflate.getRoot());
        this.selectedSortOrder = SortOrder.NONE;
        this.selectedDateRange = DateRange.NONE;
        this.selectedSizeRange = SizeRange.NONE;
        AdsClass adsClass = new AdsClass();
        ActivityDocsFilesBinding activityDocsFilesBinding = this.docsFilesBinding;
        Intrinsics.checkNotNull(activityDocsFilesBinding);
        adsClass.refreshAd(activityDocsFilesBinding.frameLayout, this, 2);
        String stringExtra = getIntent().getStringExtra("ALBUM_TITLE");
        if (stringExtra == null) {
            stringExtra = "Documents";
        }
        ActivityDocsFilesBinding activityDocsFilesBinding2 = this.docsFilesBinding;
        TextView textView2 = activityDocsFilesBinding2 != null ? activityDocsFilesBinding2.txtTitle : null;
        if (textView2 != null) {
            textView2.setText(stringExtra);
        }
        FileUtils.INSTANCE.createAppFolders(this);
        loadAlbumDocs(getIntent().getStringExtra("ALBUM_PATH"));
        setupRecyclerView();
        updateEmptyView();
        ActivityDocsFilesBinding activityDocsFilesBinding3 = this.docsFilesBinding;
        if (activityDocsFilesBinding3 != null && (appCompatImageView4 = activityDocsFilesBinding3.icBack) != null) {
            appCompatImageView4.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DocsFilesActivity$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DocsFilesActivity.onCreate$lambda$0(DocsFilesActivity.this, view);
                }
            });
        }
        ActivityDocsFilesBinding activityDocsFilesBinding4 = this.docsFilesBinding;
        if (activityDocsFilesBinding4 != null && (appCompatImageView3 = activityDocsFilesBinding4.icMenu) != null) {
            appCompatImageView3.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DocsFilesActivity$$ExternalSyntheticLambda11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DocsFilesActivity.onCreate$lambda$1(DocsFilesActivity.this, view);
                }
            });
        }
        ActivityDocsFilesBinding activityDocsFilesBinding5 = this.docsFilesBinding;
        if (activityDocsFilesBinding5 != null && (linearLayout = activityDocsFilesBinding5.llSelection) != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DocsFilesActivity$$ExternalSyntheticLambda13
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DocsFilesActivity.onCreate$lambda$2(DocsFilesActivity.this, view);
                }
            });
        }
        ActivityDocsFilesBinding activityDocsFilesBinding6 = this.docsFilesBinding;
        if (activityDocsFilesBinding6 != null && (appCompatImageView2 = activityDocsFilesBinding6.icSelectAll) != null) {
            appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DocsFilesActivity$$ExternalSyntheticLambda14
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DocsFilesActivity.onCreate$lambda$3(DocsFilesActivity.this, view);
                }
            });
        }
        ActivityDocsFilesBinding activityDocsFilesBinding7 = this.docsFilesBinding;
        if (activityDocsFilesBinding7 != null && (appCompatImageView = activityDocsFilesBinding7.icDelete) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DocsFilesActivity$$ExternalSyntheticLambda15
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DocsFilesActivity.onCreate$lambda$4(DocsFilesActivity.this, view);
                }
            });
        }
        ActivityDocsFilesBinding activityDocsFilesBinding8 = this.docsFilesBinding;
        if (activityDocsFilesBinding8 == null || (textView = activityDocsFilesBinding8.tvRecover) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DocsFilesActivity$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DocsFilesActivity.onCreate$lambda$6(DocsFilesActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(DocsFilesActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(DocsFilesActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showSortDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(DocsFilesActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DocsAdapter docsAdapter = this$0.docsAdapter;
        if (docsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("docsAdapter");
            docsAdapter = null;
        }
        docsAdapter.getSelectedItemCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(DocsFilesActivity this$0, View view) {
        TextView textView;
        AppCompatImageView appCompatImageView;
        TextView textView2;
        AppCompatImageView appCompatImageView2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DocsAdapter docsAdapter = this$0.docsAdapter;
        DocsAdapter docsAdapter2 = null;
        if (docsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("docsAdapter");
            docsAdapter = null;
        }
        int selectedItemCount = docsAdapter.getSelectedItemCount();
        DocsAdapter docsAdapter3 = this$0.docsAdapter;
        if (docsAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("docsAdapter");
        } else {
            docsAdapter2 = docsAdapter3;
        }
        if (selectedItemCount == docsAdapter2.getItemCount()) {
            this$0.deselectAllDocs();
            ActivityDocsFilesBinding activityDocsFilesBinding = this$0.docsFilesBinding;
            if (activityDocsFilesBinding != null && (appCompatImageView2 = activityDocsFilesBinding.icSelectAll) != null) {
                appCompatImageView2.setImageResource(R.drawable.ic_dslct);
            }
            ActivityDocsFilesBinding activityDocsFilesBinding2 = this$0.docsFilesBinding;
            if (activityDocsFilesBinding2 == null || (textView2 = activityDocsFilesBinding2.allSelected) == null) {
                return;
            }
            textView2.setText(R.string.all_select);
            return;
        }
        this$0.selectAllDocs();
        ActivityDocsFilesBinding activityDocsFilesBinding3 = this$0.docsFilesBinding;
        if (activityDocsFilesBinding3 != null && (appCompatImageView = activityDocsFilesBinding3.icSelectAll) != null) {
            appCompatImageView.setImageResource(R.drawable.ic_check);
        }
        ActivityDocsFilesBinding activityDocsFilesBinding4 = this$0.docsFilesBinding;
        if (activityDocsFilesBinding4 == null || (textView = activityDocsFilesBinding4.allSelected) == null) {
            return;
        }
        textView.setText(R.string.all_deselect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$4(DocsFilesActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DocsAdapter docsAdapter = this$0.docsAdapter;
        if (docsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("docsAdapter");
            docsAdapter = null;
        }
        this$0.deleteSelectedItems(docsAdapter.getSelectedItems());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$6(final DocsFilesActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AdsClass.showInterstitial(this$0, new AdsClass.onListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DocsFilesActivity$$ExternalSyntheticLambda9
            @Override // com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass.onListener
            public final void click() {
                DocsFilesActivity.onCreate$lambda$6$lambda$5(DocsFilesActivity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$6$lambda$5(DocsFilesActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.recoverSelectedDocs();
    }

    private final void loadAlbumDocs(String albumPath) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DocsFilesActivity$loadAlbumDocs$1(this, albumPath, null), 3, null);
    }

    private final void recoverSelectedDocs() {
        DocsAdapter docsAdapter = this.docsAdapter;
        if (docsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("docsAdapter");
            docsAdapter = null;
        }
        final List<DocsModel> selectedItems = docsAdapter.getSelectedItems();
        if (selectedItems.isEmpty()) {
            return;
        }
        View inflate = getLayoutInflater().inflate(R.layout.dialog_recovering_layout, (ViewGroup) null);
        final ProgressBar progressBar = (ProgressBar) inflate.findViewById(R.id.progressBar);
        final TextView textView = (TextView) inflate.findViewById(R.id.recoverItem);
        TextView textView2 = (TextView) inflate.findViewById(R.id.itemTotal);
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(inflate);
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.show();
        textView2.setText(String.valueOf(selectedItems.size()));
        progressBar.setMax(selectedItems.size());
        final Ref.IntRef intRef = new Ref.IntRef();
        new Thread(new Runnable() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DocsFilesActivity$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                DocsFilesActivity.recoverSelectedDocs$lambda$9(selectedItems, this, intRef, textView, progressBar, bottomSheetDialog);
            }
        }).start();
        deselectAllDocs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void recoverSelectedDocs$lambda$9(List selectedItems, final DocsFilesActivity this$0, final Ref.IntRef recoveredItemCount, final TextView textView, final ProgressBar progressBar, final BottomSheetDialog dialog) {
        Intrinsics.checkNotNullParameter(selectedItems, "$selectedItems");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(recoveredItemCount, "$recoveredItemCount");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Iterator it = selectedItems.iterator();
        final int i = 0;
        while (it.hasNext()) {
            DocsModel docsModel = (DocsModel) it.next();
            Thread.sleep(500L);
            this$0.recoverItem(docsModel);
            recoveredItemCount.element++;
            this$0.runOnUiThread(new Runnable() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DocsFilesActivity$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    DocsFilesActivity.recoverSelectedDocs$lambda$9$lambda$7(textView, i, progressBar);
                }
            });
            i++;
        }
        this$0.runOnUiThread(new Runnable() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DocsFilesActivity$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                DocsFilesActivity.recoverSelectedDocs$lambda$9$lambda$8(BottomSheetDialog.this, this$0, recoveredItemCount);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void recoverSelectedDocs$lambda$9$lambda$7(TextView textView, int i, ProgressBar progressBar) {
        int i2 = i + 1;
        textView.setText(String.valueOf(i2));
        progressBar.setProgress(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void recoverSelectedDocs$lambda$9$lambda$8(BottomSheetDialog dialog, DocsFilesActivity this$0, Ref.IntRef recoveredItemCount) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(recoveredItemCount, "$recoveredItemCount");
        dialog.dismiss();
        Intent intent = new Intent(this$0, (Class<?>) SuccessfullyRecoverActivity.class);
        intent.putExtra("RECOVERED_ITEM_COUNT", recoveredItemCount.element);
        intent.putExtra("ITEM_TYPE", "DOCUMENT");
        this$0.startActivity(intent);
    }

    private final void recoverItem(DocsModel doc) {
        File file = new File(Environment.getExternalStorageDirectory(), "PhotoRecovery/Documents");
        if (!file.exists()) {
            file.mkdirs();
        }
        String name = doc.getFile().getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        File file2 = new File(file, (StringsKt.startsWith$default(name, ".", false, 2, (Object) null) ? StringsKt.removePrefix(FilesKt.getNameWithoutExtension(doc.getFile()), (CharSequence) ".") : FilesKt.getNameWithoutExtension(doc.getFile())) + (FilesKt.getExtension(doc.getFile()).length() == 0 ? ".pdf" : "." + FilesKt.getExtension(doc.getFile())));
        FilesKt.copyTo$default(doc.getFile(), file2, true, 0, 4, null);
        MediaScannerConnection.scanFile(this, new String[]{file2.getAbsolutePath()}, null, null);
    }

    private final void deleteSelectedItems(final List<DocsModel> items) {
        if (items.isEmpty()) {
            return;
        }
        View inflate = getLayoutInflater().inflate(R.layout.dialog_delete_alert, (ViewGroup) null);
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(inflate);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.iv_no_btn);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.iv_yes_btn);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DocsFilesActivity$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DocsFilesActivity.deleteSelectedItems$lambda$10(BottomSheetDialog.this, view);
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DocsFilesActivity$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DocsFilesActivity.deleteSelectedItems$lambda$15(items, bottomSheetDialog, this, view);
            }
        });
        bottomSheetDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteSelectedItems$lambda$10(BottomSheetDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteSelectedItems$lambda$15(List items, BottomSheetDialog dialog, DocsFilesActivity this$0, View view) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(items, "$items");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List list = items;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((DocsModel) it.next()).getFile().delete();
        }
        dialog.dismiss();
        this$0.deselectAllDocs();
        SharedDataHolder sharedDataHolder = SharedDataHolder.INSTANCE;
        List<File> docFiles = SharedDataHolder.INSTANCE.getDocFiles();
        DocsAdapter docsAdapter = null;
        if (docFiles != null) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : docFiles) {
                File file = (File) obj;
                boolean z = false;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator it2 = list.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (Intrinsics.areEqual(((DocsModel) it2.next()).getFile(), file)) {
                                z = true;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                if (!z) {
                    arrayList2.add(obj);
                }
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        sharedDataHolder.setDocFiles(arrayList);
        List<DocsModel> list2 = this$0.allDocsList;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : list2) {
            if (!items.contains((DocsModel) obj2)) {
                arrayList3.add(obj2);
            }
        }
        this$0.allDocsList = arrayList3;
        DocsAdapter docsAdapter2 = this$0.docsAdapter;
        if (docsAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("docsAdapter");
        } else {
            docsAdapter = docsAdapter2;
        }
        List<DocsModel> list3 = this$0.allDocsList;
        docsAdapter.updateDocs(list3, list3.size());
        this$0.updateSelectionUI();
        this$0.updateEmptyView();
    }

    private final void resetFilters() {
        this.selectedFilterTypes.clear();
        this.selectedSortOrder = SortOrder.NONE;
        this.selectedDateRange = DateRange.NONE;
        this.selectedSizeRange = SizeRange.NONE;
        applyFilters();
    }

    private final void showSortDialog() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        final DialogFilterAudioLayoutBinding inflate = DialogFilterAudioLayoutBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        bottomSheetDialog.setContentView(inflate.getRoot());
        preselectFilterButtons(inflate);
        final List listOf = CollectionsKt.listOf((Object[]) new MaterialButton[]{inflate.sizeAsc, inflate.sizeDesc, inflate.timeOldest, inflate.timeNewest});
        final List<MaterialButton> listOf2 = CollectionsKt.listOf((Object[]) new MaterialButton[]{inflate.allDateBy, inflate.oneMonth, inflate.sixMonth, inflate.oneYear, inflate.customDate});
        final List listOf3 = CollectionsKt.listOf((Object[]) new MaterialButton[]{inflate.allSizeBy, inflate.zeroToOne, inflate.oneToFive, inflate.fiveToTen, inflate.moreThanTen});
        Iterator it = listOf.iterator();
        while (it.hasNext()) {
            ((MaterialButton) it.next()).setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DocsFilesActivity$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DocsFilesActivity.showSortDialog$lambda$18$lambda$17(listOf, this, inflate, listOf2, listOf3, view);
                }
            });
        }
        for (final MaterialButton materialButton : listOf2) {
            materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DocsFilesActivity$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DocsFilesActivity.showSortDialog$lambda$20$lambda$19(MaterialButton.this, inflate, this, listOf2, listOf, listOf3, view);
                }
            });
        }
        Iterator it2 = listOf3.iterator();
        while (it2.hasNext()) {
            ((MaterialButton) it2.next()).setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DocsFilesActivity$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DocsFilesActivity.showSortDialog$lambda$22$lambda$21(listOf3, listOf, this, inflate, listOf2, view);
                }
            });
        }
        inflate.applyBtn.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DocsFilesActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DocsFilesActivity.showSortDialog$lambda$23(DocsFilesActivity.this, bottomSheetDialog, view);
            }
        });
        inflate.resetFilter.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DocsFilesActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DocsFilesActivity.showSortDialog$lambda$27(DocsFilesActivity.this, listOf, listOf2, listOf3, bottomSheetDialog, inflate, view);
            }
        });
        bottomSheetDialog.show();
    }

    private static final void showSortDialog$handleButtonSelection(List<? extends MaterialButton> list, DocsFilesActivity docsFilesActivity, DialogFilterAudioLayoutBinding dialogFilterAudioLayoutBinding, List<? extends MaterialButton> list2, List<? extends MaterialButton> list3, List<? extends MaterialButton> list4, MaterialButton materialButton) {
        SizeRange sizeRange;
        DateRange dateRange;
        SortOrder sortOrder;
        for (MaterialButton materialButton2 : list4) {
            docsFilesActivity.updateButtonSelection(materialButton2, Intrinsics.areEqual(materialButton2, materialButton));
        }
        if (Intrinsics.areEqual(list4, list)) {
            if (Intrinsics.areEqual(materialButton, dialogFilterAudioLayoutBinding.sizeAsc)) {
                sortOrder = SortOrder.SIZE_ASC;
            } else if (Intrinsics.areEqual(materialButton, dialogFilterAudioLayoutBinding.sizeDesc)) {
                sortOrder = SortOrder.SIZE_DESC;
            } else if (Intrinsics.areEqual(materialButton, dialogFilterAudioLayoutBinding.timeOldest)) {
                sortOrder = SortOrder.TIME_ASC;
            } else {
                sortOrder = Intrinsics.areEqual(materialButton, dialogFilterAudioLayoutBinding.timeNewest) ? SortOrder.TIME_DESC : SortOrder.TIME_DESC;
            }
            docsFilesActivity.selectedSortOrder = sortOrder;
            return;
        }
        if (Intrinsics.areEqual(list4, list2)) {
            if (Intrinsics.areEqual(materialButton, dialogFilterAudioLayoutBinding.allDateBy)) {
                dateRange = DateRange.NONE;
            } else if (Intrinsics.areEqual(materialButton, dialogFilterAudioLayoutBinding.oneMonth)) {
                dateRange = DateRange.ONE_MONTH;
            } else if (Intrinsics.areEqual(materialButton, dialogFilterAudioLayoutBinding.sixMonth)) {
                dateRange = DateRange.SIX_MONTHS;
            } else if (Intrinsics.areEqual(materialButton, dialogFilterAudioLayoutBinding.oneYear)) {
                dateRange = DateRange.ONE_YEAR;
            } else {
                dateRange = Intrinsics.areEqual(materialButton, dialogFilterAudioLayoutBinding.customDate) ? DateRange.CUSTOM : DateRange.NONE;
            }
            docsFilesActivity.selectedDateRange = dateRange;
            if (Intrinsics.areEqual(materialButton, dialogFilterAudioLayoutBinding.customDate)) {
                docsFilesActivity.showCustomDatePickerDialog();
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(list4, list3)) {
            if (Intrinsics.areEqual(materialButton, dialogFilterAudioLayoutBinding.zeroToOne)) {
                sizeRange = SizeRange.ZERO_TO_ONE;
            } else if (Intrinsics.areEqual(materialButton, dialogFilterAudioLayoutBinding.oneToFive)) {
                sizeRange = SizeRange.ONE_TO_FIVE;
            } else if (Intrinsics.areEqual(materialButton, dialogFilterAudioLayoutBinding.fiveToTen)) {
                sizeRange = SizeRange.FIVE_TO_TEN;
            } else {
                sizeRange = Intrinsics.areEqual(materialButton, dialogFilterAudioLayoutBinding.moreThanTen) ? SizeRange.MORE_THAN_TEN : SizeRange.NONE;
            }
            docsFilesActivity.selectedSizeRange = sizeRange;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSortDialog$lambda$18$lambda$17(List sortOrderButtons, DocsFilesActivity this$0, DialogFilterAudioLayoutBinding dialogFilterBinding, List dateRangeButtons, List sizeRangeButtons, View view) {
        Intrinsics.checkNotNullParameter(sortOrderButtons, "$sortOrderButtons");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialogFilterBinding, "$dialogFilterBinding");
        Intrinsics.checkNotNullParameter(dateRangeButtons, "$dateRangeButtons");
        Intrinsics.checkNotNullParameter(sizeRangeButtons, "$sizeRangeButtons");
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.google.android.material.button.MaterialButton");
        showSortDialog$handleButtonSelection(sortOrderButtons, this$0, dialogFilterBinding, dateRangeButtons, sizeRangeButtons, sortOrderButtons, (MaterialButton) view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSortDialog$lambda$20$lambda$19(MaterialButton button, DialogFilterAudioLayoutBinding dialogFilterBinding, DocsFilesActivity this$0, List dateRangeButtons, List sortOrderButtons, List sizeRangeButtons, View view) {
        Intrinsics.checkNotNullParameter(button, "$button");
        Intrinsics.checkNotNullParameter(dialogFilterBinding, "$dialogFilterBinding");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dateRangeButtons, "$dateRangeButtons");
        Intrinsics.checkNotNullParameter(sortOrderButtons, "$sortOrderButtons");
        Intrinsics.checkNotNullParameter(sizeRangeButtons, "$sizeRangeButtons");
        if (Intrinsics.areEqual(button, dialogFilterBinding.customDate)) {
            this$0.showCustomDatePickerDialog();
        } else {
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.google.android.material.button.MaterialButton");
            showSortDialog$handleButtonSelection(sortOrderButtons, this$0, dialogFilterBinding, dateRangeButtons, sizeRangeButtons, dateRangeButtons, (MaterialButton) view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSortDialog$lambda$22$lambda$21(List sizeRangeButtons, List sortOrderButtons, DocsFilesActivity this$0, DialogFilterAudioLayoutBinding dialogFilterBinding, List dateRangeButtons, View view) {
        Intrinsics.checkNotNullParameter(sizeRangeButtons, "$sizeRangeButtons");
        Intrinsics.checkNotNullParameter(sortOrderButtons, "$sortOrderButtons");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialogFilterBinding, "$dialogFilterBinding");
        Intrinsics.checkNotNullParameter(dateRangeButtons, "$dateRangeButtons");
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.google.android.material.button.MaterialButton");
        showSortDialog$handleButtonSelection(sortOrderButtons, this$0, dialogFilterBinding, dateRangeButtons, sizeRangeButtons, sizeRangeButtons, (MaterialButton) view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSortDialog$lambda$23(DocsFilesActivity this$0, BottomSheetDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        this$0.applyFilters();
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSortDialog$lambda$27(DocsFilesActivity this$0, List sortOrderButtons, List dateRangeButtons, List sizeRangeButtons, BottomSheetDialog dialog, DialogFilterAudioLayoutBinding dialogFilterBinding, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(sortOrderButtons, "$sortOrderButtons");
        Intrinsics.checkNotNullParameter(dateRangeButtons, "$dateRangeButtons");
        Intrinsics.checkNotNullParameter(sizeRangeButtons, "$sizeRangeButtons");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(dialogFilterBinding, "$dialogFilterBinding");
        this$0.resetFilters();
        Iterator it = sortOrderButtons.iterator();
        while (it.hasNext()) {
            MaterialButton materialButton = (MaterialButton) it.next();
            Intrinsics.checkNotNull(materialButton);
            this$0.updateButtonSelection(materialButton, false);
        }
        Iterator it2 = dateRangeButtons.iterator();
        while (it2.hasNext()) {
            MaterialButton materialButton2 = (MaterialButton) it2.next();
            Intrinsics.checkNotNull(materialButton2);
            this$0.updateButtonSelection(materialButton2, Intrinsics.areEqual(materialButton2, dialogFilterBinding.allDateBy));
        }
        Iterator it3 = sizeRangeButtons.iterator();
        while (it3.hasNext()) {
            MaterialButton materialButton3 = (MaterialButton) it3.next();
            Intrinsics.checkNotNull(materialButton3);
            this$0.updateButtonSelection(materialButton3, Intrinsics.areEqual(materialButton3, dialogFilterBinding.allSizeBy));
        }
        dialog.dismiss();
    }

    private final void preselectFilterButtons(DialogFilterAudioLayoutBinding dialogBinding) {
        int i = WhenMappings.$EnumSwitchMapping$0[this.selectedSortOrder.ordinal()];
        if (i == 1) {
            MaterialButton sizeAsc = dialogBinding.sizeAsc;
            Intrinsics.checkNotNullExpressionValue(sizeAsc, "sizeAsc");
            updateButtonSelection(sizeAsc, true);
        } else if (i == 2) {
            MaterialButton sizeDesc = dialogBinding.sizeDesc;
            Intrinsics.checkNotNullExpressionValue(sizeDesc, "sizeDesc");
            updateButtonSelection(sizeDesc, true);
        } else if (i == 3) {
            MaterialButton timeOldest = dialogBinding.timeOldest;
            Intrinsics.checkNotNullExpressionValue(timeOldest, "timeOldest");
            updateButtonSelection(timeOldest, true);
        } else if (i == 4) {
            MaterialButton timeNewest = dialogBinding.timeNewest;
            Intrinsics.checkNotNullExpressionValue(timeNewest, "timeNewest");
            updateButtonSelection(timeNewest, true);
        } else if (i == 5) {
            MaterialButton timeNewest2 = dialogBinding.timeNewest;
            Intrinsics.checkNotNullExpressionValue(timeNewest2, "timeNewest");
            updateButtonSelection(timeNewest2, true);
        }
        int i2 = WhenMappings.$EnumSwitchMapping$1[this.selectedDateRange.ordinal()];
        if (i2 == 1) {
            MaterialButton oneMonth = dialogBinding.oneMonth;
            Intrinsics.checkNotNullExpressionValue(oneMonth, "oneMonth");
            updateButtonSelection(oneMonth, true);
        } else if (i2 == 2) {
            MaterialButton sixMonth = dialogBinding.sixMonth;
            Intrinsics.checkNotNullExpressionValue(sixMonth, "sixMonth");
            updateButtonSelection(sixMonth, true);
        } else if (i2 == 3) {
            MaterialButton oneYear = dialogBinding.oneYear;
            Intrinsics.checkNotNullExpressionValue(oneYear, "oneYear");
            updateButtonSelection(oneYear, true);
        } else if (i2 == 4) {
            MaterialButton customDate = dialogBinding.customDate;
            Intrinsics.checkNotNullExpressionValue(customDate, "customDate");
            updateButtonSelection(customDate, true);
        } else if (i2 == 5) {
            MaterialButton allDateBy = dialogBinding.allDateBy;
            Intrinsics.checkNotNullExpressionValue(allDateBy, "allDateBy");
            updateButtonSelection(allDateBy, true);
        }
        int i3 = WhenMappings.$EnumSwitchMapping$2[this.selectedSizeRange.ordinal()];
        if (i3 == 1) {
            MaterialButton zeroToOne = dialogBinding.zeroToOne;
            Intrinsics.checkNotNullExpressionValue(zeroToOne, "zeroToOne");
            updateButtonSelection(zeroToOne, true);
            return;
        }
        if (i3 == 2) {
            MaterialButton oneToFive = dialogBinding.oneToFive;
            Intrinsics.checkNotNullExpressionValue(oneToFive, "oneToFive");
            updateButtonSelection(oneToFive, true);
            return;
        }
        if (i3 == 3) {
            MaterialButton fiveToTen = dialogBinding.fiveToTen;
            Intrinsics.checkNotNullExpressionValue(fiveToTen, "fiveToTen");
            updateButtonSelection(fiveToTen, true);
        } else if (i3 == 4) {
            MaterialButton moreThanTen = dialogBinding.moreThanTen;
            Intrinsics.checkNotNullExpressionValue(moreThanTen, "moreThanTen");
            updateButtonSelection(moreThanTen, true);
        } else {
            if (i3 != 5) {
                return;
            }
            MaterialButton allSizeBy = dialogBinding.allSizeBy;
            Intrinsics.checkNotNullExpressionValue(allSizeBy, "allSizeBy");
            updateButtonSelection(allSizeBy, true);
        }
    }

    private final void showCustomDatePickerDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(1);
        dialog.setCancelable(true);
        View inflate = getLayoutInflater().inflate(R.layout.custom_date_picker_layout, (ViewGroup) null);
        dialog.setContentView(inflate);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setLayout(-1, -2);
        }
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        final DatePicker datePicker = (DatePicker) inflate.findViewById(R.id.startDate);
        final DatePicker datePicker2 = (DatePicker) inflate.findViewById(R.id.endDate);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.iv_no_btn);
        ((LinearLayout) inflate.findViewById(R.id.btnOk)).setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DocsFilesActivity$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DocsFilesActivity.showCustomDatePickerDialog$lambda$30(datePicker, datePicker2, this, dialog, view);
            }
        });
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DocsFilesActivity$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DocsFilesActivity.showCustomDatePickerDialog$lambda$31(dialog, view);
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showCustomDatePickerDialog$lambda$30(DatePicker datePicker, DatePicker datePicker2, DocsFilesActivity this$0, Dialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        int year = datePicker.getYear();
        int month = datePicker.getMonth();
        int dayOfMonth = datePicker.getDayOfMonth();
        int year2 = datePicker2.getYear();
        int month2 = datePicker2.getMonth();
        int dayOfMonth2 = datePicker2.getDayOfMonth();
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, dayOfMonth);
        Date time = calendar.getTime();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(year2, month2, dayOfMonth2);
        Date time2 = calendar2.getTime();
        if (time.before(time2)) {
            this$0.customStartDate = time;
            this$0.customEndDate = time2;
            this$0.applyCustomDateRangeFilter();
            dialog.dismiss();
            return;
        }
        Toast.makeText(this$0, "Start date should be before End date", Toast.LENGTH_SHORT).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showCustomDatePickerDialog$lambda$31(Dialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    private final void applyCustomDateRangeFilter() {
        if (this.customStartDate == null || this.customEndDate == null) {
            return;
        }
        this.selectedDateRange = DateRange.CUSTOM;
        applyFilters();
    }

    private final void updateButtonSelection(MaterialButton button, boolean isSelected) {
        if (isSelected) {
            DocsFilesActivity docsFilesActivity = this;
            button.setTextColor(ContextCompat.getColor(docsFilesActivity, R.color.primary));
            button.setBackgroundColor(ContextCompat.getColor(docsFilesActivity, R.color.next));
        } else {
            DocsFilesActivity docsFilesActivity2 = this;
            button.setTextColor(ContextCompat.getColor(docsFilesActivity2, R.color.button_txt_color));
            button.setBackgroundColor(ContextCompat.getColor(docsFilesActivity2, R.color.feed_btn));
        }
    }

    private final void applyFilters() {
        List<DocsModel> sortDocs = sortDocs(filterBySizeRange(filterByDateRange(this.allDocsList, this.selectedDateRange), this.selectedSizeRange), this.selectedSortOrder);
        DocsAdapter docsAdapter = this.docsAdapter;
        if (docsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("docsAdapter");
            docsAdapter = null;
        }
        docsAdapter.updateDocs(sortDocs, sortDocs.size());
        updateSelectionUI();
        updateEmptyView();
    }

    private final List<DocsModel> filterByDateRange(List<DocsModel> docs, DateRange dateRange) {
        Date date;
        Date date2;
        Date date3 = new Date();
        int i = WhenMappings.$EnumSwitchMapping$1[dateRange.ordinal()];
        if (i == 1) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : docs) {
                if (((DocsModel) obj).getDateAdded().after(new Date(date3.getTime() - 2592000000L))) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }
        if (i == 2) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : docs) {
                if (((DocsModel) obj2).getDateAdded().after(new Date(date3.getTime() - 15552000000L))) {
                    arrayList2.add(obj2);
                }
            }
            return arrayList2;
        }
        if (i == 3) {
            ArrayList arrayList3 = new ArrayList();
            for (Object obj3 : docs) {
                if (((DocsModel) obj3).getDateAdded().after(new Date(date3.getTime() - 31536000000L))) {
                    arrayList3.add(obj3);
                }
            }
            return arrayList3;
        }
        if (i != 4 || (date = this.customStartDate) == null || (date2 = this.customEndDate) == null) {
            return docs;
        }
        ArrayList arrayList4 = new ArrayList();
        for (Object obj4 : docs) {
            DocsModel docsModel = (DocsModel) obj4;
            if (docsModel.getDateAdded().after(date) && docsModel.getDateAdded().before(date2)) {
                arrayList4.add(obj4);
            }
        }
        return arrayList4;
    }

    private final List<DocsModel> filterBySizeRange(List<DocsModel> docs, SizeRange sizeRange) {
        int i = WhenMappings.$EnumSwitchMapping$2[sizeRange.ordinal()];
        if (i == 1) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : docs) {
                if (((DocsModel) obj).getSize() <= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }
        if (i == 2) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : docs) {
                DocsModel docsModel = (DocsModel) obj2;
                if (docsModel.getSize() > PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED && docsModel.getSize() <= CacheDataSink.DEFAULT_FRAGMENT_SIZE) {
                    arrayList2.add(obj2);
                }
            }
            return arrayList2;
        }
        if (i != 3) {
            if (i != 4) {
                return docs;
            }
            ArrayList arrayList3 = new ArrayList();
            for (Object obj3 : docs) {
                if (((DocsModel) obj3).getSize() > 10485760) {
                    arrayList3.add(obj3);
                }
            }
            return arrayList3;
        }
        ArrayList arrayList4 = new ArrayList();
        for (Object obj4 : docs) {
            DocsModel docsModel2 = (DocsModel) obj4;
            if (docsModel2.getSize() > CacheDataSink.DEFAULT_FRAGMENT_SIZE && docsModel2.getSize() <= 10485760) {
                arrayList4.add(obj4);
            }
        }
        return arrayList4;
    }

    private final List<DocsModel> sortDocs(List<DocsModel> docs, SortOrder sortOrder) {
        int i = WhenMappings.$EnumSwitchMapping$0[sortOrder.ordinal()];
        if (i == 1) {
            return CollectionsKt.sortedWith(docs, new Comparator() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DocsFilesActivity$sortDocs$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Long.valueOf(((DocsModel) t).getSize()), Long.valueOf(((DocsModel) t2).getSize()));
                }
            });
        }
        if (i == 2) {
            return CollectionsKt.sortedWith(docs, new Comparator() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DocsFilesActivity$sortDocs$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Long.valueOf(((DocsModel) t2).getSize()), Long.valueOf(((DocsModel) t).getSize()));
                }
            });
        }
        if (i != 3) {
            return i != 4 ? docs : CollectionsKt.sortedWith(docs, new Comparator() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DocsFilesActivity$sortDocs$$inlined$sortedByDescending$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(((DocsModel) t2).getDateAdded(), ((DocsModel) t).getDateAdded());
                }
            });
        }
        return CollectionsKt.sortedWith(docs, new Comparator() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DocsFilesActivity$sortDocs$$inlined$sortedBy$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((DocsModel) t).getDateAdded(), ((DocsModel) t2).getDateAdded());
            }
        });
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: DocsFilesActivity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/activity/DocsFilesActivity$SortOrder;", "", "(Ljava/lang/String;I)V", "NONE", "SIZE_ASC", "SIZE_DESC", "TIME_ASC", "TIME_DESC", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class SortOrder {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ SortOrder[] $VALUES;
        public static final SortOrder NONE = new SortOrder("NONE", 0);
        public static final SortOrder SIZE_ASC = new SortOrder("SIZE_ASC", 1);
        public static final SortOrder SIZE_DESC = new SortOrder("SIZE_DESC", 2);
        public static final SortOrder TIME_ASC = new SortOrder("TIME_ASC", 3);
        public static final SortOrder TIME_DESC = new SortOrder("TIME_DESC", 4);

        private static final /* synthetic */ SortOrder[] $values() {
            return new SortOrder[]{NONE, SIZE_ASC, SIZE_DESC, TIME_ASC, TIME_DESC};
        }

        public static EnumEntries<SortOrder> getEntries() {
            return $ENTRIES;
        }

        public static SortOrder valueOf(String str) {
            return (SortOrder) Enum.valueOf(SortOrder.class, str);
        }

        public static SortOrder[] values() {
            return (SortOrder[]) $VALUES.clone();
        }

        static {
            SortOrder[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private SortOrder(String str, int i) {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: DocsFilesActivity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/activity/DocsFilesActivity$DateRange;", "", "(Ljava/lang/String;I)V", "NONE", "ONE_MONTH", "SIX_MONTHS", "ONE_YEAR", "CUSTOM", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class DateRange {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ DateRange[] $VALUES;
        public static final DateRange NONE = new DateRange("NONE", 0);
        public static final DateRange ONE_MONTH = new DateRange("ONE_MONTH", 1);
        public static final DateRange SIX_MONTHS = new DateRange("SIX_MONTHS", 2);
        public static final DateRange ONE_YEAR = new DateRange("ONE_YEAR", 3);
        public static final DateRange CUSTOM = new DateRange("CUSTOM", 4);

        private static final /* synthetic */ DateRange[] $values() {
            return new DateRange[]{NONE, ONE_MONTH, SIX_MONTHS, ONE_YEAR, CUSTOM};
        }

        public static EnumEntries<DateRange> getEntries() {
            return $ENTRIES;
        }

        public static DateRange valueOf(String str) {
            return (DateRange) Enum.valueOf(DateRange.class, str);
        }

        public static DateRange[] values() {
            return (DateRange[]) $VALUES.clone();
        }

        static {
            DateRange[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private DateRange(String str, int i) {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: DocsFilesActivity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/activity/DocsFilesActivity$SizeRange;", "", "(Ljava/lang/String;I)V", "NONE", "ZERO_TO_ONE", "ONE_TO_FIVE", "FIVE_TO_TEN", "MORE_THAN_TEN", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class SizeRange {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ SizeRange[] $VALUES;
        public static final SizeRange NONE = new SizeRange("NONE", 0);
        public static final SizeRange ZERO_TO_ONE = new SizeRange("ZERO_TO_ONE", 1);
        public static final SizeRange ONE_TO_FIVE = new SizeRange("ONE_TO_FIVE", 2);
        public static final SizeRange FIVE_TO_TEN = new SizeRange("FIVE_TO_TEN", 3);
        public static final SizeRange MORE_THAN_TEN = new SizeRange("MORE_THAN_TEN", 4);

        private static final /* synthetic */ SizeRange[] $values() {
            return new SizeRange[]{NONE, ZERO_TO_ONE, ONE_TO_FIVE, FIVE_TO_TEN, MORE_THAN_TEN};
        }

        public static EnumEntries<SizeRange> getEntries() {
            return $ENTRIES;
        }

        public static SizeRange valueOf(String str) {
            return (SizeRange) Enum.valueOf(SizeRange.class, str);
        }

        public static SizeRange[] values() {
            return (SizeRange[]) $VALUES.clone();
        }

        static {
            SizeRange[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private SizeRange(String str, int i) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateEmptyView() {
        AppCompatImageView appCompatImageView;
        DocsAdapter docsAdapter = this.docsAdapter;
        if (docsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("docsAdapter");
            docsAdapter = null;
        }
        if (docsAdapter.getItemCount() == 0) {
            ActivityDocsFilesBinding activityDocsFilesBinding = this.docsFilesBinding;
            RecyclerView recyclerView = activityDocsFilesBinding != null ? activityDocsFilesBinding.recyclerView : null;
            if (recyclerView != null) {
                recyclerView.setVisibility(View.GONE);
            }
            ActivityDocsFilesBinding activityDocsFilesBinding2 = this.docsFilesBinding;
            appCompatImageView = activityDocsFilesBinding2 != null ? activityDocsFilesBinding2.ivError : null;
            if (appCompatImageView == null) {
                return;
            }
            appCompatImageView.setVisibility(View.VISIBLE);
            return;
        }
        ActivityDocsFilesBinding activityDocsFilesBinding3 = this.docsFilesBinding;
        RecyclerView recyclerView2 = activityDocsFilesBinding3 != null ? activityDocsFilesBinding3.recyclerView : null;
        if (recyclerView2 != null) {
            recyclerView2.setVisibility(View.VISIBLE);
        }
        ActivityDocsFilesBinding activityDocsFilesBinding4 = this.docsFilesBinding;
        appCompatImageView = activityDocsFilesBinding4 != null ? activityDocsFilesBinding4.ivError : null;
        if (appCompatImageView == null) {
            return;
        }
        appCompatImageView.setVisibility(View.GONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSelectionChanged(boolean isAllSelected) {
        TextView textView;
        AppCompatImageView appCompatImageView;
        TextView textView2;
        AppCompatImageView appCompatImageView2;
        if (isAllSelected) {
            ActivityDocsFilesBinding activityDocsFilesBinding = this.docsFilesBinding;
            if (activityDocsFilesBinding != null && (appCompatImageView2 = activityDocsFilesBinding.icSelectAll) != null) {
                appCompatImageView2.setImageResource(R.drawable.ic_check);
            }
            ActivityDocsFilesBinding activityDocsFilesBinding2 = this.docsFilesBinding;
            if (activityDocsFilesBinding2 == null || (textView2 = activityDocsFilesBinding2.allSelected) == null) {
                return;
            }
            textView2.setText(R.string.all_deselect);
            return;
        }
        ActivityDocsFilesBinding activityDocsFilesBinding3 = this.docsFilesBinding;
        if (activityDocsFilesBinding3 != null && (appCompatImageView = activityDocsFilesBinding3.icSelectAll) != null) {
            appCompatImageView.setImageResource(R.drawable.ic_dslct);
        }
        ActivityDocsFilesBinding activityDocsFilesBinding4 = this.docsFilesBinding;
        if (activityDocsFilesBinding4 == null || (textView = activityDocsFilesBinding4.allSelected) == null) {
            return;
        }
        textView.setText(R.string.all_select);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onDocClick(int position) {
        DocsAdapter docsAdapter = this.docsAdapter;
        DocsAdapter docsAdapter2 = null;
        if (docsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("docsAdapter");
            docsAdapter = null;
        }
        if (docsAdapter.getSelectedItemCount() <= 0) {
            DocsAdapter docsAdapter3 = this.docsAdapter;
            if (docsAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("docsAdapter");
                docsAdapter3 = null;
            }
            if (!docsAdapter3.getIsAllSelected()) {
                DocsAdapter docsAdapter4 = this.docsAdapter;
                if (docsAdapter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("docsAdapter");
                } else {
                    docsAdapter2 = docsAdapter4;
                }
                DocsModel itemAtPosition = docsAdapter2.getItemAtPosition(position);
                Intent intent = new Intent(this, (Class<?>) ViewDocActivity.class);
                intent.putExtra("DOC_PATH", itemAtPosition.getFile().getAbsolutePath());
                intent.putExtra("FILE_TYPE", "doc");
                startActivity(intent);
                return;
            }
        }
        toggleSelection(position);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onDocLongClick(int position) {
        toggleSelection(position);
    }

    private final void toggleSelection(int position) {
        DocsAdapter docsAdapter = this.docsAdapter;
        if (docsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("docsAdapter");
            docsAdapter = null;
        }
        docsAdapter.toggleSelection(position);
        DocsAdapter docsAdapter2 = this.docsAdapter;
        if (docsAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("docsAdapter");
            docsAdapter2 = null;
        }
        int selectedItemCount = docsAdapter2.getSelectedItemCount();
        if (selectedItemCount > 0) {
            ActivityDocsFilesBinding activityDocsFilesBinding = this.docsFilesBinding;
            LinearLayout linearLayout = activityDocsFilesBinding != null ? activityDocsFilesBinding.llSelection : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(View.VISIBLE);
            }
            ActivityDocsFilesBinding activityDocsFilesBinding2 = this.docsFilesBinding;
            LinearLayout linearLayout2 = activityDocsFilesBinding2 != null ? activityDocsFilesBinding2.headerLayout : null;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(View.GONE);
            }
            ActivityDocsFilesBinding activityDocsFilesBinding3 = this.docsFilesBinding;
            TextView textView = activityDocsFilesBinding3 != null ? activityDocsFilesBinding3.tvRecover : null;
            if (textView == null) {
                return;
            }
            textView.setText("Recover (" + selectedItemCount + ')');
            return;
        }
        ActivityDocsFilesBinding activityDocsFilesBinding4 = this.docsFilesBinding;
        LinearLayout linearLayout3 = activityDocsFilesBinding4 != null ? activityDocsFilesBinding4.headerLayout : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(View.VISIBLE);
        }
        ActivityDocsFilesBinding activityDocsFilesBinding5 = this.docsFilesBinding;
        LinearLayout linearLayout4 = activityDocsFilesBinding5 != null ? activityDocsFilesBinding5.llSelection : null;
        if (linearLayout4 == null) {
            return;
        }
        linearLayout4.setVisibility(View.GONE);
    }

    private final void setupRecyclerView() {
        RecyclerView recyclerView;
        this.docsAdapter = new DocsAdapter(new ArrayList(), new DocsFilesActivity$setupRecyclerView$1(this), new DocsFilesActivity$setupRecyclerView$2(this), new DocsFilesActivity$setupRecyclerView$3(this));
        ActivityDocsFilesBinding activityDocsFilesBinding = this.docsFilesBinding;
        if (activityDocsFilesBinding == null || (recyclerView = activityDocsFilesBinding.recyclerView) == null) {
            return;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DocsAdapter docsAdapter = this.docsAdapter;
        if (docsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("docsAdapter");
            docsAdapter = null;
        }
        recyclerView.setAdapter(docsAdapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DocsFilesActivity$setupRecyclerView$4$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView2, int dx, int dy) {
                boolean z;
                Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                super.onScrolled(recyclerView2, dx, dy);
                RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
                Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                int itemCount = linearLayoutManager.getItemCount();
                int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                z = DocsFilesActivity.this.isLoading;
                if (z || findLastVisibleItemPosition != itemCount - 1) {
                    return;
                }
                DocsFilesActivity.this.loadMoreDocs();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadMoreDocs() {
        int i = this.currentPage * this.pageSize;
        if (i >= this.allDocsList.size()) {
            return;
        }
        this.isLoading = true;
        List<DocsModel> list = this.allDocsList;
        List<DocsModel> subList = list.subList(i, Math.min(this.pageSize + i, list.size()));
        DocsAdapter docsAdapter = this.docsAdapter;
        if (docsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("docsAdapter");
            docsAdapter = null;
        }
        docsAdapter.addDocs(subList, this.allDocsList.size());
        int i2 = this.currentPage + 1;
        this.currentPage = i2;
        this.isLoading = false;
        if (i2 * this.pageSize < this.allDocsList.size()) {
            this.handler.post(new Runnable() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DocsFilesActivity$$ExternalSyntheticLambda20
                @Override // java.lang.Runnable
                public final void run() {
                    DocsFilesActivity.loadMoreDocs$lambda$46(DocsFilesActivity.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadMoreDocs$lambda$46(DocsFilesActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.loadMoreDocs();
    }

    private final void selectAllDocs() {
        DocsAdapter docsAdapter = this.docsAdapter;
        if (docsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("docsAdapter");
            docsAdapter = null;
        }
        docsAdapter.selectAll();
        updateSelectionUI();
    }

    private final void deselectAllDocs() {
        DocsAdapter docsAdapter = this.docsAdapter;
        if (docsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("docsAdapter");
            docsAdapter = null;
        }
        docsAdapter.deselectAll();
        updateSelectionUI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSelectionUI() {
        int selectedItemCount;
        DocsAdapter docsAdapter = this.docsAdapter;
        if (docsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("docsAdapter");
            docsAdapter = null;
        }
        if (docsAdapter.getIsAllSelected()) {
            DocsAdapter docsAdapter2 = this.docsAdapter;
            if (docsAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("docsAdapter");
                docsAdapter2 = null;
            }
            selectedItemCount = docsAdapter2.getTotalItemCount();
        } else {
            DocsAdapter docsAdapter3 = this.docsAdapter;
            if (docsAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("docsAdapter");
                docsAdapter3 = null;
            }
            selectedItemCount = docsAdapter3.getSelectedItemCount();
        }
        if (selectedItemCount > 0) {
            ActivityDocsFilesBinding activityDocsFilesBinding = this.docsFilesBinding;
            LinearLayout linearLayout = activityDocsFilesBinding != null ? activityDocsFilesBinding.llSelection : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(View.VISIBLE);
            }
            ActivityDocsFilesBinding activityDocsFilesBinding2 = this.docsFilesBinding;
            LinearLayout linearLayout2 = activityDocsFilesBinding2 != null ? activityDocsFilesBinding2.headerLayout : null;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(View.GONE);
            }
            ActivityDocsFilesBinding activityDocsFilesBinding3 = this.docsFilesBinding;
            TextView textView = activityDocsFilesBinding3 != null ? activityDocsFilesBinding3.tvRecover : null;
            if (textView == null) {
                return;
            }
            textView.setText("Recover (" + selectedItemCount + ')');
            return;
        }
        ActivityDocsFilesBinding activityDocsFilesBinding4 = this.docsFilesBinding;
        LinearLayout linearLayout3 = activityDocsFilesBinding4 != null ? activityDocsFilesBinding4.headerLayout : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(View.VISIBLE);
        }
        ActivityDocsFilesBinding activityDocsFilesBinding5 = this.docsFilesBinding;
        LinearLayout linearLayout4 = activityDocsFilesBinding5 != null ? activityDocsFilesBinding5.llSelection : null;
        if (linearLayout4 == null) {
            return;
        }
        linearLayout4.setVisibility(View.GONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<DocsModel> fetchAllDocs(List<String> docPaths) {
        List<String> list = docPaths;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            File file = new File((String) it.next());
            arrayList.add(new DocsModel(file, file.length(), new Date(file.lastModified())));
        }
        return CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DocsFilesActivity$fetchAllDocs$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((DocsModel) t2).getDateAdded(), ((DocsModel) t).getDateAdded());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<DocsModel> fetchDocsFromAlbum(String folderPath) {
        if (folderPath == null) {
            return CollectionsKt.emptyList();
        }
        File file = new File(folderPath);
        if (!file.exists()) {
            return CollectionsKt.emptyList();
        }
        File[] listFiles = file.listFiles(new FileFilter() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DocsFilesActivity$$ExternalSyntheticLambda19
            @Override // java.io.FileFilter
            public final boolean accept(File file2) {
                boolean fetchDocsFromAlbum$lambda$49;
                fetchDocsFromAlbum$lambda$49 = DocsFilesActivity.fetchDocsFromAlbum$lambda$49(file2);
                return fetchDocsFromAlbum$lambda$49;
            }
        });
        if (listFiles != null) {
            ArrayList arrayList = new ArrayList(listFiles.length);
            for (File file2 : listFiles) {
                Intrinsics.checkNotNull(file2);
                arrayList.add(new DocsModel(file2, file2.length(), new Date(file2.lastModified())));
            }
            List<DocsModel> sortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.DocsFilesActivity$fetchDocsFromAlbum$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(((DocsModel) t2).getDateAdded(), ((DocsModel) t).getDateAdded());
                }
            });
            if (sortedWith != null) {
                return sortedWith;
            }
        }
        return CollectionsKt.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean fetchDocsFromAlbum$lambda$49(File file) {
        List listOf = CollectionsKt.listOf((Object[]) new String[]{"pdf", "doc", "docx", "xls", "xlsx", "txt", "ppt", "pptx", "zip", "apk", "xapk", "aab", "temp", "odt", "ods", "odp", "rtf", "csv", "xml", InAppMessageContent.HTML, "htm", "md", "json", "epub", "mobi", "rar", "7z", "tar", "gz", "iso", "ttf", "psd", "svg", "pdf_temp", "pdf 100nu", "plp", "pages", "tmp.chck", "D0CF11E0"});
        Intrinsics.checkNotNull(file);
        String lowerCase = FilesKt.getExtension(file).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return listOf.contains(lowerCase);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        DocsAdapter docsAdapter = this.docsAdapter;
        if (docsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("docsAdapter");
            docsAdapter = null;
        }
        if (docsAdapter.getSelectedItemCount() > 0) {
            deselectAllDocs();
        } else {
            super.onBackPressed();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.docsFilesBinding = null;
        this.handler.removeCallbacksAndMessages(null);
    }
}
