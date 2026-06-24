package org.scesi.cappuchinoawesome.ui.utils.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

object Icons {
    fun listNested(color: Color = Color.White): ImageVector = ImageVector.Builder(
        name = "ListNested",
        defaultWidth = 16.dp,
        defaultHeight = 16.dp,
        viewportWidth = 16f,
        viewportHeight = 16f
    ).apply {
        path(fill = SolidColor(color)) {
            moveTo(4.5f, 11.5f)
            arcToRelative(0.5f, 0.5f, 0f, false, true, 0.5f, -0.5f)
            horizontalLineToRelative(10f)
            arcToRelative(0.5f, 0.5f, 0f, false, true, 0f, 1f)
            horizontalLineTo(5f)
            arcToRelative(0.5f, 0.5f, 0f, false, true, -0.5f, -0.5f)
        }
        path(fill = SolidColor(color)) {
            moveTo(2.5f, 7.5f)
            arcToRelative(0.5f, 0.5f, 0f, false, true, 0.5f, -0.5f)
            horizontalLineToRelative(10f)
            arcToRelative(0.5f, 0.5f, 0f, false, true, 0f, 1f)
            horizontalLineTo(3f)
            arcToRelative(0.5f, 0.5f, 0f, false, true, -0.5f, -0.5f)
        }
        path(fill = SolidColor(color)) {
            moveTo(0.5f, 3.5f)
            arcToRelative(0.5f, 0.5f, 0f, false, true, 0.5f, -0.5f)
            horizontalLineToRelative(10f)
            arcToRelative(0.5f, 0.5f, 0f, false, true, 0f, 1f)
            horizontalLineTo(1f)
            arcToRelative(0.5f, 0.5f, 0f, false, true, -0.5f, -0.5f)
        }
    }.build()
}