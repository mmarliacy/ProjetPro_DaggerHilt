package com.oc.myagenda.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.oc.myagenda.R
import com.oc.myagenda.model.Appointment

class AppointmentAdapter(

    private var appointmentList: ArrayList<Appointment>)
    : RecyclerView.Adapter<AppointmentAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.appointment_item, parent, false)
        return ViewHolder(v)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val appointment = appointmentList[position]
        holder.clientName.text = appointment.client
        holder.totalPrice.text = "${appointment.totalPrice} €"
        holder.numbersOfServices.text = "${appointment.services.size} service(s) - "
        holder.date.text = appointment.date
        holder.hourService.text = appointment.hour
    }

    override fun getItemCount(): Int {
        return appointmentList.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var clientName : TextView
        var numbersOfServices : TextView
        var totalPrice : TextView
        var date : TextView
        var hourService : TextView

        init {
            clientName = view.findViewById(R.id.client_name_appoint_field)
            numbersOfServices = view.findViewById(R.id.numbers_of_services)
            totalPrice = view.findViewById(R.id.total_price_field)
            date = view.findViewById(R.id.date_field)
            hourService = view.findViewById(R.id.hour_field)
        }
    }
}