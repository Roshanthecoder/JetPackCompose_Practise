package com.example.jetpackcomposepractise.ui.theme.designutils

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.jetpackcomposepractise.R

@Composable
fun CoilImage() {
    val grayscaleMatrix = ColorMatrix().apply {
        setToSaturation(0f) // Set saturation to 0 to make the image grayscale
    }

    Box(
        modifier = Modifier.size(100.dp), // Adjusted size for visualization
        contentAlignment = Alignment.Center
    ) {
        val painter = rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://th.bing.com/th/id/OIP.vV7JR7eGaRUwzAbFcYFzkAHaHa?rs=1&pid=ImgDetMain")
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_google_logo)
                .crossfade(true) // Enable crossfade animation
                .build()
        )
        val painterState = painter.state

        Image(
            painter = painter,
            contentDescription = "Logo image",
            contentScale = ContentScale.Crop, // Use Crop to fill the rounded shape
            modifier = Modifier
                .size(100.dp) // Adjusted size for better visualization
                .clip(CircleShape), // Clip the image to a circle shape
            colorFilter = ColorFilter.colorMatrix(grayscaleMatrix) // Apply grayscale filter
        )

        if (painterState is AsyncImagePainter.State.Loading) {
            CircularProgressIndicator()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCoilImage() {
    CoilImage()
}

