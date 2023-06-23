package com.oc.myagenda.database.room.repository.requests

import com.oc.myagenda.database.entities.ServiceSection
import kotlinx.coroutines.flow.Flow

interface SectionRepository {

    suspend fun insertSection(section: ServiceSection)

    suspend fun deleteSection(section: ServiceSection)

    fun getServicesSections() : Flow<List<ServiceSection>>
}