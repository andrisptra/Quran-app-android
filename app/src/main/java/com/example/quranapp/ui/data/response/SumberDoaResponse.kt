package com.example.quranapp.ui.data.response

import com.google.gson.annotations.SerializedName

data class SumberDoaResponse(

    @field:SerializedName("request")
    val request: Request? = null,

    @field:SerializedName("data")
    val data: List<String?>? = null,

    @field:SerializedName("status")
    val status: Boolean? = null
)

data class RequestSumberDoa(
    @field:SerializedName("path")
    val path: String? = null
)
