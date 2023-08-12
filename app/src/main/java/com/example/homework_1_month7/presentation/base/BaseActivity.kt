package com.example.homework_1_month7.presentation.base

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.homework_1_month7.presentation.utils.UIState
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class BaseActivity : AppCompatActivity() {

    protected fun <T> StateFlow<UIState<T>>.collectInfo(
        loadingState: (UIState<T>) -> Unit,
        successState: (data: T) -> Unit,
        emptyState: (message: String) -> Unit,
        errorState: (message: String) -> Unit
    ) {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                this@collectInfo.collect {
                    when (it) {
                        is UIState.Empty -> {
                            emptyState.invoke("Data is empty")
                        }
                        is UIState.Error -> {
                            errorState.invoke(it.message)
                        }
                        is UIState.Loading -> {
                            loadingState.invoke(UIState.Loading())
                        }
                        is UIState.Success -> {
                            successState.invoke(it.data!!)
                        }
                    }
                }
            }
        }
    }
}