package com.example.homework_1_month7.domain.usecases

import com.example.homework_1_month7.domain.CountryRepository
import com.example.homework_1_month7.domain.models.CountryEntity
import javax.inject.Inject

class CreateCountryUseCase @Inject constructor(
    private val countryRepository: CountryRepository
) {
    fun createCountry(countryEntity: CountryEntity) = countryRepository.createCountry(countryEntity)
}