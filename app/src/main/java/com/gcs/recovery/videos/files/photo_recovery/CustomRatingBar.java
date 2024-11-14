package com.gcs.recovery.videos.files.photo_recovery;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatRatingBar;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomRatingBar.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0003J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\fH\u0003J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\fH\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007H\u0014R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/CustomRatingBar;", "Landroidx/appcompat/widget/AppCompatRatingBar;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mSampleTile", "Landroid/graphics/Bitmap;", "createBackgroundDrawableShape", "Landroid/graphics/drawable/Drawable;", "createProgressDrawable", "Landroid/graphics/drawable/LayerDrawable;", "createProgressDrawableShape", "drawableToBitmap", "drawable", "getDrawableShape", "Landroid/graphics/drawable/shapes/RoundRectShape;", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CustomRatingBar extends AppCompatRatingBar {
    private Bitmap mSampleTile;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomRatingBar(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomRatingBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ CustomRatingBar(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomRatingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        setProgressDrawable(createProgressDrawable());
    }

    @Override // androidx.appcompat.widget.AppCompatRatingBar, android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Bitmap bitmap = this.mSampleTile;
        if (bitmap != null) {
            setMeasuredDimension(AppCompatRatingBar.resolveSizeAndState(bitmap.getWidth() * getNumStars(), widthMeasureSpec, 0), getMeasuredHeight());
        }
    }

    private final LayerDrawable createProgressDrawable() {
        Drawable createBackgroundDrawableShape = createBackgroundDrawableShape();
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{createBackgroundDrawableShape, createBackgroundDrawableShape, createProgressDrawableShape()});
        layerDrawable.setId(0, android.R.id.background);
        layerDrawable.setId(1, android.R.id.secondaryProgress);
        layerDrawable.setId(2, android.R.id.progress);
        return layerDrawable;
    }

    private final Drawable createBackgroundDrawableShape() {
        Drawable drawable = getResources().getDrawable(R.drawable.star_empty, null);
        Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(...)");
        Bitmap drawableToBitmap = drawableToBitmap(drawable);
        if (this.mSampleTile == null) {
            this.mSampleTile = drawableToBitmap;
        }
        ShapeDrawable shapeDrawable = new ShapeDrawable(getDrawableShape());
        shapeDrawable.getPaint().setShader(new BitmapShader(drawableToBitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
        return shapeDrawable;
    }

    private final Drawable createProgressDrawableShape() {
        Drawable drawable = getResources().getDrawable(R.drawable.star_filled, null);
        Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(...)");
        Bitmap drawableToBitmap = drawableToBitmap(drawable);
        ShapeDrawable shapeDrawable = new ShapeDrawable(getDrawableShape());
        shapeDrawable.getPaint().setShader(new BitmapShader(drawableToBitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
        return new ClipDrawable(shapeDrawable, 3, 1);
    }

    private final RoundRectShape getDrawableShape() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    private final Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Intrinsics.checkNotNullExpressionValue(bitmap, "getBitmap(...)");
            return bitmap;
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth() > 0 ? drawable.getIntrinsicWidth() : 1, drawable.getIntrinsicHeight() > 0 ? drawable.getIntrinsicHeight() : 1, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }
}
