package com.example.homework_1_month7.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.homework_1_month7.domain.model.Country

@Dao
interface CountryDao {

    @Query("SELECT * FROM country")
    suspend fun getCountry(): List<Country>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createCountry(country: Country)

    @Update
    suspend fun updateCountry(country: Country)

    @Delete
    suspend fun deleteCountry(country: Country)

}