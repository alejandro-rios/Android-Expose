package com.alejandrorios.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alejandrorios.data.database.dao.DBAnimeFavoritesDao
import com.alejandrorios.data.database.models.DBAnimeFavorites

/**
 * @author alejandrorios on 9/8/20
 */
@Database(
    entities = [DBAnimeFavorites::class],
    version = 1
)
abstract class AnimeExposeDatabase : RoomDatabase() {

    abstract fun getDBAnimeFavoritesDao(): DBAnimeFavoritesDao
}
