package com.pooyan.twittershowcase.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun TwitterShowCaseNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = "forYouNavigationRoute",
) {
    Text(text = "This is a header")

    Text(text = "This is a footer")
}