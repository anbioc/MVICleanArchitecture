package com.aba.core.presentation

import com.aba.core.MviProcessor
import com.aba.core.extension.ofType
import com.aba.domain.data.SearchRepository
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import javax.inject.Inject

class SearchProcessor @Inject constructor(
    private val searchRepository: SearchRepository
) : MviProcessor<SearchIntent, SearchResult> {
    override val actionProcessor = ObservableTransformer<SearchIntent, SearchResult> { action ->
//        action.publish {
//            Observable.merge {
//                action.ofType<SearchIntent.Query>().compose(searchProcessor)
//            }
//        }
        action.map {
            it.ofType<SearchIntent.Query>()
        }.compose(searchProcessor)
    }

    private val searchProcessor =
        ObservableTransformer<SearchIntent.Query, SearchResult> { action ->
            action.switchMap {
                searchRepository.search(it.query)
                    .map { result ->
                        SearchResult.Result(result)
                    }
            }
        }
}