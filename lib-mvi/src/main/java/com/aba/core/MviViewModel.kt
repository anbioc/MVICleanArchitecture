package com.aba.core

import androidx.lifecycle.LiveData

interface MviViewModel<I: MviIntent, S: MviState>{

    fun states() : LiveData<S>
    fun processIntents(intent: I)

}