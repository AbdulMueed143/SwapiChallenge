package au.com.ceo.swapichallenge.datasource.remote

import au.com.ceo.swapichallenge.datasource.BaseDataSource
import au.com.ceo.swapichallenge.network.SwapiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FilmRemoteDatasource @Inject constructor(private val service: SwapiService) : BaseDataSource {

    suspend fun getFilms() = getResult {
        service.getFilms()
    }
}