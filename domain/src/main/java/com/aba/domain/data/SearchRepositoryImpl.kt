package com.aba.domain.data

import com.aba.core.remoteDataSource.SearchRemoteDataSource
import com.aba.domain.mapper.SearchMapper
import com.aba.domain.model.TvSearchModel
import io.reactivex.Observable
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val remoteDataSource: SearchRemoteDataSource,
    private val searchMapper: SearchMapper
) : SearchRepository {
    override fun search(query: String): Observable<List<TvSearchModel>> =
        remoteDataSource.search(query).map {
            searchMapper.map(it)
        }
}