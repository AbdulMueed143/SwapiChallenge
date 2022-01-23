package au.com.ceo.swapichallenge.datasource.remote

import au.com.ceo.swapichallenge.datasource.BaseDataSource
import au.com.ceo.swapichallenge.network.SwapiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StarshipRemoteDatasource @Inject constructor(private val service: SwapiService) : BaseDataSource {

    suspend fun getStarships() = getResult {
        service.getStarships()
    }
}