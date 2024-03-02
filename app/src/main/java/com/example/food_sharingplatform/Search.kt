package com.example.food_sharingplatform

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.food_sharingplatform.ui.theme.Green

@Composable
fun searchScreen(){
    Box(modifier = Modifier.fillMaxSize()){
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp, 20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            srow1()
            Spacer(modifier = Modifier.padding(0.dp,5.dp))
            srow2()
            Spacer(modifier = Modifier.padding(0.dp,20.dp))
            srow3()

        }
    }
}

@Composable
fun srow1(){
    Column {
        Text(text = "Search",
            fontStyle = FontStyle.Normal,
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.padding(0.dp,10.dp))
        SearchBar1(onSearch = { searchText ->
            // Perform search logic with searchText
        })
    }
}


@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SearchBar1(
    onSearch: (String) -> Unit
) {
    val textState = remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    TextField(
        value = textState.value,
        onValueChange = { newValue ->
            textState.value = newValue
            // Call onSearch with the new value when text changes
            onSearch(newValue)
        },
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray, CircleShape),
        placeholder = { Text("Search") },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(onSearch = {
            // Call onSearch when the search action is triggered
            onSearch(textState.value)
            keyboardController?.hide() // Hide the keyboard after search action
        }),
        leadingIcon = {
            IconButton(onClick = { /* Handle leading icon click */ }) {
                Icon(Icons.Default.Search, contentDescription = "Search")
            }
        },
        colors = TextFieldDefaults.textFieldColors(
//            backgroundColor = Color.White,
            cursorColor = Color.Black,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}@Composable
fun srow2(){
    Column {
        Spacer(modifier = Modifier.padding(0.dp,5.dp))
        SearchBar2(onSearch = { searchText ->
            // Perform search logic with searchText
        })
    }
}


@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SearchBar2(
    onSearch: (String) -> Unit
) {
    val textState = remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    TextField(
        value = textState.value,
        onValueChange = { newValue ->
            textState.value = newValue
            // Call onSearch with the new value when text changes
            onSearch(newValue)
        },
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray, CircleShape),
        placeholder = { Text("Current Location") },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(onSearch = {
            // Call onSearch when the search action is triggered
            onSearch(textState.value)
            keyboardController?.hide() // Hide the keyboard after search action
        }),
        leadingIcon = {
            IconButton(onClick = { /* Handle leading icon click */ }) {
                Icon(Icons.Default.LocationOn, contentDescription = "Search")
            }
        },
        colors = TextFieldDefaults.textFieldColors(
//            backgroundColor = Color.White,
            cursorColor = Color.Black,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun srow3(){
    Text(text = "searh history",
        modifier = Modifier.fillMaxWidth(),
        fontSize = 20.sp,
        textAlign = TextAlign.Left)
    history()
}
@Composable
fun history() {
    // List of categories
    val categories = listOf("Groceries", "Veggies", "Fruits", "Dairy", "Beverages")

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(categories.size) { index ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = categories[index],
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.Black
                    )
                }
            }
        }
    }
}