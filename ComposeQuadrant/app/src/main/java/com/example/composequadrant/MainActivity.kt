package com.example.composequadrant

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    FullPage(Modifier)
                }
            }
        }
    }
}

@Composable
fun Quadrant(title: String, body: String, background: Color, modifier: Modifier) {
    Box(
        modifier = modifier
            .background(color = background)
            .padding(16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center)  {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = body,
                    textAlign = TextAlign.Justify
                )
        }
    }
}

@Composable
fun FullPage(modifier: Modifier) {
    val quadrantWidth = 0.5 * LocalConfiguration.current.screenWidthDp
    val quadrantHeight = 0.5 * LocalConfiguration.current.screenHeightDp
    modifier.width(quadrantWidth.dp)
    modifier.height(quadrantHeight.dp)
    Column() {
        Row() {
            //Block 1
            Quadrant(
                title = stringResource(id = R.string.title1),
                body = stringResource(id = R.string.body1),
                background = colorResource(id = R.color.color1),
                modifier = modifier
            )
            //Block 2
            Quadrant(
                title = stringResource(id = R.string.title2),
                body = stringResource(id = R.string.body2),
                background = colorResource(id = R.color.color2),
                modifier = modifier
            )
        }
        Row() {
            //Block 3
            Quadrant(
                title = stringResource(id = R.string.title3),
                body = stringResource(id = R.string.body3),
                background = colorResource(id = R.color.color3),
                modifier = modifier
            )
            //Block 4
            Quadrant(
                title = stringResource(id = R.string.title4),
                body = stringResource(id = R.string.body4),
                background = colorResource(id = R.color.color4),
                modifier = modifier
            )
        }
    }
}
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeQuadrantTheme {
        FullPage(Modifier)
    }
}