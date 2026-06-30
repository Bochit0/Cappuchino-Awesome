package org.scesi.cappuchinoawesome.ui.utils.itemcard

import android.R.attr.textStyle
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import org.scesi.cappuchinoawesome.ui.theme.subtitle

@Composable
fun ItemCard(
    name: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    containerColor: Color? = null,
    contentColor: Color? = null,
    textStyle: TextStyle? = null
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(54.dp)
            .clickable { onClick() }
            .padding(horizontal = 16.dp)
            .then(
                if (containerColor != null)
                    Modifier.background(containerColor)
                else Modifier
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            text = name,
            style = textStyle ?: MaterialTheme.typography.subtitle,
            color = contentColor ?: MaterialTheme.colorScheme.background
        )
    }
}