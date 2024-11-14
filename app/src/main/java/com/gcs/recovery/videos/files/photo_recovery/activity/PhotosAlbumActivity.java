package com.gcs.recovery.videos.files.photo_recovery.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.demo.example.R;
import com.gcs.recovery.videos.files.photo_recovery.adapter.PhotosAlbumAdapter;
import com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass;
import com.demo.example.databinding.ActivityPhotosAlbumBinding;
import com.gcs.recovery.videos.files.photo_recovery.model.AlbumModel;
import com.gcs.recovery.videos.files.photo_recovery.utils.SharedDataHolder;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;





/* compiled from: PhotosAlbumActivity.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J%\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0012\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u000fH\u0014J\b\u0010\u0015\u001a\u00020\u000fH\u0014J)\u0010\u0016\u001a\u00020\u000f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u000fH\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/activity/PhotosAlbumActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "cachedPhotoPaths", "", "", "[Ljava/lang/String;", "photosAlbumBinding", "Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ActivityPhotosAlbumBinding;", "getPhotoFolders", "", "Lcom/gcs/recovery/videos/files/photo_recovery/model/AlbumModel;", "photoPaths", "([Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initializePhotoData", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "setupRecyclerView", "albumList", "allPhotoPaths", "(Ljava/util/List;[Ljava/lang/String;)V", "showBackConfirmationDialog", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PhotosAlbumActivity extends AppCompatActivity {
    private String[] cachedPhotoPaths = new String[0];
    private ActivityPhotosAlbumBinding photosAlbumBinding;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatImageView appCompatImageView;
        super.onCreate(savedInstanceState);
        ActivityPhotosAlbumBinding inflate = ActivityPhotosAlbumBinding.inflate(getLayoutInflater());
        this.photosAlbumBinding = inflate;
        Intrinsics.checkNotNull(inflate);
        setContentView(inflate.getRoot());
        AdsClass adsClass = new AdsClass();
        ActivityPhotosAlbumBinding activityPhotosAlbumBinding = this.photosAlbumBinding;
        Intrinsics.checkNotNull(activityPhotosAlbumBinding);
        adsClass.refreshAd(activityPhotosAlbumBinding.frameLayout, this, 2);
        if (this.cachedPhotoPaths.length == 0) {
            initializePhotoData();
        }
        ActivityPhotosAlbumBinding activityPhotosAlbumBinding2 = this.photosAlbumBinding;
        if (activityPhotosAlbumBinding2 == null || (appCompatImageView = activityPhotosAlbumBinding2.icBack) == null) {
            return;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PhotosAlbumActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhotosAlbumActivity.onCreate$lambda$0(PhotosAlbumActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(PhotosAlbumActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showBackConfirmationDialog();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new PhotosAlbumActivity$onResume$1(this, null), 3, null);
    }

    private final void initializePhotoData() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new PhotosAlbumActivity$initializePhotoData$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setupRecyclerView(List<AlbumModel> albumList, final String[] allPhotoPaths) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        if (this.photosAlbumBinding != null) {
            if (albumList.isEmpty()) {
                ActivityPhotosAlbumBinding activityPhotosAlbumBinding = this.photosAlbumBinding;
                AppCompatImageView appCompatImageView = activityPhotosAlbumBinding != null ? activityPhotosAlbumBinding.ivError : null;
                Intrinsics.checkNotNull(appCompatImageView);
                appCompatImageView.setVisibility(View.VISIBLE);
                ActivityPhotosAlbumBinding activityPhotosAlbumBinding2 = this.photosAlbumBinding;
                recyclerView = activityPhotosAlbumBinding2 != null ? activityPhotosAlbumBinding2.recyclerView : null;
                Intrinsics.checkNotNull(recyclerView);
                recyclerView.setVisibility(View.GONE);
                return;
            }
            ActivityPhotosAlbumBinding activityPhotosAlbumBinding3 = this.photosAlbumBinding;
            AppCompatImageView appCompatImageView2 = activityPhotosAlbumBinding3 != null ? activityPhotosAlbumBinding3.ivError : null;
            Intrinsics.checkNotNull(appCompatImageView2);
            appCompatImageView2.setVisibility(View.GONE);
            ActivityPhotosAlbumBinding activityPhotosAlbumBinding4 = this.photosAlbumBinding;
            recyclerView = activityPhotosAlbumBinding4 != null ? activityPhotosAlbumBinding4.recyclerView : null;
            Intrinsics.checkNotNull(recyclerView);
            recyclerView.setVisibility(View.VISIBLE);
            ActivityPhotosAlbumBinding activityPhotosAlbumBinding5 = this.photosAlbumBinding;
            if (activityPhotosAlbumBinding5 == null || (recyclerView2 = activityPhotosAlbumBinding5.recyclerView) == null) {
                return;
            }
            recyclerView2.setLayoutManager(new GridLayoutManager(this, 2));
            recyclerView2.setAdapter(new PhotosAlbumAdapter(albumList, new Function1<AlbumModel, Unit>() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PhotosAlbumActivity$setupRecyclerView$1$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AlbumModel albumModel) {
                    invoke2(albumModel);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AlbumModel album) {
                    Intrinsics.checkNotNullParameter(album, "album");
                    Intent intent = new Intent(PhotosAlbumActivity.this, (Class<?>) PhotosFilesActivity.class);
                    intent.putExtra("ALBUM_TITLE", album.getAlbumName());
                    String albumName = album.getAlbumName();
                    switch (albumName.hashCode()) {
                        case -1849927648:
                            if (albumName.equals("All Photos")) {
                                SharedDataHolder.INSTANCE.setAllPhotoPaths(ArraysKt.toList(allPhotoPaths));
                                intent.putExtra("ALBUM_PATH", "ALL_PHOTOS");
                                break;
                            }
                            SharedDataHolder.INSTANCE.setAlbumFolderPath(new File(album.getThumbnail().getAbsolutePath()).getParent());
                            intent.putExtra("ALBUM_PATH", "SPECIFIC_ALBUM");
                            break;
                        case 87874216:
                            if (albumName.equals("Deleted Photos")) {
                                SharedDataHolder.INSTANCE.setAllPhotoPaths(album.getPaths());
                                intent.putExtra("ALBUM_PATH", "DELETED_FILES");
                                break;
                            }
                            SharedDataHolder.INSTANCE.setAlbumFolderPath(new File(album.getThumbnail().getAbsolutePath()).getParent());
                            intent.putExtra("ALBUM_PATH", "SPECIFIC_ALBUM");
                            break;
                        case 532061111:
                            if (albumName.equals("Hidden Photos")) {
                                SharedDataHolder.INSTANCE.setHiddenPhotoPaths(album.getPaths());
                                intent.putExtra("ALBUM_PATH", "HIDDEN_PHOTOS");
                                break;
                            }
                            SharedDataHolder.INSTANCE.setAlbumFolderPath(new File(album.getThumbnail().getAbsolutePath()).getParent());
                            intent.putExtra("ALBUM_PATH", "SPECIFIC_ALBUM");
                            break;
                        case 1536420789:
                            if (albumName.equals(".thumbnails")) {
                                SharedDataHolder.INSTANCE.setThumbnailsPath(album.getPaths());
                                intent.putExtra("ALBUM_PATH", ".THUMBNAILS");
                                break;
                            }
                            SharedDataHolder.INSTANCE.setAlbumFolderPath(new File(album.getThumbnail().getAbsolutePath()).getParent());
                            intent.putExtra("ALBUM_PATH", "SPECIFIC_ALBUM");
                            break;
                        default:
                            SharedDataHolder.INSTANCE.setAlbumFolderPath(new File(album.getThumbnail().getAbsolutePath()).getParent());
                            intent.putExtra("ALBUM_PATH", "SPECIFIC_ALBUM");
                            break;
                    }
                    PhotosAlbumActivity.this.startActivity(intent);
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getPhotoFolders(String[] strArr, Continuation<? super List<AlbumModel>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new PhotosAlbumActivity$getPhotoFolders$2(strArr, null), continuation);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        showBackConfirmationDialog();
    }

    private final void showBackConfirmationDialog() {
        View inflate = getLayoutInflater().inflate(R.layout.dialog_back_alert, (ViewGroup) null);
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(inflate);
        bottomSheetDialog.setCancelable(true);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.iv_exit_btn);
        ((LinearLayout) inflate.findViewById(R.id.iv_cancel_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PhotosAlbumActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhotosAlbumActivity.showBackConfirmationDialog$lambda$3(BottomSheetDialog.this, view);
            }
        });
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PhotosAlbumActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhotosAlbumActivity.showBackConfirmationDialog$lambda$5(PhotosAlbumActivity.this, bottomSheetDialog, view);
            }
        });
        bottomSheetDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showBackConfirmationDialog$lambda$3(BottomSheetDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showBackConfirmationDialog$lambda$5(final PhotosAlbumActivity this$0, final BottomSheetDialog dialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        AdsClass.showInterstitial(this$0, new AdsClass.onListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.PhotosAlbumActivity$$ExternalSyntheticLambda0
            @Override // com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass.onListener
            public final void click() {
                PhotosAlbumActivity.showBackConfirmationDialog$lambda$5$lambda$4(BottomSheetDialog.this, this$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showBackConfirmationDialog$lambda$5$lambda$4(BottomSheetDialog dialog, PhotosAlbumActivity this$0) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialog.dismiss();
        this$0.finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.photosAlbumBinding = null;
    }
}
