package com.aba.core

import android.os.Bundle
import androidx.fragment.app.Fragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.DaggerAppCompatActivity
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class BaseActivity : DaggerAppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var themeProvider: ThemeProvider

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    protected abstract val contentResourceId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        applyAppTheme()
        setContentView(contentResourceId)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector


    private fun applyAppTheme() = setTheme(themeProvider.theme)


}