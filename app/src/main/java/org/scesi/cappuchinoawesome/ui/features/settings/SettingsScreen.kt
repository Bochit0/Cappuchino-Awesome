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
import androidx.lifecycle.viewmodel.compose.viewModel
import org.scesi.cappuchinoawesome.ui.utils.button.ButtonComponent
import org.scesi.cappuchinoawesome.ui.utils.header.HeaderComponent
import org.scesi.cappuchinoawesome.ui.utils.icons.Icon


@Composable
fun SettingsScreen(
    settingsViewModel: SettingsViewModel,
){
    Box(modifier = Modifier.fillMaxSize()){
        Settings(modifier = Modifier, settingsViewModel)
    }
}

@Composable
fun Settings(
    modifier: Modifier = Modifier,
    settingsViewModel: SettingsViewModel,
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
            titleColor = MaterialTheme.colorScheme.onPrimary,
        )
        Spacer(Modifier.height(120.dp))
        ButtonComponent(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            onClick = {settingsViewModel.changeTheme()},
            isText = "Cambiar color theme",
            backgroundColor = MaterialTheme.colorScheme.primary,
            textColor = MaterialTheme.colorScheme.onPrimary
        )
        Spacer(Modifier.height(60.dp))
        ButtonComponent(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            onClick = { settingsViewModel.changeTypo() },
            isText = "Cambiar tipografia",
            backgroundColor = MaterialTheme.colorScheme.primary,
            textColor = MaterialTheme.colorScheme.onPrimary
        )
    }
}