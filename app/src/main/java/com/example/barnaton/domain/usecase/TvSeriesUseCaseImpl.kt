package com.example.barnaton.domain.usecase

import com.example.barnaton.data.Resource
import com.example.barnaton.data.repository.TvSeriesRepository
import com.example.barnaton.domain.model.TvDetailSeries
import com.example.barnaton.domain.model.TvFavorite
import com.example.barnaton.domain.model.TvSeries
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TvSeriesUseCaseImpl @Inject constructor(private val repository: TvSeriesRepository) :
    TvSeriesUseCase {
    override fun getAllTopRated(): Flow<Resource<List<TvSeries>>> {
        return repository.getAllTopRated()
    }

    override fun getAllOnAir(): Flow<Resource<List<TvSeries>>> {
        return repository.getAllTopOnAir()
    }

    override fun getAllPopular(): Flow<Resource<List<TvSeries>>> {
        return repository.getAllPopular()
    }

    override fun getDetailFavorite(id: Int): Flow<Resource<TvDetailSeries>> {
        return repository.getDetailFavorite(id = id)
    }

    override fun getAllTvFavorite(): Flow<Resource<List<TvFavorite>>> {
        return repository.getAllTvFavorite()
    }

    override suspend fun insertTvFavorite(entity: TvFavorite) {
        return repository.insertTvFavorite(entity)
    }

    override suspend fun deleteTvFavorite(id: Int) {
        return repository.deleteTvFavorite(id = id)
    }

    override fun getTvFavorite(id: Int): TvFavorite {
        return repository.getTvFavorite(id = id)
    }

    override suspend fun getSearchTvSeries(query: String): Flow<Resource<List<TvSeries>>> {
        return repository.getSearchTvSeries(query = query)
    }
}