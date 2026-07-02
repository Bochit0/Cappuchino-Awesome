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
import org.scesi.cappuchinoawesome.ui.features.settings.SettingsViewModel
import org.scesi.cappuchinoawesome.ui.navigation.NavApp
import org.scesi.cappuchinoawesome.ui.theme.CappuchinoawesomeTheme
import org.scesi.cappuchinoawesome.ui.theme.localTypography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val settingsViewModel: SettingsViewModel = viewModel()
            val isDarkTheme by settingsViewModel.settingTheme.collectAsStateWithLifecycle()
            val useAltFont by settingsViewModel.settingTypo.collectAsStateWithLifecycle()

            CompositionLocalProvider(localTypography provides useAltFont) {
                CappuchinoawesomeTheme(darkTheme = isDarkTheme, dynamicColor = false) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        containerColor = MaterialTheme.colorScheme.background
                    )
                    { innerPadding ->
                        NavApp(
                            modifier = Modifier.padding(innerPadding),
                            settingsViewModel = settingsViewModel
                        )
                    }
                }
            }
        }
    }
}
