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

//    private val args: Fragment2Args by navArgs()

    lateinit var v: View

    lateinit var rvDevices: RecyclerView
    private lateinit var linearLayoutManager: LinearLayoutManager

    var devices: List<Device> = listOf(Device("Dormitorio"), Device("Cocina"), Device("Lavadero"))
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

        devicesAdapter = DevicesAdapter(devices) { x ->
            Log.d("NM", x.toString())
            val action =
                RVDevicesFragmentDirections.actionRvDevicesFragmentToDeviceDetailsFragment2()
//                val action = LoginDirections.actionFragment1ToSecondActivity(validUser!!.name)
            v.findNavController().navigate(action)
        }

        rvDevices.adapter = devicesAdapter

    }

}