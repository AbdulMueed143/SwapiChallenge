package au.com.ceo.swapichallenge.network

import au.com.ceo.swapichallenge.network.reponse.FilmsResponse
import au.com.ceo.swapichallenge.network.reponse.StarshipsResponse
import retrofit2.Response
import retrofit2.http.GET

interface SwapiService {

    @GET("/api/films")
    suspend fun getFilms() : Response<FilmsResponse>

    @GET("/api/starships")
    suspend fun getStarships() : Response<StarshipsResponse>

}