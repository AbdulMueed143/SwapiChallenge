package au.com.ceo.swapichallenge.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import au.com.ceo.swapichallenge.database.dao.FilmsDao
import au.com.ceo.swapichallenge.database.dao.StarshipDao
import au.com.ceo.swapichallenge.database.dbo.FilmsDBO
import au.com.ceo.swapichallenge.database.dbo.StarshipDBO
import au.com.ceo.swapichallenge.utils.Constants

@Database(entities = [FilmsDBO::class, StarshipDBO::class], version = Constants.DATABASE_VERSION)
abstract class SwapiDatabase : RoomDatabase() {

    abstract fun filmsDao() : FilmsDao
    abstract fun starshipDao() : StarshipDao

    companion object {

        private var instance : SwapiDatabase? = null

        fun getInstance(context: Context) : SwapiDatabase {

            if (instance == null) {
                synchronized(SwapiDatabase::class) {
                    instance = Room.databaseBuilder(context.applicationContext, SwapiDatabase::class.java, Constants.DATABASE_NAME)
                        .fallbackToDestructiveMigration().build()
                }
            }

            return instance!!
        }
    }
}