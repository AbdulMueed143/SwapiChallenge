package au.com.ceo.swapichallenge.datasource.repos

import android.util.Log
import au.com.ceo.swapichallenge.database.dao.FilmsDao
import au.com.ceo.swapichallenge.datasource.remote.FilmRemoteDatasource
import au.com.ceo.swapichallenge.utils.performGetOperation
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class FilmsRepository @Inject constructor(
    private val localDataSource: FilmsDao,
    private val remoteDataSource : FilmRemoteDatasource
) : IFilmRepository {

    override fun getFilms() = performGetOperation(
        databaseQuery = {
            localDataSource.getFilms()
        },
        networkCall =
        {
            remoteDataSource.getFilms()
        },
        saveCallResult =
        {
            localDataSource.insertAll(it.results.map { film -> kotlin.run { film.toDBO() }  }.toList())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                }, {
                    Log.e("Qeury Error", "Error MEssage")
                })
        }
    )
}