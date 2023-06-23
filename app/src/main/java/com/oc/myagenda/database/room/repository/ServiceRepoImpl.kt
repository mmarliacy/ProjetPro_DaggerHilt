package com.oc.myagenda.database.room.repository

import com.oc.myagenda.database.entities.Service
import com.oc.myagenda.database.room.DAO.ServiceDao
import com.oc.myagenda.database.room.repository.requests.ServiceRepository
import kotlinx.coroutines.flow.Flow

class ServiceRepoImpl(private val serviceDao: ServiceDao) : ServiceRepository{

    override suspend fun insertServices(service: Service) {
        serviceDao.insertServices(service)
    }

    override suspend fun deleteServices(service: Service) {
        serviceDao.deleteServices(service)
    }

    override fun getServices(): Flow<List<Service>> {
        return serviceDao.getServices()
    }
}