package com.aba.network.remoteDataSource

import com.aba.network.model.SearchDTO
import io.reactivex.Observable

class SearchRemoteDataSourceImpl : SearchRemoteDataSource {
    override fun search(query: String): Observable<List<SearchDTO>> {
        TODO("Not yet implemented")
    }
}