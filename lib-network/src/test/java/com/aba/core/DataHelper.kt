package com.aba.core

import com.aba.core.model.SearchDTO
import com.aba.test.*

class DataHelper {
    companion object {
        fun provideStubSearchDto() = listOf(SearchDTO(
            score = SOME_SCORE,
            show = SearchDTO.Show(
                genres = SOME_GENRES,
                id = SOME_ID,
                url = SOME_URL,
                language = SOME_LANGUAGE,
                name = SOME_NAME,
                officialSite = SOME_URL,
                status = SOME_STATUS,
                type = SOME_TYPE,
                rating = SearchDTO.Rating(SOME_SCORE),
                image = SearchDTO.Image(
                    SOME_URL,
                    SOME_URL
                ),
                links = SearchDTO.Links(
                    SearchDTO.PreviousEpisode(SOME_URL),
                    SearchDTO.Self(SOME_URL)
                )
            )
        ))
    }
}