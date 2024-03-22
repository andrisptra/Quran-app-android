package com.example.quranapp.ui.data.response

import com.google.gson.annotations.SerializedName

data class DoaResponse(

	@field:SerializedName("request")
	val request: Request? = null,

	@field:SerializedName("data")
	val data: List<DataItemDoa?>? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
)

data class DataItemDoa(

	@field:SerializedName("indo")
	val indo: String? = null,

	@field:SerializedName("source")
	val source: String? = null,

	@field:SerializedName("judul")
	val judul: String? = null,

	@field:SerializedName("arab")
	val arab: String? = null
)

data class RequestDoa(

	@field:SerializedName("path")
	val path: String? = null
)
