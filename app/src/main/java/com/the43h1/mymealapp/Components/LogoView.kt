package com.the43h1.mymealapp.Components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.the43h1.mymealapp.ui.theme.LightRed

@Composable
fun LogoView(
    text1: String = "The",
    text2: String = "Meal",
    text3: String = "DB",
    fontSize: TextUnit = 26.sp,
    modifier: Modifier = Modifier.Companion
) {
    Text(
        buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = LightRed
                )
            ) {
                append(text1)
            }
            append(text2)
            withStyle(style = SpanStyle(color = LightRed)) {
                append(text3)
            }
        },
        fontWeight = FontWeight.Companion.Bold,
        fontSize = fontSize,
        modifier = modifier,
        color = MaterialTheme.colorScheme.onTertiaryContainer
    )
}