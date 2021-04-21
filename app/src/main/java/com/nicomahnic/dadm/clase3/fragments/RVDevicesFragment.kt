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
import com.nicomahnic.dadm.clase3.adapter.DevicesAdapter
import com.nicomahnic.dadm.clase3.entities.Device

/**
 * A simple [Fragment] subclass.
 * Use the [RVDevicesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RVDevicesFragment : Fragment() {

    lateinit var v: View

    lateinit var rvDevices: RecyclerView
    private lateinit var linearLayoutManager: LinearLayoutManager

    var devices: List<Device> = listOf(Device("Dormitorio","Hay una cama"), Device("Cocina","Cocina2"), Device("Lavadero","Lavarropas"))
    private lateinit var devicesAdapter: DevicesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_rv_devices, container, false)
        rvDevices = v.findViewById(R.id.rv_devices)

        return v
    }

    override fun onStart() {
        super.onStart()

        rvDevices.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(context)
        rvDevices.layoutManager = linearLayoutManager

        devicesAdapter = DevicesAdapter(devices) { pos ->
            Log.d("NM", pos.toString())
            val action =
                RVDevicesFragmentDirections.actionRvDevicesFragmentToDeviceDetailsFragment2(
                    deviceName = devices[pos].name,
                    description = devices[pos].description
                )

            v.findNavController().navigate(action)
        }

        rvDevices.adapter = devicesAdapter

    }

}