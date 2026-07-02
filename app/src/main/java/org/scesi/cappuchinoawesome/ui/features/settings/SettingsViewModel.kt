package org.scesi.cappuchinoawesome.ui.features.settings

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SettingsViewModel: ViewModel() {
    private val _settingTheme = MutableStateFlow<Boolean>(false)

    private val _settingTypo = MutableStateFlow<Boolean>(false)

    val settingTheme: StateFlow<Boolean> = _settingTheme.asStateFlow()

    val settingTypo: StateFlow<Boolean> = _settingTypo.asStateFlow()

    fun changeTheme(){
        _settingTheme.value = !_settingTheme.value
    }

    fun changeTypo(){
        _settingTypo.value = !_settingTypo.value
    }
}