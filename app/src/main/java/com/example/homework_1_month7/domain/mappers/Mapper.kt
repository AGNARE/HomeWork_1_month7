package com.example.homework_1_month7.domain.mappers

import com.example.homework_1_month7.data.database.dao.Country
import com.example.homework_1_month7.domain.models.CountryEntity

fun List<Country>.mapToContactEntity() = this.map {
    CountryEntity(
        id = it.id,
        name = it.name,
        language = it.language
    )
}