package com.example.androidwithkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.androidwithkotlin.databinding.FragmentBlankLayoutBinding
import com.example.androidwithkotlin.viewModel.BlankViewDataModel

class blank : Fragment() {

    private var _binding : FragmentBlankLayoutBinding? = null
    private val binding get() = _binding!!

    lateinit var viewModel: BlankViewDataModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = DataBindingUtil.inflate(inflater,R.layout.fragment_blank_layout,container,false)

        viewModel = ViewModelProvider(this).get(BlankViewDataModel::class.java)

//        viewModel.liveData.observe(this.viewLifecycleOwner) {
//            binding.tv.text = it
//        }

        binding.lifecycleOwner = this

        binding.login.setOnClickListener {
            findNavController().navigate(R.id.action_blank_to_login)
        }


        binding.data = viewModel

        return  binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}