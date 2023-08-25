package com.example.homework_1_month7.data.mapper

import com.example.homework_1_month7.domain.model.Country


fun List<Country>.mapToContactEntity() = this.map {
    Country(
        id = it.id,
        name = it.name,
        language = it.language
    )
}