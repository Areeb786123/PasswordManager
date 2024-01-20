package com.areeb.passwordmanager.ui.detail

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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.areeb.passwordmanager.R
import com.areeb.passwordmanager.data.models.entity.PmEntity


@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun DetailScreen(
    showBottomSheet: (Boolean) -> Unit,
    passWordModel: PmEntity
) {
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
        Column(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                contentAlignment = Alignment.Center
            ) {

                Image(
                    painter = painterResource(id = R.drawable.ic_default_profile),
                    contentDescription = "image"
                )
            }
            Spacer(modifier = Modifier.padding(top = 10.dp))


            Text(
                text = passWordModel.appName,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                color = Color.White,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 10.dp, start = 10.dp)
            )
            Spacer(modifier = Modifier.padding(top = 8.dp))
            Text(
                text = passWordModel.email,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.White,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 10.dp, start = 10.dp)
            )

            Spacer(modifier = Modifier.padding(top = 18.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                Text(
                    text = passWordModel.password,
                    fontWeight = FontWeight.Bold,
                    fontSize = 40.sp,
                    color = Color.White,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(top = 10.dp, start = 10.dp, bottom = 10.dp),
                    maxLines = 22,
                    overflow = TextOverflow.Ellipsis

                )
            }

            Spacer(modifier = Modifier.padding(top = 18.dp))

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.padding(start = 10.dp),
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.dark_blue))
            ) {
                Text(
                    text = "Delete it",
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = colorResource(
                        id = R.color.white
                    )
                )
            }


        }

    }
}
