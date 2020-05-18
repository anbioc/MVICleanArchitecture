package com.aba.core.service

import com.aba.core.model.SearchDTO
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.observers.TestObserver
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@RunWith(MockitoJUnitRunner::class)
class TvServiceTest {

    private val mockWebServer = MockWebServer()
    private lateinit var subject: TvService

    private lateinit var testObserver: TestObserver<List<SearchDTO>>

    @Before
    fun setup(){
        subject = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .build()
            .create(TvService::class.java)
    }

    @After
    fun `tearDown`(){
        mockWebServer.shutdown()
    }



}