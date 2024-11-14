package com.gcs.recovery.videos.files.photo_recovery.activity;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.demo.example.R;
import com.gcs.recovery.videos.files.photo_recovery.adapter.PreviewContentAdapter;
import com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass;
import com.demo.example.databinding.ActivityViewDocBinding;
import com.gcs.recovery.videos.files.photo_recovery.model.FileAttributeModel;
import com.gcs.recovery.videos.files.photo_recovery.utils.SharedDataHolder;
import com.gcs.recovery.videos.files.photo_recovery.utils.Utils;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.onesignal.inAppMessages.internal.InAppMessageContent;
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

/* compiled from: ViewDocActivity.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0012\u0010\u0013\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0011H\u0002J\u0016\u0010\u0017\u001a\u00020\u00112\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\b\u0010\u0019\u001a\u00020\u0011H\u0002J\b\u0010\u001a\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/activity/ViewDocActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "filePath", "", "viewDocBinding", "Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ActivityViewDocBinding;", "gatherFileInfo", "", "Lcom/gcs/recovery/videos/files/photo_recovery/model/FileAttributeModel;", "getFileFormat", "getFileSize", "fileSizeInBytes", "", "getMimeType", "fileExtension", "loadDocumentPreview", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "recoverFile", "setupRecyclerView", "fileInfoList", "shareFile", "showDeleteConfirmationDialog", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ViewDocActivity extends AppCompatActivity {
    private String filePath;
    private ActivityViewDocBinding viewDocBinding;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityViewDocBinding inflate = ActivityViewDocBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.viewDocBinding = inflate;
        ActivityViewDocBinding activityViewDocBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDocBinding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        String stringExtra = getIntent().getStringExtra("DOC_PATH");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.filePath = stringExtra;
        if (getIntent().getBooleanExtra("IS_RECOVERED", false)) {
            ActivityViewDocBinding activityViewDocBinding2 = this.viewDocBinding;
            if (activityViewDocBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDocBinding");
                activityViewDocBinding2 = null;
            }
            activityViewDocBinding2.previewRecovery.setVisibility(View.GONE);
        } else {
            ActivityViewDocBinding activityViewDocBinding3 = this.viewDocBinding;
            if (activityViewDocBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDocBinding");
                activityViewDocBinding3 = null;
            }
            activityViewDocBinding3.previewRecovery.setVisibility(View.VISIBLE);
        }
        loadDocumentPreview();
        String str = this.filePath;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filePath");
            str = null;
        }
        setupRecyclerView(gatherFileInfo(str));
        ActivityViewDocBinding activityViewDocBinding4 = this.viewDocBinding;
        if (activityViewDocBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDocBinding");
            activityViewDocBinding4 = null;
        }
        activityViewDocBinding4.icBack.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ViewDocActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewDocActivity.onCreate$lambda$0(ViewDocActivity.this, view);
            }
        });
        ActivityViewDocBinding activityViewDocBinding5 = this.viewDocBinding;
        if (activityViewDocBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDocBinding");
            activityViewDocBinding5 = null;
        }
        activityViewDocBinding5.icShare.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ViewDocActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewDocActivity.onCreate$lambda$1(ViewDocActivity.this, view);
            }
        });
        ActivityViewDocBinding activityViewDocBinding6 = this.viewDocBinding;
        if (activityViewDocBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDocBinding");
            activityViewDocBinding6 = null;
        }
        activityViewDocBinding6.icDelete.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ViewDocActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewDocActivity.onCreate$lambda$2(ViewDocActivity.this, view);
            }
        });
        ActivityViewDocBinding activityViewDocBinding7 = this.viewDocBinding;
        if (activityViewDocBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDocBinding");
            activityViewDocBinding7 = null;
        }
        activityViewDocBinding7.previewRecovery.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ViewDocActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewDocActivity.onCreate$lambda$3(ViewDocActivity.this, view);
            }
        });
        ActivityViewDocBinding activityViewDocBinding8 = this.viewDocBinding;
        if (activityViewDocBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDocBinding");
        } else {
            activityViewDocBinding = activityViewDocBinding8;
        }
        activityViewDocBinding.ivSuccess.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ViewDocActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewDocActivity.onCreate$lambda$4(ViewDocActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(ViewDocActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(ViewDocActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.shareFile();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(ViewDocActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showDeleteConfirmationDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(ViewDocActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.recoverFile();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$4(ViewDocActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivity(new Intent(this$0, (Class<?>) RecoveredFileActivity.class));
    }

    private final void setupRecyclerView(List<FileAttributeModel> fileInfoList) {
        PreviewContentAdapter previewContentAdapter = new PreviewContentAdapter(fileInfoList);
        ActivityViewDocBinding activityViewDocBinding = this.viewDocBinding;
        ActivityViewDocBinding activityViewDocBinding2 = null;
        if (activityViewDocBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDocBinding");
            activityViewDocBinding = null;
        }
        activityViewDocBinding.rvPreviewContent.setLayoutManager(new LinearLayoutManager(this));
        ActivityViewDocBinding activityViewDocBinding3 = this.viewDocBinding;
        if (activityViewDocBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDocBinding");
        } else {
            activityViewDocBinding2 = activityViewDocBinding3;
        }
        activityViewDocBinding2.rvPreviewContent.setAdapter(previewContentAdapter);
    }

    private final void loadDocumentPreview() {
        ActivityViewDocBinding activityViewDocBinding = this.viewDocBinding;
        String str = null;
        if (activityViewDocBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDocBinding");
            activityViewDocBinding = null;
        }
        View inflate = activityViewDocBinding.vsDocument.inflate();
        ImageView imageView = inflate != null ? (ImageView) inflate.findViewById(R.id.iv_holder) : null;
        TextView textView = inflate != null ? (TextView) inflate.findViewById(R.id.tv_document_open) : null;
        String str2 = this.filePath;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filePath");
        } else {
            str = str2;
        }
        String fileFormat = getFileFormat(str);
        Locale ROOT = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
        String lowerCase = fileFormat.toLowerCase(ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        int fileIconResource = Utils.INSTANCE.getFileIconResource(lowerCase);
        if (imageView != null) {
            imageView.setImageResource(fileIconResource);
        }
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ViewDocActivity$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ViewDocActivity.loadDocumentPreview$lambda$6(ViewDocActivity.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadDocumentPreview$lambda$6(ViewDocActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = this$0.filePath;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filePath");
            str = null;
        }
        File file = new File(str);
        ViewDocActivity viewDocActivity = this$0;
        Uri uriForFile = FileProvider.getUriForFile(viewDocActivity, this$0.getPackageName() + ".provider", file);
        String mimeType = this$0.getMimeType(FilesKt.getExtension(file));
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(uriForFile, mimeType);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        List<ResolveInfo> queryIntentActivities = this$0.getPackageManager().queryIntentActivities(intent, 65536);
        Intrinsics.checkNotNullExpressionValue(queryIntentActivities, "queryIntentActivities(...)");
        if (true ^ queryIntentActivities.isEmpty()) {
            this$0.startActivity(Intent.createChooser(intent, "Open with"));
        } else {
            Toast.makeText(viewDocActivity, "No application found to open this file type.", Toast.LENGTH_SHORT).show();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0046, code lost:
    
        if (r4.equals("docx") == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0067, code lost:
    
        if (r4.equals("xls") == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x009a, code lost:
    
        if (r4.equals("doc") == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x001e, code lost:
    
        if (r4.equals("xlsx") == false) goto L55;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String getMimeType(String fileExtension) {
        String lowerCase = fileExtension.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        switch (lowerCase.hashCode()) {
            case 96322:
                if (!lowerCase.equals("aab")) {
                }
                break;
            case 96796:
                if (!lowerCase.equals("apk")) {
                }
                break;
            case 99640:
                break;
            case 103649:
                if (!lowerCase.equals("htm")) {
                }
                break;
            case 110834:
                if (!lowerCase.equals("pdf")) {
                }
                break;
            case 111220:
                if (!lowerCase.equals("ppt")) {
                }
                break;
            case 115312:
                if (!lowerCase.equals("txt")) {
                }
                break;
            case 118783:
                break;
            case 118807:
                if (!lowerCase.equals("xml")) {
                }
                break;
            case 120609:
                if (!lowerCase.equals("zip")) {
                }
                break;
            case 3088960:
                break;
            case 3213227:
                if (!lowerCase.equals(InAppMessageContent.HTML)) {
                }
                break;
            case 3447940:
                if (!lowerCase.equals("pptx")) {
                }
                break;
            case 3671716:
                if (!lowerCase.equals("xapk")) {
                }
                break;
            case 3682393:
                break;
        }
        return "text/html";
    }

    private final List<FileAttributeModel> gatherFileInfo(String filePath) {
        File file = new File(filePath);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault());
        String name = file.getName();
        String fileSize = getFileSize(file.length());
        String format = simpleDateFormat.format(new Date(file.lastModified()));
        String fileFormat = getFileFormat(filePath);
        Intrinsics.checkNotNull(name);
        Intrinsics.checkNotNull(format);
        return CollectionsKt.listOf((Object[]) new FileAttributeModel[]{new FileAttributeModel("Name:", name), new FileAttributeModel("Format:", fileFormat), new FileAttributeModel("Path:", filePath), new FileAttributeModel("Size:", fileSize), new FileAttributeModel("Date:", format)});
    }

    private final String getFileFormat(String filePath) {
        return FilesKt.getExtension(new File(filePath));
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

    private final void showDeleteConfirmationDialog() {
        View inflate = getLayoutInflater().inflate(R.layout.dialog_delete_alert, (ViewGroup) null);
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(inflate);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.iv_no_btn);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.iv_yes_btn);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ViewDocActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewDocActivity.showDeleteConfirmationDialog$lambda$7(BottomSheetDialog.this, view);
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ViewDocActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewDocActivity.showDeleteConfirmationDialog$lambda$9(ViewDocActivity.this, bottomSheetDialog, view);
            }
        });
        bottomSheetDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDeleteConfirmationDialog$lambda$7(BottomSheetDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDeleteConfirmationDialog$lambda$9(ViewDocActivity this$0, BottomSheetDialog dialog, View view) {
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
            ViewDocActivity viewDocActivity = this$0;
            MediaScannerConnection.scanFile(viewDocActivity, new String[]{file.getAbsolutePath()}, null, null);
            Toast.makeText(viewDocActivity, "Document deleted successfully", Toast.LENGTH_SHORT).show();
            SharedDataHolder sharedDataHolder = SharedDataHolder.INSTANCE;
            List<File> docFiles = SharedDataHolder.INSTANCE.getDocFiles();
            if (docFiles != null) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : docFiles) {
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
            sharedDataHolder.setDocFiles(arrayList);
            this$0.onBackPressed();
        } else {
            Toast.makeText(this$0, "Failed to delete the Document", Toast.LENGTH_SHORT).show();
        }
        dialog.dismiss();
    }

    private final void recoverFile() {
        String str;
        try {
            String str2 = this.filePath;
            ActivityViewDocBinding activityViewDocBinding = null;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("filePath");
                str2 = null;
            }
            File file = new File(str2);
            File file2 = new File(Environment.getExternalStorageDirectory(), "PhotoRecovery/Documents");
            String name = file.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            if (StringsKt.startsWith$default(name, ".", false, 2, (Object) null)) {
                str = StringsKt.removePrefix(FilesKt.getNameWithoutExtension(file), (CharSequence) ".") + ".pdf";
            } else {
                str = FilesKt.getNameWithoutExtension(file) + ".pdf";
            }
            if (!file2.exists()) {
                file2.mkdirs();
            }
            File file3 = new File(file2, str);
            FilesKt.copyTo$default(file, file3, true, 0, 4, null);
            Toast.makeText(this, "Document recovered successfully", Toast.LENGTH_SHORT).show();
            MediaScannerConnection.scanFile(this, new String[]{file3.getAbsolutePath()}, null, null);
            ActivityViewDocBinding activityViewDocBinding2 = this.viewDocBinding;
            if (activityViewDocBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDocBinding");
                activityViewDocBinding2 = null;
            }
            activityViewDocBinding2.previewRecovery.setVisibility(View.GONE);
            ActivityViewDocBinding activityViewDocBinding3 = this.viewDocBinding;
            if (activityViewDocBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDocBinding");
            } else {
                activityViewDocBinding = activityViewDocBinding3;
            }
            activityViewDocBinding.ivSuccess.setVisibility(View.VISIBLE);
        } catch (IOException e) {
            Toast.makeText(this, "Failed to recover the document", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    private final void shareFile() {
        String str = this.filePath;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filePath");
            str = null;
        }
        Uri uriForFile = FileProvider.getUriForFile(this, getPackageName() + ".provider", new File(str));
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("document/*");
        intent.putExtra("android.intent.extra.STREAM", uriForFile);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        startActivity(Intent.createChooser(intent, "Share Document"));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        AdsClass.showInterstitial(this, new AdsClass.onListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ViewDocActivity$$ExternalSyntheticLambda6
            @Override // com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass.onListener
            public final void click() {
                ViewDocActivity.onBackPressed$lambda$11(ViewDocActivity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBackPressed$lambda$11(ViewDocActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }
}
