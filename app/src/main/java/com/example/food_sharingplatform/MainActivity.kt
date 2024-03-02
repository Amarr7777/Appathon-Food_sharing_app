package com.example.food_sharingplatform

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.food_sharingplatform.ui.theme.FoodsharingPlatformTheme
import com.example.food_sharingplatform.ui.theme.Green


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodsharingPlatformTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyBottomAppBar()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBottomAppBar(){
    val navigationController = rememberNavController()
    val context = LocalContext.current.applicationContext
    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }
    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = Green
            ) {
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Home
                        navigationController.navigate(Screen.HomeScreen.screen){
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(Icons.Default.Home, contentDescription = null, modifier = Modifier.size(26.dp),
                        tint = if(selected.value == Icons.Default.Home) Color.White else Color.DarkGray)
                }
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Search
                        navigationController.navigate(Screen.Search.screen){
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(Icons.Default.Search, contentDescription = null, modifier = Modifier.size(26.dp),
                        tint = if(selected.value == Icons.Default.Search) Color.White else Color.DarkGray)
                }
               Box(modifier = Modifier
                   .weight(1f)
                   .padding(16.dp),
                   contentAlignment = Alignment.Center){
                   FloatingActionButton(onClick = { }) {
                       Toast.makeText(context,"open",Toast.LENGTH_LONG).show()
                   }
                   Icon(Icons.Default.Add, contentDescription = null, tint = Green)
               }
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.List
                        navigationController.navigate(Screen.List.screen){
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(Icons.Default.List, contentDescription = null, modifier = Modifier.size(26.dp),
                        tint = if(selected.value == Icons.Default.List) Color.White else Color.DarkGray)
                }
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Person
                        navigationController.navigate(Screen.Profile.screen){
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(Icons.Default.Person, contentDescription = null, modifier = Modifier.size(26.dp),
                        tint = if(selected.value == Icons.Default.Person) Color.White else Color.DarkGray)
                }

            }
        }
    ) {paddingValues ->
    NavHost(navController = navigationController, startDestination = Screen.HomeScreen.screen,
        modifier = Modifier.padding(paddingValues)){
        composable(Screen.HomeScreen.screen){ homeScreen()}
        composable(Screen.Search.screen){ searchScreen() }
        composable(Screen.List.screen){ listScreen() }
        composable(Screen.Profile.screen){ profileScreen() }
    }
    }
}