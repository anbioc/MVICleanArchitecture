package com.aba.core.baseMapper

interface Mapper<T, R> {
    fun map(input: T): R
}


interface LocalMapper<T, R> {
    fun mapToLocal(items: R):T
    fun mapFromLocal(items: T): R
}