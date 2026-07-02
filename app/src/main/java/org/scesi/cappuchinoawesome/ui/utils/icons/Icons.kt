package org.scesi.cappuchinoawesome.ui.utils.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

object Icon {
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

    fun tikTok(color: Color = Color.White): ImageVector = ImageVector.Builder(
        name = "TikTokIcon",
        defaultWidth = 16.dp,
        defaultHeight = 16.dp,
        viewportWidth = 16f,
        viewportHeight = 16f
    ).apply {
        path(fill = SolidColor(color)) {
            moveTo(9f, 0f)

            lineTo(10.98f, 0f)

            curveTo(11.124f, 0.715f, 11.52f, 1.617f, 12.215f, 2.512f)
            curveTo(12.895f, 3.389f, 13.797f, 4f, 15f, 4f)

            lineTo(15f, 6f)
            curveTo(13.247f, 6f, 11.93f, 5.186f, 11f, 4.171f)

            lineTo(11f, 11f)

            curveTo(11f, 13.761f, 8.761f, 16f, 6f, 16f)
            curveTo(3.239f, 16f, 1f, 13.761f, 1f, 11f)
            curveTo(1f, 8.239f, 3.239f, 6f, 6f, 6f)

            lineTo(6f, 8f)

            curveTo(4.343f, 8f, 3f, 9.343f, 3f, 11f)
            curveTo(3f, 12.657f, 4.343f, 14f, 6f, 14f)
            curveTo(7.657f, 14f, 9f, 12.657f, 9f, 11f)

            lineTo(9f, 11f)

            close()
        }
    }.build()

    fun gitHub(color: Color = Color.White): ImageVector = ImageVector.Builder(
        name = "GitHubIcon",
        defaultWidth = 16.dp,
        defaultHeight = 16.dp,
        viewportWidth = 16f,
        viewportHeight = 16f
    ).apply {
        path(fill = SolidColor(color)) {
            moveTo(8f, 0f)
            curveTo(3.58f, 0f, 0f, 3.58f, 0f, 8f)
            curveTo(0f, 11.54f, 2.29f, 14.53f, 5.47f, 15.59f)
            curveTo(5.87f, 15.66f, 6.02f, 15.42f, 6.02f, 15.21f)
            curveTo(6.02f, 15.02f, 6.01f, 14.39f, 6.01f, 13.72f)
            curveTo(3.99f, 14.09f, 3.47f, 13.23f, 3.31f, 12.78f)
            curveTo(3.22f, 12.55f, 2.83f, 11.84f, 2.49f, 11.65f)
            curveTo(2.21f, 11.5f, 1.81f, 11.13f, 2.48f, 11.12f)
            curveTo(3.11f, 11.11f, 3.56f, 11.7f, 3.71f, 11.94f)
            curveTo(4.43f, 13.15f, 5.58f, 12.81f, 6.04f, 12.6f)
            curveTo(6.11f, 12.08f, 6.32f, 11.73f, 6.55f, 11.53f)
            curveTo(4.77f, 11.33f, 2.91f, 10.64f, 2.91f, 7.58f)
            curveTo(2.91f, 6.71f, 3.22f, 5.99f, 3.73f, 5.43f)
            curveTo(3.65f, 5.23f, 3.37f, 4.41f, 3.81f, 3.31f)
            curveTo(3.81f, 3.31f, 4.48f, 3.1f, 6.01f, 4.13f)
            curveTo(6.65f, 3.95f, 7.33f, 3.86f, 8.01f, 3.86f)
            curveTo(8.69f, 3.86f, 9.37f, 3.95f, 10.01f, 4.13f)
            curveTo(11.54f, 3.09f, 12.21f, 3.31f, 12.21f, 3.31f)
            curveTo(12.65f, 4.41f, 12.37f, 5.23f, 12.29f, 5.43f)
            curveTo(12.8f, 5.99f, 13.11f, 6.7f, 13.11f, 7.58f)
            curveTo(13.11f, 10.65f, 11.24f, 11.33f, 9.46f, 11.53f)
            curveTo(9.75f, 11.78f, 10f, 12.26f, 10f, 13.01f)
            curveTo(10f, 14.08f, 9.99f, 14.94f, 9.99f, 15.21f)
            curveTo(9.99f, 15.42f, 10.14f, 15.67f, 10.54f, 15.59f)
            arcTo(8.01f, 8.01f, 0f, true, false, 16f, 8f)
            curveTo(16f, 3.58f, 12.42f, 0f, 8f, 0f)
            close()
        }
    }.build()

}