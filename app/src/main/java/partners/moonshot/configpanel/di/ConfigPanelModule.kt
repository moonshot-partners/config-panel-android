package partners.moonshot.configpanel.di

import android.content.Context
import com.google.firebase.FirebaseApp
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import partners.moonshot.configpanel.data.ConfigPanelDataRepository
import partners.moonshot.configpanel.data.firebase.FirebaseManagerRepository
import partners.moonshot.configpanel.domain.ConfigPanelRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ConfigPanelModule {


    @Provides
    @Singleton
    fun provideFirebaseManagerRepository(firebaseRemoteConfig: FirebaseRemoteConfig): FirebaseManagerRepository {
        return FirebaseManagerRepository(firebaseRemoteConfig)
    }

    @Provides
    @Singleton
    fun provideFirebaseRemoteConfig(@ApplicationContext context: Context): FirebaseRemoteConfig {
        FirebaseApp.initializeApp(context)
        return FirebaseRemoteConfig.getInstance()
    }

    @Provides
    @Singleton
    fun provideConfigPanelRepository(firebaseManagerRepository: FirebaseManagerRepository): ConfigPanelRepository {
        return ConfigPanelDataRepository(firebaseManagerRepository)
    }
}