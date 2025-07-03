package com.the43h1.mymealapp.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(
    name = "Light Mode",
    showBackground = true,
    device = "id:pixel_5"
)
@Composable
fun LightThemePreview() {
    MyMealAppTheme(darkTheme = false) {
        ThemePreviewContent()
    }
}

@Preview(
    name = "Dark Mode",
    showBackground = true,
    device = "id:pixel_5",
    backgroundColor = 0xFF121212
)
@Composable
fun DarkThemePreview() {
    MyMealAppTheme(darkTheme = true) {
        ThemePreviewContent()
    }
}

// Common composable to render theme preview content
@Composable
fun ThemePreviewContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            "Theme Preview",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.displayLarge
        )

        Text(
            "Colors",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ColorBox(color = MaterialTheme.colorScheme.primary, label = "Primary")
            ColorBox(color = MaterialTheme.colorScheme.secondary, label = "Secondary")
            ColorBox(color = MaterialTheme.colorScheme.tertiary, label = "Tertiary")
            ColorBox(color = MaterialTheme.colorScheme.background, label = "Background")
            ColorBox(color = MaterialTheme.colorScheme.surface, label = "Surface")
        }

        Text("Container Colors", style = MaterialTheme.typography.titleLarge)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ColorBox(color = MaterialTheme.colorScheme.onPrimary, label = "On Primary")
            ColorBox(color = MaterialTheme.colorScheme.onSecondary, label = "On Secondary")
            ColorBox(color = MaterialTheme.colorScheme.onTertiary, label = "On Tertiary")
            ColorBox(color = MaterialTheme.colorScheme.onBackground, label = "On Background")
            ColorBox(color = MaterialTheme.colorScheme.onSurface, label = "On Surface")
        }

        Text("Typography", style = MaterialTheme.typography.titleLarge)
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                "Display Large", color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.displayLarge
            )
            Text(
                "Display Medium", color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.displayMedium
            )
            Text(
                "Display Small", color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.displaySmall
            )
            Text(
                "Title Large", color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                "Title Medium", color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                "Title Small", color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                "Body Large", color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                "Body Medium", color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                "Body Small", color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                "Label Large", color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.labelLarge
            )
            Text(
                "Label Medium", color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.labelMedium
            )
            Text(
                "Label Small", color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}

@Composable
fun ColorBox(color: Color, label: String) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .size(60.dp)
            .background(color)
            .border(BorderStroke(1.dp, Color.Gray), RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            label,
            color = if (color.luminance() > 0.5) Color.Black else Color.White,
            fontSize = 10.sp
        )
    }
}
