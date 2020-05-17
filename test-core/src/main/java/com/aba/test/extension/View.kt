package com.aba.test.extension

import android.view.View

infix fun View.isVisible(isVisible: Int) = visibility == isVisible