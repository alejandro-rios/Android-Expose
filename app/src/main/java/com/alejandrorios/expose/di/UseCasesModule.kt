package com.alejandrorios.expose.di

import com.alejandrorios.data.di.RepositoryModule
import com.alejandrorios.domain.repository.AnimeRepository
import com.alejandrorios.domain.repository.LocalStorageRepository
import com.alejandrorios.domain.usecase.GetAnimeFavoritesUseCase
import com.alejandrorios.domain.usecase.GetAnimeTrendsUseCase
import com.alejandrorios.domain.usecase.IsAnimeFavoriteUseCase
import com.alejandrorios.domain.usecase.RemoveAnimeFavoriteUseCase
import com.alejandrorios.domain.usecase.UpdateAnimeFavoritesUseCase
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
    fun provideGetAnimeTrendsUseCase(animeRepository: AnimeRepository) = GetAnimeTrendsUseCase(animeRepository)

    @Singleton
    @Provides
    fun provideGetAnimeFavoritesUseCase(localStorageRepository: LocalStorageRepository) = GetAnimeFavoritesUseCase(localStorageRepository)

    @Singleton
    @Provides
    fun provideIsAnimeFavoriteUseCase(localStorageRepository: LocalStorageRepository) = IsAnimeFavoriteUseCase(localStorageRepository)

    @Singleton
    @Provides
    fun provideUpdateAnimeFavoritesUseCase(localStorageRepository: LocalStorageRepository) = UpdateAnimeFavoritesUseCase(localStorageRepository)

    @Singleton
    @Provides
    fun provideRemoveAnimeFavoritesUseCase(localStorageRepository: LocalStorageRepository) = RemoveAnimeFavoriteUseCase(localStorageRepository)
}
