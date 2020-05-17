package com.aba.network

import io.reactivex.ObservableTransformer

interface MviProcessor<Action: MviIntent, Result: MviResult> {
    val actionProcessor: ObservableTransformer<Action, Result>
}