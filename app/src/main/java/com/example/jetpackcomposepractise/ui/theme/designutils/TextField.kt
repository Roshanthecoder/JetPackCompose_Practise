package com.example.jetpackcomposepractise.ui.theme.designutils

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposepractise.ui.theme.BasicsCodelabTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputDesign() {


    Column(
        modifier = Modifier.fillMaxWidth(1f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var text by remember { mutableStateOf("") }
        var visibility by remember { mutableStateOf(false) }

        val icon = if (visibility) Icons.Filled.VisibilityOff else Icons.Filled.Visibility

        OutlinedTextField(
            value = text,
            onValueChange = { newText -> text = newText },
            singleLine = true,
            shape = RoundedCornerShape(12.dp),

            trailingIcon = {
                IconButton(onClick = {
                    visibility = !visibility
                }) {
                    Icon(
                        imageVector = icon,
                        contentDescription = "This is eye button"
                    )
                }
            },
            leadingIcon = {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Default.Email, contentDescription = "Email")
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Go
            ),
            visualTransformation = if (visibility) VisualTransformation.None else PasswordVisualTransformation(),

            label = { Text("Enter Password Here") }

        )


    }

}


@Preview
@Composable
fun previewText() {

    BasicsCodelabTheme {

        InputDesign()
    }

}
