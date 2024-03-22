package com.example.quranapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quranapp.ui.data.response.Jadwal
import com.example.quranapp.ui.data.response.JadwalSholatResponse
import com.example.quranapp.ui.data.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SholatDetailViewModel : ViewModel() {
    private val _dataSholat = MutableLiveData<Jadwal?>()
    val dataSholat: LiveData<Jadwal?> = _dataSholat

    fun getJadwalSholat(id: String, tahun: String, bulan: String, tanggal: String) {
        val client = ApiConfig.getApiService().getJadwalSholat(id, tahun, bulan, tanggal)
        client.enqueue(object : Callback<JadwalSholatResponse>{
            override fun onResponse(
                call: Call<JadwalSholatResponse>,
                response: Response<JadwalSholatResponse>
            ) {
                if (response.isSuccessful){
                    val responseBody = response.body()?.data?.jadwal
                    _dataSholat.value = responseBody
                }
            }

            override fun onFailure(call: Call<JadwalSholatResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}