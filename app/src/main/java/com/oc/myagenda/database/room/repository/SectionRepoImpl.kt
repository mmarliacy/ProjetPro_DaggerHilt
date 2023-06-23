package com.oc.myagenda.database.room.repository

import com.oc.myagenda.database.entities.ServiceSection
import com.oc.myagenda.database.room.DAO.SectionDao
import com.oc.myagenda.database.room.repository.requests.SectionRepository
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