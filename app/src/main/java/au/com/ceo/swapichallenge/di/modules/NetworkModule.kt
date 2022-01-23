package au.com.ceo.swapichallenge.di.modules

import au.com.ceo.swapichallenge.network.SwapiService
import au.com.ceo.swapichallenge.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofitInstance() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    //User Information Service
    @Singleton
    @Provides
    fun providesSwapiService(retrofit: Retrofit) : SwapiService = retrofit.create(SwapiService::class.java)

}