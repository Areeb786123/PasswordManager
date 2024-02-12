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
        const val SHARED_PREFERENCES = "shared_preferences"
        const val PIN  = "pin"
        const val PHONE_NUMBER  = "phone_number"
    }

}