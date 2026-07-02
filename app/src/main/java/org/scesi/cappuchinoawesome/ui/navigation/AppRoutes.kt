package org.scesi.cappuchinoawesome.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import org.scesi.cappuchinoawesome.ui.features.aboutme.AboutMeScreen
import org.scesi.cappuchinoawesome.ui.features.home.ui.HomeScreen
import org.scesi.cappuchinoawesome.ui.features.schedule.ui.ScheduleScreen

@Composable
fun NavApp(modifier: Modifier = Modifier){
    val backStack = rememberNavBackStack(Routes.ScreenHome)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull()},
        entryProvider = entryProvider {
            entry<Routes.ScreenHome> {
                HomeScreen(modifier = modifier, onNavigate = { route -> backStack.add(route)})
            }
            entry<Routes.ScreenSchedule> { route ->
                ScheduleScreen(
                    careerCode = route.careerCode,
                    onBackClick = { backStack.removeLastOrNull() },
                    onNavigate = { route -> backStack.add(route)}
                )
            }
            entry<Routes.AboutMe> {
                AboutMeScreen(
                    onBackClick = { backStack.removeLastOrNull() }
                )
            }
        }
    )
}