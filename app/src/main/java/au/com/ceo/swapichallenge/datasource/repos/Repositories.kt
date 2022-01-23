package au.com.ceo.swapichallenge.datasource.repos

import androidx.lifecycle.LiveData
import au.com.ceo.swapichallenge.database.dbo.FilmsDBO
import au.com.ceo.swapichallenge.database.dbo.StarshipDBO
import au.com.ceo.swapichallenge.utils.Resource

interface BaseRepository {}

interface IFilmRepository : BaseRepository {
    fun getFilms() : LiveData<Resource<List<FilmsDBO>>>
}

interface IStarshipRepository : BaseRepository {
    fun getStarships() : LiveData<Resource<List<StarshipDBO>>>
}