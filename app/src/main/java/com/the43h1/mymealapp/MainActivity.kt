@file:OptIn(ExperimentalMaterial3Api::class)

package com.the43h1.mymealapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.the43h1.mymealapp.Components.AnimatedIconButton
import com.the43h1.mymealapp.Components.LogoView
import com.the43h1.mymealapp.Screen.CategoriesView
import com.the43h1.mymealapp.Screen.HomeView
import com.the43h1.mymealapp.Screen.Screens
import com.the43h1.mymealapp.ui.theme.MyMealAppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyMealAppTheme {
                viewModel = viewModel()

                var isOpened = rememberDrawerState(
                    initialValue = DrawerValue.Closed
                )

                var navController = rememberNavController()
                var coroutineScope = rememberCoroutineScope()

                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Row {
                                    AnimatedIconButton(isOpened, onClick = {
                                        coroutineScope.launch {
                                            isOpened.apply {
                                                if (isOpen) close() else open()
                                            }
                                        }
                                    }, Icons.Default.Menu, Icons.Default.Close)

                                    LogoView(modifier = Modifier.padding(top = 9.dp))
                                }
                            },
                            colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
                        )
                    }
                ) { paddingValue ->
                    ModalNavigationDrawer(drawerContent = {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth(0.7f)
                                .fillMaxHeight()
                                .background(MaterialTheme.colorScheme.tertiaryContainer)
                        ) {

                        }
                    }, drawerState = isOpened) {
                        NavHost(
                            navController = navController,
                            startDestination = Screens.HomeScreen.route
                        ) {
                            composable(Screens.HomeScreen.route) {
                                HomeView(
                                    viewModel,
                                    paddingValue,
                                    navController
                                )
                            }
                            composable(Screens.CategoriesScreen.route) {
                                CategoriesView(
                                    viewModel,
                                    paddingValue,
                                    navController
                                )
                            }
                        }
                    }
                }
            }
        }
    }
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

@Preview
@Composable
private fun TempPreview() {
    HomeView(
        viewModel = viewModel(),
        paddingValue = PaddingValues(10.dp),
        navController = rememberNavController()
    )
}