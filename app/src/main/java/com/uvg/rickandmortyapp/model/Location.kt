package com.uvg.rickandmortyapp.model

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import com.google.gson.*
import java.lang.reflect.Type

data class Location(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,

    @JsonAdapter(StringListJsonAdapter::class)
    @SerializedName("residents") val residents: List<String>
)

class StringListJsonAdapter : JsonDeserializer<List<String>> {
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): List<String> {
        return when {
            json.isJsonArray -> json.asJsonArray.mapNotNull { it.asString } // ✅ Si es un array, lo convertimos en una lista
            json.isJsonPrimitive -> listOf(json.asString) // ✅ Si es un solo String, lo convertimos en una lista de un solo elemento
            else -> emptyList()
        }
    }
}
