package com.example.quranapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quranapp.R

class DoaAdapter(private val sumberDoa: List<String?>?) :
    RecyclerView.Adapter<DoaAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val sumber: TextView = itemView.findViewById(R.id.tv_sumber_doa)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.rv_sumber_doa, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return sumberDoa?.size ?: 0
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val sumberDoa = sumberDoa?.get(position)
        holder.sumber.text = sumberDoa
    }

}