package com.example.quranapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quranapp.ui.data.response.DataItem
import com.example.quranapp.ui.data.response.DataItemJuz
import com.example.quranapp.ui.data.response.JuzResponse
import com.example.quranapp.ui.data.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JuzViewModel : ViewModel() {
    private val _listJuz = MutableLiveData<List<DataItemJuz?>?>()
    val listJuz: LiveData<List<DataItemJuz?>?> = _listJuz

    private val _showLoading = MutableLiveData<Boolean>()
    val showLoading: LiveData<Boolean> = _showLoading

    private val _message = MutableLiveData<String>()
    val message: LiveData<String> = _message


    fun getALlJuz() {
        _showLoading.value = true
        val client = ApiConfig.getApiService().getAllJuz()
        client.enqueue(object : Callback<JuzResponse> {
            override fun onResponse(call: Call<JuzResponse>, response: Response<JuzResponse>) {
                _showLoading.value = false
                if (response.isSuccessful) {
                    val responseBody = response.body()?.data
                    _listJuz.value = responseBody
                }
            }

            override fun onFailure(call: Call<JuzResponse>, t: Throwable) {
                _showLoading.value = false
                _message.value = t.message
            }


        })
    }
}