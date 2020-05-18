package com.aba.core.model
import com.google.gson.annotations.SerializedName

data class SearchDTO(
    @SerializedName("score")
    var score: Double ,
    @SerializedName("show")
    var show: Show
) {
    data class Show(
        @SerializedName("genres")
        var genres: List<String>? ,
        @SerializedName("id")
        var id: Int,
        @SerializedName("image")
        var image: Image? ,
        @SerializedName("language")
        var language: String = "" ,
        @SerializedName("_links")
        var links: Links?,
        @SerializedName("name")
        var name: String,
        @SerializedName("officialSite")
        var officialSite: String?,
        @SerializedName("rating")
        var rating: Rating? ,
        @SerializedName("status")
        var status: String,
        @SerializedName("type")
        var type: String,
        @SerializedName("url")
        var url: String
    )

    data class Image(
        @SerializedName("medium")
        var medium: String,
        @SerializedName("original")
        var original: String
    )

    data class Links(
        @SerializedName("previousepisode")
        var previousepisode: PreviousEpisode ,
        @SerializedName("self")
        var self: Self
    )


    data class Rating(
        @SerializedName("average")
        var average: Double?
    )

    data class Self(
        @SerializedName("href")
        var selfHref: String = ""
    )

    data class PreviousEpisode(
        @SerializedName("href")
        var previousEpisodeHref: String = ""
    )
}