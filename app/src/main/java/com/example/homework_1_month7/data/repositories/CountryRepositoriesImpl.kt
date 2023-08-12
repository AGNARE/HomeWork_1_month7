package com.example.homework_1_month7.data.repositories

import com.example.homework_1_month7.data.base.BaseRepository
import com.example.homework_1_month7.data.database.dao.Country
import com.example.homework_1_month7.data.database.dao.CountryDao
import com.example.homework_1_month7.domain.CountryRepository
import com.example.homework_1_month7.data.mappers.mapToContactEntity
import com.example.homework_1_month7.domain.models.CountryEntity
import com.example.homework_1_month7.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CountryRepositoriesImpl @Inject constructor(
    private val countryDao: CountryDao
) : CountryRepository, BaseRepository() {

    override fun getCountry(): Flow<Resource<List<CountryEntity>>> = makeRequest {
        countryDao.getCountry().mapToContactEntity()
    }

    override fun createCountry(country: Country): Flow<Resource<Unit>> = makeRequest {
        countryDao.createCountry(country)
    }

    override fun updateCountry(country: Country): Flow<Resource<Unit>> = makeRequest {
        countryDao.updateCountry(country)
    }

    override fun deleteCountry(country: Country): Flow<Resource<Unit>> = makeRequest {
        countryDao.deleteCountry(country)
    }
}