package com.example.android101





import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android101.ui.theme.Android101Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Android101Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Android101WithText(message = "Happy birthday Edwin", from = "-from Emma")
                }
            }
        }
    }
}
@Composable
fun Android101WithImage(message: String, from: String){
    val image = painterResource(id = R.drawable.pexels_pixabay_45238)
    Box{
        Image(painter = image , contentDescription = null,
            modifier = Modifier.fillMaxHeight().fillMaxWidth(),
        contentScale = ContentScale.Crop
         )
        Android101WithText(message = message, from = from)
    }


}

@Composable
fun Android101WithText(message: String, from: String) {
    Column {


        Text(text = message,
            fontSize = 36.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.Start)
                .padding(start = 16.dp, top = 16.dp)

        )
        Text(text = from,
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth().wrapContentWidth(align = Alignment.End)
                .padding(start = 16.dp, end = 16.dp)

        )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Android101Theme {
        Android101WithImage(message = stringResource(R.string.happy_birthday_text) , from = "-from Emma")
    }
}