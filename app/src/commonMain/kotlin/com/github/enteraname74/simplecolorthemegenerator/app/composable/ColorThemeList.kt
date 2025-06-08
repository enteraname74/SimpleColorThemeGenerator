package com.github.enteraname74.simplecolorthemegenerator.app.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.enteraname74.simplecolorthemegenerator.model.SimpleColorTheme

@Composable
fun ColorThemeList(
    modifier: Modifier = Modifier,
    colorTheme: SimpleColorTheme
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize(),
    ) {
        titleRow()
        colorRow(
            title = "Primary",
            lightContainerColor = colorTheme.lightTheme.primaryContainer,
            lightContentColor = colorTheme.lightTheme.primaryContent,
            darkContainerColor = colorTheme.darkTheme.primaryContainer,
            darkContentColor = colorTheme.darkTheme.primaryContent,
        )
        colorRow(
            title = "Secondary",
            lightContainerColor = colorTheme.lightTheme.secondaryContainer,
            lightContentColor = colorTheme.lightTheme.secondaryContent,
            darkContainerColor = colorTheme.darkTheme.secondaryContainer,
            darkContentColor = colorTheme.darkTheme.secondaryContent,
        )
        colorRow(
            title = "Accent",
            lightContainerColor = colorTheme.lightTheme.accentContainer,
            lightContentColor = colorTheme.lightTheme.accentContent,
            darkContainerColor = colorTheme.darkTheme.accentContainer,
            darkContentColor = colorTheme.darkTheme.accentContent,
        )
        colorRow(
            title = "Warning",
            lightContainerColor = colorTheme.lightTheme.warningContainer,
            lightContentColor = colorTheme.lightTheme.warningContent,
            darkContainerColor = colorTheme.darkTheme.warningContainer,
            darkContentColor = colorTheme.darkTheme.warningContent,
        )
        colorRow(
            title = "Error",
            lightContainerColor = colorTheme.lightTheme.errorContainer,
            lightContentColor = colorTheme.lightTheme.errorContent,
            darkContainerColor = colorTheme.darkTheme.errorContainer,
            darkContentColor = colorTheme.darkTheme.errorContent,
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
private fun LazyListScope.titleRow() {
    stickyHeader {
        Row(
            modifier = Modifier
                .background(Color.White)
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "Light Theme",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 25.sp,
                modifier = Modifier.weight(1f),
            )
            Text(
                text = "Dark Theme",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 25.sp,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp),
            )
        }
    }
}

private fun LazyListScope.colorRow(
    title: String,
    lightContainerColor: Color,
    lightContentColor: Color,
    darkContainerColor: Color,
    darkContentColor: Color,
) {
    item {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            ContainerBox(
                modifier = Modifier
                    .weight(1f),
            ) {
                ColorInformationCard(
                    modifier = Modifier
                        .fillMaxSize(1f),
                    title = title,
                    contentColor = lightContentColor,
                    containerColor = lightContainerColor,
                )
            }
            ContainerBox(
                modifier = Modifier
                    .weight(1f),
            ) {
                ColorInformationCard(
                    title = title,
                    contentColor = darkContentColor,
                    containerColor = darkContainerColor,
                )
            }
        }
    }
}

@Composable
private fun ContainerBox(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier
            .padding(8.dp)
    ) {
        content()
    }
}