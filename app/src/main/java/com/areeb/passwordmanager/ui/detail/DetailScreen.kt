package com.areeb.passwordmanager.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
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
            Text(text = passWordModel.appName, fontSize = 40.sp)

        }

    }
}
