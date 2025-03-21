package com.github.enteraname74.simplecolorthemegenerator

import androidx.compose.ui.graphics.Color

data class SimpleColorPalette(
    val primaryContainer: Color,
    val onPrimaryContainer: Color,
    val secondaryContainer: Color,
    val onSecondaryContainer: Color,
    val errorContainer: Color,
    val onErrorContainer: Color,
    val warningContainer: Color,
    val onWarningContainer: Color,
)

data class SimpleColorTheme(
    val lightTheme: SimpleColorPalette,
    val darkTheme: SimpleColorPalette,
)