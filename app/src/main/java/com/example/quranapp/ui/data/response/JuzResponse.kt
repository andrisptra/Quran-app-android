package com.example.quranapp.ui.data.response

import com.google.gson.annotations.SerializedName

data class JuzResponse(

	@field:SerializedName("request")
	val request: Request? = null,

	@field:SerializedName("data")
	val data: List<DataItemJuz?>? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
)

data class DataItemJuz(

	@field:SerializedName("name_start_arab")
	val nameStartArab: String? = null,

	@field:SerializedName("surah_id_end")
	val surahIdEnd: String? = null,

	@field:SerializedName("name_end_arab")
	val nameEndArab: String? = null,

	@field:SerializedName("name_end_id")
	val nameEndId: String? = null,

	@field:SerializedName("verse_end")
	val verseEnd: String? = null,

	@field:SerializedName("number")
	val number: String? = null,

	@field:SerializedName("ayat_indo")
	val ayatIndo: String? = null,

	@field:SerializedName("name_start_id")
	val nameStartId: String? = null,

	@field:SerializedName("ayat_arab")
	val ayatArab: String? = null,

	@field:SerializedName("surah_id_start")
	val surahIdStart: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("verse_start")
	val verseStart: String? = null,

	@field:SerializedName("ayat_latin")
	val ayatLatin: String? = null
)

data class RequestJuz(

	@field:SerializedName("path")
	val path: String? = null
)
