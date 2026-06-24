package org.scesi.cappuchinoawesome.ui.features.schedule.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.scesi.cappuchinoawesome.ui.utils.button.ButtonComponent
import org.scesi.cappuchinoawesome.ui.utils.header.HeaderComponent
import org.scesi.cappuchinoawesome.ui.utils.icons.Icons

@Composable
fun ScheduleScreen(){
    Box(modifier = Modifier.fillMaxSize()){
        Schedule()
    }
}

@Composable
fun Schedule(modifier: Modifier = Modifier){
    Column(modifier = modifier
        .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.secondary)
                .windowInsetsTopHeight(WindowInsets.statusBars)
        )
        HeaderComponent(
            titleHeader = "MANTECOÑO",
            backgroundColor = MaterialTheme.colorScheme.secondary,
            titleColor = MaterialTheme.colorScheme.background,
            leftAction = {ButtonComponent(
                onClick = {},
                isIcon = Icons.listNested(color = MaterialTheme.colorScheme.secondary),
                backgroundColor = MaterialTheme.colorScheme.secondary,
                textColor = MaterialTheme.colorScheme.background
            )},
            rightAction = { ButtonComponent(
                onClick = {},
                isIcon = Icons.listNested(),
                backgroundColor = MaterialTheme.colorScheme.secondary,
                textColor = MaterialTheme.colorScheme.background
            )}
        )

        TableTime()
    }
}

@Composable
fun TableTime(){}