@file:OptIn(ExperimentalMaterial3Api::class)

package com.the43h1.mymealapp

import ErrorScreen
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.the43h1.mymealapp.Components.CardView

@Composable
fun CategoriesView(
    viewModel: MainViewModel,
    paddingValue: PaddingValues,
    navController: NavHostController
) {
    var recipeState = viewModel.categoryState

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValue)
    ) {
        recipeState.value.apply {
            if (isLoading) {
                if (error != null) {
                    /** when error occurs */
                    ErrorScreen(error)
                } else {
                    /** when content is loading */
                    CircularProgressIndicator(modifier = Modifier.size(30.dp))
                }

            }
            /** Data Loaded Successfully */
            else {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier
                        .padding(8.dp)
                ) {
                    items(list) { item ->
                        CardView(category = item)
                    }
                }
            }
        }
    }
}