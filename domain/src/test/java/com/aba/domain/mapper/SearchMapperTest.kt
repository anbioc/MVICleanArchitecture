package com.aba.domain.mapper

import com.aba.domain.DataHelper
import com.aba.domain.model.TvSearchModel
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SearchMapperTest {

    private lateinit var result: List<TvSearchModel>

    @InjectMocks
    lateinit var subject: SearchMapper

    @Test
    fun `whenOnMap thenInputIsMapped`(){
        whenOnMap()
        thenInputIsMapped()
    }

    /*
     * When
     */
    private fun whenOnMap() {
        result = subject.map(DataHelper.provideSearchDTO())
    }

    /*
     * Then
     */
    private fun thenInputIsMapped() = with(result[0]) {
        assertThat(id).isEqualTo(DataHelper.provideSearchModel()[0].id)
        assertThat(score).isEqualTo(DataHelper.provideSearchModel()[0].score)
        assertThat(genres).isEqualTo(DataHelper.provideSearchModel()[0].genres)
        assertThat(name).isEqualTo(DataHelper.provideSearchModel()[0].name)
        assertThat(language).isEqualTo(DataHelper.provideSearchModel()[0].language)
        assertThat(officialSite).isEqualTo(DataHelper.provideSearchModel()[0].officialSite)
        assertThat(status).isEqualTo(DataHelper.provideSearchModel()[0].status)
        assertThat(type).isEqualTo(DataHelper.provideSearchModel()[0].type)
        assertThat(url).isEqualTo(DataHelper.provideSearchModel()[0].url)
        assertThat(mediumImage).isEqualTo(DataHelper.provideSearchModel()[0].mediumImage)
        assertThat(originalImage).isEqualTo(DataHelper.provideSearchModel()[0].originalImage)
        assertThat(averageRating).isEqualTo(DataHelper.provideSearchModel()[0].averageRating)
    }
}