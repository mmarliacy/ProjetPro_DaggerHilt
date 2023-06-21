package com.oc.myagenda.model

import androidx.room.PrimaryKey

class ServiceSection(@PrimaryKey val id : Int? = null, val section : String, val serviceList : ArrayList<Service>)