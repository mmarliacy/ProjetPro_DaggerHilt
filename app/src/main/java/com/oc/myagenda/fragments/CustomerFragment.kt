package com.oc.myagenda.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.oc.myagenda.R
import com.oc.myagenda.adapters.CustomerAdapter
import com.oc.myagenda.component.CustomerBottomSheet
import com.oc.myagenda.model.Customer

class CustomerFragment : Fragment(R.layout.client_recycler_view)  {


    private lateinit var recyclerView: RecyclerView
    private lateinit var addClient : FloatingActionButton
    var customerList : ArrayList<Customer> = arrayListOf(
        Customer("Coralie Mercier", "0697873456", "25 Av. de month, 91230 Montgeron"),
        Customer("Stephanie Plenozas", "0622569768", "36 Rue François, 95460 Cergy"),
        Customer("Patrick Boucher", "0697873456", "25 Av. de month, 91230 Montgeron"),
        Customer("Marc-Antoine Laventure", "0697873456", "25 Av. de laQuey, 91230 Montgeron"),
        Customer("Lorie Gua", "0697873456", "25 Av. de laQuey, 91230 Montgeron")
    )
    var  fCustomerAdapter: CustomerAdapter = CustomerAdapter(customerList)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.client_recycler_view)
        val manager : RecyclerView.LayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = manager
        fCustomerAdapter = CustomerAdapter(customerList)
        recyclerView.adapter = fCustomerAdapter
        recyclerView.setHasFixedSize(true)
        addClient(view)
    }

    private fun addClient(view : View){
        //--:: 1 -- Configure dialog ::-->
        val dialog = CustomerBottomSheet()
        //--:: 2 -- Add button reaction ::-->
        addClient = view.findViewById(R.id.client_fab)
        addClient.setOnClickListener{
            dialog.show(parentFragmentManager, CustomerBottomSheet.TAG)

        }
    }


}
