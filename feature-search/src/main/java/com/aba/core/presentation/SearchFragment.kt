package com.aba.core.presentation

import androidx.lifecycle.ViewModelProvider
import com.aba.core.ErrorSuccessFragment
import com.aba.feature_search.R
import javax.inject.Inject

class SearchFragment: ErrorSuccessFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    val viewModel by lazy {
        viewModelFactory.create(SearchViewModel::class.java)
    }

    override fun initView() {
        TODO("Not yet implemented")
    }

    override fun initViewListeners() {
        TODO("Not yet implemented")
    }

    override val contentResourceId: Int
        get() = R.layout.fragment_search

}
