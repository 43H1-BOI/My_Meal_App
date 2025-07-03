@file:OptIn(ExperimentalMaterial3Api::class)

package com.the43h1.mymealapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.the43h1.mymealapp.ui.theme.MyMealAppTheme

class MainActivity : ComponentActivity() {
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyMealAppTheme {
                viewModel = viewModel()


                var isOpened = rememberDrawerState(
                    initialValue = DrawerValue.Open
                )
                val rotation by animateFloatAsState(
                    targetValue = if (isOpened.currentValue == DrawerValue.Open) 90f else 0f,
                    label = "iconRotation"
                )

                var navController = rememberNavController()
                var coroutineScope = rememberCoroutineScope()

                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Row {
                                    Crossfade(
                                        targetState = isOpened.currentValue
                                    ) { state ->
                                        IconButton(onClick = {
                                            coroutineScope.launch {
                                                isOpened.apply {
                                                    if (isOpen) close() else open()
                                                }
                                            }
                                        }) {
                                            Icon(
                                                imageVector = when (state) {
                                                    DrawerValue.Closed -> Icons.Default.Menu
                                                    DrawerValue.Open -> Icons.Default.Close
                                                },
                                                "Menu",
                                                modifier = Modifier
                                                    .size(30.dp).graphicsLayer {
                                                        rotationZ = rotation
                                                    }
                                            )
                                        }
                                    }
                                    LogoView(modifier = Modifier.padding(top = 9.dp))
                                }
                            }
                        )
                    }
                ) { paddingValue ->
                    ModalNavigationDrawer(drawerContent = {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth(0.7f)
                                .fillMaxHeight()
                                .background(LightRed)
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

@Composable
fun LogoView(
    text1: String = "The",
    text2: String = "Meal",
    text3: String = "DB",
    fontSize: TextUnit = 26.sp,
    modifier: Modifier = Modifier
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
        fontWeight = FontWeight.Bold,
        fontSize = fontSize,
        modifier = modifier
    )
}