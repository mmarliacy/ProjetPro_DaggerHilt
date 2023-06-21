package com.oc.myagenda.mvvm.room.repository

import com.oc.myagenda.model.Appointment
import com.oc.myagenda.mvvm.room.database.DAO.AppointmentDao
import com.oc.myagenda.mvvm.room.repository.interfaces.AppointmentRepository
import kotlinx.coroutines.flow.Flow

class AppointmentRepoImpl(private val appointmentDao: AppointmentDao) : AppointmentRepository {

    override suspend fun insertAppointment(appointment: Appointment) {
        appointmentDao.insertAppointment(appointment)
    }

    override suspend fun deleteAppointment(appointment: Appointment) {
        appointmentDao.deleteAppointment(appointment)
    }

    override fun getAppointments(): Flow<List<Appointment>> {
        return appointmentDao.getAppointments()
    }
}