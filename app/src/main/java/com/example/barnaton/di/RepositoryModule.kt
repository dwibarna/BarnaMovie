package com.example.barnaton.di

import com.example.barnaton.data.repository.TvSeriesRepository
import com.example.barnaton.data.repository.TvSeriesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(
    includes = [
        DatabaseModule::class,
        NetworkModule::class
    ]
)
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(repositoryImpl: TvSeriesRepositoryImpl): TvSeriesRepository

}