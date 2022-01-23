package au.com.ceo.swapichallenge.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import au.com.ceo.swapichallenge.database.dbo.StarshipDBO

@Dao
interface StarshipDao : BaseDao<StarshipDBO> {
    @Query( "SELECT * FROM "+ StarshipDBO.TABLE_NAME)
    fun getStarships() : LiveData<List<StarshipDBO>>
}