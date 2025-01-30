package com.uvg.rickandmortyapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.uvg.rickandmortyapp.viewmodel.ThemeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavController, themeViewModel: ThemeViewModel) {
    val isDarkTheme by themeViewModel.isDarkTheme.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Dashboard") })
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { navController.navigate("characters") }) {
                Text("Characters")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { navController.navigate("locations") }) {
                Text("Locations")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { navController.navigate("episodes") }) {
                Text("Episodes")
            }
            Spacer(modifier = Modifier.height(16.dp))

            // Dark/Light Mode Toggle Button
            Button(onClick = { themeViewModel.toggleTheme() }) {
                Text(if (isDarkTheme) "Switch to Light Mode" else "Switch to Dark Mode")
            }
        }
    }
}
