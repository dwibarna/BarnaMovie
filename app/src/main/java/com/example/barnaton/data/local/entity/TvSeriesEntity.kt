package com.example.barnaton.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("tv_series")
data class TvSeriesEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo("first_air_date")
    val firstAirDate: String? = null,

    @ColumnInfo("overview")
    val overview: String? = null,

    @ColumnInfo("original_language")
    val originalLanguage: String? = null,

/*    @ColumnInfo("genre_ids")
    val genreIds: List<Int>? = null,*/

    @ColumnInfo("poster_path")
    val posterPath: String? = null,

/*    @ColumnInfo("origin_country")
    val originCountry: List<String>? = null,*/

    @ColumnInfo("backdrop_path")
    val backdropPath: String? = null,

    @ColumnInfo("original_name")
    val originalName: String? = null,

    @ColumnInfo("popularity")
    val popularity: Float? = null,

    @ColumnInfo("vote_average")
    val voteAverage: Float? = null,

    @ColumnInfo("name")
    val name: String? = null,

    @ColumnInfo("adult")
    val adult: Boolean? = null,

    @ColumnInfo("vote_count")
    val voteCount: Float? = null,

    @ColumnInfo("type_entity")
    val typeEntity: String? = null
)


enum class TypeEntity(val value: String) {
    POPULAR("popular"),
    ON_AIR("on_air"),
    TOP_RATED("top_rated"),
    OTHER("other");

/*    companion object {
        fun fromValue(value: String): TypeEntity? {
            for (type in entries) {
                if (type.value == value) {
                    return type
                }
            }
            return null
        }
    }*/
}
