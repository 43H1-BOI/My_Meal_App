package com.the43h1.mymealapp.Screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.the43h1.mymealapp.MainViewModel
import com.the43h1.mymealapp.ui.theme.LightRed

@Composable
fun HomeView(
    viewModel: MainViewModel,
    paddingValue: PaddingValues,
    navController: NavHostController
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Companion.CenterHorizontally,
        modifier = Modifier.Companion
            .padding(paddingValue)
            .fillMaxSize()
            .clickable {
                navController.navigate(Screens.CategoriesScreen.route)
            }
    ) {
        Text(
            buildAnnotatedString {
                append("Welcome to \n")
                withStyle(
                    style = SpanStyle(
                        color = LightRed
                    )
                ) {
                    append("The")
                }
                append("Meal")
                withStyle(style = SpanStyle(color = LightRed)) {
                    append("DB")
                }
            },
            fontWeight = FontWeight.Companion.Bold,
            fontSize = 32.sp,
            lineHeight = 32.sp
        )

    }
}