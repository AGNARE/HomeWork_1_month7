package com.example.homework_1_month7.domain.usecases

import com.example.homework_1_month7.data.database.dao.Country
import com.example.homework_1_month7.domain.CountryRepository
import javax.inject.Inject

class CreateCountryUseCase @Inject constructor(
    private val countryRepository: CountryRepository
) {
    fun createCountry(country: Country) = countryRepository.createCountry(country)
}