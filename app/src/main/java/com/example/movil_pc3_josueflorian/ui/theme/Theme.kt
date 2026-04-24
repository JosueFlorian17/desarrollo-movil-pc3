package com.example.movil_pc3_josueflorian.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = moradomain,
    secondary = moradosecundario,
    tertiary = rosaterciario
)

@Composable
fun Movilpc3josueflorianTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography,
        content = content
    )
}
