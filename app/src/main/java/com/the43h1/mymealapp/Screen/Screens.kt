package com.the43h1.mymealapp.Screen

sealed class Screens(val route: String) {
    data object HomeScreen : Screens("home_screen")
    data object CategoriesScreen : Screens("categories_screen")
}