package com.oc.myagenda.mvvm.room.repository.interfaces

import com.oc.myagenda.model.Service
import kotlinx.coroutines.flow.Flow

interface ServiceRepository {

    suspend fun insertServices(service: Service)

    suspend fun deleteServices(service: Service)

    fun getServices() : Flow<List<Service>>
}