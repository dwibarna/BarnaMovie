package com.example.barnaton.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.barnaton.data.local.entity.TvFavoriteEntity
import com.example.barnaton.data.local.entity.TvSeriesEntity

@Database(
    entities = [TvSeriesEntity::class, TvFavoriteEntity::class ],
    version = 2,
    exportSchema = false
)
abstract class TvSeriesDatabase: RoomDatabase() {
    abstract fun tvSeriesDao(): TvSeriesDao

    abstract fun tvFavoriteDao(): TvSeriesFavoriteDao
}