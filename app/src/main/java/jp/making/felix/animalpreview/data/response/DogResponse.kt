package jp.making.felix.animalpreview.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DogResponse(
    val message: List<String>,
    val status: String
)