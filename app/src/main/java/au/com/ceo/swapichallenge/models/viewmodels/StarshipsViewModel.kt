package au.com.ceo.swapichallenge.models.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import au.com.ceo.swapichallenge.database.dbo.StarshipDBO
import au.com.ceo.swapichallenge.datasource.repos.StarshipRepository
import au.com.ceo.swapichallenge.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StarshipsViewModel @Inject constructor(starshipRepository: StarshipRepository) : ViewModel() {

    val _starships: LiveData<Resource<List<StarshipDBO>>> =
        starshipRepository.getStarships()
    var starships: List<StarshipDBO>? = null

}