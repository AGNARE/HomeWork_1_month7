package com.example.homework_1_month7.domain.usecases

import com.example.homework_1_month7.domain.CountryRepository
import com.example.homework_1_month7.domain.models.CountryEntity
import javax.inject.Inject

class DeleteCountryUseCase @Inject constructor(
    private val countryRepository: CountryRepository
) {
    fun deleteCountry(countryEntity: CountryEntity) = countryRepository.deleteCountry(countryEntity)
}