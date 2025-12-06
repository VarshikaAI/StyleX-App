package com.stylex.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.stylex.app.ui.auth.AuthScreen
import com.stylex.app.ui.events.EventsScreen
import com.stylex.app.ui.outfits.OutfitScreen
import com.stylex.app.ui.profile.ProfileScreen

sealed class Screen(val route: String) {
    object Auth : Screen("auth")
    object Events : Screen("events")
    object Outfit : Screen("outfit/{eventId}") {
        fun createRoute(eventId: String) = "outfit/$eventId"
    }
    object Profile : Screen("profile")
}

@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screen.Auth.route) {
            AuthScreen(
                onAuthSuccess = {
                    navController.navigate(Screen.Events.route) {
                        popUpTo(Screen.Auth.route) { inclusive = true }
                    }
                }
            )
        }

        composable(Screen.Events.route) {
            EventsScreen(
                onEventSelected = { eventId ->
                    navController.navigate(Screen.Outfit.createRoute(eventId))
                },
                onProfileClick = {
                    navController.navigate(Screen.Profile.route)
                }
            )
        }

        composable(Screen.Outfit.route) { backStackEntry ->
            val eventId = backStackEntry.arguments?.getString("eventId") ?: ""
            OutfitScreen(
                eventId = eventId,
                onBack = { navController.popBackStack() }
            )
        }

        composable(Screen.Profile.route) {
            ProfileScreen(
                onLogout = {
                    navController.navigate(Screen.Auth.route) {
                        popUpTo(0) { inclusive = true }
                    }
                },
                onBack = { navController.popBackStack() }
            )
        }
    }
}