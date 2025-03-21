package com.github.enteraname74.simplecolorthemegenerator.app.ext

import androidx.compose.foundation.clickable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon

fun Modifier.clickableWithHandCursor(onClick: () -> Unit): Modifier =
    this
        .pointerHoverIcon(PointerIcon.Hand)
        .clickable(onClick = onClick)