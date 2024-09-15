package com.example.jetpackcomposepractise

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposepractise.ui.theme.BasicsCodelabTheme
import com.example.jetpackcomposepractise.ui.theme.designutils.ExpandableCard
import com.example.jetpackcomposepractise.ui.theme.designutils.GoogleButton
import com.example.jetpackcomposepractise.ui.theme.designutils.InputDesign


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsCodelabTheme {
                //MyApp(modifier = Modifier.fillMaxSize())
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaterialTheme.colorScheme.inversePrimary)
                            .padding(10.dp),
                    ) {
                        item {
                            ExpandableCard(
                                "This is title set",
                                "this is description test allow me to perform \n kya samjhe re a sasda sdkada sdla dasl dasj dajk djlas dla sd \n akdaksdoaksdakdpapsda sdajkd akjd akjd \n"
                            )
                            InputDesign()
                            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                                GoogleButton(
                                    Modifier
                                        .fillMaxWidth(0.7f)
                                        .padding(top = 24.dp),
                                    text = "Sign Up with Click",
                                    "Wait a moment..",
                                    R.drawable.ic_google_logo,
                                    shape = ShapeDefaults.Medium,
                                    borderColor = Color.White,
                                    backgroundColor = MaterialTheme.colorScheme.primary,
                                    progressIndicatorColor = Color.White
                                ) {
                                    Log.e("rohan", "onCreate: button clicked")
                                }
                            }

                        }

                    }


                }
            }
        }
    }


}


@Composable
fun SuperScriptText(
    normalText: String,
    superText: String
) {

    Text(buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontSize = MaterialTheme.typography.titleLarge.fontSize
            )
        ) {
            append(normalText)
        }
        withStyle(
            style = SpanStyle(
                fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                fontWeight = FontWeight.Normal,
                baselineShift = BaselineShift.Superscript
            ),
        ) {

            append(superText)
        }
    })
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    BasicsCodelabTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            //  SuperScriptText("Hii ", "Roshan")
            ExpandableCard(
                "This is title set",
                "this is description test allow me to perform \n kya samjhe re a sasda sdkada sdla dasl dasj dajk djlas dla sd \n akdaksdoaksdakdpapsda sdajkd akjd akjd \n"
            )

        }
    }

}


@Composable
fun MyApp(modifier: Modifier = Modifier) {

    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }

    Surface(modifier, color = MaterialTheme.colorScheme.background) {
        if (shouldShowOnboarding) {
            OnboardingScreen(onContinueClicked = {
                shouldShowOnboarding = false
            })
        } else {
            Greetings()
        }
    }
}

@Composable
fun OnboardingScreen(
    onContinueClicked: () -> Unit,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to the Jetpack Compose!")
        Button(
            modifier = Modifier.padding(vertical = 24.dp),
            onClick = onContinueClicked
        ) {
            Text("Continue", style = MaterialTheme.typography.titleMedium)

        }
    }
}

@Composable
private fun Greetings(
    modifier: Modifier = Modifier,
    names: List<String> = List(1000) { "$it" }
) {
    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
        items(items = names) { name ->
            Greeting(name = name)
        }
        /*for (name in names) {
            Greeting(name = name)
        }*/
    }
}

@Composable
private fun Greeting(name: String) {

    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary),
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 4.dp)
    ) {
        CardContent(name)
    }

    /*    val expanded = rememberSaveable { mutableStateOf(false) }
        val extraPadding by animateDpAsState(if (expanded.value) 48.dp else 0.dp, animationSpec = spring(dampingRatio = Spring.DampingRatioHighBouncy, stiffness = Spring.StiffnessLow))

        Surface(
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
            shape = MaterialTheme.shapes.small,
            shadowElevation = 12.dp

        ) {
            Row(modifier = Modifier.padding(24.dp)) {
                Column(modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding.coerceAtLeast(0.dp))
                ) {
                    Text(text = "Hello, ")
                    Text(text = name, style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.ExtraBold))
                }
                ElevatedButton(
                    onClick = { expanded.value = !expanded.value
                        showToast("Show More...")  }
                ) {
                    Text(if (expanded.value) "Show less" else "Show more")
                }
            }
        }*/
}

@Composable
fun CardContent(name: String) {
    var expanded by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .padding(12.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessLow
                )
            )
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)
        ) {
            Text(text = "Hello, ")
            Text(
                text = name,
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.ExtraBold)
            )
            if (expanded) {
                Text(text = ("Hii My Name Is Roshan. \n" + "Suna apne baare me kuchh \n").repeat(4))
            }
        }
        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                contentDescription = if (expanded) {
                    stringResource(R.string.show_less)
                } else {
                    stringResource(R.string.show_more)
                }
            )

        }

    }


}


/*
@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    BasicsCodelabTheme {
        Greetings()
    }
}

@Preview
@Composable
fun MyAppPreview() {
    BasicsCodelabTheme {
        MyApp(Modifier.fillMaxSize())
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    BasicsCodelabTheme {
        OnboardingScreen(onContinueClicked = { })
    }
}*/
