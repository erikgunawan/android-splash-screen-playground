package id.erikgunawan.splashscreenplayground

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class CampaignStartupFlowTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun skippingCampaignStartup_navigatesToHome() {
        composeTestRule.onNodeWithText("Lewati").assertExists()

        composeTestRule.onNodeWithText("Lewati").performClick()

        composeTestRule.onNodeWithText("Home").assertExists()
    }
}
