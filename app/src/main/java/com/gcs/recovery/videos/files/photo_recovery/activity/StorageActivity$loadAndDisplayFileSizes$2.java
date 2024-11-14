package com.gcs.recovery.videos.files.photo_recovery.activity;

import android.widget.TextView;
import com.demo.example.databinding.ActivityStorageBinding;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

import org.objectweb.asm.Opcodes;

/* compiled from: StorageActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.gcs.recovery.videos.files.photo_recovery.activity.StorageActivity$loadAndDisplayFileSizes$2", f = "StorageActivity.kt", i = {}, l = {124, Opcodes.LUSHR, 126, 127}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class StorageActivity$loadAndDisplayFileSizes$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ StorageActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StorageActivity$loadAndDisplayFileSizes$2(StorageActivity storageActivity, Continuation<? super StorageActivity$loadAndDisplayFileSizes$2> continuation) {
        super(2, continuation);
        this.this$0 = storageActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StorageActivity$loadAndDisplayFileSizes$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StorageActivity$loadAndDisplayFileSizes$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* compiled from: StorageActivity.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.gcs.recovery.videos.files.photo_recovery.activity.StorageActivity$loadAndDisplayFileSizes$2$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Long> {
        AnonymousClass1(Object obj) {
            super(0, obj, StorageActivity.class, "getLargeFilesSize", "getLargeFilesSize()J", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Long invoke() {
            long largeFilesSize;
            largeFilesSize = ((StorageActivity) this.receiver).getLargeFilesSize();
            return Long.valueOf(largeFilesSize);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00fe A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d6 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ActivityStorageBinding activityStorageBinding;
        ActivityStorageBinding activityStorageBinding2;
        Object loadAndDisplaySize;
        ActivityStorageBinding activityStorageBinding3;
        ActivityStorageBinding activityStorageBinding4;
        Object loadAndDisplaySize2;
        ActivityStorageBinding activityStorageBinding5;
        ActivityStorageBinding activityStorageBinding6;
        Object loadAndDisplaySize3;
        ActivityStorageBinding activityStorageBinding7;
        Object loadAndDisplaySize4;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StorageActivity storageActivity = this.this$0;
            activityStorageBinding = storageActivity.storageBinding;
            if (activityStorageBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("storageBinding");
                activityStorageBinding = null;
            }
            TextView largeSize = activityStorageBinding.largeSize;
            Intrinsics.checkNotNullExpressionValue(largeSize, "largeSize");
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0);
            activityStorageBinding2 = this.this$0.storageBinding;
            if (activityStorageBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("storageBinding");
                activityStorageBinding2 = null;
            }
            this.label = 1;
            loadAndDisplaySize = storageActivity.loadAndDisplaySize(largeSize, anonymousClass1, activityStorageBinding2.progBarL, this);
            if (loadAndDisplaySize == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    ResultKt.throwOnFailure(obj);
                    StorageActivity storageActivity2 = this.this$0;
                    activityStorageBinding7 = storageActivity2.storageBinding;
                    if (activityStorageBinding7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("storageBinding");
                        activityStorageBinding7 = null;
                    }
                    TextView junkSize = activityStorageBinding7.junkSize;
                    Intrinsics.checkNotNullExpressionValue(junkSize, "junkSize");
                    this.label = 4;
                    loadAndDisplaySize4 = storageActivity2.loadAndDisplaySize(junkSize, new AnonymousClass4(this.this$0), null, this);
                    if (loadAndDisplaySize4 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                StorageActivity storageActivity3 = this.this$0;
                activityStorageBinding5 = storageActivity3.storageBinding;
                if (activityStorageBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("storageBinding");
                    activityStorageBinding5 = null;
                }
                TextView scrSize = activityStorageBinding5.scrSize;
                Intrinsics.checkNotNullExpressionValue(scrSize, "scrSize");
                AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.this$0);
                activityStorageBinding6 = this.this$0.storageBinding;
                if (activityStorageBinding6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("storageBinding");
                    activityStorageBinding6 = null;
                }
                this.label = 3;
                loadAndDisplaySize3 = storageActivity3.loadAndDisplaySize(scrSize, anonymousClass3, activityStorageBinding6.progBarSS, this);
                if (loadAndDisplaySize3 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                StorageActivity storageActivity22 = this.this$0;
                activityStorageBinding7 = storageActivity22.storageBinding;
                if (activityStorageBinding7 == null) {
                }
                TextView junkSize2 = activityStorageBinding7.junkSize;
                Intrinsics.checkNotNullExpressionValue(junkSize2, "junkSize");
                this.label = 4;
                loadAndDisplaySize4 = storageActivity22.loadAndDisplaySize(junkSize2, new AnonymousClass4(this.this$0), null, this);
                if (loadAndDisplaySize4 == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        StorageActivity storageActivity4 = this.this$0;
        activityStorageBinding3 = storageActivity4.storageBinding;
        if (activityStorageBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storageBinding");
            activityStorageBinding3 = null;
        }
        TextView dupSize = activityStorageBinding3.dupSize;
        Intrinsics.checkNotNullExpressionValue(dupSize, "dupSize");
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0);
        activityStorageBinding4 = this.this$0.storageBinding;
        if (activityStorageBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storageBinding");
            activityStorageBinding4 = null;
        }
        this.label = 2;
        loadAndDisplaySize2 = storageActivity4.loadAndDisplaySize(dupSize, anonymousClass2, activityStorageBinding4.progBarD, this);
        if (loadAndDisplaySize2 == coroutine_suspended) {
            return coroutine_suspended;
        }
        StorageActivity storageActivity32 = this.this$0;
        activityStorageBinding5 = storageActivity32.storageBinding;
        if (activityStorageBinding5 == null) {
        }
        TextView scrSize2 = activityStorageBinding5.scrSize;
        Intrinsics.checkNotNullExpressionValue(scrSize2, "scrSize");
        AnonymousClass3 anonymousClass32 = new AnonymousClass3(this.this$0);
        activityStorageBinding6 = this.this$0.storageBinding;
        if (activityStorageBinding6 == null) {
        }
        this.label = 3;
        loadAndDisplaySize3 = storageActivity32.loadAndDisplaySize(scrSize2, anonymousClass32, activityStorageBinding6.progBarSS, this);
        if (loadAndDisplaySize3 == coroutine_suspended) {
        }
        StorageActivity storageActivity222 = this.this$0;
        activityStorageBinding7 = storageActivity222.storageBinding;
        if (activityStorageBinding7 == null) {
        }
        TextView junkSize22 = activityStorageBinding7.junkSize;
        Intrinsics.checkNotNullExpressionValue(junkSize22, "junkSize");
        this.label = 4;
        loadAndDisplaySize4 = storageActivity222.loadAndDisplaySize(junkSize22, new AnonymousClass4(this.this$0), null, this);
        if (loadAndDisplaySize4 == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    /* compiled from: StorageActivity.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.gcs.recovery.videos.files.photo_recovery.activity.StorageActivity$loadAndDisplayFileSizes$2$2, reason: invalid class name */
    /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function0<Long> {
        AnonymousClass2(Object obj) {
            super(0, obj, StorageActivity.class, "getDuplicateFilesSize", "getDuplicateFilesSize()J", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Long invoke() {
            long duplicateFilesSize;
            duplicateFilesSize = ((StorageActivity) this.receiver).getDuplicateFilesSize();
            return Long.valueOf(duplicateFilesSize);
        }
    }

    /* compiled from: StorageActivity.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.gcs.recovery.videos.files.photo_recovery.activity.StorageActivity$loadAndDisplayFileSizes$2$3, reason: invalid class name */
    /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function0<Long> {
        AnonymousClass3(Object obj) {
            super(0, obj, StorageActivity.class, "getScreenshotFilesSize", "getScreenshotFilesSize()J", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Long invoke() {
            long screenshotFilesSize;
            screenshotFilesSize = ((StorageActivity) this.receiver).getScreenshotFilesSize();
            return Long.valueOf(screenshotFilesSize);
        }
    }

    /* compiled from: StorageActivity.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.gcs.recovery.videos.files.photo_recovery.activity.StorageActivity$loadAndDisplayFileSizes$2$4, reason: invalid class name */
    /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function0<Long> {
        AnonymousClass4(Object obj) {
            super(0, obj, StorageActivity.class, "getJunkFilesSize", "getJunkFilesSize()J", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Long invoke() {
            long junkFilesSize;
            junkFilesSize = ((StorageActivity) this.receiver).getJunkFilesSize();
            return Long.valueOf(junkFilesSize);
        }
    }
}
