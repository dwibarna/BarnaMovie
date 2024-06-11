package com.example.barnaton.data.remote

import com.example.barnaton.data.remote.network.ApiResponse
import com.example.barnaton.data.remote.network.ApiService
import com.example.barnaton.data.remote.response.TvSeriesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    suspend fun getList(category: Int): Flow<ApiResponse<TvSeriesResponse>> = flow {
        try {
            emit(
                ApiResponse.Success(
                    when (category) {
                        1 -> apiService.getTopRated()
                        2 -> apiService.getPopular()
                        else -> apiService.getOnTheAir()
                    }
                )
            )
        } catch (e: Throwable) {
            emit(ApiResponse.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)
}