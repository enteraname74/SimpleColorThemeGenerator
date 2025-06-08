package com.github.enteraname74.simplecolorthemegenerator

import androidx.compose.ui.graphics.Color
import com.github.enteraname74.simplecolorthemegenerator.ext.blend
import com.github.enteraname74.simplecolorthemegenerator.ext.textColor
import com.github.enteraname74.simplecolorthemegenerator.model.SimpleColorPalette
import com.github.enteraname74.simplecolorthemegenerator.model.SimpleColorTheme

object SimpleColorThemeGenerator {
    fun generate(baseColor: Color): SimpleColorTheme =
        SimpleColorTheme(
            lightTheme = buildLightTheme(baseColor = baseColor),
            darkTheme = buildDarkTheme(baseColor = baseColor),
        )

    private fun buildLightTheme(baseColor: Color): SimpleColorPalette {
        val primary = baseColor.blend(
            other = Color.White,
            ratio = PRIMARY_LIGHT_COLOR_RATIO,
        )

        val secondary = baseColor.blend(
            other = Color.White,
            ratio = SECONDARY_LIGHT_COLOR_RATIO,
        )

        val error = primary.blend(
            other = Color.Red,
            ratio = ERROR_LIGHT_COLOR_RATIO,
        )

        val warning = primary.blend(
            other = Color.Yellow,
            ratio = WARNING_LIGHT_COLOR_RATIO,
        )

        return SimpleColorPalette(
            primaryContainer = primary,
            primaryContent = primary.textColor(),
            secondaryContainer = secondary,
            secondaryContent = secondary.textColor(),
            errorContainer = error,
            errorContent = error.textColor(),
            warningContainer = warning,
            warningContent = warning.textColor(),
            accentContainer = baseColor,
            accentContent = baseColor.textColor(),
        )
    }

    private fun buildDarkTheme(baseColor: Color): SimpleColorPalette {
        val primary = baseColor.blend(
            other = Color.Black,
            ratio = PRIMARY_DARK_COLOR_RATIO,
        )

        val secondary = baseColor.blend(
            other = Color.Black,
            ratio = SECONDARY_DARK_COLOR_RATIO,
        )

        val error = primary.blend(
            other = Color.Red,
            ratio = ERROR_DARK_COLOR_RATIO,
        )

        val warning = primary.blend(
            other = Color.Yellow,
            ratio = WARNING_DARK_COLOR_RATIO,
        )

        return SimpleColorPalette(
            primaryContainer = primary,
            primaryContent = primary.textColor(),
            secondaryContainer = secondary,
            secondaryContent = secondary.textColor(),
            errorContainer = error,
            errorContent = error.textColor(),
            warningContainer = warning,
            warningContent = warning.textColor(),
            accentContainer = baseColor,
            accentContent = baseColor.textColor(),
        )
    }

    private const val PRIMARY_DARK_COLOR_RATIO = 0.75f
    private const val PRIMARY_LIGHT_COLOR_RATIO = 0.9f

    private const val SECONDARY_DARK_COLOR_RATIO = 0.55f
    private const val SECONDARY_LIGHT_COLOR_RATIO = 0.7f

    private const val ERROR_DARK_COLOR_RATIO = 0.6f
    private const val ERROR_LIGHT_COLOR_RATIO = 0.2f

    private const val WARNING_DARK_COLOR_RATIO = 0.9f
    private const val WARNING_LIGHT_COLOR_RATIO = 0.3f
}