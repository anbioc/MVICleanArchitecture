package com.aba.network.remoteDataSource

import com.aba.network.DataHelper
import com.aba.network.model.SearchDTO
import com.aba.network.service.TvService
import com.aba.test.SOME_NAME
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.anyOrNull
import com.nhaarman.mockitokotlin2.given
import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SearchRemoteDataSourceImplTest {

    private lateinit var testObserver: TestObserver<List<SearchDTO>>
    private val STUB_RESULT = DataHelper.provideStubSearchDto()

    @Mock
    lateinit var mockService: TvService

    @InjectMocks
    lateinit var subject: SearchRemoteDataSourceImpl


    @Before
    fun setup(){

    }

    @Test
    fun `givenSuccessResponse whenOnSearch thenResultIsSuccessful`(){
        givenSuccessResponse()
        whenOnSearch()
        thenResultIsSuccessful()
    }

    /*
     * Given
     */
    private fun givenSuccessResponse() {
        given(mockService.searchQuery(SOME_NAME)).willReturn(
            Observable.just(STUB_RESULT)
        )
    }

    /*
     * When
     */
    private fun whenOnSearch() {
        testObserver = subject.search(SOME_NAME).test()
    }

    /*
     * Then
     */
    private fun thenResultIsSuccessful() = with(STUB_RESULT) {
        testObserver
            .assertComplete()
            .assertNoErrors()
            .assertValue(this)

    }
}