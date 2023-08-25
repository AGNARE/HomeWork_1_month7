package com.example.homework_1_month7.domain.usecase

import com.example.homework_1_month7.domain.model.Country
import com.example.homework_1_month7.domain.repository.CountryRepository
import javax.inject.Inject

class UpdateCountryUseCase @Inject constructor(
    private val countryRepository: CountryRepository
) {
    fun updateCountry(country: Country) = countryRepository.updateCountry(country)
}