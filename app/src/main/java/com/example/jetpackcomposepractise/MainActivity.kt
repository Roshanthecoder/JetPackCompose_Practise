package com.example.jetpackcomposepractise

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposepractise.ui.theme.JetPackComposePractiseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            layout()
            content()
        }
    }
    @Composable
     fun content() {

    }

    @Composable
    @Preview
     fun layout() {
         Box(modifier = Modifier
             .fillMaxWidth(1f)
             .fillMaxHeight(1f), contentAlignment = Alignment.Center) {
             Text(text = "Hi Roshan", color = Color.Green, modifier = Modifier.align(Alignment.BottomStart), fontSize = 18.sp)
             Text(text = "Hi Roshan",color = Color.Black,modifier = Modifier.align(Alignment.TopEnd,), fontSize = 18.sp)
             Text(text = "Hi Roshan",color = Color.Blue,modifier = Modifier.align(Alignment.BottomCenter), fontSize = 18.sp)
             Text(text = "Hi Roshan",color = Color.Cyan,modifier = Modifier.align(Alignment.CenterStart), fontSize = 18.sp)
             Button(onClick = {
                 Toast.makeText(this,"Pressed",Toast.LENGTH_SHORT)
             }) {

             }
         }
    }
}
