package com.github.enteraname74.simplecolorthemegenerator.app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.isCtrlPressed
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.unit.dp
import com.github.enteraname74.simplecolorthemegenerator.SimpleColorTheme
import com.github.enteraname74.simplecolorthemegenerator.SimpleColorThemeGenerator
import com.github.enteraname74.simplecolorthemegenerator.app.composable.ColorThemeList

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun App() {
    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
        ) {
            var baseColor: String by rememberSaveable {
                mutableStateOf("")
            }

            var colorTheme: SimpleColorTheme? by remember {
                mutableStateOf(null)
            }

            val requester = remember { FocusRequester() }

            LaunchedEffect(Unit) { requester.requestFocus() }

            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier.padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {


                    OutlinedTextField(
                        singleLine = true,
                        modifier = Modifier
                            .weight(1f, false)
                            .onKeyEvent {
                                if (it.key == Key.Enter) {
                                    colorTheme = generateColorTheme(baseColor = baseColor)
                                    true
                                } else {
                                    // let other handlers receive this event
                                    false
                                }
                            }
                            .focusRequester(requester),
                        value = baseColor,
                        onValueChange = { baseColor = it },
                        label = @Composable {
                            Text(text = "Base color",)
                        }
                    )

                    Button(
                        modifier = Modifier
                            .pointerHoverIcon(PointerIcon.Hand),
                        onClick = {
                            colorTheme = generateColorTheme(baseColor = baseColor)
                        }
                    ) {
                        Text(
                            text = "Generate"
                        )
                    }
                }
            }

            colorTheme?.let {
                ColorThemeList(colorTheme = it)
            }
        }
    }
}

private fun String.toColorInt(): Int? {
    if (this.isEmpty()) return null

    if (this[0] == '#') {
        var color = substring(1).toLong(16)
        if (length == 7) {
            color = color or 0x00000000ff000000L
        } else if (length != 9) {
            return null
        }
        return color.toInt()
    } else {
        return null
    }
}

private fun generateColorTheme(baseColor: String): SimpleColorTheme? {
    val baseColor: Color = baseColor.toColorInt()?.let(::Color) ?: return null

    return SimpleColorThemeGenerator.generate(baseColor)
}