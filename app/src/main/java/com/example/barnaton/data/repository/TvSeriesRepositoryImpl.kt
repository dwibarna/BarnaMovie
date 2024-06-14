package com.example.barnaton.data.repository

import com.example.barnaton.data.NetworkBoundResource
import com.example.barnaton.data.Resource
import com.example.barnaton.data.local.LocalDataSource
import com.example.barnaton.data.local.entity.TypeEntity
import com.example.barnaton.data.remote.RemoteDataSource
import com.example.barnaton.data.remote.network.ApiResponse
import com.example.barnaton.data.remote.response.TvSeriesResponse
import com.example.barnaton.domain.model.TvDetailSeries
import com.example.barnaton.domain.model.TvFavorite
import com.example.barnaton.domain.model.TvSeries
import com.example.barnaton.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
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
                return localDataSource.getAllTvSeries(TypeEntity.TOP_RATED.value).map {
                    DataMapper.tvEntityToDomain(it)
                }
            }

            override suspend fun createCall(): Flow<ApiResponse<TvSeriesResponse>> {
                return remoteDataSource.getListTopRated()
            }

            override suspend fun saveCallResult(data: TvSeriesResponse) {
                localDataSource.deleteAllTvSeries(TypeEntity.TOP_RATED.value)
                DataMapper.tvResponseToEntity(data, TypeEntity.TOP_RATED.value).let {
                    localDataSource.insertAllTvSeries(it)
                }
            }
        }.asFlow()
    }

    override fun getAllTopOnAir(): Flow<Resource<List<TvSeries>>> {
        return object : NetworkBoundResource<List<TvSeries>, TvSeriesResponse>() {
            override fun loadFromDB(): Flow<List<TvSeries>> {
                return localDataSource.getAllTvSeries(TypeEntity.ON_AIR.value).map {
                    DataMapper.tvEntityToDomain(it)
                }
            }

            override suspend fun createCall(): Flow<ApiResponse<TvSeriesResponse>> {
                return remoteDataSource.getListOnAir()
            }

            override suspend fun saveCallResult(data: TvSeriesResponse) {
                localDataSource.deleteAllTvSeries(TypeEntity.ON_AIR.value)
                DataMapper.tvResponseToEntity(data, TypeEntity.ON_AIR.value).let {
                    localDataSource.insertAllTvSeries(it)
                }
            }
        }.asFlow()
    }

    override fun getAllPopular(): Flow<Resource<List<TvSeries>>> {
        return object : NetworkBoundResource<List<TvSeries>, TvSeriesResponse>() {
            override fun loadFromDB(): Flow<List<TvSeries>> {
                return localDataSource.getAllTvSeries(TypeEntity.POPULAR.value).map {
                    DataMapper.tvEntityToDomain(it)
                }
            }

            override suspend fun createCall(): Flow<ApiResponse<TvSeriesResponse>> {
                return remoteDataSource.getListPopular()
            }

            override suspend fun saveCallResult(data: TvSeriesResponse) {
                localDataSource.deleteAllTvSeries(TypeEntity.POPULAR.value)
                DataMapper.tvResponseToEntity(data, TypeEntity.POPULAR.value).let {
                    localDataSource.insertAllTvSeries(it)
                }
            }
        }.asFlow()
    }

    override fun getDetailFavorite(id: Int): Flow<Resource<TvDetailSeries>> {
        return flow {
            emit(Resource.Loading())
            when (val apiResponse = remoteDataSource.getDetailTvSeries(id = id).first()) {
                is ApiResponse.Error -> {
                    emit(Resource.Error(message = apiResponse.message))
                }

                is ApiResponse.Success -> {
                    emit(Resource.Success(DataMapper.tvDetailResponseToDomain(apiResponse.data)))
                }
            }
        }
    }

    override fun getAllTvFavorite(): Flow<Resource<List<TvFavorite>>> {
        return flow {
            emit(Resource.Loading())
            emitAll(
                localDataSource.getAllTvFavorite().map {
                    Resource.Success(DataMapper.tvFavoriteListEntityToDomain(it))
                }
            )
        }
    }

    override suspend fun insertTvFavorite(entity: TvFavorite) {
        localDataSource.insertTvFavorite(DataMapper.tvFavoriteDomainToEntity(entity))
    }

    override suspend fun deleteTvFavorite(id: Int) {
        localDataSource.deleteTvFavorite(id)
    }

    override fun getTvFavorite(id: Int): TvFavorite {
        return DataMapper.tvFavoriteEntityToDomain(localDataSource.getTvFavorite(id))
    }
}