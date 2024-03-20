package com.example.quranapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.quranapp.databinding.RvJuzBinding
import com.example.quranapp.ui.data.response.DataItemJuz

class JuzAdapter : ListAdapter<DataItemJuz, JuzAdapter.MyViewHolder>(DIFF_CALLBACK) {
    private lateinit var onItemClickCallback: OnItemClickCallback

    class MyViewHolder(private val binding: RvJuzBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(surah: DataItemJuz) {
            binding.tvNamaJuz.text = surah.name
            binding.tvNomorSurah.text = surah.number
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: DataItemJuz)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RvJuzBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val juz = getItem(position)
        holder.bind(juz)
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(juz)
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<DataItemJuz>() {
            override fun areItemsTheSame(oldItem: DataItemJuz, newItem: DataItemJuz): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: DataItemJuz, newItem: DataItemJuz): Boolean {
                return oldItem == newItem
            }
        }
    }
}