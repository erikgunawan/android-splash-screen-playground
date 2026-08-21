package id.erikgunawan.splashscreenplayground.startup

data class CampaignData(
    val title: String,
    val ctaText: String,
)

data class CampaignStartupState(
    val campaign: CampaignData = CampaignData(
        title = "Merdeka! Promo Kemerdekaan",
        ctaText = "Lihat Promo",
    ),
    val isFinished: Boolean = false,
) {
    companion object {
        const val DURATION_MILLIS = 3_000L
    }
}
