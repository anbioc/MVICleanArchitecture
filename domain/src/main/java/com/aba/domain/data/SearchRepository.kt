package com.aba.domain.data

import com.aba.domain.model.TvSearchModel
import io.reactivex.Observable

interface SearchRepository {
    fun search(query: String): Observable<List<TvSearchModel>>
}