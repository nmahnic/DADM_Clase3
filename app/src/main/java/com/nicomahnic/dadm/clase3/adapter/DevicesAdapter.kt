package com.nicomahnic.dadm.clase3.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.nicomahnic.dadm.clase3.R
import com.nicomahnic.dadm.clase3.entities.Device

class DevicesAdapter(
    private var devicesList: MutableList<Device>
) : RecyclerView.Adapter<DevicesAdapter.DeviceHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeviceHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_device,parent,false)
        return (DeviceHolder(view))
    }

    override fun getItemCount(): Int {

        return devicesList.size
    }

    override fun onBindViewHolder(holder: DeviceHolder, position: Int) {

        holder.setName(devicesList[position].name)

        holder.getButton().setOnClickListener {
            holder.setName("Mash")
        }
    }


    class DeviceHolder (v: View) : RecyclerView.ViewHolder(v) {

        private var view: View

        init {
            this.view = v
        }

        fun setName(name: String) {
            val txt: TextView = view.findViewById(R.id.txt_name_item)
            txt.text = name
        }

        fun getButton (): Button {
            return view.findViewById(R.id.btn_item)
        }
    }
}