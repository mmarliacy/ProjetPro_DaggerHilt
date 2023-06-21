package com.oc.myagenda.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Customer(
    @PrimaryKey val id : Int? = null,
    val name: String,
    val number: String,
    val address: String
)