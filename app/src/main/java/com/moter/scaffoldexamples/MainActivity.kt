package com.moter.scaffoldexamples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.moter.scaffoldexamples.ui.theme.ScaffoldExamplesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScaffoldExamplesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    CreateScaffold(navController = navController)
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateScaffold(navController: NavHostController) {
    Scaffold(
        topBar = { TopAppBarUsage(navController = navController) },
        bottomBar = { BottomAppBarUsage(navController = navController) },
        content = { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)) {
                NavHost(navController = navController, startDestination = "Home") {
                    composable(Destination.Home.route) { HomeScreen() }
                    composable(Destination.Add.route) { AddScreen() }
                    composable(Destination.Favorites.route) { FavoritesScreen() }
                    composable(Destination.List.route) { ListScreen(navController = navController) }
                    composable(Destination.Detail.route) {
                        val userId = it.arguments?.getString("userId")
                        userId?.let {
                            DetailScreen(navController = navController, userId = userId.toInt())
                        }
                    }
                }
            }
        })
}


sealed class Destination(val route: String) {
    object Home : Destination("Home")
    object Add : Destination("Add")
    object Favorites : Destination("Favoites")
    object List : Destination("list")
    object Detail : Destination("detail/{userId}") {
        fun createRoute(userId: Int) = "detail/$userId"
    }
}

data class User(
    val id: Int,
    val name: String,
    val surname: String
) {
    companion object {
        private val users = listOf(
            User(0, "John", "Smith"),
            User(1, "Susan", "Smith"),
            User(2, "David", "Brown"),
            User(3, "Margaret", "Brown"),
            User(4, "Michael", "Jones"),
            User(5, "Patricia", "Jones"),
            User(6, "Andrew", "Williams"),
            User(7, "Sarah", "Williams"),
            User(8, "Robert", "Perry"),
            User(9, "Mary", "Perry"),
        )

        fun getTestList() = users

        fun getUser(id: Int): User? {
            for (i in users.indices) {
                if (users[i].id == id) return users[i]
            }
            return null
        }
    }
}