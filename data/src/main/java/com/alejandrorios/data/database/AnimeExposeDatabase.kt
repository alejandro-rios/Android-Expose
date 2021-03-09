package com.alejandrorios.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alejandrorios.data.database.dao.DBAnimeFavoritesDao
import com.alejandrorios.data.database.models.DBAnimeFavoritesEntity

/**
 * @author alejandrorios on 9/8/20
 */
@Database(
    entities = [DBAnimeFavoritesEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AnimeExposeDatabase : RoomDatabase() {

    abstract fun animeFavoritesDao(): DBAnimeFavoritesDao
}
