package com.aba.core.extension

import io.reactivex.Observable
import io.reactivex.annotations.CheckReturnValue
import io.reactivex.annotations.SchedulerSupport
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

fun CompositeDisposable.plusAssign(disposable: Disposable) = add(disposable)


/**
 * Filters the items emitted by an Observable, only emitting those of the specified type.
 */
@CheckReturnValue
@SchedulerSupport(SchedulerSupport.NONE)
inline fun <reified R : Any> Observable<*>.ofType(): Observable<R> = ofType(R::class.java)