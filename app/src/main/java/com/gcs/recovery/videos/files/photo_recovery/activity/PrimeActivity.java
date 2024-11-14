package com.gcs.recovery.videos.files.photo_recovery.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;












import com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass;
import com.demo.example.databinding.ActivityPrimeBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.timepicker.TimeModel;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: PrimeActivity.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\u0012\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J \u0010\u0016\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\tH\u0002J\b\u0010\u001b\u001a\u00020\u000bH\u0002J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\tH\u0002J\b\u0010\u001e\u001a\u00020\u000bH\u0002J\b\u0010\u001f\u001a\u00020\u000bH\u0002J\b\u0010 \u001a\u00020\u000bH\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/activity/PrimeActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/android/billingclient/api/PurchasesUpdatedListener;", "()V", "billingClient", "Lcom/android/billingclient/api/BillingClient;", "primeBinding", "Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ActivityPrimeBinding;", "removeAdsProductId", "", "checkIfAlreadyPurchased", "", "handleBillingError", "billingResult", "Lcom/android/billingclient/api/BillingResult;", "handlePurchase", FirebaseAnalytics.Event.PURCHASE, "Lcom/android/billingclient/api/Purchase;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPurchasesUpdated", "purchases", "", "openWebPage", "url", "queryProductsLifetime", "removeAds", "token", "setUpBillingClient", "showProducts", "startCountdownTimer", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PrimeActivity extends AppCompatActivity implements PurchasesUpdatedListener {
    private BillingClient billingClient;
    private ActivityPrimeBinding primeBinding;
    private final String removeAdsProductId = "remove_ads";

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityPrimeBinding inflate = ActivityPrimeBinding.inflate(getLayoutInflater());
        this.primeBinding = inflate;
        Intrinsics.checkNotNull(inflate);
        setContentView(inflate.getRoot());
        setUpBillingClient();
        startCountdownTimer();
        ActivityPrimeBinding activityPrimeBinding = this.primeBinding;
        Intrinsics.checkNotNull(activityPrimeBinding);
        activityPrimeBinding.btnClose.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PrimeActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PrimeActivity.onCreate$lambda$0(PrimeActivity.this, view);
            }
        });
        ActivityPrimeBinding activityPrimeBinding2 = this.primeBinding;
        Intrinsics.checkNotNull(activityPrimeBinding2);
        activityPrimeBinding2.subscribeNow.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PrimeActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PrimeActivity.onCreate$lambda$1(PrimeActivity.this, view);
            }
        });
        ActivityPrimeBinding activityPrimeBinding3 = this.primeBinding;
        Intrinsics.checkNotNull(activityPrimeBinding3);
        activityPrimeBinding3.privacyPolicy.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PrimeActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PrimeActivity.onCreate$lambda$2(PrimeActivity.this, view);
            }
        });
        ActivityPrimeBinding activityPrimeBinding4 = this.primeBinding;
        Intrinsics.checkNotNull(activityPrimeBinding4);
        activityPrimeBinding4.termsOfService.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PrimeActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PrimeActivity.onCreate$lambda$3(PrimeActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(PrimeActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(PrimeActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showProducts();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(PrimeActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.openWebPage("https://sites.google.com/view/photorecoveryfilerecovery-pp/home");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(PrimeActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.openWebPage("https://sites.google.com/view/photofilerecovery-tc/home");
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.gcs.recovery.videos.files.photo_recovery.activity.PrimeActivity$startCountdownTimer$1] */
    private final void startCountdownTimer() {
        final long j = 7200000;
        new CountDownTimer(j) { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PrimeActivity$startCountdownTimer$1
            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                ActivityPrimeBinding activityPrimeBinding;
                ActivityPrimeBinding activityPrimeBinding2;
                ActivityPrimeBinding activityPrimeBinding3;
                long j2 = (millisUntilFinished / 3600000) % 24;
                long j3 = 60;
                long j4 = (millisUntilFinished / 60000) % j3;
                long j5 = (millisUntilFinished / 1000) % j3;
                activityPrimeBinding = this.primeBinding;
                TextView textView = activityPrimeBinding != null ? activityPrimeBinding.timerHours : null;
                if (textView != null) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Long.valueOf(j2)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                    textView.setText(format);
                }
                activityPrimeBinding2 = this.primeBinding;
                TextView textView2 = activityPrimeBinding2 != null ? activityPrimeBinding2.timerMinutes : null;
                if (textView2 != null) {
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                    String format2 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Long.valueOf(j4)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
                    textView2.setText(format2);
                }
                activityPrimeBinding3 = this.primeBinding;
                TextView textView3 = activityPrimeBinding3 != null ? activityPrimeBinding3.timerSeconds : null;
                if (textView3 == null) {
                    return;
                }
                StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                String format3 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Long.valueOf(j5)}, 1));
                Intrinsics.checkNotNullExpressionValue(format3, "format(format, *args)");
                textView3.setText(format3);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                ActivityPrimeBinding activityPrimeBinding;
                ActivityPrimeBinding activityPrimeBinding2;
                ActivityPrimeBinding activityPrimeBinding3;
                activityPrimeBinding = this.primeBinding;
                TextView textView = activityPrimeBinding != null ? activityPrimeBinding.timerHours : null;
                if (textView != null) {
                    textView.setText("00");
                }
                activityPrimeBinding2 = this.primeBinding;
                TextView textView2 = activityPrimeBinding2 != null ? activityPrimeBinding2.timerMinutes : null;
                if (textView2 != null) {
                    textView2.setText("00");
                }
                activityPrimeBinding3 = this.primeBinding;
                TextView textView3 = activityPrimeBinding3 != null ? activityPrimeBinding3.timerSeconds : null;
                if (textView3 == null) {
                    return;
                }
                textView3.setText("00");
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setUpBillingClient() {
        BillingClient build = BillingClient.newBuilder(this).setListener(this).enablePendingPurchases().build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        this.billingClient = build;
        if (build == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billingClient");
            build = null;
        }
        build.startConnection(new BillingClientStateListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PrimeActivity$setUpBillingClient$1
            @Override // com.android.billingclient.api.BillingClientStateListener
            public void onBillingSetupFinished(BillingResult billingResult) {
                Intrinsics.checkNotNullParameter(billingResult, "billingResult");
                if (billingResult.getResponseCode() == 0) {
                    PrimeActivity.this.queryProductsLifetime();
                    PrimeActivity.this.checkIfAlreadyPurchased();
                }
            }

            @Override // com.android.billingclient.api.BillingClientStateListener
            public void onBillingServiceDisconnected() {
                PrimeActivity.this.setUpBillingClient();
            }
        });
    }

    private final void showProducts() {
        QueryProductDetailsParams build = QueryProductDetailsParams.newBuilder().setProductList(CollectionsKt.listOf(QueryProductDetailsParams.Product.newBuilder().setProductId(this.removeAdsProductId).setProductType("inapp").build())).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        BillingClient billingClient = this.billingClient;
        if (billingClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billingClient");
            billingClient = null;
        }
        billingClient.queryProductDetailsAsync(build, new ProductDetailsResponseListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PrimeActivity$$ExternalSyntheticLambda9
            @Override // com.android.billingclient.api.ProductDetailsResponseListener
            public final void onProductDetailsResponse(BillingResult billingResult, List list) {
                PrimeActivity.showProducts$lambda$4(PrimeActivity.this, billingResult, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showProducts$lambda$4(PrimeActivity this$0, BillingResult billingResult, List productDetailsList) {
        ProductDetails.SubscriptionOfferDetails subscriptionOfferDetails;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        Intrinsics.checkNotNullParameter(productDetailsList, "productDetailsList");
        if (billingResult.getResponseCode() == 0) {
            Iterator it = productDetailsList.iterator();
            while (it.hasNext()) {
                ProductDetails productDetails = (ProductDetails) it.next();
                if (Intrinsics.areEqual(productDetails.getProductId(), this$0.removeAdsProductId)) {
                    List<ProductDetails.SubscriptionOfferDetails> subscriptionOfferDetails2 = productDetails.getSubscriptionOfferDetails();
                    BillingClient billingClient = null;
                    String offerToken = (subscriptionOfferDetails2 == null || (subscriptionOfferDetails = (ProductDetails.SubscriptionOfferDetails) CollectionsKt.first((List) subscriptionOfferDetails2)) == null) ? null : subscriptionOfferDetails.getOfferToken();
                    BillingFlowParams.Builder newBuilder = BillingFlowParams.newBuilder();
                    BillingFlowParams.ProductDetailsParams.Builder productDetails2 = BillingFlowParams.ProductDetailsParams.newBuilder().setProductDetails(productDetails);
                    if (offerToken == null) {
                        offerToken = "";
                    }
                    BillingFlowParams build = newBuilder.setProductDetailsParamsList(CollectionsKt.listOf(productDetails2.setOfferToken(offerToken).build())).build();
                    Intrinsics.checkNotNullExpressionValue(build, "build(...)");
                    BillingClient billingClient2 = this$0.billingClient;
                    if (billingClient2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("billingClient");
                    } else {
                        billingClient = billingClient2;
                    }
                    billingClient.launchBillingFlow(this$0, build);
                }
            }
            return;
        }
        Log.e("BillingError", "Error fetching product details: " + billingResult.getDebugMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void queryProductsLifetime() {
        QueryProductDetailsParams build = QueryProductDetailsParams.newBuilder().setProductList(CollectionsKt.listOf(QueryProductDetailsParams.Product.newBuilder().setProductId(this.removeAdsProductId).setProductType("inapp").build())).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        BillingClient billingClient = this.billingClient;
        if (billingClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billingClient");
            billingClient = null;
        }
        billingClient.queryProductDetailsAsync(build, new ProductDetailsResponseListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PrimeActivity$$ExternalSyntheticLambda3
            @Override // com.android.billingclient.api.ProductDetailsResponseListener
            public final void onProductDetailsResponse(BillingResult billingResult, List list) {
                PrimeActivity.queryProductsLifetime$lambda$6(PrimeActivity.this, billingResult, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void queryProductsLifetime$lambda$6(final PrimeActivity this$0, BillingResult billingResult, List productDetailsList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        Intrinsics.checkNotNullParameter(productDetailsList, "productDetailsList");
        if (billingResult.getResponseCode() == 0) {
            Iterator it = productDetailsList.iterator();
            while (it.hasNext()) {
                ProductDetails.OneTimePurchaseOfferDetails oneTimePurchaseOfferDetails = ((ProductDetails) it.next()).getOneTimePurchaseOfferDetails();
                final String str = (oneTimePurchaseOfferDetails != null ? oneTimePurchaseOfferDetails.getFormattedPrice() : null) + "/Lifetime";
                this$0.runOnUiThread(new Runnable() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PrimeActivity$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        PrimeActivity.queryProductsLifetime$lambda$6$lambda$5(PrimeActivity.this, str);
                    }
                });
            }
            return;
        }
        Log.e("BillingError", "Error querying product details: " + billingResult.getDebugMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void queryProductsLifetime$lambda$6$lambda$5(PrimeActivity this$0, String priceText) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(priceText, "$priceText");
        ActivityPrimeBinding activityPrimeBinding = this$0.primeBinding;
        TextView textView = activityPrimeBinding != null ? activityPrimeBinding.tvPrice : null;
        if (textView == null) {
            return;
        }
        textView.setText(priceText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkIfAlreadyPurchased() {
        BillingClient billingClient = this.billingClient;
        if (billingClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billingClient");
            billingClient = null;
        }
        billingClient.queryPurchasesAsync("inapp", new PurchasesResponseListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PrimeActivity$$ExternalSyntheticLambda10
            @Override // com.android.billingclient.api.PurchasesResponseListener
            public final void onQueryPurchasesResponse(BillingResult billingResult, List list) {
                PrimeActivity.checkIfAlreadyPurchased$lambda$10(PrimeActivity.this, billingResult, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkIfAlreadyPurchased$lambda$10(final PrimeActivity this$0, BillingResult billingResult, List purchasesList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        Intrinsics.checkNotNullParameter(purchasesList, "purchasesList");
        if (billingResult.getResponseCode() == 0) {
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            Iterator it = purchasesList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((Purchase) it.next()).getProducts().contains(this$0.removeAdsProductId)) {
                    booleanRef.element = true;
                    break;
                }
            }
            this$0.runOnUiThread(new Runnable() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PrimeActivity$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    PrimeActivity.checkIfAlreadyPurchased$lambda$10$lambda$9(Ref.BooleanRef.this, this$0);
                }
            });
            return;
        }
        Log.e("BillingError", "Error checking existing purchases: " + billingResult.getDebugMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkIfAlreadyPurchased$lambda$10$lambda$9(Ref.BooleanRef isPurchased, PrimeActivity this$0) {
        MaterialButton materialButton;
        MaterialButton materialButton2;
        Intrinsics.checkNotNullParameter(isPurchased, "$isPurchased");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (isPurchased.element) {
            ActivityPrimeBinding activityPrimeBinding = this$0.primeBinding;
            if (activityPrimeBinding == null || (materialButton2 = activityPrimeBinding.subscribeNow) == null) {
                return;
            }
            materialButton2.setText("Already Purchased");
            materialButton2.setEnabled(false);
            return;
        }
        ActivityPrimeBinding activityPrimeBinding2 = this$0.primeBinding;
        if (activityPrimeBinding2 == null || (materialButton = activityPrimeBinding2.subscribeNow) == null) {
            return;
        }
        materialButton.setText("Subscribe Now");
        materialButton.setEnabled(true);
    }

    @Override // com.android.billingclient.api.PurchasesUpdatedListener
    public void onPurchasesUpdated(BillingResult billingResult, List<Purchase> purchases) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        if (billingResult.getResponseCode() == 0 && purchases != null) {
            for (Purchase purchase : purchases) {
                if (purchase.getProducts().contains(this.removeAdsProductId)) {
                    handlePurchase(purchase);
                }
            }
            return;
        }
        if (billingResult.getResponseCode() == 1) {
            Log.d("BillingClient", "Purchase canceled by user.");
        } else {
            handleBillingError(billingResult);
        }
    }

    private final void handlePurchase(final Purchase purchase) {
        if (purchase.getPurchaseState() != 1 || purchase.isAcknowledged()) {
            return;
        }
        AcknowledgePurchaseParams build = AcknowledgePurchaseParams.newBuilder().setPurchaseToken(purchase.getPurchaseToken()).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        BillingClient billingClient = this.billingClient;
        if (billingClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billingClient");
            billingClient = null;
        }
        billingClient.acknowledgePurchase(build, new AcknowledgePurchaseResponseListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PrimeActivity$$ExternalSyntheticLambda8
            @Override // com.android.billingclient.api.AcknowledgePurchaseResponseListener
            public final void onAcknowledgePurchaseResponse(BillingResult billingResult) {
                PrimeActivity.handlePurchase$lambda$11(PrimeActivity.this, purchase, billingResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handlePurchase$lambda$11(PrimeActivity this$0, Purchase purchase, BillingResult billingResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(purchase, "$purchase");
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        if (billingResult.getResponseCode() == 0) {
            String purchaseToken = purchase.getPurchaseToken();
            Intrinsics.checkNotNullExpressionValue(purchaseToken, "getPurchaseToken(...)");
            this$0.removeAds(purchaseToken);
        }
    }

    private final void handleBillingError(BillingResult billingResult) {
        String str;
        switch (billingResult.getResponseCode()) {
            case -3:
                str = "Service timeout. Please try again.";
                break;
            case -2:
                str = "This feature is not supported on your device.";
                break;
            case -1:
                str = "Service disconnected. Please reconnect.";
                break;
            case 0:
                str = "Subscription activated, Enjoy!";
                break;
            case 1:
                str = "Purchase canceled by user.";
                break;
            case 2:
                str = "Service is currently unavailable. Please try again.";
                break;
            case 3:
                str = "Billing service is unavailable.";
                break;
            case 4:
                str = "This item is unavailable.";
                break;
            case 5:
                str = "Developer error. Please contact support.";
                break;
            case 6:
                str = "An error occurred. Please try again.";
                break;
            case 7:
                str = "You already own this item.";
                break;
            case 8:
                str = "You don't own this item.";
                break;
            default:
                str = "Unknown error. Please try again.";
                break;
        }
        Toast.makeText(this, str, Toast.LENGTH_LONG).show();
    }

    private final void removeAds(String token) {
        SharedPreferences.Editor edit = getSharedPreferences("AppPrefs", 0).edit();
        edit.putString("adsEnabled", token);
        edit.apply();
        ActivityPrimeBinding activityPrimeBinding = this.primeBinding;
        Intrinsics.checkNotNull(activityPrimeBinding);
        activityPrimeBinding.subscribeNow.setVisibility(View.GONE);
    }

    private final void openWebPage(String url) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        AdsClass.showInterstitial(this, new AdsClass.onListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PrimeActivity$$ExternalSyntheticLambda0
            @Override // com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass.onListener
            public final void click() {
                PrimeActivity.onBackPressed$lambda$12(PrimeActivity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBackPressed$lambda$12(PrimeActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }
}
