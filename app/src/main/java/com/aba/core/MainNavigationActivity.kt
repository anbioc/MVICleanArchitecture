package com.aba.core

import android.os.Bundle
import androidx.navigation.ActivityNavigator
import com.aba.core.extension.makeFullScreen

class MainNavigationActivity: BaseActivity(), NavigatorActivity {
    override val contentResourceId: Int
        get() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        this.makeFullScreen()
        super.onCreate(savedInstanceState)
    }

    override fun finish() {
        super.finish()
        ActivityNavigator.applyPopAnimationsToPendingTransition(this)
    }
}