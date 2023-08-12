package com.example.homework_1_month7.domain

import com.example.homework_1_month7.data.database.dao.Country
import com.example.homework_1_month7.domain.models.CountryEntity
import com.example.homework_1_month7.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface CountryRepository {

    fun getCountry(): Flow<Resource<List<CountryEntity>>>

    fun createCountry(country: Country): Flow<Resource<Unit>>

    fun updateCountry(country: Country): Flow<Resource<Unit>>

    fun deleteCountry(country: Country): Flow<Resource<Unit>>
}