package org.scesi.cappuchinoawesome.ui.features.home.ui

import androidx.compose.foundation.Image
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.layout.ContentScale
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import org.scesi.cappuchinoawesome.ui.navigation.Routes
import org.scesi.cappuchinoawesome.network.data.Career
import org.scesi.cappuchinoawesome.network.data.StatesControl
import org.scesi.cappuchinoawesome.ui.theme.subtitle
import org.scesi.cappuchinoawesome.ui.theme.subtitleApp
import org.scesi.cappuchinoawesome.ui.theme.title
import org.scesi.cappuchinoawesome.ui.theme.titleApp
import org.scesi.cappuchinoawesome.ui.utils.button.ButtonComponent
import org.scesi.cappuchinoawesome.ui.utils.icons.Icon
import org.scesi.cappuchinoawesome.ui.utils.icons.Icon.customWaveBottom

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

        ButtonComponent(
            onClick = { onNavigate(Routes.Settings) },
            isIcon = Icon.gear(MaterialTheme.colorScheme.outline),
            backgroundColor = MaterialTheme.colorScheme.primary,
            textColor = MaterialTheme.colorScheme.tertiary,
            modifier = Modifier
                .align(Alignment.TopEnd)
        )
    }
}

@Composable
fun Home(
    modifier: Modifier,
    viewModel: HomeViewModel,
    onNavigate: (Routes) -> Unit
){
    val dropList by viewModel.isOpen.collectAsStateWithLifecycle()
    val stateCareers by viewModel.careerState.collectAsStateWithLifecycle()

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TitleApp()
        Spacer(Modifier.height(30.dp))
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    imageVector = customWaveBottom(color = MaterialTheme.colorScheme.primary),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .offset(y = 10.dp),
                    contentScale = ContentScale.FillBounds
                )
                CareerSelectButton(
                    onClick = { viewModel.toggleCareers() }
                )
                Spacer(Modifier.height(5.dp))
                if (dropList) {
                    DropDownCareers(
                        modifier = modifier,
                        onNavigate = onNavigate,
                        stateCareer = stateCareers
                    )
                }
            }
        }
    }
}

@Composable
fun TitleApp(){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Cappuchino",
            color = MaterialTheme.colorScheme.outline,
            style = MaterialTheme.typography.titleApp)
        Text(
            text = "Awesome",
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.subtitleApp)
    }
}

@Composable
fun CareerSelectButton(
    onClick: () -> Unit
){
    ButtonComponent(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        isText =  "Ver Carreras" ,
        backgroundColor = MaterialTheme.colorScheme.primary,
        textColor = MaterialTheme.colorScheme.tertiary
    )

}

@Composable
fun DropDownCareers(
    modifier: Modifier = Modifier,
    onNavigate: (Routes) -> Unit,
    stateCareer: StatesControl<List<Career>>
){
    when(stateCareer){
        is StatesControl.Loading -> {
            Box(
                modifier = Modifier.fillMaxWidth().padding(24.dp),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(color = MaterialTheme.colorScheme.tertiary)
            }
        }

        is StatesControl.Success<List<Career>> -> {
            CareerList(
                careers = stateCareer.data,
                onNavigate = onNavigate
            )
        }

        is StatesControl.Empty -> {
            Box(
                modifier = Modifier.fillMaxWidth().padding(24.dp),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "No hay carreras disponibles",
                    style = MaterialTheme.typography.title,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }

        is StatesControl.Error -> {
            Box(
                modifier = Modifier.fillMaxWidth().padding(24.dp),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = stateCareer.message,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.tertiary
                )
            }
        }
    }
}

@Composable
fun CareerList(
    careers: List<Career>,
    onNavigate: (Routes) -> Unit
) {
    DropDownComponent(
        items = careers,
        itemDivider = { HorizontalLine() },
        itemContent = { career ->
            CareerCard(
                careerName = career.name,
                onClick = { onNavigate(Routes.ScreenSchedule(career.code)) }
            )
        }
    )
}

@Composable
fun CareerCard(
    careerName: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier){
    Card(
        modifier = modifier
            .padding(bottom = 4.dp)
            .height(54.dp),
        onClick = onClick,
        shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.tertiary
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
                text = careerName,
                style = MaterialTheme.typography.subtitle
            )
        }
    }
}

@Composable
fun HorizontalLine(modifier : Modifier = Modifier){
    HorizontalDivider(
        modifier = modifier.padding(vertical = 8.dp),
        thickness = 3.dp,
        color = MaterialTheme.colorScheme.outline
    )
}