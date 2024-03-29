package com.example.quranapp.ui.data.response

import com.google.gson.annotations.SerializedName

data class JadwalSholatResponse(

	@field:SerializedName("request")
	val request: Request? = null,

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
)

data class RequestJadwalSholat(

	@field:SerializedName("path")
	val path: String? = null
)

data class Data(

	@field:SerializedName("jadwal")
	val jadwal: Jadwal? = null,

	@field:SerializedName("lokasi")
	val lokasi: String? = null,

	@field:SerializedName("daerah")
	val daerah: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)

data class Jadwal(

	@field:SerializedName("date")
	val date: String? = null,

	@field:SerializedName("imsak")
	val imsak: String? = null,

	@field:SerializedName("isya")
	val isya: String? = null,

	@field:SerializedName("dzuhur")
	val dzuhur: String? = null,

	@field:SerializedName("subuh")
	val subuh: String? = null,

	@field:SerializedName("dhuha")
	val dhuha: String? = null,

	@field:SerializedName("terbit")
	val terbit: String? = null,

	@field:SerializedName("tanggal")
	val tanggal: String? = null,

	@field:SerializedName("ashar")
	val ashar: String? = null,

	@field:SerializedName("maghrib")
	val maghrib: String? = null
)
