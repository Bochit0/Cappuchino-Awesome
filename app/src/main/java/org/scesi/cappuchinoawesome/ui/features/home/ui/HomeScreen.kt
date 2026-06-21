package org.scesi.cappuchinoawesome.ui.features.home.ui

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextFieldDefaults
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import org.scesi.cappuchinoawesome.ui.theme.subtitleApp
import org.scesi.cappuchinoawesome.ui.theme.titleApp

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel()){
    Box(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp))
    {
        Home(Modifier.align(Alignment.Center), viewModel)
    }
}
@Composable
fun Home(modifier: Modifier, viewModel: HomeViewModel){
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
            DropDownCarrers()
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
fun DropDownCarrers(modifier: Modifier = Modifier){
    val menuItemData = List(20) { "Option ${it + 1}" }
    Box(){
        LazyColumn(
            modifier = modifier
                .fillMaxWidth()
                .heightIn(max = 400.dp)
        ) {
            items(menuItemData){
                carrera ->
                    CarrerCard(carrerName = carrera)
                    HorizontalLine()
            }
        }
    }
}

@Composable
fun CarrerCard(carrerName: String, modifier: Modifier = Modifier){
    Card(
        modifier = Modifier
            .padding(bottom = 4.dp)
            .height(54.dp),
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