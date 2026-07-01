package org.scesi.cappuchinoawesome.ui.utils.button

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun ButtonComponent(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isText: String? = null,
    isIcon: ImageVector? = null,
    backgroundColor: Color,
    textColor: Color
){
    val colorButton = ButtonDefaults.buttonColors(
        containerColor = backgroundColor,
        contentColor = textColor
    )
    Crossfade(targetState = isIcon, label = "ButtonIconCrossfade") { icon ->
        if (icon !=null) {
            IconButton(
                onClick = onClick,
                modifier = modifier.size(40.dp),
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = backgroundColor,
                    contentColor = textColor)
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.size(25.dp)
                )
            }
        }
    }

    if (isText != null) {
        Button(
            onClick = onClick,
            modifier = modifier,
            colors = colorButton,
            shape = RoundedCornerShape(4.dp)
        ) {
            Text(text = isText)
        }
    }
}