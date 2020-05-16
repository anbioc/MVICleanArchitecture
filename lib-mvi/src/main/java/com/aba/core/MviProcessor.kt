package com.aba.core

import io.reactivex.ObservableTransformer

interface MviProcessor<Action: MviIntent, Result: MviResult> {
    val actionProcessor: ObservableTransformer<Action, Result>
}