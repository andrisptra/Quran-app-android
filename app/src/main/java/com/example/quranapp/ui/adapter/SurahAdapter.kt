package com.example.quranapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.quranapp.R
import com.example.quranapp.databinding.RvSurahBinding
import com.example.quranapp.ui.data.response.DataItem

class SurahAdapter : ListAdapter<DataItem, SurahAdapter.MyViewHolder>(DIFF_CALLBACK) {

    private lateinit var onItemClickCallback: OnItemClickCallback

    class MyViewHolder(private val binding: RvSurahBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(surah: DataItem) {
            binding.tvNomorAyat.text = surah.number
            binding.tvNamaSurah.text = surah.nameId
            binding.tvJumlahAyat.text =
                itemView.resources.getString(R.string.jumlah_ayat, surah.numberOfVerses)
            binding.tvJenisSurah.text = surah.revelationId
            binding.tvNamaSurahArab.text = surah.nameShort

        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: DataItem)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RvSurahBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val surah = getItem(position)
        holder.bind(surah)
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(surah)
        }
    }


    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<DataItem>() {
            override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
                return oldItem == newItem
            }
        }
    }


}