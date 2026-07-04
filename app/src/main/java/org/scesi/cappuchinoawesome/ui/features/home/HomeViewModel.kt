package org.scesi.cappuchinoawesome.ui.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.scesi.cappuchinoawesome.network.ApiService
import org.scesi.cappuchinoawesome.network.RetrofitClient
import org.scesi.cappuchinoawesome.network.data.Career
import org.scesi.cappuchinoawesome.network.data.StatesControl

class HomeViewModel(
    private val apiService: ApiService = RetrofitClient.retrofit
) : ViewModel() {
    private val _careerState = MutableStateFlow<StatesControl<List<Career>>>(StatesControl.Loading)
    private val _isOpen = MutableStateFlow(false)
    val isOpen: StateFlow<Boolean> = _isOpen.asStateFlow()
    val careerState: StateFlow<StatesControl<List<Career>>> = _careerState.asStateFlow()

    init {
        loadCareers()
    }
    fun toggleCareers(){
        _isOpen.value = !_isOpen.value
    }

    fun loadCareers() {
        viewModelScope.launch {
            _careerState.value = StatesControl.Loading
            try {
                val careers = apiService.getCareers()
                _careerState.value = if (careers.isEmpty()) {
                    StatesControl.Empty
                } else {
                   StatesControl.Success(careers)
                }
            } catch (e: Exception) {
                _careerState.value = StatesControl.Error("Sin conexión. UwU")
            }
        }
    }
}