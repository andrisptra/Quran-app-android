package com.example.quranapp.ui.data.response

import com.google.gson.annotations.SerializedName

data class DetailSurahResponse(

	@field:SerializedName("request")
	val request: Request? = null,

	@field:SerializedName("data")
	val data: List<DataItemDetailSurah?>? = null,

	@field:SerializedName("status")
	val status: Boolean? = null,

	@field:SerializedName("info")
	val info: Info? = null
)

data class RequestSurah(

	@field:SerializedName("path")
	val path: String? = null,

	@field:SerializedName("ayat")
	val ayat: Ayat? = null,

	@field:SerializedName("surat")
	val surat: String? = null
)

data class Ayat(

	@field:SerializedName("start")
	val start: Int? = null,

	@field:SerializedName("length")
	val length: Int? = null,

	@field:SerializedName("range")
	val range: String? = null,

	@field:SerializedName("end")
	val end: Int? = null
)

data class DataItemDetailSurah(

	@field:SerializedName("notes")
	val notes: Any? = null,

	@field:SerializedName("juz")
	val juz: String? = null,

	@field:SerializedName("ayah")
	val ayah: String? = null,

	@field:SerializedName("hizb")
	val hizb: Any? = null,

	@field:SerializedName("theme")
	val theme: Any? = null,

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

data class Surat(

	@field:SerializedName("relevasi")
	val relevasi: String? = null,

	@field:SerializedName("nama")
	val nama: Nama? = null,

	@field:SerializedName("ayat_max")
	val ayatMax: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null
)

data class Info(

	@field:SerializedName("surat")
	val surat: Surat? = null
)

data class Nama(

	@field:SerializedName("ar")
	val ar: String? = null,

	@field:SerializedName("id")
	val id: String? = null
)
