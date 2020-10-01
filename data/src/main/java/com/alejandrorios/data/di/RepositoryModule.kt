package com.alejandrorios.data.di

import com.alejandrorios.data.repository.AnimeRepositoryImpl
import com.alejandrorios.data.service.AnimeService
import com.alejandrorios.domain.repository.AnimeRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author alejandrorios on 8/11/20
 */
@Module(includes = [ServiceProviderModule::class, DataBaseModule::class])
class RepositoryModule {

    @Provides
    @Singleton
    fun provideAnimeRepository(animeService: AnimeService): AnimeRepository {
        return AnimeRepositoryImpl(animeService)
    }
}
