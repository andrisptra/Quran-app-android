package com.example.quranapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quranapp.ui.data.response.DataItem
import com.example.quranapp.ui.data.response.SurahResponse
import com.example.quranapp.ui.data.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SurahViewModel : ViewModel() {
    private val _listSurah = MutableLiveData<List<DataItem?>?>()
    val listSurah: LiveData<List<DataItem?>?> = _listSurah

    private val _showLoading = MutableLiveData<Boolean>()
    val showLoading: LiveData<Boolean> = _showLoading

    private val _message = MutableLiveData<String>()
    val message: LiveData<String> = _message


    fun getAllSurah() {
        _showLoading.value = true
        val client = ApiConfig.getApiService().getAllSurah()
        client.enqueue(object : Callback<SurahResponse> {
            override fun onResponse(call: Call<SurahResponse>, response: Response<SurahResponse>) {
                _showLoading.value = false
                if (response.isSuccessful) {
                    val responseBody = response.body()?.data
                    _listSurah.value = responseBody
                }
            }

            override fun onFailure(call: Call<SurahResponse>, t: Throwable) {
                _showLoading.value = false
                _message.value = t.message
            }

        })
    }


}