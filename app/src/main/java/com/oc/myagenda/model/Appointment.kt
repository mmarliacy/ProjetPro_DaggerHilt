package com.oc.myagenda.model

class Appointment (
    var client : Customer,
    var date : String,
    var hour : String,
    var services: ArrayList<Service>,
    var totalPrice : Int) {
}