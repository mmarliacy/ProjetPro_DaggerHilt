package com.oc.myagenda.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.oc.myagenda.R
import com.oc.myagenda.model.Customer

class CustomerAdapter: RecyclerView.Adapter<CustomerAdapter.ViewHolder>() {

    var pCustomerList = ArrayList<Customer>()
        @SuppressLint("NotifyDataSetChanged")
        set(value){
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.client_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val customer : Customer = pCustomerList[position]
        holder.clientName.text = customer.name

    }

    override fun getItemCount(): Int {
            return pCustomerList.size
    }


    fun updateClientList (){
        notifyDataSetChanged()
    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        var clientName : TextView = view.findViewById(R.id.client_name_item_field)
    }
}