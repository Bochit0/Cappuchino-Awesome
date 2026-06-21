package org.scesi.cappuchinoawesome.ui.theme


import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.Font
import org.scesi.cappuchinoawesome.R

// Set of Material typography styles to start with
val Typography = Typography()
val jaquardaregular = FontFamily(
    Font(R.font.jaquardaregular)
)

val orbitron = FontFamily(
    Font(R.font.orbitron)
)

val Typography.subtitle: TextStyle
    get() = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )

val Typography.title: TextStyle
    get() = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Normal,
        fontSize = 25.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    )

val Typography.text: TextStyle
    get() = TextStyle(
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 14.sp,
        letterSpacing = 0.sp
    )

val Typography.titleApp: TextStyle
    get() = TextStyle(
        fontFamily = jaquardaregular,
        fontWeight = FontWeight.Normal,
        fontSize = 62.sp,
        lineHeight = 29.sp,
        letterSpacing = 0.sp
    )

val Typography.subtitleApp: TextStyle
    get() = TextStyle(
        fontFamily = orbitron,
        fontWeight = FontWeight.Normal,
        fontSize = 45.sp,
        lineHeight = 22.sp,
        letterSpacing = 0.sp
    )