package com.uvg.rickandmortyapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Dashboard") }
            )
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
            Button(
                onClick = { navController.navigate("characters") },
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            ) {
                Text("Characters")
            }

            Button(
                onClick = { navController.navigate("locations") },
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            ) {
                Text("Locations")
            }

            Button(
                onClick = { navController.navigate("episodes") },
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            ) {
                Text("Episodes")
            }
        }
    }
}
