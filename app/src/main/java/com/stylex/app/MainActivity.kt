package com.stylex.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.stylex.app.data.UserRepository
import com.stylex.app.navigation.NavGraph
import com.stylex.app.navigation.Screen
import com.stylex.app.ui.splash.SplashScreen
import com.stylex.app.ui.theme.StyleXTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StyleXTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var showSplash by remember { mutableStateOf(true) }

                    if (showSplash) {
                        SplashScreen(
                            onSplashComplete = { showSplash = false }
                        )
                    } else {
                        val navController = rememberNavController()
                        val userRepository = UserRepository(this)

                        // Check if user is already logged in
                        val startDestination = if (userRepository.getCurrentUser() != null) {
                            Screen.Events.route
                        } else {
                            Screen.Auth.route
                        }

                        NavGraph(
                            navController = navController,
                            startDestination = startDestination
                        )
                    }
                }
            }
        }
    }
}