package com.aba.core.presentation

import com.aba.core.BaseMviState
import com.aba.core.BaseState
import com.aba.domain.model.TvSearchModel

data class SearchState(
    override val base: BaseState,
    val tvItems: List<TvSearchModel>
    ): BaseMviState {
    companion object {
        fun loading() = SearchState(
            base = BaseState.loading(),
            tvItems = emptyList()
        )
        fun idle() = SearchState(
            base = BaseState.stable(),
            tvItems = emptyList()
        )
    }
}
