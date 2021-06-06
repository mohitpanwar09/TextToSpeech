package com.example.texttospeeach_01

import android.os.Bundle
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.texttospeeach_01.ui.theme.TextToSpeeach_01Theme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var textFieldState by remember{
                mutableStateOf("")
            }
            val scopeC= rememberCoroutineScope()
            val scaffoldState= rememberScaffoldState()
            Scaffold(modifier = Modifier.fillMaxSize(),
                scaffoldState = scaffoldState
                ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally ,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 30.dp)
                ) {
                    TextField(
                        value = textFieldState,
                        label = {
                            Text(text = "Enter Word")
                        },
                        onValueChange = {
                            textFieldState=it
                        },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = {
                        /*TODO*/
                        scopeC.launch {
                            scaffoldState.snackbarHostState.showSnackbar("$textFieldState")
                        }

                    }) {
                        Text("Speak!")
                    }
                }

            }
            TextToSpeeach_01Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
//                    Greeting("Android")
                }
            }

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
    TextToSpeeach_01Theme {
        Greeting("Android")
    }
}