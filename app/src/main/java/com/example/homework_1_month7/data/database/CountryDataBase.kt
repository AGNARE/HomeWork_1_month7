package com.example.homework_1_month7.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.homework_1_month7.data.database.dao.Country
import com.example.homework_1_month7.data.database.dao.CountryDao

@Database(entities = [Country::class], version = 1)
abstract class CountryDataBase : RoomDatabase() {
    abstract fun getCountryDao(): CountryDao
}