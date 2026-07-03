package org.scesi.cappuchinoawesome.ui.utils.header

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import org.scesi.cappuchinoawesome.ui.theme.title
import org.scesi.cappuchinoawesome.ui.utils.icons.Icon.customWaveTop

@Composable
fun HeaderComponent(
    modifier: Modifier = Modifier,
    titleHeader: String,
    backgroundColor: Color,
    titleColor: Color,
    isWave: Boolean = true,
    leftAction: @Composable (() -> Unit)? = null,
){
    Column(modifier = modifier.fillMaxWidth()) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .background(backgroundColor)
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (leftAction != null) {
                    leftAction()
                    Spacer(modifier = Modifier.width(16.dp))
                }else{
                    Spacer(modifier = Modifier.width(56.dp))
                }

                Text(
                    text = titleHeader,
                    color = titleColor,
                    style = MaterialTheme.typography.title,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )
            }
        }
        if (isWave) {
            Image(
                imageVector = customWaveTop(color = backgroundColor),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .offset(y = (-1).dp),
                contentScale = ContentScale.FillBounds
            )
        }
    }
}