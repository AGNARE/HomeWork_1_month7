package com.example.homework_1_month7.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework_1_month7.domain.models.CountryEntity
import com.example.homework_1_month7.domain.usecases.CreateCountryUseCase
import com.example.homework_1_month7.domain.usecases.DeleteCountryUseCase
import com.example.homework_1_month7.domain.usecases.GetCountryUseCase
import com.example.homework_1_month7.domain.usecases.UpdateCountryUseCase
import com.example.homework_1_month7.domain.utils.Resource
import com.example.homework_1_month7.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountryViewModel @Inject constructor(

    private val getCountryUseCase: GetCountryUseCase,
    private val createCountryUseCase: CreateCountryUseCase,
    private val updateCountryUseCase: UpdateCountryUseCase,
    private val deleteCountryUseCase: DeleteCountryUseCase

) : ViewModel() {

    private val _getAllCountryStateFlow = MutableStateFlow<UIState<List<CountryEntity>>>(UIState.Empty())
    val getAllCountry: StateFlow<UIState<List<CountryEntity>>> = _getAllCountryStateFlow

    private val _createCountryStateFlow = MutableStateFlow<UIState<CountryEntity>>(UIState.Empty())
    val createAllCountry: StateFlow<UIState<CountryEntity>> = _createCountryStateFlow

    private val _updateCountryStateFlow = MutableStateFlow<UIState<CountryEntity>>(UIState.Empty())
    val updateAllCountry: StateFlow<UIState<CountryEntity>> = _updateCountryStateFlow

    private val _deleteCountryStateFlow = MutableStateFlow<UIState<CountryEntity>>(UIState.Empty())
    val deleteAllCountry: StateFlow<UIState<CountryEntity>> = _deleteCountryStateFlow

    fun getAllCountry() {
        viewModelScope.launch {
            getCountryUseCase.getCountry().collect {
                when (it) {

                    is Resource.Error -> {
                        _getAllCountryStateFlow.value = UIState.Error(it.message ?: "Some error")
                    }
                    is Resource.Loading -> {
                        _getAllCountryStateFlow.value = UIState.Loading()
                    }
                    is Resource.Success -> {
                        if (it.data != null) {
                            _getAllCountryStateFlow.value = UIState.Success(it.data)
                        }
                    }
                }
            }
        }
    }

    fun createAllCountry(countryEntity: CountryEntity) {
        viewModelScope.launch {
            createCountryUseCase.createCountry(countryEntity).collect {
                when (it) {
                    is Resource.Error -> {
                        _createCountryStateFlow.value = UIState.Error(it.message ?: "Some error")
                    }
                    is Resource.Loading -> {
                        _createCountryStateFlow.value = UIState.Loading()
                    }
                    is Resource.Success -> {
                        if (it.data != null) {
                            _createCountryStateFlow.value = UIState.Success(it.data)
                        }
                    }
                }
            }
        }
    }

    fun updateAllCountry(countryEntity: CountryEntity) {
        viewModelScope.launch {
            updateCountryUseCase.updateCountry(countryEntity).collect {
                when (it) {
                    is Resource.Error -> {
                        _updateCountryStateFlow.value = UIState.Error(it.message ?: "Some error")
                    }
                    is Resource.Loading -> {
                        _updateCountryStateFlow.value = UIState.Loading()
                    }
                    is Resource.Success -> {
                        if (it.data != null) {
                            _updateCountryStateFlow.value = UIState.Success(it.data)
                        }
                    }
                }
            }
        }
    }

    fun deleteAllCountry(countryEntity: CountryEntity) {
        viewModelScope.launch {
            deleteCountryUseCase.deleteCountry(countryEntity).collect {
                when (it) {
                    is Resource.Error -> {
                        _deleteCountryStateFlow.value = UIState.Error(it.message ?: "Some error")
                    }
                    is Resource.Loading -> {
                        _deleteCountryStateFlow.value = UIState.Loading()
                    }
                    is Resource.Success -> {
                        if (it.data != null) {
                            _deleteCountryStateFlow.value = UIState.Success(it.data)
                        }
                    }
                }
            }
        }
    }
}