package com.gcs.recovery.videos.files.photo_recovery.activity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.core.content.ContextCompat;
import androidx.webkit.internal.AssetHelper;
import com.demo.example.R;
import com.demo.example.databinding.ActivitySettingsBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: SettingsActivity.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0015J\b\u0010\u0010\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\rH\u0002J\b\u0010\u0012\u001a\u00020\rH\u0002J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\bH\u0002J\b\u0010\u0015\u001a\u00020\rH\u0002J\b\u0010\u0016\u001a\u00020\rH\u0003J\b\u0010\u0017\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/activity/SettingsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "feedDialog", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "rateDialog", "selectedFeedbackTypes", "", "", "settingsActivityBinding", "Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ActivitySettingsBinding;", "getLanguageDisplayName", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "openAppStore", "openMoreApps", "openPrivacyPolicy", "sendFeedback", "feedbackText", "setupFeedDialog", "setupRateDialog", "shareApp", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SettingsActivity extends AppCompatActivity {
    private BottomSheetDialog feedDialog;
    private BottomSheetDialog rateDialog;
    private final List<String> selectedFeedbackTypes = new ArrayList();
    private ActivitySettingsBinding settingsActivityBinding;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySettingsBinding inflate = ActivitySettingsBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.settingsActivityBinding = inflate;
        ActivitySettingsBinding activitySettingsBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsActivityBinding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        setupRateDialog();
        setupFeedDialog();
        View findViewById = findViewById(R.id.app_version);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        ((TextView) findViewById).setText("Version : " + getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
        ActivitySettingsBinding activitySettingsBinding2 = this.settingsActivityBinding;
        if (activitySettingsBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsActivityBinding");
            activitySettingsBinding2 = null;
        }
        activitySettingsBinding2.selectedLanguage.setText(getLanguageDisplayName());
        ActivitySettingsBinding activitySettingsBinding3 = this.settingsActivityBinding;
        if (activitySettingsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsActivityBinding");
            activitySettingsBinding3 = null;
        }
        activitySettingsBinding3.icBack.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.SettingsActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsActivity.onCreate$lambda$0(SettingsActivity.this, view);
            }
        });
        ActivitySettingsBinding activitySettingsBinding4 = this.settingsActivityBinding;
        if (activitySettingsBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsActivityBinding");
            activitySettingsBinding4 = null;
        }
        activitySettingsBinding4.ivLanguage.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.SettingsActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsActivity.onCreate$lambda$1(SettingsActivity.this, view);
            }
        });
        ActivitySettingsBinding activitySettingsBinding5 = this.settingsActivityBinding;
        if (activitySettingsBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsActivityBinding");
            activitySettingsBinding5 = null;
        }
        activitySettingsBinding5.rateUs.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.SettingsActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsActivity.onCreate$lambda$2(SettingsActivity.this, view);
            }
        });
        ActivitySettingsBinding activitySettingsBinding6 = this.settingsActivityBinding;
        if (activitySettingsBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsActivityBinding");
            activitySettingsBinding6 = null;
        }
        activitySettingsBinding6.shareApp.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.SettingsActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsActivity.onCreate$lambda$3(SettingsActivity.this, view);
            }
        });
        ActivitySettingsBinding activitySettingsBinding7 = this.settingsActivityBinding;
        if (activitySettingsBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsActivityBinding");
            activitySettingsBinding7 = null;
        }
        activitySettingsBinding7.feedback.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.SettingsActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsActivity.onCreate$lambda$4(SettingsActivity.this, view);
            }
        });
        ActivitySettingsBinding activitySettingsBinding8 = this.settingsActivityBinding;
        if (activitySettingsBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsActivityBinding");
            activitySettingsBinding8 = null;
        }
        activitySettingsBinding8.moreApp.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.SettingsActivity$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsActivity.onCreate$lambda$5(SettingsActivity.this, view);
            }
        });
        ActivitySettingsBinding activitySettingsBinding9 = this.settingsActivityBinding;
        if (activitySettingsBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsActivityBinding");
            activitySettingsBinding9 = null;
        }
        activitySettingsBinding9.privacy.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.SettingsActivity$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsActivity.onCreate$lambda$6(SettingsActivity.this, view);
            }
        });
        ActivitySettingsBinding activitySettingsBinding10 = this.settingsActivityBinding;
        if (activitySettingsBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingsActivityBinding");
        } else {
            activitySettingsBinding = activitySettingsBinding10;
        }
        activitySettingsBinding.btnPrime.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.SettingsActivity$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsActivity.onCreate$lambda$7(SettingsActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(SettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(SettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivity(new Intent(this$0, (Class<?>) LanguageActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(SettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BottomSheetDialog bottomSheetDialog = this$0.rateDialog;
        if (bottomSheetDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rateDialog");
            bottomSheetDialog = null;
        }
        bottomSheetDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(SettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.shareApp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$4(SettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BottomSheetDialog bottomSheetDialog = this$0.feedDialog;
        if (bottomSheetDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedDialog");
            bottomSheetDialog = null;
        }
        bottomSheetDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$5(SettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.openMoreApps();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$6(SettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.openPrivacyPolicy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$7(SettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivity(new Intent(this$0, (Class<?>) PrimeActivity.class));
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    private final String getLanguageDisplayName() {
        String string = getSharedPreferences("AppSettings", 0).getString("SelectedLanguage", Locale.getDefault().getLanguage());
        if (string == null) {
            return "English";
        }
        switch (string.hashCode()) {
            case 3121:
                if (!string.equals("ar")) {
                }
                break;
            case 3201:
                if (!string.equals("de")) {
                }
                break;
            case 3241:
                string.equals("en");
                break;
            case 3246:
                if (!string.equals("es")) {
                }
                break;
            case 3276:
                if (!string.equals("fr")) {
                }
                break;
            case 3329:
                if (!string.equals("hi")) {
                }
                break;
            case 3371:
                if (!string.equals("it")) {
                }
                break;
            case 3383:
                if (!string.equals("ja")) {
                }
                break;
            case 3494:
                if (!string.equals("ms")) {
                }
                break;
            case 3588:
                if (!string.equals("pt")) {
                }
                break;
            case 3651:
                if (!string.equals("ru")) {
                }
                break;
            case 3700:
                if (!string.equals("th")) {
                }
                break;
            case 3710:
                if (!string.equals("tr")) {
                }
                break;
            case 3741:
                if (!string.equals("ur")) {
                }
                break;
        }
        return "English";
    }

    private final void setupRateDialog() {
        SettingsActivity settingsActivity = this;
        this.rateDialog = new BottomSheetDialog(settingsActivity);
        BottomSheetDialog bottomSheetDialog = null;
        View inflate = LayoutInflater.from(settingsActivity).inflate(R.layout.dialog_rating_layout, (ViewGroup) null);
        BottomSheetDialog bottomSheetDialog2 = this.rateDialog;
        if (bottomSheetDialog2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rateDialog");
        } else {
            bottomSheetDialog = bottomSheetDialog2;
        }
        bottomSheetDialog.setContentView(inflate);
        View findViewById = inflate.findViewById(R.id.rateBtn);
        final AppCompatRatingBar appCompatRatingBar = (AppCompatRatingBar) inflate.findViewById(R.id.ratingbar);
        appCompatRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.SettingsActivity$$ExternalSyntheticLambda0
            @Override // android.widget.RatingBar.OnRatingBarChangeListener
            public final void onRatingChanged(RatingBar ratingBar, float f, boolean z) {
                SettingsActivity.setupRateDialog$lambda$8(SettingsActivity.this, ratingBar, f, z);
            }
        });
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.SettingsActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsActivity.setupRateDialog$lambda$9(AppCompatRatingBar.this, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupRateDialog$lambda$8(SettingsActivity this$0, RatingBar ratingBar, float f, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (f == 5.0f || f == 4.0f) {
            Toast.makeText(this$0, "Thank you for the rating!", Toast.LENGTH_SHORT).show();
        } else if (f == 3.0f || f == 2.0f || f == 1.0f) {
            Toast.makeText(this$0, "Please provide us your feedback.", Toast.LENGTH_SHORT).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupRateDialog$lambda$9(AppCompatRatingBar appCompatRatingBar, SettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        float rating = appCompatRatingBar.getRating();
        BottomSheetDialog bottomSheetDialog = null;
        if (rating >= 4.0f) {
            this$0.openAppStore();
            BottomSheetDialog bottomSheetDialog2 = this$0.rateDialog;
            if (bottomSheetDialog2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rateDialog");
            } else {
                bottomSheetDialog = bottomSheetDialog2;
            }
            bottomSheetDialog.dismiss();
            return;
        }
        if (rating == 3.0f) {
            BottomSheetDialog bottomSheetDialog3 = this$0.feedDialog;
            if (bottomSheetDialog3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedDialog");
                bottomSheetDialog3 = null;
            }
            bottomSheetDialog3.show();
            BottomSheetDialog bottomSheetDialog4 = this$0.rateDialog;
            if (bottomSheetDialog4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rateDialog");
            } else {
                bottomSheetDialog = bottomSheetDialog4;
            }
            bottomSheetDialog.dismiss();
            return;
        }
        Toast.makeText(this$0, "We appreciate your feedback!", Toast.LENGTH_SHORT).show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setupFeedDialog() {
        SettingsActivity settingsActivity = this;
        this.feedDialog = new BottomSheetDialog(settingsActivity);
        BottomSheetDialog bottomSheetDialog = null;
        View inflate = LayoutInflater.from(settingsActivity).inflate(R.layout.dialog_feedback_layout, (ViewGroup) null);
        BottomSheetDialog bottomSheetDialog2 = this.feedDialog;
        if (bottomSheetDialog2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedDialog");
        } else {
            bottomSheetDialog = bottomSheetDialog2;
        }
        bottomSheetDialog.setContentView(inflate);
        final TextInputEditText textInputEditText = (TextInputEditText) inflate.findViewById(R.id.feedbackEdit);
        MaterialButton materialButton = (MaterialButton) inflate.findViewById(R.id.submitBtn);
        for (final MaterialButton materialButton2 : CollectionsKt.listOf((Object[]) new MaterialButton[]{inflate.findViewById(R.id.mRbAds), inflate.findViewById(R.id.mRbBugs), inflate.findViewById(R.id.mRbSpeed), inflate.findViewById(R.id.mRbError), inflate.findViewById(R.id.mRbMore), inflate.findViewById(R.id.mRbOther)})) {
            materialButton2.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.SettingsActivity$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SettingsActivity.setupFeedDialog$lambda$11$lambda$10(MaterialButton.this, this, view);
                }
            });
        }
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.SettingsActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsActivity.setupFeedDialog$lambda$12(TextInputEditText.this, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupFeedDialog$lambda$11$lambda$10(MaterialButton materialButton, SettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String obj = materialButton.getText().toString();
        if (this$0.selectedFeedbackTypes.contains(obj)) {
            this$0.selectedFeedbackTypes.remove(obj);
            SettingsActivity settingsActivity = this$0;
            materialButton.setTextColor(ContextCompat.getColor(settingsActivity, R.color.button_txt_color));
            materialButton.setBackgroundColor(ContextCompat.getColor(settingsActivity, R.color.feed_btn));
            return;
        }
        this$0.selectedFeedbackTypes.add(obj);
        SettingsActivity settingsActivity2 = this$0;
        materialButton.setTextColor(ContextCompat.getColor(settingsActivity2, R.color.primary));
        materialButton.setBackgroundColor(ContextCompat.getColor(settingsActivity2, R.color.next));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupFeedDialog$lambda$12(TextInputEditText textInputEditText, SettingsActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String obj = StringsKt.trim((CharSequence) String.valueOf(textInputEditText.getText())).toString();
        if (obj.length() == 0) {
            Toast.makeText(this$0, "Please enter your feedback.", Toast.LENGTH_SHORT).show();
            return;
        }
        if (obj.length() < 6) {
            Toast.makeText(this$0, "Feedback must be at least 6 characters long.", Toast.LENGTH_SHORT).show();
            return;
        }
        if (this$0.selectedFeedbackTypes.isEmpty()) {
            Toast.makeText(this$0, "Please select at least one feedback type.", Toast.LENGTH_SHORT).show();
            return;
        }
        this$0.sendFeedback("Suggestions: " + CollectionsKt.joinToString$default(this$0.selectedFeedbackTypes, ", ", null, null, 0, null, null, 62, null) + "\n\nDetails:\n" + obj);
        BottomSheetDialog bottomSheetDialog = this$0.feedDialog;
        if (bottomSheetDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedDialog");
            bottomSheetDialog = null;
        }
        bottomSheetDialog.dismiss();
    }

    private final void openAppStore() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + getPackageName()));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } catch (Exception unused) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName())));
        }
    }

    private final void shareApp() {
        String str = "Hi,I'm using Photo Recovery : File Recovery App. A powerful app that can quickly scan and recover any deleted files. Download it now !! https://play.google.com/store/apps/details?id=" + getPackageName();
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(AssetHelper.DEFAULT_MIME_TYPE);
        intent.putExtra("android.intent.extra.TEXT", str);
        startActivity(Intent.createChooser(intent, "Share via"));
    }

    private final void sendFeedback(String feedbackText) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("plain/text");
        intent.putExtra("android.intent.extra.EMAIL", new String[]{"support@growcraftsolution.com"});
        intent.putExtra("android.intent.extra.SUBJECT", "Feedback & Suggestions");
        intent.putExtra("android.intent.extra.TEXT", feedbackText);
        intent.setPackage("com.google.android.gm");
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(this, "Gmail app is not installed.", Toast.LENGTH_SHORT).show();
        }
    }

    private final void openMoreApps() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://search?q=pub:GrowCraft Solution Private Limited"));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } catch (Exception unused) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/search?q=pub:GrowCraft Solution Private Limited")));
        }
    }

    private final void openPrivacyPolicy() {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://sites.google.com/view/photorecoveryfilerecovery-pp/home")));
    }
}
