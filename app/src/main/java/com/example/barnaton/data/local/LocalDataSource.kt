package com.example.barnaton.data.local

import com.example.barnaton.data.local.entity.TvSeriesEntity
import com.example.barnaton.data.local.entity.TypeEntity
import com.example.barnaton.data.local.room.TvSeriesDatabase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val database: TvSeriesDatabase) {

    fun getAllTvSeries(typeEntity: String): Flow<List<TvSeriesEntity>> = database.tvSeriesDao().getAllTvSeries(typeEntity = typeEntity)

    suspend fun insertAllTvSeries(entity: List<TvSeriesEntity>) = database.tvSeriesDao().insertAllTvSeries(entity)

    suspend fun deleteAllTvSeries(typeEntity: String) = database.tvSeriesDao().deleteAllTvSeries(typeEntity)

}