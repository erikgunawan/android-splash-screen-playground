package id.erikgunawan.splashscreenplayground.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import id.erikgunawan.splashscreenplayground.home.HomeRoute
import id.erikgunawan.splashscreenplayground.startup.CampaignStartupRoute

private const val ROUTE_CAMPAIGN_STARTUP = "campaign_startup"
private const val ROUTE_HOME = "home"

@Composable
fun AppNavHost(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = ROUTE_CAMPAIGN_STARTUP) {
        composable(ROUTE_CAMPAIGN_STARTUP) {
            CampaignStartupRoute(
                onFinished = {
                    navController.navigate(ROUTE_HOME) {
                        popUpTo(ROUTE_CAMPAIGN_STARTUP) { inclusive = true }
                    }
                },
            )
        }
        composable(ROUTE_HOME) {
            HomeRoute()
        }
    }
}
