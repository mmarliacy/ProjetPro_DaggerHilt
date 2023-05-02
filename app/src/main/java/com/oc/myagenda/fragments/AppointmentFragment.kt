package com.oc.myagenda.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.oc.myagenda.R
import com.oc.myagenda.activities.AddAppointment
import com.oc.myagenda.adapters.AppointmentAdapter
import com.oc.myagenda.model.Appointment
import com.oc.myagenda.model.Customer
import com.oc.myagenda.model.Service

class AppointmentFragment : Fragment(R.layout.appointment_recycler_view) {

    private lateinit var  appointmentAdapter: AppointmentAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var addAppointmentBtn : FloatingActionButton
    var appointmentsList : ArrayList<Appointment> = arrayListOf(
        Appointment(
            Customer("Coralie Mercier", "0697873456", "25 Av. de month, 91230 Montgeron"),
            "12/05/2023", "13h00",
            arrayListOf(Service("Manucure", 30, 25),Service("Depose", 10, 10)),75),
        Appointment(
            Customer("Marc-Antoine Laventure", "0697873456", "25 Av. de laQuey, 91230 Montgeron"),
            "12/05/2023", "15h00",
            arrayListOf( Service("Soin visage", 30, 30), Service("Pedicure", 40, 30)),
            70),
        Appointment(
            Customer("Lorie Gua", "0697873456", "25 Av. de laQuey, 91230 Montgeron"),
                "13/05/2023", "9h00",
                arrayListOf(Service("Modelage", 60, 45)),45
    ))

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addAppointmentBtn = view.findViewById(R.id.app_fab)
        createList()
        val layoutManager : LayoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.appointment_recycler_view)
        recyclerView.layoutManager = layoutManager
        appointmentAdapter = AppointmentAdapter(appointmentsList)
        recyclerView.adapter = appointmentAdapter
        appointmentAdapter.notifyDataSetChanged()
        addAppointmentBtn.setOnClickListener{
            startActivity(Intent(context, AddAppointment::class.java))
        }
    }

    private fun createList(){
        appointmentsList = ArrayList()

    }
}