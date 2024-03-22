package com.example.quranapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quranapp.ui.data.response.DataItemSemuaKota
import com.example.quranapp.ui.data.response.SemuaKotaResponse
import com.example.quranapp.ui.data.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SholatViewModel : ViewModel() {

    private val _semuaKota = MutableLiveData<List<DataItemSemuaKota?>?>()
    val semuaKota: LiveData<List<DataItemSemuaKota?>?> = _semuaKota

    fun getSemuaKota(){
        val client = ApiConfig.getApiService().getSemuaKota()
        client.enqueue(object : Callback<SemuaKotaResponse>{
            override fun onResponse(
                call: Call<SemuaKotaResponse>,
                response: Response<SemuaKotaResponse>
            ) {
               if (response.isSuccessful){
                   val responseBody = response.body()?.data
                   _semuaKota.value = responseBody
               }
            }

            override fun onFailure(call: Call<SemuaKotaResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    fun getCariKota(kota: String){
        val client = ApiConfig.getApiService().getCariKota(kota)
        client.enqueue(object : Callback<SemuaKotaResponse>{
            override fun onResponse(
                call: Call<SemuaKotaResponse>,
                response: Response<SemuaKotaResponse>
            ) {
                if (response.isSuccessful){
                    val responseBody = response.body()?.data
                    _semuaKota.value = responseBody
                }
            }

            override fun onFailure(call: Call<SemuaKotaResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}