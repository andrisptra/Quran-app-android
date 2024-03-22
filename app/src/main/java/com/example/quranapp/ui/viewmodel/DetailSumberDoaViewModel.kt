package com.example.quranapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quranapp.ui.data.response.DataItemDoa
import com.example.quranapp.ui.data.response.DoaResponse
import com.example.quranapp.ui.data.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailSumberDoaViewModel: ViewModel() {
    private val _listDoa = MutableLiveData<List<DataItemDoa?>?>()
    val listDoa: LiveData<List<DataItemDoa?>?> = _listDoa

    fun getListDoa(sumber: String){
        val client = ApiConfig.getApiService().getListDoa(sumber)
        client.enqueue(object : Callback<DoaResponse>{
            override fun onResponse(call: Call<DoaResponse>, response: Response<DoaResponse>) {
                if (response.isSuccessful){
                    val responseBody = response.body()?.data
                    _listDoa.value = responseBody
                }
            }

            override fun onFailure(call: Call<DoaResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}