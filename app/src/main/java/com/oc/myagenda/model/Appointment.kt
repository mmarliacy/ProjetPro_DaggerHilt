package com.oc.myagenda.model

import androidx.room.PrimaryKey

class Appointment (
    @PrimaryKey var id : Int? = null,
    val client : Customer,
    val date : String,
    val hour : String,
    val services: ArrayList<Service>,
    val totalPrice : Int)