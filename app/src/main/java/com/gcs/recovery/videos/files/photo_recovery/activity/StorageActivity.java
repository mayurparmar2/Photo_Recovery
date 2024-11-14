package com.gcs.recovery.videos.files.photo_recovery.activity;

import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.FileObserver;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import androidx.lifecycle.LifecycleOwnerKt;
import com.airbnb.lottie.LottieAnimationView;
import com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass;
import com.demo.example.databinding.ActivityStorageBinding;
import com.gcs.recovery.videos.files.photo_recovery.model.MediaFile;
import com.gcs.recovery.videos.files.photo_recovery.utils.JunkFileScanner;
import com.gcs.recovery.videos.files.photo_recovery.utils.SharedDataHolder;
import com.gcs.recovery.videos.files.photo_recovery.utils.Utils;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;



import org.objectweb.asm.signature.SignatureVisitor;

/* compiled from: StorageActivity.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0001;B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u0013\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0011H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0006H\u0002J\b\u0010\u001b\u001a\u00020\u0019H\u0002J1\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00110 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010#J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\rH\u0002J\b\u0010&\u001a\u00020\u0019H\u0016J\u0012\u0010'\u001a\u00020\u00192\b\u0010(\u001a\u0004\u0018\u00010)H\u0014J2\u0010*\u001a\u00020\u00192\f\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\r2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020%0.2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020100H\u0002J\b\u00102\u001a\u00020\u0019H\u0002J\b\u00103\u001a\u00020\u0019H\u0002J\b\u00104\u001a\u00020\u0019H\u0002J\u001a\u00105\u001a\u00020\u00192\u0006\u00106\u001a\u0002012\b\b\u0002\u00107\u001a\u00020\u0004H\u0002J\u001a\u00108\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00062\u0006\u00109\u001a\u00020\u0011H\u0002J\u0018\u0010:\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006<"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/activity/StorageActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "SIZE_THRESHOLD", "", "currentFileType", "Lcom/gcs/recovery/videos/files/photo_recovery/activity/StorageActivity$FileType;", "fileActivityLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "storageBinding", "Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ActivityStorageBinding;", "getDupFilesFromDirectory", "", "Ljava/io/File;", "directory", "getDuplicateFilesSize", "", "getFilesFromDirectory", "getJunkFilesSize", "getLargeFilesSize", "getScreenshotFilesSize", "isScanComplete", "", "launchFileActivity", "", "fileType", "loadAndDisplayFileSizes", "loadAndDisplaySize", "textView", "Landroid/widget/TextView;", "sizeFunction", "Lkotlin/Function0;", "animationView", "Lcom/airbnb/lottie/LottieAnimationView;", "(Landroid/widget/TextView;Lkotlin/jvm/functions/Function0;Lcom/airbnb/lottie/LottieAnimationView;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLargeFiles", "Lcom/gcs/recovery/videos/files/photo_recovery/model/MediaFile;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "queryMediaStoreFiles", "uris", "Landroid/net/Uri;", "largeFilesList", "", "uniqueFilePaths", "", "", "setupActivityResultLauncher", "setupFileObserver", "setupUI", "showToast", "message", TypedValues.TransitionType.S_DURATION, "updateFileSizeInUI", "updatedSize", "updateSharedDataHolder", "FileType", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class StorageActivity extends AppCompatActivity {
    private final int SIZE_THRESHOLD = 20971520;
    private FileType currentFileType;
    private ActivityResultLauncher<Intent> fileActivityLauncher;
    private ActivityStorageBinding storageBinding;

    /* compiled from: StorageActivity.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FileType.values().length];
            try {
                iArr[FileType.SCREENSHOT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FileType.LARGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FileType.DUPLICATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FileType.JUNK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityStorageBinding inflate = ActivityStorageBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.storageBinding = inflate;
        ActivityStorageBinding activityStorageBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storageBinding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        AdsClass adsClass = new AdsClass();
        ActivityStorageBinding activityStorageBinding2 = this.storageBinding;
        if (activityStorageBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storageBinding");
        } else {
            activityStorageBinding = activityStorageBinding2;
        }
        adsClass.refreshAd(activityStorageBinding.frameLayout, this, 0);
        loadAndDisplayFileSizes();
        setupFileObserver();
        setupUI();
        setupActivityResultLauncher();
    }

    private final void setupActivityResultLauncher() {
        this.fileActivityLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.StorageActivity$$ExternalSyntheticLambda1
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                StorageActivity.setupActivityResultLauncher$lambda$0(StorageActivity.this, (ActivityResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupActivityResultLauncher$lambda$0(StorageActivity this$0, ActivityResult result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getResultCode() == -1) {
            Intent data = result.getData();
            this$0.updateFileSizeInUI(this$0.currentFileType, data != null ? data.getLongExtra("updatedSize", 0L) : 0L);
        }
    }

    private final void updateFileSizeInUI(FileType fileType, long updatedSize) {
        TextView textView;
        if (fileType != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[fileType.ordinal()];
            ActivityStorageBinding activityStorageBinding = null;
            if (i == 1) {
                ActivityStorageBinding activityStorageBinding2 = this.storageBinding;
                if (activityStorageBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("storageBinding");
                } else {
                    activityStorageBinding = activityStorageBinding2;
                }
                textView = activityStorageBinding.scrSize;
            } else if (i == 2) {
                ActivityStorageBinding activityStorageBinding3 = this.storageBinding;
                if (activityStorageBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("storageBinding");
                } else {
                    activityStorageBinding = activityStorageBinding3;
                }
                textView = activityStorageBinding.largeSize;
            } else if (i == 3) {
                ActivityStorageBinding activityStorageBinding4 = this.storageBinding;
                if (activityStorageBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("storageBinding");
                } else {
                    activityStorageBinding = activityStorageBinding4;
                }
                textView = activityStorageBinding.dupSize;
            } else {
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                ActivityStorageBinding activityStorageBinding5 = this.storageBinding;
                if (activityStorageBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("storageBinding");
                } else {
                    activityStorageBinding = activityStorageBinding5;
                }
                textView = activityStorageBinding.junkSize;
            }
            Intrinsics.checkNotNull(textView);
            textView.setText(Utils.INSTANCE.formatSize(updatedSize));
            updateSharedDataHolder(fileType, updatedSize);
        }
    }

    private final void updateSharedDataHolder(FileType fileType, long updatedSize) {
        int i = WhenMappings.$EnumSwitchMapping$0[fileType.ordinal()];
        if (i == 1) {
            SharedDataHolder.INSTANCE.setScreenshotFilesSize(Long.valueOf(updatedSize));
            return;
        }
        if (i == 2) {
            SharedDataHolder.INSTANCE.setLargeFilesSize(Long.valueOf(updatedSize));
        } else if (i == 3) {
            SharedDataHolder.INSTANCE.setDuplicateFilesSize(Long.valueOf(updatedSize));
        } else {
            if (i != 4) {
                return;
            }
            SharedDataHolder.INSTANCE.setJunkFilesSize(Long.valueOf(updatedSize));
        }
    }

    private final void setupUI() {
        ActivityStorageBinding activityStorageBinding = this.storageBinding;
        if (activityStorageBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storageBinding");
            activityStorageBinding = null;
        }
        activityStorageBinding.icBack.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.StorageActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StorageActivity.setupUI$lambda$5$lambda$2(StorageActivity.this, view);
            }
        });
        for (Pair pair : CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(activityStorageBinding.scrBtn, FileType.SCREENSHOT), TuplesKt.to(activityStorageBinding.dupBtn, FileType.DUPLICATE), TuplesKt.to(activityStorageBinding.largeBtn, FileType.LARGE), TuplesKt.to(activityStorageBinding.junkBtn, FileType.JUNK)})) {
            ViewGroup viewGroup = (ViewGroup) pair.component1();
            final FileType fileType = (FileType) pair.component2();
            viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.StorageActivity$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StorageActivity.setupUI$lambda$5$lambda$4$lambda$3(StorageActivity.this, fileType, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupUI$lambda$5$lambda$2(StorageActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupUI$lambda$5$lambda$4$lambda$3(StorageActivity this$0, FileType type, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(type, "$type");
        this$0.currentFileType = type;
        this$0.launchFileActivity(type);
    }

    private final void launchFileActivity(FileType fileType) {
        Class cls;
        ActivityResultLauncher<Intent> activityResultLauncher = null;
        if (isScanComplete()) {
            int i = WhenMappings.$EnumSwitchMapping$0[fileType.ordinal()];
            if (i == 1) {
                cls = ScreenShotActivity.class;
            } else if (i == 2) {
                cls = LargeFileActivity.class;
            } else if (i == 3) {
                cls = DuplicateFileActivity.class;
            } else {
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                cls = DeepScanActivity.class;
            }
            ActivityResultLauncher<Intent> activityResultLauncher2 = this.fileActivityLauncher;
            if (activityResultLauncher2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fileActivityLauncher");
            } else {
                activityResultLauncher = activityResultLauncher2;
            }
            activityResultLauncher.launch(new Intent(this, (Class<?>) cls));
            return;
        }
        showToast$default(this, "Data is loading, please wait.", 0, 2, null);
    }

    private final boolean isScanComplete() {
        ActivityStorageBinding activityStorageBinding = this.storageBinding;
        if (activityStorageBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storageBinding");
            activityStorageBinding = null;
        }
        List listOf = CollectionsKt.listOf((Object[]) new LottieAnimationView[]{activityStorageBinding.progBarL, activityStorageBinding.progBarD, activityStorageBinding.progBarSS});
        if (!(listOf instanceof Collection) || !listOf.isEmpty()) {
            Iterator it = listOf.iterator();
            while (it.hasNext()) {
                if (((LottieAnimationView) it.next()).getVisibility() != 8) {
                    return false;
                }
            }
        }
        return true;
    }

    static /* synthetic */ void showToast$default(StorageActivity storageActivity, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        storageActivity.showToast(str, i);
    }

    private final void showToast(String message, int duration) {
        Toast.makeText(this, message, duration).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadAndDisplayFileSizes() {
        LottieAnimationView[] lottieAnimationViewArr = new LottieAnimationView[3];
        ActivityStorageBinding activityStorageBinding = this.storageBinding;
        if (activityStorageBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storageBinding");
            activityStorageBinding = null;
        }
        lottieAnimationViewArr[0] = activityStorageBinding.progBarL;
        ActivityStorageBinding activityStorageBinding2 = this.storageBinding;
        if (activityStorageBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storageBinding");
            activityStorageBinding2 = null;
        }
        lottieAnimationViewArr[1] = activityStorageBinding2.progBarD;
        ActivityStorageBinding activityStorageBinding3 = this.storageBinding;
        if (activityStorageBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storageBinding");
            activityStorageBinding3 = null;
        }
        lottieAnimationViewArr[2] = activityStorageBinding3.progBarSS;
        Iterator it = CollectionsKt.listOf((Object[]) lottieAnimationViewArr).iterator();
        while (it.hasNext()) {
            ((LottieAnimationView) it.next()).setVisibility(View.VISIBLE);
        }
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new StorageActivity$loadAndDisplayFileSizes$2(this, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object loadAndDisplaySize(TextView textView, Function0<Long> function0, LottieAnimationView lottieAnimationView, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new StorageActivity$loadAndDisplaySize$2(textView, function0.invoke().longValue(), lottieAnimationView, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getLargeFilesSize() {
        Long largeFilesSize = SharedDataHolder.INSTANCE.getLargeFilesSize();
        if (largeFilesSize != null) {
            return largeFilesSize.longValue();
        }
        List<MediaFile> loadLargeFiles = loadLargeFiles();
        Iterator<T> it = loadLargeFiles.iterator();
        long j = 0;
        while (it.hasNext()) {
            j += ((MediaFile) it.next()).getSize();
        }
        SharedDataHolder sharedDataHolder = SharedDataHolder.INSTANCE;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(loadLargeFiles, 10));
        Iterator<T> it2 = loadLargeFiles.iterator();
        while (it2.hasNext()) {
            arrayList.add(new File(((MediaFile) it2.next()).getFilePath()));
        }
        sharedDataHolder.setLargeFiles(arrayList);
        SharedDataHolder.INSTANCE.setLargeFilesSize(Long.valueOf(j));
        return j;
    }

    private final List<MediaFile> loadLargeFiles() {
        ArrayList arrayList = new ArrayList();
        queryMediaStoreFiles(CollectionsKt.listOf((Object[]) new Uri[]{MediaStore.Images.Media.EXTERNAL_CONTENT_URI, MediaStore.Video.Media.EXTERNAL_CONTENT_URI, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, MediaStore.Files.getContentUri("external")}), arrayList, new LinkedHashSet());
        return arrayList;
    }

    private final void queryMediaStoreFiles(List<? extends Uri> uris, List<MediaFile> largeFilesList, Set<String> uniqueFilePaths) {
        String str;
        String str2;
        String str3;
        String str4 = "_id";
        String str5 = "_display_name";
        String str6 = "_size";
        String[] strArr = {"_id", "_display_name", "_size", "_data"};
        String[] strArr2 = {String.valueOf(this.SIZE_THRESHOLD)};
        for (Uri uri : uris) {
            Cursor query = getContentResolver().query(uri, strArr, "_size >= ?", strArr2, null);
            if (query != null) {
                Cursor cursor = query;
                try {
                    Cursor cursor2 = cursor;
                    int columnIndexOrThrow = cursor2.getColumnIndexOrThrow(str4);
                    int columnIndexOrThrow2 = cursor2.getColumnIndexOrThrow(str5);
                    int columnIndexOrThrow3 = cursor2.getColumnIndexOrThrow(str6);
                    int columnIndexOrThrow4 = cursor2.getColumnIndexOrThrow("_data");
                    while (cursor2.moveToNext()) {
                        String str7 = str4;
                        String str8 = str5;
                        long j = cursor2.getLong(columnIndexOrThrow);
                        String string = cursor2.getString(columnIndexOrThrow2);
                        long j2 = cursor2.getLong(columnIndexOrThrow3);
                        String str9 = str6;
                        String string2 = cursor2.getString(columnIndexOrThrow4);
                        Uri withAppendedId = ContentUris.withAppendedId(uri, j);
                        Intrinsics.checkNotNullExpressionValue(withAppendedId, "withAppendedId(...)");
                        Intrinsics.checkNotNull(string2);
                        if (uniqueFilePaths.add(string2)) {
                            Intrinsics.checkNotNull(string);
                            largeFilesList.add(new MediaFile(string, string2, withAppendedId, j2, 0L));
                        }
                        str4 = str7;
                        str5 = str8;
                        str6 = str9;
                    }
                    str = str4;
                    str2 = str5;
                    str3 = str6;
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(cursor, null);
                } finally {
                }
            } else {
                str = str4;
                str2 = str5;
                str3 = str6;
            }
            str4 = str;
            str5 = str2;
            str6 = str3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getDuplicateFilesSize() {
        Long duplicateFilesSize = SharedDataHolder.INSTANCE.getDuplicateFilesSize();
        if (duplicateFilesSize != null) {
            return duplicateFilesSize.longValue();
        }
        List<File> dupFilesFromDirectory = getDupFilesFromDirectory(Environment.getExternalStorageDirectory());
        ArrayList arrayList = new ArrayList();
        for (Object obj : dupFilesFromDirectory) {
            if (((File) obj).length() > this.SIZE_THRESHOLD) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        long j = 0;
        while (it.hasNext()) {
            j += ((File) it.next()).length();
        }
        SharedDataHolder.INSTANCE.setDuplicateFiles(dupFilesFromDirectory);
        SharedDataHolder.INSTANCE.setDuplicateFilesSize(Long.valueOf(j));
        return j;
    }

    private final List<File> getDupFilesFromDirectory(File directory) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (directory != null && directory.exists()) {
            for (File file : SequencesKt.filter(FilesKt.walk$default(directory, null, 1, null), new Function1<File, Boolean>() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.StorageActivity$getDupFilesFromDirectory$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(File it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(it.isFile());
                }
            })) {
                String str = file.getName() + SignatureVisitor.SUPER + file.length();
                List list = (List) linkedHashMap.get(str);
                if (list != null) {
                    list.add(file);
                } else {
                    linkedHashMap.put(str, CollectionsKt.mutableListOf(file));
                }
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (((List) entry.getValue()).size() > 1) {
                linkedHashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = linkedHashMap2.entrySet().iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, (List) ((Map.Entry) it.next()).getValue());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getScreenshotFilesSize() {
        Long screenshotFilesSize = SharedDataHolder.INSTANCE.getScreenshotFilesSize();
        if (screenshotFilesSize != null) {
            return screenshotFilesSize.longValue();
        }
        long j = 0;
        if (SharedDataHolder.INSTANCE.getScreenshotFiles() != null) {
            List<File> screenshotFiles = SharedDataHolder.INSTANCE.getScreenshotFiles();
            Intrinsics.checkNotNull(screenshotFiles);
            Iterator<T> it = screenshotFiles.iterator();
            while (it.hasNext()) {
                j += ((File) it.next()).length();
            }
            return j;
        }
        Uri EXTERNAL_CONTENT_URI = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        Intrinsics.checkNotNullExpressionValue(EXTERNAL_CONTENT_URI, "EXTERNAL_CONTENT_URI");
        String[] strArr = {"%/Pictures/Screenshots/%", "%/DCIM/Screenshots/%", "%Screenshots%", "%screenshot%", "%screencapture%", MimeTypes.IMAGE_JPEG, MimeTypes.IMAGE_PNG, MimeTypes.IMAGE_WEBP, "image/gif", "image/bmp", MimeTypes.IMAGE_HEIF, "image/jpg"};
        Cursor query = getContentResolver().query(EXTERNAL_CONTENT_URI, new String[]{"_data", "_size", "_display_name"}, "(LOWER(_data) LIKE LOWER(?) OR LOWER(_data) LIKE LOWER(?) OR LOWER(_data) LIKE LOWER(?) OR LOWER(_display_name) LIKE LOWER(?) OR LOWER(_display_name) LIKE LOWER(?)) AND (mime_type IN (?, ?, ?, ?, ?, ?, ?))", strArr, null);
        ArrayList arrayList = new ArrayList();
        if (query != null) {
            Cursor cursor = query;
            try {
                Cursor cursor2 = cursor;
                int columnIndexOrThrow = cursor2.getColumnIndexOrThrow("_data");
                int columnIndexOrThrow2 = cursor2.getColumnIndexOrThrow("_size");
                while (cursor2.moveToNext()) {
                    String string = cursor2.getString(columnIndexOrThrow);
                    long j2 = cursor2.getLong(columnIndexOrThrow2);
                    arrayList.add(new File(string));
                    j += j2;
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(cursor, null);
            } finally {
            }
        }
        SharedDataHolder.INSTANCE.setScreenshotFiles(arrayList);
        SharedDataHolder.INSTANCE.setScreenshotFilesSize(Long.valueOf(j));
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getJunkFilesSize() {
        Long junkFilesSize = SharedDataHolder.INSTANCE.getJunkFilesSize();
        if (junkFilesSize != null) {
            return junkFilesSize.longValue();
        }
        List<File> filesFromDirectory = getFilesFromDirectory(Environment.getExternalStorageDirectory());
        ArrayList arrayList = new ArrayList();
        for (Object obj : filesFromDirectory) {
            if (JunkFileScanner.INSTANCE.isJunkFile((File) obj, this)) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        long j = 0;
        while (it.hasNext()) {
            j += ((File) it.next()).length();
        }
        SharedDataHolder.INSTANCE.setJunkFilesSize(Long.valueOf(j));
        return j;
    }

    private final List<File> getFilesFromDirectory(File directory) {
        if (directory != null && directory.exists()) {
            return SequencesKt.toList(SequencesKt.filter(FilesKt.walk$default(directory, null, 1, null), new Function1<File, Boolean>() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.StorageActivity$getFilesFromDirectory$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(File it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(it.isFile());
                }
            }));
        }
        return CollectionsKt.emptyList();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.gcs.recovery.videos.files.photo_recovery.activity.StorageActivity$setupFileObserver$observer$1] */
    private final void setupFileObserver() {
        final String path = Environment.getExternalStorageDirectory().getPath();
        new FileObserver(path) { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.StorageActivity$setupFileObserver$observer$1
            @Override // android.os.FileObserver
            public void onEvent(int event, String path2) {
                if (path2 != null) {
                    if (event == 2 || event == 256 || event == 512) {
                        SharedDataHolder.INSTANCE.setLargeFilesSize(null);
                        SharedDataHolder.INSTANCE.setDuplicateFilesSize(null);
                        SharedDataHolder.INSTANCE.setScreenshotFilesSize(null);
                        SharedDataHolder.INSTANCE.setJunkFilesSize(null);
                        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(StorageActivity.this), Dispatchers.getIO(), null, new StorageActivity$setupFileObserver$observer$1$onEvent$1(StorageActivity.this, null), 2, null);
                    }
                }
            }
        }.startWatching();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBackPressed$lambda$27(StorageActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        super.onBackPressed();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        AdsClass.showInterstitial(this, new AdsClass.onListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.StorageActivity$$ExternalSyntheticLambda0
            @Override // com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass.onListener
            public final void click() {
                StorageActivity.onBackPressed$lambda$27(StorageActivity.this);
            }
        });
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: StorageActivity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/activity/StorageActivity$FileType;", "", "(Ljava/lang/String;I)V", "SCREENSHOT", "LARGE", "DUPLICATE", "JUNK", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class FileType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ FileType[] $VALUES;
        public static final FileType SCREENSHOT = new FileType("SCREENSHOT", 0);
        public static final FileType LARGE = new FileType("LARGE", 1);
        public static final FileType DUPLICATE = new FileType("DUPLICATE", 2);
        public static final FileType JUNK = new FileType("JUNK", 3);

        private static final /* synthetic */ FileType[] $values() {
            return new FileType[]{SCREENSHOT, LARGE, DUPLICATE, JUNK};
        }

        public static EnumEntries<FileType> getEntries() {
            return $ENTRIES;
        }

        public static FileType valueOf(String str) {
            return (FileType) Enum.valueOf(FileType.class, str);
        }

        public static FileType[] values() {
            return (FileType[]) $VALUES.clone();
        }

        private FileType(String str, int i) {
        }

        static {
            FileType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }
}
