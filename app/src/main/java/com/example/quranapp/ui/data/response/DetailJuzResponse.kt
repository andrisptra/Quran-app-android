package com.example.quranapp.ui.data.response

import com.google.gson.annotations.SerializedName

data class DetailJuzResponse(

	@field:SerializedName("request")
	val request: Request? = null,

	@field:SerializedName("data")
	val data: List<DataItemJuzDetail?>? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
)

data class DataItemJuzDetail(

	@field:SerializedName("notes")
	val notes: Any? = null,

	@field:SerializedName("juz")
	val juz: String? = null,

	@field:SerializedName("ayah")
	val ayah: String? = null,

	@field:SerializedName("hizb")
	val hizb: String? = null,

	@field:SerializedName("theme")
	val theme: String? = null,

	@field:SerializedName("audio")
	val audio: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("latin")
	val latin: String? = null,

	@field:SerializedName("page")
	val page: String? = null,

	@field:SerializedName("text")
	val text: String? = null,

	@field:SerializedName("surah")
	val surah: String? = null,

	@field:SerializedName("asbab")
	val asbab: String? = null,

	@field:SerializedName("arab")
	val arab: String? = null
)

data class RequestJuzDetail(

	@field:SerializedName("path")
	val path: String? = null,

	@field:SerializedName("juz")
	val juz: String? = null
)
