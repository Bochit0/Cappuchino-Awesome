package org.scesi.cappuchinoawesome.ui.features.home.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
    var valueSearch by remember{ mutableStateOf("")}
    var dropList by remember { mutableStateOf(false) }

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleApp()
        Spacer(Modifier.height(20.dp))
        SearchBar(
            valueSearch = valueSearch,
            onValueChange = { newValue ->
                valueSearch = newValue
                dropList = true
            }
        )
        if (dropList) {
            DropDownCarrers()
        }
    }
}

@Composable
fun TitleApp(){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Cappuchino")
        Text("Awesome")
    }
}

@Composable
fun SearchBar(valueSearch: String, onValueChange: (String) -> Unit){
        TextField(
            value = valueSearch,
            onValueChange= onValueChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Buscar Carrera")},
            singleLine = true, //Para que al hacer click sobre el searhbar este no crezca
            maxLines = 1 // Siempre acompaña a singleLine
        )

}

@Composable
fun DropDownCarrers(modifier: Modifier = Modifier){
    val menuItemData = List(20) { "Option ${it + 1}" }
    Box(){
        LazyColumn(
            modifier = modifier
                .fillMaxWidth()
                .heightIn(max = 280.dp)
        ) {
            items(menuItemData){
                carrera ->
                    CarrerCard(carrerName = carrera)
            }
        }
    }
}

@Composable
fun CarrerCard(carrerName: String, modifier: Modifier = Modifier){
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(6.dp)
    ) {
       Text(
           text = carrerName
       )
    }
}

@Composable
fun HorizontalLine(){
    Card(){}
}