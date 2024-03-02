package com.example.food_sharingplatform

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.food_sharingplatform.ui.theme.Green

@Composable
fun homeScreen(){
Box(modifier = Modifier.fillMaxSize()){
Column(modifier = Modifier
    .fillMaxSize()
    .padding(10.dp, 20.dp)
    .align(Alignment.Center),) {
    Row1()
    Spacer(modifier = Modifier.padding(0.dp,20.dp))
    Row2()
    Spacer(modifier = Modifier.padding(0.dp,20.dp))
    row3()
    Spacer(modifier = Modifier.padding(0.dp,20.dp))
    row4()

}
}
}

@Composable
fun Row1() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Hi, Amar",
            fontSize = 26.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            imageVector = Icons.Default.Notifications,
            contentDescription = "Notification Icon"
        )
    }
}

@Composable
fun Row2(){
    Column {
        Text(text = "What are you looking for?")
        Spacer(modifier = Modifier.padding(0.dp,10.dp))
        SearchBar(onSearch = { searchText ->
            // Perform search logic with searchText
        })
    }
}

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
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
}

@Composable
fun row3(){
    Column {
        Text(text = "Category")
    }
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ImageCard(
            imageResId = R.drawable.fish,
            contentDescription = "Fish"
        )
        ImageCard(
            imageResId = R.drawable.fish,
            contentDescription = "Fish"
        )
        ImageCard(
            imageResId = R.drawable.fish,
            contentDescription = "Fish"
        )

    }
}

@Composable
fun ImageCard(
    imageResId: Int,
    contentDescription: String = "Description of your image",
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(8.dp)
) {
    Card(
//        modifier = modifier.padding(15.dp,0.dp),
        shape = shape
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = contentDescription,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .width(120.dp)
                .height(100.dp)
        )
    }
}

@Composable
fun row4() {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Last Chance")
            Text(text = "See all")
        }
        Spacer(modifier = Modifier.height(8.dp)) // Add some space between the Row and ScrollView
        HorizontalCardList()
    }
}

@Composable
fun HorizontalCardList() {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        content = {
            items(10) { index ->
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .width(250.dp)
                        .height(250.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.fish), // Replace with your image resource
                            contentDescription = "Image $index",
                            modifier = Modifier.size(100.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = "Item $index", color = Color.Black)
                    }
                }
            }
        }
    )
}
