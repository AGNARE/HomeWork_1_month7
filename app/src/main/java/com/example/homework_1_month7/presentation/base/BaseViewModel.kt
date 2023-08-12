package com.example.homework_1_month7.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework_1_month7.domain.utils.Resource
import com.example.homework_1_month7.presentation.utils.UIState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    protected fun <T> Flow<Resource<T>>.collectData(
        _state: MutableStateFlow<UIState<T>>
    ) {
        viewModelScope.launch {
            this@collectData.collect {
                when (it) {
                    is Resource.Error -> {
                        _state.value = UIState.Error(it.message ?: "Some error")
                    }
                    is Resource.Loading -> {
                        _state.value = UIState.Loading()
                    }
                    is Resource.Success -> {
                        if (it.data != null) {
                            _state.value = UIState.Success(it.data)
                        } else {
                            println("You don't have it")
                        }
                    }
                }
            }
        }
    }
}