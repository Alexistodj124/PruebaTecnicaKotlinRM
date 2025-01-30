package com.uvg.rickandmortyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.uvg.rickandmortyapp.ui.CharacterListScreen
import com.uvg.rickandmortyapp.ui.theme.RickAndMortyAPPTheme
import com.uvg.rickandmortyapp.viewmodel.CharacterViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyAPPTheme {
                val viewModel: CharacterViewModel = viewModel()
                CharacterListScreen(viewModel)
            }
        }
    }
}