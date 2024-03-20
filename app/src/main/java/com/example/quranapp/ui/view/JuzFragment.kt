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
import com.example.quranapp.databinding.FragmentJuzBinding
import com.example.quranapp.ui.adapter.JuzAdapter
import com.example.quranapp.ui.data.response.DataItemJuz
import com.example.quranapp.ui.viewmodel.JuzViewModel


class JuzFragment : Fragment() {

    private var _binding: FragmentJuzBinding? = null
    private val binding get() = _binding!!

    private val viewModel: JuzViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentJuzBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val layoutManager = LinearLayoutManager(requireActivity())
        binding.rvJuz.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(requireActivity(), layoutManager.orientation)
        binding.rvJuz.addItemDecoration(itemDecoration)

        viewModel.listJuz.observe(viewLifecycleOwner) {
            setListJuz(it)
        }
        viewModel.showLoading.observe(viewLifecycleOwner) {
            showLoading(it)
        }
        viewModel.message.observe(viewLifecycleOwner) {
            showMessage(it)
        }


        viewModel.getALlJuz()
        return root
    }

    private fun setListJuz(data: List<DataItemJuz?>?) {
        val adapter = JuzAdapter()
        adapter.submitList(data)
        binding.rvJuz.adapter = adapter

        adapter.setOnItemClickCallback(object : JuzAdapter.OnItemClickCallback{
            override fun onItemClicked(data: DataItemJuz) {
                val intent = Intent(requireActivity(),DetailJuzActivity::class.java)
                intent.putExtra(DetailJuzActivity.JUZ_ID, data.number)
                startActivity(intent)
            }

        })
    }

    private fun showLoading(isLoading: Boolean) {
        val progressBar = binding.progressBar
        val rv = binding.rvJuz
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


}