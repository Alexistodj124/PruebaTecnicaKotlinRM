package com.uvg.rickandmortyapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uvg.rickandmortyapp.model.Character
import com.uvg.rickandmortyapp.network.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {
    private val _characters = MutableStateFlow<List<Character>>(emptyList())
    val characters: StateFlow<List<Character>> = _characters

    init {
        fetchCharacters()
    }

    private fun fetchCharacters() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getCharacters()
                _characters.value = response.results
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getCharactersByIds(residentIds: List<String>) = flow {
        try {
            if (residentIds.isNotEmpty()) {
                val joinedIds = residentIds.joinToString(",") // Convertimos la lista a "1,2,3"
                val response = RetrofitInstance.api.getCharactersByIds(joinedIds) // Llamada con los IDs
                emit(response)
            } else {
                emit(emptyList<Character>()) // Si no hay residentes, devolvemos lista vacía
            }
        } catch (e: Exception) {
            e.printStackTrace()
            emit(emptyList<Character>()) // En caso de error, lista vacía
        }
    }.stateIn(viewModelScope, SharingStarted.Lazily, emptyList())
}
