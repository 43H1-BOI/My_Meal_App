@file:OptIn(ExperimentalMaterial3Api::class)

package com.the43h1.mymealapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import com.the43h1.mymealapp.ui.theme.MyMealAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyMealAppTheme {
                MainView()
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