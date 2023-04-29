package com.oc.myagenda.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.oc.myagenda.R
import com.oc.myagenda.adapters.AppointmentAdapter
import com.oc.myagenda.model.Appointment

class AppointmentFragment : Fragment(R.layout.appointment_recycler_view) {

    private lateinit var  appointmentAdapter: AppointmentAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var list : ArrayList<Appointment>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createList()
        val layoutManager : LayoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.appointment_recycler_view)
        recyclerView.layoutManager = layoutManager
        appointmentAdapter = AppointmentAdapter(list)
        recyclerView.adapter = appointmentAdapter

    }

    private fun createList(){
        list = ArrayList()
        list.add(Appointment("Lorie Gua", "12/05/2023", "13h00", arrayListOf("Manucure", "Pedicure"),45))
        list.add(Appointment("Stephanie Plenozas", "12/05/2023", "15h00", arrayListOf("Manucure", "Pedicure", "Visage"),70))
        list.add(Appointment("Patrick Boucher", "13/05/2023", "9h00", arrayListOf("Manucure"),45))
    }
}