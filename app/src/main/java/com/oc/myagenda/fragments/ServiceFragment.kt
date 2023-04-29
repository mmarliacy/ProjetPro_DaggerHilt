package com.oc.myagenda.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oc.myagenda.R
import com.oc.myagenda.adapters.ServiceAdapter
import com.oc.myagenda.model.Service

class ServiceFragment : Fragment(R.layout.service_recycler_view) {

    private lateinit var  serviceAdapter: ServiceAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var list : ArrayList<Service>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createList()
        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.service_recycler_view)
        recyclerView.layoutManager = layoutManager
        serviceAdapter = ServiceAdapter(list)
        recyclerView.adapter = serviceAdapter

    }

    private fun createList() {
        list = ArrayList()
        list.add(Service("Manucure", 30, 25))
        list.add(Service("Pedicure", 40, 30))
        list.add(Service("Soin visage", 30, 30))
        list.add(Service("Depose", 10, 10))
        list.add(Service("Modelage", 60, 45))
    }
}
