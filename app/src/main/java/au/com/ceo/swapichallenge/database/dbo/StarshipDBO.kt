package au.com.ceo.swapichallenge.database.dbo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import au.com.ceo.swapichallenge.database.dbo.StarshipDBO.Companion.TABLE_NAME
import au.com.ceo.swapichallenge.network.dto.StarshipDTO

@Entity(tableName = TABLE_NAME)
data class StarshipDBO(

    @PrimaryKey //making this assumption
    @ColumnInfo(name = StarshipDTO.COL_NAME)
    val name: String,

    @ColumnInfo(name =StarshipDTO.COL_MODEL)
    val model: String?,

    @ColumnInfo(name =StarshipDTO.COL_MANUFACTURER)
    val manufacturer: String?,

    @ColumnInfo(name =StarshipDTO.COL_CREW)
    val crew: String?,

    @ColumnInfo(name =StarshipDTO.COL_PASSENGERS)
    val passengers: String?,

    @ColumnInfo(name =StarshipDTO.COL_CARGO_CAPACITY)
    val cargoCapacity: String?,

    @ColumnInfo(name =StarshipDTO.COL_CONSUMABLES)
    val consumables: String?,

    @ColumnInfo(name =StarshipDTO.COL_CREATED)
    val created: String?,

    @ColumnInfo(name =StarshipDTO.COL_EDITED)
    val edited: String?,

    @ColumnInfo(name =StarshipDTO.COL_URL)
    val url: String?,
) {

    companion object {
        const val TABLE_NAME = "starship"
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
}