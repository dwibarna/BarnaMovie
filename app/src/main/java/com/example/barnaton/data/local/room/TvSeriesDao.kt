package com.example.barnaton.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import com.example.barnaton.data.local.entity.TvSeriesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TvSeriesDao {
    @Query("SELECT * FROM tv_series")
    fun getAllTvSeries(): Flow<List<TvSeriesEntity>>

    @Insert(onConflict = REPLACE)
    suspend fun insertAllTvSeries(entity: List<TvSeriesEntity>)

    @Query("DELETE from tv_series")
    suspend fun deleteAllTvSeries()

}