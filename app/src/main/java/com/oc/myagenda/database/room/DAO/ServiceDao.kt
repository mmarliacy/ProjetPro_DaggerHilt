package com.oc.myagenda.database.room.DAO

import androidx.room.*
import com.oc.myagenda.database.entities.Service
import kotlinx.coroutines.flow.Flow

@Dao
interface ServiceDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertServices(service: Service)

    @Delete
    suspend fun deleteServices(service: Service)

    @Query("SELECT * FROM service_table")
    fun getServices() : Flow<List<Service>>
}