package com.example.androidwithkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.androidwithkotlin.databinding.FragmentBlankBinding
import com.example.androidwithkotlin.viewModel.BlankViewModel

class blank : Fragment() {

    private var _binding : FragmentBlankBinding? = null
    private val binding get() = _binding!!

    lateinit var viewModel: BlankViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater,R.layout.fragment_blank,container,false)

//        viewModel = ViewModelProvider(this).get(BlankViewModel::class.java)

//        viewModel.liveData.observe(this.viewLifecycleOwner) {
//            binding.tv.text = it
//        }

        binding.login.setOnClickListener {
            findNavController().navigate(R.id.action_blank_to_login)
        }

//        binding.input.addTextChangedListener{
//            viewModel.update(it.toString())
//        }

        return  binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}