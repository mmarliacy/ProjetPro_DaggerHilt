package com.oc.myagenda.database.room.repository.requests

import com.oc.myagenda.database.entities.Service
import kotlinx.coroutines.flow.Flow

interface ServiceRepository {

    suspend fun insertServices(service: Service)

    suspend fun deleteServices(service: Service)

    fun getServices() : Flow<List<Service>>
}