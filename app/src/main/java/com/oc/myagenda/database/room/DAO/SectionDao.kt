package com.oc.myagenda.database.room.DAO

import androidx.room.*
import com.oc.myagenda.database.entities.ServiceSection
import kotlinx.coroutines.flow.Flow

@Dao
interface SectionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSection(section: ServiceSection)

    @Delete
    suspend fun deleteSection(section: ServiceSection)

    @Query("SELECT * FROM section_table")
    fun getServicesSections() : Flow<List<ServiceSection>>
}