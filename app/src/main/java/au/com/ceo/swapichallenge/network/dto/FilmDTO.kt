package au.com.ceo.swapichallenge.network.dto

/*
* {
            "title": "A New Hope",
            "episode_id": 4,
            "opening_crawl": "It is a period of civil war.\r\nRebel spaceships, striking\r\nfrom a hidden base, have won\r\ntheir first victory against\r\nthe evil Galactic Empire.\r\n\r\nDuring the battle, Rebel\r\nspies managed to steal secret\r\nplans to the Empire's\r\nultimate weapon, the DEATH\r\nSTAR, an armored space\r\nstation with enough power\r\nto destroy an entire planet.\r\n\r\nPursued by the Empire's\r\nsinister agents, Princess\r\nLeia races home aboard her\r\nstarship, custodian of the\r\nstolen plans that can save her\r\npeople and restore\r\nfreedom to the galaxy....",
            "director": "George Lucas",
            "producer": "Gary Kurtz, Rick McCallum",
            "release_date": "1977-05-25",
            "created": "2014-12-10T14:23:31.880000Z",
            "edited": "2014-12-20T19:49:45.256000Z",
            "url": "https://swapi.dev/api/films/1/"
        },
        *
* */

import au.com.ceo.swapichallenge.database.dbo.FilmsDBO
import au.com.ceo.swapichallenge.network.dto.FilmDTO.Companion.COL_TITLE
import com.google.gson.annotations.SerializedName

//We will only get fields that are required by provided document.
//release year, director and producer, etc.
data class FilmDTO(
    @SerializedName(COL_TITLE)
    val title: String,

    @SerializedName(COL_EPISODE_ID)
    val episodeId: String?,

    @SerializedName(COL_OPENING_CRAWL)
    val openingCrawl: String?,

    @SerializedName(COL_DIRECTOR)
    val director: String?,

    @SerializedName(COL_PRODUCER)
    val producer: String?,

    @SerializedName(COL_RELEASE_DATE)
    val releaseDate: String?,

    @SerializedName(COL_CREATED)
    val created: String?,

    @SerializedName(COL_EDITED)
    val edited: String?,

    @SerializedName(COL_URL)
    val url: String?, )
{

    companion object
    {
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

    fun toDBO() : FilmsDBO {
        return FilmsDBO(
            title = this.title,
            episodeId = this.episodeId,
            openingCrawl = this.openingCrawl,
            director = this.director,
            producer = this.producer,
            releaseDate = this.releaseDate,
            created = this.created,
            edited = this.edited,
            url = this.url
        );
    }
}