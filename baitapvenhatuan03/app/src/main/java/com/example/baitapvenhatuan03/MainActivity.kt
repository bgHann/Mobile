package com.example.baitapvenhatuan03

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            homeScreen()
        }
    }
}

@Composable
fun homeScreen() {
    Surface(modifier = Modifier.fillMaxSize().padding(20.dp).background(Color.White)) {
        Column {
            headImage()
            Spacer(modifier = Modifier.size(40.dp))
            headTextFile()
            textFile()
            Spacer(modifier = Modifier.size(200.dp))
            myButton()
        }
    }

}



@Composable
fun headImage() {
    Image(
        painter = painterResource(R.drawable.anh),
        contentDescription = "ảnh",
        modifier = Modifier.fillMaxWidth().height(370.dp).padding(top = 150.dp),
    )
}

@Composable
fun myButton() {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Blue),
        modifier = Modifier.fillMaxWidth(),
    ) {
        Text("I'm ready")
    }
}

@Composable
fun headTextFile() {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp),
        text = "Jetpack Compose",
        fontSize = 25.sp,
        fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
        textAlign = TextAlign.Center
    )
}

@Composable
fun textFile() {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp),
        text = stringResource(id = R.string.text),
        fontSize = 17.sp,
        fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    homeScreen()
}
