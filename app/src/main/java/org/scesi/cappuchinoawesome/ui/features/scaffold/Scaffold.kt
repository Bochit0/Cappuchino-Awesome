package org.scesi.cappuchinoawesome.ui.features.scaffold

import androidx.compose.material3.Icon
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import org.scesi.cappuchinoawesome.ui.features.home.ui.HomeViewModel
import org.scesi.cappuchinoawesome.ui.features.settings.SettingsViewModel
import org.scesi.cappuchinoawesome.ui.navigation.NavApp
import org.scesi.cappuchinoawesome.ui.navigation.Routes
import org.scesi.cappuchinoawesome.ui.utils.icons.Icon

@Composable
fun CappuchinoScaffold(
    modifier: Modifier = Modifier,
    backStack: NavBackStack<NavKey>,
    homeViewModel: HomeViewModel,
    settingsViewModel: SettingsViewModel
){
    val currentScreen = backStack.lastOrNull()
    fun navigateTab(target: Routes) {
        backStack.add(Routes.ScreenHome)
        if (target != Routes.ScreenHome) {
            backStack.add(target)
        }
    }

    val navItemColors = NavigationBarItemDefaults.colors(
        selectedIconColor = MaterialTheme.colorScheme.tertiary,
        selectedTextColor = MaterialTheme.colorScheme.tertiary,
        indicatorColor = androidx.compose.ui.graphics.Color.Transparent,
        unselectedIconColor = MaterialTheme.colorScheme.background,
        unselectedTextColor = MaterialTheme.colorScheme.background
    )

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                NavigationBarItem(
                    selected = currentScreen == Routes.AboutMe,
                    onClick = { navigateTab(Routes.AboutMe) },
                    icon = {
                        Icon(
                            imageVector = Icon.stars(),
                            contentDescription = "Sobre mí"
                        )
                    },
                    label = { Text("Sobre mí") },
                    colors = navItemColors
                )

                NavigationBarItem(
                    selected = currentScreen == Routes.ScreenHome,
                    onClick = { navigateTab(Routes.ScreenHome) },
                    icon = {
                        Icon(
                            imageVector = Icon.customWaveBottom(),
                            contentDescription = "Carreras"
                        )
                    },
                    label = { Text("Carreras") },
                    colors = navItemColors
                )

                NavigationBarItem(
                    selected = currentScreen == Routes.Settings,
                    onClick = { navigateTab(Routes.Settings) },
                    icon = {
                        Icon(
                            imageVector = Icon.gear(MaterialTheme.colorScheme.onSecondary),
                            contentDescription = "Settings"
                        )
                    },
                    label = { Text("Configuracion") },
                    colors = navItemColors
                )
            }
        }
    ) { innerPadding ->
        NavApp(
            modifier = Modifier.padding(innerPadding),
            backStack = backStack,
            settingsViewModel = settingsViewModel,
            homeViewModel = homeViewModel
        )
    }
}