package com.example.homework_1_month7.domain.usecase

import com.example.homework_1_month7.domain.model.Country
import com.example.homework_1_month7.domain.repository.CountryRepository
import javax.inject.Inject

class DeleteCountryUseCase @Inject constructor(
    private val countryRepository: CountryRepository
) {
    fun deleteCountry(country: Country) = countryRepository.deleteCountry(country)
}