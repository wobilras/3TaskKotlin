package com.example.a3taskkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class FragmentMain : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnCamera = view.findViewById<Button>(R.id.btnCam)
        btnCamera.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentMain_to_fragmentCamera)
        }
        val btnList = view.findViewById<Button>(R.id.btnList)
        btnList.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentMain_to_fragmentList)
        }
    }
}