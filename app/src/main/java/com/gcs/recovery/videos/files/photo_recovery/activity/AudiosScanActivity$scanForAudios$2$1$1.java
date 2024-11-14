package com.gcs.recovery.videos.files.photo_recovery.activity;

import android.widget.TextView;
import com.demo.example.databinding.ActivityAudiosScanBinding;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;


/* compiled from: AudiosScanActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.gcs.recovery.videos.files.photo_recovery.activity.AudiosScanActivity$scanForAudios$2$1$1", f = "AudiosScanActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes2.dex */
final class AudiosScanActivity$scanForAudios$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ File $file;
    int label;
    final /* synthetic */ AudiosScanActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AudiosScanActivity$scanForAudios$2$1$1(AudiosScanActivity audiosScanActivity, File file, Continuation<? super AudiosScanActivity$scanForAudios$2$1$1> continuation) {
        super(2, continuation);
        this.this$0 = audiosScanActivity;
        this.$file = file;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AudiosScanActivity$scanForAudios$2$1$1(this.this$0, this.$file, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AudiosScanActivity$scanForAudios$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int i;
        int i2;
        ActivityAudiosScanBinding activityAudiosScanBinding;
        ActivityAudiosScanBinding activityAudiosScanBinding2;
        ActivityAudiosScanBinding activityAudiosScanBinding3;
        int i3;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            i = this.this$0.scannedFiles;
            i2 = this.this$0.totalFiles;
            int i4 = (i * 100) / i2;
            activityAudiosScanBinding = this.this$0.audiosScanBinding;
            CircularProgressBar circularProgressBar = activityAudiosScanBinding != null ? activityAudiosScanBinding.storageProgress : null;
            if (circularProgressBar != null) {
                circularProgressBar.setProgress(i4);
            }
            activityAudiosScanBinding2 = this.this$0.audiosScanBinding;
            TextView textView = activityAudiosScanBinding2 != null ? activityAudiosScanBinding2.noOfItems : null;
            if (textView != null) {
                StringBuilder sb = new StringBuilder();
                i3 = this.this$0.foundFiles;
                textView.setText(sb.append(i3).append(" Items found").toString());
            }
            activityAudiosScanBinding3 = this.this$0.audiosScanBinding;
            TextView textView2 = activityAudiosScanBinding3 != null ? activityAudiosScanBinding3.itemPath : null;
            if (textView2 != null) {
                textView2.setText(this.$file.getAbsolutePath());
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
