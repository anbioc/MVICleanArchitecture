package com.aba.core

interface MviView<State: MviState> {
    fun render(states: State)
}