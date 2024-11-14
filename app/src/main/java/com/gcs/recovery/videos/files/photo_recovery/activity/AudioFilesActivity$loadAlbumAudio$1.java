package com.gcs.recovery.videos.files.photo_recovery.activity;

import com.gcs.recovery.videos.files.photo_recovery.utils.SharedDataHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;




/* compiled from: AudioFilesActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.gcs.recovery.videos.files.photo_recovery.activity.AudioFilesActivity$loadAlbumAudio$1", f = "AudioFilesActivity.kt", i = {}, l = {126}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class AudioFilesActivity$loadAlbumAudio$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $albumPath;
    int label;
    final /* synthetic */ AudioFilesActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AudioFilesActivity$loadAlbumAudio$1(AudioFilesActivity audioFilesActivity, String str, Continuation<? super AudioFilesActivity$loadAlbumAudio$1> continuation) {
        super(2, continuation);
        this.this$0 = audioFilesActivity;
        this.$albumPath = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AudioFilesActivity$loadAlbumAudio$1(this.this$0, this.$albumPath, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AudioFilesActivity$loadAlbumAudio$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b6 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        List emptyList;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AudioFilesActivity audioFilesActivity = this.this$0;
            String str = this.$albumPath;
            if (str != null) {
                switch (str.hashCode()) {
                    case -758758767:
                        if (str.equals("DELETED_FILES")) {
                            AudioFilesActivity audioFilesActivity2 = this.this$0;
                            List<String> allAudioPaths = SharedDataHolder.INSTANCE.getAllAudioPaths();
                            if (allAudioPaths == null) {
                                allAudioPaths = CollectionsKt.emptyList();
                            }
                            emptyList = audioFilesActivity2.fetchAllAudios(allAudioPaths);
                            break;
                        }
                        break;
                    case -151466021:
                        if (str.equals("ALL_AUDIOS")) {
                            AudioFilesActivity audioFilesActivity3 = this.this$0;
                            List<String> allAudioPaths2 = SharedDataHolder.INSTANCE.getAllAudioPaths();
                            if (allAudioPaths2 == null) {
                                allAudioPaths2 = CollectionsKt.emptyList();
                            }
                            emptyList = audioFilesActivity3.fetchAllAudios(allAudioPaths2);
                            break;
                        }
                        break;
                    case 529110274:
                        if (str.equals("SPECIFIC_ALBUM")) {
                            emptyList = this.this$0.fetchAudiosFromAlbum(SharedDataHolder.INSTANCE.getAlbumFolderPath());
                            break;
                        }
                        break;
                    case 1761209234:
                        if (str.equals("HIDDEN_AUDIOS")) {
                            AudioFilesActivity audioFilesActivity4 = this.this$0;
                            List<String> hiddenAudioPaths = SharedDataHolder.INSTANCE.getHiddenAudioPaths();
                            if (hiddenAudioPaths == null) {
                                hiddenAudioPaths = CollectionsKt.emptyList();
                            }
                            emptyList = audioFilesActivity4.fetchAllAudios(hiddenAudioPaths);
                            break;
                        }
                        break;
                }
                audioFilesActivity.allAudiosList = emptyList;
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.this$0, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            emptyList = CollectionsKt.emptyList();
            audioFilesActivity.allAudiosList = emptyList;
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.this$0, null), this) == coroutine_suspended) {
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* compiled from: AudioFilesActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.gcs.recovery.videos.files.photo_recovery.activity.AudioFilesActivity$loadAlbumAudio$1$1", f = "AudioFilesActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.gcs.recovery.videos.files.photo_recovery.activity.AudioFilesActivity$loadAlbumAudio$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AudioFilesActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AudioFilesActivity audioFilesActivity, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = audioFilesActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.loadMoreAudios();
                this.this$0.updateSelectionUI();
                this.this$0.updateEmptyView();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
