package com.example.homework_1_month7.domain.usecase

import com.example.homework_1_month7.domain.repository.CountryRepository
import javax.inject.Inject

class GetCountryUseCase @Inject constructor(
    private val repository: CountryRepository
) {
    fun getCountry() = repository.getCountry()
}