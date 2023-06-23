package com.oc.myagenda.ui.adapters.dropdownmenu

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.oc.myagenda.R
import com.oc.myagenda.database.entities.Service

class ServiceDropDownMenuAdapter(context: Context, private var serviceList: MutableList<Service>) :
    ArrayAdapter<Service>(context, 0, serviceList) {


    @SuppressLint("SetTextI18n")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
          val view : View = LayoutInflater.from(context).inflate(R.layout.services_dropdownmenu, parent, false)
        val service = serviceList[position]
        val ddmName : TextView = view.findViewById(R.id.service_name_ddm)
        val ddmDuration : TextView = view.findViewById(R.id.service_duration_ddm)
        val ddmPrice : TextView = view.findViewById(R.id.service_price_ddm)

        ddmName.text = service.name
        ddmDuration.text =  "${service.duration} minute(s)"
        ddmPrice.text = "${service.cost} €"
        return view
    }

    override fun getCount(): Int {
        return serviceList.size
    }
}