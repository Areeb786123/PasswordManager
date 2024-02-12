package com.areeb.passwordmanager.ui.splash.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.areeb.passwordmanager.R
import com.areeb.passwordmanager.ui.setUpScreen.viewModels.AuthViewModels
import com.areeb.passwordmanager.utils.navigations.routes.Routes
import com.areeb.passwordmanager.utils.statusColorChanger
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun Splash(navHostController: NavHostController) {
    statusColorChanger(color = colorResource(id = R.color.black))
    val systemUiController = rememberSystemUiController()
    systemUiController.isSystemBarsVisible = false
    SplashScreen(navHostController = navHostController)
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SplashScreen(navHostController: NavHostController) {
    val viewModels: AuthViewModels = hiltViewModel()

    val currentUser by viewModels.user.collectAsState()

    var screenToNavigate by remember {
        mutableStateOf("")
    }
    val isnavigateAllowed = viewModels.isNavigateAllowed.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.black)), contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "image",
            modifier = Modifier
                .width(100.dp)
                .height(100.dp), // Add your modifier here if needed
            tint = androidx.compose.ui.graphics.Color.White
        )

        Log.e("ccA", "${currentUser?.userName}")

        LaunchedEffect(Unit) {
            withContext(Dispatchers.Main) {
                delay(1000)
                screenToNavigate = if (currentUser?.userName == null) {
                    Routes.SETUP_SCREEN
                } else {
                    Routes.ADD_PIN
                }
                navHostController.navigate(screenToNavigate)

            }
        }
    }
}
