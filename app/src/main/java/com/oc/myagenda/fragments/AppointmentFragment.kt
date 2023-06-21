package com.oc.myagenda.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.oc.myagenda.Data
import com.oc.myagenda.R
import com.oc.myagenda.activities.AddAppointment
import com.oc.myagenda.adapters.AppointmentAdapter

class AppointmentFragment : Fragment(R.layout.appointment_recycler_view) {

    private lateinit var appointmentAdapter: AppointmentAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var addAppointmentBtn : FloatingActionButton


    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addAppointmentBtn = view.findViewById(R.id.app_fab)
        val layoutManager: LayoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.appointment_recycler_view)
        recyclerView.layoutManager = layoutManager
        appointmentAdapter = AppointmentAdapter(Data.appointmentsList)
        recyclerView.adapter = appointmentAdapter
        appointmentAdapter.notifyDataSetChanged()
        addAppointmentBtn.setOnClickListener {
            startActivity(Intent(context, AddAppointment::class.java))
            Log.i("Data", "")
        }
    }

}