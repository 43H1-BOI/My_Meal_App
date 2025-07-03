package com.the43h1.mymealapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    // For State of Recipe ( is Loaded or Not and Data Inside it )
    data class RecipeState(
        var isLoading: Boolean = true,
        var list: List<Category> = emptyList(),
        var error: String? = null
    )

    // private variable for state of RecipeState
    // as the state changes recomposition occurs
    private var _categoryState = mutableStateOf(RecipeState())

    // reference of _categoryState
    var categoryState: State<RecipeState> = _categoryState

    // Runs at the time of Initialization
    init {
        fetchResponse()
    }

    // too fetch response from web
    private fun fetchResponse() {
        // Coroutine Scope for running Suspend Function inside
        viewModelScope.launch {
            // try..catch for exception handling
            try {
                // fetch response from web using retrofit object
                var response: CategoriesResponse = recipeServices.getCategories()

                // copying default values with some overriding
                _categoryState.value = _categoryState.value.copy(
                    isLoading = false,
                    list = response.categories
                    // above response contains CategoriesResponse Object which has categories list in it
                )
            } catch (e: Exception) {
                _categoryState.value = _categoryState.value.copy(
                    isLoading = false,
                    error = "Error Occurred : ${e.message}"
                )
            }
        }
    }
}