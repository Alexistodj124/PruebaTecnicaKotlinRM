package com.uvg.rickandmortyapp.model

data class Episode(
    val id: Int,
    val name: String,
    val air_date: String,
    val episode: String,
    val characters: List<String> // URLs of characters appearing in the episode
)
