package com.aba.core.di

import com.aba.core.MviProcessor
import com.aba.core.presentation.SearchIntent
import com.aba.core.presentation.SearchProcessor
import com.aba.core.presentation.SearchResult
import dagger.Binds
import dagger.Module


@Module
abstract class SearchFragmentModule {
    @Binds
    abstract fun provideProcessor(processor: SearchProcessor):
            MviProcessor<SearchIntent, SearchResult>
}
