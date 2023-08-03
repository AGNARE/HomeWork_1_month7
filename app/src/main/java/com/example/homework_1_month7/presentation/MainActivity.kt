package com.example.homework_1_month7.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.homework_1_month7.databinding.ActivityMainBinding
import com.example.homework_1_month7.domain.models.CountryEntity
import com.example.homework_1_month7.presentation.utils.UIState
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<CountryViewModel>()
    private lateinit var binding: ActivityMainBinding
    private lateinit var countryEntity : CountryEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getCountry()
        createCountry()
        updateCountry()
        deleteCountry()
    }

    private fun getCountry() {
        viewModel.getAllCountry()
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getAllCountry.collect {
                    when (it) {
                        is UIState.Empty -> {}
                        is UIState.Error -> {
                            Toast.makeText(this@MainActivity, it.message, Toast.LENGTH_SHORT).show()
                        }
                        is UIState.Loading -> {
                            println("Show progress bar")
                        }
                        is UIState.Success -> {
                            println("Show data in recycler view")
                        }
                    }
                }
            }
        }
    }

    private fun createCountry() {
        viewModel.createAllCountry(countryEntity)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.createAllCountry.collect {
                    when (it) {
                        is UIState.Empty -> {}
                        is UIState.Error -> {
                            Toast.makeText(this@MainActivity, it.message, Toast.LENGTH_SHORT).show()
                        }
                        is UIState.Loading -> {
                            println("Show progress bar")
                        }
                        is UIState.Success -> {
                            println("Show data in recycler view")
                        }
                    }
                }
            }
        }
    }

    private fun updateCountry() {
        viewModel.updateAllCountry(countryEntity)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.updateAllCountry.collect {
                    when (it) {
                        is UIState.Empty -> {}
                        is UIState.Error -> {
                            Toast.makeText(this@MainActivity, it.message, Toast.LENGTH_SHORT).show()
                        }
                        is UIState.Loading -> {
                            println("Show progress bar")
                        }
                        is UIState.Success -> {
                            println("Show data in recycler view")
                        }
                    }
                }
            }
        }
    }

    private fun deleteCountry() {
        viewModel.deleteAllCountry(countryEntity)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.deleteAllCountry.collect {
                    when (it) {
                        is UIState.Empty -> {}
                        is UIState.Error -> {
                            Toast.makeText(this@MainActivity, it.message, Toast.LENGTH_SHORT).show()
                        }
                        is UIState.Loading -> {
                            println("Show progress bar")
                        }
                        is UIState.Success -> {
                            println("Show data in recycler view")
                        }
                    }
                }
            }
        }
    }
}