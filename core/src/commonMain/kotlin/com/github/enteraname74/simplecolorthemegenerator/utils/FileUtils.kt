package com.github.enteraname74.simplecolorthemegenerator.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.github.enteraname74.simplecolorthemegenerator.model.SimpleColorPalette
import com.github.enteraname74.simplecolorthemegenerator.model.SimpleColorTheme

object FileUtils {
    fun formatSimpleColorThemeForFile(
        colorTheme: SimpleColorTheme,
    ): String = buildString {
        appendLine("import androidx.compose.ui.graphics.Color")
        append("\n")
        appendPalette(
            colorPalette = colorTheme.lightTheme,
            mode = Mode.Light,
        )
        append("\n")
        appendPalette(
            colorPalette = colorTheme.darkTheme,
            mode = Mode.Dark,
        )
    }

    private fun StringBuilder.appendPalette(
        colorPalette: SimpleColorPalette,
        mode: Mode,
    ) {
        appendColor(
            name = colorPalette::primaryContainer.name,
            color = colorPalette.primaryContainer,
            mode = mode,
        )
        appendColor(
            name = colorPalette::primaryContent.name,
            color = colorPalette.primaryContent,
            mode = mode,
        )
        appendColor(
            name = colorPalette::secondaryContainer.name,
            color = colorPalette.secondaryContent,
            mode = mode,
        )
        appendColor(
            name = colorPalette::secondaryContent.name,
            color = colorPalette.secondaryContent,
            mode = mode,
        )
        appendColor(
            name = colorPalette::accentContainer.name,
            color = colorPalette.accentContainer,
            mode = mode,
        )
        appendColor(
            name = colorPalette::accentContent.name,
            color = colorPalette.accentContent,
            mode = mode,
        )
        appendColor(
            name = colorPalette::warningContainer.name,
            color = colorPalette.warningContainer,
            mode = mode,
        )
        appendColor(
            name = colorPalette::warningContent.name,
            color = colorPalette.warningContent,
            mode = mode,
        )
        appendColor(
            name = colorPalette::errorContainer.name,
            color = colorPalette.errorContainer,
            mode = mode,
        )
        appendColor(
            name = colorPalette::errorContent.name,
            color = colorPalette.errorContent,
            mode = mode,
        )
    }

    @OptIn(ExperimentalStdlibApi::class)
    private fun StringBuilder.appendColor(
        name: String,
        color: Color,
        mode: Mode,
    ) {
        appendLine("val $name${mode.value} = Color(0x${color.toArgb().toHexString()})")
    }

    private enum class Mode(val value: String) {
        Dark("Dark"),
        Light("Light"),
    }
}