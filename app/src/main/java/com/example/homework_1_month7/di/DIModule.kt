package com.example.homework_1_month7.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.homework_1_month7.data.database.CountryDataBase
import com.example.homework_1_month7.data.database.dao.CountryDao
import com.example.homework_1_month7.data.repositories.CountryRepositoriesImpl
import com.example.homework_1_month7.domain.CountryRepository
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
    fun provideRoomDataBase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        RoomDatabase::class.java,
        "country"
    ).build()

    @Provides
    fun provideCountryDao(countryDataBase: CountryDataBase) =
        countryDataBase.getCountryDao()

    @Provides
    fun provideCountryRepository(countryDao: CountryDao): CountryRepository =
        CountryRepositoriesImpl(countryDao)

}