package com.aba.core.di

import com.aba.core.MainNavigationActivity
import com.aba.core.scope.PerActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @PerActivity
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainNavigationActivity
}
