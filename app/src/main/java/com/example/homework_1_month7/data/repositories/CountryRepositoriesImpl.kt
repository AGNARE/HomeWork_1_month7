package com.example.homework_1_month7.data.repositories

import com.example.homework_1_month7.data.database.dao.Country
import com.example.homework_1_month7.data.database.dao.CountryDao
import com.example.homework_1_month7.domain.CountryRepository

class CountryRepositoriesImpl(
    private val countryDao: CountryDao
): CountryRepository {

    override fun getCountry(): List<Country> {
        countryDao.getCountry()
    }

    override fun createCountry(country: Country) {
        countryDao.createCountry()
    }

    override fun updateCountry(country: Country) {
        countryDao.updateCountry()
    }

    override fun deleteCountry(country: Country) {
        countryDao.deleteCountry()
    }
}