package com.the43h1.mymealapp.Components

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedIconButton(
    isOpened: DrawerState,
    onClick: () -> Unit = {},
    menuIcon: ImageVector,
    closeIcon: ImageVector
) {
    val rotation by animateFloatAsState(
        targetValue = if (isOpened.currentValue == DrawerValue.Open) 90f else 0f,
        label = "iconRotation"
    )

    Crossfade(
        targetState = isOpened.currentValue
    ) { state ->
        IconButton(
            onClick = {
                onClick()
            }
        ) {
            Icon(
                imageVector = when (state) {
                    DrawerValue.Closed -> menuIcon
                    DrawerValue.Open -> closeIcon
                },
                "Menu",
                modifier = Modifier.Companion
                    .size(30.dp)
                    .graphicsLayer {
                        rotationZ = rotation
                    },
                tint = MaterialTheme.colorScheme.onTertiaryContainer
            )
        }
    }
}