package org.scesi.cappuchinoawesome.ui.network.data

sealed class StatesControl {
    data object Loading : StatesControl()
    data class Success(val carreers: List<Career>) : StatesControl()
    data object Empty : StatesControl()
    data class Error(val message: String) : StatesControl()
}