package com.uvg.rickandmortyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.uvg.rickandmortyapp.ui.*
import com.uvg.rickandmortyapp.viewmodel.CharacterViewModel
import com.uvg.rickandmortyapp.viewmodel.EpisodeViewModel
import com.uvg.rickandmortyapp.ui.theme.RickAndMortyAPPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyAPPTheme {
                val navController = rememberNavController()
                val characterViewModel: CharacterViewModel = viewModel()
                val episodeViewModel: EpisodeViewModel = viewModel()
                AppNavigation(navController, characterViewModel, episodeViewModel)
            }
        }
    }
}

@Composable
fun AppNavigation(navController: NavHostController, characterViewModel: CharacterViewModel, episodeViewModel: EpisodeViewModel) {
    NavHost(navController = navController, startDestination = "dashboard") {
        composable("dashboard") { DashboardScreen(navController) }
        composable("characters") { CharacterListScreen(characterViewModel) }
        composable("locations") { LocationScreen() }
        composable("episodes") { EpisodeScreen(episodeViewModel) }
    }
}
