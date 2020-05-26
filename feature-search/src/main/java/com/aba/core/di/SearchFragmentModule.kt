package com.aba.core.di


import com.aba.core.presentation.SearchProcessor
import com.aba.core.scope.PerFragment
import dagger.Binds
import dagger.Module


@Module
abstract class SearchFragmentModule {

    @Binds
    @PerFragment
    abstract fun provideProcessor(processor: SearchProcessor):
            SearchProcessor

//    @Provides
//    @PerFragment
//    fun provideProcessor(searchRepository: SearchRepository):
//            MviProcessor<SearchIntent, SearchResult> = SearchProcessor(searchRepository)

}
