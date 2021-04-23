package com.nicomahnic.dadm.clase3.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nicomahnic.dadm.clase3.R
import com.nicomahnic.dadm.clase3.activities.SecondActivity
import com.nicomahnic.dadm.clase3.adapter.DevicesAdapter
import com.nicomahnic.dadm.clase3.entities.Device

/**
 * A simple [Fragment] subclass.
 * Use the [RVDevicesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RVDevicesFragment : Fragment(R.layout.fragment_rv_devices) {

    private lateinit var v: View

    private lateinit var rvDevices: RecyclerView
    private lateinit var linearLayoutManager: LinearLayoutManager

    var devices: List<Device> = listOf(
        Device("Dormitorio","Hay una cama"),
        Device("Cocina","Cocina2"),
        Device("Lavadero","Lavarropas")
    )
    
    private lateinit var devicesAdapter: DevicesAdapter

    override fun onViewCreated (view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        v = view
        rvDevices = v.findViewById(R.id.rv_devices)

        Log.d("NM", "Singleton ${SecondActivity.User.name}")
    }

    override fun onStart() {
        super.onStart()

        rvDevices.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(context)
        rvDevices.layoutManager = linearLayoutManager

        devicesAdapter = DevicesAdapter(devices) { pos ->
            Log.d("NM", pos.toString())
            val action =
                RVDevicesFragmentDirections.
                actionRvDevicesFragmentToDeviceDetailsFragment2(
                    deviceName = devices[pos].name,
                    description = devices[pos].description
                )

            v.findNavController().navigate(action)
        }
        rvDevices.adapter = devicesAdapter
    }
}