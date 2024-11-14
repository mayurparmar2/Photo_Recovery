package com.gcs.recovery.videos.files.photo_recovery.ads;

import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Log;






import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CheckSubscription.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0012\u001a\u00020\u0010R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/ads/CheckSubscription;", "", "context", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "billingClient", "Lcom/android/billingclient/api/BillingClient;", "getBillingClient", "()Lcom/android/billingclient/api/BillingClient;", "setBillingClient", "(Lcom/android/billingclient/api/BillingClient;)V", "getContext", "()Landroid/app/Activity;", "purchasesUpdatedListener", "Lcom/android/billingclient/api/PurchasesUpdatedListener;", "checkPremium", "", "process", "queryPurchase", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CheckSubscription {
    private BillingClient billingClient;
    private final Activity context;
    private final PurchasesUpdatedListener purchasesUpdatedListener;

    public final BillingClient getBillingClient() {
        return this.billingClient;
    }

    public final Activity getContext() {
        return this.context;
    }

    public final void setBillingClient(BillingClient billingClient) {
        this.billingClient = billingClient;
    }

    public CheckSubscription(Activity context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.purchasesUpdatedListener = new PurchasesUpdatedListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.ads.CheckSubscription$$ExternalSyntheticLambda0
            @Override // com.android.billingclient.api.PurchasesUpdatedListener
            public final void onPurchasesUpdated(BillingResult billingResult, List list) {
                Intrinsics.checkNotNullParameter(billingResult, "billingResult");
            }
        };
    }

    public final void checkPremium() {
        this.billingClient = BillingClient.newBuilder(this.context).setListener(this.purchasesUpdatedListener).enablePendingPurchases().build();
        queryPurchase();
    }

    public final void queryPurchase() {
        BillingClient billingClient = this.billingClient;
        if (billingClient != null) {
            billingClient.startConnection(new BillingClientStateListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.ads.CheckSubscription$queryPurchase$1
                @Override // com.android.billingclient.api.BillingClientStateListener
                public void onBillingServiceDisconnected() {
                }

                @Override // com.android.billingclient.api.BillingClientStateListener
                public void onBillingSetupFinished(BillingResult billingResult) {
                    Intrinsics.checkNotNullParameter(billingResult, "billingResult");
                    CheckSubscription.this.process();
                }
            });
        }
    }

    public final void process() {
        BillingClient billingClient = this.billingClient;
        Intrinsics.checkNotNull(billingClient);
        billingClient.queryPurchasesAsync("inapp", new PurchasesResponseListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.ads.CheckSubscription$$ExternalSyntheticLambda1
            @Override // com.android.billingclient.api.PurchasesResponseListener
            public final void onQueryPurchasesResponse(BillingResult billingResult, List list) {
                CheckSubscription.process$lambda$1(CheckSubscription.this, billingResult, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void process$lambda$1(CheckSubscription this$0, BillingResult billingResult, List purchases) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        Intrinsics.checkNotNullParameter(purchases, "purchases");
        if (billingResult.getResponseCode() == 0) {
            Iterator it = purchases.iterator();
            while (it.hasNext()) {
                Purchase purchase = (Purchase) it.next();
                String purchaseToken = purchase.getPurchaseToken();
                Intrinsics.checkNotNullExpressionValue(purchaseToken, "getPurchaseToken(...)");
                Log.d("PurchaseToken", "Purchase token: " + purchaseToken);
                SharedPreferences.Editor edit = this$0.context.getSharedPreferences("AppPrefs", 0).edit();
                edit.putString("adsEnabled", purchase.getPurchaseToken());
                edit.apply();
            }
            return;
        }
        Log.e("BillingClient", "Failed to query purchases: " + billingResult.getResponseCode());
    }
}
