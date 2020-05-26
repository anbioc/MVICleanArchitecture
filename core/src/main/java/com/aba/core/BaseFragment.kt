package com.aba.core

import android.content.Context
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class BaseFragment: Fragment() {

//    @Inject
//    lateinit var fragmentNavigator: FragmentNavigationHelper

    protected abstract val contentResourceId: Int

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)

    }

}