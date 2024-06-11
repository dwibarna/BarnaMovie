package com.example.barnaton.data.repository

import com.example.barnaton.data.NetworkBoundResource
import com.example.barnaton.data.Resource
import com.example.barnaton.data.local.LocalDataSource
import com.example.barnaton.data.remote.RemoteDataSource
import com.example.barnaton.data.remote.network.ApiResponse
import com.example.barnaton.data.remote.response.TvSeriesResponse
import com.example.barnaton.domain.model.TvSeries
import com.example.barnaton.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TvSeriesRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : TvSeriesRepository {
    override fun getAllTopRated(): Flow<Resource<List<TvSeries>>> {
        return object : NetworkBoundResource<List<TvSeries>, TvSeriesResponse>() {
            override fun loadFromDB(): Flow<List<TvSeries>> {
                return localDataSource.getAllTvSeries().map {
                    DataMapper.tvEntityToDomain(it)
                }
            }

            override suspend fun createCall(): Flow<ApiResponse<TvSeriesResponse>> {
                return remoteDataSource.getList(1)
            }

            override suspend fun saveCallResult(data: TvSeriesResponse) {
                localDataSource.deleteAllTvSeries()
                DataMapper.tvResponseToEntity(data).let {
                    localDataSource.insertAllTvSeries(it)
                }
            }
        }.asFlow()
    }

    override fun getAllTopOnAir(): Flow<Resource<List<TvSeries>>> {
        return object : NetworkBoundResource<List<TvSeries>, TvSeriesResponse>() {
            override fun loadFromDB(): Flow<List<TvSeries>> {
                return localDataSource.getAllTvSeries().map {
                    DataMapper.tvEntityToDomain(it)
                }
            }

            override suspend fun createCall(): Flow<ApiResponse<TvSeriesResponse>> {
                return remoteDataSource.getList(0)
            }

            override suspend fun saveCallResult(data: TvSeriesResponse) {
                localDataSource.deleteAllTvSeries()
                DataMapper.tvResponseToEntity(data).let {
                    localDataSource.insertAllTvSeries(it)
                }
            }
        }.asFlow()
    }

    override fun getAllPopular(): Flow<Resource<List<TvSeries>>> {
        return object : NetworkBoundResource<List<TvSeries>, TvSeriesResponse>() {
            override fun loadFromDB(): Flow<List<TvSeries>> {
                return localDataSource.getAllTvSeries().map {
                    DataMapper.tvEntityToDomain(it)
                }
            }

            override suspend fun createCall(): Flow<ApiResponse<TvSeriesResponse>> {
                return remoteDataSource.getList(2)
            }

            override suspend fun saveCallResult(data: TvSeriesResponse) {
                localDataSource.deleteAllTvSeries()
                DataMapper.tvResponseToEntity(data).let {
                    localDataSource.insertAllTvSeries(it)
                }
            }
        }.asFlow()
    }
}