package com.uvg.rickandmortyapp.network

import com.uvg.rickandmortyapp.model.Character
import com.uvg.rickandmortyapp.model.Episode
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("character")
    suspend fun getCharacters(@Query("page") page: Int = 1): CharacterResponse
    @GET("episode")
    suspend fun getEpisodes(@Query("page") page: Int = 1): EpisodeResponse
}

data class CharacterResponse(val results: List<Character>)
data class EpisodeResponse(val results: List<Episode>)

// Configuración de Retrofit
object RetrofitInstance {
    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}