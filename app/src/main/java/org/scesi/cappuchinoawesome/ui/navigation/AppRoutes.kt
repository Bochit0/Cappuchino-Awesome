package org.scesi.cappuchinoawesome.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import org.scesi.cappuchinoawesome.ui.features.aboutme.AboutMeScreen
import org.scesi.cappuchinoawesome.ui.features.home.HomeScreen
import org.scesi.cappuchinoawesome.ui.features.home.HomeViewModel
import org.scesi.cappuchinoawesome.ui.features.schedule.ScheduleScreen
import org.scesi.cappuchinoawesome.ui.features.settings.SettingsScreen
import org.scesi.cappuchinoawesome.ui.features.settings.SettingsViewModel

@Composable
fun NavApp(
    modifier: Modifier = Modifier,
    backStack: NavBackStack<NavKey>,
    homeViewModel: HomeViewModel,
    settingsViewModel: SettingsViewModel
){
    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull()},
        entryProvider = entryProvider {
            entry<Routes.ScreenHome> {
                HomeScreen(
                    modifier = modifier,
                    onNavigate = { route -> backStack.add(route) },
                    viewModel = homeViewModel
                )
            }
            entry<Routes.ScreenSchedule> { route ->
                ScheduleScreen(
                    modifier = modifier,
                    careerCode = route.careerCode,
                )
            }
            entry<Routes.AboutMe> {
                AboutMeScreen( modifier = modifier)
            }
            entry<Routes.Settings> {
                SettingsScreen (
                    modifier = modifier,
                    settingsViewModel = settingsViewModel
                )
            }
        }
    )
}