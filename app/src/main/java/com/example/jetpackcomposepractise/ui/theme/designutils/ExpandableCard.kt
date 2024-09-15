package com.example.jetpackcomposepractise.ui.theme.designutils

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.snap
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposepractise.ui.theme.BasicsCodelabTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpandableCard(title: String, description: String) {
    var expandedState by remember { mutableStateOf(false) }
    val rotationicon by animateFloatAsState(
        if (expandedState) 180f else 0f, label = "rotation"
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = snap(delayMillis = 600)
            ), shape = ShapeDefaults.Large,
        onClick = {
            expandedState = !expandedState
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {

            Row {
                Text(
                    modifier = Modifier.weight(1f),
                    text = title,
                    fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                IconButton(modifier = Modifier
                    .alpha(1f)
                    .rotate(rotationicon), onClick = {
                    expandedState = !expandedState
                }) {

                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "This is arrow down button"
                    )
                }
            }
            if (expandedState) {
                Text(
                    text = description, fontSize = MaterialTheme.typography.bodySmall.fontSize,
                    fontWeight = FontWeight.Bold,
                )

            }
        }
    }


}

@Preview
@Composable
fun Preview() {
    BasicsCodelabTheme {

        ExpandableCard("Hii roshan", "asofajf asfjasfkpaos asfapsfokasp agskfpoaksf asfapsof ")
    }
}