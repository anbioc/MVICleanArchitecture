package com.aba.network.remoteDataSource

import com.aba.network.model.SearchDTO
import io.reactivex.Observable

interface SearchRemoteDataSource {
    fun search(query: String): Observable<List<SearchDTO>>

}