package com.oc.myagenda.database.room.DAO

import androidx.room.*
import com.oc.myagenda.database.entities.Appointment
import kotlinx.coroutines.flow.Flow

@Dao
interface AppointmentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAppointment(appointment: Appointment)

    @Delete
    suspend fun deleteAppointment(appointment: Appointment)

    @Query("SELECT * FROM appointment_table")
    fun getAppointments() : Flow<List<Appointment>>

}