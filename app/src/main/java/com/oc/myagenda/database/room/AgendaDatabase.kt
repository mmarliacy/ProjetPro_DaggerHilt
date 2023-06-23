package com.oc.myagenda.database.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.oc.myagenda.database.entities.Appointment
import com.oc.myagenda.database.entities.Customer
import com.oc.myagenda.database.entities.Service
import com.oc.myagenda.database.entities.ServiceSection
import com.oc.myagenda.database.room.DAO.AppointmentDao
import com.oc.myagenda.database.room.DAO.CustomerDao
import com.oc.myagenda.database.room.DAO.SectionDao
import com.oc.myagenda.database.room.DAO.ServiceDao

@Database(entities = [Appointment::class, Customer::class, Service::class, ServiceSection::class], version = 1,  )
abstract class AgendaDatabase : RoomDatabase(){

    abstract val appointmentDao : AppointmentDao
    abstract val customerDao : CustomerDao
    abstract val serviceDao : ServiceDao
    abstract val sectionDao : SectionDao
}