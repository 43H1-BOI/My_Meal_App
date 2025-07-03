import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp

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