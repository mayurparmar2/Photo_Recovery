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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.share.internal.ShareInternalUtility;
import com.demo.example.R;
import com.gcs.recovery.videos.files.photo_recovery.adapter.AudiosAdapter;
import com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass;
import com.demo.example.databinding.ActivityAudioFilesBinding;
import com.demo.example.databinding.DialogFilterAudioLayoutBinding;
import com.gcs.recovery.videos.files.photo_recovery.model.AudiosModel;
import com.gcs.recovery.videos.files.photo_recovery.utils.FileUtils;
import com.gcs.recovery.videos.files.photo_recovery.utils.SharedDataHolder;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.button.MaterialButton;

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




/* compiled from: AudioFilesActivity.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0003RSTB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\u0016\u0010 \u001a\u00020\u001e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\b\u0010\"\u001a\u00020\u001eH\u0002J\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00180\u0004H\u0002J\u0018\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010$\u001a\u0004\u0018\u00010\u0018H\u0002J$\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010(\u001a\u00020\u0015H\u0002J$\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010*\u001a\u00020\u001aH\u0002J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0002J\u0012\u0010/\u001a\u00020\u001e2\b\u00100\u001a\u0004\u0018\u00010\u0018H\u0002J\u0010\u00101\u001a\u00020\u001e2\u0006\u00102\u001a\u00020\u0005H\u0002J\b\u00103\u001a\u00020\u001eH\u0002J\u0010\u00104\u001a\u00020\u001e2\u0006\u00105\u001a\u00020\u000bH\u0002J\u0010\u00106\u001a\u00020\u001e2\u0006\u00105\u001a\u00020\u000bH\u0002J\b\u00107\u001a\u00020\u001eH\u0016J\u0012\u00108\u001a\u00020\u001e2\b\u00109\u001a\u0004\u0018\u00010:H\u0014J\b\u0010;\u001a\u00020\u001eH\u0014J\u0010\u0010<\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020\u0012H\u0002J\u0010\u0010>\u001a\u00020\u001e2\u0006\u0010?\u001a\u00020@H\u0002J\u0010\u0010A\u001a\u00020\u001e2\u0006\u0010B\u001a\u00020\u0005H\u0002J\b\u0010C\u001a\u00020\u001eH\u0003J\b\u0010D\u001a\u00020\u001eH\u0002J\b\u0010E\u001a\u00020\u001eH\u0002J\b\u0010F\u001a\u00020\u001eH\u0002J\b\u0010G\u001a\u00020\u001eH\u0002J\b\u0010H\u001a\u00020\u001eH\u0002J$\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010J\u001a\u00020\u001cH\u0002J\u0010\u0010K\u001a\u00020\u001e2\u0006\u00105\u001a\u00020\u000bH\u0003J\u0018\u0010L\u001a\u00020\u001e2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\u0012H\u0002J\b\u0010P\u001a\u00020\u001eH\u0002J\b\u0010Q\u001a\u00020\u001eH\u0003R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006U"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/activity/AudioFilesActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "allAudiosList", "", "Lcom/gcs/recovery/videos/files/photo_recovery/model/AudiosModel;", "audioFilesBinding", "Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ActivityAudioFilesBinding;", "audiosAdapter", "Lcom/gcs/recovery/videos/files/photo_recovery/adapter/AudiosAdapter;", "currentPage", "", "customEndDate", "Ljava/util/Date;", "customStartDate", "handler", "Landroid/os/Handler;", "isLoading", "", "pageSize", "selectedDateRange", "Lcom/gcs/recovery/videos/files/photo_recovery/activity/AudioFilesActivity$DateRange;", "selectedFilterTypes", "", "", "selectedSizeRange", "Lcom/gcs/recovery/videos/files/photo_recovery/activity/AudioFilesActivity$SizeRange;", "selectedSortOrder", "Lcom/gcs/recovery/videos/files/photo_recovery/activity/AudioFilesActivity$SortOrder;", "applyCustomDateRangeFilter", "", "applyFilters", "deleteSelectedItems", FirebaseAnalytics.Param.ITEMS, "deselectAllAudios", "fetchAllAudios", "audioPaths", "fetchAudiosFromAlbum", "filterByDateRange", "audios", "dateRange", "filterBySizeRange", "sizeRange", "getAudioDuration", "", ShareInternalUtility.STAGING_PARAM, "Ljava/io/File;", "loadAlbumAudio", "albumPath", "loadAudioDurationAsync", "audioModel", "loadMoreAudios", "onAudioClick", "position", "onAudioLongClick", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSelectionChanged", "isAllSelected", "preselectFilterButtons", "dialogBinding", "Lcom/gcs/recovery/videos/files/photo_recovery/databinding/DialogFilterAudioLayoutBinding;", "recoverItem", "audio", "recoverSelectedAudios", "resetFilters", "selectAllAudios", "setupRecyclerView", "showCustomDatePickerDialog", "showSortDialog", "sortAudios", SDKConstants.PARAM_SORT_ORDER, "toggleSelection", "updateButtonSelection", "button", "Lcom/google/android/material/button/MaterialButton;", "isSelected", "updateEmptyView", "updateSelectionUI", "DateRange", "SizeRange", "SortOrder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AudioFilesActivity extends AppCompatActivity {
    private ActivityAudioFilesBinding audioFilesBinding;
    private AudiosAdapter audiosAdapter;
    private int currentPage;
    private Date customEndDate;
    private Date customStartDate;
    private boolean isLoading;
    private List<AudiosModel> allAudiosList = CollectionsKt.emptyList();
    private final int pageSize = 20;
    private Handler handler = new Handler(Looper.getMainLooper());
    private final List<String> selectedFilterTypes = new ArrayList();
    private SortOrder selectedSortOrder = SortOrder.NONE;
    private DateRange selectedDateRange = DateRange.NONE;
    private SizeRange selectedSizeRange = SizeRange.NONE;

    /* compiled from: AudioFilesActivity.kt */
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
        ActivityAudioFilesBinding inflate = ActivityAudioFilesBinding.inflate(getLayoutInflater());
        this.audioFilesBinding = inflate;
        Intrinsics.checkNotNull(inflate);
        setContentView(inflate.getRoot());
        FileUtils.INSTANCE.createAppFolders(this);
        this.selectedSortOrder = SortOrder.NONE;
        this.selectedDateRange = DateRange.NONE;
        this.selectedSizeRange = SizeRange.NONE;
        AdsClass adsClass = new AdsClass();
        ActivityAudioFilesBinding activityAudioFilesBinding = this.audioFilesBinding;
        Intrinsics.checkNotNull(activityAudioFilesBinding);
        adsClass.refreshAd(activityAudioFilesBinding.frameLayout, this, 2);
        String stringExtra = getIntent().getStringExtra("ALBUM_TITLE");
        if (stringExtra == null) {
            stringExtra = "Audios";
        }
        ActivityAudioFilesBinding activityAudioFilesBinding2 = this.audioFilesBinding;
        TextView textView2 = activityAudioFilesBinding2 != null ? activityAudioFilesBinding2.txtTitle : null;
        if (textView2 != null) {
            textView2.setText(stringExtra);
        }
        loadAlbumAudio(getIntent().getStringExtra("ALBUM_PATH"));
        setupRecyclerView();
        updateEmptyView();
        ActivityAudioFilesBinding activityAudioFilesBinding3 = this.audioFilesBinding;
        if (activityAudioFilesBinding3 != null && (appCompatImageView4 = activityAudioFilesBinding3.icBack) != null) {
            appCompatImageView4.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.AudioFilesActivity$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AudioFilesActivity.onCreate$lambda$0(AudioFilesActivity.this, view);
                }
            });
        }
        ActivityAudioFilesBinding activityAudioFilesBinding4 = this.audioFilesBinding;
        if (activityAudioFilesBinding4 != null && (appCompatImageView3 = activityAudioFilesBinding4.icMenu) != null) {
            appCompatImageView3.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.AudioFilesActivity$$ExternalSyntheticLambda11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AudioFilesActivity.onCreate$lambda$1(AudioFilesActivity.this, view);
                }
            });
        }
        ActivityAudioFilesBinding activityAudioFilesBinding5 = this.audioFilesBinding;
        if (activityAudioFilesBinding5 != null && (linearLayout = activityAudioFilesBinding5.llSelection) != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.AudioFilesActivity$$ExternalSyntheticLambda15
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AudioFilesActivity.onCreate$lambda$2(AudioFilesActivity.this, view);
                }
            });
        }
        ActivityAudioFilesBinding activityAudioFilesBinding6 = this.audioFilesBinding;
        if (activityAudioFilesBinding6 != null && (appCompatImageView2 = activityAudioFilesBinding6.icSelectAll) != null) {
            appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.AudioFilesActivity$$ExternalSyntheticLambda16
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AudioFilesActivity.onCreate$lambda$3(AudioFilesActivity.this, view);
                }
            });
        }
        ActivityAudioFilesBinding activityAudioFilesBinding7 = this.audioFilesBinding;
        if (activityAudioFilesBinding7 != null && (appCompatImageView = activityAudioFilesBinding7.icDelete) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.AudioFilesActivity$$ExternalSyntheticLambda17
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AudioFilesActivity.onCreate$lambda$4(AudioFilesActivity.this, view);
                }
            });
        }
        ActivityAudioFilesBinding activityAudioFilesBinding8 = this.audioFilesBinding;
        if (activityAudioFilesBinding8 == null || (textView = activityAudioFilesBinding8.tvRecover) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.AudioFilesActivity$$ExternalSyntheticLambda18
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudioFilesActivity.onCreate$lambda$6(AudioFilesActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(AudioFilesActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(AudioFilesActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showSortDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(AudioFilesActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AudiosAdapter audiosAdapter = this$0.audiosAdapter;
        if (audiosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audiosAdapter");
            audiosAdapter = null;
        }
        audiosAdapter.getSelectedItemCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(AudioFilesActivity this$0, View view) {
        TextView textView;
        AppCompatImageView appCompatImageView;
        TextView textView2;
        AppCompatImageView appCompatImageView2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AudiosAdapter audiosAdapter = this$0.audiosAdapter;
        AudiosAdapter audiosAdapter2 = null;
        if (audiosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audiosAdapter");
            audiosAdapter = null;
        }
        int selectedItemCount = audiosAdapter.getSelectedItemCount();
        AudiosAdapter audiosAdapter3 = this$0.audiosAdapter;
        if (audiosAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audiosAdapter");
        } else {
            audiosAdapter2 = audiosAdapter3;
        }
        if (selectedItemCount == audiosAdapter2.getItemCount()) {
            this$0.deselectAllAudios();
            ActivityAudioFilesBinding activityAudioFilesBinding = this$0.audioFilesBinding;
            if (activityAudioFilesBinding != null && (appCompatImageView2 = activityAudioFilesBinding.icSelectAll) != null) {
                appCompatImageView2.setImageResource(R.drawable.ic_dslct);
            }
            ActivityAudioFilesBinding activityAudioFilesBinding2 = this$0.audioFilesBinding;
            if (activityAudioFilesBinding2 == null || (textView2 = activityAudioFilesBinding2.allSelected) == null) {
                return;
            }
            textView2.setText(R.string.all_select);
            return;
        }
        this$0.selectAllAudios();
        ActivityAudioFilesBinding activityAudioFilesBinding3 = this$0.audioFilesBinding;
        if (activityAudioFilesBinding3 != null && (appCompatImageView = activityAudioFilesBinding3.icSelectAll) != null) {
            appCompatImageView.setImageResource(R.drawable.ic_check);
        }
        ActivityAudioFilesBinding activityAudioFilesBinding4 = this$0.audioFilesBinding;
        if (activityAudioFilesBinding4 == null || (textView = activityAudioFilesBinding4.allSelected) == null) {
            return;
        }
        textView.setText(R.string.all_deselect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$4(AudioFilesActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AudiosAdapter audiosAdapter = this$0.audiosAdapter;
        if (audiosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audiosAdapter");
            audiosAdapter = null;
        }
        this$0.deleteSelectedItems(audiosAdapter.getSelectedItems());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$6(final AudioFilesActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AdsClass.showInterstitial(this$0, new AdsClass.onListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.AudioFilesActivity$$ExternalSyntheticLambda14
            @Override // com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass.onListener
            public final void click() {
                AudioFilesActivity.onCreate$lambda$6$lambda$5(AudioFilesActivity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$6$lambda$5(AudioFilesActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.recoverSelectedAudios();
    }

    private final void loadAlbumAudio(String albumPath) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AudioFilesActivity$loadAlbumAudio$1(this, albumPath, null), 3, null);
    }

    private final void recoverSelectedAudios() {
        AudiosAdapter audiosAdapter = this.audiosAdapter;
        if (audiosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audiosAdapter");
            audiosAdapter = null;
        }
        final List<AudiosModel> selectedItems = audiosAdapter.getSelectedItems();
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
        new Thread(new Runnable() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.AudioFilesActivity$$ExternalSyntheticLambda19
            @Override // java.lang.Runnable
            public final void run() {
                AudioFilesActivity.recoverSelectedAudios$lambda$9(selectedItems, this, intRef, textView, progressBar, bottomSheetDialog);
            }
        }).start();
        deselectAllAudios();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void recoverSelectedAudios$lambda$9(List selectedItems, final AudioFilesActivity this$0, final Ref.IntRef recoveredItemCount, final TextView textView, final ProgressBar progressBar, final BottomSheetDialog dialog) {
        Intrinsics.checkNotNullParameter(selectedItems, "$selectedItems");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(recoveredItemCount, "$recoveredItemCount");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Iterator it = selectedItems.iterator();
        final int i = 0;
        while (it.hasNext()) {
            AudiosModel audiosModel = (AudiosModel) it.next();
            Thread.sleep(500L);
            this$0.recoverItem(audiosModel);
            recoveredItemCount.element++;
            this$0.runOnUiThread(new Runnable() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.AudioFilesActivity$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    AudioFilesActivity.recoverSelectedAudios$lambda$9$lambda$7(textView, i, progressBar);
                }
            });
            i++;
        }
        this$0.runOnUiThread(new Runnable() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.AudioFilesActivity$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                AudioFilesActivity.recoverSelectedAudios$lambda$9$lambda$8(BottomSheetDialog.this, this$0, recoveredItemCount);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void recoverSelectedAudios$lambda$9$lambda$7(TextView textView, int i, ProgressBar progressBar) {
        int i2 = i + 1;
        textView.setText(String.valueOf(i2));
        progressBar.setProgress(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void recoverSelectedAudios$lambda$9$lambda$8(BottomSheetDialog dialog, AudioFilesActivity this$0, Ref.IntRef recoveredItemCount) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(recoveredItemCount, "$recoveredItemCount");
        dialog.dismiss();
        Intent intent = new Intent(this$0, (Class<?>) SuccessfullyRecoverActivity.class);
        intent.putExtra("RECOVERED_ITEM_COUNT", recoveredItemCount.element);
        intent.putExtra("ITEM_TYPE", "AUDIO");
        this$0.startActivity(intent);
    }

    private final void recoverItem(AudiosModel audio) {
        String str;
        File file = new File(Environment.getExternalStorageDirectory(), "PhotoRecovery/Audios");
        if (!file.exists()) {
            file.mkdirs();
        }
        String name = audio.getFile().getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        if (StringsKt.startsWith$default(name, ".", false, 2, (Object) null)) {
            str = StringsKt.removePrefix(FilesKt.getNameWithoutExtension(audio.getFile()), (CharSequence) ".") + ".mp3";
        } else {
            str = FilesKt.getNameWithoutExtension(audio.getFile()) + ".mp3";
        }
        File file2 = new File(file, str);
        FilesKt.copyTo$default(audio.getFile(), file2, true, 0, 4, null);
        MediaScannerConnection.scanFile(this, new String[]{file2.getAbsolutePath()}, null, null);
    }

    private final void deleteSelectedItems(final List<AudiosModel> items) {
        if (items.isEmpty()) {
            return;
        }
        View inflate = getLayoutInflater().inflate(R.layout.dialog_delete_alert, (ViewGroup) null);
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(inflate);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.iv_no_btn);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.iv_yes_btn);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.AudioFilesActivity$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudioFilesActivity.deleteSelectedItems$lambda$10(BottomSheetDialog.this, view);
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.AudioFilesActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudioFilesActivity.deleteSelectedItems$lambda$15(items, bottomSheetDialog, this, view);
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
    public static final void deleteSelectedItems$lambda$15(List items, BottomSheetDialog dialog, AudioFilesActivity this$0, View view) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(items, "$items");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List list = items;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((AudiosModel) it.next()).getFile().delete();
        }
        dialog.dismiss();
        this$0.deselectAllAudios();
        SharedDataHolder sharedDataHolder = SharedDataHolder.INSTANCE;
        List<File> audioFiles = SharedDataHolder.INSTANCE.getAudioFiles();
        AudiosAdapter audiosAdapter = null;
        if (audioFiles != null) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : audioFiles) {
                File file = (File) obj;
                boolean z = false;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator it2 = list.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (Intrinsics.areEqual(((AudiosModel) it2.next()).getFile(), file)) {
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
        sharedDataHolder.setAudioFiles(arrayList);
        List<AudiosModel> list2 = this$0.allAudiosList;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : list2) {
            if (!items.contains((AudiosModel) obj2)) {
                arrayList3.add(obj2);
            }
        }
        this$0.allAudiosList = arrayList3;
        AudiosAdapter audiosAdapter2 = this$0.audiosAdapter;
        if (audiosAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audiosAdapter");
        } else {
            audiosAdapter = audiosAdapter2;
        }
        List<AudiosModel> list3 = this$0.allAudiosList;
        audiosAdapter.updateAudios(list3, list3.size());
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
            ((MaterialButton) it.next()).setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.AudioFilesActivity$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AudioFilesActivity.showSortDialog$lambda$18$lambda$17(listOf, this, inflate, listOf2, listOf3, view);
                }
            });
        }
        for (final MaterialButton materialButton : listOf2) {
            materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.AudioFilesActivity$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AudioFilesActivity.showSortDialog$lambda$20$lambda$19(MaterialButton.this, inflate, this, listOf2, listOf, listOf3, view);
                }
            });
        }
        Iterator it2 = listOf3.iterator();
        while (it2.hasNext()) {
            ((MaterialButton) it2.next()).setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.AudioFilesActivity$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AudioFilesActivity.showSortDialog$lambda$22$lambda$21(listOf3, listOf, this, inflate, listOf2, view);
                }
            });
        }
        inflate.applyBtn.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.AudioFilesActivity$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudioFilesActivity.showSortDialog$lambda$23(AudioFilesActivity.this, bottomSheetDialog, view);
            }
        });
        inflate.resetFilter.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.AudioFilesActivity$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudioFilesActivity.showSortDialog$lambda$27(AudioFilesActivity.this, listOf, listOf2, listOf3, bottomSheetDialog, inflate, view);
            }
        });
        bottomSheetDialog.show();
    }

    private static final void showSortDialog$handleButtonSelection(List<? extends MaterialButton> list, AudioFilesActivity audioFilesActivity, DialogFilterAudioLayoutBinding dialogFilterAudioLayoutBinding, List<? extends MaterialButton> list2, List<? extends MaterialButton> list3, List<? extends MaterialButton> list4, MaterialButton materialButton) {
        SizeRange sizeRange;
        DateRange dateRange;
        SortOrder sortOrder;
        for (MaterialButton materialButton2 : list4) {
            audioFilesActivity.updateButtonSelection(materialButton2, Intrinsics.areEqual(materialButton2, materialButton));
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
            audioFilesActivity.selectedSortOrder = sortOrder;
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
            audioFilesActivity.selectedDateRange = dateRange;
            if (Intrinsics.areEqual(materialButton, dialogFilterAudioLayoutBinding.customDate)) {
                audioFilesActivity.showCustomDatePickerDialog();
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
            audioFilesActivity.selectedSizeRange = sizeRange;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSortDialog$lambda$18$lambda$17(List sortOrderButtons, AudioFilesActivity this$0, DialogFilterAudioLayoutBinding dialogFilterBinding, List dateRangeButtons, List sizeRangeButtons, View view) {
        Intrinsics.checkNotNullParameter(sortOrderButtons, "$sortOrderButtons");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialogFilterBinding, "$dialogFilterBinding");
        Intrinsics.checkNotNullParameter(dateRangeButtons, "$dateRangeButtons");
        Intrinsics.checkNotNullParameter(sizeRangeButtons, "$sizeRangeButtons");
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.google.android.material.button.MaterialButton");
        showSortDialog$handleButtonSelection(sortOrderButtons, this$0, dialogFilterBinding, dateRangeButtons, sizeRangeButtons, sortOrderButtons, (MaterialButton) view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSortDialog$lambda$20$lambda$19(MaterialButton button, DialogFilterAudioLayoutBinding dialogFilterBinding, AudioFilesActivity this$0, List dateRangeButtons, List sortOrderButtons, List sizeRangeButtons, View view) {
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
    public static final void showSortDialog$lambda$22$lambda$21(List sizeRangeButtons, List sortOrderButtons, AudioFilesActivity this$0, DialogFilterAudioLayoutBinding dialogFilterBinding, List dateRangeButtons, View view) {
        Intrinsics.checkNotNullParameter(sizeRangeButtons, "$sizeRangeButtons");
        Intrinsics.checkNotNullParameter(sortOrderButtons, "$sortOrderButtons");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialogFilterBinding, "$dialogFilterBinding");
        Intrinsics.checkNotNullParameter(dateRangeButtons, "$dateRangeButtons");
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.google.android.material.button.MaterialButton");
        showSortDialog$handleButtonSelection(sortOrderButtons, this$0, dialogFilterBinding, dateRangeButtons, sizeRangeButtons, sizeRangeButtons, (MaterialButton) view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSortDialog$lambda$23(AudioFilesActivity this$0, BottomSheetDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        this$0.applyFilters();
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSortDialog$lambda$27(AudioFilesActivity this$0, List sortOrderButtons, List dateRangeButtons, List sizeRangeButtons, BottomSheetDialog dialog, DialogFilterAudioLayoutBinding dialogFilterBinding, View view) {
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
        ((LinearLayout) inflate.findViewById(R.id.btnOk)).setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.AudioFilesActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudioFilesActivity.showCustomDatePickerDialog$lambda$30(datePicker, datePicker2, this, dialog, view);
            }
        });
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.AudioFilesActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AudioFilesActivity.showCustomDatePickerDialog$lambda$31(dialog, view);
            }
        });
        dialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showCustomDatePickerDialog$lambda$30(DatePicker datePicker, DatePicker datePicker2, AudioFilesActivity this$0, Dialog dialog, View view) {
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
            AudioFilesActivity audioFilesActivity = this;
            button.setTextColor(ContextCompat.getColor(audioFilesActivity, R.color.primary));
            button.setBackgroundColor(ContextCompat.getColor(audioFilesActivity, R.color.next));
        } else {
            AudioFilesActivity audioFilesActivity2 = this;
            button.setTextColor(ContextCompat.getColor(audioFilesActivity2, R.color.button_txt_color));
            button.setBackgroundColor(ContextCompat.getColor(audioFilesActivity2, R.color.feed_btn));
        }
    }

    private final void applyFilters() {
        List<AudiosModel> sortAudios = sortAudios(filterBySizeRange(filterByDateRange(this.allAudiosList, this.selectedDateRange), this.selectedSizeRange), this.selectedSortOrder);
        AudiosAdapter audiosAdapter = this.audiosAdapter;
        if (audiosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audiosAdapter");
            audiosAdapter = null;
        }
        audiosAdapter.updateAudios(sortAudios, sortAudios.size());
        updateSelectionUI();
        updateEmptyView();
    }

    private final List<AudiosModel> filterByDateRange(List<AudiosModel> audios, DateRange dateRange) {
        Date date;
        Date date2;
        Date date3 = new Date();
        int i = WhenMappings.$EnumSwitchMapping$1[dateRange.ordinal()];
        if (i == 1) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : audios) {
                if (((AudiosModel) obj).getDateAdded().after(new Date(date3.getTime() - 2592000000L))) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }
        if (i == 2) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : audios) {
                if (((AudiosModel) obj2).getDateAdded().after(new Date(date3.getTime() - 15552000000L))) {
                    arrayList2.add(obj2);
                }
            }
            return arrayList2;
        }
        if (i == 3) {
            ArrayList arrayList3 = new ArrayList();
            for (Object obj3 : audios) {
                if (((AudiosModel) obj3).getDateAdded().after(new Date(date3.getTime() - 31536000000L))) {
                    arrayList3.add(obj3);
                }
            }
            return arrayList3;
        }
        if (i != 4 || (date = this.customStartDate) == null || (date2 = this.customEndDate) == null) {
            return audios;
        }
        ArrayList arrayList4 = new ArrayList();
        for (Object obj4 : audios) {
            AudiosModel audiosModel = (AudiosModel) obj4;
            if (audiosModel.getDateAdded().after(date) && audiosModel.getDateAdded().before(date2)) {
                arrayList4.add(obj4);
            }
        }
        return arrayList4;
    }

    private final List<AudiosModel> filterBySizeRange(List<AudiosModel> audios, SizeRange sizeRange) {
        int i = WhenMappings.$EnumSwitchMapping$2[sizeRange.ordinal()];
        if (i == 1) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : audios) {
                if (((AudiosModel) obj).getSize() <= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }
        if (i == 2) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : audios) {
                AudiosModel audiosModel = (AudiosModel) obj2;
                if (audiosModel.getSize() > PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED && audiosModel.getSize() <= CacheDataSink.DEFAULT_FRAGMENT_SIZE) {
                    arrayList2.add(obj2);
                }
            }
            return arrayList2;
        }
        if (i != 3) {
            if (i != 4) {
                return audios;
            }
            ArrayList arrayList3 = new ArrayList();
            for (Object obj3 : audios) {
                if (((AudiosModel) obj3).getSize() > 10485760) {
                    arrayList3.add(obj3);
                }
            }
            return arrayList3;
        }
        ArrayList arrayList4 = new ArrayList();
        for (Object obj4 : audios) {
            AudiosModel audiosModel2 = (AudiosModel) obj4;
            if (audiosModel2.getSize() > CacheDataSink.DEFAULT_FRAGMENT_SIZE && audiosModel2.getSize() <= 10485760) {
                arrayList4.add(obj4);
            }
        }
        return arrayList4;
    }

    private final List<AudiosModel> sortAudios(List<AudiosModel> audios, SortOrder sortOrder) {
        int i = WhenMappings.$EnumSwitchMapping$0[sortOrder.ordinal()];
        if (i == 1) {
            return CollectionsKt.sortedWith(audios, new Comparator() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.AudioFilesActivity$sortAudios$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Long.valueOf(((AudiosModel) t).getSize()), Long.valueOf(((AudiosModel) t2).getSize()));
                }
            });
        }
        if (i == 2) {
            return CollectionsKt.sortedWith(audios, new Comparator() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.AudioFilesActivity$sortAudios$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Long.valueOf(((AudiosModel) t2).getSize()), Long.valueOf(((AudiosModel) t).getSize()));
                }
            });
        }
        if (i != 3) {
            return i != 4 ? audios : CollectionsKt.sortedWith(audios, new Comparator() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.AudioFilesActivity$sortAudios$$inlined$sortedByDescending$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(((AudiosModel) t2).getDateAdded(), ((AudiosModel) t).getDateAdded());
                }
            });
        }
        return CollectionsKt.sortedWith(audios, new Comparator() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.AudioFilesActivity$sortAudios$$inlined$sortedBy$2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((AudiosModel) t).getDateAdded(), ((AudiosModel) t2).getDateAdded());
            }
        });
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: AudioFilesActivity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/activity/AudioFilesActivity$SortOrder;", "", "(Ljava/lang/String;I)V", "NONE", "SIZE_ASC", "SIZE_DESC", "TIME_ASC", "TIME_DESC", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        private SortOrder(String str, int i) {
        }

        static {
            SortOrder[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: AudioFilesActivity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/activity/AudioFilesActivity$DateRange;", "", "(Ljava/lang/String;I)V", "NONE", "ONE_MONTH", "SIX_MONTHS", "ONE_YEAR", "CUSTOM", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        private DateRange(String str, int i) {
        }

        static {
            DateRange[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: AudioFilesActivity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/activity/AudioFilesActivity$SizeRange;", "", "(Ljava/lang/String;I)V", "NONE", "ZERO_TO_ONE", "ONE_TO_FIVE", "FIVE_TO_TEN", "MORE_THAN_TEN", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

        private SizeRange(String str, int i) {
        }

        static {
            SizeRange[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateEmptyView() {
        AppCompatImageView appCompatImageView;
        AudiosAdapter audiosAdapter = this.audiosAdapter;
        if (audiosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audiosAdapter");
            audiosAdapter = null;
        }
        if (audiosAdapter.getItemCount() == 0) {
            ActivityAudioFilesBinding activityAudioFilesBinding = this.audioFilesBinding;
            RecyclerView recyclerView = activityAudioFilesBinding != null ? activityAudioFilesBinding.recyclerView : null;
            if (recyclerView != null) {
                recyclerView.setVisibility(View.GONE);
            }
            ActivityAudioFilesBinding activityAudioFilesBinding2 = this.audioFilesBinding;
            appCompatImageView = activityAudioFilesBinding2 != null ? activityAudioFilesBinding2.ivError : null;
            if (appCompatImageView == null) {
                return;
            }
            appCompatImageView.setVisibility(View.VISIBLE);
            return;
        }
        ActivityAudioFilesBinding activityAudioFilesBinding3 = this.audioFilesBinding;
        RecyclerView recyclerView2 = activityAudioFilesBinding3 != null ? activityAudioFilesBinding3.recyclerView : null;
        if (recyclerView2 != null) {
            recyclerView2.setVisibility(View.VISIBLE);
        }
        ActivityAudioFilesBinding activityAudioFilesBinding4 = this.audioFilesBinding;
        appCompatImageView = activityAudioFilesBinding4 != null ? activityAudioFilesBinding4.ivError : null;
        if (appCompatImageView == null) {
            return;
        }
        appCompatImageView.setVisibility(View.GONE);
    }

    private final void setupRecyclerView() {
        RecyclerView recyclerView;
        this.audiosAdapter = new AudiosAdapter(new ArrayList(), new AudioFilesActivity$setupRecyclerView$1(this), new AudioFilesActivity$setupRecyclerView$2(this), new AudioFilesActivity$setupRecyclerView$3(this));
        ActivityAudioFilesBinding activityAudioFilesBinding = this.audioFilesBinding;
        if (activityAudioFilesBinding == null || (recyclerView = activityAudioFilesBinding.recyclerView) == null) {
            return;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        AudiosAdapter audiosAdapter = this.audiosAdapter;
        if (audiosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audiosAdapter");
            audiosAdapter = null;
        }
        recyclerView.setAdapter(audiosAdapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.AudioFilesActivity$setupRecyclerView$4$1
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
                z = AudioFilesActivity.this.isLoading;
                if (z || findLastVisibleItemPosition != itemCount - 1) {
                    return;
                }
                AudioFilesActivity.this.loadMoreAudios();
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
            ActivityAudioFilesBinding activityAudioFilesBinding = this.audioFilesBinding;
            if (activityAudioFilesBinding != null && (appCompatImageView2 = activityAudioFilesBinding.icSelectAll) != null) {
                appCompatImageView2.setImageResource(R.drawable.ic_check);
            }
            ActivityAudioFilesBinding activityAudioFilesBinding2 = this.audioFilesBinding;
            if (activityAudioFilesBinding2 == null || (textView2 = activityAudioFilesBinding2.allSelected) == null) {
                return;
            }
            textView2.setText(R.string.all_deselect);
            return;
        }
        ActivityAudioFilesBinding activityAudioFilesBinding3 = this.audioFilesBinding;
        if (activityAudioFilesBinding3 != null && (appCompatImageView = activityAudioFilesBinding3.icSelectAll) != null) {
            appCompatImageView.setImageResource(R.drawable.ic_dslct);
        }
        ActivityAudioFilesBinding activityAudioFilesBinding4 = this.audioFilesBinding;
        if (activityAudioFilesBinding4 == null || (textView = activityAudioFilesBinding4.allSelected) == null) {
            return;
        }
        textView.setText(R.string.all_select);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAudioClick(int position) {
        AudiosAdapter audiosAdapter = this.audiosAdapter;
        AudiosAdapter audiosAdapter2 = null;
        if (audiosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audiosAdapter");
            audiosAdapter = null;
        }
        if (audiosAdapter.getSelectedItemCount() <= 0) {
            AudiosAdapter audiosAdapter3 = this.audiosAdapter;
            if (audiosAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("audiosAdapter");
                audiosAdapter3 = null;
            }
            if (!audiosAdapter3.getIsAllSelected()) {
                AudiosAdapter audiosAdapter4 = this.audiosAdapter;
                if (audiosAdapter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("audiosAdapter");
                } else {
                    audiosAdapter2 = audiosAdapter4;
                }
                AudiosModel itemAtPosition = audiosAdapter2.getItemAtPosition(position);
                Intent intent = new Intent(this, (Class<?>) ViewAudioActivity.class);
                intent.putExtra("AUDIO_PATH", itemAtPosition.getFile().getAbsolutePath());
                intent.putExtra("FILE_TYPE", "audio");
                startActivity(intent);
                return;
            }
        }
        toggleSelection(position);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAudioLongClick(int position) {
        toggleSelection(position);
    }

    private final void toggleSelection(int position) {
        AudiosAdapter audiosAdapter = this.audiosAdapter;
        if (audiosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audiosAdapter");
            audiosAdapter = null;
        }
        audiosAdapter.toggleSelection(position);
        AudiosAdapter audiosAdapter2 = this.audiosAdapter;
        if (audiosAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audiosAdapter");
            audiosAdapter2 = null;
        }
        int selectedItemCount = audiosAdapter2.getSelectedItemCount();
        if (selectedItemCount > 0) {
            ActivityAudioFilesBinding activityAudioFilesBinding = this.audioFilesBinding;
            LinearLayout linearLayout = activityAudioFilesBinding != null ? activityAudioFilesBinding.llSelection : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(View.VISIBLE);
            }
            ActivityAudioFilesBinding activityAudioFilesBinding2 = this.audioFilesBinding;
            LinearLayout linearLayout2 = activityAudioFilesBinding2 != null ? activityAudioFilesBinding2.headerLayout : null;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(View.GONE);
            }
            ActivityAudioFilesBinding activityAudioFilesBinding3 = this.audioFilesBinding;
            TextView textView = activityAudioFilesBinding3 != null ? activityAudioFilesBinding3.tvRecover : null;
            if (textView == null) {
                return;
            }
            textView.setText("Recover (" + selectedItemCount + ')');
            return;
        }
        ActivityAudioFilesBinding activityAudioFilesBinding4 = this.audioFilesBinding;
        LinearLayout linearLayout3 = activityAudioFilesBinding4 != null ? activityAudioFilesBinding4.headerLayout : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(View.VISIBLE);
        }
        ActivityAudioFilesBinding activityAudioFilesBinding5 = this.audioFilesBinding;
        LinearLayout linearLayout4 = activityAudioFilesBinding5 != null ? activityAudioFilesBinding5.llSelection : null;
        if (linearLayout4 == null) {
            return;
        }
        linearLayout4.setVisibility(View.GONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadMoreAudios() {
        int i = this.currentPage * this.pageSize;
        if (i >= this.allAudiosList.size()) {
            return;
        }
        this.isLoading = true;
        List<AudiosModel> list = this.allAudiosList;
        List<AudiosModel> subList = list.subList(i, Math.min(this.pageSize + i, list.size()));
        AudiosAdapter audiosAdapter = this.audiosAdapter;
        if (audiosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audiosAdapter");
            audiosAdapter = null;
        }
        audiosAdapter.addAudios(subList, this.allAudiosList.size());
        Iterator<T> it = subList.iterator();
        while (it.hasNext()) {
            loadAudioDurationAsync((AudiosModel) it.next());
        }
        int i2 = this.currentPage + 1;
        this.currentPage = i2;
        this.isLoading = false;
        if (i2 * this.pageSize < this.allAudiosList.size()) {
            this.handler.post(new Runnable() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.AudioFilesActivity$$ExternalSyntheticLambda20
                @Override // java.lang.Runnable
                public final void run() {
                    AudioFilesActivity.loadMoreAudios$lambda$47(AudioFilesActivity.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadMoreAudios$lambda$47(AudioFilesActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.loadMoreAudios();
    }

    private final void selectAllAudios() {
        AudiosAdapter audiosAdapter = this.audiosAdapter;
        if (audiosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audiosAdapter");
            audiosAdapter = null;
        }
        audiosAdapter.selectAll();
        updateSelectionUI();
    }

    private final void deselectAllAudios() {
        AudiosAdapter audiosAdapter = this.audiosAdapter;
        if (audiosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audiosAdapter");
            audiosAdapter = null;
        }
        audiosAdapter.deselectAll();
        updateSelectionUI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSelectionUI() {
        int selectedItemCount;
        AudiosAdapter audiosAdapter = this.audiosAdapter;
        if (audiosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audiosAdapter");
            audiosAdapter = null;
        }
        if (audiosAdapter.getIsAllSelected()) {
            AudiosAdapter audiosAdapter2 = this.audiosAdapter;
            if (audiosAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("audiosAdapter");
                audiosAdapter2 = null;
            }
            selectedItemCount = audiosAdapter2.getTotalItemCount();
        } else {
            AudiosAdapter audiosAdapter3 = this.audiosAdapter;
            if (audiosAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("audiosAdapter");
                audiosAdapter3 = null;
            }
            selectedItemCount = audiosAdapter3.getSelectedItemCount();
        }
        if (selectedItemCount > 0) {
            ActivityAudioFilesBinding activityAudioFilesBinding = this.audioFilesBinding;
            LinearLayout linearLayout = activityAudioFilesBinding != null ? activityAudioFilesBinding.llSelection : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(View.VISIBLE);
            }
            ActivityAudioFilesBinding activityAudioFilesBinding2 = this.audioFilesBinding;
            LinearLayout linearLayout2 = activityAudioFilesBinding2 != null ? activityAudioFilesBinding2.headerLayout : null;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(View.GONE);
            }
            ActivityAudioFilesBinding activityAudioFilesBinding3 = this.audioFilesBinding;
            TextView textView = activityAudioFilesBinding3 != null ? activityAudioFilesBinding3.tvRecover : null;
            if (textView == null) {
                return;
            }
            textView.setText("Recover (" + selectedItemCount + ')');
            return;
        }
        ActivityAudioFilesBinding activityAudioFilesBinding4 = this.audioFilesBinding;
        LinearLayout linearLayout3 = activityAudioFilesBinding4 != null ? activityAudioFilesBinding4.headerLayout : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(View.VISIBLE);
        }
        ActivityAudioFilesBinding activityAudioFilesBinding5 = this.audioFilesBinding;
        LinearLayout linearLayout4 = activityAudioFilesBinding5 != null ? activityAudioFilesBinding5.llSelection : null;
        if (linearLayout4 == null) {
            return;
        }
        linearLayout4.setVisibility(View.GONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<AudiosModel> fetchAllAudios(List<String> audioPaths) {
        List<String> list = audioPaths;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            File file = new File((String) it.next());
            arrayList.add(new AudiosModel(file, 0L, new Date(file.lastModified()), 0L, 8, null));
        }
        return CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.AudioFilesActivity$fetchAllAudios$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((AudiosModel) t2).getDateAdded(), ((AudiosModel) t).getDateAdded());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<AudiosModel> fetchAudiosFromAlbum(String audioPaths) {
        if (audioPaths == null) {
            return CollectionsKt.emptyList();
        }
        File file = new File(audioPaths);
        if (!file.exists()) {
            return CollectionsKt.emptyList();
        }
        File[] listFiles = file.listFiles(new FileFilter() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.AudioFilesActivity$$ExternalSyntheticLambda13
            @Override // java.io.FileFilter
            public final boolean accept(File file2) {
                boolean fetchAudiosFromAlbum$lambda$50;
                fetchAudiosFromAlbum$lambda$50 = AudioFilesActivity.fetchAudiosFromAlbum$lambda$50(file2);
                return fetchAudiosFromAlbum$lambda$50;
            }
        });
        if (listFiles != null) {
            ArrayList arrayList = new ArrayList(listFiles.length);
            for (File file2 : listFiles) {
                Intrinsics.checkNotNull(file2);
                arrayList.add(new AudiosModel(file2, 0L, new Date(file2.lastModified()), 0L, 8, null));
            }
            List<AudiosModel> sortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.AudioFilesActivity$fetchAudiosFromAlbum$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(((AudiosModel) t2).getDateAdded(), ((AudiosModel) t).getDateAdded());
                }
            });
            if (sortedWith != null) {
                return sortedWith;
            }
        }
        return CollectionsKt.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean fetchAudiosFromAlbum$lambda$50(File file) {
        List listOf = CollectionsKt.listOf((Object[]) new String[]{"mp3", "wav", "m4a", "ogg", "flac", "opus", "aac", "aiff", "alac", "amr", "ape", "au", "dts", "mka", "ra", "wma", "wv"});
        Intrinsics.checkNotNull(file);
        String lowerCase = FilesKt.getExtension(file).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return listOf.contains(lowerCase);
    }

    private final void loadAudioDurationAsync(final AudiosModel audioModel) {
        new Thread(new Runnable() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.AudioFilesActivity$$ExternalSyntheticLambda21
            @Override // java.lang.Runnable
            public final void run() {
                AudioFilesActivity.loadAudioDurationAsync$lambda$54(AudioFilesActivity.this, audioModel);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadAudioDurationAsync$lambda$54(final AudioFilesActivity this$0, final AudiosModel audioModel) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(audioModel, "$audioModel");
        final long audioDuration = this$0.getAudioDuration(audioModel.getFile());
        this$0.runOnUiThread(new Runnable() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.AudioFilesActivity$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                AudioFilesActivity.loadAudioDurationAsync$lambda$54$lambda$53(AudiosModel.this, audioDuration, this$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadAudioDurationAsync$lambda$54$lambda$53(AudiosModel audioModel, long j, AudioFilesActivity this$0) {
        Intrinsics.checkNotNullParameter(audioModel, "$audioModel");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        audioModel.setDuration(j);
        AudiosAdapter audiosAdapter = this$0.audiosAdapter;
        if (audiosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audiosAdapter");
            audiosAdapter = null;
        }
        audiosAdapter.updateAudio(audioModel);
    }

    private final long getAudioDuration(File file) {
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
        AudiosAdapter audiosAdapter = this.audiosAdapter;
        if (audiosAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audiosAdapter");
            audiosAdapter = null;
        }
        if (audiosAdapter.getSelectedItemCount() > 0) {
            deselectAllAudios();
        } else {
            super.onBackPressed();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.audioFilesBinding = null;
        this.handler.removeCallbacksAndMessages(null);
    }
}
