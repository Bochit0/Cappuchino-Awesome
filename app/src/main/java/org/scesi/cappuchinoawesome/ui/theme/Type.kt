package org.scesi.cappuchinoawesome.ui.theme


import android.R.attr.maxWidth
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.scesi.cappuchinoawesome.R

// Set of Material typography styles to start with
val Typography = Typography()
val jaquardaregular = FontFamily(
    Font(R.font.jaquardaregular)
)

val orbitron = FontFamily(
    Font(R.font.orbitron)
)

val localTypography = compositionLocalOf { false }
val Typography.subtitle: TextStyle
    @Composable get() = if (localTypography.current) {
        TextStyle(
            fontFamily = orbitron,
            fontWeight = FontWeight.Medium,
            fontSize = 19.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.5.sp
        )
    }else{
        TextStyle(
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Medium,
            fontSize = 19.sp,
            lineHeight = 16.sp,
            letterSpacing = 0.5.sp
        )
    }

val Typography.title: TextStyle
    @Composable get() = if (localTypography.current) {
        TextStyle(
            fontFamily = jaquardaregular,
            fontWeight = FontWeight.Normal,
            fontSize = 24.sp,
            lineHeight = 28.sp,
            letterSpacing = 0.sp
        )
    }else{
        TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 24.sp,
            lineHeight = 28.sp,
            letterSpacing = 0.sp
        )
    }

val Typography.text: TextStyle
    @Composable get() = if (localTypography.current) {
    TextStyle(
        fontFamily = orbitron,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 14.sp,
        letterSpacing = 0.sp
    )
    }else{
        TextStyle(
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            lineHeight = 14.sp,
            letterSpacing = 0.sp
        )
    }

fun titleApp(maxWidth: Dp): TextStyle =
    TextStyle(
        fontFamily = jaquardaregular,
        fontWeight = FontWeight.Normal,
        fontSize = when {
            maxWidth < 360.dp -> 40.sp
            maxWidth < 400.dp -> 54.sp
            else -> 62.sp
        },
        lineHeight = 29.sp,
        letterSpacing = 0.sp
    )


fun subtitleApp(maxWidth: Dp): TextStyle =
    TextStyle(
        fontFamily = orbitron,
        fontWeight = FontWeight.Normal,
        fontSize = when {
            maxWidth < 360.dp -> 32.sp
            maxWidth < 400.dp -> 39.sp
            else -> 45.sp
        },
        lineHeight = 22.sp,
        letterSpacing = 0.sp
    )
