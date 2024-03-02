package com.example.food_sharingplatform

sealed class Screen(val screen: String) {
    object HomeScreen : Screen("home")
    object Search : Screen("search")
    object Profile : Screen("profile")
    object Message : Screen("message")
    object List : Screen("list")
}
