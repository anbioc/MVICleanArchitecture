package com.aba.core.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.aba.core.util.DataHelper
import com.aba.domain.data.SearchRepository
import com.aba.test.SOME_EXCEPTION
import com.aba.test.SOME_NAME
import com.nhaarman.mockitokotlin2.given
import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class SearchProcessorTest {


    private lateinit var testObserver: TestObserver<SearchResult>

    @get:Rule
    val rule = InstantTaskExecutorRule()


    @Mock
    lateinit var mockRepository: SearchRepository
    @InjectMocks
    lateinit var subject: SearchProcessor


    @Test
    fun `givenSuccessfulResult whenOnAction thenResultIsSuccessful`(){
        givenSuccessfulResult()
        whenOnAction()
        thenResultIsSuccessful()
    }

    @Test
    fun `givenFailureResult whenOnAction thenResultIsNotCompleted`(){
        givenFailureResult()
        whenOnAction()
        thenResultIsNotCompleted()
    }


    /*
     * Given
     */
    private fun givenSuccessfulResult() {
        given(mockRepository.search(SOME_NAME)).willReturn(
            Observable.just(DataHelper.provideTvSearchModelItems())
        )
    }

    private fun givenFailureResult() {
        given(mockRepository.search(SOME_NAME)).willReturn(
            Observable.error(SOME_EXCEPTION)
        )
    }


    /*
     * When
     */
    private fun whenOnAction() {
        testObserver = Observable.just(SearchIntent.Query(SOME_NAME))
            .compose(subject.actionProcessor)
            .test()
    }



    /*
     * Then
     */
    private fun thenResultIsSuccessful() = testObserver.assertComplete()
        .assertNoErrors().apply {
            assertValue {
                (it as SearchResult.Result).result == DataHelper.provideTvSearchModelItems()
            }
        }


    private fun thenResultIsNotCompleted() = testObserver.assertNotComplete()
        .assertError(SOME_EXCEPTION)

}

