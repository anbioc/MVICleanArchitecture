package com.aba.core.util

import com.aba.domain.model.TvSearchModel
import com.aba.test.*

object DataHelper {

    fun provideTvSearchModelItems() = listOf(
        TvSearchModel(
            id = SOME_OTHER_ID,
            type = SOME_OTHER_TYPE,
            status = SOME_OTHER_STATUS,
            officialSite = SOME_OTHER_URL,
            name = SOME_OTHER_NAME,
            language = SOME_OTHER_LANGUAGE,
            url = SOME_OTHER_URL,
            genres = SOME_OTHER_GENRES,
            score = SOME_OTHER_SCORE,
            averageRating = SOME_OTHER_SCORE,
            mediumImage = SOME_OTHER_URL,
            originalImage = SOME_OTHER_URL
        )
    )
}