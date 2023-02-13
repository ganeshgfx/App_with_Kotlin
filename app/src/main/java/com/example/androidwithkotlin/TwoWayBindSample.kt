package com.example.androidwithkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.androidwithkotlin.databinding.FragmentTwoWayBindSampleBinding
import com.example.androidwithkotlin.viewModel.SettingData

class TwoWayBindSample : Fragment() {

    var _bind : FragmentTwoWayBindSampleBinding?=null
    val bind get() = _bind!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _bind = DataBindingUtil.inflate(inflater,R.layout.fragment_two_way_bind_sample,container,false)
        bind.data = ViewModelProvider(this).get(SettingData::class.java)
        bind.lifecycleOwner = this
        return bind.root
    }
}