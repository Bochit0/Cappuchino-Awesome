package org.scesi.cappuchinoawesome.ui.features.home.ui
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.scesi.cappuchinoawesome.ui.features.home.data.CareerService
import org.scesi.cappuchinoawesome.ui.network.ApiService
import org.scesi.cappuchinoawesome.ui.network.data.Career
import org.scesi.cappuchinoawesome.ui.network.data.StatesControl

class HomeViewModel : ViewModel() {

    private val careers = CareerService()

    private val _careerState = MutableStateFlow<StatesControl <List <Career>>>(StatesControl.Loading)
    private val _searchText = MutableStateFlow("")
    private val _isOpen = MutableStateFlow(false)

    val searchText : StateFlow<String> = _searchText.asStateFlow()
    val isOpen: StateFlow<Boolean> = _isOpen.asStateFlow()
    val careerState: StateFlow<StatesControl<List <Career>>> = _careerState.asStateFlow()

    init {
        loadCareers()
    }
    fun onChangeTextSearch(textValue: String){
        _searchText.value = textValue
        _isOpen.value = textValue.isNotEmpty()
    }

    fun loadCareers() {
        viewModelScope.launch {
            _careerState.value = StatesControl.Loading
            try {
                val result = careers.getCareers()
                _careerState.value = if (result.isEmpty()) {
                    StatesControl.Empty
                } else {
                   StatesControl.Success(result)
                }
            } catch (e: Exception) {
                _careerState.value = StatesControl.Error("Sin conexión. UwU")
            }
        }
    }
}