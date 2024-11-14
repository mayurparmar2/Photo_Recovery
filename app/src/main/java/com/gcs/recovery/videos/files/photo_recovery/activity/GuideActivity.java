package com.gcs.recovery.videos.files.photo_recovery.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewpager.widget.ViewPager;
import com.demo.example.R;
import com.gcs.recovery.videos.files.photo_recovery.adapter.GuidePagerAdapter;
import com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass;
import com.demo.example.databinding.ActivityGuideBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GuideActivity.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/activity/GuideActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapter", "Lcom/gcs/recovery/videos/files/photo_recovery/adapter/GuidePagerAdapter;", "guideActivityBinding", "Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ActivityGuideBinding;", "sharedPreferences", "Landroid/content/SharedPreferences;", "navigateNextScreen", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "updateDots", "position", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GuideActivity extends AppCompatActivity {
    private GuidePagerAdapter adapter;
    private ActivityGuideBinding guideActivityBinding;
    private SharedPreferences sharedPreferences;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityGuideBinding inflate = ActivityGuideBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.guideActivityBinding = inflate;
        ActivityGuideBinding activityGuideBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guideActivityBinding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        SharedPreferences sharedPreferences = getSharedPreferences("app_prefs", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        this.sharedPreferences = sharedPreferences;
        AdsClass adsClass = new AdsClass();
        ActivityGuideBinding activityGuideBinding2 = this.guideActivityBinding;
        if (activityGuideBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guideActivityBinding");
            activityGuideBinding2 = null;
        }
        adsClass.refreshAd(activityGuideBinding2.frameLayout, this, 0);
        ActivityGuideBinding activityGuideBinding3 = this.guideActivityBinding;
        if (activityGuideBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guideActivityBinding");
            activityGuideBinding3 = null;
        }
        final ViewPager viewPager = activityGuideBinding3.viewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager, "viewPager");
        ActivityGuideBinding activityGuideBinding4 = this.guideActivityBinding;
        if (activityGuideBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guideActivityBinding");
        } else {
            activityGuideBinding = activityGuideBinding4;
        }
        LinearLayout ivNext = activityGuideBinding.ivNext;
        Intrinsics.checkNotNullExpressionValue(ivNext, "ivNext");
        GuidePagerAdapter guidePagerAdapter = new GuidePagerAdapter(this);
        this.adapter = guidePagerAdapter;
        viewPager.setAdapter(guidePagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.GuideActivity$onCreate$1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int state) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int position) {
                GuideActivity.this.updateDots(position);
            }
        });
        ivNext.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.GuideActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuideActivity.onCreate$lambda$1(ViewPager.this, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(ViewPager viewPager, final GuideActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(viewPager, "$viewPager");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int currentItem = viewPager.getCurrentItem();
        GuidePagerAdapter guidePagerAdapter = this$0.adapter;
        if (guidePagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            guidePagerAdapter = null;
        }
        if (currentItem < guidePagerAdapter.getCount() - 1) {
            viewPager.setCurrentItem(currentItem + 1);
        } else {
            AdsClass.showInterstitial(this$0, new AdsClass.onListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.GuideActivity$$ExternalSyntheticLambda1
                @Override // com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass.onListener
                public final void click() {
                    GuideActivity.onCreate$lambda$1$lambda$0(GuideActivity.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1$lambda$0(GuideActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.navigateNextScreen();
    }

    private final void navigateNextScreen() {
        SharedPreferences sharedPreferences = this.sharedPreferences;
        SharedPreferences sharedPreferences2 = null;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
            sharedPreferences = null;
        }
        if (sharedPreferences.getBoolean("isFirstTimeUser", true)) {
            startActivity(new Intent(this, (Class<?>) LanguageActivity.class));
            SharedPreferences sharedPreferences3 = this.sharedPreferences;
            if (sharedPreferences3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
            } else {
                sharedPreferences2 = sharedPreferences3;
            }
            sharedPreferences2.edit().putBoolean("isFirstTimeUser", false).apply();
        } else {
            startActivity(new Intent(this, (Class<?>) MainActivity.class));
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateDots(int position) {
        AppCompatImageView[] appCompatImageViewArr = new AppCompatImageView[3];
        ActivityGuideBinding activityGuideBinding = this.guideActivityBinding;
        ActivityGuideBinding activityGuideBinding2 = null;
        if (activityGuideBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guideActivityBinding");
            activityGuideBinding = null;
        }
        int i = 0;
        appCompatImageViewArr[0] = activityGuideBinding.ivDot1;
        ActivityGuideBinding activityGuideBinding3 = this.guideActivityBinding;
        if (activityGuideBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guideActivityBinding");
            activityGuideBinding3 = null;
        }
        appCompatImageViewArr[1] = activityGuideBinding3.ivDot2;
        ActivityGuideBinding activityGuideBinding4 = this.guideActivityBinding;
        if (activityGuideBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guideActivityBinding");
        } else {
            activityGuideBinding2 = activityGuideBinding4;
        }
        appCompatImageViewArr[2] = activityGuideBinding2.ivDot3;
        while (i < 3) {
            appCompatImageViewArr[i].setImageResource(i == position ? R.drawable.ic_select_guide : R.drawable.ic_unselect_guide);
            i++;
        }
    }
}
