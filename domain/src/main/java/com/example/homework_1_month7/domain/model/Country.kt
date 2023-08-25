package com.example.homework_1_month7.domain.model

import java.io.Serializable

data class Country(
    val id: Int,
    val name: String? = null,
    val language: String? = null,
) : Serializable
