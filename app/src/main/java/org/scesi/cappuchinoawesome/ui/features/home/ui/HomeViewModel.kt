package org.scesi.cappuchinoawesome.ui.features.home.ui
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel : ViewModel() {
    private val _searchText = MutableStateFlow("")
    private val _isOpen = MutableStateFlow(false)

    val searchText : StateFlow<String> = _searchText.asStateFlow()
    val isOpen: StateFlow<Boolean> = _isOpen.asStateFlow()

    fun onChangeTextSearch(textValue: String){
        _searchText.value = textValue
        _isOpen.value = textValue.isNotEmpty()
    }
}