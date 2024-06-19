package com.example.barnaton.data.local

import com.example.barnaton.data.local.entity.TvFavoriteEntity
import com.example.barnaton.data.local.entity.TvSeriesEntity
import com.example.barnaton.data.local.room.TvSeriesDatabase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val database: TvSeriesDatabase) {

    fun getAllTvSeries(typeEntity: String): Flow<List<TvSeriesEntity>> =
        database.tvSeriesDao().getAllTvSeries(typeEntity = typeEntity)

    suspend fun insertAllTvSeries(entity: List<TvSeriesEntity>) =
        database.tvSeriesDao().insertAllTvSeries(entity)

    suspend fun deleteAllTvSeries(typeEntity: String) =
        database.tvSeriesDao().deleteAllTvSeries(typeEntity)


    fun getAllTvFavorite(): Flow<List<TvFavoriteEntity>> =
        database.tvFavoriteDao().getAllTvFavorite()

    suspend fun insertTvFavorite(entity: TvFavoriteEntity) =
        database.tvFavoriteDao().insertTvFavorite(entity = entity)

    suspend fun deleteTvFavorite(id: Int) = database.tvFavoriteDao().deleteTvFavorite(id = id)

    fun getTvFavorite(id: Int): TvFavoriteEntity? = database.tvFavoriteDao().getTvFavorite(id = id)
}