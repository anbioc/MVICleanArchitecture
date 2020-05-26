package com.aba.core.di

import android.app.Application
import android.content.Context
import com.aba.core.ThemeProvider
import com.aba.core.base.MainThemeProvider
import dagger.Module
import dagger.Provides

@Module
class AndroidModule {

    @Provides
    fun provideTheme(): ThemeProvider = MainThemeProvider()

    @Provides
    fun provideContext(application: Application): Context = application.applicationContext
}