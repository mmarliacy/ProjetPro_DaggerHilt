package com.oc.myagenda.mvvm.room.repository

import com.oc.myagenda.model.ServiceSection
import com.oc.myagenda.mvvm.room.database.DAO.SectionDao
import com.oc.myagenda.mvvm.room.repository.interfaces.SectionRepository
import kotlinx.coroutines.flow.Flow

class SectionRepoImpl(private val sectionDao: SectionDao) : SectionRepository {

    override suspend fun insertSection(section: ServiceSection) {
        sectionDao.insertSection(section)
    }

    override suspend fun deleteSection(section: ServiceSection) {
        sectionDao.deleteSection(section)
    }

    override fun getServicesSections(): Flow<List<ServiceSection>> {
        return sectionDao.getServicesSections()
    }
}