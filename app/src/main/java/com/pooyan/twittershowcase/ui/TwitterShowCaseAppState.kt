package com.pooyan.twittershowcase.ui

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.pooyan.dev.tweet.TweetsRoute
import com.pooyan.domain.network.NetworkMonitor
import com.pooyan.login.LoginRoute
import com.pooyan.twittershowcase.MainActivityUiState
import com.pooyan.ui.TrackDisposableJank
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn


@Composable
fun rememberTwitterShowCaseAppState(
    windowSizeClass: WindowSizeClass,
    networkMonitor: NetworkMonitor,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController(),
    userHasSelectedTwitterAccount: Boolean,
): TwitterShowCaseAppState {
    NavigationTrackingSideEffect(navController)
    return remember(windowSizeClass, navController, userHasSelectedTwitterAccount) {
        TwitterShowCaseAppState(windowSizeClass, navController, coroutineScope, networkMonitor, userHasSelectedTwitterAccount)
    }
}

@Stable
class TwitterShowCaseAppState(
    val windowSizeClass: WindowSizeClass,
    val navController: NavHostController,
    coroutineScope: CoroutineScope,
    networkMonitor: NetworkMonitor,
    userHasSelectedTwitterAccount: Boolean,
) {
    val isOffline = networkMonitor.isOnline
        .map(Boolean::not)
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = false,
        )

    val destination = if (userHasSelectedTwitterAccount) TweetsRoute else LoginRoute
}

/**
 * Stores information about navigation events to be used with JankStats
 */
@Composable
private fun NavigationTrackingSideEffect(navController: NavHostController) {
    TrackDisposableJank(navController) { metricsHolder ->
        val listener = NavController.OnDestinationChangedListener { _, destination, _ ->
            metricsHolder.state?.putState("Navigation", destination.route.toString())
        }

        navController.addOnDestinationChangedListener(listener)

        onDispose {
            navController.removeOnDestinationChangedListener(listener)
        }
    }
}