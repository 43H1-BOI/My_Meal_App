@file:OptIn(ExperimentalMaterial3Api::class)

package com.the43h1.mymealapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.the43h1.mymealapp.ui.theme.LightRed
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
                    initialValue = DrawerValue.Open
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
        modifier = modifier,
        color = MaterialTheme.colorScheme.onTertiaryContainer
    )
}


@Composable
fun AnimatedIconButton(
    isOpened: DrawerState,
    onClick: () -> Unit = {},
    menuIcon: ImageVector,
    closeIcon: ImageVector
) {
    val rotation by animateFloatAsState(
        targetValue = if (isOpened.currentValue == DrawerValue.Open) 90f else 0f,
        label = "iconRotation"
    )

    Crossfade(
        targetState = isOpened.currentValue
    ) { state ->
        IconButton(
            onClick = {
                onClick()
            }
        ) {
            Icon(
                imageVector = when (state) {
                    DrawerValue.Closed -> menuIcon
                    DrawerValue.Open -> closeIcon
                },
                "Menu",
                modifier = Modifier
                    .size(30.dp)
                    .graphicsLayer {
                        rotationZ = rotation
                    },
                tint = MaterialTheme.colorScheme.onTertiaryContainer
            )
        }
    }
}