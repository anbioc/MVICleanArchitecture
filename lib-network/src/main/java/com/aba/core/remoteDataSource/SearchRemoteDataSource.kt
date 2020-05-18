package com.aba.core.remoteDataSource

import com.aba.core.model.SearchDTO
import io.reactivex.Observable

interface SearchRemoteDataSource {
    fun search(query: String): Observable<List<SearchDTO>>

}