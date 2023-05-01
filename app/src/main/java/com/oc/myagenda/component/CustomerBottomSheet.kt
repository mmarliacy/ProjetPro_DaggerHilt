package com.oc.myagenda.component

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.textfield.TextInputEditText
import com.oc.myagenda.R
import com.oc.myagenda.fragments.CustomerFragment
import com.oc.myagenda.model.Customer

class CustomerBottomSheet : BottomSheetDialogFragment(R.layout.add_client_dialog) {

    private lateinit var addCustomerBtn: Button


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addCustomerBtn = view.findViewById(R.id.add_client_btn)

        addCustomerBtn.setOnClickListener {
            formFill(view)
        }
    }


    companion object {
        const val TAG = "CustomerBottomSheet"
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun formFill(view: View) {
        val name: TextInputEditText = view.findViewById(R.id.client_name_txt)
        val number: TextInputEditText = view.findViewById(R.id.client_number_txt)
        val address: TextInputEditText = view.findViewById(R.id.client_address_txt)


        val customerName = name.text.toString()
        val customerNumber = number.text.toString()
        val customerAddress = address.text.toString()

        val client = Customer(customerName, customerNumber, customerAddress)
        var list = ArrayList<Customer>()
        list.add(client)
        var clientAdapter = CustomerFragment().fCustomerAdapter
        clientAdapter.updateClientList()


    }


}