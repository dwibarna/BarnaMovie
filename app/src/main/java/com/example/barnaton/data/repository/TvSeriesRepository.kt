package com.example.barnaton.data.repository

import com.example.barnaton.data.Resource
import com.example.barnaton.domain.model.TvSeries
import kotlinx.coroutines.flow.Flow

interface TvSeriesRepository {
    fun getAllTopRated(): Flow<Resource<List<TvSeries>>>

    fun getAllTopOnAir(): Flow<Resource<List<TvSeries>>>

    fun getAllPopular(): Flow<Resource<List<TvSeries>>>
}

