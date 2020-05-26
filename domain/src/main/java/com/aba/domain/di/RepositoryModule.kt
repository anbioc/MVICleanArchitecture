package com.aba.domain.di

import androidx.annotation.NonNull
import com.aba.core.remoteDataSource.SearchRemoteDataSource
import com.aba.domain.data.SearchRepository
import com.aba.domain.data.SearchRepositoryImpl
import com.aba.domain.mapper.SearchMapper
import dagger.Module
import dagger.Provides


@Module
class RepositoryModule {
    @Provides
    fun provideSearchRepository(
        @NonNull remoteDataSource: SearchRemoteDataSource,
        @NonNull searchMapper: SearchMapper
    ): SearchRepository = SearchRepositoryImpl(
        remoteDataSource,
        searchMapper
    )

}