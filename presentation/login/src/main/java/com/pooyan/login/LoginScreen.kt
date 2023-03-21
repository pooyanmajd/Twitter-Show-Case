package com.pooyan.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.pooyan.design.component.AppBackground
import com.pooyan.design.component.DefaultButton
import com.pooyan.design.component.DefaultTopAppBar
import com.pooyan.design.theme.TwitterShowCaseTheme
import com.pooyan.ui.DevicePreviews

@Composable
internal fun LoginScreen(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = hiltViewModel(),
    onNavigateToTweets: () -> Unit
) {

    LoginScreenDetails(modifier = modifier, onNextClick = {
        viewModel.onTwitterNameSelected(it)
        onNavigateToTweets()
    })
}

@OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalComposeUiApi::class,
    ExperimentalLayoutApi::class
)
@Composable
internal fun LoginScreenDetails(
    modifier: Modifier,
    onNextClick: (String) -> Unit
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { DefaultTopAppBar(titleRes = R.string.twitter_show_case) },
        containerColor = Color.Transparent
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(
                    top = innerPadding.calculateTopPadding(),
                    start = 16.dp,
                    end = 16.dp,
                    bottom = innerPadding.calculateBottomPadding()
                )
                .consumeWindowInsets(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = modifier.padding(top = 16.dp),
                text = stringResource(R.string.twitter_account_title),
                style = MaterialTheme.typography.titleLarge,
            )

            var twitterName by rememberSaveable(stateSaver = TextFieldValue.Saver) {
                mutableStateOf(TextFieldValue())
            }
            val keyboardController = LocalSoftwareKeyboardController.current

            OutlinedTextField(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                    .testTag(stringResource(R.string.twitter_account_tag)),
                value = twitterName,
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                supportingText = {
                    Text(text = stringResource(R.string.default_twitter_account))
                },
                keyboardActions = KeyboardActions(onNext = {
                    onNextClick(twitterName.text)
                    keyboardController?.hide()
                }),
                placeholder = {
                    Text(text = stringResource(R.string.android_dev))
                },
                onValueChange = { twitterName = it },
                label = { Text(stringResource(R.string.twitter_name)) },
                maxLines = 1
            )

            DefaultButton(modifier = modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
                onClick = { onNextClick(twitterName.text) },
                text = {
                    Text(
                        text = stringResource(R.string.next),
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            )
        }
    }
}

@DevicePreviews
@Composable
fun LoginScreenDetailsPreview() {
    AppBackground {
        TwitterShowCaseTheme {
            LoginScreenDetails(modifier = Modifier, onNextClick = {})
        }
    }
}

