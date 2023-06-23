package com.oc.myagenda.ui.adapters.dropdownmenu

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.oc.myagenda.R
import com.oc.myagenda.database.entities.Customer

class CustomerDropDownMenuAdapter(context: Context, private var customerList: MutableList<Customer>) :
    ArrayAdapter<Customer>(context, 0, customerList) {


    @SuppressLint("SetTextI18n", "ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view : View = LayoutInflater.from(context).inflate(R.layout.client_item, parent, false)
        val customer = customerList[position]
        val customerName : TextView = view.findViewById(R.id.client_name_item_field)
        customerName.text = customer.name
        return view
    }

    override fun getCount(): Int {
        return customerList.size
    }
}