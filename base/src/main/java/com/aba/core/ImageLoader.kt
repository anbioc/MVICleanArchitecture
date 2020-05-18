package com.aba.core

import android.widget.ImageView

interface ImageLoader {

    fun loadImage(view: ImageView,
                  placeHolderId: Int,
                  errorPlaceHolderId: Int,
                  imageUrl: String)

}