package com.pooyan.login

import androidx.activity.ComponentActivity
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

internal class LoginScreenTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun clickingNextButton_callsOnNextClick() {
        composeTestRule.setContent {
            LoginScreenDetails(
                modifier = Modifier,
                onNextClick = {}
            )
        }

        // Find the "Next" button and click it
        composeTestRule.onNodeWithText(composeTestRule.activity.resources.getString(R.string.next))
            .performClick()
            .assertExists()
            .assertIsEnabled()
            .assertHasClickAction()
    }

    @Test
    fun clickingNextButton_updatesTwitterName() {
        var twitterName: String? = null

        val onNextClick: (String) -> Unit = { name -> twitterName = name }
        composeTestRule.setContent {
            LoginScreenDetails(
                modifier = Modifier,
                onNextClick = onNextClick
            )
        }
        val selectedInput = "@AndroidJack"

        composeTestRule.onNodeWithTag(composeTestRule.activity.resources.getString(R.string.twitter_account_tag))
            .performTextInput(selectedInput)

        composeTestRule.onNodeWithText(composeTestRule.activity.resources.getString(R.string.next))
            .performClick()

        assertEquals(selectedInput, twitterName)
    }
}