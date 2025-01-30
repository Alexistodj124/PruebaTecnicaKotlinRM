package com.uvg.rickandmortyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.uvg.rickandmortyapp.ui.CharacterListScreen
import com.uvg.rickandmortyapp.ui.DashboardScreen
import com.uvg.rickandmortyapp.ui.EpisodeScreen
import com.uvg.rickandmortyapp.ui.LocationScreen
import com.uvg.rickandmortyapp.ui.theme.RickAndMortyAPPTheme
import com.uvg.rickandmortyapp.viewmodel.CharacterViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyAPPTheme {
                val navController = rememberNavController()
                val characterViewModel: CharacterViewModel = viewModel()
                AppNavigation(navController, characterViewModel)
            }
        }
    }
}

@Composable
fun AppNavigation(navController: NavHostController, characterViewModel: CharacterViewModel) {
    NavHost(navController = navController, startDestination = "dashboard") {
        composable("dashboard") { DashboardScreen(navController) }
        composable("characters") { CharacterListScreen(characterViewModel) }
        composable("locations") { LocationScreen() }
        composable("episodes") { EpisodeScreen() }
    }
}
