package com.the43h1.mymealapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.the43h1.mymealapp.ui.theme.MyMealAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyMealAppTheme {
                MainApp()
            }
        }
    }
}

@Preview
@Composable
fun MainApp() {
    var viewModel: MainViewModel = viewModel()
    var recipeState = viewModel.categoryState

    Surface {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            if (!recipeState.value.isLoading) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    recipeState.value.apply {
                        if (error != null) { // when error occurs
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
                        } else { // when content is loading
                            CircularProgressIndicator(modifier = Modifier.size(30.dp))
                        }
                    }
                }
            } else {
                LazyColumn {
                    items(recipeState.value.list) { items ->
                        Row(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                            TODO("Create this with name and image")
                        }
                    }
                }
            }
        }
    }
}


@Preview
@Composable
private fun TempPreview() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
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


@Composable
fun CardView(
    onClick: () -> Unit = {},
    imageRes: Int,
    imageDesc: String,
    text: String = imageDesc
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .height(180.dp)
            .clip(MaterialTheme.shapes.medium)
            .background(MaterialTheme.colorScheme.background)
            .padding(vertical = 16.dp, horizontal = 8.dp)
            .clickable{onClick()}
    ) {
        Image(
            painter = painterResource(imageRes),
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
            overflow = TextOverflow.Ellipsis
        )
    }
}