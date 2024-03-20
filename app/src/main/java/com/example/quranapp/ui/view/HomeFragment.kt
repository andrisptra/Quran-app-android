package com.example.quranapp.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.example.quranapp.R
import com.example.quranapp.databinding.FragmentHomeBinding
import com.example.quranapp.ui.adapter.HomeSectionPagerAdapter
import com.example.quranapp.ui.viewmodel.HomeViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupSearchBar()
        setupTab()

        with(binding) {
            searchView.setupWithSearchBar(searchBar)
            searchView
                .editText
                .setOnEditorActionListener { _, _, _ ->
                    searchBar.textView.text = searchView.text
                    searchView.hide()
                    false
                }
        }

        return root
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

    private fun setupTab() {
        val viewPagerBind = binding.viewPager
        val tabLayout = binding.tabLayout
        val tabLayoutAdapter = HomeSectionPagerAdapter(requireActivity())
        val viewPager: ViewPager2 = viewPagerBind
        viewPager.adapter = tabLayoutAdapter
        val tabs: TabLayout = tabLayout
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = resources.getString(tab_string[position])
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private val tab_string = intArrayOf(
            R.string.title_tab_1,
            R.string.title_tab_2,
            R.string.title_tab_3
        )
    }
}