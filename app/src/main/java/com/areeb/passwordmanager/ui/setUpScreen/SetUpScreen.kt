package com.areeb.passwordmanager.ui.setUpScreen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.areeb.passwordmanager.R
import com.areeb.passwordmanager.data.models.entity.UserEntity
import com.areeb.passwordmanager.ui.setUpScreen.viewModels.AuthViewModels
import com.areeb.passwordmanager.utils.navigations.routes.Routes.Companion.HOME
import androidx.compose.foundation.layout.Column as Column

@Composable
fun SetUpScreen(navHostController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.dark_blue)),
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_girl),
            contentDescription = "image",
            modifier = Modifier.wrapContentSize().wrapContentHeight().align(Alignment.TopCenter),
        )

        Body(navHostController = navHostController)
    }
}

@Preview
@Composable
private fun Body(navHostController: NavHostController) {
    val homeViewModels: AuthViewModels = hiltViewModel()
    var text by remember { mutableStateOf(TextFieldValue("")) }
    var otp by remember { mutableStateOf("") }
    var confirmOtp by remember { mutableStateOf("") }
    var isButtonClicked by remember {
        mutableStateOf(false)
    }

    Card(
        modifier = Modifier
            .fillMaxSize().padding(top = 60.dp),
        shape = CardDefaults.shape,
        colors = CardDefaults.cardColors(colorResource(id = R.color.black)),
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            HeaderSection()
            ImageSection()
            InputSection(
                text = text,
                onValueChange = { text = it },
                placeholder = "username",
                leadingIcon = R.drawable.ic_person,
            )
            PinSection(otp = otp, onValueChange = { otp = it }, label = "Set Pin")
            PinSection(otp = confirmOtp, onValueChange = { confirmOtp = it }, label = "Confirm Pin")
            FingerprintSection()
            Spacer(modifier = Modifier.padding(top = 8.dp))
            ThrowErrorMessage(
                errorInt = getUser(text.text, otp, confirmOtp).second,
                isButtonClicked,
            )
            Spacer(modifier = Modifier.padding(top = 8.dp))
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.BottomCenter,
            ) {
                Button(
                    onClick = {
                        val user = UserEntity(userName = text.text, password = otp)
                        isButtonClicked = true
                        if (getUser(
                                userName = text.text,
                                otp,
                                confirmPass = confirmOtp,
                            ).first
                        ) {
                            Log.e("tag", user.toString())
                            homeViewModels.saveUser(user)
                            navHostController.navigate(HOME)
                        }
                    },
                    modifier = Modifier.fillMaxWidth().wrapContentHeight()
                        .padding(end = 20.dp, start = 20.dp, bottom = 10.dp),
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.dark_blue)),

                ) {
                    Text(text = "save")
                }
            }
        }
    }
}

@Composable
private fun HeaderSection() {
    Column {
        Image(
            painter = painterResource(id = R.drawable.ic_drawer),
            contentDescription = "image",
            modifier = Modifier.fillMaxWidth().height(50.dp),
        )
        Spacer(modifier = Modifier.padding(top = 10.dp))
        Text(
            text = "Add New Account",
            textAlign = TextAlign.Start,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(start = 10.dp),
            color = colorResource(id = R.color.white),
        )
        Spacer(modifier = Modifier.padding(top = 20.dp))
    }
}

@Composable
private fun ImageSection() {
    Image(
        painter = painterResource(id = R.drawable.ic_pass),
        modifier = Modifier.fillMaxWidth().height(70.dp),
        contentDescription = "image",
    )
    Spacer(modifier = Modifier.padding(top = 10.dp))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun InputSection(
    text: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    placeholder: String,
    leadingIcon: Int,
) {
    Text(
        text = "Enter your name",
        textAlign = TextAlign.Start,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        modifier = Modifier.padding(start = 20.dp),
        color = colorResource(id = R.color.white),
    )
    Spacer(modifier = Modifier.padding(top = 10.dp))
    OutlinedTextField(
        value = text,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp),
        placeholder = { Text(text = placeholder) },
        leadingIcon = {
            Image(
                painter = painterResource(id = leadingIcon),
                contentDescription = "image",
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(colorResource(id = R.color.white)),
    )
    Spacer(modifier = Modifier.padding(top = 10.dp))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PinSection(otp: String, onValueChange: (String) -> Unit, label: String) {
    Text(
        text = label,
        textAlign = TextAlign.Start,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        modifier = Modifier.padding(start = 20.dp),
        color = colorResource(id = R.color.white),
    )
    Spacer(modifier = Modifier.padding(top = 10.dp))
    OutlinedTextField(
        value = otp.toString(),
        onValueChange = {
            if (otp.length <= 3) {
                onValueChange(it)
            }
        },
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp)
            .fillMaxWidth(),
        leadingIcon = {
            Image(
                painter = painterResource(id = R.drawable.ic_password),
                contentDescription = "image",
            )
        },
        keyboardOptions = KeyboardOptions(
            autoCorrect = true,
            keyboardType = KeyboardType.Number,
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(colorResource(id = R.color.white)),
    )
    Spacer(modifier = Modifier.padding(top = 10.dp))
}

@Composable
private fun FingerprintSection() {
    Text(
        text = "Set FingerPrint",
        modifier = Modifier.padding(start = 10.dp),
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        color = colorResource(id = R.color.white),
    )
    Spacer(modifier = Modifier.padding(top = 10.dp))
    Box(
        modifier = Modifier.fillMaxWidth().wrapContentHeight(),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            painter = painterResource(id = R.drawable.baseline_fingerprint_24),
            contentDescription = "image",
            modifier = Modifier.width(70.dp).height(70.dp),
            alignment = Alignment.Center,
        )
    }
}

private fun getUser(userName: String, pass: String, confirmPass: String): Pair<Boolean, Int> {
    if (userName.isEmpty()) {
        return Pair(false, 1)
    }
    if (pass.isEmpty() || pass.length <= 3) {
        return Pair(false, 2)
    }

    if (confirmPass.isEmpty() || confirmPass.length <= 3) {
        return Pair(false, 3)
    }

    if (confirmPass != pass) {
        return Pair(false, 4)
    }

    return Pair(true, 5)
}

@Composable
fun ThrowErrorMessage(errorInt: Int, isButtonClicked: Boolean) {
    var errorMessage by remember {
        mutableStateOf("")
    }

    if (isButtonClicked) {
        when (errorInt) {
            1 -> {
                errorMessage = "userName can not be empty"
            }

            2 -> {
                errorMessage = "pin can't be empty or <= 3"
            }

            3 -> {
                errorMessage = "confirm pin  can't be empty or <= 3 "
            }

            4 -> {
                errorMessage = "pin does not match"
            }

            5 -> {
                errorMessage = ""
            }

            else -> {
                errorMessage = ""
            }
        }
    }

    Text(
        text = errorMessage,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth(),
        fontSize = 12.sp,
        fontWeight = FontWeight.SemiBold,
        color = colorResource(id = R.color.red),
    )
}
