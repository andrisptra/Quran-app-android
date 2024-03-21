package com.example.quranapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quranapp.ui.data.response.SumberDoaResponse
import com.example.quranapp.ui.data.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DoaViewModel : ViewModel() {

    private val _listSumberDoa = MutableLiveData<List<String?>?>()
    val listSumberDoa: LiveData<List<String?>?> = _listSumberDoa

    fun getSumberDoa() {
        val client = ApiConfig.getApiService().getSumberDoa()
        client.enqueue(object : Callback<SumberDoaResponse> {
            override fun onResponse(
                call: Call<SumberDoaResponse>,
                response: Response<SumberDoaResponse>
            ) {
                if (response.isSuccessful) {
                    val responseBody = response.body()?.data
                    _listSumberDoa.value = responseBody
                }
            }

            override fun onFailure(call: Call<SumberDoaResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

}