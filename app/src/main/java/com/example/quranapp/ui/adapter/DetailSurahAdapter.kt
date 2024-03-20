package com.example.quranapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.quranapp.databinding.RvDetailSurahBinding
import com.example.quranapp.ui.data.response.DataItemDetailSurah

class DetailSurahAdapter :
    ListAdapter<DataItemDetailSurah, DetailSurahAdapter.MyViewHolder>(DIFF_CALLBACK) {

    class MyViewHolder(private val binding: RvDetailSurahBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(surah: DataItemDetailSurah) {
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
        val surah = getItem(position)
        holder.bind(surah)
    }


    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<DataItemDetailSurah>() {
            override fun areItemsTheSame(
                oldItem: DataItemDetailSurah,
                newItem: DataItemDetailSurah
            ): Boolean {
                return newItem == oldItem
            }

            override fun areContentsTheSame(
                oldItem: DataItemDetailSurah,
                newItem: DataItemDetailSurah
            ): Boolean {
                return newItem == oldItem
            }

        }
    }


}