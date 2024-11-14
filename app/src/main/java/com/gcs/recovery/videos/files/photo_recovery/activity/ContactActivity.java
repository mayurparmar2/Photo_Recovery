package com.gcs.recovery.videos.files.photo_recovery.activity;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.gcs.recovery.videos.files.photo_recovery.NonSwipeableViewPager;
import com.gcs.recovery.videos.files.photo_recovery.adapter.ContactViewPagerAdapter;
import com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass;
import com.demo.example.databinding.ActivityContactBinding;
import com.google.android.material.tabs.TabLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContactActivity.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\f\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/activity/ContactActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapter", "Lcom/gcs/recovery/videos/files/photo_recovery/adapter/ContactViewPagerAdapter;", "contactBinding", "Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ActivityContactBinding;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setupViewPager", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ContactActivity extends AppCompatActivity {
    private ContactViewPagerAdapter adapter;
    private ActivityContactBinding contactBinding;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityContactBinding inflate = ActivityContactBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.contactBinding = inflate;
        ActivityContactBinding activityContactBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contactBinding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        AdsClass adsClass = new AdsClass();
        ActivityContactBinding activityContactBinding2 = this.contactBinding;
        if (activityContactBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contactBinding");
            activityContactBinding2 = null;
        }
        adsClass.refreshAd(activityContactBinding2.frameLayout, this, 2);
        setupViewPager();
        ActivityContactBinding activityContactBinding3 = this.contactBinding;
        if (activityContactBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contactBinding");
        } else {
            activityContactBinding = activityContactBinding3;
        }
        activityContactBinding.icBack.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ContactActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ContactActivity.onCreate$lambda$0(ContactActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(ContactActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackPressed();
    }

    private final void setupViewPager() {
        this.adapter = new ContactViewPagerAdapter(this);
        ActivityContactBinding activityContactBinding = this.contactBinding;
        ActivityContactBinding activityContactBinding2 = null;
        if (activityContactBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contactBinding");
            activityContactBinding = null;
        }
        NonSwipeableViewPager nonSwipeableViewPager = activityContactBinding.viewPager;
        ContactViewPagerAdapter contactViewPagerAdapter = this.adapter;
        if (contactViewPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            contactViewPagerAdapter = null;
        }
        nonSwipeableViewPager.setAdapter(contactViewPagerAdapter);
        ActivityContactBinding activityContactBinding3 = this.contactBinding;
        if (activityContactBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contactBinding");
            activityContactBinding3 = null;
        }
        TabLayout tabLayout = activityContactBinding3.tabLayout;
        ActivityContactBinding activityContactBinding4 = this.contactBinding;
        if (activityContactBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contactBinding");
        } else {
            activityContactBinding2 = activityContactBinding4;
        }
        tabLayout.setupWithViewPager(activityContactBinding2.viewPager);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        ContactViewPagerAdapter contactViewPagerAdapter = this.adapter;
        if (contactViewPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            contactViewPagerAdapter = null;
        }
        if (contactViewPagerAdapter.handleBackPress()) {
            return;
        }
        AdsClass.showInterstitial(this, new AdsClass.onListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.ContactActivity$$ExternalSyntheticLambda1
            @Override // com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass.onListener
            public final void click() {
                ContactActivity.onBackPressed$lambda$1(ContactActivity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBackPressed$lambda$1(ContactActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        super.onBackPressed();
    }
}
