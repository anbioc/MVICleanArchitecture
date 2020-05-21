package com.aba.domain.di

import com.aba.domain.mapper.SearchMapper
import dagger.Binds
import dagger.Module

@Module
abstract class MapperModule {

    @Binds
    abstract fun provideSearchMapper(searchMapper: SearchMapper): SearchMapper
}