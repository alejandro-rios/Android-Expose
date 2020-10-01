package com.alejandrorios.expose.di

import com.alejandrorios.data.di.RepositoryModule
import com.alejandrorios.domain.repository.AnimeRepository
import com.alejandrorios.domain.usecase.GetAnimeTrendsUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author alejandrorios on 8/15/20
 */
@Module(includes = [RepositoryModule::class])
class UseCasesModule {

    @Singleton
    @Provides
    fun provideGetAnimeTrendsUseCase(
        animeRepository: AnimeRepository
    ) = GetAnimeTrendsUseCase(animeRepository)
}
