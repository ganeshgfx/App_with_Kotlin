package com.example.androidwithkotlin

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.androidwithkotlin.data.HomeData
import com.example.androidwithkotlin.databinding.FragmentHomeBinding

class Home : Fragment() {

    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var dataBinding:FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        _binding = FragmentHomeBinding.inflate(inflater,container,false)

        val homeData = HomeData("We are at Home Page...")

        binding.homedata = homeData

        binding.logout.setOnClickListener {
            findNavController().navigate(R.id.action_home2_to_login)
        }

        binding.input.addTextChangedListener {
            binding.tv.setText(it.toString())
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}