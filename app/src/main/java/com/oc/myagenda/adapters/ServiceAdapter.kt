package com.oc.myagenda.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.oc.myagenda.R
import com.oc.myagenda.model.Service

class ServiceAdapter: RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder>(){

    var serviceList : ArrayList<Service> = ArrayList()
    set(value){
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.service_item, parent, false)
        return ServiceViewHolder(v)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        val service = serviceList[position]
        holder.name.text = service.name
        holder.duration.text = "${service.duration} minute(s)"
        holder.cost.text = "${service.cost} € "
    }

    override fun getItemCount(): Int {
        return serviceList.size
    }

    inner class ServiceViewHolder(view : View) : RecyclerView.ViewHolder(view){

        val name : TextView = view.findViewById(R.id.service_name_field)
        val duration : TextView = view.findViewById(R.id.service_duration_item_service)
        val cost : TextView = view.findViewById(R.id.service_price_item_service)

        init {
            name
            duration
            cost
        }
    }
}
