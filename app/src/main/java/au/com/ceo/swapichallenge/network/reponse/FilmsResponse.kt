package au.com.ceo.swapichallenge.network.reponse

import au.com.ceo.swapichallenge.network.dto.FilmDTO
import com.google.gson.annotations.SerializedName

data class FilmsResponse(
    @SerializedName("count")
    var count: String?,

    @SerializedName("next")
    var next: String?,

    @SerializedName("previous")
    var previous: String?,

    @SerializedName("results")
    var results: ArrayList<FilmDTO>
) {
}