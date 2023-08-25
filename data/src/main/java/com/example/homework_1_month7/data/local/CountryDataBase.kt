package com.example.homework_1_month7.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.homework_1_month7.domain.model.Country

@Database(entities = [Country::class], version = 1)
abstract class CountryDataBase : RoomDatabase() {
    abstract fun getCountryDao(): CountryDao
}