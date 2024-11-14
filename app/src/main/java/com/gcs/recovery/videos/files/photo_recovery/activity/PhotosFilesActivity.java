package com.gcs.recovery.videos.files.photo_recovery.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.ShareInternalUtility;
import com.demo.example.R;
import com.gcs.recovery.videos.files.photo_recovery.adapter.PhotosAdapter;
import com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass;
import com.demo.example.databinding.ActivityPhotosFilesBinding;
import com.demo.example.databinding.DialogSortLayoutBinding;
import com.gcs.recovery.videos.files.photo_recovery.model.PhotosModel;
import com.gcs.recovery.videos.files.photo_recovery.utils.FileUtils;
import com.gcs.recovery.videos.files.photo_recovery.utils.SharedDataHolder;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.button.MaterialButton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
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






/* compiled from: PhotosFilesActivity.kt */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0003`abB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0002J \u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0007H\u0002J\u0010\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020\u0007H\u0002J\u0016\u0010*\u001a\u00020!2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\b\u0010,\u001a\u00020!H\u0002J%\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0004H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010/J!\u00100\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u00101\u001a\u0004\u0018\u00010\u001aH\u0082@ø\u0001\u0000¢\u0006\u0002\u00102J$\u00103\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u00105\u001a\u00020\u0017H\u0002J$\u00106\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u00107\u001a\u00020\u001dH\u0002J\u0010\u00108\u001a\u00020\u001a2\u0006\u00109\u001a\u00020:H\u0002J\u0010\u0010;\u001a\u00020\u000f2\u0006\u00109\u001a\u00020:H\u0002J\u0010\u0010<\u001a\u00020\u000f2\u0006\u00109\u001a\u00020:H\u0002J\u001b\u0010=\u001a\u00020!2\b\u0010>\u001a\u0004\u0018\u00010\u001aH\u0082@ø\u0001\u0000¢\u0006\u0002\u00102J\b\u0010?\u001a\u00020!H\u0002J\b\u0010@\u001a\u00020!H\u0016J\u0012\u0010A\u001a\u00020!2\b\u0010B\u001a\u0004\u0018\u00010CH\u0014J\b\u0010D\u001a\u00020!H\u0014J\u0010\u0010E\u001a\u00020!2\u0006\u0010F\u001a\u00020\u0007H\u0002J\u0010\u0010G\u001a\u00020!2\u0006\u0010F\u001a\u00020\u0007H\u0002J\u0010\u0010H\u001a\u00020!2\u0006\u0010I\u001a\u00020\u000fH\u0002J\u0010\u0010J\u001a\u00020!2\u0006\u0010K\u001a\u00020LH\u0002J\u0010\u0010M\u001a\u00020!2\u0006\u0010N\u001a\u00020\u0005H\u0002J\b\u0010O\u001a\u00020!H\u0003J\b\u0010P\u001a\u00020!H\u0002J\u0010\u0010Q\u001a\u00020!2\u0006\u0010)\u001a\u00020\u0007H\u0002J\b\u0010R\u001a\u00020!H\u0002J\b\u0010S\u001a\u00020!H\u0002J\b\u0010T\u001a\u00020!H\u0002J\b\u0010U\u001a\u00020!H\u0002J$\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010W\u001a\u00020\u001fH\u0002J\u0010\u0010X\u001a\u00020!2\u0006\u0010F\u001a\u00020\u0007H\u0003J\u0018\u0010Y\u001a\u00020!2\u0006\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020\u000fH\u0002J\b\u0010]\u001a\u00020!H\u0002J\b\u0010^\u001a\u00020!H\u0002J\b\u0010_\u001a\u00020!H\u0003R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006c"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/activity/PhotosFilesActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "allPhotosList", "", "Lcom/gcs/recovery/videos/files/photo_recovery/model/PhotosModel;", "currentGridSpan", "", "currentPage", "customEndDate", "Ljava/util/Date;", "customStartDate", "handler", "Landroid/os/Handler;", "isGridSpanSelected", "", "isLoading", "pageSize", "photoFilesBinding", "Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ActivityPhotosFilesBinding;", "photosAdapter", "Lcom/gcs/recovery/videos/files/photo_recovery/adapter/PhotosAdapter;", "selectedDateRange", "Lcom/gcs/recovery/videos/files/photo_recovery/activity/PhotosFilesActivity$DateRange;", "selectedFilterTypes", "", "", "selectedGridSpan", "selectedSizeRange", "Lcom/gcs/recovery/videos/files/photo_recovery/activity/PhotosFilesActivity$SizeRange;", "selectedSortOrder", "Lcom/gcs/recovery/videos/files/photo_recovery/activity/PhotosFilesActivity$SortOrder;", "applyCustomDateRangeFilter", "", "applyFilters", "calculateInSampleSize", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "Landroid/graphics/BitmapFactory$Options;", "reqWidth", "reqHeight", "changeGridSpan", "spanCount", "deleteSelectedItems", FirebaseAnalytics.Param.ITEMS, "deselectAllPhotos", "fetchAllPhotos", "photoPaths", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchPhotosFromAlbum", "folderPath", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "filterByDateRange", "photos", "dateRange", "filterBySizeRange", "sizeRange", "getFileSignature", ShareInternalUtility.STAGING_PARAM, "Ljava/io/File;", "isImageWithoutExtension", "isValidImage", "loadAlbumPhotos", "albumPath", "loadMorePhotos", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPhotoClick", "position", "onPhotoLongClick", "onSelectionChanged", "isAllSelected", "preselectFilterButtons", "dialogBinding", "Lcom/gcs/recovery/videos/files/photo_recovery/databinding/DialogSortLayoutBinding;", "recoverItem", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO, "recoverSelectedImages", "resetFilters", "saveGridSpan", "selectAllPhotos", "setupRecyclerView", "showCustomDatePickerDialog", "showSortDialog", "sortPhotos", SDKConstants.PARAM_SORT_ORDER, "toggleSelection", "updateButtonSelection", "button", "Lcom/google/android/material/button/MaterialButton;", "isSelected", "updateEmptyView", "updateRecyclerViewGridSpan", "updateSelectionUI", "DateRange", "SizeRange", "SortOrder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PhotosFilesActivity extends AppCompatActivity {
    private int currentPage;
    private Date customEndDate;
    private Date customStartDate;
    private boolean isGridSpanSelected;
    private boolean isLoading;
    private ActivityPhotosFilesBinding photoFilesBinding;
    private PhotosAdapter photosAdapter;
    private List<PhotosModel> allPhotosList = CollectionsKt.emptyList();
    private final int pageSize = 20;
    private int currentGridSpan = 3;
    private Handler handler = new Handler(Looper.getMainLooper());
    private final List<String> selectedFilterTypes = new ArrayList();
    private int selectedGridSpan = this.currentGridSpan;
    private SortOrder selectedSortOrder = SortOrder.NONE;
    private DateRange selectedDateRange = DateRange.NONE;
    private SizeRange selectedSizeRange = SizeRange.NONE;

    /* compiled from: PhotosFilesActivity.kt */
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
        ActivityPhotosFilesBinding inflate = ActivityPhotosFilesBinding.inflate(getLayoutInflater());
        this.photoFilesBinding = inflate;
        Intrinsics.checkNotNull(inflate);
        setContentView(inflate.getRoot());
        FileUtils.INSTANCE.createAppFolders(this);
        AdsClass adsClass = new AdsClass();
        ActivityPhotosFilesBinding activityPhotosFilesBinding = this.photoFilesBinding;
        Intrinsics.checkNotNull(activityPhotosFilesBinding);
        adsClass.refreshAd(activityPhotosFilesBinding.frameLayout, this, 2);
        this.selectedGridSpan = this.currentGridSpan;
        this.selectedSortOrder = SortOrder.NONE;
        this.selectedDateRange = DateRange.NONE;
        this.selectedSizeRange = SizeRange.NONE;
        String stringExtra = getIntent().getStringExtra("ALBUM_TITLE");
        if (stringExtra == null) {
            stringExtra = "Photos";
        }
        ActivityPhotosFilesBinding activityPhotosFilesBinding2 = this.photoFilesBinding;
        TextView textView2 = activityPhotosFilesBinding2 != null ? activityPhotosFilesBinding2.txtTitle : null;
        if (textView2 != null) {
            textView2.setText(stringExtra);
        }
        this.currentGridSpan = getPreferences(0).getInt("GRID_SPAN", 3);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new PhotosFilesActivity$onCreate$1(this, getIntent().getStringExtra("ALBUM_PATH"), null), 3, null);
        setupRecyclerView();
        ActivityPhotosFilesBinding activityPhotosFilesBinding3 = this.photoFilesBinding;
        if (activityPhotosFilesBinding3 != null && (appCompatImageView4 = activityPhotosFilesBinding3.icBack) != null) {
            appCompatImageView4.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PhotosFilesActivity$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PhotosFilesActivity.onCreate$lambda$0(PhotosFilesActivity.this, view);
                }
            });
        }
        ActivityPhotosFilesBinding activityPhotosFilesBinding4 = this.photoFilesBinding;
        if (activityPhotosFilesBinding4 != null && (appCompatImageView3 = activityPhotosFilesBinding4.icMenu) != null) {
            appCompatImageView3.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PhotosFilesActivity$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PhotosFilesActivity.onCreate$lambda$1(PhotosFilesActivity.this, view);
                }
            });
        }
        ActivityPhotosFilesBinding activityPhotosFilesBinding5 = this.photoFilesBinding;
        if (activityPhotosFilesBinding5 != null && (linearLayout = activityPhotosFilesBinding5.llSelection) != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PhotosFilesActivity$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PhotosFilesActivity.onCreate$lambda$2(PhotosFilesActivity.this, view);
                }
            });
        }
        ActivityPhotosFilesBinding activityPhotosFilesBinding6 = this.photoFilesBinding;
        if (activityPhotosFilesBinding6 != null && (appCompatImageView2 = activityPhotosFilesBinding6.icSelectAll) != null) {
            appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PhotosFilesActivity$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PhotosFilesActivity.onCreate$lambda$3(PhotosFilesActivity.this, view);
                }
            });
        }
        ActivityPhotosFilesBinding activityPhotosFilesBinding7 = this.photoFilesBinding;
        if (activityPhotosFilesBinding7 != null && (appCompatImageView = activityPhotosFilesBinding7.icDelete) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PhotosFilesActivity$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PhotosFilesActivity.onCreate$lambda$4(PhotosFilesActivity.this, view);
                }
            });
        }
        ActivityPhotosFilesBinding activityPhotosFilesBinding8 = this.photoFilesBinding;
        if (activityPhotosFilesBinding8 == null || (textView = activityPhotosFilesBinding8.tvRecover) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PhotosFilesActivity$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhotosFilesActivity.onCreate$lambda$6(PhotosFilesActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(PhotosFilesActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(PhotosFilesActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showSortDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(PhotosFilesActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PhotosAdapter photosAdapter = this$0.photosAdapter;
        if (photosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photosAdapter");
            photosAdapter = null;
        }
        photosAdapter.getSelectedItemCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(PhotosFilesActivity this$0, View view) {
        TextView textView;
        AppCompatImageView appCompatImageView;
        TextView textView2;
        AppCompatImageView appCompatImageView2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PhotosAdapter photosAdapter = this$0.photosAdapter;
        PhotosAdapter photosAdapter2 = null;
        if (photosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photosAdapter");
            photosAdapter = null;
        }
        int selectedItemCount = photosAdapter.getSelectedItemCount();
        PhotosAdapter photosAdapter3 = this$0.photosAdapter;
        if (photosAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photosAdapter");
        } else {
            photosAdapter2 = photosAdapter3;
        }
        if (selectedItemCount == photosAdapter2.getItemCount()) {
            this$0.deselectAllPhotos();
            ActivityPhotosFilesBinding activityPhotosFilesBinding = this$0.photoFilesBinding;
            if (activityPhotosFilesBinding != null && (appCompatImageView2 = activityPhotosFilesBinding.icSelectAll) != null) {
                appCompatImageView2.setImageResource(R.drawable.ic_dslct);
            }
            ActivityPhotosFilesBinding activityPhotosFilesBinding2 = this$0.photoFilesBinding;
            if (activityPhotosFilesBinding2 == null || (textView2 = activityPhotosFilesBinding2.allSelected) == null) {
                return;
            }
            textView2.setText(R.string.all_select);
            return;
        }
        this$0.selectAllPhotos();
        ActivityPhotosFilesBinding activityPhotosFilesBinding3 = this$0.photoFilesBinding;
        if (activityPhotosFilesBinding3 != null && (appCompatImageView = activityPhotosFilesBinding3.icSelectAll) != null) {
            appCompatImageView.setImageResource(R.drawable.ic_check);
        }
        ActivityPhotosFilesBinding activityPhotosFilesBinding4 = this$0.photoFilesBinding;
        if (activityPhotosFilesBinding4 == null || (textView = activityPhotosFilesBinding4.allSelected) == null) {
            return;
        }
        textView.setText(R.string.all_deselect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$4(PhotosFilesActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PhotosAdapter photosAdapter = this$0.photosAdapter;
        if (photosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photosAdapter");
            photosAdapter = null;
        }
        this$0.deleteSelectedItems(photosAdapter.getSelectedItems());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$6(final PhotosFilesActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AdsClass.showInterstitial(this$0, new AdsClass.onListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PhotosFilesActivity$$ExternalSyntheticLambda12
            @Override // com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass.onListener
            public final void click() {
                PhotosFilesActivity.onCreate$lambda$6$lambda$5(PhotosFilesActivity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$6$lambda$5(PhotosFilesActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.recoverSelectedImages();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadAlbumPhotos(String str, Continuation<? super Unit> continuation) {
        PhotosFilesActivity$loadAlbumPhotos$1 photosFilesActivity$loadAlbumPhotos$1;
        int i;
        PhotosFilesActivity photosFilesActivity;
        if (continuation instanceof PhotosFilesActivity$loadAlbumPhotos$1) {
            photosFilesActivity$loadAlbumPhotos$1 = (PhotosFilesActivity$loadAlbumPhotos$1) continuation;
            if ((photosFilesActivity$loadAlbumPhotos$1.label & Integer.MIN_VALUE) != 0) {
                photosFilesActivity$loadAlbumPhotos$1.label -= Integer.MIN_VALUE;
                Object obj = photosFilesActivity$loadAlbumPhotos$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = photosFilesActivity$loadAlbumPhotos$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    MainCoroutineDispatcher main = Dispatchers.getMain();
                    PhotosFilesActivity$loadAlbumPhotos$2 photosFilesActivity$loadAlbumPhotos$2 = new PhotosFilesActivity$loadAlbumPhotos$2(this, null);
                    photosFilesActivity$loadAlbumPhotos$1.L$0 = this;
                    photosFilesActivity$loadAlbumPhotos$1.L$1 = str;
                    photosFilesActivity$loadAlbumPhotos$1.label = 1;
                    if (BuildersKt.withContext(main, photosFilesActivity$loadAlbumPhotos$2, photosFilesActivity$loadAlbumPhotos$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    photosFilesActivity = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    str = (String) photosFilesActivity$loadAlbumPhotos$1.L$1;
                    photosFilesActivity = (PhotosFilesActivity) photosFilesActivity$loadAlbumPhotos$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new PhotosFilesActivity$loadAlbumPhotos$3(photosFilesActivity, str, null), 3, null);
                return Unit.INSTANCE;
            }
        }
        photosFilesActivity$loadAlbumPhotos$1 = new PhotosFilesActivity$loadAlbumPhotos$1(this, continuation);
        Object obj2 = photosFilesActivity$loadAlbumPhotos$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = photosFilesActivity$loadAlbumPhotos$1.label;
        if (i != 0) {
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new PhotosFilesActivity$loadAlbumPhotos$3(photosFilesActivity, str, null), 3, null);
        return Unit.INSTANCE;
    }

    private final void recoverSelectedImages() {
        PhotosAdapter photosAdapter = this.photosAdapter;
        if (photosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photosAdapter");
            photosAdapter = null;
        }
        final List<PhotosModel> selectedItems = photosAdapter.getSelectedItems();
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
        new Thread(new Runnable() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PhotosFilesActivity$$ExternalSyntheticLambda18
            @Override // java.lang.Runnable
            public final void run() {
                PhotosFilesActivity.recoverSelectedImages$lambda$9(selectedItems, this, intRef, textView, progressBar, bottomSheetDialog);
            }
        }).start();
        deselectAllPhotos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void recoverSelectedImages$lambda$9(List selectedItems, final PhotosFilesActivity this$0, final Ref.IntRef recoveredItemCount, final TextView textView, final ProgressBar progressBar, final BottomSheetDialog dialog) {
        Intrinsics.checkNotNullParameter(selectedItems, "$selectedItems");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(recoveredItemCount, "$recoveredItemCount");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Iterator it = selectedItems.iterator();
        final int i = 0;
        while (it.hasNext()) {
            PhotosModel photosModel = (PhotosModel) it.next();
            Thread.sleep(500L);
            this$0.recoverItem(photosModel);
            recoveredItemCount.element++;
            this$0.runOnUiThread(new Runnable() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PhotosFilesActivity$$ExternalSyntheticLambda16
                @Override // java.lang.Runnable
                public final void run() {
                    PhotosFilesActivity.recoverSelectedImages$lambda$9$lambda$7(textView, i, progressBar);
                }
            });
            i++;
        }
        this$0.runOnUiThread(new Runnable() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PhotosFilesActivity$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                PhotosFilesActivity.recoverSelectedImages$lambda$9$lambda$8(BottomSheetDialog.this, this$0, recoveredItemCount);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void recoverSelectedImages$lambda$9$lambda$7(TextView textView, int i, ProgressBar progressBar) {
        int i2 = i + 1;
        textView.setText(String.valueOf(i2));
        progressBar.setProgress(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void recoverSelectedImages$lambda$9$lambda$8(BottomSheetDialog dialog, PhotosFilesActivity this$0, Ref.IntRef recoveredItemCount) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(recoveredItemCount, "$recoveredItemCount");
        dialog.dismiss();
        Intent intent = new Intent(this$0, (Class<?>) SuccessfullyRecoverActivity.class);
        intent.putExtra("RECOVERED_ITEM_COUNT", recoveredItemCount.element);
        intent.putExtra("ITEM_TYPE", "PHOTO");
        this$0.startActivity(intent);
    }

    private final void recoverItem(PhotosModel photo) {
        String str;
        File file = new File(Environment.getExternalStorageDirectory(), "PhotoRecovery/Photos");
        if (!file.exists()) {
            file.mkdirs();
        }
        String name = photo.getFile().getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        if (StringsKt.startsWith$default(name, ".", false, 2, (Object) null)) {
            str = StringsKt.removePrefix(FilesKt.getNameWithoutExtension(photo.getFile()), (CharSequence) ".") + ".jpg";
        } else {
            str = FilesKt.getNameWithoutExtension(photo.getFile()) + ".jpg";
        }
        File file2 = new File(file, str);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(photo.getFile().getAbsolutePath(), options);
        options.inSampleSize = calculateInSampleSize(options, 1080, 1920);
        options.inJustDecodeBounds = false;
        Bitmap decodeFile = BitmapFactory.decodeFile(photo.getFile().getAbsolutePath(), options);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        try {
            FileOutputStream fileOutputStream2 = fileOutputStream;
            if (decodeFile != null) {
                Boolean.valueOf(decodeFile.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream2));
            }
            CloseableKt.closeFinally(fileOutputStream, null);
            MediaScannerConnection.scanFile(this, new String[]{file2.getAbsolutePath()}, null, null);
        } finally {
        }
    }

    private final int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        Pair pair = TuplesKt.to(Integer.valueOf(options.outHeight), Integer.valueOf(options.outWidth));
        int intValue = ((Number) pair.component1()).intValue();
        int intValue2 = ((Number) pair.component2()).intValue();
        int i = 1;
        if (intValue > reqHeight || intValue2 > reqWidth) {
            int i2 = intValue / 2;
            int i3 = intValue2 / 2;
            while (i2 / i >= reqHeight && i3 / i >= reqWidth) {
                i *= 2;
            }
        }
        return i;
    }

    private final void deleteSelectedItems(final List<PhotosModel> items) {
        if (items.isEmpty()) {
            return;
        }
        View inflate = getLayoutInflater().inflate(R.layout.dialog_delete_alert, (ViewGroup) null);
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(inflate);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.iv_no_btn);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.iv_yes_btn);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PhotosFilesActivity$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhotosFilesActivity.deleteSelectedItems$lambda$11(BottomSheetDialog.this, view);
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PhotosFilesActivity$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhotosFilesActivity.deleteSelectedItems$lambda$16(items, bottomSheetDialog, this, view);
            }
        });
        bottomSheetDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteSelectedItems$lambda$11(BottomSheetDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteSelectedItems$lambda$16(List items, BottomSheetDialog dialog, PhotosFilesActivity this$0, View view) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(items, "$items");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List list = items;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((PhotosModel) it.next()).getFile().delete();
        }
        dialog.dismiss();
        this$0.deselectAllPhotos();
        SharedDataHolder sharedDataHolder = SharedDataHolder.INSTANCE;
        List<File> photoFiles = SharedDataHolder.INSTANCE.getPhotoFiles();
        PhotosAdapter photosAdapter = null;
        if (photoFiles != null) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : photoFiles) {
                File file = (File) obj;
                boolean z = false;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator it2 = list.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (Intrinsics.areEqual(((PhotosModel) it2.next()).getFile(), file)) {
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
        sharedDataHolder.setPhotoFiles(arrayList);
        List<PhotosModel> list2 = this$0.allPhotosList;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : list2) {
            if (!items.contains((PhotosModel) obj2)) {
                arrayList3.add(obj2);
            }
        }
        this$0.allPhotosList = arrayList3;
        PhotosAdapter photosAdapter2 = this$0.photosAdapter;
        if (photosAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photosAdapter");
        } else {
            photosAdapter = photosAdapter2;
        }
        List<PhotosModel> list3 = this$0.allPhotosList;
        photosAdapter.updatePhotos(list3, list3.size());
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
            ((MaterialButton) it.next()).setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PhotosFilesActivity$$ExternalSyntheticLambda19
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PhotosFilesActivity.showSortDialog$lambda$19$lambda$18(listOf, this, inflate, listOf2, listOf3, listOf4, view);
                }
            });
        }
        for (Iterator it2 = listOf2.iterator(); it2.hasNext(); it2 = it2) {
            ((MaterialButton) it2.next()).setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PhotosFilesActivity$$ExternalSyntheticLambda20
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PhotosFilesActivity.showSortDialog$lambda$21$lambda$20(listOf2, listOf, this, inflate, listOf3, listOf4, view);
                }
            });
        }
        for (Iterator it3 = listOf3.iterator(); it3.hasNext(); it3 = it3) {
            final MaterialButton materialButton = (MaterialButton) it3.next();
            materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PhotosFilesActivity$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PhotosFilesActivity.showSortDialog$lambda$23$lambda$22(MaterialButton.this, inflate, this, listOf3, listOf, listOf2, listOf4, view);
                }
            });
        }
        Iterator it4 = listOf4.iterator();
        while (it4.hasNext()) {
            ((MaterialButton) it4.next()).setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PhotosFilesActivity$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PhotosFilesActivity.showSortDialog$lambda$25$lambda$24(listOf4, listOf, this, inflate, listOf2, listOf3, view);
                }
            });
        }
        inflate.applyBtn.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PhotosFilesActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhotosFilesActivity.showSortDialog$lambda$26(PhotosFilesActivity.this, bottomSheetDialog, view);
            }
        });
        inflate.resetFilter.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PhotosFilesActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhotosFilesActivity.showSortDialog$lambda$31(PhotosFilesActivity.this, listOf, listOf2, listOf3, listOf4, bottomSheetDialog, inflate, view);
            }
        });
        bottomSheetDialog.show();
    }

    private static final void showSortDialog$handleButtonSelection(List<? extends MaterialButton> list, PhotosFilesActivity photosFilesActivity, DialogSortLayoutBinding dialogSortLayoutBinding, List<? extends MaterialButton> list2, List<? extends MaterialButton> list3, List<? extends MaterialButton> list4, List<? extends MaterialButton> list5, MaterialButton materialButton) {
        SizeRange sizeRange;
        DateRange dateRange;
        SortOrder sortOrder;
        int i;
        for (MaterialButton materialButton2 : list5) {
            photosFilesActivity.updateButtonSelection(materialButton2, Intrinsics.areEqual(materialButton2, materialButton));
        }
        if (Intrinsics.areEqual(list5, list)) {
            if (Intrinsics.areEqual(materialButton, dialogSortLayoutBinding.btnGrid2)) {
                i = 2;
            } else if (Intrinsics.areEqual(materialButton, dialogSortLayoutBinding.btnGrid3)) {
                i = 3;
            } else {
                i = Intrinsics.areEqual(materialButton, dialogSortLayoutBinding.btnGrid4) ? 4 : photosFilesActivity.currentGridSpan;
            }
            photosFilesActivity.selectedGridSpan = i;
            photosFilesActivity.isGridSpanSelected = true;
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
            photosFilesActivity.selectedSortOrder = sortOrder;
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
            photosFilesActivity.selectedDateRange = dateRange;
            if (Intrinsics.areEqual(materialButton, dialogSortLayoutBinding.customDate)) {
                photosFilesActivity.showCustomDatePickerDialog();
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
            photosFilesActivity.selectedSizeRange = sizeRange;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSortDialog$lambda$19$lambda$18(List gridSpanButtons, PhotosFilesActivity this$0, DialogSortLayoutBinding dialogBinding, List sortOrderButtons, List dateRangeButtons, List sizeRangeButtons, View view) {
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
    public static final void showSortDialog$lambda$21$lambda$20(List sortOrderButtons, List gridSpanButtons, PhotosFilesActivity this$0, DialogSortLayoutBinding dialogBinding, List dateRangeButtons, List sizeRangeButtons, View view) {
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
    public static final void showSortDialog$lambda$23$lambda$22(MaterialButton button, DialogSortLayoutBinding dialogBinding, PhotosFilesActivity this$0, List dateRangeButtons, List gridSpanButtons, List sortOrderButtons, List sizeRangeButtons, View view) {
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
    public static final void showSortDialog$lambda$25$lambda$24(List sizeRangeButtons, List gridSpanButtons, PhotosFilesActivity this$0, DialogSortLayoutBinding dialogBinding, List sortOrderButtons, List dateRangeButtons, View view) {
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
    public static final void showSortDialog$lambda$26(PhotosFilesActivity this$0, BottomSheetDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        this$0.applyFilters();
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSortDialog$lambda$31(PhotosFilesActivity this$0, List gridSpanButtons, List sortOrderButtons, List dateRangeButtons, List sizeRangeButtons, BottomSheetDialog dialog, DialogSortLayoutBinding dialogBinding, View view) {
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
        ((LinearLayout) inflate.findViewById(R.id.btnOk)).setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PhotosFilesActivity$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhotosFilesActivity.showCustomDatePickerDialog$lambda$34(datePicker, datePicker2, this, dialog, view);
            }
        });
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PhotosFilesActivity$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhotosFilesActivity.showCustomDatePickerDialog$lambda$35(dialog, view);
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showCustomDatePickerDialog$lambda$34(DatePicker datePicker, DatePicker datePicker2, PhotosFilesActivity this$0, Dialog dialog, View view) {
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
    public static final void showCustomDatePickerDialog$lambda$35(Dialog dialog, View view) {
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
            PhotosFilesActivity photosFilesActivity = this;
            button.setTextColor(ContextCompat.getColor(photosFilesActivity, R.color.primary));
            button.setBackgroundColor(ContextCompat.getColor(photosFilesActivity, R.color.next));
        } else {
            PhotosFilesActivity photosFilesActivity2 = this;
            button.setTextColor(ContextCompat.getColor(photosFilesActivity2, R.color.button_txt_color));
            button.setBackgroundColor(ContextCompat.getColor(photosFilesActivity2, R.color.feed_btn));
        }
    }

    private final void applyFilters() {
        if (this.isGridSpanSelected) {
            changeGridSpan(this.selectedGridSpan);
        }
        List<PhotosModel> sortPhotos = sortPhotos(filterBySizeRange(filterByDateRange(this.allPhotosList, this.selectedDateRange), this.selectedSizeRange), this.selectedSortOrder);
        PhotosAdapter photosAdapter = this.photosAdapter;
        if (photosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photosAdapter");
            photosAdapter = null;
        }
        photosAdapter.updatePhotos(sortPhotos, sortPhotos.size());
        updateSelectionUI();
        updateEmptyView();
        this.isGridSpanSelected = false;
    }

    private final List<PhotosModel> filterByDateRange(List<PhotosModel> photos, DateRange dateRange) {
        Date date;
        Date date2;
        Date date3 = new Date();
        int i = WhenMappings.$EnumSwitchMapping$1[dateRange.ordinal()];
        if (i == 1) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : photos) {
                if (((PhotosModel) obj).getDateAdded().after(new Date(date3.getTime() - 2592000000L))) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }
        if (i == 2) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : photos) {
                if (((PhotosModel) obj2).getDateAdded().after(new Date(date3.getTime() - 15552000000L))) {
                    arrayList2.add(obj2);
                }
            }
            return arrayList2;
        }
        if (i == 3) {
            ArrayList arrayList3 = new ArrayList();
            for (Object obj3 : photos) {
                if (((PhotosModel) obj3).getDateAdded().after(new Date(date3.getTime() - 31536000000L))) {
                    arrayList3.add(obj3);
                }
            }
            return arrayList3;
        }
        if (i != 4 || (date = this.customStartDate) == null || (date2 = this.customEndDate) == null) {
            return photos;
        }
        ArrayList arrayList4 = new ArrayList();
        for (Object obj4 : photos) {
            PhotosModel photosModel = (PhotosModel) obj4;
            if (photosModel.getDateAdded().after(date) && photosModel.getDateAdded().before(date2)) {
                arrayList4.add(obj4);
            }
        }
        return arrayList4;
    }

    private final List<PhotosModel> filterBySizeRange(List<PhotosModel> photos, SizeRange sizeRange) {
        int i = WhenMappings.$EnumSwitchMapping$2[sizeRange.ordinal()];
        if (i == 1) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : photos) {
                if (((PhotosModel) obj).getSize() <= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }
        if (i == 2) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : photos) {
                PhotosModel photosModel = (PhotosModel) obj2;
                if (photosModel.getSize() > PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED && photosModel.getSize() <= CacheDataSink.DEFAULT_FRAGMENT_SIZE) {
                    arrayList2.add(obj2);
                }
            }
            return arrayList2;
        }
        if (i != 3) {
            if (i != 4) {
                return photos;
            }
            ArrayList arrayList3 = new ArrayList();
            for (Object obj3 : photos) {
                if (((PhotosModel) obj3).getSize() > 10485760) {
                    arrayList3.add(obj3);
                }
            }
            return arrayList3;
        }
        ArrayList arrayList4 = new ArrayList();
        for (Object obj4 : photos) {
            PhotosModel photosModel2 = (PhotosModel) obj4;
            if (photosModel2.getSize() > CacheDataSink.DEFAULT_FRAGMENT_SIZE && photosModel2.getSize() <= 10485760) {
                arrayList4.add(obj4);
            }
        }
        return arrayList4;
    }

    private final List<PhotosModel> sortPhotos(List<PhotosModel> photos, SortOrder sortOrder) {
        int i = WhenMappings.$EnumSwitchMapping$0[sortOrder.ordinal()];
        if (i == 1) {
            return CollectionsKt.sortedWith(photos, new Comparator() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PhotosFilesActivity$sortPhotos$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Long.valueOf(((PhotosModel) t).getSize()), Long.valueOf(((PhotosModel) t2).getSize()));
                }
            });
        }
        if (i == 2) {
            return CollectionsKt.sortedWith(photos, new Comparator() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PhotosFilesActivity$sortPhotos$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Long.valueOf(((PhotosModel) t2).getSize()), Long.valueOf(((PhotosModel) t).getSize()));
                }
            });
        }
        if (i != 3) {
            return i != 4 ? photos : CollectionsKt.sortedWith(photos, new Comparator() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PhotosFilesActivity$sortPhotos$$inlined$sortedByDescending$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(((PhotosModel) t2).getDateAdded(), ((PhotosModel) t).getDateAdded());
                }
            });
        }
        return CollectionsKt.sortedWith(photos, new Comparator() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PhotosFilesActivity$sortPhotos$$inlined$sortedBy$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((PhotosModel) t).getDateAdded(), ((PhotosModel) t2).getDateAdded());
            }
        });
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: PhotosFilesActivity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/activity/PhotosFilesActivity$SortOrder;", "", "(Ljava/lang/String;I)V", "NONE", "SIZE_ASC", "SIZE_DESC", "TIME_ASC", "TIME_DESC", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
    /* compiled from: PhotosFilesActivity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/activity/PhotosFilesActivity$DateRange;", "", "(Ljava/lang/String;I)V", "NONE", "ONE_MONTH", "SIX_MONTHS", "ONE_YEAR", "CUSTOM", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
    /* compiled from: PhotosFilesActivity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/activity/PhotosFilesActivity$SizeRange;", "", "(Ljava/lang/String;I)V", "NONE", "ZERO_TO_ONE", "ONE_TO_FIVE", "FIVE_TO_TEN", "MORE_THAN_TEN", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
        ActivityPhotosFilesBinding activityPhotosFilesBinding = this.photoFilesBinding;
        PhotosAdapter photosAdapter = null;
        RecyclerView recyclerView = activityPhotosFilesBinding != null ? activityPhotosFilesBinding.recyclerView : null;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new GridLayoutManager(this, this.currentGridSpan));
        }
        PhotosAdapter photosAdapter2 = this.photosAdapter;
        if (photosAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photosAdapter");
        } else {
            photosAdapter = photosAdapter2;
        }
        photosAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateEmptyView() {
        AppCompatImageView appCompatImageView;
        PhotosAdapter photosAdapter = this.photosAdapter;
        if (photosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photosAdapter");
            photosAdapter = null;
        }
        if (photosAdapter.getItemCount() == 0) {
            ActivityPhotosFilesBinding activityPhotosFilesBinding = this.photoFilesBinding;
            RecyclerView recyclerView = activityPhotosFilesBinding != null ? activityPhotosFilesBinding.recyclerView : null;
            if (recyclerView != null) {
                recyclerView.setVisibility(View.GONE);
            }
            ActivityPhotosFilesBinding activityPhotosFilesBinding2 = this.photoFilesBinding;
            appCompatImageView = activityPhotosFilesBinding2 != null ? activityPhotosFilesBinding2.ivError : null;
            if (appCompatImageView == null) {
                return;
            }
            appCompatImageView.setVisibility(View.VISIBLE);
            return;
        }
        ActivityPhotosFilesBinding activityPhotosFilesBinding3 = this.photoFilesBinding;
        RecyclerView recyclerView2 = activityPhotosFilesBinding3 != null ? activityPhotosFilesBinding3.recyclerView : null;
        if (recyclerView2 != null) {
            recyclerView2.setVisibility(View.VISIBLE);
        }
        ActivityPhotosFilesBinding activityPhotosFilesBinding4 = this.photoFilesBinding;
        appCompatImageView = activityPhotosFilesBinding4 != null ? activityPhotosFilesBinding4.ivError : null;
        if (appCompatImageView == null) {
            return;
        }
        appCompatImageView.setVisibility(View.GONE);
    }

    private final void setupRecyclerView() {
        RecyclerView recyclerView;
        this.photosAdapter = new PhotosAdapter(new ArrayList(), new PhotosFilesActivity$setupRecyclerView$1(this), new PhotosFilesActivity$setupRecyclerView$2(this), new PhotosFilesActivity$setupRecyclerView$3(this));
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, this.currentGridSpan);
        ActivityPhotosFilesBinding activityPhotosFilesBinding = this.photoFilesBinding;
        if (activityPhotosFilesBinding == null || (recyclerView = activityPhotosFilesBinding.recyclerView) == null) {
            return;
        }
        recyclerView.setLayoutManager(gridLayoutManager);
        PhotosAdapter photosAdapter = this.photosAdapter;
        if (photosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photosAdapter");
            photosAdapter = null;
        }
        recyclerView.setAdapter(photosAdapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PhotosFilesActivity$setupRecyclerView$4$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView2, int dx, int dy) {
                boolean z;
                Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
                Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
                GridLayoutManager gridLayoutManager2 = (GridLayoutManager) layoutManager;
                z = PhotosFilesActivity.this.isLoading;
                if (z || gridLayoutManager2.findLastVisibleItemPosition() != gridLayoutManager2.getItemCount() - 1) {
                    return;
                }
                PhotosFilesActivity.this.loadMorePhotos();
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
            ActivityPhotosFilesBinding activityPhotosFilesBinding = this.photoFilesBinding;
            if (activityPhotosFilesBinding != null && (appCompatImageView2 = activityPhotosFilesBinding.icSelectAll) != null) {
                appCompatImageView2.setImageResource(R.drawable.ic_check);
            }
            ActivityPhotosFilesBinding activityPhotosFilesBinding2 = this.photoFilesBinding;
            if (activityPhotosFilesBinding2 == null || (textView2 = activityPhotosFilesBinding2.allSelected) == null) {
                return;
            }
            textView2.setText(R.string.all_deselect);
            return;
        }
        ActivityPhotosFilesBinding activityPhotosFilesBinding3 = this.photoFilesBinding;
        if (activityPhotosFilesBinding3 != null && (appCompatImageView = activityPhotosFilesBinding3.icSelectAll) != null) {
            appCompatImageView.setImageResource(R.drawable.ic_dslct);
        }
        ActivityPhotosFilesBinding activityPhotosFilesBinding4 = this.photoFilesBinding;
        if (activityPhotosFilesBinding4 == null || (textView = activityPhotosFilesBinding4.allSelected) == null) {
            return;
        }
        textView.setText(R.string.all_select);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onPhotoClick(int position) {
        PhotosAdapter photosAdapter = this.photosAdapter;
        PhotosAdapter photosAdapter2 = null;
        if (photosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photosAdapter");
            photosAdapter = null;
        }
        if (photosAdapter.getSelectedItemCount() <= 0) {
            PhotosAdapter photosAdapter3 = this.photosAdapter;
            if (photosAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photosAdapter");
                photosAdapter3 = null;
            }
            if (!photosAdapter3.getIsAllSelected()) {
                PhotosAdapter photosAdapter4 = this.photosAdapter;
                if (photosAdapter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("photosAdapter");
                } else {
                    photosAdapter2 = photosAdapter4;
                }
                PhotosModel itemAtPosition = photosAdapter2.getItemAtPosition(position);
                Intent intent = new Intent(this, (Class<?>) ViewPhotoActivity.class);
                intent.putExtra("PHOTO_PATH", itemAtPosition.getFile().getAbsolutePath());
                intent.putExtra("FILE_TYPE", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO);
                startActivity(intent);
                return;
            }
        }
        toggleSelection(position);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onPhotoLongClick(int position) {
        toggleSelection(position);
    }

    private final void toggleSelection(int position) {
        PhotosAdapter photosAdapter = this.photosAdapter;
        if (photosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photosAdapter");
            photosAdapter = null;
        }
        photosAdapter.toggleSelection(position);
        PhotosAdapter photosAdapter2 = this.photosAdapter;
        if (photosAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photosAdapter");
            photosAdapter2 = null;
        }
        int selectedItemCount = photosAdapter2.getSelectedItemCount();
        if (selectedItemCount > 0) {
            ActivityPhotosFilesBinding activityPhotosFilesBinding = this.photoFilesBinding;
            LinearLayout linearLayout = activityPhotosFilesBinding != null ? activityPhotosFilesBinding.llSelection : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(View.VISIBLE);
            }
            ActivityPhotosFilesBinding activityPhotosFilesBinding2 = this.photoFilesBinding;
            LinearLayout linearLayout2 = activityPhotosFilesBinding2 != null ? activityPhotosFilesBinding2.headerLayout : null;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(View.GONE);
            }
            ActivityPhotosFilesBinding activityPhotosFilesBinding3 = this.photoFilesBinding;
            TextView textView = activityPhotosFilesBinding3 != null ? activityPhotosFilesBinding3.tvRecover : null;
            if (textView == null) {
                return;
            }
            textView.setText("Recover (" + selectedItemCount + ')');
            return;
        }
        ActivityPhotosFilesBinding activityPhotosFilesBinding4 = this.photoFilesBinding;
        LinearLayout linearLayout3 = activityPhotosFilesBinding4 != null ? activityPhotosFilesBinding4.headerLayout : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(View.VISIBLE);
        }
        ActivityPhotosFilesBinding activityPhotosFilesBinding5 = this.photoFilesBinding;
        LinearLayout linearLayout4 = activityPhotosFilesBinding5 != null ? activityPhotosFilesBinding5.llSelection : null;
        if (linearLayout4 == null) {
            return;
        }
        linearLayout4.setVisibility(View.GONE);
    }

    private final void selectAllPhotos() {
        PhotosAdapter photosAdapter = this.photosAdapter;
        if (photosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photosAdapter");
            photosAdapter = null;
        }
        photosAdapter.selectAll();
        updateSelectionUI();
    }

    private final void deselectAllPhotos() {
        PhotosAdapter photosAdapter = this.photosAdapter;
        if (photosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photosAdapter");
            photosAdapter = null;
        }
        photosAdapter.deselectAll();
        updateSelectionUI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSelectionUI() {
        int selectedItemCount;
        PhotosAdapter photosAdapter = this.photosAdapter;
        if (photosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photosAdapter");
            photosAdapter = null;
        }
        if (photosAdapter.getIsAllSelected()) {
            PhotosAdapter photosAdapter2 = this.photosAdapter;
            if (photosAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photosAdapter");
                photosAdapter2 = null;
            }
            selectedItemCount = photosAdapter2.getTotalItemCount();
        } else {
            PhotosAdapter photosAdapter3 = this.photosAdapter;
            if (photosAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photosAdapter");
                photosAdapter3 = null;
            }
            selectedItemCount = photosAdapter3.getSelectedItemCount();
        }
        if (selectedItemCount > 0) {
            ActivityPhotosFilesBinding activityPhotosFilesBinding = this.photoFilesBinding;
            LinearLayout linearLayout = activityPhotosFilesBinding != null ? activityPhotosFilesBinding.llSelection : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(View.VISIBLE);
            }
            ActivityPhotosFilesBinding activityPhotosFilesBinding2 = this.photoFilesBinding;
            LinearLayout linearLayout2 = activityPhotosFilesBinding2 != null ? activityPhotosFilesBinding2.headerLayout : null;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(View.GONE);
            }
            ActivityPhotosFilesBinding activityPhotosFilesBinding3 = this.photoFilesBinding;
            TextView textView = activityPhotosFilesBinding3 != null ? activityPhotosFilesBinding3.tvRecover : null;
            if (textView == null) {
                return;
            }
            textView.setText("Recover (" + selectedItemCount + ')');
            return;
        }
        ActivityPhotosFilesBinding activityPhotosFilesBinding4 = this.photoFilesBinding;
        LinearLayout linearLayout3 = activityPhotosFilesBinding4 != null ? activityPhotosFilesBinding4.headerLayout : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(View.VISIBLE);
        }
        ActivityPhotosFilesBinding activityPhotosFilesBinding5 = this.photoFilesBinding;
        LinearLayout linearLayout4 = activityPhotosFilesBinding5 != null ? activityPhotosFilesBinding5.llSelection : null;
        if (linearLayout4 == null) {
            return;
        }
        linearLayout4.setVisibility(View.GONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadMorePhotos() {
        int i = this.currentPage * this.pageSize;
        if (i >= this.allPhotosList.size()) {
            return;
        }
        this.isLoading = true;
        List<PhotosModel> list = this.allPhotosList;
        List<PhotosModel> subList = list.subList(i, Math.min(this.pageSize + i, list.size()));
        PhotosAdapter photosAdapter = this.photosAdapter;
        if (photosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photosAdapter");
            photosAdapter = null;
        }
        photosAdapter.addPhotos(subList, this.allPhotosList.size());
        int i2 = this.currentPage + 1;
        this.currentPage = i2;
        this.isLoading = false;
        if (i2 * this.pageSize < this.allPhotosList.size()) {
            this.handler.post(new Runnable() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PhotosFilesActivity$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    PhotosFilesActivity.loadMorePhotos$lambda$50(PhotosFilesActivity.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadMorePhotos$lambda$50(PhotosFilesActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.loadMorePhotos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object fetchPhotosFromAlbum(String str, Continuation<? super List<PhotosModel>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new PhotosFilesActivity$fetchPhotosFromAlbum$2(str, this, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object fetchAllPhotos(List<String> list, Continuation<? super List<PhotosModel>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new PhotosFilesActivity$fetchAllPhotos$2(list, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isValidImage(File file) {
        if (file.isDirectory()) {
            return false;
        }
        String lowerCase = FilesKt.getExtension(file).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        try {
            String fileSignature = getFileSignature(file);
            if (CollectionsKt.listOf((Object[]) new String[]{"m4a", "mp3", "mp4", "wav"}).contains(lowerCase)) {
                return false;
            }
            if (!CollectionsKt.listOf((Object[]) new String[]{"heic", "jpg"}).contains(lowerCase) && !StringsKt.startsWith$default(fileSignature, "FFD8FFE0", false, 2, (Object) null) && !StringsKt.startsWith$default(fileSignature, "FFD8FFE1", false, 2, (Object) null) && !StringsKt.startsWith$default(fileSignature, "89504E47", false, 2, (Object) null) && !StringsKt.startsWith$default(fileSignature, "47494638", false, 2, (Object) null) && !StringsKt.startsWith$default(fileSignature, "424D", false, 2, (Object) null) && !StringsKt.startsWith$default(fileSignature, "52494646", false, 2, (Object) null) && !StringsKt.startsWith$default(fileSignature, "0000000C", false, 2, (Object) null)) {
                if (!StringsKt.startsWith$default(fileSignature, "0000001C", false, 2, (Object) null)) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isImageWithoutExtension(File file) {
        if (FilesKt.getExtension(file).length() > 0) {
            return false;
        }
        return isValidImage(file);
    }

    private final String getFileSignature(File file) {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            byte[] bArr = new byte[8];
            fileInputStream.read(bArr);
            String joinToString$default = ArraysKt.joinToString$default(bArr, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) new Function1<Byte, CharSequence>() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PhotosFilesActivity$getFileSignature$1$1
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
            return joinToString$default;
        } finally {
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        PhotosAdapter photosAdapter = this.photosAdapter;
        if (photosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photosAdapter");
            photosAdapter = null;
        }
        if (photosAdapter.getSelectedItemCount() > 0) {
            deselectAllPhotos();
        } else {
            super.onBackPressed();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.photoFilesBinding = null;
        this.handler.removeCallbacksAndMessages(null);
    }
}
