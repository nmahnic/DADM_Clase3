package com.nicomahnic.dadm.clase3.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.nicomahnic.dadm.clase3.R

class DeviceDetailsFragment : Fragment() {

    lateinit var v: View
    val args: DeviceDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_device_details, container, false)

        val name = args.deviceName
        val description = args.description

        Log.d("NM","HOLA $name ,$description")
        return v
    }

}