package com.github.enteraname74.simplecolorthemegenerator.ext

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import kotlin.math.max
import kotlin.math.min

/**
 * Blend a color with another one.
 * The ratio should be between 0.0 and 1.0.
 */
fun Color.blend(
    other: Color,
    ratio: Float
): Color {
    val inverseRatio = 1 - ratio
    val a = this.alpha * inverseRatio + other.alpha * ratio
    val r = this.red * inverseRatio + other.red * ratio
    val g = this.green * inverseRatio + other.green * ratio
    val b = this.blue * inverseRatio + other.blue * ratio
    return Color(
        red = r,
        green = g,
        blue = b,
        alpha = a
    )
}

fun Color.textColor(
    baseLight: Color = Color.White,
    baseDark: Color = Color.Black,
): Color {

    val lightColor = baseLight.blend(
        other = this,
        ratio = 0.2f
    )

    val darkColor = baseDark.blend(
        other = this,
        ratio = 0.4f,
    )

    val whiteContrast = getContrast(
        color1 = lightColor,
        color2 = this,
    )
    val darkContrast = getContrast(
        color1 = darkColor,
        color2 = this,
    )

    return if (whiteContrast >= CONTRASTED_COLOR_THRESHOLD || whiteContrast >= darkContrast) {
        lightColor
    } else {
        darkColor
    }
}


/**
 * Retrieve the color contrast between two color.
 */
private fun getContrast(
    color1: Color,
    color2: Color,
): Float {
    val color1Luminance: Float = color1.luminance()
    val color2Luminance: Float = color2.luminance()

    val brightest = max(color1Luminance, color2Luminance)
    val darkest = min(color1Luminance, color2Luminance)

    return (brightest + 0.05f) / (darkest + 0.05f)
}

private const val CONTRASTED_COLOR_THRESHOLD = 4.5f
