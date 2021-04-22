package com.nicomahnic.dadm.clase3.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.nicomahnic.dadm.clase3.R
import com.nicomahnic.dadm.clase3.activities.SecondActivity

class DeviceDetailsFragment : Fragment(R.layout.fragment_device_details) {

    private lateinit var v: View
    private lateinit var txtServiceTitle: TextView
    private lateinit var txtDescription: TextView
    private lateinit var imgService: ImageView
    private val args: DeviceDetailsFragmentArgs by navArgs()

    override fun onViewCreated (view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        v = view

        val serviceName = args.deviceName
        val description = args.description

        txtServiceTitle = v.findViewById(R.id.txt_service_title)
        txtDescription = v.findViewById(R.id.txt_description)
        imgService = v.findViewById(R.id.img_service)

        txtServiceTitle.text = serviceName
        txtDescription.text = description

        Log.d("NM","HOLA ${SecondActivity.User.name} $serviceName ,$description")
    }

}