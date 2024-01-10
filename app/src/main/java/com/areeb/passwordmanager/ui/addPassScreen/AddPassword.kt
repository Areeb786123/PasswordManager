package com.areeb.passwordmanager.ui.addPassScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
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
import com.areeb.passwordmanager.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPassScreen(
    showBottomSheet: (Boolean) -> Unit,
) {
    var appName by remember {
        mutableStateOf("")
    }
    var login by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    val modalSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    ModalBottomSheet(
        onDismissRequest = {
            showBottomSheet(false)
        },
        sheetState = modalSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
        containerColor = colorResource(id = R.color.greish_black),
        modifier = Modifier.padding(top = 30.dp),
    ) {
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
                text = "Save Crediantials",
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
                    modifier = Modifier.width(80.dp).height(80.dp),
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
                modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp, top = 20.dp),
            )
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
                value = login,
                onValueChange = {
                    login = it
                },
                textStyle = TextStyle(
                    fontSize = 16.sp,
                    color = colorResource(
                        id = R.color.white,

                    ),
                    fontWeight = FontWeight.SemiBold,
                ),
                modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp, top = 20.dp),
            )
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
                modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp, top = 20.dp),

            )
            Spacer(modifier = Modifier.padding(top = 20.dp))
            Button(
                onClick = { /*TODO*/ },
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
                    modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp),
                )
            }
        }
    }
}
