package com.areeb.passwordmanager.ui.addPassword

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.areeb.passwordmanager.R
import com.areeb.passwordmanager.data.models.entity.PmEntity
import com.areeb.passwordmanager.ui.addPassword.viewModels.AddDataViewModels
import com.areeb.passwordmanager.utils.navigations.routes.Routes.Companion.HOME
import com.areeb.passwordmanager.utils.statusColorChanger
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import java.util.Locale


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AddPasswordScreen(navHostController: NavHostController) {
    statusColorChanger(color = colorResource(id = R.color.blakish_grey))
    val systemUiController = rememberSystemUiController()
    systemUiController.isSystemBarsVisible = false
    Scaffold(
        content = {
            Screen(navHostController)
        }
    )
}

@Preview
@Composable
private fun Screen(navHostController: NavHostController) {
    val context = LocalContext.current
    var appName by remember {
        mutableStateOf("")
    }
    var loginEmail by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    val viewModel: AddDataViewModels = hiltViewModel()
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = colorResource(
                        id = R.color.greish_black,
                    ),
                ),
        ) {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(
                    text = "Add your Password",
                    modifier = Modifier
                        .wrapContentHeight()
                        .padding(start = 10.dp, top = 10.dp),
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 20.sp,
                )
            }

            Spacer(modifier = Modifier.padding(top = 30.dp))

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center,
            ) {
                Card(
                    modifier = Modifier
                        .width(80.dp)
                        .height(80.dp),
                    shape = RoundedCornerShape(12.dp),
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.password_icons),
                        contentDescription = "image",
                    )
                }
            }

            Spacer(modifier = Modifier.padding(top = 20.dp))
            Text(
                text = "App Name",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, top = 10.dp),
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                fontSize = 14.sp,
            )
            Spacer(modifier = Modifier.padding(top = 6.dp))
            TextField(
                value = appName,
                onValueChange = {
                    appName = it
                },
                textStyle = TextStyle(
                    fontSize = 16.sp,
                    color = colorResource(
                        id = R.color.white,

                        ),
                    fontWeight = FontWeight.SemiBold,
                ),
                modifier = Modifier
                    .imePadding()
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp, top = 20.dp),
            )
            Text(
                text = "login email",
                modifier = Modifier
                    .imePadding()
                    .fillMaxWidth()
                    .padding(start = 10.dp, top = 10.dp),
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                fontSize = 14.sp,
            )
            Spacer(modifier = Modifier.padding(top = 6.dp))
            TextField(
                value = loginEmail,
                onValueChange = {
                    loginEmail = it
                },
                textStyle = TextStyle(
                    fontSize = 16.sp,
                    color = colorResource(
                        id = R.color.white,

                        ),
                    fontWeight = FontWeight.SemiBold,
                ),
                modifier = Modifier
                    .imePadding()
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp, top = 20.dp),
            )
            Text(
                text = "password",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, top = 10.dp),
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                fontSize = 14.sp,
            )
            Spacer(modifier = Modifier.padding(top = 6.dp))
            TextField(
                value = password,
                onValueChange = {
                    password = it
                },
                textStyle = TextStyle(
                    fontSize = 16.sp,
                    color = colorResource(
                        id = R.color.white,

                        ),
                    fontWeight = FontWeight.SemiBold,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .imePadding()
                    .padding(start = 10.dp, end = 10.dp, top = 20.dp),

                )
            Spacer(modifier = Modifier.padding(top = 20.dp))
            Button(
                onClick = {
                    if (appName.isEmpty()) {
                        Toast.makeText(context, "app name should not be e", Toast.LENGTH_SHORT)
                            .show()
                    } else if (password.isEmpty()) {
                        Toast.makeText(context, "email should not be e", Toast.LENGTH_SHORT).show()
                    } else if (loginEmail.isEmpty()) {
                        Toast.makeText(context, "login should not be e", Toast.LENGTH_SHORT).show()
                    } else {
                        val pmEntity = PmEntity(
                            id = 0,
                            appName = appName,
                            loginEmail = loginEmail,
                            password = password
                        )
                        viewModel.addCredentials(
                            pmEntity
                        )

                        navHostController.navigate(HOME)
                    }


                },
                modifier = Modifier.padding(start = 10.dp, end = 10.dp),
            ) {
                Text(
                    text = "Save Crediantials",
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = colorResource(
                        id = R.color.white,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp)
                )
            }
        }
    }
}