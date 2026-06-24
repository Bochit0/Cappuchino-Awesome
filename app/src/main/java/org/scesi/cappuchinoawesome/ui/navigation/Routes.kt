package org.scesi.cappuchinoawesome.ui.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed class Routes: NavKey {
    @Serializable data object ScreenHome: Routes()
    @Serializable data object ScreenSchedule: Routes()
}
