package com.oc.myagenda.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.chip.Chip
import com.oc.myagenda.R
import com.oc.myagenda.adapters.ServiceDropDownMenuAdapter
import com.oc.myagenda.databinding.AddAppointmentBinding
import com.oc.myagenda.fragments.ServiceFragment
import com.oc.myagenda.model.Service

class AddAppointment : AppCompatActivity() {

    private lateinit var binding : AddAppointmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AddAppointmentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        displayServiceList()

    }


    private fun displayServiceList(){
        val serviceList = ServiceFragment().list

        val arrayAdapter = ServiceDropDownMenuAdapter(this, serviceList)
        binding.servicesBookTxt.setAdapter(arrayAdapter)
        selectChip(serviceList)
    }

    @SuppressLint("InflateParams")
    fun selectChip(list : ArrayList<Service>){
        val chipGroup = binding.chipGroup


        val autoCompleteTextView = findViewById<AutoCompleteTextView>(binding.servicesBookTxt.id)
        autoCompleteTextView.setOnItemClickListener { _, _, i, _ // adapterView, view, position, l
        ->
            val service : Service = list[i]
            val tags : List<String> = if (service.name.contains(" ")){
                service.name.split(";")
            } else {
                service.name.split(" ")
            }


            for(text in tags){
                val chip : Chip =
                    LayoutInflater.from(this).inflate(R.layout.chip_service, null, true) as Chip
                    chip.text = text

                chip.setOnCloseIconClickListener {
                    chipGroup.removeView(chip)
                }
                chipGroup.addView(chip)

            }
            autoCompleteTextView.editableText.clear()
        }

    }



}