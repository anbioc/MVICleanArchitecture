package com.aba.core.presentation

import com.aba.core.BaseState
import com.aba.core.MviResult
import com.aba.domain.model.TvSearchModel

sealed class SearchResult: MviResult {

    object lastStable: SearchResult()
    class Error(val error: BaseState.ErrorState): SearchResult()
    class Result(val result: List<TvSearchModel>): SearchResult()
}
