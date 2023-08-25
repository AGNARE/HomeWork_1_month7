package com.example.homework_1_month7.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity("country")
data class Country(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String?,
    val language: String?
) : Serializable