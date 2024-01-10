package com.areeb.passwordmanager.ui.addPassScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.areeb.passwordmanager.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPassScreen(
    showBottomSheet: (Boolean) -> Unit,
) {
    val modalSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    ModalBottomSheet(
        onDismissRequest = {
            showBottomSheet(false)
        },
        sheetState = modalSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
        containerColor = colorResource(id = R.color.greish_black),
        modifier = Modifier.padding(top = 40.dp),
    ) {
        Column(
            modifier = Modifier.fillMaxSize().background(
                color = colorResource(
                    id = R.color.greish_black,
                ),
            ),
        ) {
        }
    }
}
