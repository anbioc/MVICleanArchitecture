package com.aba.core.presentation

import com.aba.core.MviIntent
import com.aba.domain.model.TvSearchModel

sealed class SearchIntent : MviIntent {

    object Initial: SearchIntent()
    class Query(val query: String): SearchIntent()
    class NextPage(
        val query : String,
        val totalCount : Int,
        val page : Int
    ) : SearchIntent()

    class SearchResultClicked(
        val tvItem: TvSearchModel
    ): SearchIntent()


}
