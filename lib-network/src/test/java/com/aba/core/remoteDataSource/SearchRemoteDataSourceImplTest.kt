package com.aba.core.remoteDataSource

import com.aba.core.DataHelper
import com.aba.core.model.SearchDTO
import com.aba.core.service.TvService
import com.aba.test.SOME_EXCEPTION
import com.aba.test.SOME_NAME
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.verify
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
        thenServiceSearchQueryIsCalled()
    }



    @Test
    fun `givenFailureResult whenOnSearch thenOperationNotCompleted`(){
        givenFailureResult()
        whenOnSearch()
        thenOperationNotCompleted()
    }




    /*
     * Given
     */
    private fun givenSuccessResponse() {
        given(mockService.searchQuery(SOME_NAME)).willReturn(
            Observable.just(STUB_RESULT)
        )
    }

    private fun givenFailureResult() {
        given(mockService.searchQuery(SOME_NAME)).willReturn(
            Observable.error(SOME_EXCEPTION)
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

    private fun thenServiceSearchQueryIsCalled() {
        verify(mockService).searchQuery(SOME_NAME)
    }


    private fun thenOperationNotCompleted() {
        testObserver.
        assertNotComplete()
            .assertError(SOME_EXCEPTION)
    }
}