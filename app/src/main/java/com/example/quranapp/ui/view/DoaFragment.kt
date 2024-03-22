package com.example.quranapp.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quranapp.R
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
        val dividerItemDecoration = DividerItemDecoration(context, layoutManager.orientation)
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

        adapter.setOnItemClickCallback(object : DoaAdapter.OnItemClickCallback {
            override fun onItemClicked(data: String) {
                val bundle = Bundle()
                bundle.putString(SUMBER,data)
                view?.findNavController()?.navigate(R.id.action_navigation_doa_to_detailSumberDoaFragment,bundle)
//                val detailDoaFragment = DetailSumberDoaFragment()
//                val bundle = Bundle()
//                bundle.putString(DetailSumberDoaFragment.SUMBER, data)
//                detailDoaFragment.arguments = bundle
//                val fragmentManager = parentFragmentManager
//                fragmentManager.beginTransaction().apply {
//                    replace(
//                        R.id.doa_fragment,
//                        detailDoaFragment,
//                        DetailSumberDoaFragment::class.java.simpleName
//                    )
//                    addToBackStack(null)
//                    commit()
//                }
                Toast.makeText(context, data, Toast.LENGTH_SHORT).show()
            }

        })


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object{
        val SUMBER = "sumber"
    }
}