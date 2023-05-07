package com.example.composetaskmanager

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetaskmanager.ui.theme.ComposeTaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTaskManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CompleteScreen(modifier = Modifier)
                }
            }
        }
    }
}

@Composable // part 1
fun Checkmark(modifier: Modifier = Modifier) {
    val checkmark = painterResource(id = R.drawable.ic_task_completed)
    Image(
        painter = checkmark,
        contentDescription = null,
        modifier = modifier)
}

@Composable // Part 2
fun TaskCompleteText(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(id = R.string.completeText),
        fontWeight = FontWeight.Bold,
        modifier = modifier.padding(
                            top = 24.dp,
                            bottom = 8.dp)
    )
}

@Composable // Part 3
fun SubText(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(id = R.string.subCompleteText),
        fontSize = 16.sp,
        modifier = modifier
    )
}

@Composable // Final
fun CompleteScreen(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Checkmark(modifier = modifier)
        TaskCompleteText(modifier = modifier)
        SubText(modifier = modifier)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTaskManagerTheme {
        CompleteScreen(modifier = Modifier)
    }
}