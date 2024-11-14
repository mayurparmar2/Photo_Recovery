package com.gcs.recovery.videos.files.photo_recovery.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewpager.widget.PagerAdapter;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.demo.example.R;
import com.demo.example.databinding.Onboard1Binding;
import com.demo.example.databinding.Onboard2Binding;
import com.demo.example.databinding.Onboard3Binding;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GuidePagerAdapter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\u0018\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/adapter/GuidePagerAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "layoutInflater", "Landroid/view/LayoutInflater;", "layouts", "", "destroyItem", "", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "position", "", "object", "", "getCount", "instantiateItem", "isViewFromObject", "", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GuidePagerAdapter extends PagerAdapter {
    private final Context context;
    private final LayoutInflater layoutInflater;
    private final int[] layouts;

    public GuidePagerAdapter(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        Object systemService = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        this.layoutInflater = (LayoutInflater) systemService;
        this.layouts = new int[]{R.layout.onboard_1, R.layout.onboard_2, R.layout.onboard_3};
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.layouts.length;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object object) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(object, "object");
        return Intrinsics.areEqual(view, object);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup container, int position) {
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(container, "container");
        if (position == 0) {
            Onboard1Binding inflate = Onboard1Binding.inflate(this.layoutInflater, container, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            LinearLayout root = inflate.getRoot();
            Intrinsics.checkNotNull(root);
            linearLayout = root;
        } else if (position == 1) {
            Onboard2Binding inflate2 = Onboard2Binding.inflate(this.layoutInflater, container, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(...)");
            LinearLayout root2 = inflate2.getRoot();
            Intrinsics.checkNotNull(root2);
            linearLayout = root2;
        } else if (position == 2) {
            Onboard3Binding inflate3 = Onboard3Binding.inflate(this.layoutInflater, container, false);
            Intrinsics.checkNotNullExpressionValue(inflate3, "inflate(...)");
            LinearLayout root3 = inflate3.getRoot();
            Intrinsics.checkNotNull(root3);
            linearLayout = root3;
        } else {
            throw new IllegalStateException("Invalid position: " + position);
        }
        container.addView(linearLayout);
        return linearLayout;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup container, int position, Object object) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(object, "object");
        container.removeView((View) object);
    }
}
