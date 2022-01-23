package au.com.ceo.swapichallenge.datasource.repos

import android.util.Log
import au.com.ceo.swapichallenge.database.dao.StarshipDao
import au.com.ceo.swapichallenge.datasource.remote.StarshipRemoteDatasource
import au.com.ceo.swapichallenge.utils.performGetOperation
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class StarshipRepository @Inject constructor() : IStarshipRepository {

    @Inject lateinit var remoteDataSource: StarshipRemoteDatasource
    @Inject lateinit var localDataSource: StarshipDao

   override fun getStarships() = performGetOperation(
        databaseQuery = {
            localDataSource.getStarships()
        },
        networkCall = {
            remoteDataSource.getStarships()
        },
        saveCallResult = {

            localDataSource.insertAll(it.results.map { starship -> kotlin.run { starship.toDBO() } }.toList())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                }, {
                    Log.e("Qeury Error", "Error MEssage")
                })
        }
    )
}