package com.aba.domain.di

import com.aba.domain.mapper.SearchMapper
import dagger.Module
import dagger.Provides

@Module
class MapperModule {

    @Provides
    fun provideSearchMapper(): SearchMapper = SearchMapper()
}