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

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        fetchAllCharacters()
    }

    private fun fetchAllCharacters() {
        viewModelScope.launch {
            val allCharacters = mutableListOf<Character>()
            var page = 1

            try {
                while (true) {
                    val response = RetrofitInstance.api.getCharacters(page)
                    allCharacters.addAll(response.results)

                    if (response.info.next == null) break // No hay más páginas
                    page++
                }
                _characters.value = allCharacters
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _isLoading.value = false // 🔹 Oculta el loading cuando termina la carga
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
