package com.gcs.recovery.videos.files.photo_recovery.activity;

import android.app.LocaleManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.view.View;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.os.LocaleListCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.demo.example.R;
import com.gcs.recovery.videos.files.photo_recovery.adapter.LanguageAdapter;
import com.gcs.recovery.videos.files.photo_recovery.ads.AdsClass;
import com.demo.example.databinding.ActivityLanguageBinding;
import com.gcs.recovery.videos.files.photo_recovery.model.LanguageModel;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LanguageActivity.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\u0012\u0010\u0011\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0010H\u0002J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0010H\u0002J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0010H\u0002J\b\u0010\u0018\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/gcs/recovery/videos/files/photo_recovery/activity/LanguageActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "languageAdapter", "Lcom/gcs/recovery/videos/files/photo_recovery/adapter/LanguageAdapter;", "languageBinding", "Lcom/gcs/recovery/videos/files/photo_recovery/databinding/ActivityLanguageBinding;", "selectedLanguage", "Lcom/gcs/recovery/videos/files/photo_recovery/model/LanguageModel;", "applySavedLanguage", "", "getAvailableLanguages", "", "getOnBackInvokedDispatcher", "Landroid/window/OnBackInvokedDispatcher;", "getSavedLanguageCode", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "saveLanguageCode", "languageCode", "setLocale", "setNewLocale", "setupLanguageRecyclerView", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LanguageActivity extends AppCompatActivity {
    private LanguageAdapter languageAdapter;
    private ActivityLanguageBinding languageBinding;
    private LanguageModel selectedLanguage;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        Object obj;
        applySavedLanguage();
        super.onCreate(savedInstanceState);
        ActivityLanguageBinding inflate = ActivityLanguageBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.languageBinding = inflate;
        ActivityLanguageBinding activityLanguageBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("languageBinding");
            inflate = null;
        }
        setContentView(inflate.getRoot());
        setupLanguageRecyclerView();
        AdsClass adsClass = new AdsClass();
        ActivityLanguageBinding activityLanguageBinding2 = this.languageBinding;
        if (activityLanguageBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("languageBinding");
            activityLanguageBinding2 = null;
        }
        adsClass.refreshAd(activityLanguageBinding2.frameLayout, this, 0);
        String savedLanguageCode = getSavedLanguageCode();
        if (savedLanguageCode != null) {
            Iterator<T> it = getAvailableLanguages().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (Intrinsics.areEqual(((LanguageModel) obj).getLanguageCode(), savedLanguageCode)) {
                        break;
                    }
                }
            }
            LanguageModel languageModel = (LanguageModel) obj;
            this.selectedLanguage = languageModel;
            if (languageModel != null) {
                LanguageAdapter languageAdapter = this.languageAdapter;
                if (languageAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("languageAdapter");
                    languageAdapter = null;
                }
                languageAdapter.setSelectedLanguage(languageModel);
                ActivityLanguageBinding activityLanguageBinding3 = this.languageBinding;
                if (activityLanguageBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("languageBinding");
                    activityLanguageBinding3 = null;
                }
                activityLanguageBinding3.selectLanguageButton.setEnabled(true);
            }
        }
        ActivityLanguageBinding activityLanguageBinding4 = this.languageBinding;
        if (activityLanguageBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("languageBinding");
            activityLanguageBinding4 = null;
        }
        activityLanguageBinding4.backButton.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.LanguageActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LanguageActivity.onCreate$lambda$2(LanguageActivity.this, view);
            }
        });
        ActivityLanguageBinding activityLanguageBinding5 = this.languageBinding;
        if (activityLanguageBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("languageBinding");
        } else {
            activityLanguageBinding = activityLanguageBinding5;
        }
        activityLanguageBinding.selectLanguageButton.setOnClickListener(new View.OnClickListener() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.LanguageActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LanguageActivity.onCreate$lambda$4(LanguageActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(LanguageActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getOnBackPressedDispatcher().onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$4(LanguageActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LanguageModel languageModel = this$0.selectedLanguage;
        if (languageModel != null) {
            this$0.setNewLocale(languageModel.getLanguageCode());
        }
    }

    private final void setupLanguageRecyclerView() {
        this.languageAdapter = new LanguageAdapter(getAvailableLanguages(), new Function1<LanguageModel, Unit>() { // from class: com.gcs.recovery.videos.files.photo_recovery.activity.LanguageActivity$setupLanguageRecyclerView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LanguageModel languageModel) {
                invoke2(languageModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LanguageModel language) {
                ActivityLanguageBinding activityLanguageBinding;
                Intrinsics.checkNotNullParameter(language, "language");
                LanguageActivity.this.selectedLanguage = language;
                activityLanguageBinding = LanguageActivity.this.languageBinding;
                if (activityLanguageBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("languageBinding");
                    activityLanguageBinding = null;
                }
                activityLanguageBinding.selectLanguageButton.setEnabled(true);
            }
        });
        ActivityLanguageBinding activityLanguageBinding = this.languageBinding;
        ActivityLanguageBinding activityLanguageBinding2 = null;
        if (activityLanguageBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("languageBinding");
            activityLanguageBinding = null;
        }
        RecyclerView recyclerView = activityLanguageBinding.languageRecyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LanguageAdapter languageAdapter = this.languageAdapter;
        if (languageAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("languageAdapter");
            languageAdapter = null;
        }
        recyclerView.setAdapter(languageAdapter);
        ActivityLanguageBinding activityLanguageBinding3 = this.languageBinding;
        if (activityLanguageBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("languageBinding");
        } else {
            activityLanguageBinding2 = activityLanguageBinding3;
        }
        activityLanguageBinding2.selectLanguageButton.setEnabled(false);
    }

    private final String getSavedLanguageCode() {
        return getSharedPreferences("AppSettings", 0).getString("SelectedLanguage", null);
    }

    private final List<LanguageModel> getAvailableLanguages() {
        return CollectionsKt.listOf((Object[]) new LanguageModel[]{new LanguageModel("English", "English", R.drawable.ic_flag_us, "en", false, 16, null), new LanguageModel("Español", "Spanish", R.drawable.ic_flag_spain, "es", false, 16, null), new LanguageModel("Français", "French", R.drawable.ic_flag_fr, "fr", false, 16, null), new LanguageModel("हिंदी", "Hindi", R.drawable.ic_flag_ind, "hi", false, 16, null), new LanguageModel("العربية", "Arabic", R.drawable.ic_flag_sa, "ar", false, 16, null), new LanguageModel("Deutsch", "German", R.drawable.ic_flag_de, "de", false, 16, null), new LanguageModel("Italiano", "Italian", R.drawable.ic_flag_it, "it", false, 16, null), new LanguageModel("日本語", "Japanese", R.drawable.ic_flag_jp, "ja", false, 16, null), new LanguageModel("Português do Brasil", "Portuguese", R.drawable.ic_flag_pt, "pt", false, 16, null), new LanguageModel("Русский", "Russian", R.drawable.ic_flag_ru, "ru", false, 16, null), new LanguageModel("Türkçe", "Turkish", R.drawable.ic_flag_tr, "tr", false, 16, null), new LanguageModel("ภาษาไทย", "Thai", R.drawable.ic_flag_th, "th", false, 16, null), new LanguageModel("Melayu", "Malay", R.drawable.ic_flag_melay, "ms", false, 16, null), new LanguageModel("اردو", "Urdu", R.drawable.ic_flag_pak, "ur", false, 16, null)});
    }

    private final void setNewLocale(String languageCode) {
        if (Build.VERSION.SDK_INT >= 33) {
            ((LocaleManager) getSystemService(LocaleManager.class)).setApplicationLocales(LocaleList.forLanguageTags(languageCode));
        } else {
            AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags(languageCode));
        }
        saveLanguageCode(languageCode);
        Intent intent = new Intent(this, (Class<?>) MainActivity.class);
        intent.setFlags(268468224);
        startActivity(intent);
        finish();
    }

    private final void saveLanguageCode(String languageCode) {
        SharedPreferences.Editor edit = getSharedPreferences("AppSettings", 0).edit();
        edit.putString("SelectedLanguage", languageCode);
        edit.apply();
    }

    private final void applySavedLanguage() {
        String savedLanguageCode = getSavedLanguageCode();
        if (savedLanguageCode != null) {
            setLocale(savedLanguageCode);
        }
    }

    private final void setLocale(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.setLocale(locale);
        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
    }

    @Override // android.app.Activity
    public OnBackInvokedDispatcher getOnBackInvokedDispatcher() {
        OnBackInvokedDispatcher onBackInvokedDispatcher = super.getOnBackInvokedDispatcher();
        Intrinsics.checkNotNullExpressionValue(onBackInvokedDispatcher, "getOnBackInvokedDispatcher(...)");
        return onBackInvokedDispatcher;
    }
}
