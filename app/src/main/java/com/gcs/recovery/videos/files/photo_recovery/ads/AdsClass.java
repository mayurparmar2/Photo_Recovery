package com.gcs.recovery.videos.files.photo_recovery.ads;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.demo.example.R;
import com.google.android.exoplayer2.ExoPlayer;














import java.util.Objects;

/* loaded from: classes2.dex */
public class AdsClass {
    public static InterstitialAd interstitialAd;
    static InterstitialAdLoadCallback interstitialAdLoadCallback;
    public static NativeAd mNativeAd;
    static onListener onClickListener;

    public interface onListener {
        void click();
    }

    public static void loadAd(final Activity activity) {
        final AdRequest build = new AdRequest.Builder().build();
        InterstitialAdLoadCallback interstitialAdLoadCallback2 = new InterstitialAdLoadCallback() { // from class: com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass.1
            @Override // com.google.android.gms.ads.AdLoadCallback
            public void onAdFailedToLoad(LoadAdError loadAdError) {
            }

            @Override // com.google.android.gms.ads.AdLoadCallback
            public void onAdLoaded(InterstitialAd interstitialAd2) {
                AdsClass.interstitialAd = interstitialAd2;
                interstitialAd2.setFullScreenContentCallback(new FullScreenContentCallback() { // from class: com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass.1.1
                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdShowedFullScreenContent() {
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdDismissedFullScreenContent() {
                        AdsClass.onClickListener.click();
                        InterstitialAd.load(activity, Config.ADMOB_INTERSTITIAL_ID, build, AdsClass.interstitialAdLoadCallback);
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                        AdsClass.onClickListener.click();
                    }
                });
            }
        };
        interstitialAdLoadCallback = interstitialAdLoadCallback2;
        InterstitialAd.load(activity, Config.ADMOB_INTERSTITIAL_ID, build, interstitialAdLoadCallback2);
        Config.loadAdsEnableFromPrefs(activity);
    }

    public static void showInterstitial(final Activity activity, onListener onlistener) {
        if (activity == null || activity.isFinishing()) {
            onClickListener.click();
            return;
        }
        final ProgressDialog progressDialog = new ProgressDialog(activity);
        progressDialog.setMessage("Loading Ads...");
        progressDialog.setCancelable(false);
        if (Config.adsEnable.isEmpty()) {
            onClickListener = onlistener;
            if (interstitialAd != null) {
                try {
                    progressDialog.show();
                    new Handler().postDelayed(new Runnable() { // from class: com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            AdsClass.lambda$showInterstitial$0(progressDialog, activity);
                        }
                    }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                    return;
                } catch (Exception unused) {
                    if (progressDialog.isShowing()) {
                        progressDialog.dismiss();
                    }
                    onlistener.click();
                    return;
                }
            }
            onlistener.click();
        } else {
            onlistener.click();
        }
        Config.loadAdsEnableFromPrefs(activity);
    }

    static /* synthetic */ void lambda$showInterstitial$0(ProgressDialog progressDialog, Activity activity) {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        interstitialAd.show(activity);
    }

    private void populateNativeAdView(NativeAd nativeAd, NativeAdView nativeAdView, boolean z) {
        if (!z) {
            nativeAdView.setMediaView((MediaView) nativeAdView.findViewById(R.id.ad_media));
            ((MediaView) Objects.requireNonNull(nativeAdView.getMediaView())).setMediaContent(nativeAd.getMediaContent());
        }
        nativeAdView.setHeadlineView(nativeAdView.findViewById(R.id.ad_headline));
        nativeAdView.setBodyView(nativeAdView.findViewById(R.id.ad_body));
        nativeAdView.setCallToActionView(nativeAdView.findViewById(R.id.ad_call_to_action));
        nativeAdView.setIconView(nativeAdView.findViewById(R.id.ad_app_icon));
        nativeAdView.setStarRatingView(nativeAdView.findViewById(R.id.ad_stars));
        nativeAdView.setAdvertiserView(nativeAdView.findViewById(R.id.ad_advertiser));
        ((TextView) nativeAdView.getHeadlineView()).setText(nativeAd.getHeadline());
        if (nativeAd.getBody() != null) {
            nativeAdView.getBodyView().setVisibility(View.VISIBLE);
            ((TextView) nativeAdView.getBodyView()).setText(nativeAd.getBody());
        } else {
            nativeAdView.getBodyView().setVisibility(View.INVISIBLE);
        }
        if (nativeAd.getCallToAction() != null) {
            nativeAdView.getCallToActionView().setVisibility(View.VISIBLE);
            ((Button) nativeAdView.getCallToActionView()).setText(nativeAd.getCallToAction());
        } else {
            nativeAdView.getCallToActionView().setVisibility(View.INVISIBLE);
        }
        if (nativeAd.getIcon() != null) {
            ((ImageView) nativeAdView.getIconView()).setImageDrawable(nativeAd.getIcon().getDrawable());
            nativeAdView.getIconView().setVisibility(View.VISIBLE);
        } else {
            nativeAdView.getIconView().setVisibility(View.GONE);
        }
        if (nativeAd.getStarRating() != null) {
            ((RatingBar) nativeAdView.getStarRatingView()).setRating(nativeAd.getStarRating().floatValue());
            nativeAdView.getStarRatingView().setVisibility(View.VISIBLE);
        } else {
            nativeAdView.getStarRatingView().setVisibility(View.INVISIBLE);
        }
        if (nativeAd.getAdvertiser() != null) {
            ((TextView) nativeAdView.getAdvertiserView()).setText(nativeAd.getAdvertiser());
            nativeAdView.getAdvertiserView().setVisibility(View.VISIBLE);
        } else {
            nativeAdView.getAdvertiserView().setVisibility(View.INVISIBLE);
        }
        nativeAdView.setNativeAd(nativeAd);
        if (z) {
            return;
        }
        VideoController videoController = nativeAd.getMediaContent().getVideoController();
        if (videoController.hasVideoContent()) {
            nativeAdView.getMediaView().setMediaContent(nativeAd.getMediaContent());
            videoController.setVideoLifecycleCallbacks(new VideoController.VideoLifecycleCallbacks() { // from class: com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass.2
                @Override // com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks
                public void onVideoStart() {
                    super.onVideoStart();
                }

                @Override // com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks
                public void onVideoEnd() {
                    super.onVideoEnd();
                }
            });
        }
    }

    public void refreshAd(final FrameLayout frameLayout, final Activity activity, final int i) {
        if (Config.adsEnable.isEmpty()) {
            frameLayout.setVisibility(View.VISIBLE);
            AdLoader.Builder builder = new AdLoader.Builder(activity, Config.ADMOB_NATIVE_ID);
            builder.forNativeAd(new NativeAd.OnNativeAdLoadedListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass$$ExternalSyntheticLambda1
                @Override // com.google.android.gms.ads.nativead.NativeAd.OnNativeAdLoadedListener
                public final void onNativeAdLoaded(NativeAd nativeAd) {
                    AdsClass.this.m445xa355da45(activity, i, frameLayout, nativeAd);
                }
            });
            builder.withNativeAdOptions(new NativeAdOptions.Builder().setVideoOptions(new VideoOptions.Builder().setStartMuted(true).build()).build());
            builder.withAdListener(new AdListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass.3
                @Override // com.google.android.gms.ads.AdListener
                public void onAdFailedToLoad(LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                }

                @Override // com.google.android.gms.ads.AdListener
                public void onAdLoaded() {
                    super.onAdLoaded();
                }

                @Override // com.google.android.gms.ads.AdListener
                public void onAdClicked() {
                    super.onAdClicked();
                }
            }).build().loadAd(new AdRequest.Builder().build());
        } else {
            frameLayout.setVisibility(View.GONE);
        }
        Config.loadAdsEnableFromPrefs(activity);
    }

    /* renamed from: lambda$refreshAd$1$com-gcs-recovery-videos-files-photo_recovery-ads-AdsClass, reason: not valid java name */
    /* synthetic */ void m445xa355da45(Activity activity, int i, FrameLayout frameLayout, NativeAd nativeAd) {
        NativeAdView nativeAdView;
        if (activity.isDestroyed() || activity.isChangingConfigurations() || activity.isFinishing()) {
            nativeAd.destroy();
            return;
        }
        NativeAd nativeAd2 = mNativeAd;
        if (nativeAd2 != null) {
            nativeAd2.destroy();
        }
        mNativeAd = nativeAd;
        if (i == 0) {
            nativeAdView = (NativeAdView) activity.getLayoutInflater().inflate(R.layout.admob_native_layout, (ViewGroup) null);
        } else if (i == 1) {
            nativeAdView = (NativeAdView) activity.getLayoutInflater().inflate(R.layout.admob_small_native_layout, (ViewGroup) null);
        } else {
            nativeAdView = (NativeAdView) activity.getLayoutInflater().inflate(R.layout.banner_native_layout, (ViewGroup) null);
        }
        populateNativeAdView(nativeAd, nativeAdView, i == 2);
        frameLayout.removeAllViews();
        frameLayout.addView(nativeAdView);
    }
}
