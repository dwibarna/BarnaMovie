package com.example.barnaton.domain.usecase

import com.example.barnaton.data.Resource
import com.example.barnaton.data.repository.TvSeriesRepository
import com.example.barnaton.domain.model.TvDetailSeries
import com.example.barnaton.domain.model.TvSeries
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TvSeriesUseCaseImpl @Inject constructor(private val repository: TvSeriesRepository) : TvSeriesUseCase {
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
}