package com.areeb.passwordmanager.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun statusColorChanger(color: Color) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor(color)
    }
}


interface StringConstant {
    companion object {
        const val PASSWORD_MANAGER_ENTITY = "passwordManagerEntity"
    }

}