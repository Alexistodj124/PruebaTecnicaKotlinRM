package com.uvg.rickandmortyapp.network

import com.uvg.rickandmortyapp.model.Character
import com.uvg.rickandmortyapp.model.Episode
import com.uvg.rickandmortyapp.model.Location
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("character")
    suspend fun getCharacters(@Query("page") page: Int = 1): CharacterResponse
    @GET("episode")
    suspend fun getEpisodes(@Query("page") page: Int = 1): EpisodeResponse
    @GET("location")
    suspend fun getLocations(@Query("page") page: Int = 1): LocationResponse
    @GET("character/{ids}")
    suspend fun getCharactersByIds(@Path("ids") ids: String): List<Character>
}

data class CharacterResponse(
    val info: PageInfo,
    val results: List<Character>
)

data class PageInfo(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)

data class EpisodeResponse(val results: List<Episode>)
data class LocationResponse(val results: List<Location>)

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