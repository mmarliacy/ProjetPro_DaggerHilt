package com.oc.myagenda.ui.component

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar
import com.oc.myagenda.R
import com.oc.myagenda.ui.fragments.CustomerFragment
import com.oc.myagenda.database.entities.Customer
import com.oc.myagenda.databinding.AddClientDialogBinding

class CustomerBottomSheet (var addCustomerListener: AddCustomerListener) : BottomSheetDialogFragment(R.layout.add_client_dialog) {

    private lateinit var addCustomerBtn: Button
    private var binding : AddClientDialogBinding? = null
    private val _binding get() = binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = AddClientDialogBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addCustomerBtn = _binding.addClientBtn

        addCustomerBtn.setOnClickListener {
            addCustomer()
        }
    }


    companion object {
        const val TAG = "CustomerBottomSheet"
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun addCustomer() {
        val customerName = _binding.clientNameTxt.text.toString()
        val customerNumber = _binding.clientNumberTxt.text.toString()
        val customerAddress = _binding.clientAddressTxt.text.toString()

            if(customerName.isEmpty()|| customerNumber.isEmpty() || customerAddress.isEmpty() ){
                setSnackBar("Information(s) missing")
                //Toast.makeText(requireActivity(), "Information(s) missing", Toast.LENGTH_LONG).show()
            } else {
                val customer = Customer(customerName, customerNumber, customerAddress)
                addCustomerListener.addCustomer(customer)
                setSnackBar("$customerName has been added")
            }

        //
        var list = ArrayList<Customer>()
        //list.add(client)
        val clientAdapter = CustomerFragment().fCustomerAdapter
        clientAdapter.updateClientList()


    }

    private fun setSnackBar(message: String) {
        val snackBar = Snackbar.make(requireContext(), _binding.root, message, Snackbar.LENGTH_LONG).setAction("Ok", null)
        snackBar.setActionTextColor(Color.WHITE)
        val snackBarView = snackBar.view
        snackBarView.setBackgroundColor(Color.BLACK)
        snackBar.show()
    }


}

interface AddCustomerListener {

    fun addCustomer(customer: Customer)

}
