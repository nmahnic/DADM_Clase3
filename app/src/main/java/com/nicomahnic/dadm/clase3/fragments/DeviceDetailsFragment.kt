package com.nicomahnic.dadm.clase3.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.nicomahnic.dadm.clase3.R
import com.nicomahnic.dadm.clase3.activities.SecondActivity

class DeviceDetailsFragment : Fragment(R.layout.fragment_device_details) {

    lateinit var v: View
    val args: DeviceDetailsFragmentArgs by navArgs()

    override fun onViewCreated (view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        v = view

        val serviceName = args.deviceName
        val description = args.description

        Log.d("NM","HOLA ${SecondActivity.User.name} $serviceName ,$description")
    }

}