package id.erikgunawan.splashscreenplayground.startup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CampaignStartupRoute(
    onFinished: () -> Unit,
    viewModel: CampaignStartupViewModel = viewModel(),
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(state.isFinished) {
        if (state.isFinished) {
            onFinished()
        }
    }

    CampaignStartupContent(
        campaign = state.campaign,
        onSkip = viewModel::onSkip,
    )
}

@Composable
private fun CampaignStartupContent(
    campaign: CampaignData,
    onSkip: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1B5E20))
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = campaign.title,
            style = MaterialTheme.typography.headlineSmall,
            color = Color.White,
        )
        Button(onClick = onSkip, modifier = Modifier.padding(top = 24.dp)) {
            Text(text = campaign.ctaText)
        }
        TextButton(onClick = onSkip, modifier = Modifier.padding(top = 8.dp)) {
            Text(text = "Lewati", color = Color.White)
        }
    }
}
