package com.aba.domain.data

import com.aba.core.remoteDataSource.SearchRemoteDataSource
import com.aba.domain.DataHelper
import com.aba.domain.mapper.SearchMapper
import com.aba.domain.model.TvSearchModel
import com.aba.test.SOME_EXCEPTION
import com.aba.test.SOME_NAME
import com.nhaarman.mockitokotlin2.any
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
class SearchRepositoryImplTest {

    private lateinit var testObserver: TestObserver<List<TvSearchModel>>

    @InjectMocks
    lateinit var subject: SearchRepositoryImpl
    @Mock
    lateinit var mockRemoteDataSource: SearchRemoteDataSource
    @Mock
    lateinit var mockMapper: SearchMapper


    @Before
    fun setup(){
        given(mockMapper.map(DataHelper.provideSearchDTO())).willReturn(
            DataHelper.provideSearchModel()
        )
    }

    @Test
    fun `givenSuccessfulResult whenOnSearch thenResultIsSuccessful`(){
        givenSuccessfulResult()
        whenOnSearch()
        thenResultIsSuccessful()
        thenVerifyRemoteDataSourceIsCalled()
    }


    @Test
    fun `givenFailureResult whenOnSearch thenResultIsNotCompleted`(){
        givenFailureResult()
        whenOnSearch()
        thenResultIsNotCompleted()
    }



    /*
     * Given
     */
    private fun givenFailureResult() {
        given(mockRemoteDataSource.search(SOME_NAME))
            .willReturn(
                Observable.error(SOME_EXCEPTION)
            )
    }


    private fun givenSuccessfulResult() {
        given(mockRemoteDataSource.search(SOME_NAME)).willReturn(
            Observable.just(
                DataHelper.provideSearchDTO()
            )
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
    private fun thenResultIsSuccessful() = testObserver.assertComplete()
        .assertNoErrors()
        .assertResult(
            DataHelper.provideSearchModel()
        )

    private fun thenResultIsNotCompleted() = testObserver.assertNotComplete()
        .assertError(SOME_EXCEPTION)

    private fun thenVerifyRemoteDataSourceIsCalled() {
        verify(mockRemoteDataSource).search(SOME_NAME)
    }
}