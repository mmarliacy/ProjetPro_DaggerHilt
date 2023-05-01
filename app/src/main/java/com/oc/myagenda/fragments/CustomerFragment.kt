package com.oc.myagenda.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
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
    private var  list : ArrayList<Customer> = ArrayList()
    var  fCustomerAdapter: CustomerAdapter = CustomerAdapter(list)

    private lateinit var addBtn : Button
    private lateinit var cancelBtn : Button
    private lateinit var addClient : FloatingActionButton
    private lateinit var layout : ConstraintLayout


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initList()
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.client_recycler_view)
        val manager : RecyclerView.LayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = manager
        fCustomerAdapter = CustomerAdapter(list)
        recyclerView.adapter = fCustomerAdapter
        recyclerView.setHasFixedSize(true)
        addClient(view)
    }

    private fun addClient(view : View){
        //--:: 1 -- Configure dialog ::-->
        var dialog = CustomerBottomSheet()

        //--:: 2 -- Add button reaction ::-->
        addClient = view.findViewById(R.id.client_fab)
        addClient.setOnClickListener{
            dialog.show(parentFragmentManager, CustomerBottomSheet.TAG)

        }
    }

    private fun initList(){
        list = arrayListOf(
            Customer("Coralie Mercier", "0697873456", "25 Av. de laQuey, 91230 Montgeron"),
            Customer("Stephanie Plenozas", "0622569768", "36 Rue François, 95460 Cergy"),
            Customer("Patrick Boucher", "0697873456", "25 Av. de laQuey, 91230 Montgeron"),
            Customer("Marc-Antoine Laventure", "0697873456", "25 Av. de laQuey, 91230 Montgeron"),
            Customer("Lorie Gua", "0697873456", "25 Av. de laQuey, 91230 Montgeron"))
    }


}
