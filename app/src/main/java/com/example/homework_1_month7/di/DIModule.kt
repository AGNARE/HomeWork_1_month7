package com.example.homework_1_month7.di

import com.example.homework_1_month7.App
import com.example.homework_1_month7.data.database.dao.CountryDao
import com.example.homework_1_month7.data.repositories.CountryRepositoriesImpl
import com.example.homework_1_month7.domain.CountryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DIModule {

    @Provides
    fun provideCountryDao() =
        App.appDatabase.getCountryDao()

    @Provides
    fun provideCountryRepository(countryDao: CountryDao): CountryRepository =
        CountryRepositoriesImpl(countryDao)

}