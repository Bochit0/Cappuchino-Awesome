package org.scesi.cappuchinoawesome.ui.features.home.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun HomeScreen(modifier: Modifier = Modifier){
    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp))
    {
        Home(Modifier.align(Alignment.Center))
    }
}
@Composable
fun Home(modifier: Modifier){
    Column(modifier = modifier) {
        TitleApp()
        Spacer(Modifier.padding(20.dp))
        SearchBar()
    }
}

@Composable
fun TitleApp(){
    Row() {
        Text("Cappuchino")
    }
    Row() {
        Text("Awesome")
    }
}
@Preview
@Composable
fun SearchBar(){
    var textState by remember { mutableStateOf("") }
    TextField(
        value = "",
        onValueChange= { newValue ->
            textState = newValue
        },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Buscar Carrera")},
        singleLine = true, //Para que al hacer click sobre el searhbar este no crezca
        maxLines = 1 // Siempre acompaña a singleLine
    )
}

