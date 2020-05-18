package com.aba.core

interface ErrorContainer {
    fun getError(throwable: Throwable): ErrorEntity
}