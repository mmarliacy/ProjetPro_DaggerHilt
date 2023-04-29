package com.oc.myagenda.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.oc.myagenda.R
import com.oc.myagenda.model.Client

class ClientAdapter(private var clientList:ArrayList<Client>): RecyclerView.Adapter<ClientAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.client_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val client : Client = clientList[position]
        holder.clientName.text = client.name
    }

    override fun getItemCount(): Int {
            return clientList.size
    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        var clientName : TextView = view.findViewById(R.id.client_name_item_field)
    }
}