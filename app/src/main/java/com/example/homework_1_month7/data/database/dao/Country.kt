package com.example.homework_1_month7.data.database.dao

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("country")
data class Country(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val language: String
)