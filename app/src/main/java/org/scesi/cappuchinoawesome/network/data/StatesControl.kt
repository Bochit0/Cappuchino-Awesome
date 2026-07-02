package org.scesi.cappuchinoawesome.network.data

sealed class StatesControl<out T> {
    data object Loading : StatesControl<Nothing>()
    data class Success<T>(val data: T) : StatesControl<T>()
    data object Empty : StatesControl<Nothing>()
    data class Error(val message: String) : StatesControl<Nothing>()
}