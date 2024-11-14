package com.gcs.recovery.videos.files.photo_recovery.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaMetadataRetriever;
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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.internal.ShareInternalUtility;
import com.demo.example.R;
import com.gcs.recovery.videos.files.photo_recovery.adapter.VideosAdapter;
import com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass;
import com.demo.example.databinding.ActivityVideoFilesBinding;
import com.demo.example.databinding.DialogSortLayoutBinding;
import com.gcs.recovery.videos.files.photo_recovery.model.VideosModel;
import com.gcs.recovery.videos.files.photo_recovery.utils.FileUtils;
import com.gcs.recovery.videos.files.photo_recovery.utils.SharedDataHolder;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.button.MaterialButton;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;






/* compiled from: VideoFilesActivity.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0003]^_B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0002J\u0010\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020\u0007H\u0002J\u0016\u0010%\u001a\u00020!2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\b\u0010'\u001a\u00020!H\u0002J%\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00160\u0004H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010*J!\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010,\u001a\u0004\u0018\u00010\u0016H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010-J$\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u00100\u001a\u00020\u0013H\u0002J$\u00101\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u00102\u001a\u00020\u0019H\u0002J\u0010\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0002J\u0010\u00107\u001a\u00020\u000f2\u0006\u00105\u001a\u000206H\u0002J\u001b\u00108\u001a\u00020!2\b\u00109\u001a\u0004\u0018\u00010\u0016H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010-J\b\u0010:\u001a\u00020!H\u0002J\u0010\u0010;\u001a\u00020!2\u0006\u0010<\u001a\u00020\u0005H\u0002J\b\u0010=\u001a\u00020!H\u0016J\u0012\u0010>\u001a\u00020!2\b\u0010?\u001a\u0004\u0018\u00010@H\u0014J\b\u0010A\u001a\u00020!H\u0014J\u0010\u0010B\u001a\u00020!2\u0006\u0010C\u001a\u00020\u000fH\u0002J\u0010\u0010D\u001a\u00020!2\u0006\u0010E\u001a\u00020\u0007H\u0002J\u0010\u0010F\u001a\u00020!2\u0006\u0010E\u001a\u00020\u0007H\u0002J\u0010\u0010G\u001a\u00020!2\u0006\u0010H\u001a\u00020IH\u0002J\u0010\u0010J\u001a\u00020!2\u0006\u0010K\u001a\u00020\u0005H\u0002J\b\u0010L\u001a\u00020!H\u0003J\b\u0010M\u001a\u00020!H\u0002J\u0010\u0010N\u001a\u00020!2\u0006\u0010$\u001a\u00020\u0007H\u0002J\b\u0010O\u001a\u00020!H\u0002J\b\u0010P\u001a\u00020!H\u0002J\b\u0010Q\u001a\u00020!H\u0002J\b\u0010R\u001a\u00020!H\u0002J$\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010T\u001a\u00020\u001bH\u0002J\u0010\u0010U\u001a\u00020!2\u0006\u0010E\u001a\u00020\u0007H\u0003J\u0018\u0010V\u001a\u00020!2\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020\u000fH\u0002J\b\u0010Z\u001a\u00020!H\u0002J\b\u0010[\u001a\u00020!H\u0002J\b\u0010\\\u001a\u00020!H\u0003R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006`"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/activity/VideoFilesActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "allVideosList", "", "Lcom/gcs/recovery/videos/files/photo_recovery/model/VideosModel;", "currentGridSpan", "", "currentPage", "customEndDate", "Ljava/util/Date;", "customStartDate", "handler", "Landroid/os/Handler;", "isGridSpanSelected", "", "isLoading", "pageSize", "selectedDateRange", "Lcom/gcs/recovery/videos/files/photo_recovery/activity/VideoFilesActivity$DateRange;", "selectedFilterTypes", "", "", "selectedGridSpan", "selectedSizeRange", "Lcom/gcs/recovery/videos/files/photo_recovery/activity/VideoFilesActivity$SizeRange;", "selectedSortOrder", "Lcom/gcs/recovery/videos/files/photo_recovery/activity/VideoFilesActivity$SortOrder;", "videoFilesBinding", "Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ActivityVideoFilesBinding;", "videosAdapter", "Lcom/gcs/recovery/videos/files/photo_recovery/adapter/VideosAdapter;", "applyCustomDateRangeFilter", "", "applyFilters", "changeGridSpan", "spanCount", "deleteSelectedItems", FirebaseAnalytics.Param.ITEMS, "deselectAllVideos", "fetchAllVideos", "videoPaths", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchVideosFromAlbum", "folderPath", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "filterByDateRange", "videos", "dateRange", "filterBySizeRange", "sizeRange", "getVideoDuration", "", ShareInternalUtility.STAGING_PARAM, "Ljava/io/File;", "isValidVideo", "loadAlbumPhotos", "albumPath", "loadMoreVideos", "loadVideoDurationAsync", "videoModel", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSelectionChanged", "isAllSelected", "onVideoClick", "position", "onVideoLongClick", "preselectFilterButtons", "dialogBinding", "Lcom/gcs/recovery/videos/files/photo_recovery/databinding/DialogSortLayoutBinding;", "recoverItem", "video", "recoverSelectedVideos", "resetFilters", "saveGridSpan", "selectAllVideos", "setupRecyclerView", "showCustomDatePickerDialog", "showSortDialog", "sortVideos", SDKConstants.PARAM_SORT_ORDER, "toggleSelection", "updateButtonSelection", "button", "Lcom/google/android/material/button/MaterialButton;", "isSelected", "updateEmptyView", "updateRecyclerViewGridSpan", "updateSelectionUI", "DateRange", "SizeRange", "SortOrder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class VideoFilesActivity extends AppCompatActivity {
    private int currentPage;
    private Date customEndDate;
    private Date customStartDate;
    private boolean isGridSpanSelected;
    private boolean isLoading;
    private ActivityVideoFilesBinding videoFilesBinding;
    private VideosAdapter videosAdapter;
    private List<VideosModel> allVideosList = CollectionsKt.emptyList();
    private final int pageSize = 20;
    private int currentGridSpan = 3;
    private Handler handler = new Handler(Looper.getMainLooper());
    private final List<String> selectedFilterTypes = new ArrayList();
    private int selectedGridSpan = this.currentGridSpan;
    private SortOrder selectedSortOrder = SortOrder.NONE;
    private DateRange selectedDateRange = DateRange.NONE;
    private SizeRange selectedSizeRange = SizeRange.NONE;

    /* compiled from: VideoFilesActivity.kt */
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
        ActivityVideoFilesBinding inflate = ActivityVideoFilesBinding.inflate(getLayoutInflater());
        this.videoFilesBinding = inflate;
        Intrinsics.checkNotNull(inflate);
        setContentView(inflate.getRoot());
        FileUtils.INSTANCE.createAppFolders(this);
        this.selectedGridSpan = this.currentGridSpan;
        this.selectedSortOrder = SortOrder.NONE;
        this.selectedDateRange = DateRange.NONE;
        this.selectedSizeRange = SizeRange.NONE;
        AdsClass adsClass = new AdsClass();
        ActivityVideoFilesBinding activityVideoFilesBinding = this.videoFilesBinding;
        Intrinsics.checkNotNull(activityVideoFilesBinding);
        adsClass.refreshAd(activityVideoFilesBinding.frameLayout, this, 2);
        String stringExtra = getIntent().getStringExtra("ALBUM_TITLE");
        if (stringExtra == null) {
            stringExtra = "Videos";
        }
        ActivityVideoFilesBinding activityVideoFilesBinding2 = this.videoFilesBinding;
        TextView textView2 = activityVideoFilesBinding2 != null ? activityVideoFilesBinding2.txtTitle : null;
        if (textView2 != null) {
            textView2.setText(stringExtra);
        }
        this.currentGridSpan = getPreferences(0).getInt("GRID_SPAN", 3);
        String stringExtra2 = getIntent().getStringExtra("ALBUM_PATH");
        setupRecyclerView();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new VideoFilesActivity$onCreate$1(this, stringExtra2, null), 3, null);
        ActivityVideoFilesBinding activityVideoFilesBinding3 = this.videoFilesBinding;
        if (activityVideoFilesBinding3 != null && (appCompatImageView4 = activityVideoFilesBinding3.icBack) != null) {
            appCompatImageView4.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.VideoFilesActivity$$ExternalSyntheticLambda22
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VideoFilesActivity.onCreate$lambda$0(VideoFilesActivity.this, view);
                }
            });
        }
        ActivityVideoFilesBinding activityVideoFilesBinding4 = this.videoFilesBinding;
        if (activityVideoFilesBinding4 != null && (appCompatImageView3 = activityVideoFilesBinding4.icMenu) != null) {
            appCompatImageView3.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.VideoFilesActivity$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VideoFilesActivity.onCreate$lambda$1(VideoFilesActivity.this, view);
                }
            });
        }
        ActivityVideoFilesBinding activityVideoFilesBinding5 = this.videoFilesBinding;
        if (activityVideoFilesBinding5 != null && (linearLayout = activityVideoFilesBinding5.llSelection) != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.VideoFilesActivity$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VideoFilesActivity.onCreate$lambda$2(VideoFilesActivity.this, view);
                }
            });
        }
        ActivityVideoFilesBinding activityVideoFilesBinding6 = this.videoFilesBinding;
        if (activityVideoFilesBinding6 != null && (appCompatImageView2 = activityVideoFilesBinding6.icSelectAll) != null) {
            appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.VideoFilesActivity$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VideoFilesActivity.onCreate$lambda$3(VideoFilesActivity.this, view);
                }
            });
        }
        ActivityVideoFilesBinding activityVideoFilesBinding7 = this.videoFilesBinding;
        if (activityVideoFilesBinding7 != null && (appCompatImageView = activityVideoFilesBinding7.icDelete) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.VideoFilesActivity$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VideoFilesActivity.onCreate$lambda$4(VideoFilesActivity.this, view);
                }
            });
        }
        ActivityVideoFilesBinding activityVideoFilesBinding8 = this.videoFilesBinding;
        if (activityVideoFilesBinding8 == null || (textView = activityVideoFilesBinding8.tvRecover) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.VideoFilesActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoFilesActivity.onCreate$lambda$6(VideoFilesActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(VideoFilesActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(VideoFilesActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showSortDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(VideoFilesActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VideosAdapter videosAdapter = this$0.videosAdapter;
        if (videosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videosAdapter");
            videosAdapter = null;
        }
        videosAdapter.getSelectedItemCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(VideoFilesActivity this$0, View view) {
        TextView textView;
        AppCompatImageView appCompatImageView;
        TextView textView2;
        AppCompatImageView appCompatImageView2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VideosAdapter videosAdapter = this$0.videosAdapter;
        VideosAdapter videosAdapter2 = null;
        if (videosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videosAdapter");
            videosAdapter = null;
        }
        int selectedItemCount = videosAdapter.getSelectedItemCount();
        VideosAdapter videosAdapter3 = this$0.videosAdapter;
        if (videosAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videosAdapter");
        } else {
            videosAdapter2 = videosAdapter3;
        }
        if (selectedItemCount == videosAdapter2.getItemCount()) {
            this$0.deselectAllVideos();
            ActivityVideoFilesBinding activityVideoFilesBinding = this$0.videoFilesBinding;
            if (activityVideoFilesBinding != null && (appCompatImageView2 = activityVideoFilesBinding.icSelectAll) != null) {
                appCompatImageView2.setImageResource(R.drawable.ic_dslct);
            }
            ActivityVideoFilesBinding activityVideoFilesBinding2 = this$0.videoFilesBinding;
            if (activityVideoFilesBinding2 == null || (textView2 = activityVideoFilesBinding2.allSelected) == null) {
                return;
            }
            textView2.setText(R.string.all_select);
            return;
        }
        this$0.selectAllVideos();
        ActivityVideoFilesBinding activityVideoFilesBinding3 = this$0.videoFilesBinding;
        if (activityVideoFilesBinding3 != null && (appCompatImageView = activityVideoFilesBinding3.icSelectAll) != null) {
            appCompatImageView.setImageResource(R.drawable.ic_check);
        }
        ActivityVideoFilesBinding activityVideoFilesBinding4 = this$0.videoFilesBinding;
        if (activityVideoFilesBinding4 == null || (textView = activityVideoFilesBinding4.allSelected) == null) {
            return;
        }
        textView.setText(R.string.all_deselect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$4(VideoFilesActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VideosAdapter videosAdapter = this$0.videosAdapter;
        if (videosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videosAdapter");
            videosAdapter = null;
        }
        this$0.deleteSelectedItems(videosAdapter.getSelectedItems());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$6(final VideoFilesActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AdsClass.showInterstitial(this$0, new AdsClass.onListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.VideoFilesActivity$$ExternalSyntheticLambda19
            @Override // com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass.onListener
            public final void click() {
                VideoFilesActivity.onCreate$lambda$6$lambda$5(VideoFilesActivity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$6$lambda$5(VideoFilesActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.recoverSelectedVideos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadAlbumPhotos(String str, Continuation<? super Unit> continuation) {
        VideoFilesActivity$loadAlbumPhotos$1 videoFilesActivity$loadAlbumPhotos$1;
        int i;
        VideoFilesActivity videoFilesActivity;
        if (continuation instanceof VideoFilesActivity$loadAlbumPhotos$1) {
            videoFilesActivity$loadAlbumPhotos$1 = (VideoFilesActivity$loadAlbumPhotos$1) continuation;
            if ((videoFilesActivity$loadAlbumPhotos$1.label & Integer.MIN_VALUE) != 0) {
                videoFilesActivity$loadAlbumPhotos$1.label -= Integer.MIN_VALUE;
                Object obj = videoFilesActivity$loadAlbumPhotos$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = videoFilesActivity$loadAlbumPhotos$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    MainCoroutineDispatcher main = Dispatchers.getMain();
                    VideoFilesActivity$loadAlbumPhotos$2 videoFilesActivity$loadAlbumPhotos$2 = new VideoFilesActivity$loadAlbumPhotos$2(this, null);
                    videoFilesActivity$loadAlbumPhotos$1.L$0 = this;
                    videoFilesActivity$loadAlbumPhotos$1.L$1 = str;
                    videoFilesActivity$loadAlbumPhotos$1.label = 1;
                    if (BuildersKt.withContext(main, videoFilesActivity$loadAlbumPhotos$2, videoFilesActivity$loadAlbumPhotos$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    videoFilesActivity = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    str = (String) videoFilesActivity$loadAlbumPhotos$1.L$1;
                    videoFilesActivity = (VideoFilesActivity) videoFilesActivity$loadAlbumPhotos$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new VideoFilesActivity$loadAlbumPhotos$3(videoFilesActivity, str, null), 3, null);
                return Unit.INSTANCE;
            }
        }
        videoFilesActivity$loadAlbumPhotos$1 = new VideoFilesActivity$loadAlbumPhotos$1(this, continuation);
        Object obj2 = videoFilesActivity$loadAlbumPhotos$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = videoFilesActivity$loadAlbumPhotos$1.label;
        if (i != 0) {
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new VideoFilesActivity$loadAlbumPhotos$3(videoFilesActivity, str, null), 3, null);
        return Unit.INSTANCE;
    }

    private final void recoverSelectedVideos() {
        VideosAdapter videosAdapter = this.videosAdapter;
        if (videosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videosAdapter");
            videosAdapter = null;
        }
        final List<VideosModel> selectedItems = videosAdapter.getSelectedItems();
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
        new Thread(new Runnable() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.VideoFilesActivity$$ExternalSyntheticLambda18
            @Override // java.lang.Runnable
            public final void run() {
                VideoFilesActivity.recoverSelectedVideos$lambda$9(selectedItems, this, intRef, textView, progressBar, bottomSheetDialog);
            }
        }).start();
        deselectAllVideos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void recoverSelectedVideos$lambda$9(List selectedItems, final VideoFilesActivity this$0, final Ref.IntRef recoveredItemCount, final TextView textView, final ProgressBar progressBar, final BottomSheetDialog dialog) {
        Intrinsics.checkNotNullParameter(selectedItems, "$selectedItems");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(recoveredItemCount, "$recoveredItemCount");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Iterator it = selectedItems.iterator();
        final int i = 0;
        while (it.hasNext()) {
            VideosModel videosModel = (VideosModel) it.next();
            Thread.sleep(500L);
            this$0.recoverItem(videosModel);
            recoveredItemCount.element++;
            this$0.runOnUiThread(new Runnable() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.VideoFilesActivity$$ExternalSyntheticLambda20
                @Override // java.lang.Runnable
                public final void run() {
                    VideoFilesActivity.recoverSelectedVideos$lambda$9$lambda$7(textView, i, progressBar);
                }
            });
            i++;
        }
        this$0.runOnUiThread(new Runnable() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.VideoFilesActivity$$ExternalSyntheticLambda21
            @Override // java.lang.Runnable
            public final void run() {
                VideoFilesActivity.recoverSelectedVideos$lambda$9$lambda$8(BottomSheetDialog.this, this$0, recoveredItemCount);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void recoverSelectedVideos$lambda$9$lambda$7(TextView textView, int i, ProgressBar progressBar) {
        int i2 = i + 1;
        textView.setText(String.valueOf(i2));
        progressBar.setProgress(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void recoverSelectedVideos$lambda$9$lambda$8(BottomSheetDialog dialog, VideoFilesActivity this$0, Ref.IntRef recoveredItemCount) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(recoveredItemCount, "$recoveredItemCount");
        dialog.dismiss();
        Intent intent = new Intent(this$0, (Class<?>) SuccessfullyRecoverActivity.class);
        intent.putExtra("RECOVERED_ITEM_COUNT", recoveredItemCount.element);
        intent.putExtra("ITEM_TYPE", ShareConstants.VIDEO_URL);
        this$0.startActivity(intent);
    }

    private final void recoverItem(VideosModel video) {
        String str;
        File file = new File(Environment.getExternalStorageDirectory(), "PhotoRecovery/Videos");
        if (!file.exists()) {
            file.mkdirs();
        }
        String name = video.getFile().getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        if (!StringsKt.startsWith$default(name, ".", false, 2, (Object) null)) {
            String name2 = video.getFile().getName();
            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
            if (!StringsKt.startsWith$default(name2, "_", false, 2, (Object) null)) {
                str = FilesKt.getNameWithoutExtension(video.getFile()) + ".mp4";
                File file2 = new File(file, str);
                FilesKt.copyTo$default(video.getFile(), file2, true, 0, 4, null);
                MediaScannerConnection.scanFile(this, new String[]{file2.getAbsolutePath()}, null, null);
            }
        }
        str = StringsKt.removePrefix(FilesKt.getNameWithoutExtension(video.getFile()), (CharSequence) ".") + ".mp4";
        File file22 = new File(file, str);
        FilesKt.copyTo$default(video.getFile(), file22, true, 0, 4, null);
        MediaScannerConnection.scanFile(this, new String[]{file22.getAbsolutePath()}, null, null);
    }

    private final void deleteSelectedItems(final List<VideosModel> items) {
        if (items.isEmpty()) {
            return;
        }
        View inflate = getLayoutInflater().inflate(R.layout.dialog_delete_alert, (ViewGroup) null);
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(inflate);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.iv_no_btn);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.iv_yes_btn);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.VideoFilesActivity$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoFilesActivity.deleteSelectedItems$lambda$10(BottomSheetDialog.this, view);
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.VideoFilesActivity$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoFilesActivity.deleteSelectedItems$lambda$15(items, bottomSheetDialog, this, view);
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
    public static final void deleteSelectedItems$lambda$15(List items, BottomSheetDialog dialog, VideoFilesActivity this$0, View view) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(items, "$items");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List list = items;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((VideosModel) it.next()).getFile().delete();
        }
        dialog.dismiss();
        this$0.deselectAllVideos();
        SharedDataHolder sharedDataHolder = SharedDataHolder.INSTANCE;
        List<File> videoFiles = SharedDataHolder.INSTANCE.getVideoFiles();
        VideosAdapter videosAdapter = null;
        if (videoFiles != null) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : videoFiles) {
                File file = (File) obj;
                boolean z = false;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator it2 = list.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (Intrinsics.areEqual(((VideosModel) it2.next()).getFile(), file)) {
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
        sharedDataHolder.setVideoFiles(arrayList);
        List<VideosModel> list2 = this$0.allVideosList;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : list2) {
            if (!items.contains((VideosModel) obj2)) {
                arrayList3.add(obj2);
            }
        }
        this$0.allVideosList = arrayList3;
        VideosAdapter videosAdapter2 = this$0.videosAdapter;
        if (videosAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videosAdapter");
        } else {
            videosAdapter = videosAdapter2;
        }
        List<VideosModel> list3 = this$0.allVideosList;
        videosAdapter.updateVideos(list3, list3.size());
        this$0.updateSelectionUI();
        this$0.updateEmptyView();
    }

    private final void resetFilters() {
        this.selectedFilterTypes.clear();
        this.selectedGridSpan = this.currentGridSpan;
        this.selectedSortOrder = SortOrder.NONE;
        this.selectedDateRange = DateRange.NONE;
        this.selectedSizeRange = SizeRange.NONE;
        applyFilters();
    }

    private final void showSortDialog() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        final DialogSortLayoutBinding inflate = DialogSortLayoutBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        bottomSheetDialog.setContentView(inflate.getRoot());
        preselectFilterButtons(inflate);
        final List listOf = CollectionsKt.listOf((Object[]) new MaterialButton[]{inflate.btnGrid2, inflate.btnGrid3, inflate.btnGrid4});
        final List listOf2 = CollectionsKt.listOf((Object[]) new MaterialButton[]{inflate.sizeAsc, inflate.sizeDesc, inflate.timeOldest, inflate.timeNewest});
        final List listOf3 = CollectionsKt.listOf((Object[]) new MaterialButton[]{inflate.allDateBy, inflate.oneMonth, inflate.sixMonth, inflate.oneYear, inflate.customDate});
        final List listOf4 = CollectionsKt.listOf((Object[]) new MaterialButton[]{inflate.allSizeBy, inflate.zeroToOne, inflate.oneToFive, inflate.fiveToTen, inflate.moreThanTen});
        for (Iterator it = listOf.iterator(); it.hasNext(); it = it) {
            ((MaterialButton) it.next()).setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.VideoFilesActivity$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VideoFilesActivity.showSortDialog$lambda$18$lambda$17(listOf, this, inflate, listOf2, listOf3, listOf4, view);
                }
            });
        }
        for (Iterator it2 = listOf2.iterator(); it2.hasNext(); it2 = it2) {
            ((MaterialButton) it2.next()).setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.VideoFilesActivity$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VideoFilesActivity.showSortDialog$lambda$20$lambda$19(listOf2, listOf, this, inflate, listOf3, listOf4, view);
                }
            });
        }
        for (Iterator it3 = listOf3.iterator(); it3.hasNext(); it3 = it3) {
            final MaterialButton materialButton = (MaterialButton) it3.next();
            materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.VideoFilesActivity$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VideoFilesActivity.showSortDialog$lambda$22$lambda$21(MaterialButton.this, inflate, this, listOf3, listOf, listOf2, listOf4, view);
                }
            });
        }
        Iterator it4 = listOf4.iterator();
        while (it4.hasNext()) {
            ((MaterialButton) it4.next()).setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.VideoFilesActivity$$ExternalSyntheticLambda12
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VideoFilesActivity.showSortDialog$lambda$24$lambda$23(listOf4, listOf, this, inflate, listOf2, listOf3, view);
                }
            });
        }
        inflate.applyBtn.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.VideoFilesActivity$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoFilesActivity.showSortDialog$lambda$25(VideoFilesActivity.this, bottomSheetDialog, view);
            }
        });
        inflate.resetFilter.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.VideoFilesActivity$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoFilesActivity.showSortDialog$lambda$30(VideoFilesActivity.this, listOf, listOf2, listOf3, listOf4, bottomSheetDialog, inflate, view);
            }
        });
        bottomSheetDialog.show();
    }

    private static final void showSortDialog$handleButtonSelection(List<? extends MaterialButton> list, VideoFilesActivity videoFilesActivity, DialogSortLayoutBinding dialogSortLayoutBinding, List<? extends MaterialButton> list2, List<? extends MaterialButton> list3, List<? extends MaterialButton> list4, List<? extends MaterialButton> list5, MaterialButton materialButton) {
        SizeRange sizeRange;
        DateRange dateRange;
        SortOrder sortOrder;
        int i;
        for (MaterialButton materialButton2 : list5) {
            videoFilesActivity.updateButtonSelection(materialButton2, Intrinsics.areEqual(materialButton2, materialButton));
        }
        if (Intrinsics.areEqual(list5, list)) {
            if (Intrinsics.areEqual(materialButton, dialogSortLayoutBinding.btnGrid2)) {
                i = 2;
            } else if (Intrinsics.areEqual(materialButton, dialogSortLayoutBinding.btnGrid3)) {
                i = 3;
            } else {
                i = Intrinsics.areEqual(materialButton, dialogSortLayoutBinding.btnGrid4) ? 4 : videoFilesActivity.currentGridSpan;
            }
            videoFilesActivity.selectedGridSpan = i;
            videoFilesActivity.isGridSpanSelected = true;
            return;
        }
        if (Intrinsics.areEqual(list5, list2)) {
            if (Intrinsics.areEqual(materialButton, dialogSortLayoutBinding.sizeAsc)) {
                sortOrder = SortOrder.SIZE_ASC;
            } else if (Intrinsics.areEqual(materialButton, dialogSortLayoutBinding.sizeDesc)) {
                sortOrder = SortOrder.SIZE_DESC;
            } else if (Intrinsics.areEqual(materialButton, dialogSortLayoutBinding.timeOldest)) {
                sortOrder = SortOrder.TIME_ASC;
            } else {
                sortOrder = Intrinsics.areEqual(materialButton, dialogSortLayoutBinding.timeNewest) ? SortOrder.TIME_DESC : SortOrder.TIME_DESC;
            }
            videoFilesActivity.selectedSortOrder = sortOrder;
            return;
        }
        if (Intrinsics.areEqual(list5, list3)) {
            if (Intrinsics.areEqual(materialButton, dialogSortLayoutBinding.allDateBy)) {
                dateRange = DateRange.NONE;
            } else if (Intrinsics.areEqual(materialButton, dialogSortLayoutBinding.oneMonth)) {
                dateRange = DateRange.ONE_MONTH;
            } else if (Intrinsics.areEqual(materialButton, dialogSortLayoutBinding.sixMonth)) {
                dateRange = DateRange.SIX_MONTHS;
            } else if (Intrinsics.areEqual(materialButton, dialogSortLayoutBinding.oneYear)) {
                dateRange = DateRange.ONE_YEAR;
            } else {
                dateRange = Intrinsics.areEqual(materialButton, dialogSortLayoutBinding.customDate) ? DateRange.CUSTOM : DateRange.NONE;
            }
            videoFilesActivity.selectedDateRange = dateRange;
            if (Intrinsics.areEqual(materialButton, dialogSortLayoutBinding.customDate)) {
                videoFilesActivity.showCustomDatePickerDialog();
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(list5, list4)) {
            if (Intrinsics.areEqual(materialButton, dialogSortLayoutBinding.zeroToOne)) {
                sizeRange = SizeRange.ZERO_TO_ONE;
            } else if (Intrinsics.areEqual(materialButton, dialogSortLayoutBinding.oneToFive)) {
                sizeRange = SizeRange.ONE_TO_FIVE;
            } else if (Intrinsics.areEqual(materialButton, dialogSortLayoutBinding.fiveToTen)) {
                sizeRange = SizeRange.FIVE_TO_TEN;
            } else {
                sizeRange = Intrinsics.areEqual(materialButton, dialogSortLayoutBinding.moreThanTen) ? SizeRange.MORE_THAN_TEN : SizeRange.NONE;
            }
            videoFilesActivity.selectedSizeRange = sizeRange;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSortDialog$lambda$18$lambda$17(List gridSpanButtons, VideoFilesActivity this$0, DialogSortLayoutBinding dialogBinding, List sortOrderButtons, List dateRangeButtons, List sizeRangeButtons, View view) {
        Intrinsics.checkNotNullParameter(gridSpanButtons, "$gridSpanButtons");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialogBinding, "$dialogBinding");
        Intrinsics.checkNotNullParameter(sortOrderButtons, "$sortOrderButtons");
        Intrinsics.checkNotNullParameter(dateRangeButtons, "$dateRangeButtons");
        Intrinsics.checkNotNullParameter(sizeRangeButtons, "$sizeRangeButtons");
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.google.android.material.button.MaterialButton");
        showSortDialog$handleButtonSelection(gridSpanButtons, this$0, dialogBinding, sortOrderButtons, dateRangeButtons, sizeRangeButtons, gridSpanButtons, (MaterialButton) view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSortDialog$lambda$20$lambda$19(List sortOrderButtons, List gridSpanButtons, VideoFilesActivity this$0, DialogSortLayoutBinding dialogBinding, List dateRangeButtons, List sizeRangeButtons, View view) {
        Intrinsics.checkNotNullParameter(sortOrderButtons, "$sortOrderButtons");
        Intrinsics.checkNotNullParameter(gridSpanButtons, "$gridSpanButtons");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialogBinding, "$dialogBinding");
        Intrinsics.checkNotNullParameter(dateRangeButtons, "$dateRangeButtons");
        Intrinsics.checkNotNullParameter(sizeRangeButtons, "$sizeRangeButtons");
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.google.android.material.button.MaterialButton");
        showSortDialog$handleButtonSelection(gridSpanButtons, this$0, dialogBinding, sortOrderButtons, dateRangeButtons, sizeRangeButtons, sortOrderButtons, (MaterialButton) view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSortDialog$lambda$22$lambda$21(MaterialButton button, DialogSortLayoutBinding dialogBinding, VideoFilesActivity this$0, List dateRangeButtons, List gridSpanButtons, List sortOrderButtons, List sizeRangeButtons, View view) {
        Intrinsics.checkNotNullParameter(button, "$button");
        Intrinsics.checkNotNullParameter(dialogBinding, "$dialogBinding");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dateRangeButtons, "$dateRangeButtons");
        Intrinsics.checkNotNullParameter(gridSpanButtons, "$gridSpanButtons");
        Intrinsics.checkNotNullParameter(sortOrderButtons, "$sortOrderButtons");
        Intrinsics.checkNotNullParameter(sizeRangeButtons, "$sizeRangeButtons");
        if (Intrinsics.areEqual(button, dialogBinding.customDate)) {
            this$0.showCustomDatePickerDialog();
        } else {
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.google.android.material.button.MaterialButton");
            showSortDialog$handleButtonSelection(gridSpanButtons, this$0, dialogBinding, sortOrderButtons, dateRangeButtons, sizeRangeButtons, dateRangeButtons, (MaterialButton) view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSortDialog$lambda$24$lambda$23(List sizeRangeButtons, List gridSpanButtons, VideoFilesActivity this$0, DialogSortLayoutBinding dialogBinding, List sortOrderButtons, List dateRangeButtons, View view) {
        Intrinsics.checkNotNullParameter(sizeRangeButtons, "$sizeRangeButtons");
        Intrinsics.checkNotNullParameter(gridSpanButtons, "$gridSpanButtons");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialogBinding, "$dialogBinding");
        Intrinsics.checkNotNullParameter(sortOrderButtons, "$sortOrderButtons");
        Intrinsics.checkNotNullParameter(dateRangeButtons, "$dateRangeButtons");
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.google.android.material.button.MaterialButton");
        showSortDialog$handleButtonSelection(gridSpanButtons, this$0, dialogBinding, sortOrderButtons, dateRangeButtons, sizeRangeButtons, sizeRangeButtons, (MaterialButton) view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSortDialog$lambda$25(VideoFilesActivity this$0, BottomSheetDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        this$0.applyFilters();
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSortDialog$lambda$30(VideoFilesActivity this$0, List gridSpanButtons, List sortOrderButtons, List dateRangeButtons, List sizeRangeButtons, BottomSheetDialog dialog, DialogSortLayoutBinding dialogBinding, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(gridSpanButtons, "$gridSpanButtons");
        Intrinsics.checkNotNullParameter(sortOrderButtons, "$sortOrderButtons");
        Intrinsics.checkNotNullParameter(dateRangeButtons, "$dateRangeButtons");
        Intrinsics.checkNotNullParameter(sizeRangeButtons, "$sizeRangeButtons");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(dialogBinding, "$dialogBinding");
        this$0.resetFilters();
        Iterator it = gridSpanButtons.iterator();
        while (it.hasNext()) {
            MaterialButton materialButton = (MaterialButton) it.next();
            Intrinsics.checkNotNull(materialButton);
            this$0.updateButtonSelection(materialButton, Intrinsics.areEqual(materialButton, dialogBinding.btnGrid3));
        }
        Iterator it2 = sortOrderButtons.iterator();
        while (it2.hasNext()) {
            MaterialButton materialButton2 = (MaterialButton) it2.next();
            Intrinsics.checkNotNull(materialButton2);
            this$0.updateButtonSelection(materialButton2, false);
        }
        Iterator it3 = dateRangeButtons.iterator();
        while (it3.hasNext()) {
            MaterialButton materialButton3 = (MaterialButton) it3.next();
            Intrinsics.checkNotNull(materialButton3);
            this$0.updateButtonSelection(materialButton3, Intrinsics.areEqual(materialButton3, dialogBinding.allDateBy));
        }
        Iterator it4 = sizeRangeButtons.iterator();
        while (it4.hasNext()) {
            MaterialButton materialButton4 = (MaterialButton) it4.next();
            Intrinsics.checkNotNull(materialButton4);
            this$0.updateButtonSelection(materialButton4, Intrinsics.areEqual(materialButton4, dialogBinding.allSizeBy));
        }
        dialog.dismiss();
    }

    private final void preselectFilterButtons(DialogSortLayoutBinding dialogBinding) {
        int i = this.currentGridSpan;
        if (i == 2) {
            MaterialButton btnGrid2 = dialogBinding.btnGrid2;
            Intrinsics.checkNotNullExpressionValue(btnGrid2, "btnGrid2");
            updateButtonSelection(btnGrid2, true);
        } else if (i == 3) {
            MaterialButton btnGrid3 = dialogBinding.btnGrid3;
            Intrinsics.checkNotNullExpressionValue(btnGrid3, "btnGrid3");
            updateButtonSelection(btnGrid3, true);
        } else if (i == 4) {
            MaterialButton btnGrid4 = dialogBinding.btnGrid4;
            Intrinsics.checkNotNullExpressionValue(btnGrid4, "btnGrid4");
            updateButtonSelection(btnGrid4, true);
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[this.selectedSortOrder.ordinal()];
        if (i2 == 1) {
            MaterialButton sizeAsc = dialogBinding.sizeAsc;
            Intrinsics.checkNotNullExpressionValue(sizeAsc, "sizeAsc");
            updateButtonSelection(sizeAsc, true);
        } else if (i2 == 2) {
            MaterialButton sizeDesc = dialogBinding.sizeDesc;
            Intrinsics.checkNotNullExpressionValue(sizeDesc, "sizeDesc");
            updateButtonSelection(sizeDesc, true);
        } else if (i2 == 3) {
            MaterialButton timeOldest = dialogBinding.timeOldest;
            Intrinsics.checkNotNullExpressionValue(timeOldest, "timeOldest");
            updateButtonSelection(timeOldest, true);
        } else if (i2 == 4) {
            MaterialButton timeNewest = dialogBinding.timeNewest;
            Intrinsics.checkNotNullExpressionValue(timeNewest, "timeNewest");
            updateButtonSelection(timeNewest, true);
        } else if (i2 == 5) {
            MaterialButton timeNewest2 = dialogBinding.timeNewest;
            Intrinsics.checkNotNullExpressionValue(timeNewest2, "timeNewest");
            updateButtonSelection(timeNewest2, true);
        }
        int i3 = WhenMappings.$EnumSwitchMapping$1[this.selectedDateRange.ordinal()];
        if (i3 == 1) {
            MaterialButton oneMonth = dialogBinding.oneMonth;
            Intrinsics.checkNotNullExpressionValue(oneMonth, "oneMonth");
            updateButtonSelection(oneMonth, true);
        } else if (i3 == 2) {
            MaterialButton sixMonth = dialogBinding.sixMonth;
            Intrinsics.checkNotNullExpressionValue(sixMonth, "sixMonth");
            updateButtonSelection(sixMonth, true);
        } else if (i3 == 3) {
            MaterialButton oneYear = dialogBinding.oneYear;
            Intrinsics.checkNotNullExpressionValue(oneYear, "oneYear");
            updateButtonSelection(oneYear, true);
        } else if (i3 == 4) {
            MaterialButton customDate = dialogBinding.customDate;
            Intrinsics.checkNotNullExpressionValue(customDate, "customDate");
            updateButtonSelection(customDate, true);
        } else if (i3 == 5) {
            MaterialButton allDateBy = dialogBinding.allDateBy;
            Intrinsics.checkNotNullExpressionValue(allDateBy, "allDateBy");
            updateButtonSelection(allDateBy, true);
        }
        int i4 = WhenMappings.$EnumSwitchMapping$2[this.selectedSizeRange.ordinal()];
        if (i4 == 1) {
            MaterialButton zeroToOne = dialogBinding.zeroToOne;
            Intrinsics.checkNotNullExpressionValue(zeroToOne, "zeroToOne");
            updateButtonSelection(zeroToOne, true);
            return;
        }
        if (i4 == 2) {
            MaterialButton oneToFive = dialogBinding.oneToFive;
            Intrinsics.checkNotNullExpressionValue(oneToFive, "oneToFive");
            updateButtonSelection(oneToFive, true);
            return;
        }
        if (i4 == 3) {
            MaterialButton fiveToTen = dialogBinding.fiveToTen;
            Intrinsics.checkNotNullExpressionValue(fiveToTen, "fiveToTen");
            updateButtonSelection(fiveToTen, true);
        } else if (i4 == 4) {
            MaterialButton moreThanTen = dialogBinding.moreThanTen;
            Intrinsics.checkNotNullExpressionValue(moreThanTen, "moreThanTen");
            updateButtonSelection(moreThanTen, true);
        } else {
            if (i4 != 5) {
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
        ((LinearLayout) inflate.findViewById(R.id.btnOk)).setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.VideoFilesActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoFilesActivity.showCustomDatePickerDialog$lambda$33(datePicker, datePicker2, this, dialog, view);
            }
        });
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.VideoFilesActivity$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoFilesActivity.showCustomDatePickerDialog$lambda$34(dialog, view);
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showCustomDatePickerDialog$lambda$33(DatePicker datePicker, DatePicker datePicker2, VideoFilesActivity this$0, Dialog dialog, View view) {
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
    public static final void showCustomDatePickerDialog$lambda$34(Dialog dialog, View view) {
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
            VideoFilesActivity videoFilesActivity = this;
            button.setTextColor(ContextCompat.getColor(videoFilesActivity, R.color.primary));
            button.setBackgroundColor(ContextCompat.getColor(videoFilesActivity, R.color.next));
        } else {
            VideoFilesActivity videoFilesActivity2 = this;
            button.setTextColor(ContextCompat.getColor(videoFilesActivity2, R.color.button_txt_color));
            button.setBackgroundColor(ContextCompat.getColor(videoFilesActivity2, R.color.feed_btn));
        }
    }

    private final void applyFilters() {
        if (this.isGridSpanSelected) {
            changeGridSpan(this.selectedGridSpan);
        }
        List<VideosModel> sortVideos = sortVideos(filterBySizeRange(filterByDateRange(this.allVideosList, this.selectedDateRange), this.selectedSizeRange), this.selectedSortOrder);
        VideosAdapter videosAdapter = this.videosAdapter;
        if (videosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videosAdapter");
            videosAdapter = null;
        }
        videosAdapter.updateVideos(sortVideos, sortVideos.size());
        updateSelectionUI();
        updateEmptyView();
        this.isGridSpanSelected = false;
    }

    private final List<VideosModel> filterByDateRange(List<VideosModel> videos, DateRange dateRange) {
        Date date;
        Date date2;
        Date date3 = new Date();
        int i = WhenMappings.$EnumSwitchMapping$1[dateRange.ordinal()];
        if (i == 1) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : videos) {
                if (((VideosModel) obj).getDateAdded().after(new Date(date3.getTime() - 2592000000L))) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }
        if (i == 2) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : videos) {
                if (((VideosModel) obj2).getDateAdded().after(new Date(date3.getTime() - 15552000000L))) {
                    arrayList2.add(obj2);
                }
            }
            return arrayList2;
        }
        if (i == 3) {
            ArrayList arrayList3 = new ArrayList();
            for (Object obj3 : videos) {
                if (((VideosModel) obj3).getDateAdded().after(new Date(date3.getTime() - 31536000000L))) {
                    arrayList3.add(obj3);
                }
            }
            return arrayList3;
        }
        if (i != 4 || (date = this.customStartDate) == null || (date2 = this.customEndDate) == null) {
            return videos;
        }
        ArrayList arrayList4 = new ArrayList();
        for (Object obj4 : videos) {
            VideosModel videosModel = (VideosModel) obj4;
            if (videosModel.getDateAdded().after(date) && videosModel.getDateAdded().before(date2)) {
                arrayList4.add(obj4);
            }
        }
        return arrayList4;
    }

    private final List<VideosModel> filterBySizeRange(List<VideosModel> videos, SizeRange sizeRange) {
        int i = WhenMappings.$EnumSwitchMapping$2[sizeRange.ordinal()];
        if (i == 1) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : videos) {
                if (((VideosModel) obj).getSize() <= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }
        if (i == 2) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : videos) {
                VideosModel videosModel = (VideosModel) obj2;
                if (videosModel.getSize() > PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED && videosModel.getSize() <= CacheDataSink.DEFAULT_FRAGMENT_SIZE) {
                    arrayList2.add(obj2);
                }
            }
            return arrayList2;
        }
        if (i != 3) {
            if (i != 4) {
                return videos;
            }
            ArrayList arrayList3 = new ArrayList();
            for (Object obj3 : videos) {
                if (((VideosModel) obj3).getSize() > 10485760) {
                    arrayList3.add(obj3);
                }
            }
            return arrayList3;
        }
        ArrayList arrayList4 = new ArrayList();
        for (Object obj4 : videos) {
            VideosModel videosModel2 = (VideosModel) obj4;
            if (videosModel2.getSize() > CacheDataSink.DEFAULT_FRAGMENT_SIZE && videosModel2.getSize() <= 10485760) {
                arrayList4.add(obj4);
            }
        }
        return arrayList4;
    }

    private final List<VideosModel> sortVideos(List<VideosModel> videos, SortOrder sortOrder) {
        int i = WhenMappings.$EnumSwitchMapping$0[sortOrder.ordinal()];
        if (i == 1) {
            return CollectionsKt.sortedWith(videos, new Comparator() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.VideoFilesActivity$sortVideos$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Long.valueOf(((VideosModel) t).getSize()), Long.valueOf(((VideosModel) t2).getSize()));
                }
            });
        }
        if (i == 2) {
            return CollectionsKt.sortedWith(videos, new Comparator() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.VideoFilesActivity$sortVideos$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Long.valueOf(((VideosModel) t2).getSize()), Long.valueOf(((VideosModel) t).getSize()));
                }
            });
        }
        if (i != 3) {
            return i != 4 ? videos : CollectionsKt.sortedWith(videos, new Comparator() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.VideoFilesActivity$sortVideos$$inlined$sortedByDescending$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(((VideosModel) t2).getDateAdded(), ((VideosModel) t).getDateAdded());
                }
            });
        }
        return CollectionsKt.sortedWith(videos, new Comparator() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.VideoFilesActivity$sortVideos$$inlined$sortedBy$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((VideosModel) t).getDateAdded(), ((VideosModel) t2).getDateAdded());
            }
        });
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: VideoFilesActivity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/activity/VideoFilesActivity$SortOrder;", "", "(Ljava/lang/String;I)V", "NONE", "SIZE_ASC", "SIZE_DESC", "TIME_ASC", "TIME_DESC", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
    /* compiled from: VideoFilesActivity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/activity/VideoFilesActivity$DateRange;", "", "(Ljava/lang/String;I)V", "NONE", "ONE_MONTH", "SIX_MONTHS", "ONE_YEAR", "CUSTOM", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
    /* compiled from: VideoFilesActivity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/activity/VideoFilesActivity$SizeRange;", "", "(Ljava/lang/String;I)V", "NONE", "ZERO_TO_ONE", "ONE_TO_FIVE", "FIVE_TO_TEN", "MORE_THAN_TEN", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    private final void changeGridSpan(int spanCount) {
        if (this.currentGridSpan != spanCount) {
            this.currentGridSpan = spanCount;
            saveGridSpan(spanCount);
            updateRecyclerViewGridSpan();
        }
    }

    private final void saveGridSpan(int spanCount) {
        getPreferences(0).edit().putInt("GRID_SPAN", spanCount).apply();
    }

    private final void updateRecyclerViewGridSpan() {
        ActivityVideoFilesBinding activityVideoFilesBinding = this.videoFilesBinding;
        VideosAdapter videosAdapter = null;
        RecyclerView recyclerView = activityVideoFilesBinding != null ? activityVideoFilesBinding.recyclerView : null;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new GridLayoutManager(this, this.currentGridSpan));
        }
        VideosAdapter videosAdapter2 = this.videosAdapter;
        if (videosAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videosAdapter");
        } else {
            videosAdapter = videosAdapter2;
        }
        videosAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateEmptyView() {
        AppCompatImageView appCompatImageView;
        VideosAdapter videosAdapter = this.videosAdapter;
        if (videosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videosAdapter");
            videosAdapter = null;
        }
        if (videosAdapter.getItemCount() == 0) {
            ActivityVideoFilesBinding activityVideoFilesBinding = this.videoFilesBinding;
            RecyclerView recyclerView = activityVideoFilesBinding != null ? activityVideoFilesBinding.recyclerView : null;
            if (recyclerView != null) {
                recyclerView.setVisibility(View.GONE);
            }
            ActivityVideoFilesBinding activityVideoFilesBinding2 = this.videoFilesBinding;
            appCompatImageView = activityVideoFilesBinding2 != null ? activityVideoFilesBinding2.ivError : null;
            if (appCompatImageView == null) {
                return;
            }
            appCompatImageView.setVisibility(View.VISIBLE);
            return;
        }
        ActivityVideoFilesBinding activityVideoFilesBinding3 = this.videoFilesBinding;
        RecyclerView recyclerView2 = activityVideoFilesBinding3 != null ? activityVideoFilesBinding3.recyclerView : null;
        if (recyclerView2 != null) {
            recyclerView2.setVisibility(View.VISIBLE);
        }
        ActivityVideoFilesBinding activityVideoFilesBinding4 = this.videoFilesBinding;
        appCompatImageView = activityVideoFilesBinding4 != null ? activityVideoFilesBinding4.ivError : null;
        if (appCompatImageView == null) {
            return;
        }
        appCompatImageView.setVisibility(View.GONE);
    }

    private final void setupRecyclerView() {
        RecyclerView recyclerView;
        this.videosAdapter = new VideosAdapter(new ArrayList(), new VideoFilesActivity$setupRecyclerView$1(this), new VideoFilesActivity$setupRecyclerView$2(this), new VideoFilesActivity$setupRecyclerView$3(this), this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, this.currentGridSpan);
        ActivityVideoFilesBinding activityVideoFilesBinding = this.videoFilesBinding;
        if (activityVideoFilesBinding == null || (recyclerView = activityVideoFilesBinding.recyclerView) == null) {
            return;
        }
        recyclerView.setLayoutManager(gridLayoutManager);
        VideosAdapter videosAdapter = this.videosAdapter;
        if (videosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videosAdapter");
            videosAdapter = null;
        }
        recyclerView.setAdapter(videosAdapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.VideoFilesActivity$setupRecyclerView$4$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView2, int dx, int dy) {
                boolean z;
                Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
                Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
                GridLayoutManager gridLayoutManager2 = (GridLayoutManager) layoutManager;
                z = VideoFilesActivity.this.isLoading;
                if (z || gridLayoutManager2.findLastVisibleItemPosition() != gridLayoutManager2.getItemCount() - 1) {
                    return;
                }
                VideoFilesActivity.this.loadMoreVideos();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSelectionChanged(boolean isAllSelected) {
        TextView textView;
        AppCompatImageView appCompatImageView;
        TextView textView2;
        AppCompatImageView appCompatImageView2;
        if (isAllSelected) {
            ActivityVideoFilesBinding activityVideoFilesBinding = this.videoFilesBinding;
            if (activityVideoFilesBinding != null && (appCompatImageView2 = activityVideoFilesBinding.icSelectAll) != null) {
                appCompatImageView2.setImageResource(R.drawable.ic_check);
            }
            ActivityVideoFilesBinding activityVideoFilesBinding2 = this.videoFilesBinding;
            if (activityVideoFilesBinding2 == null || (textView2 = activityVideoFilesBinding2.allSelected) == null) {
                return;
            }
            textView2.setText(R.string.all_deselect);
            return;
        }
        ActivityVideoFilesBinding activityVideoFilesBinding3 = this.videoFilesBinding;
        if (activityVideoFilesBinding3 != null && (appCompatImageView = activityVideoFilesBinding3.icSelectAll) != null) {
            appCompatImageView.setImageResource(R.drawable.ic_dslct);
        }
        ActivityVideoFilesBinding activityVideoFilesBinding4 = this.videoFilesBinding;
        if (activityVideoFilesBinding4 == null || (textView = activityVideoFilesBinding4.allSelected) == null) {
            return;
        }
        textView.setText(R.string.all_select);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onVideoClick(int position) {
        VideosAdapter videosAdapter = this.videosAdapter;
        VideosAdapter videosAdapter2 = null;
        if (videosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videosAdapter");
            videosAdapter = null;
        }
        if (videosAdapter.getSelectedItemCount() <= 0) {
            VideosAdapter videosAdapter3 = this.videosAdapter;
            if (videosAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videosAdapter");
                videosAdapter3 = null;
            }
            if (!videosAdapter3.getIsAllSelected()) {
                VideosAdapter videosAdapter4 = this.videosAdapter;
                if (videosAdapter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("videosAdapter");
                } else {
                    videosAdapter2 = videosAdapter4;
                }
                VideosModel itemAtPosition = videosAdapter2.getItemAtPosition(position);
                Intent intent = new Intent(this, (Class<?>) ViewVideoActivity.class);
                intent.putExtra("VIDEO_PATH", itemAtPosition.getFile().getAbsolutePath());
                intent.putExtra("FILE_TYPE", "video");
                startActivity(intent);
                return;
            }
        }
        toggleSelection(position);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onVideoLongClick(int position) {
        toggleSelection(position);
    }

    private final void toggleSelection(int position) {
        VideosAdapter videosAdapter = this.videosAdapter;
        if (videosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videosAdapter");
            videosAdapter = null;
        }
        videosAdapter.toggleSelection(position);
        VideosAdapter videosAdapter2 = this.videosAdapter;
        if (videosAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videosAdapter");
            videosAdapter2 = null;
        }
        int selectedItemCount = videosAdapter2.getSelectedItemCount();
        if (selectedItemCount > 0) {
            ActivityVideoFilesBinding activityVideoFilesBinding = this.videoFilesBinding;
            LinearLayout linearLayout = activityVideoFilesBinding != null ? activityVideoFilesBinding.llSelection : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(View.VISIBLE);
            }
            ActivityVideoFilesBinding activityVideoFilesBinding2 = this.videoFilesBinding;
            LinearLayout linearLayout2 = activityVideoFilesBinding2 != null ? activityVideoFilesBinding2.headerLayout : null;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(View.GONE);
            }
            ActivityVideoFilesBinding activityVideoFilesBinding3 = this.videoFilesBinding;
            TextView textView = activityVideoFilesBinding3 != null ? activityVideoFilesBinding3.tvRecover : null;
            if (textView == null) {
                return;
            }
            textView.setText("Recover (" + selectedItemCount + ')');
            return;
        }
        ActivityVideoFilesBinding activityVideoFilesBinding4 = this.videoFilesBinding;
        LinearLayout linearLayout3 = activityVideoFilesBinding4 != null ? activityVideoFilesBinding4.headerLayout : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(View.VISIBLE);
        }
        ActivityVideoFilesBinding activityVideoFilesBinding5 = this.videoFilesBinding;
        LinearLayout linearLayout4 = activityVideoFilesBinding5 != null ? activityVideoFilesBinding5.llSelection : null;
        if (linearLayout4 == null) {
            return;
        }
        linearLayout4.setVisibility(View.GONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadMoreVideos() {
        int i = this.currentPage * this.pageSize;
        if (i >= this.allVideosList.size()) {
            return;
        }
        this.isLoading = true;
        List<VideosModel> list = this.allVideosList;
        List<VideosModel> subList = list.subList(i, Math.min(this.pageSize + i, list.size()));
        VideosAdapter videosAdapter = this.videosAdapter;
        if (videosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videosAdapter");
            videosAdapter = null;
        }
        videosAdapter.addVideos(subList, this.allVideosList.size());
        Iterator<T> it = this.allVideosList.subList(i, Math.min(this.pageSize + i, this.allVideosList.size())).iterator();
        while (it.hasNext()) {
            loadVideoDurationAsync((VideosModel) it.next());
        }
        int i2 = this.currentPage + 1;
        this.currentPage = i2;
        this.isLoading = false;
        if (i2 * this.pageSize < this.allVideosList.size()) {
            this.handler.post(new Runnable() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.VideoFilesActivity$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    VideoFilesActivity.loadMoreVideos$lambda$50(VideoFilesActivity.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadMoreVideos$lambda$50(VideoFilesActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.loadMoreVideos();
    }

    private final void selectAllVideos() {
        VideosAdapter videosAdapter = this.videosAdapter;
        if (videosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videosAdapter");
            videosAdapter = null;
        }
        videosAdapter.selectAll();
        updateSelectionUI();
    }

    private final void deselectAllVideos() {
        VideosAdapter videosAdapter = this.videosAdapter;
        if (videosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videosAdapter");
            videosAdapter = null;
        }
        videosAdapter.deselectAll();
        updateSelectionUI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSelectionUI() {
        int selectedItemCount;
        VideosAdapter videosAdapter = this.videosAdapter;
        if (videosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videosAdapter");
            videosAdapter = null;
        }
        if (videosAdapter.getIsAllSelected()) {
            VideosAdapter videosAdapter2 = this.videosAdapter;
            if (videosAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videosAdapter");
                videosAdapter2 = null;
            }
            selectedItemCount = videosAdapter2.getTotalItemCount();
        } else {
            VideosAdapter videosAdapter3 = this.videosAdapter;
            if (videosAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videosAdapter");
                videosAdapter3 = null;
            }
            selectedItemCount = videosAdapter3.getSelectedItemCount();
        }
        if (selectedItemCount > 0) {
            ActivityVideoFilesBinding activityVideoFilesBinding = this.videoFilesBinding;
            LinearLayout linearLayout = activityVideoFilesBinding != null ? activityVideoFilesBinding.llSelection : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(View.VISIBLE);
            }
            ActivityVideoFilesBinding activityVideoFilesBinding2 = this.videoFilesBinding;
            LinearLayout linearLayout2 = activityVideoFilesBinding2 != null ? activityVideoFilesBinding2.headerLayout : null;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(View.GONE);
            }
            ActivityVideoFilesBinding activityVideoFilesBinding3 = this.videoFilesBinding;
            TextView textView = activityVideoFilesBinding3 != null ? activityVideoFilesBinding3.tvRecover : null;
            if (textView == null) {
                return;
            }
            textView.setText("Recover (" + selectedItemCount + ')');
            return;
        }
        ActivityVideoFilesBinding activityVideoFilesBinding4 = this.videoFilesBinding;
        LinearLayout linearLayout3 = activityVideoFilesBinding4 != null ? activityVideoFilesBinding4.headerLayout : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(View.VISIBLE);
        }
        ActivityVideoFilesBinding activityVideoFilesBinding5 = this.videoFilesBinding;
        LinearLayout linearLayout4 = activityVideoFilesBinding5 != null ? activityVideoFilesBinding5.llSelection : null;
        if (linearLayout4 == null) {
            return;
        }
        linearLayout4.setVisibility(View.GONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object fetchAllVideos(List<String> list, Continuation<? super List<VideosModel>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new VideoFilesActivity$fetchAllVideos$2(list, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object fetchVideosFromAlbum(String str, Continuation<? super List<VideosModel>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new VideoFilesActivity$fetchVideosFromAlbum$2(str, this, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isValidVideo(File file) {
        if (file.isDirectory()) {
            return false;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            byte[] bArr = new byte[8];
            fileInputStream.read(bArr);
            String joinToString$default = ArraysKt.joinToString$default(bArr, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) new Function1<Byte, CharSequence>() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.VideoFilesActivity$isValidVideo$header$1$1
                public final CharSequence invoke(byte b) {
                    String format = String.format("%02X", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                    return format;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ CharSequence invoke(Byte b) {
                    return invoke(b.byteValue());
                }
            }, 30, (Object) null);
            CloseableKt.closeFinally(fileInputStream, null);
            if (StringsKt.equals(FilesKt.getExtension(file), "m4a", true) || StringsKt.equals(FilesKt.getExtension(file), "heic", true) || StringsKt.equals(FilesKt.getExtension(file), "webp", true) || StringsKt.equals(FilesKt.getExtension(file), "mp3", true) || StringsKt.equals(FilesKt.getExtension(file), "jpg", true)) {
                return false;
            }
            return StringsKt.startsWith$default(joinToString$default, "000001BA", false, 2, (Object) null) || StringsKt.startsWith$default(joinToString$default, "000001B3", false, 2, (Object) null) || StringsKt.startsWith$default(joinToString$default, "00000018", false, 2, (Object) null) || StringsKt.startsWith$default(joinToString$default, "00000020", false, 2, (Object) null) || StringsKt.startsWith$default(joinToString$default, "66747970", false, 2, (Object) null) || StringsKt.startsWith$default(joinToString$default, "1A45DFA3", false, 2, (Object) null) || (StringsKt.startsWith$default(joinToString$default, "52494646", false, 2, (Object) null) && StringsKt.equals(FilesKt.getExtension(file), "avi", true)) || StringsKt.startsWith$default(joinToString$default, "00000014", false, 2, (Object) null) || StringsKt.startsWith$default(joinToString$default, "464C5601", false, 2, (Object) null) || StringsKt.startsWith$default(joinToString$default, "3026B2758E66CF11", false, 2, (Object) null) || StringsKt.startsWith$default(joinToString$default, "0000001C", false, 2, (Object) null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(fileInputStream, th);
                throw th2;
            }
        }
    }

    private final void loadVideoDurationAsync(final VideosModel videoModel) {
        new Thread(new Runnable() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.VideoFilesActivity$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                VideoFilesActivity.loadVideoDurationAsync$lambda$53(VideoFilesActivity.this, videoModel);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadVideoDurationAsync$lambda$53(final VideoFilesActivity this$0, final VideosModel videoModel) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(videoModel, "$videoModel");
        final long videoDuration = this$0.getVideoDuration(videoModel.getFile());
        this$0.runOnUiThread(new Runnable() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.VideoFilesActivity$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                VideoFilesActivity.loadVideoDurationAsync$lambda$53$lambda$52(VideosModel.this, videoDuration, this$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadVideoDurationAsync$lambda$53$lambda$52(VideosModel videoModel, long j, VideoFilesActivity this$0) {
        Intrinsics.checkNotNullParameter(videoModel, "$videoModel");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        videoModel.setDuration(j);
        VideosAdapter videosAdapter = this$0.videosAdapter;
        if (videosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videosAdapter");
            videosAdapter = null;
        }
        videosAdapter.updateVideo(videoModel);
    }

    private final long getVideoDuration(File file) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        long j = 0;
        try {
            mediaMetadataRetriever.setDataSource(file.getAbsolutePath());
            String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
            if (extractMetadata != null) {
                j = Long.parseLong(extractMetadata);
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            mediaMetadataRetriever.release();
            throw th;
        }
        mediaMetadataRetriever.release();
        return j;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        VideosAdapter videosAdapter = this.videosAdapter;
        if (videosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videosAdapter");
            videosAdapter = null;
        }
        if (videosAdapter.getSelectedItemCount() > 0) {
            deselectAllVideos();
        } else {
            super.onBackPressed();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.videoFilesBinding = null;
        this.handler.removeCallbacksAndMessages(null);
    }
}
