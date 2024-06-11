package com.example.barnaton.data.remote.network

import com.example.barnaton.BuildConfig
import com.example.barnaton.data.remote.response.TvSeriesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("tv/top_rated")
    suspend fun getTopRated(
        @Query("API_KEY") apiKey: String = BuildConfig.BASE_API_KEY
    ): TvSeriesResponse

    @GET("tv/popular")
    suspend fun getPopular(
        @Query("API_KEY") apiKey: String = BuildConfig.BASE_API_KEY
    ): TvSeriesResponse

    @GET("tv/on_the_air")
    suspend fun getOnTheAir(
        @Query("API_KEY") apiKey: String = BuildConfig.BASE_API_KEY
    ): TvSeriesResponse
}