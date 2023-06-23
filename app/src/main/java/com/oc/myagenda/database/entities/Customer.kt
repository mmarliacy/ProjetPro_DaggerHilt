package com.oc.myagenda.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Customer(
    @ColumnInfo(name = "customer_name")
    val name: String,
    @ColumnInfo(name = "customer_number")
    val number: String,
    @ColumnInfo(name = "customer_address")
    val address: String,
){
    @PrimaryKey(autoGenerate = true)
    val customerId : Int? = null
}