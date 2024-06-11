package com.example.barnaton.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.barnaton.data.local.entity.TvSeriesEntity

@Database(
    entities = [TvSeriesEntity::class ],
    version = 1,
    exportSchema = false
)
abstract class TvSeriesDatabase: RoomDatabase() {
    abstract fun tvSeriesDao(): TvSeriesDao
}