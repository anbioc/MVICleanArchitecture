package com.aba.core

interface MviIntent {
    fun<R: Any> ofType(): R = (this as R)
}
