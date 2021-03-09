package com.alejandrorios.data.di

import com.alejandrorios.data.database.AnimeExposeDatabase
import com.alejandrorios.data.database.dao.DBAnimeFavoritesDao
import dagger.Module
import dagger.Provides

/**
 * @author alejandrorios on 9/8/20
 */
@Module
class DatabaseModule {

    @Provides
    fun providesDBAnimeFavoritesDao(
        animeExposeDatabase: AnimeExposeDatabase
    ): DBAnimeFavoritesDao = animeExposeDatabase.animeFavoritesDao()
}
