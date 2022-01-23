package au.com.ceo.swapichallenge.models.domainmodels

import java.util.*

class FilmDomainModel {
    var title: String = ""
    var director: String = ""
    var producer: String = ""
    var releaseDate: Date = Date()

    var releaseDateAsString: String = ""
    get() {
        return releaseDate.toString()
    }

    constructor(title: String, director: String, producer: String, releaseDate: Date) {
        this.title = title
        this.director = director
        this.producer = producer
        this.releaseDate = releaseDate
    }


}