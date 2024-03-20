package com.example.quranapp.ui.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quranapp.databinding.FragmentSurahBinding
import com.example.quranapp.ui.adapter.SurahAdapter
import com.example.quranapp.ui.data.response.DataItem
import com.example.quranapp.ui.viewmodel.SurahViewModel

class Surahragment : Fragment() {

    private var _binding: FragmentSurahBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SurahViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSurahBinding.inflate(inflater, container, false)
        val root: View = binding.root

        viewModel.listSurah.observe(requireActivity()) {
            setListSurah(it)
        }
        viewModel.showLoading.observe(requireActivity()) {
            showLoading(it)
        }
        viewModel.message.observe(requireActivity()) {
            showMessage(it)
        }

        val layoutManager = LinearLayoutManager(requireActivity())
        binding.rvSurah.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(requireActivity(), layoutManager.orientation)
        binding.rvSurah.addItemDecoration(itemDecoration)

        viewModel.getAllSurah()





        return root
    }

    private fun setListSurah(data: List<DataItem?>?) {
        val adapter = SurahAdapter()
        adapter.submitList(data)
        binding.rvSurah.adapter = adapter

        adapter.setOnItemClickCallback(object : SurahAdapter.OnItemClickCallback{
            override fun onItemClicked(data: DataItem) {
                val intent = Intent(requireActivity(), DetailSurahActivity::class.java)
                intent.putExtra(DetailSurahActivity.SURAH_NAME, data.nameId)
                intent.putExtra(DetailSurahActivity.SURAH_ID, data.number)
                intent.putExtra(DetailSurahActivity.AYAT_END, data.numberOfVerses)
                startActivity(intent)
            }

        })
    }

    private fun showLoading(isLoading: Boolean) {
        val progressBar = binding.progressBar
        val rv = binding.rvSurah
        if (isLoading) {
            progressBar.visibility = View.VISIBLE
            rv.visibility = View.GONE
        } else {
            progressBar.visibility = View.GONE
            rv.visibility = View.VISIBLE
        }
    }

    private fun showMessage(message: String) {
        if (message.isNotEmpty()) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        const val ARG_SECTION_NUMBER = "section_number"
    }
}