package com.gcs.recovery.videos.files.photo_recovery.activity;

import android.widget.TextView;
import com.demo.example.databinding.ActivityPhotosScanBinding;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;
import java.io.File;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;



import org.objectweb.asm.Opcodes;

/* compiled from: PhotosScanActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.gcs.recovery.videos.files.photo_recovery.activity.PhotosScanActivity$scanForPhotos$2$deferreds$1$1", f = "PhotosScanActivity.kt", i = {}, l = {112, Opcodes.FNEG, Opcodes.LUSHR}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class PhotosScanActivity$scanForPhotos$2$deferreds$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
    final /* synthetic */ File $file;
    final /* synthetic */ List<File> $imageFiles;
    Object L$0;
    int label;
    final /* synthetic */ PhotosScanActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PhotosScanActivity$scanForPhotos$2$deferreds$1$1(PhotosScanActivity photosScanActivity, File file, List<File> list, Continuation<? super PhotosScanActivity$scanForPhotos$2$deferreds$1$1> continuation) {
        super(2, continuation);
        this.this$0 = photosScanActivity;
        this.$file = file;
        this.$imageFiles = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PhotosScanActivity$scanForPhotos$2$deferreds$1$1(this.this$0, this.$file, this.$imageFiles, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Object> continuation) {
        return invoke2(coroutineScope, (Continuation<Object>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<Object> continuation) {
        return ((PhotosScanActivity$scanForPhotos$2$deferreds$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int i;
        boolean isValidImage;
        int i2;
        boolean isImageWithoutExtension;
        Object scanForPhotos;
        List<File> list;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 != 0) {
                if (i3 == 1) {
                    list = (List) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    return Boxing.boxBoolean(list.addAll((Collection) obj));
                }
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                if (i3 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            PhotosScanActivity photosScanActivity = this.this$0;
            i = photosScanActivity.scannedFiles;
            photosScanActivity.scannedFiles = i + 1;
            if (this.$file.isDirectory()) {
                List<File> list2 = this.$imageFiles;
                PhotosScanActivity photosScanActivity2 = this.this$0;
                File file = this.$file;
                Intrinsics.checkNotNullExpressionValue(file, "$file");
                this.L$0 = list2;
                this.label = 1;
                scanForPhotos = photosScanActivity2.scanForPhotos(file, this);
                if (scanForPhotos == coroutine_suspended) {
                    return coroutine_suspended;
                }
                list = list2;
                obj = scanForPhotos;
                return Boxing.boxBoolean(list.addAll((Collection) obj));
            }
            PhotosScanActivity photosScanActivity3 = this.this$0;
            File file2 = this.$file;
            Intrinsics.checkNotNullExpressionValue(file2, "$file");
            isValidImage = photosScanActivity3.isValidImage(file2);
            if (!isValidImage) {
                PhotosScanActivity photosScanActivity4 = this.this$0;
                File file3 = this.$file;
                Intrinsics.checkNotNullExpressionValue(file3, "$file");
                isImageWithoutExtension = photosScanActivity4.isImageWithoutExtension(file3);
                if (!isImageWithoutExtension) {
                    this.label = 3;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass3(this.this$0, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
            }
            List<File> list3 = this.$imageFiles;
            File file4 = this.$file;
            synchronized (list3) {
                Intrinsics.checkNotNull(file4);
                list3.add(file4);
            }
            PhotosScanActivity photosScanActivity5 = this.this$0;
            i2 = photosScanActivity5.foundFiles;
            photosScanActivity5.foundFiles = i2 + 1;
            this.label = 2;
            if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(this.this$0, this.$file, null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        } catch (Exception e) {
            e.printStackTrace();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: PhotosScanActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.gcs.recovery.videos.files.photo_recovery.activity.PhotosScanActivity$scanForPhotos$2$deferreds$1$1$2", f = "PhotosScanActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.gcs.recovery.videos.files.photo_recovery.activity.PhotosScanActivity$scanForPhotos$2$deferreds$1$1$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ File $file;
        int label;
        final /* synthetic */ PhotosScanActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(PhotosScanActivity photosScanActivity, File file, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = photosScanActivity;
            this.$file = file;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, this.$file, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int i;
            int i2;
            ActivityPhotosScanBinding activityPhotosScanBinding;
            ActivityPhotosScanBinding activityPhotosScanBinding2;
            ActivityPhotosScanBinding activityPhotosScanBinding3;
            int i3;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                i = this.this$0.scannedFiles;
                i2 = this.this$0.totalFiles;
                int i4 = (i * 100) / i2;
                activityPhotosScanBinding = this.this$0.photosScanBinding;
                CircularProgressBar circularProgressBar = activityPhotosScanBinding != null ? activityPhotosScanBinding.storageProgress : null;
                if (circularProgressBar != null) {
                    circularProgressBar.setProgress(i4);
                }
                activityPhotosScanBinding2 = this.this$0.photosScanBinding;
                TextView textView = activityPhotosScanBinding2 != null ? activityPhotosScanBinding2.noOfItems : null;
                if (textView != null) {
                    StringBuilder sb = new StringBuilder();
                    i3 = this.this$0.foundFiles;
                    textView.setText(sb.append(i3).append(" Items found").toString());
                }
                activityPhotosScanBinding3 = this.this$0.photosScanBinding;
                TextView textView2 = activityPhotosScanBinding3 != null ? activityPhotosScanBinding3.itemPath : null;
                if (textView2 != null) {
                    textView2.setText(this.$file.getAbsolutePath());
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: PhotosScanActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.gcs.recovery.videos.files.photo_recovery.activity.PhotosScanActivity$scanForPhotos$2$deferreds$1$1$3", f = "PhotosScanActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.gcs.recovery.videos.files.photo_recovery.activity.PhotosScanActivity$scanForPhotos$2$deferreds$1$1$3, reason: invalid class name */
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PhotosScanActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(PhotosScanActivity photosScanActivity, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.this$0 = photosScanActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            int i;
            int i2;
            ActivityPhotosScanBinding activityPhotosScanBinding;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                i = this.this$0.scannedFiles;
                i2 = this.this$0.totalFiles;
                int i3 = (i * 100) / i2;
                activityPhotosScanBinding = this.this$0.photosScanBinding;
                CircularProgressBar circularProgressBar = activityPhotosScanBinding != null ? activityPhotosScanBinding.storageProgress : null;
                if (circularProgressBar != null) {
                    circularProgressBar.setProgress(i3);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
