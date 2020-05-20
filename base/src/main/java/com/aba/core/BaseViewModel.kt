package com.aba.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.BiFunction
import io.reactivex.subjects.PublishSubject

abstract class BaseViewModel<Intent : MviIntent, State : MviState, Result : MviResult>(
    private val processor: MviProcessor<Intent, Result>,
    private val startState: State
) : MviViewModel<Intent, State>, ViewModel() {

    private val compositeDisposable: CompositeDisposable by lazy {
        CompositeDisposable()
    }
    private val _stateLiveData by lazy {
        MutableLiveData<State>()
    }
    private val intentSubject: PublishSubject<Intent> by lazy {
        PublishSubject.create<Intent>()
    }



    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    override fun states(): LiveData<State> {
        compositeDisposable.add(compose().subscribe {
            _stateLiveData.postValue(it)
        })
       return  _stateLiveData
    }

    override fun processIntents(intent: Intent) {
        intentSubject.onNext(intent)
    }

    private val intentFilter = ObservableTransformer<Intent, Intent> { intent ->
        filterIntent(intent)
    }

    private val reducer = BiFunction<State, Result, State> { initState, result ->
        reduce(initState, result)
    }


    private fun compose(): Observable<State> = intentSubject
        .compose(intentFilter)
        .compose(processor.actionProcessor)
        .scan(startState, reducer)
        .startWith(startWith())



    abstract fun startWith(): Observable<State>
    protected open fun filterIntent(intent: Observable<Intent>) = intent
    protected abstract fun reduce(initState: State, result: Result): State

}