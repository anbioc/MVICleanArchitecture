package com.aba.domain.di

import com.aba.domain.data.SearchRepository
import com.aba.domain.data.SearchRepositoryImpl
import dagger.Binds
import dagger.Module


@Module
abstract class RepositoryModule {
    @Binds
    abstract fun provideSearchRepository(searchRepository: SearchRepositoryImpl): SearchRepository

}