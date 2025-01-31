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
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterListByLocationScreen(residentIds: List<String>, viewModel: CharacterViewModel) {
    val characters by viewModel.getCharactersByIds(residentIds).collectAsState()

    Scaffold(
        topBar = { TopAppBar(title = { Text("Residents") }) }
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            items(characters) { character ->
                CharacterCard(character)
            }
        }
    }
}
