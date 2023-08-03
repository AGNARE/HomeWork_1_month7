package com.example.homework_1_month7.domain

import com.example.homework_1_month7.domain.models.CountryEntity
import com.example.homework_1_month7.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface CountryRepository {

    fun getCountry(): Flow<Resource<List<CountryEntity>>>

    fun createCountry(countryEntity: CountryEntity): Flow<Resource<CountryEntity>>

    fun updateCountry(countryEntity: CountryEntity): Flow<Resource<CountryEntity>>

    fun deleteCountry(countryEntity: CountryEntity): Flow<Resource<CountryEntity>>
}