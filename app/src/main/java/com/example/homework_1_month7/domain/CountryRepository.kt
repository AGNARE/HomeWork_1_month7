package com.example.homework_1_month7.domain

import com.example.homework_1_month7.data.database.dao.Country

interface CountryRepository {

    fun getCountry(): List<Country>

    fun createCountry(country: Country)

    fun updateCountry(country: Country)

    fun deleteCountry(country: Country)
}