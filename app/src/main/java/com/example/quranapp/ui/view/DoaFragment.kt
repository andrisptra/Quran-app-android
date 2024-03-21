package com.example.quranapp.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quranapp.databinding.FragmentDoaBinding
import com.example.quranapp.ui.adapter.DoaAdapter
import com.example.quranapp.ui.viewmodel.DoaViewModel

class DoaFragment : Fragment() {

    private var _binding: FragmentDoaBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: DoaViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(DoaViewModel::class.java)

        _binding = FragmentDoaBinding.inflate(inflater, container, false)
        val root: View = binding.root


        val layoutManager = LinearLayoutManager(requireActivity())
        binding.rvDoaSumber.layoutManager = layoutManager
        val dividerItemDecoration = DividerItemDecoration(context,layoutManager.orientation)
        binding.rvDoaSumber.addItemDecoration(dividerItemDecoration)

        viewModel.listSumberDoa.observe(viewLifecycleOwner) {
            setSumberDoa(it)
        }

        viewModel.getSumberDoa()





        return root
    }

    private fun setSumberDoa(data: List<String?>?) {
        val adapter = DoaAdapter(data)
        binding.rvDoaSumber.adapter = adapter


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}