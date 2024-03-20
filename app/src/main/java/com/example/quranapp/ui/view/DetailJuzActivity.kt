package com.example.quranapp.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quranapp.databinding.ActivityDetailJuzBinding
import com.example.quranapp.ui.adapter.DetailJuzAdapter
import com.example.quranapp.ui.data.response.DataItemJuzDetail
import com.example.quranapp.ui.viewmodel.DetailJuzViewModel

class DetailJuzActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailJuzBinding
    private val viewModel: DetailJuzViewModel  by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailJuzBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val juzId = intent.getStringExtra(JUZ_ID).toString()

        val layoutManager = LinearLayoutManager(this)
        binding.rvAyat.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(this, layoutManager.orientation)
        binding.rvAyat.addItemDecoration(itemDecoration)

        viewModel.listAyat.observe(this){
            setListAyat(it)
        }
        viewModel.getDetailJuz(juzId)


    }

    private fun setListAyat(ayat: List<DataItemJuzDetail?>?){
        val adapter = DetailJuzAdapter()
        adapter.submitList(ayat)
        binding.rvAyat.adapter = adapter

    }

    companion object{
        val JUZ_ID = "juz_id"
    }
}