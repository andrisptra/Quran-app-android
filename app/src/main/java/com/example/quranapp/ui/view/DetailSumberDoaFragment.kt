package com.example.quranapp.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quranapp.databinding.FragmentDetailSumberDoaBinding
import com.example.quranapp.ui.adapter.ListDoaAdapter
import com.example.quranapp.ui.data.response.DataItemDoa
import com.example.quranapp.ui.viewmodel.DetailSumberDoaViewModel

class DetailSumberDoaFragment : Fragment() {
    private var _binding: FragmentDetailSumberDoaBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val viewModel:DetailSumberDoaViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailSumberDoaBinding.inflate(inflater, container, false)


        val layoutManager = LinearLayoutManager(requireActivity())
        binding.rvListDoa.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(context,layoutManager.orientation)
        binding.rvListDoa.addItemDecoration(itemDecoration)

        viewModel.listDoa.observe(viewLifecycleOwner){
            setListDoa(it)
        }

        val sumber = arguments?.getString(SUMBER).toString()
        viewModel.getListDoa(sumber)


        return binding.root
    }

    private fun setListDoa(data: List<DataItemDoa?>?){
        val adapter = ListDoaAdapter()
        adapter.submitList(data)
        binding.rvListDoa.adapter = adapter
    }


    companion object{
        val SUMBER = "sumber"
    }

}