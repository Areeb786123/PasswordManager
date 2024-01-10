package com.areeb.passwordmanager.ui.home.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.areeb.passwordmanager.R
import com.areeb.passwordmanager.utils.statusColorChanger
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navHostController: NavHostController) {
    statusColorChanger(color = colorResource(id = R.color.black))
    val systemUiController = rememberSystemUiController()
    systemUiController.isSystemBarsVisible = false
    Scaffold(
        floatingActionButton = {
            ExtendedFloatingActionButton(
                modifier = Modifier
                    .padding(bottom = 40.dp)
                    .width(170.dp)
                    .height(70.dp),
                containerColor = colorResource(id = R.color.dark_blue),
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
                        modifier = Modifier
                            .height(20.dp)
                            .width(30.dp)
                            .padding(end = 2.dp),
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

@Preview
@Composable
private fun Content() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.black)),
    ) {
        CustomTopBar()
        Spacer(modifier = Modifier.padding(top = 4.dp))
        SearchBar()
        PasswordSection()
    }
}

@Composable
private fun CustomTopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Box(
                modifier = Modifier
                    .width(80.dp),
                contentAlignment = Alignment.TopStart,
            ) {
                Card(
                    modifier = Modifier
                        .padding(start = 10.dp, top = 10.dp)
                        .width(56.dp)
                        .height(56.dp),
                    shape = CircleShape,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_default_profile),
                        contentDescription = "image",
                        modifier = Modifier.fillMaxSize(),
                    )
                }
            }

            Spacer(modifier = Modifier.padding(start = 6.dp))
            Column(
                modifier = Modifier
                    .width(150.dp)
                    .padding(top = 14.dp),
                horizontalAlignment = Alignment.Start,
            ) {
                Text(
                    text = "Hello , 👋🏻",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(
                        id = R.color.white,
                    ),
                )
                Text(
                    text = "Guest",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(
                        id = R.color.white,
                    ),
                )
            }
            Box(
                modifier = Modifier
                    .width(200.dp)
                    .weight(1f),
                contentAlignment = Alignment.TopEnd,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_menu_24),
                    modifier = Modifier
                        .width(70.dp)
                        .height(70.dp),
                    contentDescription = "image",
                    contentScale = ContentScale.Inside,
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SearchBar() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(start = 20.dp, end = 20.dp),
        shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(colorResource(id = R.color.greish_black)),
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "image",
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp),
            )
            Spacer(modifier = Modifier.padding(start = 6.dp))
            BasicTextField(
                value = "hello ",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                textStyle = TextStyle(
                    fontSize = 16.sp,
                    color = colorResource(
                        id = R.color.white,

                    ),
                    fontWeight = FontWeight.SemiBold,
                ),
            )
        }
    }
}

@Composable
private fun PasswordSection() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Saved Password",
            textAlign = TextAlign.Start,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(start = 10.dp, top = 14.dp),
            color = colorResource(id = R.color.white),
        )
        Spacer(modifier = Modifier.padding(top = 10.dp))
        PasswordList()
    }
}

@Composable
private fun PasswordList() {
    LazyColumn(content = {
        items(dummyText()) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(start = 14.dp, end = 14.dp, top = 8.dp, bottom = 10.dp),
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(colorResource(id = R.color.greish_black)),
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Card(
                        modifier = Modifier
                            .width(66.dp)
                            .height(46.dp)
                            .padding(start = 10.dp),
                        colors = CardDefaults.cardColors(
                            colorResource(id = R.color.blakish_grey),
                        ),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 20.dp,
                        ),
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_default_profile),
                            contentDescription = "image",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.FillBounds,
                        )
                    }

                    Spacer(modifier = Modifier.padding(start = 10.dp))
                    Text(
                        text = it.toString(),
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = colorResource(id = R.color.white),

                    )
                }
            }
        }
    })
}

private fun dummyText(): List<String> {
    return listOf(
        "facebook",
        "instagram",
        "X",
        "google",
        "yahoo",
        "galgotias",
        "TurnsApp",
        "NoteApp",
        "SekaiSheet",
        "School",
        "college",
    )
}

