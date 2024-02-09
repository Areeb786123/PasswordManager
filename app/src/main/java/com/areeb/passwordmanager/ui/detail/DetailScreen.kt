package com.areeb.passwordmanager.ui.detail

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.areeb.passwordmanager.R
import com.areeb.passwordmanager.data.models.entity.PmEntity
import com.areeb.passwordmanager.ui.addPassword.viewModels.AddDataViewModels


@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun DetailScreen(
    showBottomSheet: (Boolean) -> Unit,
    passWordModel: PmEntity
) {

    Body(showBottomSheet = showBottomSheet, passWordModel = passWordModel)

}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun Body(
    showBottomSheet: (Boolean) -> Unit,
    passWordModel: PmEntity
) {
    val modalSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val passWordViewModel: AddDataViewModels = hiltViewModel()
    ModalBottomSheet(
        onDismissRequest = {
            showBottomSheet(false)
        },
        sheetState = modalSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
        containerColor = colorResource(id = R.color.greish_black),
        modifier = Modifier.padding(top = 30.dp),
    ) {

        var finalPassWord by remember {
            mutableStateOf(passWordModel.password)
        }

        var isPasswordVisible by remember {
            mutableStateOf(false)
        }
        Column(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = passWordModel.appName, fontSize = 26.sp, color = Color.White)
            }

            Spacer(modifier = Modifier.height(30.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.password_icons),
                    modifier = Modifier
                        .width(80.dp)
                        .height(80.dp),
                    contentDescription = "image"
                )
            }
            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "Email",
                modifier = Modifier.padding(start = 20.dp),
                fontSize = 26.sp,
                color = Color.White
            )
            Text(
                text = passWordModel.loginEmail,
                modifier = Modifier.padding(start = 20.dp),
                fontSize = 16.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(20.dp))
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp),
                color = Color.White
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Password",
                fontSize = 26.sp,
                modifier = Modifier.padding(start = 20.dp),
                color = Color.White
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                contentAlignment = Alignment.TopStart
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    BasicTextField(
                        value = passWordModel.password,
                        onValueChange = {
                            finalPassWord = it
                        },
                        textStyle = TextStyle(fontSize = 16.sp, color = Color.White),
                        modifier = Modifier.padding(start = 20.dp),
                        readOnly = true,
                        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    )
                    Spacer(modifier = Modifier.width(20.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        contentAlignment = Alignment.TopEnd
                    ) {
                        Image(
                            painter = if (isPasswordVisible) painterResource(id = R.drawable.eye_open) else painterResource(
                                id = R.drawable.eye_close
                            ),
                            contentDescription = "image",
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .padding(end = 10.dp)
                                .clickable {
                                    isPasswordVisible = isPasswordVisible == false
                                },
                        )
                    }


                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp), color = Color.White
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Note",
                fontSize = 26.sp,
                modifier = Modifier.padding(start = 20.dp),
                color = Color.White
            )

            Spacer(modifier = Modifier.width(40.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Note not added yet ",
                    fontSize = 16.sp,
                    modifier = Modifier.padding(start = 20.dp),
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(20.dp))
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp),
                color = Color.White
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row(modifier = Modifier
                .padding(start = 10.dp)
                .clickable {
                    passWordViewModel.deleteCredentials(passWordModel)
                }) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_delete_outline_24),
                    contentDescription = "image"
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Delete",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontStyle = FontStyle.Normal,
                    color = Color.Red,
                    modifier = Modifier.clickable {
                        Log.e("dataDetail", passWordModel.toString())
                        passWordViewModel.deleteCredentials(passWordModel)
                        showBottomSheet(false)

                    }
                )
            }

        }

    }
}