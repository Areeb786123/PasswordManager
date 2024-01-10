package com.areeb.passwordmanager.utils.navigations.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.areeb.passwordmanager.ui.addPassScreen.AddPassScreen
import com.areeb.passwordmanager.ui.home.screens.Home
import com.areeb.passwordmanager.ui.setUpScreen.SetUpScreen
import com.areeb.passwordmanager.ui.settings.screens.Settings
import com.areeb.passwordmanager.ui.splash.screens.Splash
import com.areeb.passwordmanager.utils.navigations.routes.Routes.Companion.ADD_PASS_SCREEN
import com.areeb.passwordmanager.utils.navigations.routes.Routes.Companion.HOME
import com.areeb.passwordmanager.utils.navigations.routes.Routes.Companion.SETTINGS
import com.areeb.passwordmanager.utils.navigations.routes.Routes.Companion.SETUP_SCREEN
import com.areeb.passwordmanager.utils.navigations.routes.Routes.Companion.SPLASH

@Composable
fun Navigation(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = HOME) {
        composable(HOME) {
            Home(navHostController = navHostController)
        }

        composable(SPLASH) {
            Splash(navHostController = navHostController)
        }

        composable(SETTINGS) {
            Settings(navHostController = navHostController)
        }

        composable(SETUP_SCREEN) {
            SetUpScreen(navHostController = navHostController)
        }
    }
}
