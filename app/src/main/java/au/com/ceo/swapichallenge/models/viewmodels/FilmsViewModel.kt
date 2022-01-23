package au.com.ceo.swapichallenge.models.viewmodels

import androidx.lifecycle.*
import au.com.ceo.swapichallenge.database.dbo.FilmsDBO
import au.com.ceo.swapichallenge.datasource.repos.FilmsRepository
import au.com.ceo.swapichallenge.models.domainmodels.FilmDomainModel
import au.com.ceo.swapichallenge.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FilmsViewModel @Inject constructor(repository: FilmsRepository) : ViewModel() {
    val _films: LiveData<Resource<List<FilmsDBO>>> =
        repository.getFilms()

    var films: LiveData<List<FilmDomainModel>> = _films.switchMap {
        filterWithReleaseDate(it)
    }


    private fun filterWithReleaseDate(films: Resource<List<FilmsDBO>>) : LiveData<List<FilmDomainModel>> {
        val result = MutableLiveData<List<FilmDomainModel>>()

        viewModelScope.launch {
            result.value = films.data?.map {
                it.toDomainModel()
            }?.sortedByDescending {
                it.releaseDate
            }?.toList()
        }

        return result
    }

}