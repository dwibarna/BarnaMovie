package com.example.barnaton


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.barnaton.ui.components.BottomBar
import com.example.barnaton.ui.navigations.Screen
import com.example.barnaton.ui.screen.home.HomeScreen
import com.example.barnaton.ui.screen.home.HomeViewModel
import com.example.barnaton.ui.theme.BarnatonTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BarnatonTheme {
                MainApp()
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainAppPreview() {
    BarnatonTheme {
        MainApp()
    }
}

@Composable
fun MainApp(
    modifier: Modifier = Modifier,
    navHostController: NavHostController = rememberNavController()
) {
    Scaffold(
        bottomBar = {
            BottomBar(
                navHostController
            )
        },
        modifier = modifier
    ) {
        NavHost(
            navController = navHostController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(it)
        ) {
            composable(Screen.Home.route) {
                val viewModels = hiltViewModel<HomeViewModel>()
                HomeScreen(
                    viewModel = viewModels
                )
            }
            composable(Screen.Favorite.route) {
/*                FavoriteScreen()*/
            }
            composable(Screen.Profile.route) {
/*                ProfileScreen()*/
            }
        }
    }
}
