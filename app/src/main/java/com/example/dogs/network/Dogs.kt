package com.example.dogs.network

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

data class Dogs(
//    @Json(name="status")
//    @SerializedName("status")
    var status: String,
    //  @SerializedName("message")
    @Json(name="message")
    var images: List<String>
)
