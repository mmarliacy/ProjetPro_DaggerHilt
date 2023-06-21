package com.oc.myagenda.mvvm.room.repository.interfaces

import com.oc.myagenda.model.Appointment
import kotlinx.coroutines.flow.Flow

interface AppointmentRepository {

    suspend fun insertAppointment(appointment: Appointment)

    suspend fun deleteAppointment(appointment: Appointment)

    fun getAppointments() : Flow<List<Appointment>>
}