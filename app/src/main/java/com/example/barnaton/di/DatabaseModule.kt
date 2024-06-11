package com.example.barnaton.di

import android.content.Context
import androidx.room.Room
import com.example.barnaton.data.local.room.TvSeriesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): TvSeriesDatabase =
        Room.databaseBuilder(
            context = context,
            klass = TvSeriesDatabase::class.java,
            name = "tv_series.db"
        )
            .fallbackToDestructiveMigration()
            .build()


    @Provides
    fun provideTvSeriesDao(database: TvSeriesDatabase) = database.tvSeriesDao()
}