package com.example.barnaton.utils

import com.example.barnaton.data.local.entity.TvSeriesEntity
import com.example.barnaton.data.remote.response.TvSeriesResponse
import com.example.barnaton.domain.model.TvSeries

object DataMapper {
    fun tvResponseToEntity(data: TvSeriesResponse, type: String): List<TvSeriesEntity> {
        val array: MutableList<TvSeriesEntity> = mutableListOf()
        data.results?.forEach {
            array.add(
                TvSeriesEntity(
                    id = it.id ?: 0,
                    firstAirDate = it.firstAirDate,
                    overview = it.overview,
                    originalLanguage = it.originalLanguage,
                    /*                    genreIds = it.genreIds ,*/
                    posterPath = it.posterPath,
                    /*                    originCountry = it.originCountry,*/
                    backdropPath = it.backdropPath,
                    originalName = it.originalName,
                    voteAverage = it.voteAverage,
                    name = it.name,
                    adult = it.adult,
                    voteCount = it.voteCount,
                    typeEntity = type
                )
            )
        }
        return array
    }

    fun tvEntityToDomain(data: List<TvSeriesEntity>): List<TvSeries> {
        val array: MutableList<TvSeries> = mutableListOf()
        data.forEach { dataa ->
            TvSeries(
                id = dataa.id,
                firstAirDate = dataa.firstAirDate ?: "",
                overview = dataa.overview ?: "No Overview",
                originalLanguage = dataa.originalLanguage ?: "id",
                /*                genreIds = dataa.genreIds ?: emptyList(),*/
                posterPath = "https://image.tmdb.org/t/p/w500" + (dataa.posterPath ?: ""),
                /*                originCountry = dataa.originCountry ?: emptyList(),*/
                backdropPath = "https://image.tmdb.org/t/p/w500" + (dataa.backdropPath ?: ""),
                originalName = dataa.originalName ?: "Untitled",
                voteAverage = dataa.voteAverage ?: 0F,
                name = dataa.name ?: "Untitled",
                adult = dataa.adult ?: false,
                voteCount = dataa.voteCount ?: 0F,
                genreIds = emptyList(),
                originCountry = emptyList()
            ).let(array::add)
        }
        return array
    }
}