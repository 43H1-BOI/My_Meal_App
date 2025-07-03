@file:OptIn(ExperimentalMaterial3Api::class)

package com.the43h1.mymealapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.the43h1.mymealapp.ui.theme.MyMealAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyMealAppTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(
                                    stringResource(R.string.app_name),
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        )
                    }
                ) { paddingValue ->
                    MainApp(paddingValue)
                }
            }
        }
    }
}

@Composable
fun MainApp(paddingValue: PaddingValues) {
    var viewModel: MainViewModel = viewModel()
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

@Composable
fun ErrorScreen(error: String?) {
    Text(
        buildAnnotatedString {
            withStyle(
                SpanStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp,
                )
            ) {
                append("Error Occurred : \n")
                withStyle(
                    style = SpanStyle(
                        color = Color.Red
                    )
                ) {
                    append(error)
                }
            }
        }
    )
}


/* Two Element View Created before LazyVerticalGrid
@Composable
fun TwoElementView(
    modifier: Modifier = Modifier,
    image1Res: Int,
    image1Desc: String,
    image2Res: Int,
    image2Desc: String,
    spacerModifier: Modifier = Modifier.width(16.dp)
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        CardView(
            imageRes = image1Res,
            imageDesc = image1Desc
        )

        Spacer(modifier = spacerModifier)

        CardView(
            imageRes = image2Res,
            imageDesc = image2Desc
        )
    }
}
*/

/* TempPreview
//@Preview
@Composable
private fun TempPreview() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(horizontal = 16.dp)
        ) {
            CardView(
                imageRes = R.drawable.beef,
                imageDesc = "Beef"
            )
            Spacer(modifier = Modifier.width(8.dp))
            CardView(
                imageRes = R.drawable.chicken,
                imageDesc = "Chicken"
            )
        }
    }
}
*/