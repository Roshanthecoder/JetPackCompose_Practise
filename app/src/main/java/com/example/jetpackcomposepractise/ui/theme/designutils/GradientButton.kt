package com.example.jetpackcomposepractise.ui.theme.designutils

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun GradientButton(
    text: String,
    textColor: Color,
    gradient: Brush,
    onClick: () -> Unit
) {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
        contentPadding = PaddingValues(),
        onClick = { onClick() })
    {
        Box(
            modifier = Modifier
                .background(gradient)
                .padding(horizontal = 50.dp, vertical = 30.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = text, color = textColor, fontSize = 16.sp)
        }
    }
}

@Preview
@Composable
fun PreviewButton() {

    GradientButton(
        "Hii Roshan", Color.White, Brush.horizontalGradient(
            colors = listOf(Color.Red, Color.Blue)
        )
    ) {
        Log.e("Roshan", "PreviewButton: Clicked")
    }
}