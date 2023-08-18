package com.moter.scaffoldexamples

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarUsage(navController: NavHostController) {
    val context = LocalContext.current
    val showMenu = remember { mutableStateOf(false) }

    TopAppBar(title = { Text(text = "Top App Bar") },
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.Menu, contentDescription = null)
            }
        },
        actions = {
            IconButton(onClick = {
//                if (navController.currentDestination?.route !== Destination.Add.route)
                navController.navigate(route = Destination.Add.route) {
                    launchSingleTop = true
                }
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
            IconButton(onClick = {
                navController.navigate(route = Destination.Favorites.route)
            }) {
                Icon(painter = painterResource(id = R.drawable.ic_fav), contentDescription = null)
            }
            IconButton(onClick = { showMenu.value = true }) {
                Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
            }

            DropdownMenu(expanded = showMenu.value, onDismissRequest = { showMenu.value = false }) {
                DropdownMenuItem(
                    text = { Text(text = "Build") },
                    onClick = { showMenu.value = false },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Build,
                            contentDescription = null
                        )
                    }
                )
            }
        }
    )
}


@Preview(showBackground = true)
@Composable
fun TopAppBarUsagePreview() {
    TopAppBarUsage(rememberNavController())
}