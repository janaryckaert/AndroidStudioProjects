package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Page(Modifier)
                }
            }
        }
    }
}

@Composable // Part 1
fun Header(modifier: Modifier = Modifier) {
    val header = painterResource(id = R.drawable.bg_compose_background)
    Image(
        painter = header,
        contentDescription = null,
        contentScale = ContentScale.FillWidth,
        modifier = Modifier
    )
}

@Composable  // Part 2
fun Title(titleText: String, modifier: Modifier = Modifier) {
    Text(
        text = titleText,
        fontSize = 24.sp,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable // Part 3
fun Introduction(introText: String, modifier: Modifier = Modifier) {
    Text(
        text = introText,
        textAlign = TextAlign.Justify,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable // Part 4
fun BodyText(bodyText: String, modifier: Modifier = Modifier) {
    Text(
        text = bodyText,
        textAlign = TextAlign.Justify,
        modifier = Modifier.padding(16.dp)
    )
}

// Build the whole page
@Composable
fun Page(modifier: Modifier = Modifier) {
    val titleText = "Jetpack Compose tutorial"
    val introText = "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs."
    val bodyText = "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name."
    Column(verticalArrangement = Arrangement.Top) {
        Header(
            modifier = Modifier)
        Title(
            titleText = titleText,
            modifier = Modifier)
        Introduction(
            introText = introText,
            modifier = Modifier)
        BodyText(
            bodyText = bodyText,
            modifier = Modifier)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeArticleTheme {
        Page(Modifier)
    }
}