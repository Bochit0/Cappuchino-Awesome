package org.scesi.cappuchinoawesome.ui.features.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.scesi.cappuchinoawesome.ui.utils.button.ButtonComponent
import org.scesi.cappuchinoawesome.ui.utils.header.HeaderComponent
import org.scesi.cappuchinoawesome.ui.utils.icons.Icon


@Composable
fun SettingsScreen(
    settingsViewModel: SettingsViewModel,
    onBackClick: () -> Unit){
    Box(modifier = Modifier.fillMaxSize()){
        Settings(modifier = Modifier, settingsViewModel, onBackClick)
    }
}

@Composable
fun Settings(
    modifier: Modifier = Modifier,
    settingsViewModel: SettingsViewModel,
    onBackClick: () -> Unit
){
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary)
                .windowInsetsTopHeight(WindowInsets.statusBars)
        )
        HeaderComponent(
            titleHeader = "Configuraciones",
            backgroundColor = MaterialTheme.colorScheme.primary,
            titleColor = MaterialTheme.colorScheme.tertiary,
            leftAction = { ButtonComponent(
                onClick = {onBackClick()},
                isIcon = Icon.boxArrowLeft(MaterialTheme.colorScheme.outline),
                backgroundColor = MaterialTheme.colorScheme.primary,
                textColor = MaterialTheme.colorScheme.tertiary
            )}
        )
        Spacer(Modifier.height(120.dp))
        ButtonComponent(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            onClick = {settingsViewModel.changeTheme()},
            isText = "Cambiar color theme",
            backgroundColor = MaterialTheme.colorScheme.primary,
            textColor = MaterialTheme.colorScheme.tertiary
        )
        Spacer(Modifier.height(60.dp))
        ButtonComponent(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            onClick = {},
            isText = "Cambiar tipografia",
            backgroundColor = MaterialTheme.colorScheme.primary,
            textColor = MaterialTheme.colorScheme.tertiary
        )
    }
}