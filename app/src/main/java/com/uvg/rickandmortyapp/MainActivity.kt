package com.uvg.rickandmortyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.uvg.rickandmortyapp.ui.*
import com.uvg.rickandmortyapp.ui.theme.RickAndMortyAPPTheme
import com.uvg.rickandmortyapp.viewmodel.*

class MainActivity : ComponentActivity() {
    private val themeViewModel: ThemeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val isDarkTheme by themeViewModel.isDarkTheme.collectAsState()

            RickAndMortyAPPTheme(darkTheme = isDarkTheme) {
                val navController = rememberNavController()
                val characterViewModel: CharacterViewModel = viewModel()
                val episodeViewModel: EpisodeViewModel = viewModel()
                val locationViewModel: LocationViewModel = viewModel()

                AppNavigation(navController, themeViewModel, characterViewModel, episodeViewModel, locationViewModel)
            }
        }
    }
}

@Composable
fun AppNavigation(
    navController: NavHostController,
    themeViewModel: ThemeViewModel,
    characterViewModel: CharacterViewModel,
    episodeViewModel: EpisodeViewModel,
    locationViewModel: LocationViewModel
) {
    NavHost(navController = navController, startDestination = "dashboard") {
        composable("dashboard") { DashboardScreen(navController, themeViewModel) }
        composable("characters") { CharacterListScreen(characterViewModel) }
        composable("locations") { LocationScreen(navController, locationViewModel) }
        composable("episodes") { EpisodeScreen(episodeViewModel) }

        composable(
            "locationCharacters/{residentIds}",
            arguments = listOf(navArgument("residentIds") { type = NavType.StringType })
        ) { backStackEntry ->
            val residentIds = backStackEntry.arguments?.getString("residentIds")?.split(",") ?: emptyList()
            CharacterListByLocationScreen(residentIds, characterViewModel)
        }
    }
}
