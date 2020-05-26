package com.aba.core.presentation

import com.aba.core.BaseState
import com.aba.core.BaseViewModel
import com.aba.core.MviProcessor
import io.reactivex.Observable
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    processor: SearchProcessor
) : BaseViewModel<SearchIntent, SearchState, SearchResult>(
    processor,
    SearchState.idle()
) {


    override fun reduce(initState: SearchState, result: SearchResult): SearchState = when (result) {
        is SearchResult.lastStable -> {
            initState.copy(base = BaseState.stable())
        }
        is SearchResult.Result -> {
            initState.copy(base = BaseState.stable(), tvItems = result.result)
        }
        is SearchResult.Error -> {
            initState.copy(base = BaseState.withError(result.error))
        }
    }


    override fun startWith(): Observable<SearchState> = Observable.just(SearchState.loading())
}