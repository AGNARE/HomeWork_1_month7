package com.example.homework_1_month7.presentation

import com.example.homework_1_month7.data.database.dao.Country
import com.example.homework_1_month7.domain.models.CountryEntity
import com.example.homework_1_month7.domain.usecases.CreateCountryUseCase
import com.example.homework_1_month7.domain.usecases.DeleteCountryUseCase
import com.example.homework_1_month7.domain.usecases.GetCountryUseCase
import com.example.homework_1_month7.domain.usecases.UpdateCountryUseCase
import com.example.homework_1_month7.presentation.base.BaseViewModel
import com.example.homework_1_month7.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class CountryViewModel @Inject constructor(

    private val getCountryUseCase: GetCountryUseCase,
    private val createCountryUseCase: CreateCountryUseCase,
    private val updateCountryUseCase: UpdateCountryUseCase,
    private val deleteCountryUseCase: DeleteCountryUseCase

) : BaseViewModel() {

    private val _getAllCountryStateFlow =
        MutableStateFlow<UIState<List<CountryEntity>>>(UIState.Empty())
    val getAllCountry: StateFlow<UIState<List<CountryEntity>>> = _getAllCountryStateFlow

    private val _createCountryStateFlow = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val createAllCountry: StateFlow<UIState<Unit>> = _createCountryStateFlow

    private val _updateCountryStateFlow = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val updateAllCountry: StateFlow<UIState<Unit>> = _updateCountryStateFlow

    private val _deleteCountryStateFlow = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val deleteAllCountry: StateFlow<UIState<Unit>> = _deleteCountryStateFlow

    fun getAllCountry() {
        getCountryUseCase.getCountry().collectData(_getAllCountryStateFlow)
    }

    fun createAllCountry(country: Country) {
        createCountryUseCase.createCountry(country).collectData(_createCountryStateFlow)
    }

    fun updateAllCountry(country: Country) {
        updateCountryUseCase.updateCountry(country).collectData(_updateCountryStateFlow)
    }

    fun deleteAllCountry(country: Country) {
        deleteCountryUseCase.deleteCountry(country).collectData(_deleteCountryStateFlow)
    }

}