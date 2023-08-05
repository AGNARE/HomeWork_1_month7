package com.example.homework_1_month7

import android.app.Application
import androidx.room.Room
import com.example.homework_1_month7.data.database.CountryDataBase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {

    companion object {
        lateinit var appDatabase: CountryDataBase
    }

    override fun onCreate() {
        super.onCreate()
        appDatabase =
            Room.databaseBuilder(applicationContext, CountryDataBase::class.java, "country")
                .allowMainThreadQueries().build()
    }

}