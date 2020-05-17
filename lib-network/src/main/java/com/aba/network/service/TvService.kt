package com.aba.network.service

import com.aba.network.model.SearchDTO
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface TvService {

    @GET("search/shows")
    fun searchQuery(@Query("q") query: String): Observable<List<SearchDTO>>

}