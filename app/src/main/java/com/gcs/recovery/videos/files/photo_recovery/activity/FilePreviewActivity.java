package com.gcs.recovery.videos.files.photo_recovery.activity;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.demo.example.R;
import com.demo.example.databinding.ActivityFilePreviewBinding;
import com.github.chrisbanes.photoview.PhotoView;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Player;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: FilePreviewActivity.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0011H\u0014J\u0012\u0010\u0016\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u0012\u0010\u0019\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u0012\u0010\u001a\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u0011H\u0002J\b\u0010\u001c\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/activity/FilePreviewActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "filePreviewBinding", "Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ActivityFilePreviewBinding;", "handler", "Landroid/os/Handler;", "isControlsVisible", "", "isPlaying", "videoPlayer", "Lcom/google/android/exoplayer2/ExoPlayer;", "formatTime", "", "ms", "", "handleOtherFileTypes", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setFileTitle", "fileUri", "Landroid/net/Uri;", "setupPhotoView", "setupPlayerView", "setupTouchListener", "updateSeekBar", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FilePreviewActivity extends AppCompatActivity {
    private ActivityFilePreviewBinding filePreviewBinding;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private boolean isControlsVisible = true;
    private boolean isPlaying;
    private ExoPlayer videoPlayer;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityFilePreviewBinding activityFilePreviewBinding = null;
        EdgeToEdge.enable$default(this, null, null, 3, null);
        ActivityFilePreviewBinding inflate = ActivityFilePreviewBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.filePreviewBinding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filePreviewBinding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        getWindow().addFlags(128);
        getWindow().setFlags(512, 512);
        Uri parse = Uri.parse(getIntent().getStringExtra("FILE_URI"));
        boolean booleanExtra = getIntent().getBooleanExtra("IS_IMAGE", true);
        boolean booleanExtra2 = getIntent().getBooleanExtra("IS_VIDEO", false);
        setFileTitle(parse);
        setupTouchListener();
        if (booleanExtra) {
            setupPhotoView(parse);
        } else if (booleanExtra2) {
            setupPlayerView(parse);
        } else {
            handleOtherFileTypes();
        }
        ActivityFilePreviewBinding activityFilePreviewBinding2 = this.filePreviewBinding;
        if (activityFilePreviewBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filePreviewBinding");
        } else {
            activityFilePreviewBinding = activityFilePreviewBinding2;
        }
        activityFilePreviewBinding.icBack.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.FilePreviewActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FilePreviewActivity.onCreate$lambda$0(FilePreviewActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(FilePreviewActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getOnBackPressedDispatcher().onBackPressed();
    }

    private final void setFileTitle(Uri fileUri) {
        if (fileUri != null) {
            String path = fileUri.getPath();
            if (path == null) {
                path = "";
            }
            String name = new File(path).getName();
            ActivityFilePreviewBinding activityFilePreviewBinding = this.filePreviewBinding;
            if (activityFilePreviewBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("filePreviewBinding");
                activityFilePreviewBinding = null;
            }
            activityFilePreviewBinding.title.setText(name);
        }
    }

    private final void setupPhotoView(Uri fileUri) {
        ActivityFilePreviewBinding activityFilePreviewBinding = this.filePreviewBinding;
        ActivityFilePreviewBinding activityFilePreviewBinding2 = null;
        if (activityFilePreviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filePreviewBinding");
            activityFilePreviewBinding = null;
        }
        PhotoView photoView = activityFilePreviewBinding.photoView;
        photoView.setVisibility(View.VISIBLE);
        if (fileUri != null) {
            Glide.with((FragmentActivity) this).load(fileUri).into(photoView);
        }
        ActivityFilePreviewBinding activityFilePreviewBinding3 = this.filePreviewBinding;
        if (activityFilePreviewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filePreviewBinding");
            activityFilePreviewBinding3 = null;
        }
        activityFilePreviewBinding3.playerView.setVisibility(View.GONE);
        ActivityFilePreviewBinding activityFilePreviewBinding4 = this.filePreviewBinding;
        if (activityFilePreviewBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filePreviewBinding");
        } else {
            activityFilePreviewBinding2 = activityFilePreviewBinding4;
        }
        activityFilePreviewBinding2.previewDetailIvHolder.setVisibility(View.GONE);
    }

    private final void setupPlayerView(Uri fileUri) {
        ActivityFilePreviewBinding activityFilePreviewBinding = this.filePreviewBinding;
        ActivityFilePreviewBinding activityFilePreviewBinding2 = null;
        if (activityFilePreviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filePreviewBinding");
            activityFilePreviewBinding = null;
        }
        activityFilePreviewBinding.playerView.setVisibility(View.VISIBLE);
        ActivityFilePreviewBinding activityFilePreviewBinding3 = this.filePreviewBinding;
        if (activityFilePreviewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filePreviewBinding");
            activityFilePreviewBinding3 = null;
        }
        activityFilePreviewBinding3.photoView.setVisibility(View.GONE);
        ActivityFilePreviewBinding activityFilePreviewBinding4 = this.filePreviewBinding;
        if (activityFilePreviewBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filePreviewBinding");
            activityFilePreviewBinding4 = null;
        }
        activityFilePreviewBinding4.previewDetailIvHolder.setVisibility(View.GONE);
        ExoPlayer build = new ExoPlayer.Builder(this).build();
        Intrinsics.checkNotNull(fileUri);
        build.setMediaItem(MediaItem.fromUri(fileUri));
        build.prepare();
        ActivityFilePreviewBinding activityFilePreviewBinding5 = this.filePreviewBinding;
        if (activityFilePreviewBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filePreviewBinding");
            activityFilePreviewBinding5 = null;
        }
        activityFilePreviewBinding5.playerView.setPlayer(build);
        this.videoPlayer = build;
        ActivityFilePreviewBinding activityFilePreviewBinding6 = this.filePreviewBinding;
        if (activityFilePreviewBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filePreviewBinding");
            activityFilePreviewBinding6 = null;
        }
        final View findViewById = activityFilePreviewBinding6.playerView.findViewById(R.id.exo_play);
        ActivityFilePreviewBinding activityFilePreviewBinding7 = this.filePreviewBinding;
        if (activityFilePreviewBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filePreviewBinding");
            activityFilePreviewBinding7 = null;
        }
        final View findViewById2 = activityFilePreviewBinding7.playerView.findViewById(R.id.exo_pause);
        ActivityFilePreviewBinding activityFilePreviewBinding8 = this.filePreviewBinding;
        if (activityFilePreviewBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filePreviewBinding");
            activityFilePreviewBinding8 = null;
        }
        final SeekBar seekBar = (SeekBar) activityFilePreviewBinding8.playerView.findViewById(R.id.video_progress);
        ActivityFilePreviewBinding activityFilePreviewBinding9 = this.filePreviewBinding;
        if (activityFilePreviewBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filePreviewBinding");
            activityFilePreviewBinding9 = null;
        }
        final TextView textView = (TextView) activityFilePreviewBinding9.playerView.findViewById(R.id.exo_position);
        ActivityFilePreviewBinding activityFilePreviewBinding10 = this.filePreviewBinding;
        if (activityFilePreviewBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filePreviewBinding");
        } else {
            activityFilePreviewBinding2 = activityFilePreviewBinding10;
        }
        final TextView textView2 = (TextView) activityFilePreviewBinding2.playerView.findViewById(R.id.exo_duration);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.FilePreviewActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FilePreviewActivity.setupPlayerView$lambda$5(FilePreviewActivity.this, findViewById, findViewById2, view);
            }
        });
        findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.FilePreviewActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FilePreviewActivity.setupPlayerView$lambda$6(FilePreviewActivity.this, findViewById, findViewById2, view);
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.FilePreviewActivity$setupPlayerView$4
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar2) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar2) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar2, int progress, boolean fromUser) {
                ExoPlayer exoPlayer;
                String formatTime;
                if (fromUser) {
                    exoPlayer = FilePreviewActivity.this.videoPlayer;
                    if (exoPlayer != null) {
                        exoPlayer.seekTo(progress);
                    }
                    TextView textView3 = textView;
                    formatTime = FilePreviewActivity.this.formatTime(progress);
                    textView3.setText(formatTime);
                }
            }
        });
        ExoPlayer exoPlayer = this.videoPlayer;
        if (exoPlayer != null) {
            exoPlayer.addListener(new Player.Listener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.FilePreviewActivity$setupPlayerView$5
                @Override // com.google.android.exoplayer2.Player.Listener
                public void onPlaybackStateChanged(int state) {
                    ExoPlayer exoPlayer2;
                    ExoPlayer exoPlayer3;
                    String formatTime;
                    ExoPlayer exoPlayer4;
                    ExoPlayer exoPlayer5;
                    if (state == 3) {
                        SeekBar seekBar2 = seekBar;
                        exoPlayer2 = this.videoPlayer;
                        seekBar2.setMax(exoPlayer2 != null ? (int) exoPlayer2.getDuration() : 0);
                        TextView textView3 = textView2;
                        FilePreviewActivity filePreviewActivity = this;
                        exoPlayer3 = filePreviewActivity.videoPlayer;
                        formatTime = filePreviewActivity.formatTime(exoPlayer3 != null ? exoPlayer3.getDuration() : 0L);
                        textView3.setText(formatTime);
                        this.updateSeekBar();
                        return;
                    }
                    if (state != 4) {
                        return;
                    }
                    exoPlayer4 = this.videoPlayer;
                    if (exoPlayer4 != null) {
                        exoPlayer4.seekTo(0L);
                    }
                    exoPlayer5 = this.videoPlayer;
                    if (exoPlayer5 != null) {
                        exoPlayer5.setPlayWhenReady(false);
                    }
                    this.isPlaying = false;
                    findViewById.setVisibility(View.VISIBLE);
                    findViewById2.setVisibility(View.GONE);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupPlayerView$lambda$5(FilePreviewActivity this$0, View view, View view2, View view3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ExoPlayer exoPlayer = this$0.videoPlayer;
        if (exoPlayer != null) {
            exoPlayer.play();
        }
        this$0.isPlaying = true;
        view.setVisibility(View.GONE);
        view2.setVisibility(View.VISIBLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupPlayerView$lambda$6(FilePreviewActivity this$0, View view, View view2, View view3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ExoPlayer exoPlayer = this$0.videoPlayer;
        if (exoPlayer != null) {
            exoPlayer.pause();
        }
        this$0.isPlaying = false;
        view.setVisibility(View.VISIBLE);
        view2.setVisibility(View.GONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSeekBar() {
        final ExoPlayer exoPlayer = this.videoPlayer;
        if (exoPlayer != null) {
            this.handler.postDelayed(new Runnable() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.FilePreviewActivity$updateSeekBar$1$1
                @Override // java.lang.Runnable
                public void run() {
                    boolean z;
                    Handler handler;
                    ActivityFilePreviewBinding activityFilePreviewBinding;
                    ActivityFilePreviewBinding activityFilePreviewBinding2;
                    String formatTime;
                    z = FilePreviewActivity.this.isPlaying;
                    if (z) {
                        int currentPosition = (int) exoPlayer.getCurrentPosition();
                        activityFilePreviewBinding = FilePreviewActivity.this.filePreviewBinding;
                        ActivityFilePreviewBinding activityFilePreviewBinding3 = null;
                        if (activityFilePreviewBinding == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("filePreviewBinding");
                            activityFilePreviewBinding = null;
                        }
                        ((SeekBar) activityFilePreviewBinding.playerView.findViewById(R.id.video_progress)).setProgress(currentPosition);
                        activityFilePreviewBinding2 = FilePreviewActivity.this.filePreviewBinding;
                        if (activityFilePreviewBinding2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("filePreviewBinding");
                        } else {
                            activityFilePreviewBinding3 = activityFilePreviewBinding2;
                        }
                        TextView textView = (TextView) activityFilePreviewBinding3.playerView.findViewById(R.id.exo_position);
                        formatTime = FilePreviewActivity.this.formatTime(exoPlayer.getCurrentPosition());
                        textView.setText(formatTime);
                    }
                    handler = FilePreviewActivity.this.handler;
                    handler.postDelayed(this, 1000L);
                }
            }, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String formatTime(long ms) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(ms)), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(ms) % 60)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    private final void handleOtherFileTypes() {
        ActivityFilePreviewBinding activityFilePreviewBinding = this.filePreviewBinding;
        ActivityFilePreviewBinding activityFilePreviewBinding2 = null;
        if (activityFilePreviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filePreviewBinding");
            activityFilePreviewBinding = null;
        }
        activityFilePreviewBinding.photoView.setVisibility(View.GONE);
        ActivityFilePreviewBinding activityFilePreviewBinding3 = this.filePreviewBinding;
        if (activityFilePreviewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filePreviewBinding");
            activityFilePreviewBinding3 = null;
        }
        activityFilePreviewBinding3.playerView.setVisibility(View.GONE);
        ActivityFilePreviewBinding activityFilePreviewBinding4 = this.filePreviewBinding;
        if (activityFilePreviewBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filePreviewBinding");
        } else {
            activityFilePreviewBinding2 = activityFilePreviewBinding4;
        }
        activityFilePreviewBinding2.previewDetailIvHolder.setVisibility(View.VISIBLE);
    }

    private final void setupTouchListener() {
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.FilePreviewActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FilePreviewActivity.setupTouchListener$lambda$9(FilePreviewActivity.this, view);
            }
        };
        ActivityFilePreviewBinding activityFilePreviewBinding = this.filePreviewBinding;
        ActivityFilePreviewBinding activityFilePreviewBinding2 = null;
        if (activityFilePreviewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filePreviewBinding");
            activityFilePreviewBinding = null;
        }
        activityFilePreviewBinding.playerView.setOnClickListener(onClickListener);
        ActivityFilePreviewBinding activityFilePreviewBinding3 = this.filePreviewBinding;
        if (activityFilePreviewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filePreviewBinding");
        } else {
            activityFilePreviewBinding2 = activityFilePreviewBinding3;
        }
        activityFilePreviewBinding2.photoView.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupTouchListener$lambda$9(FilePreviewActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActivityFilePreviewBinding activityFilePreviewBinding = null;
        if (this$0.isControlsVisible) {
            ActivityFilePreviewBinding activityFilePreviewBinding2 = this$0.filePreviewBinding;
            if (activityFilePreviewBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("filePreviewBinding");
                activityFilePreviewBinding2 = null;
            }
            activityFilePreviewBinding2.icBack.setVisibility(View.GONE);
            ActivityFilePreviewBinding activityFilePreviewBinding3 = this$0.filePreviewBinding;
            if (activityFilePreviewBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("filePreviewBinding");
            } else {
                activityFilePreviewBinding = activityFilePreviewBinding3;
            }
            activityFilePreviewBinding.title.setVisibility(View.GONE);
            this$0.isControlsVisible = false;
            return;
        }
        ActivityFilePreviewBinding activityFilePreviewBinding4 = this$0.filePreviewBinding;
        if (activityFilePreviewBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filePreviewBinding");
            activityFilePreviewBinding4 = null;
        }
        activityFilePreviewBinding4.icBack.setVisibility(View.VISIBLE);
        ActivityFilePreviewBinding activityFilePreviewBinding5 = this$0.filePreviewBinding;
        if (activityFilePreviewBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("filePreviewBinding");
        } else {
            activityFilePreviewBinding = activityFilePreviewBinding5;
        }
        activityFilePreviewBinding.title.setVisibility(View.VISIBLE);
        this$0.isControlsVisible = true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        getWindow().clearFlags(128);
        ExoPlayer exoPlayer = this.videoPlayer;
        if (exoPlayer != null) {
            exoPlayer.release();
        }
        this.videoPlayer = null;
    }
}
