package com.gcs.recovery.videos.files.photo_recovery.activity;

import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.facebook.internal.AnalyticsEvents;
import com.demo.example.R;
import com.gcs.recovery.videos.files.photo_recovery.adapter.PreviewContentAdapter;
import com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass;
import com.demo.example.databinding.ActivityViewVideoBinding;
import com.gcs.recovery.videos.files.photo_recovery.model.FileAttributeModel;
import com.gcs.recovery.videos.files.photo_recovery.utils.SharedDataHolder;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ViewVideoActivity.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0012\u0010\u0012\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0010H\u0014J \u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u00020\u0010H\u0002J\u0016\u0010\u001b\u001a\u00020\u00102\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\b\u0010\u001d\u001a\u00020\u0010H\u0002J\b\u0010\u001e\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/activity/ViewVideoActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "filePath", "", "viewVideoBinding", "Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ActivityViewVideoBinding;", "gatherFileInfo", "", "Lcom/gcs/recovery/videos/files/photo_recovery/model/FileAttributeModel;", "getFileFormat", "getFileSize", "fileSizeInBytes", "", "getResolution", "loadVideoPreview", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "openFilePreviewActivity", "isImage", "", "isVideo", "recoverVideo", "setupRecyclerView", "fileInfoList", "shareFile", "showDeleteConfirmationDialog", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ViewVideoActivity extends AppCompatActivity {
    private String filePath;
    private ActivityViewVideoBinding viewVideoBinding;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityViewVideoBinding inflate = ActivityViewVideoBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.viewVideoBinding = inflate;
        ActivityViewVideoBinding activityViewVideoBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewVideoBinding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        String stringExtra = getIntent().getStringExtra("VIDEO_PATH");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.filePath = stringExtra;
        loadVideoPreview();
        String str = this.filePath;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filePath");
            str = null;
        }
        setupRecyclerView(gatherFileInfo(str));
        ActivityViewVideoBinding activityViewVideoBinding2 = this.viewVideoBinding;
        if (activityViewVideoBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewVideoBinding");
            activityViewVideoBinding2 = null;
        }
        activityViewVideoBinding2.icBack.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ViewVideoActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewVideoActivity.onCreate$lambda$0(ViewVideoActivity.this, view);
            }
        });
        if (getIntent().getBooleanExtra("IS_RECOVERED", false)) {
            ActivityViewVideoBinding activityViewVideoBinding3 = this.viewVideoBinding;
            if (activityViewVideoBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewVideoBinding");
                activityViewVideoBinding3 = null;
            }
            activityViewVideoBinding3.previewRecovery.setVisibility(View.GONE);
        } else {
            ActivityViewVideoBinding activityViewVideoBinding4 = this.viewVideoBinding;
            if (activityViewVideoBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewVideoBinding");
                activityViewVideoBinding4 = null;
            }
            activityViewVideoBinding4.previewRecovery.setVisibility(View.VISIBLE);
        }
        ActivityViewVideoBinding activityViewVideoBinding5 = this.viewVideoBinding;
        if (activityViewVideoBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewVideoBinding");
            activityViewVideoBinding5 = null;
        }
        activityViewVideoBinding5.previewRecovery.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ViewVideoActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewVideoActivity.onCreate$lambda$1(ViewVideoActivity.this, view);
            }
        });
        ActivityViewVideoBinding activityViewVideoBinding6 = this.viewVideoBinding;
        if (activityViewVideoBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewVideoBinding");
            activityViewVideoBinding6 = null;
        }
        activityViewVideoBinding6.icShare.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ViewVideoActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewVideoActivity.onCreate$lambda$2(ViewVideoActivity.this, view);
            }
        });
        ActivityViewVideoBinding activityViewVideoBinding7 = this.viewVideoBinding;
        if (activityViewVideoBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewVideoBinding");
            activityViewVideoBinding7 = null;
        }
        activityViewVideoBinding7.icDelete.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ViewVideoActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewVideoActivity.onCreate$lambda$3(ViewVideoActivity.this, view);
            }
        });
        ActivityViewVideoBinding activityViewVideoBinding8 = this.viewVideoBinding;
        if (activityViewVideoBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewVideoBinding");
        } else {
            activityViewVideoBinding = activityViewVideoBinding8;
        }
        activityViewVideoBinding.ivSuccess.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ViewVideoActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewVideoActivity.onCreate$lambda$4(ViewVideoActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(ViewVideoActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(ViewVideoActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.recoverVideo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(ViewVideoActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.shareFile();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(ViewVideoActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showDeleteConfirmationDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$4(ViewVideoActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivity(new Intent(this$0, (Class<?>) RecoveredFileActivity.class));
    }

    private final List<FileAttributeModel> gatherFileInfo(String filePath) {
        File file = new File(filePath);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault());
        String name = file.getName();
        String fileSize = getFileSize(file.length());
        String format = simpleDateFormat.format(new Date(file.lastModified()));
        String fileFormat = getFileFormat(filePath);
        String resolution = getResolution(filePath);
        Intrinsics.checkNotNull(name);
        Intrinsics.checkNotNull(format);
        return CollectionsKt.listOfNotNull((Object[]) new FileAttributeModel[]{new FileAttributeModel("Name:", name), new FileAttributeModel("Format:", fileFormat), new FileAttributeModel("Path:", filePath), new FileAttributeModel("Size:", fileSize), new FileAttributeModel("Date:", format), new FileAttributeModel("Resolution", resolution)});
    }

    private final String getFileSize(long fileSizeInBytes) {
        long j = 1024;
        long j2 = fileSizeInBytes / j;
        long j3 = j2 / j;
        long j4 = j3 / j;
        long j5 = fileSizeInBytes % j;
        if (j4 > 0) {
            return j4 + " GB";
        }
        if (j3 > 0) {
            return j3 + " MB";
        }
        if (j2 > 0) {
            return j2 + " KB";
        }
        return j5 + " B";
    }

    private final String getFileFormat(String filePath) {
        return FilesKt.getExtension(new File(filePath));
    }

    private final String getResolution(String filePath) {
        String str;
        Integer intOrNull;
        Integer intOrNull2;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(filePath);
                String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
                int i = 0;
                int intValue = (extractMetadata == null || (intOrNull2 = StringsKt.toIntOrNull(extractMetadata)) == null) ? 0 : intOrNull2.intValue();
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                if (extractMetadata2 != null && (intOrNull = StringsKt.toIntOrNull(extractMetadata2)) != null) {
                    i = intOrNull.intValue();
                }
                str = new StringBuilder().append(intValue).append('x').append(i).toString();
            } catch (Exception e) {
                e.printStackTrace();
                str = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
            }
            return str;
        } finally {
            mediaMetadataRetriever.release();
        }
    }

    private final void setupRecyclerView(List<FileAttributeModel> fileInfoList) {
        PreviewContentAdapter previewContentAdapter = new PreviewContentAdapter(fileInfoList);
        ActivityViewVideoBinding activityViewVideoBinding = this.viewVideoBinding;
        ActivityViewVideoBinding activityViewVideoBinding2 = null;
        if (activityViewVideoBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewVideoBinding");
            activityViewVideoBinding = null;
        }
        activityViewVideoBinding.rvPreviewContent.setLayoutManager(new LinearLayoutManager(this));
        ActivityViewVideoBinding activityViewVideoBinding3 = this.viewVideoBinding;
        if (activityViewVideoBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewVideoBinding");
        } else {
            activityViewVideoBinding2 = activityViewVideoBinding3;
        }
        activityViewVideoBinding2.rvPreviewContent.setAdapter(previewContentAdapter);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0077 A[Catch: IOException -> 0x00c4, TryCatch #0 {IOException -> 0x00c4, blocks: (B:3:0x0005, B:5:0x000c, B:6:0x0012, B:9:0x0030, B:12:0x0040, B:13:0x0071, B:15:0x0077, B:16:0x007a, B:19:0x00aa, B:20:0x00ae, B:22:0x00b9, B:23:0x00be, B:28:0x0056), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00aa A[Catch: IOException -> 0x00c4, TRY_ENTER, TryCatch #0 {IOException -> 0x00c4, blocks: (B:3:0x0005, B:5:0x000c, B:6:0x0012, B:9:0x0030, B:12:0x0040, B:13:0x0071, B:15:0x0077, B:16:0x007a, B:19:0x00aa, B:20:0x00ae, B:22:0x00b9, B:23:0x00be, B:28:0x0056), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b9 A[Catch: IOException -> 0x00c4, TryCatch #0 {IOException -> 0x00c4, blocks: (B:3:0x0005, B:5:0x000c, B:6:0x0012, B:9:0x0030, B:12:0x0040, B:13:0x0071, B:15:0x0077, B:16:0x007a, B:19:0x00aa, B:20:0x00ae, B:22:0x00b9, B:23:0x00be, B:28:0x0056), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void recoverVideo() {
        String str;
        ActivityViewVideoBinding activityViewVideoBinding;
        ActivityViewVideoBinding activityViewVideoBinding2;
        try {
            String str2 = this.filePath;
            ActivityViewVideoBinding activityViewVideoBinding3 = null;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("filePath");
                str2 = null;
            }
            File file = new File(str2);
            File file2 = new File(Environment.getExternalStorageDirectory(), "PhotoRecovery/Videos");
            String name = file.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            if (!StringsKt.startsWith$default(name, ".", false, 2, (Object) null)) {
                String name2 = file.getName();
                Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                if (!StringsKt.startsWith$default(name2, "-", false, 2, (Object) null)) {
                    str = FilesKt.getNameWithoutExtension(file) + ".mp4";
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    File file3 = new File(file2, str);
                    FilesKt.copyTo$default(file, file3, true, 0, 4, null);
                    Toast.makeText(this, "Video recovered successfully", Toast.LENGTH_SHORT).show();
                    MediaScannerConnection.scanFile(this, new String[]{file3.getAbsolutePath()}, null, null);
                    activityViewVideoBinding = this.viewVideoBinding;
                    if (activityViewVideoBinding == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewVideoBinding");
                        activityViewVideoBinding = null;
                    }
                    activityViewVideoBinding.previewRecovery.setVisibility(View.GONE);
                    activityViewVideoBinding2 = this.viewVideoBinding;
                    if (activityViewVideoBinding2 != null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewVideoBinding");
                    } else {
                        activityViewVideoBinding3 = activityViewVideoBinding2;
                    }
                    activityViewVideoBinding3.ivSuccess.setVisibility(View.VISIBLE);
                }
            }
            str = StringsKt.removePrefix(FilesKt.getNameWithoutExtension(file), (CharSequence) ".") + ".mp4";
            if (!file2.exists()) {
            }
            File file32 = new File(file2, str);
            FilesKt.copyTo$default(file, file32, true, 0, 4, null);
            Toast.makeText(this, "Video recovered successfully", Toast.LENGTH_SHORT).show();
            MediaScannerConnection.scanFile(this, new String[]{file32.getAbsolutePath()}, null, null);
            activityViewVideoBinding = this.viewVideoBinding;
            if (activityViewVideoBinding == null) {
            }
            activityViewVideoBinding.previewRecovery.setVisibility(View.GONE);
            activityViewVideoBinding2 = this.viewVideoBinding;
            if (activityViewVideoBinding2 != null) {
            }
            activityViewVideoBinding3.ivSuccess.setVisibility(View.VISIBLE);
        } catch (IOException e) {
            Toast.makeText(this, "Failed to recover the video", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    private final void loadVideoPreview() {
        ActivityViewVideoBinding activityViewVideoBinding = this.viewVideoBinding;
        String str = null;
        if (activityViewVideoBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewVideoBinding");
            activityViewVideoBinding = null;
        }
        View inflate = activityViewVideoBinding.vsVideo.inflate();
        ImageView imageView = inflate != null ? (ImageView) inflate.findViewById(R.id.iv_preview_video) : null;
        if (imageView != null) {
            RequestManager with = Glide.with((FragmentActivity) this);
            String str2 = this.filePath;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("filePath");
            } else {
                str = str2;
            }
            with.load(Uri.fromFile(new File(str))).thumbnail(0.1f).placeholder(R.drawable.ic_video_placeholder).error(R.drawable.ic_video_placeholder).into(imageView);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ViewVideoActivity$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ViewVideoActivity.loadVideoPreview$lambda$6$lambda$5(ViewVideoActivity.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadVideoPreview$lambda$6$lambda$5(ViewVideoActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = this$0.filePath;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filePath");
            str = null;
        }
        this$0.openFilePreviewActivity(str, false, true);
    }

    private final void openFilePreviewActivity(String filePath, boolean isImage, boolean isVideo) {
        Intent intent = new Intent(this, (Class<?>) FilePreviewActivity.class);
        intent.putExtra("FILE_URI", Uri.fromFile(new File(filePath)).toString());
        intent.putExtra("IS_IMAGE", isImage);
        intent.putExtra("IS_VIDEO", isVideo);
        startActivity(intent);
    }

    private final void showDeleteConfirmationDialog() {
        View inflate = getLayoutInflater().inflate(R.layout.dialog_delete_alert, (ViewGroup) null);
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(inflate);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.iv_no_btn);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.iv_yes_btn);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ViewVideoActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewVideoActivity.showDeleteConfirmationDialog$lambda$8(BottomSheetDialog.this, view);
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ViewVideoActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewVideoActivity.showDeleteConfirmationDialog$lambda$10(ViewVideoActivity.this, bottomSheetDialog, view);
            }
        });
        bottomSheetDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDeleteConfirmationDialog$lambda$8(BottomSheetDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDeleteConfirmationDialog$lambda$10(ViewVideoActivity this$0, BottomSheetDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        String str = this$0.filePath;
        ArrayList arrayList = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filePath");
            str = null;
        }
        File file = new File(str);
        if (file.exists() && file.delete()) {
            ViewVideoActivity viewVideoActivity = this$0;
            MediaScannerConnection.scanFile(viewVideoActivity, new String[]{file.getAbsolutePath()}, null, null);
            Toast.makeText(viewVideoActivity, "Video deleted successfully", Toast.LENGTH_SHORT).show();
            SharedDataHolder sharedDataHolder = SharedDataHolder.INSTANCE;
            List<File> videoFiles = SharedDataHolder.INSTANCE.getVideoFiles();
            if (videoFiles != null) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : videoFiles) {
                    String absolutePath = ((File) obj).getAbsolutePath();
                    String str2 = this$0.filePath;
                    if (str2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("filePath");
                        str2 = null;
                    }
                    if (!Intrinsics.areEqual(absolutePath, str2)) {
                        arrayList2.add(obj);
                    }
                }
                arrayList = arrayList2;
            }
            sharedDataHolder.setVideoFiles(arrayList);
            this$0.onBackPressed();
        } else {
            Toast.makeText(this$0, "Failed to delete the video", Toast.LENGTH_SHORT).show();
        }
        dialog.dismiss();
    }

    private final void shareFile() {
        String str = this.filePath;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filePath");
            str = null;
        }
        Uri uriForFile = FileProvider.getUriForFile(this, getPackageName() + ".provider", new File(str));
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("video/*");
        intent.putExtra("android.intent.extra.STREAM", uriForFile);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        startActivity(Intent.createChooser(intent, "Share Video"));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        AdsClass.showInterstitial(this, new AdsClass.onListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ViewVideoActivity$$ExternalSyntheticLambda6
            @Override // com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass.onListener
            public final void click() {
                ViewVideoActivity.onBackPressed$lambda$12(ViewVideoActivity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBackPressed$lambda$12(ViewVideoActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        if (this.viewVideoBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewVideoBinding");
        }
        super.onDestroy();
    }
}
