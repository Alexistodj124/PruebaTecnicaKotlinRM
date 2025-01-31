package com.uvg.rickandmortyapp.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.uvg.rickandmortyapp.model.Location
import com.uvg.rickandmortyapp.viewmodel.LocationViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocationScreen(navController: NavController, viewModel: LocationViewModel) {
    val locations by viewModel.locations.collectAsState()

    Scaffold(
        topBar = { TopAppBar(title = { Text("Locations") }) }
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            items(locations) { location ->
                LocationCard(location) {
                    if (location.residents.isNotEmpty()) {
                        val residentsIds = location.residents.joinToString(",") { it.split("/").last() }
                        navController.navigate("locationCharacters/$residentsIds")
                    }
                }
            }
        }
    }
}


@Composable
fun LocationCard(location: Location, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(enabled = location.residents.isNotEmpty()) { onClick() }, // 🔹 Solo habilita el clic si hay residentes
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = location.name, style = MaterialTheme.typography.titleLarge)
            Text(text = "Type: ${location.type}")
            Text(text = "Dimension: ${location.dimension}")
            Text(text = "Residents: ${location.residents.size}")

            if (location.residents.isEmpty()) {
                Text(
                    text = "No residents available",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
