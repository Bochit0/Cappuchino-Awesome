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

    fun list(color: Color = Color.White): ImageVector = ImageVector.Builder(
        name = "List",
        defaultWidth = 16.dp,
        defaultHeight = 16.dp,
        viewportWidth = 16f,
        viewportHeight = 16f
    ).apply {
        path(fill = SolidColor(color)) {
            moveTo(2.5f, 12f)
            arcToRelative(0.5f, 0.5f, 0f, false, true, 0.5f, -0.5f)
            horizontalLineToRelative(10f)
            arcToRelative(0.5f, 0.5f, 0f, false, true, 0f, 1f)
            horizontalLineTo(3f)
            arcToRelative(0.5f, 0.5f, 0f, false, true, -0.5f, -0.5f)
        }
        path(fill = SolidColor(color)) {
            moveTo(2.5f, 8f)
            arcToRelative(0.5f, 0.5f, 0f, false, true, 0.5f, -0.5f)
            horizontalLineToRelative(10f)
            arcToRelative(0.5f, 0.5f, 0f, false, true, 0f, 1f)
            horizontalLineTo(3f)
            arcToRelative(0.5f, 0.5f, 0f, false, true, -0.5f, -0.5f)
        }
        path(fill = SolidColor(color)) {
            moveTo(2.5f, 4f)
            arcToRelative(0.5f, 0.5f, 0f, false, true, 0.5f, -0.5f)
            horizontalLineToRelative(10f)
            arcToRelative(0.5f, 0.5f, 0f, false, true, 0f, 1f)
            horizontalLineTo(3f)
            arcToRelative(0.5f, 0.5f, 0f, false, true, -0.5f, -0.5f)
        }
    }.build()

    fun boxArrowLeft(color: Color = Color.White): ImageVector = ImageVector.Builder(
        name = "BoxArrowLeft",
        defaultWidth = 16.dp,
        defaultHeight = 16.dp,
        viewportWidth = 16f,
        viewportHeight = 16f
    ).apply {
        path(fill = SolidColor(color)) {
            moveTo(6f, 12.5f)
            arcToRelative(0.5f, 0.5f, 0f, false, false, 0.5f, 0.5f)
            horizontalLineToRelative(8f)
            arcToRelative(0.5f, 0.5f, 0f, false, false, 0.5f, -0.5f)
            verticalLineToRelative(-9f)
            arcToRelative(0.5f, 0.5f, 0f, false, false, -0.5f, -0.5f)
            horizontalLineToRelative(-8f)
            arcToRelative(0.5f, 0.5f, 0f, false, false, -0.5f, 0.5f)
            verticalLineToRelative(2f)
            arcToRelative(0.5f, 0.5f, 0f, false, true, -1f, 0f)
            verticalLineToRelative(-2f)
            arcTo(1.5f, 1.5f, 0f, false, true, 6.5f, 2f)
            horizontalLineToRelative(8f)
            arcTo(1.5f, 1.5f, 0f, false, true, 16f, 3.5f)
            verticalLineToRelative(9f)
            arcTo(1.5f, 1.5f, 0f, false, true, 14.5f, 15f)
            horizontalLineToRelative(-8f)
            arcTo(1.5f, 1.5f, 0f, false, true, 5f, 12.5f)
            verticalLineToRelative(-2f)
            arcToRelative(0.5f, 0.5f, 0f, false, true, 1f, 0f)
            close()
        }
        path(fill = SolidColor(color)) {
            moveTo(0.146f, 8.354f)
            arcToRelative(0.5f, 0.5f, 0f, false, true, 0f, -0.708f)
            lineToRelative(3f, -3f)
            arcToRelative(0.5f, 0.5f, 0f, true, true, 0.708f, 0.708f)
            lineTo(1.707f, 7.5f)
            horizontalLineToRelative(8.793f)
            arcToRelative(0.5f, 0.5f, 0f, false, true, 0f, 1f)
            horizontalLineTo(1.707f)
            lineToRelative(2.147f, 2.146f)
            arcToRelative(0.5f, 0.5f, 0f, false, true, -0.708f, 0.708f)
            close()
        }
    }.build()

    fun stars(color: Color = Color.White): ImageVector = ImageVector.Builder(
        name = "Stars",
        defaultWidth = 16.dp,
        defaultHeight = 16.dp,
        viewportWidth = 16f,
        viewportHeight = 16f
    ).apply {
        path(fill = SolidColor(color)) {
            moveTo(7.657f, 6.247f)
            arcToRelative(0.361f, 0.361f, 0f, false, true, .686f, 0f)
            lineToRelative(0.645f, 1.937f)
            arcToRelative(2.89f, 2.89f, 0f, false, false, 1.829f, 1.828f)
            lineToRelative(1.936f, .645f)
            arcToRelative(0.361f, 0.361f, 0f, false, true, 0f, .686f)
            lineToRelative(-1.937f, .645f)
            arcToRelative(2.89f, 2.89f, 0f, false, false, -1.828f, 1.829f)
            lineToRelative(-0.645f, 1.936f)
            arcToRelative(0.361f, 0.361f, 0f, false, true, -0.686f, 0f)
            lineToRelative(-0.645f, -1.937f)
            arcToRelative(2.89f, 2.89f, 0f, false, false, -1.828f, -1.828f)
            lineToRelative(-1.937f, -0.645f)
            arcToRelative(0.361f, 0.361f, 0f, false, true, 0f, -0.686f)
            lineToRelative(1.937f, -0.645f)
            arcToRelative(2.89f, 2.89f, 0f, false, false, 1.828f, -1.828f)
            close()
        }
        path(fill = SolidColor(color)) {
            moveTo(3.794f, 1.148f)
            arcToRelative(0.217f, 0.217f, 0f, false, true, .412f, 0f)
            lineToRelative(0.387f, 1.162f)
            curveToRelative(0.173f, 0.518f, 0.579f, 0.924f, 1.097f, 1.097f)
            lineToRelative(1.162f, .387f)
            arcToRelative(0.217f, 0.217f, 0f, false, true, 0f, .412f)
            lineToRelative(-1.162f, .387f)
            verticalLineToRelative(0.001f)
            arcTo(1.73f, 1.73f, 0f, false, false, 4.593f, 5.69f)
            lineToRelative(-0.387f, 1.162f)
            arcToRelative(0.217f, 0.217f, 0f, false, true, -0.412f, 0f)
            lineTo(3.407f, 5.69f)
            arcTo(1.73f, 1.73f, 0f, false, false, 2.31f, 4.593f)
            lineToRelative(-1.162f, -0.387f)
            arcToRelative(0.217f, 0.217f, 0f, false, true, 0f, -0.412f)
            lineToRelative(1.162f, -0.387f)
            arcTo(1.73f, 1.73f, 0f, false, false, 3.407f, 2.31f)
            close()
        }
        path(fill = SolidColor(color)) {
            moveTo(10.863f, 0.099f)
            arcToRelative(0.145f, 0.145f, 0f, false, true, .274f, 0f)
            lineToRelative(0.258f, .774f)
            curveToRelative(0.115f, 0.346f, 0.386f, 0.617f, 0.732f, 0.732f)
            lineToRelative(0.774f, .258f)
            arcToRelative(0.145f, 0.145f, 0f, false, true, 0f, .274f)
            lineToRelative(-0.774f, .258f)
            verticalLineToRelative(0.001f)
            arcToRelative(1.16f, 1.16f, 0f, false, false, -0.732f, .732f)
            lineToRelative(-0.258f, .774f)
            arcToRelative(0.145f, 0.145f, 0f, false, true, -0.274f, 0f)
            lineToRelative(-0.258f, -0.774f)
            arcToRelative(1.16f, 1.16f, 0f, false, false, -0.732f, -0.732f)
            lineToRelative(-0.774f, -0.258f)
            arcToRelative(0.145f, 0.145f, 0f, false, true, 0f, -0.274f)
            lineToRelative(0.774f, -0.258f)
            curveToRelative(0.346f, -0.115f, 0.617f, -0.386f, 0.732f, -0.732f)
            close()
        }
    }.build()

    fun customWaveTop(color: Color = Color(0xFF0099FF)): ImageVector = ImageVector.Builder(
        name = "CustomWaveTop",
        defaultWidth = 1440.dp,
        defaultHeight = 320.dp,
        viewportWidth = 1440f,
        viewportHeight = 320f
    ).apply {
        path(fill = SolidColor(color)) {
            moveTo(0f, 32f)
            lineTo(0f, 192f)
            lineTo(55.4f, 192f)
            lineTo(55.4f, 224f)
            lineTo(110.8f, 224f)
            lineTo(110.8f, 192f)
            lineTo(166.2f, 192f)
            lineTo(166.2f, 64f)
            lineTo(221.5f, 64f)
            lineTo(221.5f, 32f)
            lineTo(276.9f, 32f)
            lineTo(276.9f, 224f)
            lineTo(332.3f, 224f)
            lineTo(332.3f, 64f)
            lineTo(387.7f, 64f)
            lineTo(387.7f, 64f)
            lineTo(443.1f, 64f)
            lineTo(443.1f, 256f)
            lineTo(498.5f, 256f)
            lineTo(498.5f, 160f)
            lineTo(553.8f, 160f)
            lineTo(553.8f, 256f)
            lineTo(609.2f, 256f)
            lineTo(609.2f, 288f)
            lineTo(664.6f, 288f)
            lineTo(664.6f, 192f)
            lineTo(720f, 192f)
            lineTo(720f, 64f)
            lineTo(775.4f, 64f)
            lineTo(775.4f, 288f)
            lineTo(830.8f, 288f)
            lineTo(830.8f, 160f)
            lineTo(886.2f, 160f)
            lineTo(886.2f, 288f)
            lineTo(941.5f, 288f)
            lineTo(941.5f, 96f)
            lineTo(996.9f, 96f)
            lineTo(996.9f, 32f)
            lineTo(1052.3f, 32f)
            lineTo(1052.3f, 288f)
            lineTo(1107.7f, 288f)
            lineTo(1107.7f, 96f)
            lineTo(1163.1f, 96f)
            lineTo(1163.1f, 160f)
            lineTo(1218.5f, 160f)
            lineTo(1218.5f, 256f)
            lineTo(1273.8f, 256f)
            lineTo(1273.8f, 32f)
            lineTo(1329.2f, 32f)
            lineTo(1329.2f, 256f)
            lineTo(1384.6f, 256f)
            lineTo(1384.6f, 224f)
            lineTo(1440f, 224f)

            // Cierre y retorno por el techo superior (Y = 0f)
            lineTo(1440f, 0f)
            lineTo(1384.6f, 0f)
            lineTo(1384.6f, 0f)
            lineTo(1329.2f, 0f)
            lineTo(1329.2f, 0f)
            lineTo(1273.8f, 0f)
            lineTo(1273.8f, 0f)
            lineTo(1218.5f, 0f)
            lineTo(1218.5f, 0f)
            lineTo(1163.1f, 0f)
            lineTo(1163.1f, 0f)
            lineTo(1107.7f, 0f)
            lineTo(1107.7f, 0f)
            lineTo(1052.3f, 0f)
            lineTo(1052.3f, 0f)
            lineTo(996.9f, 0f)
            lineTo(996.9f, 0f)
            lineTo(941.5f, 0f)
            lineTo(941.5f, 0f)
            lineTo(886.2f, 0f)
            lineTo(886.2f, 0f)
            lineTo(830.8f, 0f)
            lineTo(830.8f, 0f)
            lineTo(775.4f, 0f)
            lineTo(775.4f, 0f)
            lineTo(720f, 0f)
            lineTo(720f, 0f)
            lineTo(664.6f, 0f)
            lineTo(664.6f, 0f)
            lineTo(609.2f, 0f)
            lineTo(609.2f, 0f)
            lineTo(553.8f, 0f)
            lineTo(553.8f, 0f)
            lineTo(498.5f, 0f)
            lineTo(498.5f, 0f)
            lineTo(443.1f, 0f)
            lineTo(443.1f, 0f)
            lineTo(387.7f, 0f)
            lineTo(387.7f, 0f)
            lineTo(332.3f, 0f)
            lineTo(332.3f, 0f)
            lineTo(276.9f, 0f)
            lineTo(276.9f, 0f)
            lineTo(221.5f, 0f)
            lineTo(221.5f, 0f)
            lineTo(166.2f, 0f)
            lineTo(166.2f, 0f)
            lineTo(110.8f, 0f)
            lineTo(110.8f, 0f)
            lineTo(55.4f, 0f)
            lineTo(55.4f, 0f)
            lineTo(0f, 0f)
            lineTo(0f, 0f)
            close()
        }
    }.build()

    fun customWaveBottom(color: Color = Color(0xFF0099FF)): ImageVector = ImageVector.Builder(
        name = "CustomWaveBottom",
        defaultWidth = 1440.dp,
        defaultHeight = 320.dp,
        viewportWidth = 1440f,
        viewportHeight = 320f
    ).apply {
        path(fill = SolidColor(color)) {
            moveTo(0f, 0f)
            lineTo(0f, 192f)
            lineTo(62.6f, 192f)
            lineTo(62.6f, 64f)
            lineTo(125.2f, 64f)
            lineTo(125.2f, 192f)
            lineTo(187.8f, 192f)
            lineTo(187.8f, 32f)
            lineTo(250.4f, 32f)
            lineTo(250.4f, 64f)
            lineTo(313f, 64f)
            lineTo(313f, 224f)
            lineTo(375.7f, 224f)
            lineTo(375.7f, 96f)
            lineTo(438.3f, 96f)
            lineTo(438.3f, 128f)
            lineTo(500.9f, 128f)
            lineTo(500.9f, 64f)
            lineTo(563.5f, 64f)
            lineTo(563.5f, 32f)
            lineTo(626.1f, 32f)
            lineTo(626.1f, 64f)
            lineTo(688.7f, 64f)
            lineTo(688.7f, 96f)
            lineTo(751.3f, 96f)
            lineTo(751.3f, 256f)
            lineTo(813.9f, 256f)
            lineTo(813.9f, 224f)
            lineTo(876.5f, 224f)
            lineTo(876.5f, 64f)
            lineTo(939.1f, 64f)
            lineTo(939.1f, 64f)
            lineTo(1001.7f, 64f)
            lineTo(1001.7f, 128f)
            lineTo(1064.3f, 128f)
            lineTo(1064.3f, 160f)
            lineTo(1127f, 160f)
            lineTo(1127f, 160f)
            lineTo(1189.6f, 160f)
            lineTo(1189.6f, 288f)
            lineTo(1252.2f, 288f)
            lineTo(1252.2f, 32f)
            lineTo(1314.8f, 32f)
            lineTo(1314.8f, 224f)
            lineTo(1377.4f, 224f)
            lineTo(1377.4f, 128f)
            lineTo(1440f, 128f)

            lineTo(1440f, 320f)
            lineTo(1377.4f, 320f)
            lineTo(1377.4f, 320f)
            lineTo(1314.8f, 320f)
            lineTo(1314.8f, 320f)
            lineTo(1252.2f, 320f)
            lineTo(1252.2f, 320f)
            lineTo(1189.6f, 320f)
            lineTo(1189.6f, 320f)
            lineTo(1127f, 320f)
            lineTo(1127f, 320f)
            lineTo(1064.3f, 320f)
            lineTo(1064.3f, 320f)
            lineTo(1001.7f, 320f)
            lineTo(1001.7f, 320f)
            lineTo(939.1f, 320f)
            lineTo(939.1f, 320f)
            lineTo(876.5f, 320f)
            lineTo(876.5f, 320f)
            lineTo(813.9f, 320f)
            lineTo(813.9f, 320f)
            lineTo(751.3f, 320f)
            lineTo(751.3f, 320f)
            lineTo(688.7f, 320f)
            lineTo(688.7f, 320f)
            lineTo(626.1f, 320f)
            lineTo(626.1f, 320f)
            lineTo(563.5f, 320f)
            lineTo(563.5f, 320f)
            lineTo(500.9f, 320f)
            lineTo(500.9f, 320f)
            lineTo(438.3f, 320f)
            lineTo(438.3f, 320f)
            lineTo(375.7f, 320f)
            lineTo(375.7f, 320f)
            lineTo(313f, 320f)
            lineTo(313f, 320f)
            lineTo(250.4f, 320f)
            lineTo(250.4f, 320f)
            lineTo(187.8f, 320f)
            lineTo(187.8f, 320f)
            lineTo(125.2f, 320f)
            lineTo(125.2f, 320f)
            lineTo(62.6f, 320f)
            lineTo(62.6f, 320f)
            lineTo(0f, 320f)
            lineTo(0f, 320f)

            close()
        }
    }.build()
}