package com.gcs.recovery.videos.files.photo_recovery.activity;

import android.content.Intent;
import android.graphics.BitmapFactory;
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
import com.demo.example.R;
import com.gcs.recovery.videos.files.photo_recovery.adapter.PreviewContentAdapter;
import com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass;
import com.demo.example.databinding.ActivityFileViewBinding;
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

/* compiled from: ViewPhotoActivity.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0012\u0010\u0012\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J \u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u0010H\u0002J\u0016\u0010\u001a\u001a\u00020\u00102\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\b\u0010\u001c\u001a\u00020\u0010H\u0002J\b\u0010\u001d\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/activity/ViewPhotoActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "filePath", "", "fileViewBinding", "Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ActivityFileViewBinding;", "gatherFileInfo", "", "Lcom/gcs/recovery/videos/files/photo_recovery/model/FileAttributeModel;", "getFileFormat", "getFileSize", "fileSizeInBytes", "", "getResolution", "loadPhotoPreview", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "openFilePreviewActivity", "isImage", "", "isVideo", "recoverPhoto", "setupRecyclerView", "fileInfoList", "shareFile", "showDeleteConfirmationDialog", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ViewPhotoActivity extends AppCompatActivity {
    private String filePath;
    private ActivityFileViewBinding fileViewBinding;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityFileViewBinding inflate = ActivityFileViewBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.fileViewBinding = inflate;
        ActivityFileViewBinding activityFileViewBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileViewBinding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        String stringExtra = getIntent().getStringExtra("PHOTO_PATH");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.filePath = stringExtra;
        if (stringExtra == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filePath");
            stringExtra = null;
        }
        setupRecyclerView(gatherFileInfo(stringExtra));
        if (getIntent().getBooleanExtra("IS_RECOVERED", false)) {
            ActivityFileViewBinding activityFileViewBinding2 = this.fileViewBinding;
            if (activityFileViewBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fileViewBinding");
                activityFileViewBinding2 = null;
            }
            activityFileViewBinding2.previewRecovery.setVisibility(View.GONE);
        } else {
            ActivityFileViewBinding activityFileViewBinding3 = this.fileViewBinding;
            if (activityFileViewBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fileViewBinding");
                activityFileViewBinding3 = null;
            }
            activityFileViewBinding3.previewRecovery.setVisibility(View.VISIBLE);
        }
        ActivityFileViewBinding activityFileViewBinding4 = this.fileViewBinding;
        if (activityFileViewBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileViewBinding");
            activityFileViewBinding4 = null;
        }
        activityFileViewBinding4.icShare.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ViewPhotoActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewPhotoActivity.onCreate$lambda$0(ViewPhotoActivity.this, view);
            }
        });
        ActivityFileViewBinding activityFileViewBinding5 = this.fileViewBinding;
        if (activityFileViewBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileViewBinding");
            activityFileViewBinding5 = null;
        }
        activityFileViewBinding5.icBack.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ViewPhotoActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewPhotoActivity.onCreate$lambda$1(ViewPhotoActivity.this, view);
            }
        });
        ActivityFileViewBinding activityFileViewBinding6 = this.fileViewBinding;
        if (activityFileViewBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileViewBinding");
            activityFileViewBinding6 = null;
        }
        activityFileViewBinding6.previewRecovery.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ViewPhotoActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewPhotoActivity.onCreate$lambda$2(ViewPhotoActivity.this, view);
            }
        });
        ActivityFileViewBinding activityFileViewBinding7 = this.fileViewBinding;
        if (activityFileViewBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileViewBinding");
            activityFileViewBinding7 = null;
        }
        activityFileViewBinding7.icDelete.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ViewPhotoActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewPhotoActivity.onCreate$lambda$3(ViewPhotoActivity.this, view);
            }
        });
        loadPhotoPreview();
        ActivityFileViewBinding activityFileViewBinding8 = this.fileViewBinding;
        if (activityFileViewBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileViewBinding");
        } else {
            activityFileViewBinding = activityFileViewBinding8;
        }
        activityFileViewBinding.ivSuccess.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ViewPhotoActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewPhotoActivity.onCreate$lambda$4(ViewPhotoActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(ViewPhotoActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.shareFile();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(ViewPhotoActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(ViewPhotoActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.recoverPhoto();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(ViewPhotoActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showDeleteConfirmationDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$4(ViewPhotoActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivity(new Intent(this$0, (Class<?>) RecoveredFileActivity.class));
    }

    private final void showDeleteConfirmationDialog() {
        View inflate = getLayoutInflater().inflate(R.layout.dialog_delete_alert, (ViewGroup) null);
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(inflate);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.iv_no_btn);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.iv_yes_btn);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ViewPhotoActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewPhotoActivity.showDeleteConfirmationDialog$lambda$5(BottomSheetDialog.this, view);
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ViewPhotoActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewPhotoActivity.showDeleteConfirmationDialog$lambda$7(ViewPhotoActivity.this, bottomSheetDialog, view);
            }
        });
        bottomSheetDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDeleteConfirmationDialog$lambda$5(BottomSheetDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDeleteConfirmationDialog$lambda$7(ViewPhotoActivity this$0, BottomSheetDialog dialog, View view) {
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
            ViewPhotoActivity viewPhotoActivity = this$0;
            MediaScannerConnection.scanFile(viewPhotoActivity, new String[]{file.getAbsolutePath()}, null, null);
            Toast.makeText(viewPhotoActivity, "Photo deleted successfully", Toast.LENGTH_SHORT).show();
            SharedDataHolder sharedDataHolder = SharedDataHolder.INSTANCE;
            List<File> photoFiles = SharedDataHolder.INSTANCE.getPhotoFiles();
            if (photoFiles != null) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : photoFiles) {
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
            sharedDataHolder.setPhotoFiles(arrayList);
            this$0.onBackPressed();
        } else {
            Toast.makeText(this$0, "Failed to delete the photo", Toast.LENGTH_SHORT).show();
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
        intent.setType("photo/*");
        intent.putExtra("android.intent.extra.STREAM", uriForFile);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        startActivity(Intent.createChooser(intent, "Share Photo"));
    }

    private final void recoverPhoto() {
        String str;
        try {
            String str2 = this.filePath;
            ActivityFileViewBinding activityFileViewBinding = null;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("filePath");
                str2 = null;
            }
            File file = new File(str2);
            File file2 = new File(Environment.getExternalStorageDirectory(), "PhotoRecovery/Photos");
            String name = file.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            if (StringsKt.startsWith$default(name, ".", false, 2, (Object) null)) {
                str = StringsKt.removePrefix(FilesKt.getNameWithoutExtension(file), (CharSequence) ".") + ".jpg";
            } else {
                str = FilesKt.getNameWithoutExtension(file) + ".jpg";
            }
            if (!file2.exists()) {
                file2.mkdirs();
            }
            File file3 = new File(file2, str);
            FilesKt.copyTo$default(file, file3, true, 0, 4, null);
            Toast.makeText(this, "Photo recovered successfully", Toast.LENGTH_SHORT).show();
            MediaScannerConnection.scanFile(this, new String[]{file3.getAbsolutePath()}, null, null);
            ActivityFileViewBinding activityFileViewBinding2 = this.fileViewBinding;
            if (activityFileViewBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fileViewBinding");
                activityFileViewBinding2 = null;
            }
            activityFileViewBinding2.previewRecovery.setVisibility(View.GONE);
            ActivityFileViewBinding activityFileViewBinding3 = this.fileViewBinding;
            if (activityFileViewBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fileViewBinding");
            } else {
                activityFileViewBinding = activityFileViewBinding3;
            }
            activityFileViewBinding.ivSuccess.setVisibility(View.VISIBLE);
        } catch (IOException e) {
            Toast.makeText(this, "Failed to recover the photo", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
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

    private final void loadPhotoPreview() {
        ActivityFileViewBinding activityFileViewBinding = this.fileViewBinding;
        String str = null;
        if (activityFileViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileViewBinding");
            activityFileViewBinding = null;
        }
        View inflate = activityFileViewBinding.vsPhoto.inflate();
        ImageView imageView = inflate != null ? (ImageView) inflate.findViewById(R.id.iv_preview_photo) : null;
        if (imageView != null) {
            RequestManager with = Glide.with((FragmentActivity) this);
            String str2 = this.filePath;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("filePath");
            } else {
                str = str2;
            }
            with.load(Uri.fromFile(new File(str))).placeholder(R.drawable.ic_image_placeholder).error(R.drawable.ic_image_placeholder).into(imageView);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ViewPhotoActivity$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ViewPhotoActivity.loadPhotoPreview$lambda$10$lambda$9(ViewPhotoActivity.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadPhotoPreview$lambda$10$lambda$9(ViewPhotoActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = this$0.filePath;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filePath");
            str = null;
        }
        this$0.openFilePreviewActivity(str, true, false);
    }

    private final void openFilePreviewActivity(String filePath, boolean isImage, boolean isVideo) {
        Intent intent = new Intent(this, (Class<?>) FilePreviewActivity.class);
        intent.putExtra("FILE_URI", Uri.fromFile(new File(filePath)).toString());
        intent.putExtra("IS_IMAGE", isImage);
        intent.putExtra("IS_VIDEO", isVideo);
        startActivity(intent);
    }

    private final String getResolution(String filePath) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, options);
        return new StringBuilder().append(options.outWidth).append('x').append(options.outHeight).toString();
    }

    private final void setupRecyclerView(List<FileAttributeModel> fileInfoList) {
        PreviewContentAdapter previewContentAdapter = new PreviewContentAdapter(fileInfoList);
        ActivityFileViewBinding activityFileViewBinding = this.fileViewBinding;
        ActivityFileViewBinding activityFileViewBinding2 = null;
        if (activityFileViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileViewBinding");
            activityFileViewBinding = null;
        }
        activityFileViewBinding.rvPreviewContent.setLayoutManager(new LinearLayoutManager(this));
        ActivityFileViewBinding activityFileViewBinding3 = this.fileViewBinding;
        if (activityFileViewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fileViewBinding");
        } else {
            activityFileViewBinding2 = activityFileViewBinding3;
        }
        activityFileViewBinding2.rvPreviewContent.setAdapter(previewContentAdapter);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        AdsClass.showInterstitial(this, new AdsClass.onListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ViewPhotoActivity$$ExternalSyntheticLambda6
            @Override // com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass.onListener
            public final void click() {
                ViewPhotoActivity.onBackPressed$lambda$13(ViewPhotoActivity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBackPressed$lambda$13(ViewPhotoActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }
}
