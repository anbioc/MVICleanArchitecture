package com.aba.core.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.aba.core.R


class GeneralEditText: LinearLayout{

    constructor(context: Context): super(context)
    constructor(context: Context, attrs: AttributeSet): super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int): super(context, attrs, defStyleAttr)


    init {
        View.inflate(context, R.layout.inc_search, this)
    }


}