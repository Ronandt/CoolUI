package com.example.coolui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ListItem
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.coolui.ui.theme.CoolUITheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navState = rememberNavController()
            CoolUITheme {
                NavHost(navController = navState, startDestination = "contacts") {
                    composable("contacts") {
                        ContactsScreen()
                    }
                }
                // A surface container using the 'background' color from the theme

                    //ListItem(icon = {Icon(Icons.Default.Menu, "Menu")}, text ={Text("This is the text")}, secondaryText = {Text("Secondarywefoijfowjiofjiofjweiofjwiofjweiofwwefwfwefwe")}, singleLineSecondaryText = false, trailing = {Text("BOI")}, )

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoolUITheme {
        Greeting("Android")
    }
}

