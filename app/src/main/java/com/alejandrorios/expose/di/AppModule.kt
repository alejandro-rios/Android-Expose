package com.alejandrorios.expose.di

import com.alejandrorios.expose.utils.CoroutinesContextProvider
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

/**
 * @author alejandrorios on 8/15/20
 */
@Module
class AppModule {

    @Singleton
    @Provides
    fun provideContextProvider(): CoroutinesContextProvider {
        return CoroutinesContextProvider(Dispatchers.Main, Dispatchers.IO)
    }
}
