package com.example.quranapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.quranapp.databinding.RvDoaListBinding
import com.example.quranapp.ui.data.response.DataItemDoa

class ListDoaAdapter : ListAdapter<DataItemDoa, ListDoaAdapter.MyViewHolder>(DIFF_CALLBACK) {
    class MyViewHolder(private val binding: RvDoaListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(listDoa: DataItemDoa){
            binding.judul.text = listDoa.judul
            binding.doaContentArab.text = listDoa.arab
            binding.doaContentIndo.text = listDoa.indo
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding= RvDoaListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val doa = getItem(position)
        holder.bind(doa)
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<DataItemDoa>() {
            override fun areItemsTheSame(oldItem: DataItemDoa, newItem: DataItemDoa): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: DataItemDoa, newItem: DataItemDoa): Boolean {
                return oldItem == newItem
            }
        }
    }


}