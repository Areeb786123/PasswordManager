package com.areeb.passwordmanager.ui.setUpScreen

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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
import androidx.navigation.NavHostController
import com.areeb.passwordmanager.R
import androidx.compose.foundation.layout.Column as Column

@Composable
fun SetUpScreen(navHostController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.light_green)),
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_girl),
            contentDescription = "image",
            modifier = Modifier.wrapContentSize().wrapContentHeight().align(Alignment.TopStart),
        )

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.width(90.dp).height(40.dp).align(Alignment.TopEnd)
                .padding(end = 10.dp),
        ) {
            Text(text = "save")
        }
        Body(navHostController = navHostController)
    }
}

@Preview
@Composable
private fun Body(navHostController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 60.dp,

            ),
        shape = CardDefaults.shape,
        colors = CardDefaults.cardColors(colorResource(id = R.color.white)),
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.ic_drawer),
                contentDescription = "image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
            )
            Spacer(modifier = Modifier.padding(top = 10.dp))

            Text(
                text = "Add New Account",
                textAlign = TextAlign.Start,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 10.dp),
            )
            Spacer(modifier = Modifier.padding(top = 20.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_pass),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp),
                contentDescription = "image",
            )
            Spacer(modifier = Modifier.padding(top = 10.dp))
            UserName()
            SetPin()
            ConfirmPin()
            Spacer(
                modifier = Modifier.padding(top = 10.dp),
            )
            Text(
                text = "Set FingerPrint",
                modifier = Modifier.padding(start = 10.dp),
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
            )

            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_fingerprint_24),
                    contentDescription = "image",
                    modifier = Modifier.width(70.dp).height(70.dp),
                    alignment = Alignment.Center,
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun UserName() {
    Spacer(modifier = Modifier.padding(top = 30.dp))
    var text by remember { mutableStateOf(TextFieldValue("")) }
    Text(
        text = "Enter your name",
        textAlign = TextAlign.Start,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        modifier = Modifier.padding(start = 20.dp),
    )
    Spacer(modifier = Modifier.padding(top = 10.dp))
    OutlinedTextField(
        value = text,
        onValueChange = {
            text = it
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp),
        placeholder = { Text(text = "username") },
        leadingIcon = {
            Image(
                painter = painterResource(id = R.drawable.ic_person),
                contentDescription = "image",
            )
        },

    )
}

@Composable
private fun SetPin() {
    Spacer(modifier = Modifier.padding(top = 10.dp))
    Text(
        text = "Set Pin",
        textAlign = TextAlign.Start,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        modifier = Modifier.padding(start = 20.dp),
    )
    Spacer(modifier = Modifier.padding(top = 10.dp))
    OtpField()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OtpField() {
    var otp by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = otp,
        onValueChange = {
            if (otp.length <= 3) {
                otp = it
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
    )
}

@Composable
private fun ConfirmPin() {
    Spacer(modifier = Modifier.padding(top = 10.dp))
    Text(
        text = "Confirm Pin",
        textAlign = TextAlign.Start,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        modifier = Modifier.padding(start = 20.dp),
    )
    Spacer(modifier = Modifier.padding(top = 10.dp))
    ConfirmOtpField()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ConfirmOtpField() {
    var otp by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = otp,
        onValueChange = {
            if (otp.length <= 3) {
                otp = it
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
    )
}
