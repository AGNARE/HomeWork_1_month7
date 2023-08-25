package com.example.homework_1_month7.domain.repository

import com.example.homework_1_month7.domain.model.Country
import com.example.homework_1_month7.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface CountryRepository {

    fun getCountry(): Flow<Resource<List<Country>>>

    fun createCountry(country: Country): Flow<Resource<Unit>>

    fun updateCountry(country: Country): Flow<Resource<Unit>>

    fun deleteCountry(country: Country): Flow<Resource<Unit>>

}