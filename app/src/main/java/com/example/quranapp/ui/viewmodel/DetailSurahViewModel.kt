package com.example.quranapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quranapp.ui.data.response.DataItemDetailSurah
import com.example.quranapp.ui.data.response.DetailSurahResponse
import com.example.quranapp.ui.data.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailSurahViewModel : ViewModel() {
    private val _listAyat = MutableLiveData<List<DataItemDetailSurah?>?>()
    val listAyat: LiveData<List<DataItemDetailSurah?>?> = _listAyat

    fun getDetailSurah(surah: String, ayatStart: String, ayatEnd: String) {
        val client = ApiConfig.getApiService().getDetailSurah(surah, ayatStart, ayatEnd)
        client.enqueue(object : Callback<DetailSurahResponse> {
            override fun onResponse(
                call: Call<DetailSurahResponse>,
                response: Response<DetailSurahResponse>
            ) {
                if (response.isSuccessful) {
                    val responseBody = response.body()?.data
                    _listAyat.value = responseBody
                }
            }

            override fun onFailure(call: Call<DetailSurahResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

}