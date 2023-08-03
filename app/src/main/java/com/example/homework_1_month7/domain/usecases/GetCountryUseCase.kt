package com.example.homework_1_month7.domain.usecases

import com.example.homework_1_month7.domain.CountryRepository
import javax.inject.Inject

class GetCountryUseCase @Inject constructor(
    private val repository: CountryRepository
) {
    fun getCountry() = repository.getCountry()
}