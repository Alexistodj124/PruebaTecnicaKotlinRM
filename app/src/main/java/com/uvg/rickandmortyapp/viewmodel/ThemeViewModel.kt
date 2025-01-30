package com.uvg.rickandmortyapp.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ThemeViewModel : ViewModel() {
    private val _isDarkTheme = MutableStateFlow(true)
    val isDarkTheme: StateFlow<Boolean> = _isDarkTheme

    fun toggleTheme() {
        _isDarkTheme.value = !_isDarkTheme.value
    }
}
