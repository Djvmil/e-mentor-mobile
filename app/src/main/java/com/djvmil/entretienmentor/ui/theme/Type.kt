package com.djvmil.entretienmentor.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.djvmil.entretienmentor.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.helvetica_neue_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.helvetica_neue_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    bodySmall = TextStyle(
        fontSize = 18.sp,
        fontFamily = FontFamily(Font(R.font.helvetica_neue_regular))
    ),
    titleLarge = TextStyle(
        fontSize = 14.sp,
        fontFamily = FontFamily(Font(R.font.helvetica_neue_regular))
    ),
    titleMedium = TextStyle(
        fontSize = 12.sp,
        fontFamily = FontFamily(Font(R.font.helvetica_neue_regular))
    ),
    titleSmall = TextStyle(
        fontSize = 12.sp,
        fontFamily = FontFamily(Font(R.font.helvetica_neue_regular))
    ),
    displayLarge = TextStyle(
        fontSize = 14.sp,
        fontFamily = FontFamily(Font(R.font.helvetica_neue_regular))
    ),
    displayMedium = TextStyle(
        fontSize = 12.sp,
        fontFamily = FontFamily(Font(R.font.helvetica_neue_regular))
    ),
    displaySmall = TextStyle(
        fontSize = 12.sp,
        fontFamily = FontFamily(Font(R.font.helvetica_neue_regular))
    ),
    labelLarge = TextStyle(
        fontSize = 14.sp,
        fontFamily = FontFamily(Font(R.font.helvetica_neue_regular))
    ),
    labelMedium = TextStyle(
        fontSize = 12.sp,
        fontFamily = FontFamily(Font(R.font.helvetica_neue_regular))
    ),
    labelSmall = TextStyle(
        fontSize = 12.sp,
        fontFamily = FontFamily(Font(R.font.helvetica_neue_regular))
    )
)