package com.oc.myagenda.database.entities

import androidx.room.PrimaryKey

class Service (@PrimaryKey val id : Int? = null, val name : String, val duration : Int, val cost : Int){
}