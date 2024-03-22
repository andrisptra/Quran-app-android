package com.example.quranapp.ui.data.response

import com.google.gson.annotations.SerializedName

data class SemuaKotaResponse(

	@field:SerializedName("request")
	val request: RequestSemuaKota? = null,

	@field:SerializedName("data")
	val data: List<DataItemSemuaKota?>? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
)

data class RequestSemuaKota(

	@field:SerializedName("path")
	val path: String? = null
)

data class DataItemSemuaKota(

	@field:SerializedName("lokasi")
	val lokasi: String? = null,

	@field:SerializedName("id")
	val id: String? = null
)
