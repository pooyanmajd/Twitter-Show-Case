package com.pooyan.twittershowcase.ui

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.pooyan.design.component.AppBackground
import com.pooyan.domain.network.NetworkMonitor
import com.pooyan.twittershowcase.R
import com.pooyan.twittershowcase.navigation.TwitterShowCaseNavHost

@OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalComposeUiApi::class,
    ExperimentalLayoutApi::class
)
@Composable
fun TwitterShowCaseApp(
    windowSizeClass: WindowSizeClass,
    networkMonitor: NetworkMonitor,
    userHasSelectedTwitterAccount: Boolean,
    appState: TwitterShowCaseAppState = rememberTwitterShowCaseAppState(
        windowSizeClass = windowSizeClass,
        networkMonitor = networkMonitor,
        userHasSelectedTwitterAccount = userHasSelectedTwitterAccount,
    )
) {
    AppBackground {
        val snackbarHostState = remember { SnackbarHostState() }
        val isOffline by appState.isOffline.collectAsStateWithLifecycle()

        // If user is not connected to the internet show a snack bar to inform them.
        val notConnectedMessage = stringResource(R.string.not_connected)
        LaunchedEffect(isOffline) {
            if (isOffline) {
                snackbarHostState.showSnackbar(
                    message = notConnectedMessage,
                    duration = SnackbarDuration.Indefinite,
                )
            }
        }

        val bottomPadding: Dp by animateDpAsState(
            if (snackbarHostState.currentSnackbarData != null) {
                32.dp
            } else {
                0.dp
            }
        )

        Scaffold(
            modifier = Modifier
                .semantics {
                    testTagsAsResourceId = true
                }
                .padding(bottom = bottomPadding),
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.onBackground,
            contentWindowInsets = WindowInsets(0, 0, 0, 0),
            snackbarHost = { SnackbarHost(snackbarHostState) }
        ) { padding ->
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .consumeWindowInsets(padding)
                    .windowInsetsPadding(WindowInsets.safeDrawing)
            ) {
                TwitterShowCaseNavHost(
                    navController = appState.navController,
                    startDestination = appState.destination
                )
            }
        }
    }
}