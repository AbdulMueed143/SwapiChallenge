package au.com.ceo.swapichallenge.di.modules

import au.com.ceo.swapichallenge.datasource.repos.FilmsRepository
import au.com.ceo.swapichallenge.datasource.repos.IFilmRepository
import au.com.ceo.swapichallenge.datasource.repos.IStarshipRepository
import au.com.ceo.swapichallenge.datasource.repos.StarshipRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun providesStarshipRepository(implementation: StarshipRepository) : IStarshipRepository

    @Binds
    abstract fun providesFilmRepository(implementation: FilmsRepository) : IFilmRepository

}