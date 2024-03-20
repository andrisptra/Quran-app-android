package com.example.quranapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.quranapp.databinding.RvDetailSurahBinding
import com.example.quranapp.ui.data.response.DataItemJuzDetail

class DetailJuzAdapter :
    ListAdapter<DataItemJuzDetail, DetailJuzAdapter.MyViewHolder>(DIFF_CALLBACK) {
    class MyViewHolder(private val binding: RvDetailSurahBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(surah: DataItemJuzDetail) {
            binding.tvNomorAyat.text = surah.ayah
            binding.tvAyatArab.text = surah.arab
            binding.terjemahan.text = surah.text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            RvDetailSurahBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val ayat = getItem(position)
        holder.bind(ayat)
    }


    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<DataItemJuzDetail>() {
            override fun areItemsTheSame(
                oldItem: DataItemJuzDetail,
                newItem: DataItemJuzDetail
            ): Boolean {
                return newItem == oldItem
            }

            override fun areContentsTheSame(
                oldItem: DataItemJuzDetail,
                newItem: DataItemJuzDetail
            ): Boolean {
                return newItem == oldItem
            }

        }
    }


}