package com.the43h1.mymealapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter

/** Takes image individually as Parameter */
@Composable
fun CardView(
    onClick: () -> Unit = {},
    imageRes: Int,
    imageDesc: String,
    text: String = imageDesc,
    height: Dp = 200.dp,
    width: Dp = height * 4 / 5f, // for Aspect Ratio of 4:5
    size: DpSize = DpSize(width, height),
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(8.dp)
            .clickable { onClick() }
            .size(size)
            .clip(shape = MaterialTheme.shapes.medium)
            .background(color = MaterialTheme.colorScheme.primaryContainer)
            .padding(vertical = 16.dp, horizontal = 8.dp)
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = imageDesc,
            modifier = Modifier
                .weight(9f),
            contentScale = ContentScale.Fit,
            alignment = Alignment.Center
        )
        Text(
            text = text,
            modifier = Modifier.weight(1f),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}


/** Takes Category as Parameter */
@Composable
fun CardView(
    onClick: () -> Unit = {},
    category: Category,
    height: Dp = 200.dp,
    width: Dp = height * 4 / 5f, // for Aspect Ratio of 4:5
    size: DpSize = DpSize(width, height),
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(8.dp)
            .clickable { onClick() }
            .size(size)
            .clip(shape = MaterialTheme.shapes.medium)
            .background(color = MaterialTheme.colorScheme.primaryContainer)
            .padding(vertical = 16.dp, horizontal = 8.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(category.strCategoryThumb),
            contentDescription = category.strCategory,
            modifier = Modifier
                .weight(8f),
            contentScale = ContentScale.Fit,
            alignment = Alignment.Center
        )
        Text(
            text = category.strCategory,
            modifier = Modifier.weight(1f),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}