package com.example.quranapp.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quranapp.R
import com.example.quranapp.databinding.ActivityDetailSurahBinding
import com.example.quranapp.databinding.RvDetailSurahBinding
import com.example.quranapp.ui.adapter.DetailSurahAdapter
import com.example.quranapp.ui.data.response.DataItemDetailSurah
import com.example.quranapp.ui.viewmodel.DetailSurahViewModel

class DetailSurahActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailSurahBinding
    private val viewModel: DetailSurahViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailSurahBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val surahId = intent.getStringExtra(SURAH_ID).toString()
        val ayatStart = "1"
        val surahName = intent.getStringExtra(SURAH_NAME).toString()
        val ayatEnd = intent.getStringExtra(AYAT_END).toString()

        viewModel.listAyat.observe(this){
            setListAyat(it)
        }

        val layoutManager = LinearLayoutManager(this)
        binding.rvAyat.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(this, layoutManager.orientation)
        binding.rvAyat.addItemDecoration(itemDecoration)
        viewModel.getDetailSurah(surahId, ayatStart, ayatEnd)

        binding.topAppBar.title = surahName

        binding.topAppBar.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }


    }

    private fun setListAyat(data: List<DataItemDetailSurah?>?){
        val adapter = DetailSurahAdapter()
        adapter.submitList(data)
        binding.rvAyat.adapter = adapter
    }

    companion object{
        var SURAH_NAME = "surah_name"
        var SURAH_ID = "surah_id"
        var AYAT_END = "ayat_end"
    }
}