package com.aba.core.remoteDataSource

import com.aba.core.model.SearchDTO
import com.aba.core.service.TvService
import io.reactivex.Observable
import javax.inject.Inject

class SearchRemoteDataSourceImpl @Inject constructor (
    private val service: TvService
) : SearchRemoteDataSource {
    override fun search(query: String): Observable<List<SearchDTO>> =
        service.searchQuery(query)
}