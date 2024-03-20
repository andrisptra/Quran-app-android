package com.example.quranapp.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.quranapp.ui.view.JuzFragment
import com.example.quranapp.ui.view.Surahragment

class HomeSectionPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = Surahragment()
            1 -> fragment = JuzFragment()
            2 -> fragment = Surahragment()
        }
        return fragment as Fragment
    }


}