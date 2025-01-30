package com.uvg.rickandmortyapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uvg.rickandmortyapp.model.Episode
import com.uvg.rickandmortyapp.network.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EpisodeViewModel : ViewModel() {
    private val _episodes = MutableStateFlow<List<Episode>>(emptyList())
    val episodes: StateFlow<List<Episode>> = _episodes

    init {
        fetchEpisodes()
    }

    private fun fetchEpisodes() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getEpisodes()
                _episodes.value = response.results
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
