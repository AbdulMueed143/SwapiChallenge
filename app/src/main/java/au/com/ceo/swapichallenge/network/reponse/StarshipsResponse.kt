package au.com.ceo.swapichallenge.network.reponse

import au.com.ceo.swapichallenge.network.dto.StarshipDTO
import com.google.gson.annotations.SerializedName

class StarshipsResponse(
    @SerializedName("count")
    var count: String?,

    @SerializedName("next")
    var next: String?,

    @SerializedName("previous")
    var previous: String?,

    @SerializedName("results")
    var results: ArrayList<StarshipDTO>
) {
}