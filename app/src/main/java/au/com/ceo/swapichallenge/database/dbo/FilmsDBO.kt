package au.com.ceo.swapichallenge.database.dbo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import au.com.ceo.swapichallenge.database.dbo.FilmsDBO.Companion.TABLE_NAME
import au.com.ceo.swapichallenge.models.domainmodels.FilmDomainModel
import java.text.SimpleDateFormat
import java.util.*

@Entity(tableName = TABLE_NAME)
data class FilmsDBO(
    @PrimaryKey //We are just making this assumption
    @ColumnInfo(name = COL_TITLE)
    val title: String,

    @ColumnInfo(name = COL_EPISODE_ID)
    val episodeId: String?,

    @ColumnInfo(name = COL_OPENING_CRAWL)
    val openingCrawl: String?,

    @ColumnInfo(name = COL_DIRECTOR)
    val director: String?,

    @ColumnInfo(name = COL_PRODUCER)
    val producer: String?,

    @ColumnInfo(name = COL_RELEASE_DATE)
    val releaseDate: String?,

    @ColumnInfo(name = COL_CREATED)
    val created: String?,

    @ColumnInfo(name = COL_EDITED)
    val edited: String?,

    @ColumnInfo(name = COL_URL)
    val url: String?,
) {

    companion object {
        const val TABLE_NAME = "films"
        const val COL_TITLE = "title"
        const val COL_EPISODE_ID = "episode_id"
        const val COL_OPENING_CRAWL = "opening_crawl"
        const val COL_DIRECTOR = "director"
        const val COL_PRODUCER = "producer"
        const val COL_RELEASE_DATE = "release_date"
        const val COL_CREATED = "created"
        const val COL_EDITED = "edited"
        const val COL_URL = "url"
    }

    fun toDomainModel() : FilmDomainModel {
        return FilmDomainModel(
            title = this.title,
            director = this.director ?: "",
            producer = this.producer ?: "",
            releaseDate = SimpleDateFormat("yyyy-mm-dd").parse(this.releaseDate) ?: Date()
        )
    }
}