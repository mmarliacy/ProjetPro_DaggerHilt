package com.oc.myagenda.mvvm.room.repository.interfaces

import com.oc.myagenda.model.ServiceSection
import kotlinx.coroutines.flow.Flow

interface SectionRepository {

    suspend fun insertSection(section: ServiceSection)

    suspend fun deleteSection(section: ServiceSection)

    fun getServicesSections() : Flow<List<ServiceSection>>
}