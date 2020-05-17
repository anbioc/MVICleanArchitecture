package com.aba.network

interface MviView<State: MviState> {
    fun render(states: State)
}