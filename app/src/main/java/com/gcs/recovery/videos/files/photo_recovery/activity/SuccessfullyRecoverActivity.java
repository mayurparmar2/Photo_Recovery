package com.gcs.recovery.videos.files.photo_recovery.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import com.facebook.share.internal.ShareConstants;
import com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass;
import com.demo.example.databinding.ActivitySuccessfullyRecoverBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SuccessfullyRecoverActivity.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0015R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/activity/SuccessfullyRecoverActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "successfullyRecoverBinding", "Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ActivitySuccessfullyRecoverBinding;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SuccessfullyRecoverActivity extends AppCompatActivity {
    private ActivitySuccessfullyRecoverBinding successfullyRecoverBinding;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        String str;
        super.onCreate(savedInstanceState);
        ActivitySuccessfullyRecoverBinding inflate = ActivitySuccessfullyRecoverBinding.inflate(getLayoutInflater());
        this.successfullyRecoverBinding = inflate;
        setContentView(inflate != null ? inflate.getRoot() : null);
        AdsClass adsClass = new AdsClass();
        ActivitySuccessfullyRecoverBinding activitySuccessfullyRecoverBinding = this.successfullyRecoverBinding;
        Intrinsics.checkNotNull(activitySuccessfullyRecoverBinding);
        adsClass.refreshAd(activitySuccessfullyRecoverBinding.frameLayout, this, 0);
        int intExtra = getIntent().getIntExtra("RECOVERED_ITEM_COUNT", 0);
        String stringExtra = getIntent().getStringExtra("ITEM_TYPE");
        if (stringExtra == null) {
            stringExtra = ShareConstants.PHOTOS;
        }
        ActivitySuccessfullyRecoverBinding activitySuccessfullyRecoverBinding2 = this.successfullyRecoverBinding;
        TextView textView = activitySuccessfullyRecoverBinding2 != null ? activitySuccessfullyRecoverBinding2.itemNoTextView : null;
        if (textView != null) {
            switch (stringExtra.hashCode()) {
                case 62628790:
                    if (stringExtra.equals("AUDIO")) {
                        str = intExtra + " Audio";
                        break;
                    }
                    str = intExtra + " Items";
                    break;
                case 76105234:
                    if (stringExtra.equals("PHOTO")) {
                        str = intExtra + " Photos";
                        break;
                    }
                    str = intExtra + " Items";
                    break;
                case 81665115:
                    if (stringExtra.equals(ShareConstants.VIDEO_URL)) {
                        str = intExtra + " Videos";
                        break;
                    }
                    str = intExtra + " Items";
                    break;
                case 1644347675:
                    if (stringExtra.equals("DOCUMENT")) {
                        str = intExtra + " Documents";
                        break;
                    }
                    str = intExtra + " Items";
                    break;
                default:
                    str = intExtra + " Items";
                    break;
            }
            textView.setText(str);
        }
        ActivitySuccessfullyRecoverBinding activitySuccessfullyRecoverBinding3 = this.successfullyRecoverBinding;
        if (activitySuccessfullyRecoverBinding3 != null && (linearLayout2 = activitySuccessfullyRecoverBinding3.previewRecovery) != null) {
            linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.SuccessfullyRecoverActivity$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SuccessfullyRecoverActivity.onCreate$lambda$0(SuccessfullyRecoverActivity.this, view);
                }
            });
        }
        ActivitySuccessfullyRecoverBinding activitySuccessfullyRecoverBinding4 = this.successfullyRecoverBinding;
        if (activitySuccessfullyRecoverBinding4 != null && (linearLayout = activitySuccessfullyRecoverBinding4.tvContiBtn) != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.SuccessfullyRecoverActivity$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SuccessfullyRecoverActivity.onCreate$lambda$2(SuccessfullyRecoverActivity.this, view);
                }
            });
        }
        ActivitySuccessfullyRecoverBinding activitySuccessfullyRecoverBinding5 = this.successfullyRecoverBinding;
        if (activitySuccessfullyRecoverBinding5 != null && (appCompatImageView2 = activitySuccessfullyRecoverBinding5.icBack) != null) {
            appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.SuccessfullyRecoverActivity$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SuccessfullyRecoverActivity.onCreate$lambda$3(SuccessfullyRecoverActivity.this, view);
                }
            });
        }
        ActivitySuccessfullyRecoverBinding activitySuccessfullyRecoverBinding6 = this.successfullyRecoverBinding;
        if (activitySuccessfullyRecoverBinding6 == null || (appCompatImageView = activitySuccessfullyRecoverBinding6.icHome) == null) {
            return;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.SuccessfullyRecoverActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SuccessfullyRecoverActivity.onCreate$lambda$4(SuccessfullyRecoverActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(SuccessfullyRecoverActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivity(new Intent(this$0, (Class<?>) RecoveredFileActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(final SuccessfullyRecoverActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AdsClass.showInterstitial(this$0, new AdsClass.onListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.SuccessfullyRecoverActivity$$ExternalSyntheticLambda1
            @Override // com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass.onListener
            public final void click() {
                SuccessfullyRecoverActivity.onCreate$lambda$2$lambda$1(SuccessfullyRecoverActivity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2$lambda$1(SuccessfullyRecoverActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(SuccessfullyRecoverActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$4(SuccessfullyRecoverActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent(this$0, (Class<?>) MainActivity.class);
        intent.addFlags(PendingIntent.FLAG_MUTABLE0);
        this$0.startActivity(intent);
        this$0.finish();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        AdsClass.showInterstitial(this, new AdsClass.onListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.SuccessfullyRecoverActivity$$ExternalSyntheticLambda0
            @Override // com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass.onListener
            public final void click() {
                SuccessfullyRecoverActivity.onBackPressed$lambda$5(SuccessfullyRecoverActivity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBackPressed$lambda$5(SuccessfullyRecoverActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }
}
