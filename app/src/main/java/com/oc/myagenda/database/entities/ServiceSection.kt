package com.oc.myagenda.database.entities

import androidx.room.PrimaryKey

class ServiceSection(@PrimaryKey val id : Int? = null, val section : String, val serviceList : ArrayList<Service>)