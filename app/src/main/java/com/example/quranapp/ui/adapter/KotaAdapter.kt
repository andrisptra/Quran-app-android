package com.example.quranapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.quranapp.databinding.RvSumberDoaBinding
import com.example.quranapp.ui.data.response.DataItemSemuaKota

class KotaAdapter : ListAdapter<DataItemSemuaKota, KotaAdapter.MyViewHolder>(DIFF_CALLBACK) {
    private lateinit var onItemClickCallback: OnItemClickCallback

    class MyViewHolder(private val binding: RvSumberDoaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DataItemSemuaKota) {
            binding.tvSumberDoa.text = data.lokasi
        }

    }

    interface OnItemClickCallback {
        fun onItemClicked(data: DataItemSemuaKota)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RvSumberDoaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = getItem(position)
        holder.bind(data)
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(data)
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<DataItemSemuaKota>() {
            override fun areItemsTheSame(
                oldItem: DataItemSemuaKota,
                newItem: DataItemSemuaKota
            ): Boolean {
                return newItem == oldItem
            }

            override fun areContentsTheSame(
                oldItem: DataItemSemuaKota,
                newItem: DataItemSemuaKota
            ): Boolean {
                return newItem == oldItem
            }

        }
    }

}