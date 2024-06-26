package com.example.barnaton.data.remote.network

import com.example.barnaton.BuildConfig
import com.example.barnaton.data.remote.response.TvSeriesDetailResponse
import com.example.barnaton.data.remote.response.TvSeriesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("tv/top_rated")
    suspend fun getTopRated(
        @Query("api_key") apiKey: String = BuildConfig.BASE_API_KEY
    ): TvSeriesResponse

    @GET("tv/popular")
    suspend fun getPopular(
        @Query("api_key") apiKey: String = BuildConfig.BASE_API_KEY
    ): TvSeriesResponse

    @GET("tv/on_the_air")
    suspend fun getOnTheAir(
        @Query("api_key") apiKey: String = BuildConfig.BASE_API_KEY
    ): TvSeriesResponse

    @GET("tv/{id}")
    suspend fun getDetailTvSeries(
        @Path("id") id: Int,
        @Query("api_key") apiKey: String = BuildConfig.BASE_API_KEY,
    ): TvSeriesDetailResponse

    @GET("search/tv")
    suspend fun getSearchTvSeries(
        @Query("api_key") apiKey: String = BuildConfig.BASE_API_KEY,
        @Query("query") query: String
    ): TvSeriesResponse
}