package com.moter.scaffoldexamples

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


@Composable
fun BottomAppBarUsage(navController: NavHostController) {
    BottomAppBar(actions = {
        IconButton(onClick = {
            navController.navigate(Destination.List.route)
        }) {
            Icon(imageVector = Icons.Filled.List, contentDescription = null)
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Filled.Search, contentDescription = null)
        }
    },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = null)
            }
        })
}

@Preview
@Composable
fun BottomAppBarUsagePreview() {
    BottomAppBarUsage(rememberNavController())
}