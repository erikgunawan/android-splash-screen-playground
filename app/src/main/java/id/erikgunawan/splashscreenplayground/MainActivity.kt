package id.erikgunawan.splashscreenplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import id.erikgunawan.splashscreenplayground.nav.AppNavHost

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            SplashScreenPlaygroundApp(onCampaignStartupFinished = ::reportFullyDrawn)
        }
    }
}

@Composable
private fun SplashScreenPlaygroundApp(onCampaignStartupFinished: () -> Unit) {
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            AppNavHost(onCampaignStartupFinished = onCampaignStartupFinished)
        }
    }
}
