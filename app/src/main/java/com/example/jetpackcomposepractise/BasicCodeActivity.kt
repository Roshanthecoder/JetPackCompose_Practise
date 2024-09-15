package com.example.jetpackcomposepractise

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class BasicCodeActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            roshan()

            /*MessageCard(
                Message(
                    "Android",
                    "Hey How Are You .. Hindi me bata sakta.. Chal Kal Milta hoon"
                )
            )*/
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun roshan() {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                text = "Welcome back!",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = "",
                onValueChange = {},
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth(0.8f)
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = "",
                onValueChange = {},
                label = { Text("Password") },
                modifier = Modifier.fillMaxWidth(0.8f),
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth(0.8f)
            ) {
                Text("Login")
            }
        }
    }
}

/*

    data class Message(val author: String, val body: String)


    @OptIn(ExperimentalMaterial3Api::class)
    @Preview
    @Composable
    fun SearchBar(modifier: Modifier = Modifier) {
        TextField(
            value = "",
            onValueChange = {},
            modifier = modifier
                .fillMaxWidth()
                .heightIn(min = 56.dp))
    }
}

*/
/*@Composable
fun MessageCard(msg: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            modifier = Modifier
                .size(size = 60.dp)
                .clip(CircleShape)
                .border(1.dp, MaterialTheme.colorScheme.primary, CircleShape)
        )
        Spacer(
            modifier = Modifier
                .width(8.dp)
                .height(8.dp)
        )
        Column() {
            Text(msg.author, modifier = Modifier.clickable {
                showToast(applicationContext)
            }, style = MaterialTheme.typography.titleSmall)
            Spacer(modifier = Modifier.height(8.dp))

            Surface(
                shape = MaterialTheme.shapes.extraSmall,
                shadowElevation = 4.dp,
                modifier = Modifier.clickable { showToast(applicationContext) }) {
                Text(
                    msg.body,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(all = 8.dp)
                )
            }


        }
    }
}

@Composable
fun conversation(messages: List<Message>) {
    LazyColumn() {
        items(messages) { message ->
            MessageCard(msg = message)
        }
    }
}*//*


fun showToast(context: Context) {
    Toast.makeText(context, "You Pressed Me", Toast.LENGTH_SHORT).show()
}


//        @Composable
//        fun MessageCard(msg: Message) {
//            Row {
//                Text(text = msg.author+"\n")
//                Text(text = msg.body)
//                Text(text = msg.author)
//                Text(text = msg.body)
//                Text(text = msg.author)
//                Text(text = msg.body)
//            }
//
//        }
@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
*/
/*@Composable
fun PreviewMessageCard() {
    MessageCard(
        msg = Message("Lexi", " Hey How Are You .. Hindi me bata sakta ")
    )
}*//*


*/
