package com.example.quranapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quranapp.ui.data.response.DataItemJuzDetail
import com.example.quranapp.ui.data.response.DetailJuzResponse
import com.example.quranapp.ui.data.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailJuzViewModel: ViewModel() {
    private val _listAyat = MutableLiveData<List<DataItemJuzDetail?>?>()
    val listAyat: LiveData<List<DataItemJuzDetail?>?> = _listAyat

    fun getDetailJuz(id: String){
        val client = ApiConfig.getApiService().getDetailJuz(id)
        client.enqueue(object :Callback<DetailJuzResponse>{
            override fun onResponse(
                call: Call<DetailJuzResponse>,
                response: Response<DetailJuzResponse>
            ) {
                if (response.isSuccessful){
                    val responseBody = response.body()?.data
                    _listAyat.value = responseBody
                }
            }

            override fun onFailure(call: Call<DetailJuzResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}