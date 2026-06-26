package org.scesi.cappuchinoawesome.ui.features.home.ui

import org.scesi.cappuchinoawesome.ui.utils.dropdown.DropDownComponent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextFieldDefaults
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import org.scesi.cappuchinoawesome.ui.navigation.Routes
import org.scesi.cappuchinoawesome.ui.theme.subtitleApp
import org.scesi.cappuchinoawesome.ui.theme.titleApp

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(),
    onNavigate: (Routes) -> Unit
){
    Box(
        modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp))
    {
        Home(
            modifier = modifier.align(Alignment.Center),
            viewModel = viewModel,
            onNavigate = onNavigate
        )
    }
}

@Composable
fun Home(
    modifier: Modifier,
    viewModel: HomeViewModel,
    onNavigate: (Routes) -> Unit
){
    val valueSearch by viewModel.searchText.collectAsStateWithLifecycle()
    val dropList by viewModel.isOpen.collectAsStateWithLifecycle()

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleApp()
        Spacer(Modifier.height(20.dp))
        SearchBar(
            valueSearch = valueSearch,
            onValueChange = { newValue ->
                viewModel.onChangeTextSearch(newValue)
            }
        )
        Spacer(Modifier.height(5.dp))
        if (dropList) {
            DropDownCarrers(onNavigate = onNavigate)
        }
    }
}

@Composable
fun TitleApp(){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Cappuchino",
            color = MaterialTheme.colorScheme.tertiary,
            style = MaterialTheme.typography.titleApp)
        Text(
            text = "Awesome",
            color = MaterialTheme.colorScheme.secondary,
            style = MaterialTheme.typography.subtitleApp)
    }
}

@Composable
fun SearchBar(valueSearch: String, onValueChange: (String) -> Unit){
        TextField(
            value = valueSearch,
            onValueChange= onValueChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(text = "Buscar Carrera",
                     color = MaterialTheme.colorScheme.primary)},
            singleLine = true,
            maxLines = 1,
            colors = TextFieldDefaults.colors(
                focusedTextColor = MaterialTheme.colorScheme.primary,
                focusedIndicatorColor = MaterialTheme.colorScheme.secondary,
                unfocusedIndicatorColor = MaterialTheme.colorScheme.secondary.copy(alpha = 0.5f),
                disabledIndicatorColor = MaterialTheme.colorScheme.primary
            )
        )

}

@Composable
fun DropDownCarrers(modifier: Modifier = Modifier, onNavigate: (Routes) -> Unit){
    val menuItemData = List(20) { "Option ${it + 1}" }
    DropDownComponent(
        items = menuItemData,
        itemDivider = { HorizontalLine() },
        itemContent = { index ->
            CarrerCard(
                carrerName = index,
                onClick = {onNavigate(Routes.ScreenSchedule)}
            )
        }
    )
}

@Composable
fun CarrerCard(
    carrerName: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier){
    Card(
        modifier = modifier
            .padding(bottom = 4.dp)
            .height(54.dp),
        onClick = onClick,
        shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondary,
            contentColor = MaterialTheme.colorScheme.background
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = carrerName,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Composable
fun HorizontalLine(modifier : Modifier = Modifier){
    HorizontalDivider(
        modifier = modifier.padding(vertical = 8.dp),
        thickness = 3.dp,
        color = MaterialTheme.colorScheme.tertiary
    )
}