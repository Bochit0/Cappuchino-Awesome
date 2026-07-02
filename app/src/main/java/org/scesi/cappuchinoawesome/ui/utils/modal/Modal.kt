package org.scesi.cappuchinoawesome.ui.utils.modal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import org.scesi.cappuchinoawesome.ui.theme.subtitle

@Composable
fun Modal(
    modifier: Modifier = Modifier,
    textHeader: String,
    textMedium: String,
    textFooter: String,
    isClass: Boolean = false,
    onDismiss: () -> Unit
){
    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
                contentColor = MaterialTheme.colorScheme.tertiary
            ),
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(vertical = 24.dp, horizontal = 20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = textHeader,
                    style = MaterialTheme.typography.subtitle
                )
                Spacer(Modifier.height(10.dp))
                HorizontalLine(modifier)
                Spacer(Modifier.height(10.dp))
                if(!isClass){
                    Text(
                        text = "AUXILIATURA",
                        style = MaterialTheme.typography.subtitle
                    )
                }
                Spacer(Modifier.height(4.dp))
                Text(
                    text = "AULA: $textMedium",
                    style = MaterialTheme.typography.subtitle
                )
                Spacer(Modifier.height(17.dp))
                Text(
                    text = textFooter,
                    style = MaterialTheme.typography.subtitle
                )
            }
        }
    }
}

@Composable
fun HorizontalLine(modifier : Modifier = Modifier){
    HorizontalDivider(
        modifier = modifier.padding(vertical = 5.dp),
        thickness = 3.dp,
        color = MaterialTheme.colorScheme.tertiary.copy(alpha = 0.3f)
    )
}