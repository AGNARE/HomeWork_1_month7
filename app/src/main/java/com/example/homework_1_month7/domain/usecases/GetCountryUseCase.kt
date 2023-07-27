package com.example.homework_1_month7.domain.usecases

import com.example.homework_1_month7.domain.CountryRepository
import com.example.homework_1_month7.domain.mappers.mapToContactEntity
import com.example.homework_1_month7.domain.models.CountryEntity

class GetCountryUseCase(
    private val repository: CountryRepository
) {

    fun getCountry(): List<CountryEntity> {
        return repository.getCountry().mapToContactEntity()
    }

}