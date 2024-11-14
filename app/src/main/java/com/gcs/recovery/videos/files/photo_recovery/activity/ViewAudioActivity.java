package com.gcs.recovery.videos.files.photo_recovery.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.demo.example.R;
import com.gcs.recovery.videos.files.photo_recovery.adapter.PreviewContentAdapter;
import com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass;
import com.demo.example.databinding.ActivityViewAudioBinding;
import com.gcs.recovery.videos.files.photo_recovery.model.FileAttributeModel;
import com.gcs.recovery.videos.files.photo_recovery.utils.SharedDataHolder;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: ViewAudioActivity.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0003J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\u0012\u0010\u001a\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u0018H\u0014J\u0012\u0010\u001e\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\u0012\u0010!\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\b\u0010\"\u001a\u00020\u0018H\u0002J\u0016\u0010#\u001a\u00020\u00182\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\b\u0010%\u001a\u00020\u0018H\u0002J\b\u0010&\u001a\u00020\u0018H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/activity/ViewAudioActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "filePath", "", "handler", "Landroid/os/Handler;", "isPlaying", "", "mediaPlayer", "Landroid/media/MediaPlayer;", "viewAudioBinding", "Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ActivityViewAudioBinding;", "formatTime", "millis", "", "gatherFileInfo", "", "Lcom/gcs/recovery/videos/files/photo_recovery/model/FileAttributeModel;", "getFileFormat", "getFileSize", "fileSizeInBytes", "", "loadAudioPreview", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "pauseAudio", "playButton", "Landroid/widget/ImageView;", "playAudio", "recoverFile", "setupRecyclerView", "fileInfoList", "shareFile", "showDeleteConfirmationDialog", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ViewAudioActivity extends AppCompatActivity {
    private String filePath;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private boolean isPlaying;
    private MediaPlayer mediaPlayer;
    private ActivityViewAudioBinding viewAudioBinding;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityViewAudioBinding inflate = ActivityViewAudioBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.viewAudioBinding = inflate;
        ActivityViewAudioBinding activityViewAudioBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewAudioBinding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        String stringExtra = getIntent().getStringExtra("AUDIO_PATH");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.filePath = stringExtra;
        loadAudioPreview();
        String str = this.filePath;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filePath");
            str = null;
        }
        setupRecyclerView(gatherFileInfo(str));
        if (getIntent().getBooleanExtra("IS_RECOVERED", false)) {
            ActivityViewAudioBinding activityViewAudioBinding2 = this.viewAudioBinding;
            if (activityViewAudioBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewAudioBinding");
                activityViewAudioBinding2 = null;
            }
            activityViewAudioBinding2.previewRecovery.setVisibility(View.GONE);
        } else {
            ActivityViewAudioBinding activityViewAudioBinding3 = this.viewAudioBinding;
            if (activityViewAudioBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewAudioBinding");
                activityViewAudioBinding3 = null;
            }
            activityViewAudioBinding3.previewRecovery.setVisibility(View.VISIBLE);
        }
        ActivityViewAudioBinding activityViewAudioBinding4 = this.viewAudioBinding;
        if (activityViewAudioBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewAudioBinding");
            activityViewAudioBinding4 = null;
        }
        activityViewAudioBinding4.icShare.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ViewAudioActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewAudioActivity.onCreate$lambda$0(ViewAudioActivity.this, view);
            }
        });
        ActivityViewAudioBinding activityViewAudioBinding5 = this.viewAudioBinding;
        if (activityViewAudioBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewAudioBinding");
            activityViewAudioBinding5 = null;
        }
        activityViewAudioBinding5.icDelete.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ViewAudioActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewAudioActivity.onCreate$lambda$1(ViewAudioActivity.this, view);
            }
        });
        ActivityViewAudioBinding activityViewAudioBinding6 = this.viewAudioBinding;
        if (activityViewAudioBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewAudioBinding");
            activityViewAudioBinding6 = null;
        }
        activityViewAudioBinding6.previewRecovery.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ViewAudioActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewAudioActivity.onCreate$lambda$2(ViewAudioActivity.this, view);
            }
        });
        ActivityViewAudioBinding activityViewAudioBinding7 = this.viewAudioBinding;
        if (activityViewAudioBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewAudioBinding");
            activityViewAudioBinding7 = null;
        }
        activityViewAudioBinding7.icBack.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ViewAudioActivity$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewAudioActivity.onCreate$lambda$3(ViewAudioActivity.this, view);
            }
        });
        ActivityViewAudioBinding activityViewAudioBinding8 = this.viewAudioBinding;
        if (activityViewAudioBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewAudioBinding");
        } else {
            activityViewAudioBinding = activityViewAudioBinding8;
        }
        activityViewAudioBinding.ivSuccess.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ViewAudioActivity$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewAudioActivity.onCreate$lambda$4(ViewAudioActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(ViewAudioActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.shareFile();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(ViewAudioActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showDeleteConfirmationDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(ViewAudioActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.recoverFile();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(ViewAudioActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$4(ViewAudioActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivity(new Intent(this$0, (Class<?>) RecoveredFileActivity.class));
    }

    private final void loadAudioPreview() {
        ActivityViewAudioBinding activityViewAudioBinding = this.viewAudioBinding;
        String str = null;
        if (activityViewAudioBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewAudioBinding");
            activityViewAudioBinding = null;
        }
        View inflate = activityViewAudioBinding.vsAudio.inflate();
        final ImageView imageView = inflate != null ? (ImageView) inflate.findViewById(R.id.iv_audio_start) : null;
        final SeekBar seekBar = inflate != null ? (SeekBar) inflate.findViewById(R.id.audio_preview_progress) : null;
        final TextView textView = inflate != null ? (TextView) inflate.findViewById(R.id.audio_preview_tv_current) : null;
        TextView textView2 = inflate != null ? (TextView) inflate.findViewById(R.id.audio_preview_tv_total) : null;
        MediaPlayer mediaPlayer = new MediaPlayer();
        String str2 = this.filePath;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filePath");
        } else {
            str = str2;
        }
        mediaPlayer.setDataSource(str);
        mediaPlayer.prepare();
        this.mediaPlayer = mediaPlayer;
        if (textView2 != null) {
            textView2.setText(formatTime(mediaPlayer.getDuration()));
        }
        MediaPlayer mediaPlayer2 = this.mediaPlayer;
        if (mediaPlayer2 != null) {
            mediaPlayer2.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ViewAudioActivity$$ExternalSyntheticLambda4
                @Override // android.media.MediaPlayer.OnPreparedListener
                public final void onPrepared(MediaPlayer mediaPlayer3) {
                    ViewAudioActivity.loadAudioPreview$lambda$7(seekBar, this, imageView, mediaPlayer3);
                }
            });
        }
        MediaPlayer mediaPlayer3 = this.mediaPlayer;
        if (mediaPlayer3 != null) {
            mediaPlayer3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ViewAudioActivity$$ExternalSyntheticLambda5
                @Override // android.media.MediaPlayer.OnCompletionListener
                public final void onCompletion(MediaPlayer mediaPlayer4) {
                    ViewAudioActivity.loadAudioPreview$lambda$8(imageView, this, mediaPlayer4);
                }
            });
        }
        if (seekBar != null) {
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ViewAudioActivity$loadAudioPreview$4
                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onStartTrackingTouch(SeekBar seekBar2) {
                }

                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onStopTrackingTouch(SeekBar seekBar2) {
                }

                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onProgressChanged(SeekBar seekBar2, int progress, boolean fromUser) {
                    MediaPlayer mediaPlayer4;
                    String formatTime;
                    if (fromUser) {
                        mediaPlayer4 = ViewAudioActivity.this.mediaPlayer;
                        if (mediaPlayer4 != null) {
                            mediaPlayer4.seekTo(progress);
                        }
                        TextView textView3 = textView;
                        if (textView3 == null) {
                            return;
                        }
                        formatTime = ViewAudioActivity.this.formatTime(progress);
                        textView3.setText(formatTime);
                    }
                }
            });
        }
        this.handler.postDelayed(new Runnable() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ViewAudioActivity$loadAudioPreview$5
            @Override // java.lang.Runnable
            public void run() {
                MediaPlayer mediaPlayer4;
                Handler handler;
                String formatTime;
                mediaPlayer4 = ViewAudioActivity.this.mediaPlayer;
                if (mediaPlayer4 != null) {
                    SeekBar seekBar2 = seekBar;
                    TextView textView3 = textView;
                    ViewAudioActivity viewAudioActivity = ViewAudioActivity.this;
                    if (seekBar2 != null) {
                        seekBar2.setProgress(mediaPlayer4.getCurrentPosition());
                    }
                    if (textView3 != null) {
                        formatTime = viewAudioActivity.formatTime(mediaPlayer4.getCurrentPosition());
                        textView3.setText(formatTime);
                    }
                }
                handler = ViewAudioActivity.this.handler;
                handler.postDelayed(this, 1000L);
            }
        }, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadAudioPreview$lambda$7(SeekBar seekBar, final ViewAudioActivity this$0, final ImageView imageView, MediaPlayer mediaPlayer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (seekBar != null) {
            MediaPlayer mediaPlayer2 = this$0.mediaPlayer;
            seekBar.setMax(mediaPlayer2 != null ? mediaPlayer2.getDuration() : 0);
        }
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ViewAudioActivity$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ViewAudioActivity.loadAudioPreview$lambda$7$lambda$6(ViewAudioActivity.this, imageView, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadAudioPreview$lambda$7$lambda$6(ViewAudioActivity this$0, ImageView imageView, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isPlaying) {
            this$0.pauseAudio(imageView);
        } else {
            this$0.playAudio(imageView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadAudioPreview$lambda$8(ImageView imageView, ViewAudioActivity this$0, MediaPlayer mediaPlayer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (imageView != null) {
            imageView.setImageResource(R.drawable.iv_play);
        }
        this$0.isPlaying = false;
    }

    private final void playAudio(ImageView playButton) {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
        if (playButton != null) {
            playButton.setImageResource(R.drawable.ic_pause);
        }
        this.isPlaying = true;
    }

    private final void pauseAudio(ImageView playButton) {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
        if (playButton != null) {
            playButton.setImageResource(R.drawable.iv_play);
        }
        this.isPlaying = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String formatTime(int millis) {
        int i = (millis / 1000) % 60;
        int i2 = (millis / 60000) % 60;
        int i3 = millis / 3600000;
        if (i3 > 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i)}, 3));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return format;
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String format2 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i2), Integer.valueOf(i)}, 2));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        return format2;
    }

    private final void setupRecyclerView(List<FileAttributeModel> fileInfoList) {
        PreviewContentAdapter previewContentAdapter = new PreviewContentAdapter(fileInfoList);
        ActivityViewAudioBinding activityViewAudioBinding = this.viewAudioBinding;
        ActivityViewAudioBinding activityViewAudioBinding2 = null;
        if (activityViewAudioBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewAudioBinding");
            activityViewAudioBinding = null;
        }
        activityViewAudioBinding.rvPreviewContent.setLayoutManager(new LinearLayoutManager(this));
        ActivityViewAudioBinding activityViewAudioBinding3 = this.viewAudioBinding;
        if (activityViewAudioBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewAudioBinding");
        } else {
            activityViewAudioBinding2 = activityViewAudioBinding3;
        }
        activityViewAudioBinding2.rvPreviewContent.setAdapter(previewContentAdapter);
    }

    private final void shareFile() {
        String str = this.filePath;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filePath");
            str = null;
        }
        Uri uriForFile = FileProvider.getUriForFile(this, getPackageName() + ".provider", new File(str));
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("audio/*");
        intent.putExtra("android.intent.extra.STREAM", uriForFile);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        startActivity(Intent.createChooser(intent, "Share Audio"));
    }

    private final void recoverFile() {
        try {
            String str = this.filePath;
            ActivityViewAudioBinding activityViewAudioBinding = null;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("filePath");
                str = null;
            }
            File file = new File(str);
            File file2 = new File(Environment.getExternalStorageDirectory(), "PhotoRecovery/Audios");
            if (!file2.exists()) {
                file2.mkdirs();
            }
            File file3 = new File(file2, file.getName());
            FilesKt.copyTo$default(file, file3, true, 0, 4, null);
            Toast.makeText(this, "Audio recovered successfully", Toast.LENGTH_SHORT).show();
            MediaScannerConnection.scanFile(this, new String[]{file3.getAbsolutePath()}, null, null);
            ActivityViewAudioBinding activityViewAudioBinding2 = this.viewAudioBinding;
            if (activityViewAudioBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewAudioBinding");
                activityViewAudioBinding2 = null;
            }
            activityViewAudioBinding2.previewRecovery.setVisibility(View.GONE);
            ActivityViewAudioBinding activityViewAudioBinding3 = this.viewAudioBinding;
            if (activityViewAudioBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewAudioBinding");
            } else {
                activityViewAudioBinding = activityViewAudioBinding3;
            }
            activityViewAudioBinding.ivSuccess.setVisibility(View.VISIBLE);
        } catch (IOException e) {
            Toast.makeText(this, "Failed to recover the audio", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    private final void showDeleteConfirmationDialog() {
        View inflate = getLayoutInflater().inflate(R.layout.dialog_delete_alert, (ViewGroup) null);
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(inflate);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.iv_no_btn);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.iv_yes_btn);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ViewAudioActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewAudioActivity.showDeleteConfirmationDialog$lambda$10(BottomSheetDialog.this, view);
            }
        });
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ViewAudioActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewAudioActivity.showDeleteConfirmationDialog$lambda$12(ViewAudioActivity.this, bottomSheetDialog, view);
            }
        });
        bottomSheetDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDeleteConfirmationDialog$lambda$10(BottomSheetDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDeleteConfirmationDialog$lambda$12(ViewAudioActivity this$0, BottomSheetDialog dialog, View view) {
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
            ViewAudioActivity viewAudioActivity = this$0;
            MediaScannerConnection.scanFile(viewAudioActivity, new String[]{file.getAbsolutePath()}, null, null);
            Toast.makeText(viewAudioActivity, "Audio deleted successfully", Toast.LENGTH_SHORT).show();
            SharedDataHolder sharedDataHolder = SharedDataHolder.INSTANCE;
            List<File> audioFiles = SharedDataHolder.INSTANCE.getAudioFiles();
            if (audioFiles != null) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : audioFiles) {
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
            sharedDataHolder.setAudioFiles(arrayList);
            this$0.onBackPressed();
        } else {
            Toast.makeText(this$0, "Failed to delete the audio", Toast.LENGTH_SHORT).show();
        }
        dialog.dismiss();
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
        if (j4 > 0) {
            return j4 + " GB";
        }
        if (j3 > 0) {
            return j3 + " MB";
        }
        if (j2 > 0) {
            return j2 + " KB";
        }
        return fileSizeInBytes + " B";
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        this.mediaPlayer = null;
        this.handler.removeCallbacksAndMessages(null);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        AdsClass.showInterstitial(this, new AdsClass.onListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ViewAudioActivity$$ExternalSyntheticLambda0
            @Override // com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass.onListener
            public final void click() {
                ViewAudioActivity.onBackPressed$lambda$13(ViewAudioActivity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBackPressed$lambda$13(ViewAudioActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }
}
