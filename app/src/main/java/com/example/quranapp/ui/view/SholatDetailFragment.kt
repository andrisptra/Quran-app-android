package com.example.quranapp.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.quranapp.R
import com.example.quranapp.databinding.FragmentSholatDetailBinding
import com.example.quranapp.ui.data.response.Jadwal
import com.example.quranapp.ui.viewmodel.SholatDetailViewModel
import java.time.LocalDate
import java.util.Calendar
import kotlin.math.tan

class SholatDetailFragment : Fragment() {

    private var _binding: FragmentSholatDetailBinding? = null
    val binding get() = _binding!!

    private val viewModel: SholatDetailViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSholatDetailBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val kotaId = arguments?.getString(KOTAID).toString()
        val calendar = Calendar.getInstance()
        val tahun = calendar.get(Calendar.YEAR).toString()
        val bulan = (calendar.get(Calendar.MONTH)+ 1).toString()
        val tanggal = calendar.get(Calendar.DATE).toString()
        viewModel.dataSholat.observe(viewLifecycleOwner){
            if (it != null) {
                setJadwalSholat(it)
            }
        }

        viewModel.getJadwalSholat(kotaId,tahun,bulan, tanggal)

        return root
    }

    private fun setJadwalSholat(data: Jadwal){
        binding.waktuSubuh.text = data.subuh
        binding.waktuDzuhur.text = data.dzuhur
        binding.waktuAshar.text = data.ashar
        binding.waktuMagrib.text = data.maghrib
        binding.waktuIsya.text = data.isya

    }

    companion object{
        val KOTAID = "kotaId"
    }

}


