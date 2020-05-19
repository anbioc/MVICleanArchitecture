package com.aba.core.presentation

import com.aba.core.MviProcessor
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import javax.inject.Inject

class SearchProcessor @Inject constructor(

) : MviProcessor<SearchIntent, SearchResult> {
    override val actionProcessor: ObservableTransformer<SearchIntent, SearchResult> =
        ObservableTransformer {
            Observable.just(SearchResult.Result(emptyList()))
        }
}