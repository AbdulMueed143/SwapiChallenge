package au.com.ceo.swapichallenge.di.modules

import android.content.Context
import au.com.ceo.swapichallenge.database.SwapiDatabase
import au.com.ceo.swapichallenge.database.dao.FilmsDao
import au.com.ceo.swapichallenge.database.dao.StarshipDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun providesAppDatabase(@ApplicationContext context: Context) : SwapiDatabase {
        return SwapiDatabase.getInstance(context)
    }

    @Provides
    fun providesFilmDao(swapiDatabase: SwapiDatabase) : FilmsDao {
        return swapiDatabase.filmsDao()
    }

    @Provides
    fun providesStarshipDao(swapiDatabase: SwapiDatabase) : StarshipDao {
        return swapiDatabase.starshipDao()
    }
}