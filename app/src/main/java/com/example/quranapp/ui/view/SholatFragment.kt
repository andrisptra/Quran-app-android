package com.example.quranapp.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.quranapp.R
import com.example.quranapp.databinding.FragmentSholatBinding
import com.example.quranapp.ui.adapter.KotaAdapter
import com.example.quranapp.ui.data.response.DataItemSemuaKota
import com.example.quranapp.ui.viewmodel.SholatViewModel

class SholatFragment : Fragment() {

    private var _binding: FragmentSholatBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SholatViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSholatBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val layoutManager = LinearLayoutManager(context)
        binding.rvKota.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(context, layoutManager.orientation)
        binding.rvKota.addItemDecoration(itemDecoration)

        viewModel.semuaKota.observe(viewLifecycleOwner){
            setSemuaKota(it)
        }

        viewModel.getSemuaKota()
        setupSearchBar()

        with(binding) {
            searchView.setupWithSearchBar(searchBar)
            searchView
                .editText
                .setOnEditorActionListener { _, _, _ ->
                    searchBar.textView.text = searchView.text
                    searchView.hide()
                    if (searchBar.text.isEmpty()){
                        viewModel.getSemuaKota()
                    } else{
                        viewModel.getCariKota(searchBar.text.toString())
                    }

                    false
                }
        }

        return root
    }

    private fun setSemuaKota(data: List<DataItemSemuaKota?>?){
        val adapter = KotaAdapter()
        adapter.submitList(data)
        binding.rvKota.adapter = adapter

        adapter.setOnItemClickCallback(object : KotaAdapter.OnItemClickCallback{
            override fun onItemClicked(data: DataItemSemuaKota) {
                val bundle = Bundle()
                bundle.putString(KOTAID,data.id)
                view?.findNavController()?.navigate(R.id.action_navigation_sholat_to_sholatDetailFragment,bundle)
            }

        })


    }
    private fun setupSearchBar() {
        var searchBarState = true
        binding.topAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.navigation_search -> {
                    if (searchBarState) {
                        searchBarState = false
                        binding.searchBar.visibility = View.VISIBLE

                    } else {
                        binding.searchBar.visibility = View.GONE
                        searchBarState = true
                    }

                    true
                }

                else -> false
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object{
        val KOTAID = "kotaId"
    }
}