package com.aba.core.presentation

import androidx.lifecycle.ViewModelProvider
import com.aba.core.ErrorSuccessFragment
import com.aba.core.extension.observeLiveData
import com.aba.feature_search.R
import javax.inject.Inject

class SearchFragment: ErrorSuccessFragment<SearchState>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by lazy {
        viewModelFactory.create(SearchViewModel::class.java)
    }

    override fun initView() {
        TODO("Not yet implemented")
    }

    override fun initViewListeners() {
        TODO("Not yet implemented")
    }

    override fun subscribeToLiveData() {
        observeLiveData(viewModel.states()){
            render(it)
        }
    }

    override fun render(state: SearchState) {

    }

    override val contentResourceId: Int
        get() = R.layout.fragment_search

}
