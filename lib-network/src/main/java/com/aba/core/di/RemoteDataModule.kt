package com.aba.core.di

import androidx.annotation.NonNull
import com.aba.core.remoteDataSource.SearchRemoteDataSource
import com.aba.core.remoteDataSource.SearchRemoteDataSourceImpl
import com.aba.core.service.TvService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class RemoteDataModule {

    @Provides
    fun provideSearchRemoteDataSource(
        @NonNull service: TvService
    ): SearchRemoteDataSource = SearchRemoteDataSourceImpl(service)

    @Provides
    fun provideTvService(@NonNull retrofit: Retrofit) = retrofit.create(TvService::class.java)


}