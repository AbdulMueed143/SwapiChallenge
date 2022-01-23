package au.com.ceo.swapichallenge.di.modules

import au.com.ceo.swapichallenge.datasource.remote.FilmRemoteDatasource
import au.com.ceo.swapichallenge.datasource.remote.StarshipRemoteDatasource
import au.com.ceo.swapichallenge.network.SwapiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatasourceModule {
    @Singleton
    @Provides
    fun providesStarshipRemoteDatasource(swapiService: SwapiService) : StarshipRemoteDatasource {
        return StarshipRemoteDatasource(swapiService)
    }

    @Singleton
    @Provides
    fun providesFilmRemoteDatasource(swapiService: SwapiService) : FilmRemoteDatasource {
        return FilmRemoteDatasource(swapiService)
    }
}