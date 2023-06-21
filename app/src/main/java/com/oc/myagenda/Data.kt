package com.oc.myagenda

import com.oc.myagenda.model.Appointment
import com.oc.myagenda.model.Customer
import com.oc.myagenda.model.Service
import com.oc.myagenda.model.ServiceSection

object Data {

    //-- APPOINTMENTS --
    val appointmentsList : ArrayList<Appointment> = arrayListOf(
    Appointment(1,
    Customer(1, "Coralie Mercier", "0697873456", "25 Av. de month, 91230 Montgeron"),
    "12/05/2023", "13h00",
    arrayListOf(Service(1, "Manucure", 30, 25),Service(4, "Depose", 10, 10)),75),
    Appointment(2,
    Customer(4, "Marc-Antoine Laventure", "0697873456", "25 Av. de laQuey, 91230 Montgeron"),
    "12/05/2023", "15h00",
    arrayListOf( Service(3, "Soin visage", 30, 30), Service(2, "Pedicure", 40, 30)),
    70),
    Appointment(3,
    Customer(5, "Lorie Gua", "0697873456", "25 Av. de laQuey, 91230 Montgeron"),
    "13/05/2023", "9h00",
    arrayListOf(Service(5, "Modelage", 60, 45)),45
    ))

    //-- CUSTOMERS --
    val customerList : ArrayList<Customer> = arrayListOf(
        Customer(1, "Coralie Mercier", "0697873456", "25 Av. de month, 91230 Montgeron"),
        Customer(2, "Stephanie Plenozas", "0622569768", "36 Rue François, 95460 Cergy"),
        Customer(3, "Patrick Boucher", "0697873456", "25 Av. de month, 91230 Montgeron"),
        Customer(4, "Marc-Antoine Laventure", "0697873456", "25 Av. de laQuey, 91230 Montgeron"),
        Customer(5, "Lorie Gua", "0697873456", "25 Av. de laQuey, 91230 Montgeron")
    )

    //-- SERVICES --
    val serviceList: ArrayList<Service> = arrayListOf(
    Service(1,"Manucure", 30, 25),
    Service(2,"Pedicure", 40, 30),
    Service(3,"Soin visage", 30, 30),
    Service(4,"Depose", 10, 10),
    Service(5,"Modelage", 60, 45),
    Service(6,"Soin éclatant", 30, 30),
    Service(7,"Séance madérothérapie", 60, 230)
    )

    //-- SERVICES SECTIONS --
    val sectionServiceList: ArrayList<ServiceSection> = arrayListOf(
        ServiceSection(1,"Soins mains", arrayListOf(Service(1, "Manucure", 30, 25), Service(4, "Depose", 10, 10))),
        ServiceSection(2,"Soins corps", arrayListOf(Service(5, "Modelage", 60, 45))),
        ServiceSection(3,"Soins visage", arrayListOf(Service(6,"Soin éclatant", 30, 30))),
        ServiceSection(4,"Soins pieds", arrayListOf(Service(2,"Pedicure", 40, 30))),
        ServiceSection(5,"Soins spécifiques", arrayListOf(Service(7,"Séance madérothérapie", 60, 230)))
    )


}