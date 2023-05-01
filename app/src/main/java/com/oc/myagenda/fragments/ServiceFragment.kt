package com.oc.myagenda.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.oc.myagenda.R
import com.oc.myagenda.adapters.ServiceAdapter
import com.oc.myagenda.component.ServiceBottomSheet
import com.oc.myagenda.model.Service

class ServiceFragment : Fragment(R.layout.service_recycler_view) {

    private lateinit var serviceAdapter: ServiceAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var addNewService: FloatingActionButton

    var list: ArrayList<Service> = arrayListOf(
        Service("Manucure", 30, 25),
        Service("Pedicure", 40, 30),
        Service("Soin visage", 30, 30),
        Service("Depose", 10, 10),
        Service("Modelage", 60, 45)
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addNewService = view.findViewById(R.id.service_fab)
        recyclerView = view.findViewById(R.id.service_recycler_view)
        val manager = LinearLayoutManager(context)
        serviceAdapter = ServiceAdapter()
        serviceAdapter.serviceList = list
        recyclerView.apply {
            layoutManager = manager
            adapter = serviceAdapter
        }

        connectAddServiceBtn()

    }


    private fun connectAddServiceBtn() {
        addNewService.setOnClickListener {
            val serviceDialog = ServiceBottomSheet()
            serviceDialog.show(parentFragmentManager, ServiceBottomSheet.TAG)
        }
    }
}
