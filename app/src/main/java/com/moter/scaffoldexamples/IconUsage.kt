package com.moter.scaffoldexamples

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.sharp.AccountCircle
import androidx.compose.material.icons.twotone.AddCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun IconsSamples() {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        val icon = painterResource(id = R.drawable.ic_fav)
        Icon(painter = icon, contentDescription = null)
        Icon(Icons.Default.AccountBox, contentDescription = null)
        Icon(Icons.TwoTone.AddCircle, contentDescription = null)

        IconButton(onClick = { }) {
            Icon(Icons.Sharp.AccountCircle, contentDescription = null)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun IconsSamplesPreview() {
    IconsSamples()
}