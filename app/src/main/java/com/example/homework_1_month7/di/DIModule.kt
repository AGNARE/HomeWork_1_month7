package com.example.homework_1_month7.di

import android.content.Context
import androidx.room.Room
import com.example.homework_1_month7.data.local.CountryDao
import com.example.homework_1_month7.data.local.CountryDataBase
import com.example.homework_1_month7.data.repository.CountryRepositoriesImpl
import com.example.homework_1_month7.domain.repository.CountryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DIModule {

    @Singleton
    @Provides
    fun provideCountryDatabase(
        @ApplicationContext context: Context
    ): com.example.homework_1_month7.data.local.CountryDataBase = Room.databaseBuilder(
        context,
        com.example.homework_1_month7.data.local.CountryDataBase::class.java,
        "note_db"
    ).build()

    @Singleton
    @Provides
    fun provideCountryDao(countryDataBase: CountryDataBase) = countryDataBase.getCountryDao()

    @Singleton
    @Provides
    fun provideCountryRepository(countryDao: CountryDao): CountryRepository =
        CountryRepositoriesImpl(countryDao)

}