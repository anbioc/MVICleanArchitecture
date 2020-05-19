package com.aba.core.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.aba.core.BaseState
import com.aba.core.MviProcessor
import com.aba.core.util.DataHelper
import com.aba.domain.model.TvSearchModel
import com.aba.test.SOME_NAME
import com.aba.test.extension.observeOnce
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations.initMocks
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class SearchViewModelTest {


    @get:Rule
    val rule = InstantTaskExecutorRule()

//    @get:Rule
//    var timeoutRule: RxImmediateSchedulerRule = RxImmediateSchedulerRule()


    private val mockProcessor: MviProcessor<SearchIntent, SearchResult> = mock()
    lateinit var subject: SearchViewModel

    @Before
    fun setup(){
        initMocks(this)
        subject = SearchViewModel(mockProcessor)
    }

    @Test
    fun `givenProcessorResultIsSuccessful whenOnSearch thenResultIsSuccessful`(){
        givenProcessorResultIsSuccessful()
        whenOnSearch()
        thenResultIsSuccessful()
    }

    @Test
    fun `givenProcessorResultIsFailure whenOnSearch thenResultIsFailure`(){
        givenProcessorResultIsFailure()
        whenOnSearch()
        thenResultIsFailure()
    }





    /*
     * Given
     */
    private fun givenProcessorResultIsSuccessful() {
        given(mockProcessor.actionProcessor).willReturn(
            ObservableTransformer {
                Observable.just(SearchResult.Result(DataHelper.provideTvSearchModelItems()))
            }
        )
    }

    private fun givenProcessorResultIsFailure() {
        given(mockProcessor.actionProcessor).willReturn(
            ObservableTransformer {
                Observable.just(SearchResult.Error(
                    BaseState.ErrorState.String(SOME_NAME)))
            }
        )
    }


    /*
     * When
     */
    private fun whenOnSearch() {
        subject.processIntents(SearchIntent.Query(SOME_NAME))
    }

    /*
     * Then
     */
    private fun thenResultIsSuccessful() =
        subject.states().observeOnce { state ->
        assertThat(state.base).isEqualTo(BaseState.stable())
        assertThat(state.tvItems).isEqualTo(DataHelper.provideTvSearchModelItems())
    }

    private fun thenResultIsFailure() = subject.states().observeOnce { state ->
        assertThat(state.base).isEqualTo(BaseState.showError(SOME_NAME))
        assertThat(state.tvItems).isEqualTo(emptyList<TvSearchModel>())
    }

}