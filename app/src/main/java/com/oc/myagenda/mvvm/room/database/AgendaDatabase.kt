package com.oc.myagenda.mvvm.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.oc.myagenda.model.Appointment
import com.oc.myagenda.model.Customer
import com.oc.myagenda.model.Service
import com.oc.myagenda.model.ServiceSection
import com.oc.myagenda.mvvm.room.database.DAO.AppointmentDao
import com.oc.myagenda.mvvm.room.database.DAO.CustomerDao
import com.oc.myagenda.mvvm.room.database.DAO.SectionDao
import com.oc.myagenda.mvvm.room.database.DAO.ServiceDao

@Database(entities = [Appointment::class, Customer::class, Service::class, ServiceSection::class], version = 1,  )
abstract class AgendaDatabase : RoomDatabase(){

    abstract val appointmentDao : AppointmentDao
    abstract val customerDao : CustomerDao
    abstract val serviceDao : ServiceDao
    abstract val sectionDao : SectionDao
}