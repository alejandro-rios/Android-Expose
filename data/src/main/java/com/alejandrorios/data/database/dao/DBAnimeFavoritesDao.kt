package com.alejandrorios.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alejandrorios.data.database.models.DBAnimeFavoritesEntity

/**
 * @author alejandrorios on 9/8/20
 */
@Dao
interface DBAnimeFavoritesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: DBAnimeFavoritesEntity)

    @Query("SELECT * FROM anime_favorites")
    fun getAll(): List<DBAnimeFavoritesEntity>

    @Query("SELECT * FROM anime_favorites WHERE id = :animeId")
    fun findById(animeId: Int): DBAnimeFavoritesEntity

    @Query("DELETE FROM anime_favorites WHERE id = :animeId")
    fun deleteItem(animeId: Int)
}
