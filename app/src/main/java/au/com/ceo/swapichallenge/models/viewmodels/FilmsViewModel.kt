package au.com.ceo.swapichallenge.models.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import au.com.ceo.swapichallenge.database.dbo.FilmsDBO
import au.com.ceo.swapichallenge.datasource.repos.FilmsRepository
import au.com.ceo.swapichallenge.models.domainmodels.FilmDomainModel
import au.com.ceo.swapichallenge.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FilmsViewModel @Inject constructor(repository: FilmsRepository) : ViewModel() {
    val _films: LiveData<Resource<List<FilmsDBO>>> =
        repository.getFilms()

    var films: List<FilmDomainModel>? = null

}