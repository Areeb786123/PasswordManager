package com.areeb.passwordmanager.ui.home.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.areeb.passwordmanager.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navHostController: NavHostController) {
    Scaffold(
        floatingActionButton = {
            ExtendedFloatingActionButton(
                modifier = Modifier
                    .padding(bottom = 40.dp)
                    .width(170.dp)
                    .height(50.dp),
                containerColor = colorResource(id = R.color.greish_black),
                contentColor = Color.White,
                onClick = { /*TODO*/ },
                shape = MaterialTheme.shapes.small.copy(CornerSize(percent = 50)),

            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly,
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_plus),
                        modifier = Modifier.height(20.dp).width(30.dp).padding(end = 2.dp),
                        contentDescription = "image",
                    )
                    Text(text = "Add Account", textAlign = TextAlign.Start)
                }
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        content = {
            Content()
        },

    )
}

@Composable
private fun Content() {
}
