package com.uvg.rickandmortyapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.uvg.rickandmortyapp.model.Episode
import com.uvg.rickandmortyapp.viewmodel.EpisodeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EpisodeScreen(viewModel: EpisodeViewModel) {
    val episodes by viewModel.episodes.collectAsState()

    Scaffold(
        topBar = { TopAppBar(title = { Text("Episodes") }) }
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            items(episodes) { episode ->
                EpisodeCard(episode)
            }
        }
    }
}

@Composable
fun EpisodeCard(episode: Episode) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = episode.name, style = MaterialTheme.typography.titleLarge)
            Text(text = "Air Date: ${episode.air_date}")
            Text(text = "Episode: ${episode.episode}")
        }
    }
}
