package org.scesi.cappuchinoawesome.ui.features.aboutme


import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.scesi.cappuchinoawesome.ui.theme.text
import org.scesi.cappuchinoawesome.ui.utils.button.ButtonComponent
import org.scesi.cappuchinoawesome.ui.utils.header.HeaderComponent
import org.scesi.cappuchinoawesome.ui.utils.icons.Icon
import org.scesi.cappuchinoawesome.ui.utils.icons.Icon.customWaveBottom
import org.scesi.cappuchinoawesome.ui.utils.infocard.InfoCard
import androidx.core.net.toUri

@Composable
fun AboutMeScreen(
    onBackClick: () -> Unit
){
    Box(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background))
    {
        AboutMe(
            modifier = Modifier.align(Alignment.Center),
            onBackClick
        )
    }
}

@Composable
fun AboutMe(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit
){
    val context = LocalContext.current
    Column(modifier = modifier
        .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary)
                .windowInsetsTopHeight(WindowInsets.statusBars)
        )

        HeaderComponent(
            titleHeader = "By Bochito",
            titleColor = MaterialTheme.colorScheme.onPrimary,
            backgroundColor = MaterialTheme.colorScheme.primary,
            leftAction = {
                ButtonComponent(
                    onClick = {onBackClick()},
                    isIcon = Icon.boxArrowLeft(MaterialTheme.colorScheme.onPrimary),
                    backgroundColor = MaterialTheme.colorScheme.primary,
                    textColor = MaterialTheme.colorScheme.tertiary
                )
            }

        )

        Spacer(Modifier.height(10.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                imageVector = customWaveBottom(color = MaterialTheme.colorScheme.primary),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(0.95f)
                    .height(60.dp)
                    .offset(y = 10.dp),
                contentScale = ContentScale.FillBounds
            )
            InfoCard(
                title = "Cappuchino Awesome",
                modifier = Modifier.fillMaxWidth(0.95f)
            ) {
                Text(
                    text = "Cappuchino Awesome es un proyecto dedicado a la postulacion SCESI UMMS 2026, desarrollado " +
                            "para el área de programacion mobile, gracias al mentor Saúl, se pudo avanzar en gran medida la app " +
                            "faltan pequeñitos detalles como la persistencia con el uso de Room e inyeccion de dependencias, " +
                            " cosas menores UwU, pero el provecho lo saqué yo al aprender una gran especialización como lo es desarrollo mobile." +
                            " Gracias SCESI por el apoyo y el conocimiento que me dieron.",
                    style = MaterialTheme.typography.text.copy(lineHeight = 22.sp)
                )
            }

            Spacer(Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(0.95f),
                verticalAlignment = Alignment.Top
            ) {
                InfoCard(
                    title = "Sobre mi",
                    modifier = Modifier.weight(1f),
                ) {
                    Text(
                        text =  "Mi nombre es Jhosua, un estudiante de Ingenieria Informatica - UMSS, un gusto por el software libre y un hambre por el conocimiento",
                        style = MaterialTheme.typography.text.copy(lineHeight = 22.sp)
                    )
                }

                Spacer(Modifier.width(16.dp))

                InfoCard(
                    title = "Mis redes",
                    modifier = Modifier.weight(1f),
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        ButtonComponent(
                            onClick = {
                                val intent = Intent(Intent.ACTION_VIEW,
                                    "https://www.tiktok.com/@don_bocho?_r=1&_t=ZS-97gfEbDEJ8C".toUri()
                                )
                                context.startActivity(intent)
                            },
                            isIcon = Icon.tikTok(color = MaterialTheme.colorScheme.onSecondary),
                            backgroundColor = MaterialTheme.colorScheme.secondary,
                            textColor = MaterialTheme.colorScheme.outline,
                            modifier = Modifier.padding(horizontal = 8.dp)
                        )

                        ButtonComponent(
                            onClick = {
                                val intent = Intent(Intent.ACTION_VIEW,
                                    "https://github.com/Bochit0".toUri()
                                )
                                context.startActivity(intent)
                            },
                            isIcon = Icon.gitHub(color = MaterialTheme.colorScheme.onSecondary),
                            backgroundColor = MaterialTheme.colorScheme.secondary,
                            textColor = MaterialTheme.colorScheme.outline,
                            modifier = Modifier.padding(horizontal = 8.dp)
                        )
                    }
                }
            }
        }
    }
}