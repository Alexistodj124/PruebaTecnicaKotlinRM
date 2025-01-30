package com.uvg.rickandmortyapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.uvg.rickandmortyapp.model.Location
import com.uvg.rickandmortyapp.viewmodel.LocationViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocationScreen(viewModel: LocationViewModel) {
    val locations by viewModel.locations.collectAsState()

    Scaffold(
        topBar = { TopAppBar(title = { Text("Locations") }) }
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            items(locations) { location ->
                LocationCard(location)
            }
        }
    }
}

@Composable
fun LocationCard(location: Location) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = location.name, style = MaterialTheme.typography.titleLarge)
            Text(text = "Type: ${location.type}")
            Text(text = "Dimension: ${location.dimension}")
            Text(text = "Residents: ${location.residents.size}")
        }
    }
}
