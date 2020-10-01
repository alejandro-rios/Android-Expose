package com.alejandrorios.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alejandrorios.data.database.models.DBAnimeFavorites

/**
 * @author alejandrorios on 9/8/20
 */
@Dao
interface DBAnimeFavoritesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: DBAnimeFavorites)

    @Query("SELECT * FROM anime_favorites")
    fun getAll(): List<DBAnimeFavorites>

    @Query("DELETE FROM anime_favorites")
    fun deleteAll()
}
