package com.areeb.passwordmanager.ui.addPassword

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.areeb.passwordmanager.R
import com.areeb.passwordmanager.data.models.entity.PmEntity
import com.areeb.passwordmanager.ui.addPassword.viewModels.AddDataViewModels

@Composable
fun AddPasswordScreen(navHostController: NavHostController) {
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
            Text(
                text = "Add your Password",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, top = 10.dp),
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 24.sp,
            )
            Spacer(modifier = Modifier.padding(top = 20.dp))

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
                        painter = painterResource(id = R.drawable.ic_default_profile),
                        contentDescription = "image",
                    )
                }
            }

            Spacer(modifier = Modifier.padding(top = 10.dp))
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
                    val pmEntity = PmEntity(
                        id = 0,
                        appName = appName,
                        loginEmail = loginEmail,
                        password = password
                    )
                    viewModel.addCredentials(
                        pmEntity
                    )
                    
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
                        .padding(start = 10.dp, end = 10.dp),
                )
            }
        }
    }
}