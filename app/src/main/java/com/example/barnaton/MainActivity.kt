package com.example.barnaton


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.barnaton.ui.components.BottomBar
import com.example.barnaton.ui.navigations.Screen
import com.example.barnaton.ui.screen.about.AboutScreen
import com.example.barnaton.ui.screen.detail.DetailScreen
import com.example.barnaton.ui.screen.detail.DetailViewModel
import com.example.barnaton.ui.screen.favorite.FavoriteScreen
import com.example.barnaton.ui.screen.favorite.FavoriteViewModel
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
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute != Screen.DetailScreen.route) {
                BottomBar(
                    navHostController
                )
            }
        },
        modifier = modifier
    ) { paddingValues ->
        NavHost(
            navController = navHostController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screen.Home.route) {
                val viewModels = hiltViewModel<HomeViewModel>()
                HomeScreen(
                    viewModel = viewModels,
                    navigateToDetail = { id ->
                        navHostController.navigate(Screen.DetailScreen.createRoute(id))
                    }
                )
            }
            composable(Screen.Favorite.route) {
                val viewModels = hiltViewModel<FavoriteViewModel>()
                FavoriteScreen(
                    viewModel = viewModels,
                    navigateToDetail = { id ->
                        navHostController.navigate(Screen.DetailScreen.createRoute(id))
                    }
                )
            }
            composable(Screen.Profile.route) {
                AboutScreen()
            }
            composable(
                route = Screen.DetailScreen.route,
                arguments = listOf(navArgument("detailId") {
                    type = NavType.IntType
                }),
            ) {
                val id = it.arguments?.getInt("detailId") ?: 0
                val viewModels = hiltViewModel<DetailViewModel>()
                DetailScreen(
                    id = id,
                    viewModel = viewModels
                )
            }
        }
    }
}
