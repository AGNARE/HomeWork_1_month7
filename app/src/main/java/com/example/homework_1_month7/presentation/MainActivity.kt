package com.example.homework_1_month7.presentation

import android.os.Bundle
import androidx.activity.viewModels
import com.example.homework_1_month7.data.database.dao.Country
import com.example.homework_1_month7.databinding.ActivityMainBinding
import com.example.homework_1_month7.presentation.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private val viewModel by viewModels<CountryViewModel>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getCountry()
        val country = Country(1, "first", "second")
        createCountry(country)
        updateCountry(country)
        deleteCountry(country)
    }

    private fun getCountry() {
        viewModel.getAllCountry()
        viewModel.getAllCountry.collectInfo(
            emptyState = {
                println("DATA IS EMPTY")
            },
            errorState = {
                println("SOME ERROR: $it")
            },
            loadingState = {
                println("SHOW PROGRESS BAR")
            },
            successState = {
                println("SET LIST ADAPTER: $it")
            }
        )
    }

    private fun createCountry(country: Country) {
        viewModel.createAllCountry(country)
        viewModel.createAllCountry.collectInfo(
            emptyState = {
                println("DATA IS EMPTY")
            },
            errorState = {
                println("SOME ERROR: $it")
            },
            loadingState = {
                println("SHOW PROGRESS BAR")
            },
            successState = {
                println("SET LIST ADAPTER: $it")
            }
        )
    }

    private fun updateCountry(country: Country) {
        viewModel.updateAllCountry(country)
        viewModel.updateAllCountry.collectInfo(
            emptyState = {
                println("DATA IS EMPTY")
            },
            errorState = {
                println("SOME ERROR: $it")
            },
            loadingState = {
                println("SHOW PROGRESS BAR")
            },
            successState = {
                println("SET LIST ADAPTER: $it")
            }
        )
    }

    private fun deleteCountry(country: Country) {
        viewModel.deleteAllCountry(country)
        viewModel.deleteAllCountry.collectInfo(
            emptyState = {
                println("DATA IS EMPTY")
            },
            errorState = {
                println("SOME ERROR: $it")
            },
            loadingState = {
                println("SHOW PROGRESS BAR")
            },
            successState = {
                println("SET LIST ADAPTER: $it")
            }
        )
    }
}