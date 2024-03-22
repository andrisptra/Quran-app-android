package com.example.quranapp.ui.data.retrofit

import com.example.quranapp.ui.data.response.DetailJuzResponse
import com.example.quranapp.ui.data.response.DetailSurahResponse
import com.example.quranapp.ui.data.response.DoaResponse
import com.example.quranapp.ui.data.response.JadwalSholatResponse
import com.example.quranapp.ui.data.response.JuzResponse
import com.example.quranapp.ui.data.response.SemuaKotaResponse
import com.example.quranapp.ui.data.response.SumberDoaResponse
import com.example.quranapp.ui.data.response.SurahResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("quran/surat/semua")
    fun getAllSurah(): Call<SurahResponse>

    @GET("quran/juz/semua")
    fun getAllJuz(): Call<JuzResponse>

    @GET("quran/ayat/{surah}/{ayatStart}-{ayatEnd}")
    fun getDetailSurah(
        @Path("surah") surah: String,
        @Path("ayatStart") ayatStart: String,
        @Path("ayatEnd") ayatEnd: String
    ): Call<DetailSurahResponse>

    @GET("quran/ayat/juz/{nomorJuz}")
    fun getDetailJuz(
        @Path("nomorJuz") nomorJuz: String
    ): Call<DetailJuzResponse>

    @GET("doa/sumber")
    fun getSumberDoa(): Call<SumberDoaResponse>

    @GET("doa/sumber/{sumber}")
    fun getListDoa(
        @Path("sumber") sumber: String
    ): Call<DoaResponse>

    @GET("sholat/kota/semua")
    fun getSemuaKota():Call<SemuaKotaResponse>

    @GET("sholat/kota/cari/{cari}")
    fun getCariKota(
        @Path("cari") cari: String
    ): Call<SemuaKotaResponse>

    @GET("sholat/jadwal/{id}/{tahun}/{bulan}/{tanggal}")
    fun getJadwalSholat(
        @Path("id") id: String,
        @Path("tahun") tahun: String,
        @Path("bulan") bulan: String,
        @Path("tanggal") tanggal: String,
    ): Call<JadwalSholatResponse>

}