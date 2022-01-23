package au.com.ceo.swapichallenge.network.dto

import au.com.ceo.swapichallenge.database.dbo.StarshipDBO
import com.google.gson.annotations.SerializedName

/*
*
        {
            "name": "CR90 corvette",
            "model": "CR90 corvette",
            "manufacturer": "Corellian Engineering Corporation",
            "cost_in_credits": "3500000",
            "length": "150",
            "max_atmosphering_speed": "950",
            "crew": "30-165",
            "passengers": "600",
            "cargo_capacity": "3000000",
            "consumables": "1 year",
            "hyperdrive_rating": "2.0",
            "MGLT": "60",
            "starship_class": "corvette",
            "created": "2014-12-10T14:20:33.369000Z",
            "edited": "2014-12-20T21:23:49.867000Z",
            "url": "https://swapi.dev/api/starships/2/"
        },
* */

data class StarshipDTO(
    @SerializedName(COL_NAME)
    val name: String,

    @SerializedName(COL_MODEL)
    val model: String?,

    @SerializedName(COL_MANUFACTURER)
    val manufacturer: String?,

    @SerializedName(COL_CREW)
    val crew: String?,

    @SerializedName(COL_PASSENGERS)
    val passengers: String?,

    @SerializedName(COL_CARGO_CAPACITY)
    val cargoCapacity: String?,

    @SerializedName(COL_CONSUMABLES)
    val consumables: String?,

    @SerializedName(COL_CREATED)
    val created: String?,

    @SerializedName(COL_EDITED)
    val edited: String?,

    @SerializedName(COL_URL)
    val url: String?,
)
{
    companion object {
        const val COL_NAME = "name"
        const val COL_MODEL = "model"
        const val COL_MANUFACTURER = "manufacturer"
        const val COL_CREW = "crew"
        const val COL_PASSENGERS = "passengers"
        const val COL_CARGO_CAPACITY = "cargo_capacity"
        const val COL_CONSUMABLES = "consumables"
        const val COL_CREATED = "created"
        const val COL_EDITED = "edited"
        const val COL_URL = "url"
    }

    fun toDBO() : StarshipDBO {
        //technically we should be converting date time here or we can use dbo converters and there are many ways whatever you prefer mate!
        return StarshipDBO(
            name = this.name,
            model = this.model,
            manufacturer = this.manufacturer,
            crew = this.crew,
            passengers = this.passengers,
            cargoCapacity = this.cargoCapacity,
            consumables = this.consumables,
            created = this.created,
            edited = this.edited,
            url = this.url
        )
    }
}