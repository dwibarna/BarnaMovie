package com.example.barnaton.data.remote

import com.example.barnaton.data.remote.network.ApiResponse
import com.example.barnaton.data.remote.network.ApiService
import com.example.barnaton.data.remote.response.TvSeriesDetailResponse
import com.example.barnaton.data.remote.response.TvSeriesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    suspend fun getListPopular(): Flow<ApiResponse<TvSeriesResponse>> = flow {
        try {
            emit(
                ApiResponse.Success(apiService.getPopular())
            )
        } catch (e: Throwable) {
            emit(ApiResponse.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)


    suspend fun getListTopRated(): Flow<ApiResponse<TvSeriesResponse>> = flow {
        try {
            emit(
                ApiResponse.Success(
                    apiService.getTopRated()
                )
            )
        } catch (e: Throwable) {
            emit(ApiResponse.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)


    suspend fun getListOnAir(): Flow<ApiResponse<TvSeriesResponse>> = flow {
        try {
            emit(
                ApiResponse.Success(
                    apiService.getOnTheAir()
                )
            )
        } catch (e: Throwable) {
            emit(ApiResponse.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

    suspend fun getDetailTvSeries(id: Int): Flow<ApiResponse<TvSeriesDetailResponse>> = flow {
        try {
            emit(
                ApiResponse.Success(
                    apiService.getDetailTvSeries(id = id)
                )
            )
        } catch (e: Throwable) {
            emit(ApiResponse.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

    suspend fun getSearchTvSeries(query: String): Flow<ApiResponse<TvSeriesResponse>> = flow {
        try {
            emit(
                ApiResponse.Success(
                    apiService.getSearchTvSeries(query = query)
                )
            )
        } catch (e: Throwable) {
            emit(ApiResponse.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)
}