package com.zdez.getmeaxolotl

import com.squareup.moshi.Json

data class Properties(
    val url: String,
    var facts: String,
    @Json(name = "pics_repo") val picsRepo: String,
    @Json(name = "api_repo") val apiRepo: String
)
