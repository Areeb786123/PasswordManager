package com.areeb.passwordmanager.ui.pinScreen

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.areeb.passwordmanager.R
import com.areeb.passwordmanager.ui.setUpScreen.viewModels.AuthViewModels
import com.areeb.passwordmanager.utils.navigations.routes.Routes.Companion.HOME
import com.areeb.passwordmanager.utils.sharedPreferences.GetSharedPreferences
import com.areeb.passwordmanager.utils.statusColorChanger
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AddPinScreen(navHostController: NavHostController) {

    statusColorChanger(color = Color.Black)
    Body(navHostController = navHostController)

}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview
@Composable
private fun Body(navHostController: NavHostController) {
    val context = LocalContext.current
    val authViewModels: AuthViewModels = hiltViewModel()
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw._sec))
    val redirectUser by remember {
        mutableStateOf(false)
    }
    val currentUser = authViewModels.currentUser.collectAsState()
    Spacer(modifier = Modifier.padding(top = 80.dp))
    var pin by remember {
        mutableStateOf("")
    }
    Scaffold(content = {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black)
        ) {
            Spacer(modifier = Modifier.padding(top = 20.dp))
            LottieAnimation(
                composition = composition,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp), contentAlignment = Alignment.Center
            ) {
                Spacer(modifier = Modifier.padding(top = 80.dp))
                Text(
                    text = "Enter your Creds ",
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 24.sp
                )
                Spacer(modifier = Modifier.padding(top = 20.dp))

            }
            Spacer(modifier = Modifier.padding(top = 20.dp))

            PinSection(pin = pin, onValueChange = {
                pin = it
            })

            if (currentUser.value?.userName?.isNotEmpty() == true) {
                RedirectUser(authViewModels, context, navHostController)
            }
        }
    }, floatingActionButton = {
        FloatingActionButton(onClick = {
            if (pin.isEmpty()) {
                Toast.makeText(context, "pin is empty", Toast.LENGTH_SHORT).show()
            } else {
                if (pin.toInt() == GetSharedPreferences.getPin(context)) {
                    authViewModels.getCurrentUser(
                        GetSharedPreferences.getPhoneNumber(context = context).toString()
                    )
                } else {
                    Toast.makeText(context, "wrong pin", Toast.LENGTH_SHORT).show()
                }
            }

        }) {
            Image(
                painter = painterResource(id = R.drawable.outline_arrow_forward_24),
                contentDescription = "image"
            )
        }
    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PinSection(pin: String, onValueChange: (pin: String) -> Unit) {
    TextField(
        value = pin.take(4),
        onValueChange = {
            onValueChange(it)
        },
        placeholder = { Text(text = "Enter your saved Pin", color = Color.White) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp),
        leadingIcon = {
            Image(
                painter = painterResource(id = R.drawable.ic_password),
                contentDescription = "image"
            )
        },
        textStyle = TextStyle(color = Color.White, fontSize = 24.sp)
    )
}

@Composable
private fun RedirectUser(
    authViewModels: AuthViewModels,
    context: Context,
    navHostController: NavHostController
) {
    Log.e("chch", "redirect was called")
    val job = rememberCoroutineScope()
    val currentUser = authViewModels.currentUser.collectAsState()
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.padding(top = 40.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = "welcome  ${currentUser.value?.userName.toString()}",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
        }
    }


    // Coroutine scope to handle navigation with delay
    val coroutineScope = rememberCoroutineScope()

    // Launch a coroutine with delay before navigating
    LaunchedEffect(Unit) {
        coroutineScope.launch {
            delay(600) // Delay for 500 milliseconds
            navHostController.navigate(HOME) // Navigate to HOME destination
        }
    }


}