package com.example.barnaton.data.repository

import com.example.barnaton.BuildConfig
import com.example.barnaton.data.Resource
import com.example.barnaton.data.local.entity.TvFavoriteEntity
import com.example.barnaton.data.remote.response.TvSeriesResponse
import com.example.barnaton.domain.model.TvDetailSeries
import com.example.barnaton.domain.model.TvFavorite
import com.example.barnaton.domain.model.TvSeries
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

interface TvSeriesRepository {
    fun getAllTopRated(): Flow<Resource<List<TvSeries>>>

    fun getAllTopOnAir(): Flow<Resource<List<TvSeries>>>

    fun getAllPopular(): Flow<Resource<List<TvSeries>>>

    fun getDetailFavorite(id: Int): Flow<Resource<TvDetailSeries>>

    fun getAllTvFavorite(): Flow<Resource<List<TvFavorite>>>

    suspend fun insertTvFavorite(entity: TvFavorite)

    suspend fun deleteTvFavorite(id: Int)

    fun getTvFavorite(id: Int): TvFavorite

    suspend fun getSearchTvSeries(query: String): Flow<Resource<List<TvSeries>>>
}

