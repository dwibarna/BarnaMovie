package com.example.barnaton.domain.usecase

import com.example.barnaton.data.Resource
import com.example.barnaton.domain.model.TvDetailSeries
import com.example.barnaton.domain.model.TvFavorite
import com.example.barnaton.domain.model.TvSeries
import kotlinx.coroutines.flow.Flow

interface TvSeriesUseCase {

    fun getAllTopRated(): Flow<Resource<List<TvSeries>>>

    fun getAllOnAir(): Flow<Resource<List<TvSeries>>>

    fun getAllPopular(): Flow<Resource<List<TvSeries>>>

    fun getDetailFavorite(id: Int): Flow<Resource<TvDetailSeries>>

    fun getAllTvFavorite(): Flow<Resource<List<TvFavorite>>>

    suspend fun insertTvFavorite(entity: TvFavorite)

    suspend fun deleteTvFavorite(id: Int)

    fun getTvFavorite(id: Int): TvFavorite

    suspend fun getSearchTvSeries(query: String): Flow<Resource<List<TvSeries>>>
}