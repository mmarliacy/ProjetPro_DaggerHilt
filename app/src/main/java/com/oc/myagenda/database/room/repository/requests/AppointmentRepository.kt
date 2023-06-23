package com.oc.myagenda.database.room.repository.requests

import com.oc.myagenda.database.entities.Appointment
import kotlinx.coroutines.flow.Flow

interface AppointmentRepository {

    suspend fun insertAppointment(appointment: Appointment)

    suspend fun deleteAppointment(appointment: Appointment)

    fun getAppointments() : Flow<List<Appointment>>
}