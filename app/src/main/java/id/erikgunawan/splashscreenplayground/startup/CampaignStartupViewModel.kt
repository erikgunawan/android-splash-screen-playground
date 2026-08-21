package id.erikgunawan.splashscreenplayground.startup

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

private const val TAG = "StartupPerf"

class CampaignStartupViewModel : ViewModel() {

    private val _state = MutableStateFlow(CampaignStartupState())
    val state: StateFlow<CampaignStartupState> = _state.asStateFlow()

    init {
        Log.d(TAG, "CampaignStartup shown")
        viewModelScope.launch {
            delay(CampaignStartupState.DURATION_MILLIS)
            finish()
        }
    }

    fun onSkip() {
        finish()
    }

    private fun finish() {
        Log.d(TAG, "CampaignStartup finished")
        _state.update { it.copy(isFinished = true) }
    }
}
