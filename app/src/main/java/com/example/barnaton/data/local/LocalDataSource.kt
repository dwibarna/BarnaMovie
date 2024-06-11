package com.example.barnaton.data.local

import com.example.barnaton.data.local.entity.TvSeriesEntity
import com.example.barnaton.data.local.room.TvSeriesDatabase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val database: TvSeriesDatabase) {

    fun getAllTvSeries(): Flow<List<TvSeriesEntity>> = database.tvSeriesDao().getAllTvSeries()

    suspend fun insertAllTvSeries(entity: List<TvSeriesEntity>) = database.tvSeriesDao().insertAllTvSeries(entity)

    suspend fun deleteAllTvSeries() = database.tvSeriesDao().deleteAllTvSeries()

}