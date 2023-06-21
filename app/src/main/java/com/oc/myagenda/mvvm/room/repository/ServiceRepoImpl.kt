package com.oc.myagenda.mvvm.room.repository

import com.oc.myagenda.model.Service
import com.oc.myagenda.mvvm.room.database.DAO.ServiceDao
import com.oc.myagenda.mvvm.room.repository.interfaces.ServiceRepository
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