package com.aba.network.remoteDataSource

import com.aba.network.model.SearchDTO
import com.aba.network.service.TvService
import io.reactivex.Observable
import javax.inject.Inject

class SearchRemoteDataSourceImpl @Inject constructor (
    private val service: TvService
) : SearchRemoteDataSource {
    override fun search(query: String): Observable<List<SearchDTO>> =
        service.searchQuery(query)
}