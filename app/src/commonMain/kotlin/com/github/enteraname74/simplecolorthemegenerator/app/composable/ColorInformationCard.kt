package com.github.enteraname74.simplecolorthemegenerator.app.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ContentCopy
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ColorInformationCard(
    title: String,
    contentColor: Color,
    containerColor: Color,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(2.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "$title Container",
                color = Color.Black,
                modifier = Modifier.weight(1f)
            )
            CopyButton(
                colorToCopy = containerColor,
                iconColor = Color.Black,
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(
                    color = containerColor,
                    shape = RoundedCornerShape(14.dp),
                ),
            contentAlignment = Alignment.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Text(
                    text = "$title Content",
                    textAlign = TextAlign.Center,
                    color = contentColor,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 25.sp,
                )
                CopyButton(
                    colorToCopy = contentColor,
                    iconColor = contentColor,
                )
            }
        }
    }
}

@OptIn(ExperimentalStdlibApi::class)
@Composable
fun CopyButton(
    colorToCopy: Color,
    iconColor: Color,
) {
    val clipboardManager = LocalClipboardManager.current

    IconButton(
        onClick = {
            clipboardManager.setText(
                AnnotatedString(
                    "0x${colorToCopy.toArgb().toHexString()}"
                )
            )
        }
    ) {
        Icon(
            tint = iconColor,
            modifier = Modifier
                .pointerHoverIcon(PointerIcon.Hand),
            imageVector = Icons.Rounded.ContentCopy,
            contentDescription = null,
        )
    }
}