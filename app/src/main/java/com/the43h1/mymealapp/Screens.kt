package com.the43h1.mymealapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

sealed class Screens (val route : String){
    data object HomeScreen : Screens("home_screen")
    data object CategoriesScreen: Screens("categories_screen")
}

@Composable
fun HomeView(viewModel: MainViewModel) {
    TODO("Create This")
}