package com.soulsensei.app.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soulsensei.app.data.model.ApiResponse
import com.soulsensei.app.data.remote.RetrofitClient.api
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _data = MutableStateFlow<ApiResponse?>(null)
    val data = _data.asStateFlow()

    fun fetchData() {
        viewModelScope.launch {
            try {
                val response = api.getAssignment()
                if (response.isSuccessful) {
                    _data.value = response.body()
                }
            } catch (e: Exception) {
                Log.e("API_ERROR", e.message ?: "Error")
            }
        }
    }
}



