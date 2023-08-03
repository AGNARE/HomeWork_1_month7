package com.example.homework_1_month7.domain.usecases

import com.example.homework_1_month7.domain.CountryRepository
import com.example.homework_1_month7.domain.models.CountryEntity
import javax.inject.Inject

class UpdateCountryUseCase @Inject constructor(
    private val countryRepository: CountryRepository
) {
    fun updateCountry(countryEntity: CountryEntity) = countryRepository.updateCountry(countryEntity)
}