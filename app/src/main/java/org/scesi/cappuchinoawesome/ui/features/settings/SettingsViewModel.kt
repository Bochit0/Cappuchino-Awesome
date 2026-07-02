package org.scesi.cappuchinoawesome.ui.features.settings

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SettingsViewModel: ViewModel() {
    private val _settingTheme = MutableStateFlow<Boolean>(false)

    val settingTheme: StateFlow<Boolean> = _settingTheme.asStateFlow()

    fun changeTheme(){
        _settingTheme.value = !_settingTheme.value
    }
}