package com.oc.myagenda.database.room.repository

import com.oc.myagenda.database.entities.Appointment
import com.oc.myagenda.database.room.DAO.AppointmentDao
import com.oc.myagenda.database.room.repository.requests.AppointmentRepository
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