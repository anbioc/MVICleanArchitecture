package com.aba.domain.mapper

import com.aba.core.baseMapper.Mapper
import com.aba.core.model.SearchDTO
import com.aba.domain.model.TvSearchModel

class SearchMapper: Mapper<List<SearchDTO>, List<TvSearchModel>> {
    override fun map(input: List<SearchDTO>): List<TvSearchModel> = mutableListOf<TvSearchModel>().apply {
        input.forEach {
            add(
                with(it.show){
                    TvSearchModel(
                        id = id,
                        originalImage = image?.original ?: "",
                        mediumImage = image?.medium ?: "",
                        averageRating = rating?.average ?: 0.0,
                        score = it.score,
                        genres = genres ?: listOf(),
                        url = url,
                        language = language,
                        name = name,
                        officialSite = officialSite ?: "",
                        status = status,
                        type = type
                    )
                }

            )
        }
    }
}