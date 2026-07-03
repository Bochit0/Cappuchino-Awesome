package org.scesi.cappuchinoawesome

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.rememberNavBackStack
import org.scesi.cappuchinoawesome.ui.features.home.ui.HomeViewModel
import org.scesi.cappuchinoawesome.ui.features.scaffold.CappuchinoScaffold
import org.scesi.cappuchinoawesome.ui.features.settings.SettingsViewModel
import org.scesi.cappuchinoawesome.ui.navigation.NavApp
import org.scesi.cappuchinoawesome.ui.navigation.Routes
import org.scesi.cappuchinoawesome.ui.theme.CappuchinoawesomeTheme
import org.scesi.cappuchinoawesome.ui.theme.localTypography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val settingsViewModel: SettingsViewModel = viewModel()
            val homeViewModel: HomeViewModel = viewModel()
            val isDarkTheme by settingsViewModel.settingTheme.collectAsStateWithLifecycle()
            val useAltFont by settingsViewModel.settingTypo.collectAsStateWithLifecycle()
            val backStack = rememberNavBackStack(Routes.ScreenHome)

            CompositionLocalProvider(localTypography provides useAltFont) {
                CappuchinoawesomeTheme(darkTheme = isDarkTheme, dynamicColor = false) {
                    CappuchinoScaffold(
                        backStack = backStack,
                        homeViewModel = homeViewModel,
                        settingsViewModel = settingsViewModel
                    )
                }
            }
        }
    }
}
