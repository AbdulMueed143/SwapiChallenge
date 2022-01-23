package au.com.ceo.swapichallenge.models.viewmodels

import androidx.lifecycle.*
import au.com.ceo.swapichallenge.database.dbo.StarshipDBO
import au.com.ceo.swapichallenge.datasource.repos.StarshipRepository
import au.com.ceo.swapichallenge.models.domainmodels.FilmDomainModel
import au.com.ceo.swapichallenge.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StarshipsViewModel @Inject constructor(starshipRepository: StarshipRepository) : ViewModel() {

    val _starships: LiveData<Resource<List<StarshipDBO>>> =
        starshipRepository.getStarships()
    var starships: LiveData<List<StarshipDBO>> = _starships.switchMap { filterWithLength(it) }

    private fun filterWithLength(starships: Resource<List<StarshipDBO>>) : LiveData<List<StarshipDBO>> {
        val result = MutableLiveData<List<StarshipDBO>>()

        viewModelScope.launch {
            result.value = starships.data?.sortedByDescending {
                it.name.length
            }
        }

        return result
    }

}