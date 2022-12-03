package partners.moonshot.configpanel.di

import android.content.Context
import com.google.firebase.FirebaseApp
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import partners.moonshot.configpanel.data.ConfigPanelDataRepository
import partners.moonshot.configpanel.data.preferences.KeyCodePreferences
import partners.moonshot.configpanel.domain.ConfigPanelRepository
import partners.moonshot.configpanel.ui.konami.KonamiCodeChecker
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ConfigPanelModule {

    @Provides
    @Singleton
    fun provideKonamiCodeChequer(
        keyCodePreferences: KeyCodePreferences
    ): KonamiCodeChecker {
        return KonamiCodeChecker(keyCodePreferences)
    }

    @Provides
    @Singleton
    fun provideFirebaseRemoteConfig(@ApplicationContext context: Context): FirebaseRemoteConfig {
        FirebaseApp.initializeApp(context)
        return FirebaseRemoteConfig.getInstance()
    }

    @Provides
    @Singleton
    fun provideKeyCodePreferences(@ApplicationContext context: Context): KeyCodePreferences {
        return KeyCodePreferences(context)
    }

    @Provides
    @Singleton
    fun provideConfigPanelRepository(
        firebaseDatabase: FirebaseDatabase,
        keyCodePreferences: KeyCodePreferences
    ): ConfigPanelRepository {
        return ConfigPanelDataRepository(firebaseDatabase, keyCodePreferences)
    }

    @Provides
    @Singleton
    fun provideFirebaseDataBase(): FirebaseDatabase {
        return FirebaseDatabase.getInstance()
    }
}