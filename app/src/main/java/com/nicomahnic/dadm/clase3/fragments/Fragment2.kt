package com.nicomahnic.dadm.clase3.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nicomahnic.dadm.clase3.R
import com.nicomahnic.dadm.clase3.adapter.DevicesAdapter
import com.nicomahnic.dadm.clase3.entities.Device

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment2.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment2 : Fragment() {

//    private val args: Fragment2Args by navArgs()

    lateinit var v : View

    lateinit var rvDevices : RecyclerView
    private lateinit var linearLayoutManager: LinearLayoutManager

    var devices : MutableList<Device> = ArrayList<Device>()
    private lateinit var devicesAdapter: DevicesAdapter

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_2, container, false)
        rvDevices = v.findViewById(R.id.rv_devices)

        return v
    }

    override fun onStart() {
        super.onStart()

        devices.add(Device("Pedro"))
        devices.add(Device("Rodolfo"))
        devices.add(Device("Emilio"))


        rvDevices.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(context)
        rvDevices.layoutManager = linearLayoutManager

        devicesAdapter = DevicesAdapter(devices)

        rvDevices.adapter = devicesAdapter

    }

}