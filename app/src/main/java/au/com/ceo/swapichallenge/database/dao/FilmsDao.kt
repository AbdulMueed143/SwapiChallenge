package au.com.ceo.swapichallenge.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import au.com.ceo.swapichallenge.database.dbo.FilmsDBO

@Dao
interface FilmsDao : BaseDao<FilmsDBO> {
    @Query( "SELECT * FROM "+FilmsDBO.TABLE_NAME)
    fun getFilms() : LiveData<List<FilmsDBO>>
}