package com.example.quranapp.ui.data.retrofit

import com.example.quranapp.ui.data.response.DetailJuzResponse
import com.example.quranapp.ui.data.response.DetailSurahResponse
import com.example.quranapp.ui.data.response.JuzResponse
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
}