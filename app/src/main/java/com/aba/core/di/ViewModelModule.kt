package com.aba.core.di

import androidx.lifecycle.ViewModelProvider
import com.aba.core.AppViewModelFactory
import com.aba.core.ViewModelKey
import com.aba.core.presentation.SearchViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import androidx.lifecycle.ViewModel

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    abstract fun provideSearchViewModel(searchViewModel: SearchViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory : AppViewModelFactory) : ViewModelProvider.Factory

}