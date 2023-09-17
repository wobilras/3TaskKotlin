package com.example.a3taskkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.a3taskkotlin.databinding.FragmentMainBinding

class FragmentMain : Fragment() {
    lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCam.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentMain_to_fragmentCamera)
        }
        binding.btnList.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentMain_to_fragmentList)
        }
    }
}