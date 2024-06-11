package com.example.barnaton.di

import com.example.barnaton.domain.usecase.TvSeriesUseCase
import com.example.barnaton.domain.usecase.TvSeriesUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {

    @Binds
    @ViewModelScoped
    abstract fun provideTvSeriesUseCase(useCaseImpl: TvSeriesUseCaseImpl): TvSeriesUseCase
}