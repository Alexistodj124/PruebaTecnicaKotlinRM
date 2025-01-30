package com.uvg.rickandmortyapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.uvg.rickandmortyapp.model.Character
import com.uvg.rickandmortyapp.viewmodel.CharacterViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterListScreen(viewModel: CharacterViewModel) {
    val characters by viewModel.characters.collectAsState()

    Scaffold(
        topBar = { TopAppBar(title = { Text("Rick and Morty Blog") }) }
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            items(characters) { character ->
                CharacterCard(character)
            }
        }
    }
}

@Composable
fun CharacterCard(character: Character) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            Image(
                painter = rememberAsyncImagePainter(character.image),
                contentDescription = character.name,
                modifier = Modifier.size(100.dp)
            )
            Column(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .fillMaxHeight()
            ) {
                Text(text = character.name, style = MaterialTheme.typography.titleLarge)
                Text(text = "Status: ${character.status}")
                Text(text = "Species: ${character.species}")
                Text(text = "Gender: ${character.gender}")
            }
        }
    }
}
